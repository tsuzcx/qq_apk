package com.tencent.mm.plugin.music.g.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.i;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.d;
import com.tencent.mm.plugin.music.cache.d.a;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.cache.h;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
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
  private com.tencent.mm.plugin.music.cache.a wCi;
  public URL wCj;
  private byte[] wCk;
  private final Map<String, String> wCl;
  
  public a(Map<String, String> paramMap)
  {
    AppMethodBeat.i(195462);
    this.mCurrentOffset = -1L;
    this.mURL = null;
    this.wCj = null;
    this.mHeaders = null;
    this.mConnection = null;
    this.mTotalSize = -1L;
    this.mMimeType = "";
    this.mInputStream = null;
    this.mAllowCrossDomainRedirect = true;
    this.mAllowCrossProtocolRedirect = true;
    this.wCk = new byte[1];
    this.wCl = paramMap;
    AppMethodBeat.o(195462);
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
    int i = j;
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
    label283:
    label1082:
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
          break label283;
        }
        localObject1 = this.mHeaders.entrySet().iterator();
        m = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label283;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        this.mConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
        if ((i != 0) || (!"Accept-Encoding".equals(localEntry.getKey()))) {
          break label1082;
        }
        i = 1;
      }
      catch (IOException localIOException1)
      {
        i = j;
        this.mTotalSize = -1L;
        teardownConnection();
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "seekTo exception:%s", new Object[] { localIOException1 + ", response:" + i });
        AppMethodBeat.o(137432);
        throw localIOException1;
      }
      this.mConnection = ((HttpURLConnection)((URL)localObject1).openConnection());
      continue;
      if (paramLong > 0L) {
        this.mConnection.setRequestProperty("Range", "bytes=" + paramLong + "-");
      }
      if (m == 0) {
        this.mConnection.setRequestProperty("Accept-Encoding", "");
      }
      m = this.mConnection.getResponseCode();
      g.eE(this.wCj.toString(), m);
      Object localObject2;
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
          break;
        }
        i = m;
        this.mURL = ((URL)localObject2);
        break;
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
      try
      {
        for (this.mTotalSize = bu.getLong((String)localObject2, 0L);; this.mTotalSize = this.mConnection.getContentLength())
        {
          i = m;
          if (TextUtils.isEmpty(this.mMimeType))
          {
            i = m;
            this.mMimeType = this.mConnection.getContentType();
            i = m;
            ae.i("MicroMsg.Music.MMMediaHTTPConnection", "mimeType:", new Object[] { this.mMimeType });
          }
          if ((paramLong <= 0L) || (m == 206)) {
            break;
          }
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
        }
        i = m;
        this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
        i = m;
        this.mCurrentOffset = paramLong;
        AppMethodBeat.o(137432);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label901;
      }
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
        ae.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", localIOException, "teardownConnection", new Object[0]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.Music.MMMediaHTTPConnection", localException.getMessage());
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
    this.wCj = paramURL;
    this.mHeaders = paramMap;
    this.mTotalSize = -1L;
    this.mMimeType = "";
    if (ak.cpe())
    {
      paramURL = this.mURL.toString();
      if (!e.dvQ()) {
        break label680;
      }
      paramURL = ((c)b.aQ(c.class)).atu(paramURL);
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramURL)) && (!paramURL.equalsIgnoreCase(this.mURL.toString()))) {
        ae.i("MicroMsg.Music.MMMediaHTTPConnection", "use temp shake music url to play:%s", new Object[] { paramURL });
      }
      try
      {
        this.mURL = new URL(paramURL);
        if (this.mURL != null)
        {
          g.C(this.mURL.toString(), paramMap);
          paramURL = this.wCj.toString();
          Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "connect, originUrlStr: ".concat(String.valueOf(paramURL)));
          localObject1 = (String)this.wCl.get(paramURL);
          paramURL = paramMap;
          if (!"invalidReferrer".equals(localObject1))
          {
            if (paramMap != null) {
              paramMap.remove("referer");
            }
            paramURL = paramMap;
            if (!bu.isNullOrNil((String)localObject1))
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
          this.wCi = new com.tencent.mm.plugin.music.cache.a(this);
          paramURL = this.wCi;
          paramMap = paramURL.wyT.wCj.toString();
          paramURL.wyU = new d(paramMap);
          paramURL.wyU.iTe = paramURL.wyT.getSize();
          localObject1 = paramURL.wyU;
          ae.i("MicroMsg.Music.IndexBitMgr", "initData");
          long l;
          if (((d)localObject1).iTe <= 0L)
          {
            ae.e("MicroMsg.Music.IndexBitMgr", "fileLength is invalid!");
            paramURL.wyV = new h(paramMap);
            if (new k(paramURL.wyV.fileName).exists()) {
              break label1299;
            }
            ae.i("MicroMsg.Music.FileBytesCacheMgr", "piece file not exist, clear cache!");
            paramURL.wyU.clearCache();
            l = paramURL.wyT.getSize();
            localObject1 = paramURL.wyV;
            Logger.i("MicroMsg.Music.PieceFileCache", "open");
          }
          try
          {
            localObject2 = new k(((h)localObject1).fileName);
            if (!((k)localObject2).exists()) {
              ae.i("MicroMsg.Music.PieceFileCache", "create file:%b", new Object[] { Boolean.valueOf(((k)localObject2).createNewFile()) });
            }
            ((h)localObject1).randomAccessFile = o.dg(w.B(((k)localObject2).mUri), true);
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
          paramURL.wyV.setLength(l);
          g.ba(paramMap, l);
          ae.i("MicroMsg.Music.FileBytesCacheMgr", "attach() fileLength is " + l + ",pieceFileCache length is " + paramURL.wyV.getLength());
          localObject1 = paramURL.wyT.getMIMEType();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"application/octet-stream".equalsIgnoreCase((String)localObject1))) {
            g.in(paramMap, (String)localObject1);
          }
          paramURL.fq = -1;
          paramURL.mSize = 0;
          paramURL.wyW = -1;
          paramURL.wyX = 0;
          AppMethodBeat.o(137428);
          return true;
          label680:
          ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
          paramURL = null;
          continue;
          paramURL = paramURL;
          ae.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", paramURL, "playUrl", new Object[0]);
        }
        catch (Exception paramMap)
        {
          for (;;)
          {
            Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect, put referrer fail since " + paramMap.toString());
            paramURL = new HashMap(paramURL);
            paramURL.put("Referer", localObject1);
            continue;
            if ((((d)localObject1).iTe % 8192L == 0L) || (((d)localObject1).iTe < 8192L)) {}
            for (((d)localObject1).count = ((int)(((d)localObject1).iTe / 8192L));; ((d)localObject1).count = ((int)(((d)localObject1).iTe / 8192L) + 1))
            {
              if (((d)localObject1).iTe <= 8192L)
              {
                ae.i("MicroMsg.Music.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
                ((d)localObject1).count = 1;
              }
              ae.i("MicroMsg.Music.IndexBitMgr", "fileLength:%d, count:%d", new Object[] { Long.valueOf(((d)localObject1).iTe), Integer.valueOf(((d)localObject1).count) });
              ((d)localObject1).wza = new BitSet(((d)localObject1).count);
              ((d)localObject1).dAQ = g.atC(((d)localObject1).mUrl);
              if (!TextUtils.isEmpty(((d)localObject1).dAQ)) {
                break label937;
              }
              ae.e("MicroMsg.Music.IndexBitMgr", "initData musicId is null!'");
              break;
            }
            label937:
            ae.i("MicroMsg.Music.IndexBitMgr", "musicId:%s", new Object[] { ((d)localObject1).dAQ });
            localObject2 = e.atv(((d)localObject1).dAQ);
            if (localObject2 == null)
            {
              ae.e("MicroMsg.Music.IndexBitMgr", "initData pMusic is null!'");
            }
            else
            {
              ae.i("MicroMsg.Music.IndexBitMgr", "initData music field_fileCacheComplete:%d", new Object[] { Integer.valueOf(((i)localObject2).ikC) });
              if ((((i)localObject2).ikB == null) || (((i)localObject2).ikB.length == 0))
              {
                ae.e("MicroMsg.Music.IndexBitMgr", "initData field_indexBitData is null!'");
              }
              else
              {
                ((d)localObject1).wza = d.a.bC(((i)localObject2).ikB);
                if (((d)localObject1).wza == null)
                {
                  ae.e("MicroMsg.Music.IndexBitMgr", "initData bitSet is null");
                  ((d)localObject1).wza = new BitSet(((d)localObject1).count);
                }
                label1224:
                do
                {
                  for (;;)
                  {
                    ae.i("MicroMsg.Music.IndexBitMgr", "initData bitSet:" + ((d)localObject1).wza.toString());
                    ae.i("MicroMsg.Music.IndexBitMgr", "initData bitSet count %d, cardinality:" + ((d)localObject1).count + "," + ((d)localObject1).wza.cardinality());
                    break;
                    if (((d)localObject1).count >= ((d)localObject1).wza.cardinality()) {
                      break label1224;
                    }
                    ae.e("MicroMsg.Music.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", new Object[] { Integer.valueOf(((d)localObject1).count), Integer.valueOf(((d)localObject1).wza.cardinality()) });
                    ((d)localObject1).clearCache();
                  }
                } while (((i)localObject2).ikE == 1);
                ae.i("MicroMsg.Music.IndexBitMgr", "remove dirty bit set from db, reset cache complete to 0");
                if (((d)localObject1).count > 1)
                {
                  ((d)localObject1).LK(((d)localObject1).count - 1);
                  ((d)localObject1).LK(((d)localObject1).count - 2);
                }
                for (;;)
                {
                  ((d)localObject1).LH(0);
                  break;
                  ((d)localObject1).LK(((d)localObject1).count - 1);
                }
                label1299:
                if ((paramURL.wyV.dvR() != paramURL.wyT.getSize()) && (paramURL.wyT.getSize() != -1L))
                {
                  ae.i("MicroMsg.Music.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
                  paramURL.wyU.clearCache();
                  localObject1 = paramURL.wyV;
                  Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile");
                  h.atH(((h)localObject1).fileName);
                }
                else if (paramURL.wyT.getSize() == -1L)
                {
                  ae.i("MicroMsg.Music.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
                }
                else
                {
                  ae.i("MicroMsg.Music.FileBytesCacheMgr", "piece file exist!");
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
    if (this.wCi != null)
    {
      com.tencent.mm.plugin.music.cache.a locala = this.wCi;
      locala.dvH();
      locala.wyU.dvO();
      locala.wyV.close();
      locala.wyT = null;
      ae.i("MicroMsg.Music.FileBytesCacheMgr", "detach()");
      this.wCi = null;
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
    String str1 = g.atF(this.wCj.toString());
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
        ae.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
      ae.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time2 :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    String str2 = g.atE(this.wCj.toString());
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
    if (g.atG(this.wCj.toString()) > 0L)
    {
      this.mTotalSize = g.atG(this.wCj.toString());
      l = this.mTotalSize;
      AppMethodBeat.o(137434);
      return l;
    }
    if (this.mConnection == null) {}
    try
    {
      l = System.currentTimeMillis();
      seekTo(0L);
      ae.d("MicroMsg.Music.MMMediaHTTPConnection", "getSize cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
      if (g.gE(this.wCj.toString()) > 0L)
      {
        this.mTotalSize = g.gE(this.wCj.toString());
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
    if (paramInt2 > this.wCk.length) {
      this.wCk = new byte[paramInt2];
    }
    Arrays.fill(this.wCk, 0, this.wCk.length, (byte)0);
    for (;;)
    {
      Object localObject;
      int j;
      int i;
      try
      {
        if (this.wCi == null) {
          continue;
        }
        localObject = this.wCi;
        arrayOfByte = this.wCk;
        j = (int)paramLong;
        if ((arrayOfByte != null) && (j >= 0) && (paramInt2 >= 0)) {
          continue;
        }
        ae.e("MicroMsg.Music.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2) });
      }
      catch (ProtocolException paramArrayOfByte)
      {
        byte[] arrayOfByte;
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.eF(this.wCj.toString(), 750);
        teardownConnection();
        AppMethodBeat.o(137433);
        return -1010;
        i = j + paramInt2;
        l = i;
        if (l <= ((com.tencent.mm.plugin.music.cache.a)localObject).wyT.getSize()) {
          break label1279;
        }
        ae.e("MicroMsg.Music.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(((com.tencent.mm.plugin.music.cache.a)localObject).wyT.getSize()) });
        i = (int)((com.tencent.mm.plugin.music.cache.a)localObject).wyT.getSize() - j;
        if (!((com.tencent.mm.plugin.music.cache.a)localObject).wyU.gJ(j, i)) {
          break label1286;
        }
        i = ((com.tencent.mm.plugin.music.cache.a)localObject).wyV.read(arrayOfByte, j, i);
        continue;
        if ((this.mTotalSize <= 0L) || (paramLong < this.mTotalSize) || (paramInt2 <= 0)) {
          continue;
        }
        ae.e("MicroMsg.Music.MMMediaHTTPConnection", "offset is illegal, mTotalSize:%d, offset:%d, size:%d", new Object[] { Long.valueOf(this.mTotalSize), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(137433);
        return 0;
        Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "read from network");
        if (paramLong == this.mCurrentOffset) {
          continue;
        }
        seekTo(paramLong);
        i = this.mInputStream.read(this.wCk, 0, paramInt2);
        if (i != -1) {
          continue;
        }
        paramInt1 = 0;
        this.mCurrentOffset += paramInt1;
        if (this.wCi == null) {
          continue;
        }
        paramArrayOfByte = this.wCi;
        localObject = this.wCk;
        m = (int)paramLong;
        if ((localObject != null) && (m >= 0) && (paramInt1 >= 0)) {
          continue;
        }
        ae.e("MicroMsg.Music.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(137433);
        return paramInt1;
        System.arraycopy(this.wCk, 0, paramArrayOfByte, paramInt1, i);
        paramInt1 = i;
        continue;
      }
      catch (NoRouteToHostException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.eF(this.wCj.toString(), 751);
        teardownConnection();
        AppMethodBeat.o(137433);
        return -1010;
        if (paramArrayOfByte.wyT.getSize() > 0L) {
          continue;
        }
        ae.e("MicroMsg.Music.FileBytesCacheMgr", "write() fileLength is error, file length is " + paramArrayOfByte.wyT.getSize());
        continue;
      }
      catch (UnknownServiceException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.eF(this.wCj.toString(), 752);
        teardownConnection();
        AppMethodBeat.o(137433);
        return -1010;
        i = m + paramInt1;
        long l = i;
        if (l <= paramArrayOfByte.wyT.getSize()) {
          continue;
        }
        ae.e("MicroMsg.Music.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramArrayOfByte.wyT.getSize()) });
        continue;
      }
      catch (IOException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => -1 " + paramArrayOfByte);
        g.eF(this.wCj.toString(), 753);
        teardownConnection();
        AppMethodBeat.o(137433);
        return -1;
        if ((!paramArrayOfByte.LE(m)) || (!paramArrayOfByte.LE(i))) {
          break label1158;
        }
        if ((paramArrayOfByte.LF(m)) && (paramArrayOfByte.LF(i))) {
          continue;
        }
        if (!paramArrayOfByte.LF(m)) {
          break label1134;
        }
        paramArrayOfByte.z((byte[])localObject, m, paramInt1);
        if (paramArrayOfByte.mSize != 81920) {
          continue;
        }
        paramArrayOfByte.dvH();
        paramArrayOfByte.LG(i);
        if (i != paramArrayOfByte.wyT.getSize()) {
          continue;
        }
        paramArrayOfByte.dvH();
        paramArrayOfByte.LG(i);
        continue;
      }
      catch (Exception paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "unknown exception ".concat(String.valueOf(paramArrayOfByte)));
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => -1");
        g.eF(this.wCj.toString(), 754);
        teardownConnection();
        AppMethodBeat.o(137433);
        return -1;
      }
      if (i > 0)
      {
        if (i != paramInt2) {
          Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "read from cache, n%d, size %d " + i + "," + paramInt2);
        }
        System.arraycopy(this.wCk, 0, paramArrayOfByte, paramInt1, i);
        AppMethodBeat.o(137433);
        return i;
        if (((com.tencent.mm.plugin.music.cache.a)localObject).wyT.getSize() <= 0L)
        {
          ae.e("MicroMsg.Music.FileBytesCacheMgr", "read(), fileLength is error, file length is " + ((com.tencent.mm.plugin.music.cache.a)localObject).wyT.getSize());
          break label1286;
        }
      }
      int m;
      label1134:
      paramArrayOfByte.dvH();
      paramArrayOfByte.LG(m);
      paramArrayOfByte.z((byte[])localObject, m, paramInt1);
      continue;
      label1158:
      if ((paramArrayOfByte.LE(m)) && (!paramArrayOfByte.LE(i)) && (paramArrayOfByte.LF(m)))
      {
        j = 81920 - paramArrayOfByte.mSize;
        int k = paramInt1 - j;
        if (j > 0) {
          paramArrayOfByte.z((byte[])localObject, m, j);
        }
        paramArrayOfByte.dvH();
        m += j;
        paramArrayOfByte.LG(m);
        if (k > 0) {
          paramArrayOfByte.h((byte[])localObject, j, m, k);
        }
      }
      else
      {
        paramArrayOfByte.dvH();
        paramArrayOfByte.LG(m);
        paramArrayOfByte.z((byte[])localObject, m, paramInt1);
        continue;
        label1279:
        i = paramInt2;
        continue;
        label1286:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a.a
 * JD-Core Version:    0.7.0.1
 */