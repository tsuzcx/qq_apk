package com.tencent.mm.plugin.music.g.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.d;
import com.tencent.mm.plugin.music.cache.d.a;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.cache.h;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
  private com.tencent.mm.plugin.music.cache.a tYs;
  public URL tYt;
  private byte[] tYu;
  private final Map<String, String> tYv;
  
  public a(Map<String, String> paramMap)
  {
    AppMethodBeat.i(193679);
    this.mCurrentOffset = -1L;
    this.mURL = null;
    this.tYt = null;
    this.mHeaders = null;
    this.mConnection = null;
    this.mTotalSize = -1L;
    this.mMimeType = "";
    this.mInputStream = null;
    this.mAllowCrossDomainRedirect = true;
    this.mAllowCrossProtocolRedirect = true;
    this.tYu = new byte[1];
    this.tYv = paramMap;
    AppMethodBeat.o(193679);
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
          g.dX(this.tYt.toString(), m);
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
            this.mTotalSize = bt.getLong((String)localObject2, 0L);
            i = m;
            if (TextUtils.isEmpty(this.mMimeType))
            {
              i = m;
              this.mMimeType = this.mConnection.getContentType();
              i = m;
              ad.i("MicroMsg.Music.MMMediaHTTPConnection", "mimeType:", new Object[] { this.mMimeType });
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
            ad.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", localIOException3, "teardownConnection", new Object[0]);
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
        ad.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", localIOException, "teardownConnection", new Object[0]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.Music.MMMediaHTTPConnection", localException.getMessage());
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
    this.tYt = paramURL;
    this.mHeaders = paramMap;
    this.mTotalSize = -1L;
    this.mMimeType = "";
    if (aj.cbv())
    {
      paramURL = this.mURL.toString();
      if (!com.tencent.mm.plugin.music.cache.e.cUJ()) {
        break label680;
      }
      paramURL = ((c)b.aP(c.class)).aim(paramURL);
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramURL)) && (!paramURL.equalsIgnoreCase(this.mURL.toString()))) {
        ad.i("MicroMsg.Music.MMMediaHTTPConnection", "use temp shake music url to play:%s", new Object[] { paramURL });
      }
      try
      {
        this.mURL = new URL(paramURL);
        if (this.mURL != null)
        {
          g.y(this.mURL.toString(), paramMap);
          paramURL = this.tYt.toString();
          Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "connect, originUrlStr: ".concat(String.valueOf(paramURL)));
          localObject1 = (String)this.tYv.get(paramURL);
          paramURL = paramMap;
          if (!"invalidReferrer".equals(localObject1))
          {
            if (paramMap != null) {
              paramMap.remove("referer");
            }
            paramURL = paramMap;
            if (!bt.isNullOrNil((String)localObject1))
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
          this.tYs = new com.tencent.mm.plugin.music.cache.a(this);
          paramURL = this.tYs;
          paramMap = paramURL.tVk.tYt.toString();
          paramURL.tVl = new d(paramMap);
          paramURL.tVl.hWY = paramURL.tVk.getSize();
          localObject1 = paramURL.tVl;
          ad.i("MicroMsg.Music.IndexBitMgr", "initData");
          long l;
          if (((d)localObject1).hWY <= 0L)
          {
            ad.e("MicroMsg.Music.IndexBitMgr", "fileLength is invalid!");
            paramURL.tVm = new h(paramMap);
            if (new com.tencent.mm.vfs.e(paramURL.tVm.fileName).exists()) {
              break label1299;
            }
            ad.i("MicroMsg.Music.FileBytesCacheMgr", "piece file not exist, clear cache!");
            paramURL.tVl.clearCache();
            l = paramURL.tVk.getSize();
            localObject1 = paramURL.tVm;
            Logger.i("MicroMsg.Music.PieceFileCache", "open");
          }
          try
          {
            localObject2 = new com.tencent.mm.vfs.e(((h)localObject1).fileName);
            if (!((com.tencent.mm.vfs.e)localObject2).exists()) {
              ad.i("MicroMsg.Music.PieceFileCache", "create file:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.e)localObject2).createNewFile()) });
            }
            ((h)localObject1).randomAccessFile = com.tencent.mm.vfs.i.cS(q.B(((com.tencent.mm.vfs.e)localObject2).mUri), true);
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
          paramURL.tVm.setLength(l);
          g.aW(paramMap, l);
          ad.i("MicroMsg.Music.FileBytesCacheMgr", "attach() fileLength is " + l + ",pieceFileCache length is " + paramURL.tVm.getLength());
          localObject1 = paramURL.tVk.getMIMEType();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"application/octet-stream".equalsIgnoreCase((String)localObject1))) {
            g.hD(paramMap, (String)localObject1);
          }
          paramURL.LZ = -1;
          paramURL.mSize = 0;
          paramURL.tVn = -1;
          paramURL.tVo = 0;
          AppMethodBeat.o(137428);
          return true;
          label680:
          ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
          paramURL = null;
          continue;
          paramURL = paramURL;
          ad.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", paramURL, "playUrl", new Object[0]);
        }
        catch (Exception paramMap)
        {
          for (;;)
          {
            Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect, put referrer fail since " + paramMap.toString());
            paramURL = new HashMap(paramURL);
            paramURL.put("Referer", localObject1);
            continue;
            if ((((d)localObject1).hWY % 8192L == 0L) || (((d)localObject1).hWY < 8192L)) {}
            for (((d)localObject1).count = ((int)(((d)localObject1).hWY / 8192L));; ((d)localObject1).count = ((int)(((d)localObject1).hWY / 8192L) + 1))
            {
              if (((d)localObject1).hWY <= 8192L)
              {
                ad.i("MicroMsg.Music.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
                ((d)localObject1).count = 1;
              }
              ad.i("MicroMsg.Music.IndexBitMgr", "fileLength:%d, count:%d", new Object[] { Long.valueOf(((d)localObject1).hWY), Integer.valueOf(((d)localObject1).count) });
              ((d)localObject1).tVr = new BitSet(((d)localObject1).count);
              ((d)localObject1).dqm = g.aiu(((d)localObject1).mUrl);
              if (!TextUtils.isEmpty(((d)localObject1).dqm)) {
                break label937;
              }
              ad.e("MicroMsg.Music.IndexBitMgr", "initData musicId is null!'");
              break;
            }
            label937:
            ad.i("MicroMsg.Music.IndexBitMgr", "musicId:%s", new Object[] { ((d)localObject1).dqm });
            localObject2 = com.tencent.mm.plugin.music.cache.e.ain(((d)localObject1).dqm);
            if (localObject2 == null)
            {
              ad.e("MicroMsg.Music.IndexBitMgr", "initData pMusic is null!'");
            }
            else
            {
              ad.i("MicroMsg.Music.IndexBitMgr", "initData music field_fileCacheComplete:%d", new Object[] { Integer.valueOf(((com.tencent.mm.az.i)localObject2).hnS) });
              if ((((com.tencent.mm.az.i)localObject2).hnR == null) || (((com.tencent.mm.az.i)localObject2).hnR.length == 0))
              {
                ad.e("MicroMsg.Music.IndexBitMgr", "initData field_indexBitData is null!'");
              }
              else
              {
                ((d)localObject1).tVr = d.a.bs(((com.tencent.mm.az.i)localObject2).hnR);
                if (((d)localObject1).tVr == null)
                {
                  ad.e("MicroMsg.Music.IndexBitMgr", "initData bitSet is null");
                  ((d)localObject1).tVr = new BitSet(((d)localObject1).count);
                }
                label1224:
                do
                {
                  for (;;)
                  {
                    ad.i("MicroMsg.Music.IndexBitMgr", "initData bitSet:" + ((d)localObject1).tVr.toString());
                    ad.i("MicroMsg.Music.IndexBitMgr", "initData bitSet count %d, cardinality:" + ((d)localObject1).count + "," + ((d)localObject1).tVr.cardinality());
                    break;
                    if (((d)localObject1).count >= ((d)localObject1).tVr.cardinality()) {
                      break label1224;
                    }
                    ad.e("MicroMsg.Music.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", new Object[] { Integer.valueOf(((d)localObject1).count), Integer.valueOf(((d)localObject1).tVr.cardinality()) });
                    ((d)localObject1).clearCache();
                  }
                } while (((com.tencent.mm.az.i)localObject2).hnU == 1);
                ad.i("MicroMsg.Music.IndexBitMgr", "remove dirty bit set from db, reset cache complete to 0");
                if (((d)localObject1).count > 1)
                {
                  ((d)localObject1).HE(((d)localObject1).count - 1);
                  ((d)localObject1).HE(((d)localObject1).count - 2);
                }
                for (;;)
                {
                  ((d)localObject1).HB(0);
                  break;
                  ((d)localObject1).HE(((d)localObject1).count - 1);
                }
                label1299:
                if ((paramURL.tVm.cUK() != paramURL.tVk.getSize()) && (paramURL.tVk.getSize() != -1L))
                {
                  ad.i("MicroMsg.Music.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
                  paramURL.tVl.clearCache();
                  localObject1 = paramURL.tVm;
                  Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile");
                  h.aiz(((h)localObject1).fileName);
                }
                else if (paramURL.tVk.getSize() == -1L)
                {
                  ad.i("MicroMsg.Music.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
                }
                else
                {
                  ad.i("MicroMsg.Music.FileBytesCacheMgr", "piece file exist!");
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
    if (this.tYs != null)
    {
      com.tencent.mm.plugin.music.cache.a locala = this.tYs;
      locala.cUA();
      locala.tVl.cUH();
      locala.tVm.close();
      locala.tVk = null;
      ad.i("MicroMsg.Music.FileBytesCacheMgr", "detach()");
      this.tYs = null;
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
    String str1 = g.aix(this.tYt.toString());
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
        ad.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
      ad.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time2 :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    String str2 = g.aiw(this.tYt.toString());
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
    if (g.aiy(this.tYt.toString()) > 0L)
    {
      this.mTotalSize = g.aiy(this.tYt.toString());
      l = this.mTotalSize;
      AppMethodBeat.o(137434);
      return l;
    }
    if (this.mConnection == null) {}
    try
    {
      l = System.currentTimeMillis();
      seekTo(0L);
      ad.d("MicroMsg.Music.MMMediaHTTPConnection", "getSize cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
      if (g.fN(this.tYt.toString()) > 0L)
      {
        this.mTotalSize = g.fN(this.tYt.toString());
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
    if (paramInt2 > this.tYu.length) {
      this.tYu = new byte[paramInt2];
    }
    Arrays.fill(this.tYu, 0, this.tYu.length, (byte)0);
    label1114:
    label1259:
    for (;;)
    {
      Object localObject;
      int j;
      int i;
      try
      {
        if (this.tYs == null) {
          continue;
        }
        localObject = this.tYs;
        arrayOfByte = this.tYu;
        j = (int)paramLong;
        if ((arrayOfByte != null) && (j >= 0) && (paramInt2 >= 0)) {
          continue;
        }
        ad.e("MicroMsg.Music.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2) });
      }
      catch (ProtocolException paramArrayOfByte)
      {
        byte[] arrayOfByte;
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.dY(this.tYt.toString(), 750);
        AppMethodBeat.o(137433);
        return -1010;
        i = j + paramInt2;
        l = i;
        if (l <= ((com.tencent.mm.plugin.music.cache.a)localObject).tVk.getSize()) {
          break label1259;
        }
        ad.e("MicroMsg.Music.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(((com.tencent.mm.plugin.music.cache.a)localObject).tVk.getSize()) });
        i = (int)((com.tencent.mm.plugin.music.cache.a)localObject).tVk.getSize() - j;
        if (!((com.tencent.mm.plugin.music.cache.a)localObject).tVl.gj(j, i)) {
          break label1266;
        }
        i = ((com.tencent.mm.plugin.music.cache.a)localObject).tVm.read(arrayOfByte, j, i);
        continue;
        if ((this.mTotalSize <= 0L) || (paramLong < this.mTotalSize) || (paramInt2 <= 0)) {
          continue;
        }
        ad.e("MicroMsg.Music.MMMediaHTTPConnection", "offset is illegal, mTotalSize:%d, offset:%d, size:%d", new Object[] { Long.valueOf(this.mTotalSize), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(137433);
        return 0;
        Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "read from network");
        if (paramLong == this.mCurrentOffset) {
          continue;
        }
        seekTo(paramLong);
        i = this.mInputStream.read(this.tYu, 0, paramInt2);
        if (i != -1) {
          continue;
        }
        paramInt1 = 0;
        this.mCurrentOffset += paramInt1;
        if (this.tYs == null) {
          continue;
        }
        paramArrayOfByte = this.tYs;
        localObject = this.tYu;
        m = (int)paramLong;
        if ((localObject != null) && (m >= 0) && (paramInt1 >= 0)) {
          continue;
        }
        ad.e("MicroMsg.Music.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(137433);
        return paramInt1;
        System.arraycopy(this.tYu, 0, paramArrayOfByte, paramInt1, i);
        paramInt1 = i;
        continue;
      }
      catch (NoRouteToHostException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.dY(this.tYt.toString(), 751);
        AppMethodBeat.o(137433);
        return -1010;
        if (paramArrayOfByte.tVk.getSize() > 0L) {
          continue;
        }
        ad.e("MicroMsg.Music.FileBytesCacheMgr", "write() fileLength is error, file length is " + paramArrayOfByte.tVk.getSize());
        continue;
      }
      catch (UnknownServiceException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.dY(this.tYt.toString(), 752);
        AppMethodBeat.o(137433);
        return -1010;
        i = m + paramInt1;
        long l = i;
        if (l <= paramArrayOfByte.tVk.getSize()) {
          continue;
        }
        ad.e("MicroMsg.Music.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramArrayOfByte.tVk.getSize()) });
        continue;
      }
      catch (IOException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => -1 " + paramArrayOfByte);
        g.dY(this.tYt.toString(), 753);
        AppMethodBeat.o(137433);
        return -1;
        if ((!paramArrayOfByte.Hy(m)) || (!paramArrayOfByte.Hy(i))) {
          break label1138;
        }
        if ((paramArrayOfByte.Hz(m)) && (paramArrayOfByte.Hz(i))) {
          continue;
        }
        if (!paramArrayOfByte.Hz(m)) {
          break label1114;
        }
        paramArrayOfByte.y((byte[])localObject, m, paramInt1);
        if (paramArrayOfByte.mSize != 81920) {
          continue;
        }
        paramArrayOfByte.cUA();
        paramArrayOfByte.HA(i);
        if (i != paramArrayOfByte.tVk.getSize()) {
          continue;
        }
        paramArrayOfByte.cUA();
        paramArrayOfByte.HA(i);
        continue;
      }
      catch (Exception paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "unknown exception ".concat(String.valueOf(paramArrayOfByte)));
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => -1");
        g.dY(this.tYt.toString(), 754);
        AppMethodBeat.o(137433);
        return -1;
      }
      if (i > 0)
      {
        if (i != paramInt2) {
          Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "read from cache, n%d, size %d " + i + "," + paramInt2);
        }
        System.arraycopy(this.tYu, 0, paramArrayOfByte, paramInt1, i);
        AppMethodBeat.o(137433);
        return i;
        if (((com.tencent.mm.plugin.music.cache.a)localObject).tVk.getSize() <= 0L)
        {
          ad.e("MicroMsg.Music.FileBytesCacheMgr", "read(), fileLength is error, file length is " + ((com.tencent.mm.plugin.music.cache.a)localObject).tVk.getSize());
          break label1266;
        }
      }
      int m;
      paramArrayOfByte.cUA();
      paramArrayOfByte.HA(m);
      paramArrayOfByte.y((byte[])localObject, m, paramInt1);
      continue;
      label1138:
      if ((paramArrayOfByte.Hy(m)) && (!paramArrayOfByte.Hy(i)) && (paramArrayOfByte.Hz(m)))
      {
        j = 81920 - paramArrayOfByte.mSize;
        int k = paramInt1 - j;
        if (j > 0) {
          paramArrayOfByte.y((byte[])localObject, m, j);
        }
        paramArrayOfByte.cUA();
        m += j;
        paramArrayOfByte.HA(m);
        if (k > 0) {
          paramArrayOfByte.f((byte[])localObject, j, m, k);
        }
      }
      else
      {
        paramArrayOfByte.cUA();
        paramArrayOfByte.HA(m);
        paramArrayOfByte.y((byte[])localObject, m, paramInt1);
        continue;
        i = paramInt2;
        continue;
        label1266:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a.a
 * JD-Core Version:    0.7.0.1
 */