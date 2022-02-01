package com.tencent.mm.plugin.music.g.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.d;
import com.tencent.mm.plugin.music.cache.d.a;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.cache.h;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements IMediaHTTPConnection
{
  private boolean mAllowCrossDomainRedirect;
  private boolean mAllowCrossProtocolRedirect;
  private HttpURLConnection mConnection;
  private long mCurrentOffset;
  private Map<String, String> mHeaders;
  private InputStream mInputStream;
  private String mMimeType;
  private long mTotalSize;
  private URL mURL;
  private com.tencent.mm.plugin.music.cache.a vhe;
  public URL vhf;
  private byte[] vhg;
  private final Map<String, String> vhh;
  
  public a(Map<String, String> paramMap)
  {
    AppMethodBeat.i(191312);
    this.mCurrentOffset = -1L;
    this.mURL = null;
    this.vhf = null;
    this.mHeaders = null;
    this.mConnection = null;
    this.mTotalSize = -1L;
    this.mMimeType = "";
    this.mInputStream = null;
    this.mAllowCrossDomainRedirect = true;
    this.mAllowCrossProtocolRedirect = true;
    this.vhg = new byte[1];
    this.vhh = paramMap;
    AppMethodBeat.o(191312);
  }
  
  private static final boolean isLocalHost(URL paramURL)
  {
    AppMethodBeat.i(137431);
    if (paramURL == null)
    {
      AppMethodBeat.o(137431);
      return false;
    }
    paramURL = paramURL.getHost();
    if (paramURL == null)
    {
      AppMethodBeat.o(137431);
      return false;
    }
    try
    {
      boolean bool = paramURL.equalsIgnoreCase("localhost");
      if (bool)
      {
        AppMethodBeat.o(137431);
        return true;
      }
    }
    catch (IllegalArgumentException paramURL)
    {
      Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "isLocalHost IllegalArgumentException:%s", new Object[] { String.valueOf(paramURL) });
      AppMethodBeat.o(137431);
    }
    return false;
  }
  
  private void seekTo(long paramLong)
  {
    AppMethodBeat.i(137432);
    teardownConnection();
    j = 0;
    i = j;
    try
    {
      localObject1 = this.mURL;
      i = j;
      bool1 = isLocalHost((URL)localObject1);
      k = 0;
      j = 0;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Object localObject1;
        boolean bool1;
        int k;
        int m;
        continue;
        j = m;
      }
    }
    if (bool1) {}
    for (;;)
    {
      try
      {
        this.mConnection = ((HttpURLConnection)((URL)localObject1).openConnection(Proxy.NO_PROXY));
        this.mConnection.setConnectTimeout(30000);
        this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
        m = 0;
        i = 0;
        Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "mHeaders=" + this.mHeaders);
        if (this.mHeaders == null) {
          continue;
        }
        localObject1 = this.mHeaders.entrySet().iterator();
      }
      catch (IOException localIOException1)
      {
        Map.Entry localEntry;
        i = j;
        this.mTotalSize = -1L;
        if (this.mInputStream == null) {
          continue;
        }
        try
        {
          this.mInputStream.close();
          this.mInputStream = null;
          this.mConnection = null;
          this.mCurrentOffset = -1L;
          Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "seekTo exception:%s", new Object[] { localIOException1 + ", response:" + i });
          AppMethodBeat.o(137432);
          throw localIOException1;
          if (paramLong > 0L) {
            this.mConnection.setRequestProperty("Range", "bytes=" + paramLong + "-");
          }
          if (m == 0) {
            this.mConnection.setRequestProperty("Accept-Encoding", "");
          }
          m = this.mConnection.getResponseCode();
          g.ee(this.vhf.toString(), m);
          if ((m == 300) || (m == 301) || (m == 302) || (m == 303) || (m == 307))
          {
            k += 1;
            if (k > 20)
            {
              i = m;
              localObject2 = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(k)));
              i = m;
              AppMethodBeat.o(137432);
              i = m;
              throw ((Throwable)localObject2);
            }
            i = m;
            localObject2 = this.mConnection.getRequestMethod();
            if (m == 307)
            {
              i = m;
              if (!((String)localObject2).equals("GET"))
              {
                i = m;
                if (!((String)localObject2).equals("HEAD"))
                {
                  i = m;
                  localObject2 = new NoRouteToHostException("Invalid redirect");
                  i = m;
                  AppMethodBeat.o(137432);
                  i = m;
                  throw ((Throwable)localObject2);
                }
              }
            }
            i = m;
            localObject2 = this.mConnection.getHeaderField("Location");
            if (localObject2 == null)
            {
              i = m;
              localObject2 = new NoRouteToHostException("Invalid redirect");
              i = m;
              AppMethodBeat.o(137432);
              i = m;
              throw ((Throwable)localObject2);
            }
            i = m;
            localObject2 = new URL(this.mURL, (String)localObject2);
            i = m;
            if (!((URL)localObject2).getProtocol().equals("https"))
            {
              i = m;
              if (!((URL)localObject2).getProtocol().equals("http"))
              {
                i = m;
                localObject2 = new NoRouteToHostException("Unsupported protocol redirect");
                i = m;
                AppMethodBeat.o(137432);
                i = m;
                throw ((Throwable)localObject2);
              }
            }
            i = m;
            boolean bool2 = this.mURL.getProtocol().equals(((URL)localObject2).getProtocol());
            i = m;
            if ((!this.mAllowCrossProtocolRedirect) && (!bool2))
            {
              i = m;
              localObject2 = new NoRouteToHostException("Cross-protocol redirects are disallowed");
              i = m;
              AppMethodBeat.o(137432);
              i = m;
              throw ((Throwable)localObject2);
            }
            i = m;
            bool2 = this.mURL.getHost().equals(((URL)localObject2).getHost());
            i = m;
            if ((!this.mAllowCrossDomainRedirect) && (!bool2))
            {
              i = m;
              localObject2 = new NoRouteToHostException("Cross-domain redirects are disallowed");
              i = m;
              AppMethodBeat.o(137432);
              i = m;
              throw ((Throwable)localObject2);
            }
            if (m == 307) {
              break label1139;
            }
            i = m;
            this.mURL = ((URL)localObject2);
            break label1139;
          }
          i = m;
          if (this.mAllowCrossDomainRedirect)
          {
            i = m;
            this.mURL = this.mConnection.getURL();
          }
          if (m == 206)
          {
            i = m;
            localObject2 = this.mConnection.getHeaderField("Content-Range");
            i = m;
            this.mTotalSize = -1L;
            if (localObject2 != null)
            {
              i = m;
              j = ((String)localObject2).lastIndexOf('/');
              if (j >= 0)
              {
                i = m;
                localObject2 = ((String)localObject2).substring(j + 1);
                i = m;
              }
            }
          }
        }
        catch (IOException localIOException3)
        {
          try
          {
            Object localObject2;
            this.mTotalSize = bs.getLong((String)localObject2, 0L);
            i = m;
            if (TextUtils.isEmpty(this.mMimeType))
            {
              i = m;
              this.mMimeType = this.mConnection.getContentType();
              i = m;
              ac.i("MicroMsg.Music.MMMediaHTTPConnection", "mimeType:", new Object[] { this.mMimeType });
            }
            if ((paramLong > 0L) && (m != 206))
            {
              i = m;
              localObject2 = new ProtocolException();
              i = m;
              AppMethodBeat.o(137432);
              i = m;
              throw ((Throwable)localObject2);
              if (m != 200)
              {
                i = m;
                localObject2 = new IOException();
                i = m;
                AppMethodBeat.o(137432);
                i = m;
                throw ((Throwable)localObject2);
              }
              i = m;
              this.mTotalSize = this.mConnection.getContentLength();
              continue;
            }
            i = m;
            this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
            i = m;
            this.mCurrentOffset = paramLong;
            AppMethodBeat.o(137432);
            return;
            localIOException3 = localIOException3;
            ac.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", localIOException3, "teardownConnection", new Object[0]);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            continue;
          }
        }
        continue;
      }
      m = i;
      if (!((Iterator)localObject1).hasNext()) {
        continue;
      }
      localEntry = (Map.Entry)((Iterator)localObject1).next();
      this.mConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      if ((i != 0) || (!"Accept-Encoding".equals(localEntry.getKey()))) {
        continue;
      }
      i = 1;
      continue;
      this.mConnection = ((HttpURLConnection)((URL)localObject1).openConnection());
    }
  }
  
  private void teardownConnection()
  {
    AppMethodBeat.i(137430);
    if (this.mInputStream != null) {}
    try
    {
      this.mInputStream.close();
      this.mInputStream = null;
      if (this.mConnection == null) {}
    }
    catch (IOException localIOException)
    {
      try
      {
        this.mConnection.getInputStream().close();
        this.mConnection.disconnect();
        this.mConnection = null;
        this.mCurrentOffset = -1L;
        AppMethodBeat.o(137430);
        return;
        localIOException = localIOException;
        ac.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", localIOException, "teardownConnection", new Object[0]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.Music.MMMediaHTTPConnection", localException.getMessage());
        }
      }
    }
  }
  
  public final boolean connect(URL paramURL, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137428);
    Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect");
    Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect: uri=" + paramURL + ", headers=" + paramMap);
    disconnect();
    this.mAllowCrossDomainRedirect = true;
    this.mURL = paramURL;
    this.vhf = paramURL;
    this.mHeaders = paramMap;
    this.mTotalSize = -1L;
    this.mMimeType = "";
    if (ai.ciE())
    {
      paramURL = this.mURL.toString();
      if (!com.tencent.mm.plugin.music.cache.e.dip()) {
        break label680;
      }
      paramURL = ((c)b.aQ(c.class)).anh(paramURL);
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramURL)) && (!paramURL.equalsIgnoreCase(this.mURL.toString()))) {
        ac.i("MicroMsg.Music.MMMediaHTTPConnection", "use temp shake music url to play:%s", new Object[] { paramURL });
      }
      try
      {
        this.mURL = new URL(paramURL);
        if (this.mURL != null)
        {
          g.z(this.mURL.toString(), paramMap);
          paramURL = this.vhf.toString();
          Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "connect, originUrlStr: ".concat(String.valueOf(paramURL)));
          localObject1 = (String)this.vhh.get(paramURL);
          paramURL = paramMap;
          if (!"invalidReferrer".equals(localObject1))
          {
            if (paramMap != null) {
              paramMap.remove("referer");
            }
            paramURL = paramMap;
            if (!bs.isNullOrNil((String)localObject1))
            {
              Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect, add referrer: ".concat(String.valueOf(localObject1)));
              paramURL = paramMap;
              if (paramMap == null)
              {
                paramURL = new HashMap();
                this.mHeaders = paramURL;
              }
            }
          }
        }
      }
      catch (MalformedURLException paramURL)
      {
        try
        {
          paramURL.put("Referer", localObject1);
          Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "headers=".concat(String.valueOf(paramURL)));
          this.vhe = new com.tencent.mm.plugin.music.cache.a(this);
          paramURL = this.vhe;
          paramMap = paramURL.vdS.vhf.toString();
          paramURL.vdT = new d(paramMap);
          paramURL.vdT.ixc = paramURL.vdS.getSize();
          localObject1 = paramURL.vdT;
          ac.i("MicroMsg.Music.IndexBitMgr", "initData");
          long l;
          if (((d)localObject1).ixc <= 0L)
          {
            ac.e("MicroMsg.Music.IndexBitMgr", "fileLength is invalid!");
            paramURL.vdU = new h(paramMap);
            if (new com.tencent.mm.vfs.e(paramURL.vdU.fileName).exists()) {
              break label1299;
            }
            ac.i("MicroMsg.Music.FileBytesCacheMgr", "piece file not exist, clear cache!");
            paramURL.vdT.clearCache();
            l = paramURL.vdS.getSize();
            localObject1 = paramURL.vdU;
            Logger.i("MicroMsg.Music.PieceFileCache", "open");
          }
          try
          {
            localObject2 = new com.tencent.mm.vfs.e(((h)localObject1).fileName);
            if (!((com.tencent.mm.vfs.e)localObject2).exists()) {
              ac.i("MicroMsg.Music.PieceFileCache", "create file:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.e)localObject2).createNewFile()) });
            }
            ((h)localObject1).randomAccessFile = com.tencent.mm.vfs.i.cY(q.B(((com.tencent.mm.vfs.e)localObject2).mUri), true);
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[] { ((h)localObject1).fileName });
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            for (;;)
            {
              Object localObject2;
              Logger.e("MicroMsg.Music.PieceFileCache", "file not found", localFileNotFoundException);
              Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[] { ((h)localObject1).fileName });
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              Logger.e("MicroMsg.Music.PieceFileCache", "io ", localIOException);
              Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[] { ((h)localObject1).fileName });
            }
          }
          finally
          {
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[] { ((h)localObject1).fileName });
            AppMethodBeat.o(137428);
          }
          paramURL.vdU.setLength(l);
          g.aY(paramMap, l);
          ac.i("MicroMsg.Music.FileBytesCacheMgr", "attach() fileLength is " + l + ",pieceFileCache length is " + paramURL.vdU.getLength());
          localObject1 = paramURL.vdS.getMIMEType();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"application/octet-stream".equalsIgnoreCase((String)localObject1))) {
            g.hW(paramMap, (String)localObject1);
          }
          paramURL.MW = -1;
          paramURL.mSize = 0;
          paramURL.vdV = -1;
          paramURL.vdW = 0;
          AppMethodBeat.o(137428);
          return true;
          label680:
          ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
          paramURL = null;
          continue;
          paramURL = paramURL;
          ac.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", paramURL, "playUrl", new Object[0]);
        }
        catch (Exception paramMap)
        {
          for (;;)
          {
            Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect, put referrer fail since " + paramMap.toString());
            paramURL = new HashMap(paramURL);
            paramURL.put("Referer", localObject1);
            continue;
            if ((((d)localObject1).ixc % 8192L == 0L) || (((d)localObject1).ixc < 8192L)) {}
            for (((d)localObject1).count = ((int)(((d)localObject1).ixc / 8192L));; ((d)localObject1).count = ((int)(((d)localObject1).ixc / 8192L) + 1))
            {
              if (((d)localObject1).ixc <= 8192L)
              {
                ac.i("MicroMsg.Music.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
                ((d)localObject1).count = 1;
              }
              ac.i("MicroMsg.Music.IndexBitMgr", "fileLength:%d, count:%d", new Object[] { Long.valueOf(((d)localObject1).ixc), Integer.valueOf(((d)localObject1).count) });
              ((d)localObject1).vdZ = new BitSet(((d)localObject1).count);
              ((d)localObject1).dnX = g.anp(((d)localObject1).mUrl);
              if (!TextUtils.isEmpty(((d)localObject1).dnX)) {
                break label937;
              }
              ac.e("MicroMsg.Music.IndexBitMgr", "initData musicId is null!'");
              break;
            }
            label937:
            ac.i("MicroMsg.Music.IndexBitMgr", "musicId:%s", new Object[] { ((d)localObject1).dnX });
            localObject2 = com.tencent.mm.plugin.music.cache.e.ani(((d)localObject1).dnX);
            if (localObject2 == null)
            {
              ac.e("MicroMsg.Music.IndexBitMgr", "initData pMusic is null!'");
            }
            else
            {
              ac.i("MicroMsg.Music.IndexBitMgr", "initData music field_fileCacheComplete:%d", new Object[] { Integer.valueOf(((com.tencent.mm.ay.i)localObject2).hOv) });
              if ((((com.tencent.mm.ay.i)localObject2).hOu == null) || (((com.tencent.mm.ay.i)localObject2).hOu.length == 0))
              {
                ac.e("MicroMsg.Music.IndexBitMgr", "initData field_indexBitData is null!'");
              }
              else
              {
                ((d)localObject1).vdZ = d.a.br(((com.tencent.mm.ay.i)localObject2).hOu);
                if (((d)localObject1).vdZ == null)
                {
                  ac.e("MicroMsg.Music.IndexBitMgr", "initData bitSet is null");
                  ((d)localObject1).vdZ = new BitSet(((d)localObject1).count);
                }
                label1224:
                do
                {
                  for (;;)
                  {
                    ac.i("MicroMsg.Music.IndexBitMgr", "initData bitSet:" + ((d)localObject1).vdZ.toString());
                    ac.i("MicroMsg.Music.IndexBitMgr", "initData bitSet count %d, cardinality:" + ((d)localObject1).count + "," + ((d)localObject1).vdZ.cardinality());
                    break;
                    if (((d)localObject1).count >= ((d)localObject1).vdZ.cardinality()) {
                      break label1224;
                    }
                    ac.e("MicroMsg.Music.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", new Object[] { Integer.valueOf(((d)localObject1).count), Integer.valueOf(((d)localObject1).vdZ.cardinality()) });
                    ((d)localObject1).clearCache();
                  }
                } while (((com.tencent.mm.ay.i)localObject2).hOx == 1);
                ac.i("MicroMsg.Music.IndexBitMgr", "remove dirty bit set from db, reset cache complete to 0");
                if (((d)localObject1).count > 1)
                {
                  ((d)localObject1).JD(((d)localObject1).count - 1);
                  ((d)localObject1).JD(((d)localObject1).count - 2);
                }
                for (;;)
                {
                  ((d)localObject1).JA(0);
                  break;
                  ((d)localObject1).JD(((d)localObject1).count - 1);
                }
                label1299:
                if ((paramURL.vdU.diq() != paramURL.vdS.getSize()) && (paramURL.vdS.getSize() != -1L))
                {
                  ac.i("MicroMsg.Music.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
                  paramURL.vdT.clearCache();
                  localObject1 = paramURL.vdU;
                  Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile");
                  h.anu(((h)localObject1).fileName);
                }
                else if (paramURL.vdS.getSize() == -1L)
                {
                  ac.i("MicroMsg.Music.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
                }
                else
                {
                  ac.i("MicroMsg.Music.FileBytesCacheMgr", "piece file exist!");
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(137429);
    Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "disconnect");
    teardownConnection();
    this.mHeaders = null;
    this.mURL = null;
    if (this.vhe != null)
    {
      com.tencent.mm.plugin.music.cache.a locala = this.vhe;
      locala.dig();
      locala.vdT.din();
      locala.vdU.close();
      locala.vdS = null;
      ac.i("MicroMsg.Music.FileBytesCacheMgr", "detach()");
      this.vhe = null;
    }
    AppMethodBeat.o(137429);
  }
  
  public final String getMIMEType()
  {
    AppMethodBeat.i(137435);
    if (!TextUtils.isEmpty(this.mMimeType))
    {
      Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType mimeType:" + this.mMimeType);
      str1 = this.mMimeType;
      AppMethodBeat.o(137435);
      return str1;
    }
    String str1 = g.ans(this.vhf.toString());
    if (!TextUtils.isEmpty(str1))
    {
      this.mMimeType = str1;
      AppMethodBeat.o(137435);
      return str1;
    }
    if (this.mConnection == null) {}
    for (;;)
    {
      try
      {
        l = System.currentTimeMillis();
        seekTo(0L);
        str1 = this.mConnection.getContentType();
        ac.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        this.mMimeType = str1;
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        AppMethodBeat.o(137435);
        return str1;
      }
      catch (IOException localIOException)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType exception:%s", new Object[] { String.valueOf(localIOException) });
        str2 = "";
        continue;
      }
      long l = System.currentTimeMillis();
      str2 = this.mConnection.getContentType();
      Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType mimeType:".concat(String.valueOf(str2)));
      ac.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time2 :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    String str2 = g.anr(this.vhf.toString());
    this.mMimeType = str2;
    if (!TextUtils.isEmpty(str2))
    {
      AppMethodBeat.o(137435);
      return str2;
    }
    AppMethodBeat.o(137435);
    return "application/octet-stream";
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(137434);
    long l;
    if (this.mTotalSize > 0L)
    {
      l = this.mTotalSize;
      AppMethodBeat.o(137434);
      return l;
    }
    if (g.ant(this.vhf.toString()) > 0L)
    {
      this.mTotalSize = g.ant(this.vhf.toString());
      l = this.mTotalSize;
      AppMethodBeat.o(137434);
      return l;
    }
    if (this.mConnection == null) {}
    try
    {
      l = System.currentTimeMillis();
      seekTo(0L);
      ac.d("MicroMsg.Music.MMMediaHTTPConnection", "getSize cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if (this.mTotalSize > 0L)
      {
        l = this.mTotalSize;
        AppMethodBeat.o(137434);
        return l;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "getSize exception:%s", new Object[] { String.valueOf(localIOException) });
        this.mTotalSize = -1L;
      }
      if (g.fD(this.vhf.toString()) > 0L)
      {
        this.mTotalSize = g.fD(this.vhf.toString());
        l = this.mTotalSize;
        AppMethodBeat.o(137434);
        return l;
      }
      AppMethodBeat.o(137434);
    }
    return -1L;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(137436);
    String str = this.mURL.toString();
    AppMethodBeat.o(137436);
    return str;
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137433);
    if (paramInt2 > this.vhg.length) {
      this.vhg = new byte[paramInt2];
    }
    Arrays.fill(this.vhg, 0, this.vhg.length, (byte)0);
    label1114:
    label1259:
    for (;;)
    {
      Object localObject;
      int j;
      int i;
      try
      {
        if (this.vhe == null) {
          continue;
        }
        localObject = this.vhe;
        arrayOfByte = this.vhg;
        j = (int)paramLong;
        if ((arrayOfByte != null) && (j >= 0) && (paramInt2 >= 0)) {
          continue;
        }
        ac.e("MicroMsg.Music.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2) });
      }
      catch (ProtocolException paramArrayOfByte)
      {
        byte[] arrayOfByte;
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.ef(this.vhf.toString(), 750);
        AppMethodBeat.o(137433);
        return -1010;
        i = j + paramInt2;
        l = i;
        if (l <= ((com.tencent.mm.plugin.music.cache.a)localObject).vdS.getSize()) {
          break label1259;
        }
        ac.e("MicroMsg.Music.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(((com.tencent.mm.plugin.music.cache.a)localObject).vdS.getSize()) });
        i = (int)((com.tencent.mm.plugin.music.cache.a)localObject).vdS.getSize() - j;
        if (!((com.tencent.mm.plugin.music.cache.a)localObject).vdT.gq(j, i)) {
          break label1266;
        }
        i = ((com.tencent.mm.plugin.music.cache.a)localObject).vdU.read(arrayOfByte, j, i);
        continue;
        if ((this.mTotalSize <= 0L) || (paramLong < this.mTotalSize) || (paramInt2 <= 0)) {
          continue;
        }
        ac.e("MicroMsg.Music.MMMediaHTTPConnection", "offset is illegal, mTotalSize:%d, offset:%d, size:%d", new Object[] { Long.valueOf(this.mTotalSize), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(137433);
        return 0;
        Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "read from network");
        if (paramLong == this.mCurrentOffset) {
          continue;
        }
        seekTo(paramLong);
        i = this.mInputStream.read(this.vhg, 0, paramInt2);
        if (i != -1) {
          continue;
        }
        paramInt1 = 0;
        this.mCurrentOffset += paramInt1;
        if (this.vhe == null) {
          continue;
        }
        paramArrayOfByte = this.vhe;
        localObject = this.vhg;
        m = (int)paramLong;
        if ((localObject != null) && (m >= 0) && (paramInt1 >= 0)) {
          continue;
        }
        ac.e("MicroMsg.Music.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(137433);
        return paramInt1;
        System.arraycopy(this.vhg, 0, paramArrayOfByte, paramInt1, i);
        paramInt1 = i;
        continue;
      }
      catch (NoRouteToHostException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.ef(this.vhf.toString(), 751);
        AppMethodBeat.o(137433);
        return -1010;
        if (paramArrayOfByte.vdS.getSize() > 0L) {
          continue;
        }
        ac.e("MicroMsg.Music.FileBytesCacheMgr", "write() fileLength is error, file length is " + paramArrayOfByte.vdS.getSize());
        continue;
      }
      catch (UnknownServiceException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.ef(this.vhf.toString(), 752);
        AppMethodBeat.o(137433);
        return -1010;
        i = m + paramInt1;
        long l = i;
        if (l <= paramArrayOfByte.vdS.getSize()) {
          continue;
        }
        ac.e("MicroMsg.Music.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramArrayOfByte.vdS.getSize()) });
        continue;
      }
      catch (IOException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => -1 " + paramArrayOfByte);
        g.ef(this.vhf.toString(), 753);
        AppMethodBeat.o(137433);
        return -1;
        if ((!paramArrayOfByte.Jx(m)) || (!paramArrayOfByte.Jx(i))) {
          break label1138;
        }
        if ((paramArrayOfByte.Jy(m)) && (paramArrayOfByte.Jy(i))) {
          continue;
        }
        if (!paramArrayOfByte.Jy(m)) {
          break label1114;
        }
        paramArrayOfByte.x((byte[])localObject, m, paramInt1);
        if (paramArrayOfByte.mSize != 81920) {
          continue;
        }
        paramArrayOfByte.dig();
        paramArrayOfByte.Jz(i);
        if (i != paramArrayOfByte.vdS.getSize()) {
          continue;
        }
        paramArrayOfByte.dig();
        paramArrayOfByte.Jz(i);
        continue;
      }
      catch (Exception paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "unknown exception ".concat(String.valueOf(paramArrayOfByte)));
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => -1");
        g.ef(this.vhf.toString(), 754);
        AppMethodBeat.o(137433);
        return -1;
      }
      if (i > 0)
      {
        if (i != paramInt2) {
          Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "read from cache, n%d, size %d " + i + "," + paramInt2);
        }
        System.arraycopy(this.vhg, 0, paramArrayOfByte, paramInt1, i);
        AppMethodBeat.o(137433);
        return i;
        if (((com.tencent.mm.plugin.music.cache.a)localObject).vdS.getSize() <= 0L)
        {
          ac.e("MicroMsg.Music.FileBytesCacheMgr", "read(), fileLength is error, file length is " + ((com.tencent.mm.plugin.music.cache.a)localObject).vdS.getSize());
          break label1266;
        }
      }
      int m;
      paramArrayOfByte.dig();
      paramArrayOfByte.Jz(m);
      paramArrayOfByte.x((byte[])localObject, m, paramInt1);
      continue;
      label1138:
      if ((paramArrayOfByte.Jx(m)) && (!paramArrayOfByte.Jx(i)) && (paramArrayOfByte.Jy(m)))
      {
        j = 81920 - paramArrayOfByte.mSize;
        int k = paramInt1 - j;
        if (j > 0) {
          paramArrayOfByte.x((byte[])localObject, m, j);
        }
        paramArrayOfByte.dig();
        m += j;
        paramArrayOfByte.Jz(m);
        if (k > 0) {
          paramArrayOfByte.g((byte[])localObject, j, m, k);
        }
      }
      else
      {
        paramArrayOfByte.dig();
        paramArrayOfByte.Jz(m);
        paramArrayOfByte.x((byte[])localObject, m, paramInt1);
        continue;
        i = paramInt2;
        continue;
        label1266:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a.a
 * JD-Core Version:    0.7.0.1
 */