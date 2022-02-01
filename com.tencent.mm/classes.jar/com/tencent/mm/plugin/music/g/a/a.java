package com.tencent.mm.plugin.music.g.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.d;
import com.tencent.mm.plugin.music.cache.d.a;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.cache.h;
import com.tencent.mm.plugin.music.e.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  private com.tencent.mm.plugin.music.cache.a LOu;
  public URL LOv;
  private byte[] LOw;
  private final Map<String, String> LOx;
  private boolean mAllowCrossDomainRedirect;
  private boolean mAllowCrossProtocolRedirect;
  private HttpURLConnection mConnection;
  private long mCurrentOffset;
  private Map<String, String> mHeaders;
  private InputStream mInputStream;
  private String mMimeType;
  private long mTotalSize;
  private URL mURL;
  
  public a(Map<String, String> paramMap)
  {
    AppMethodBeat.i(270839);
    this.mCurrentOffset = -1L;
    this.mURL = null;
    this.LOv = null;
    this.mHeaders = null;
    this.mConnection = null;
    this.mTotalSize = -1L;
    this.mMimeType = "";
    this.mInputStream = null;
    this.mAllowCrossDomainRedirect = true;
    this.mAllowCrossProtocolRedirect = true;
    this.LOw = new byte[1];
    this.LOx = paramMap;
    AppMethodBeat.o(270839);
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
      g.gn(this.LOv.toString(), m);
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
        for (this.mTotalSize = Util.getLong((String)localObject2, 0L);; this.mTotalSize = this.mConnection.getContentLength())
        {
          i = m;
          if (TextUtils.isEmpty(this.mMimeType))
          {
            i = m;
            this.mMimeType = this.mConnection.getContentType();
            i = m;
            Log.i("MicroMsg.Music.MMMediaHTTPConnection", "mimeType:", new Object[] { this.mMimeType });
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
        Log.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", localIOException, "teardownConnection", new Object[0]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.Music.MMMediaHTTPConnection", localException.getMessage());
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
    this.LOv = paramURL;
    this.mHeaders = paramMap;
    paramURL = paramMap;
    if (paramMap == null)
    {
      paramURL = new HashMap();
      this.mHeaders = paramURL;
    }
    this.mTotalSize = -1L;
    this.mMimeType = "";
    if (MMApplicationContext.isMMProcess())
    {
      paramMap = this.mURL.toString();
      if (!e.gmX()) {
        break label745;
      }
      paramMap = ((c)b.bU(c.class)).aOx(paramMap);
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramMap)) && (!paramMap.equalsIgnoreCase(this.mURL.toString()))) {
        Log.i("MicroMsg.Music.MMMediaHTTPConnection", "use temp shake music url to play:%s", new Object[] { paramMap });
      }
      try
      {
        this.mURL = new URL(paramMap);
        paramMap = com.tencent.mm.plugin.music.logic.j.gnw().LLw;
        if (paramMap != null) {}
        try
        {
          paramMap = paramMap.aOR(this.mURL.toString());
          if ((paramMap != null) && (!TextUtils.isEmpty(paramMap.toString())))
          {
            this.mURL = paramMap;
            Log.i("MicroMsg.Music.MMMediaHTTPConnection", "use getRedirectURL url to play:%s", new Object[] { paramMap.toString() });
          }
        }
        catch (MalformedURLException paramMap)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", paramMap, "getRedirectURL", new Object[0]);
          }
        }
        if (this.mURL != null)
        {
          g.R(this.mURL.toString(), paramURL);
          paramMap = this.LOv.toString();
          Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "connect, originUrlStr: ".concat(String.valueOf(paramMap)));
          localObject1 = (String)this.LOx.get(paramMap);
          paramMap = paramURL;
          if (!"invalidReferrer".equals(localObject1))
          {
            if (paramURL != null) {
              paramURL.remove("referer");
            }
            paramMap = paramURL;
            if (!Util.isNullOrNil((String)localObject1)) {
              Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect, add referrer: ".concat(String.valueOf(localObject1)));
            }
          }
        }
        try
        {
          paramURL.put("Referer", localObject1);
          paramMap = paramURL;
        }
        catch (Exception paramMap)
        {
          for (;;)
          {
            long l;
            Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect, put referrer fail since " + paramMap.toString());
            paramMap = new HashMap(paramURL);
            paramMap.put("Referer", localObject1);
            continue;
            if ((((d)localObject1).fileLength % 8192L == 0L) || (((d)localObject1).fileLength < 8192L)) {}
            for (((d)localObject1).count = ((int)(((d)localObject1).fileLength / 8192L));; ((d)localObject1).count = ((int)(((d)localObject1).fileLength / 8192L) + 1))
            {
              if (((d)localObject1).fileLength <= 8192L)
              {
                Log.i("MicroMsg.Music.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
                ((d)localObject1).count = 1;
              }
              Log.i("MicroMsg.Music.IndexBitMgr", "fileLength:%d, count:%d", new Object[] { Long.valueOf(((d)localObject1).fileLength), Integer.valueOf(((d)localObject1).count) });
              ((d)localObject1).LKB = new BitSet(((d)localObject1).count);
              ((d)localObject1).musicId = g.aOE(((d)localObject1).mUrl);
              if (!TextUtils.isEmpty(((d)localObject1).musicId)) {
                break label1019;
              }
              Log.e("MicroMsg.Music.IndexBitMgr", "initData musicId is null!'");
              break;
            }
            Log.i("MicroMsg.Music.IndexBitMgr", "musicId:%s", new Object[] { ((d)localObject1).musicId });
            localObject2 = e.aOy(((d)localObject1).musicId);
            if (localObject2 == null)
            {
              Log.e("MicroMsg.Music.IndexBitMgr", "initData pMusic is null!'");
            }
            else
            {
              Log.i("MicroMsg.Music.IndexBitMgr", "initData music field_fileCacheComplete:%d", new Object[] { Integer.valueOf(((com.tencent.mm.aw.j)localObject2).oPe) });
              if ((((com.tencent.mm.aw.j)localObject2).oPd == null) || (((com.tencent.mm.aw.j)localObject2).oPd.length == 0))
              {
                Log.e("MicroMsg.Music.IndexBitMgr", "initData field_indexBitData is null!'");
              }
              else
              {
                ((d)localObject1).LKB = d.a.cl(((com.tencent.mm.aw.j)localObject2).oPd);
                if (((d)localObject1).LKB == null)
                {
                  Log.e("MicroMsg.Music.IndexBitMgr", "initData bitSet is null");
                  ((d)localObject1).LKB = new BitSet(((d)localObject1).count);
                }
                do
                {
                  for (;;)
                  {
                    Log.i("MicroMsg.Music.IndexBitMgr", "initData bitSet:" + ((d)localObject1).LKB.toString());
                    Log.i("MicroMsg.Music.IndexBitMgr", "initData bitSet count %d, cardinality:" + ((d)localObject1).count + "," + ((d)localObject1).LKB.cardinality());
                    break;
                    if (((d)localObject1).count >= ((d)localObject1).LKB.cardinality()) {
                      break label1306;
                    }
                    Log.e("MicroMsg.Music.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", new Object[] { Integer.valueOf(((d)localObject1).count), Integer.valueOf(((d)localObject1).LKB.cardinality()) });
                    ((d)localObject1).clearCache();
                  }
                } while (((com.tencent.mm.aw.j)localObject2).oPg == 1);
                Log.i("MicroMsg.Music.IndexBitMgr", "remove dirty bit set from db, reset cache complete to 0");
                if (((d)localObject1).count > 1)
                {
                  ((d)localObject1).adp(((d)localObject1).count - 1);
                  ((d)localObject1).adp(((d)localObject1).count - 2);
                }
                for (;;)
                {
                  ((d)localObject1).adm(0);
                  break;
                  ((d)localObject1).adp(((d)localObject1).count - 1);
                }
                if ((paramURL.LKw.gmY() != paramURL.LKu.getSize()) && (paramURL.LKu.getSize() != -1L))
                {
                  Log.i("MicroMsg.Music.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
                  paramURL.LKv.clearCache();
                  localObject1 = paramURL.LKw;
                  Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile");
                  h.aOJ(((h)localObject1).fileName);
                }
                else if (paramURL.LKu.getSize() == -1L)
                {
                  Log.i("MicroMsg.Music.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
                }
                else
                {
                  Log.i("MicroMsg.Music.FileBytesCacheMgr", "piece file exist!");
                }
              }
            }
          }
        }
        Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "headers=".concat(String.valueOf(paramMap)));
        this.LOu = new com.tencent.mm.plugin.music.cache.a(this);
        paramURL = this.LOu;
        paramMap = paramURL.LKu.LOv.toString();
        paramURL.LKv = new d(paramMap);
        paramURL.LKv.fileLength = paramURL.LKu.getSize();
        localObject1 = paramURL.LKv;
        Log.i("MicroMsg.Music.IndexBitMgr", "initData");
        if (((d)localObject1).fileLength <= 0L)
        {
          Log.e("MicroMsg.Music.IndexBitMgr", "fileLength is invalid!");
          paramURL.LKw = new h(paramMap);
          if (new u(paramURL.LKw.fileName).jKS()) {
            break label1381;
          }
          Log.i("MicroMsg.Music.FileBytesCacheMgr", "piece file not exist, clear cache!");
          paramURL.LKv.clearCache();
          l = paramURL.LKu.getSize();
          localObject1 = paramURL.LKw;
          Logger.i("MicroMsg.Music.PieceFileCache", "open");
        }
        try
        {
          localObject2 = new u(((h)localObject1).fileName);
          if (!((u)localObject2).jKS()) {
            Log.i("MicroMsg.Music.PieceFileCache", "create file:%b", new Object[] { Boolean.valueOf(((u)localObject2).jKZ()) });
          }
          ((h)localObject1).randomAccessFile = y.eA(ah.v(((u)localObject2).mUri), true);
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
        paramURL.LKw.dY(l);
        g.bn(paramMap, l);
        Log.i("MicroMsg.Music.FileBytesCacheMgr", "attach() fileLength is " + l + ",pieceFileCache length is " + paramURL.LKw.getLength());
        localObject1 = paramURL.LKu.getMIMEType();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"application/octet-stream".equalsIgnoreCase((String)localObject1))) {
          g.kv(paramMap, (String)localObject1);
        }
        paramURL.Sc = -1;
        paramURL.mSize = 0;
        paramURL.LKx = -1;
        paramURL.LKy = 0;
        AppMethodBeat.o(137428);
        return true;
        label745:
        Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        paramMap = null;
      }
      catch (MalformedURLException paramMap)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", paramMap, "playUrl", new Object[0]);
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
    if (this.LOu != null)
    {
      com.tencent.mm.plugin.music.cache.a locala = this.LOu;
      locala.gmP();
      locala.LKv.gmV();
      locala.LKw.close();
      locala.LKu = null;
      Log.i("MicroMsg.Music.FileBytesCacheMgr", "detach()");
      this.LOu = null;
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
    String str1 = g.aOH(this.LOv.toString());
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
        Log.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
      Log.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time2 :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    String str2 = g.aOG(this.LOv.toString());
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
    if (g.aOI(this.LOv.toString()) > 0L)
    {
      this.mTotalSize = g.aOI(this.LOv.toString());
      l = this.mTotalSize;
      AppMethodBeat.o(137434);
      return l;
    }
    if (this.mConnection == null) {}
    try
    {
      l = System.currentTimeMillis();
      seekTo(0L);
      Log.d("MicroMsg.Music.MMMediaHTTPConnection", "getSize cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
      if (g.jK(this.LOv.toString()) > 0L)
      {
        this.mTotalSize = g.jK(this.LOv.toString());
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
    if (paramInt2 > this.LOw.length) {
      this.LOw = new byte[paramInt2];
    }
    Arrays.fill(this.LOw, 0, this.LOw.length, (byte)0);
    label1292:
    for (;;)
    {
      Object localObject;
      int j;
      int i;
      try
      {
        if ((g.aOM(this.LOv.toString())) || (this.LOu == null)) {
          continue;
        }
        localObject = this.LOu;
        arrayOfByte = this.LOw;
        j = (int)paramLong;
        if ((arrayOfByte != null) && (j >= 0) && (paramInt2 >= 0)) {
          continue;
        }
        Log.e("MicroMsg.Music.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2) });
      }
      catch (ProtocolException paramArrayOfByte)
      {
        byte[] arrayOfByte;
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.go(this.LOv.toString(), 750);
        teardownConnection();
        AppMethodBeat.o(137433);
        return -1010;
        i = j + paramInt2;
        l = i;
        if (l <= ((com.tencent.mm.plugin.music.cache.a)localObject).LKu.getSize()) {
          break label1292;
        }
        Log.e("MicroMsg.Music.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(((com.tencent.mm.plugin.music.cache.a)localObject).LKu.getSize()) });
        i = (int)((com.tencent.mm.plugin.music.cache.a)localObject).LKu.getSize() - j;
        if (!((com.tencent.mm.plugin.music.cache.a)localObject).LKv.jY(j, i)) {
          break label1299;
        }
        i = ((com.tencent.mm.plugin.music.cache.a)localObject).LKw.b(arrayOfByte, j, i);
        continue;
        if ((this.mTotalSize <= 0L) || (paramLong < this.mTotalSize) || (paramInt2 <= 0)) {
          continue;
        }
        Log.e("MicroMsg.Music.MMMediaHTTPConnection", "offset is illegal, mTotalSize:%d, offset:%d, size:%d", new Object[] { Long.valueOf(this.mTotalSize), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(137433);
        return 0;
        Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "read from network");
        if (paramLong == this.mCurrentOffset) {
          continue;
        }
        seekTo(paramLong);
        i = this.mInputStream.read(this.LOw, 0, paramInt2);
        if (i != -1) {
          continue;
        }
        paramInt1 = 0;
        this.mCurrentOffset += paramInt1;
        if (this.LOu == null) {
          continue;
        }
        paramArrayOfByte = this.LOu;
        localObject = this.LOw;
        m = (int)paramLong;
        if ((localObject != null) && (m >= 0) && (paramInt1 >= 0)) {
          continue;
        }
        Log.e("MicroMsg.Music.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(137433);
        return paramInt1;
        System.arraycopy(this.LOw, 0, paramArrayOfByte, paramInt1, i);
        paramInt1 = i;
        continue;
      }
      catch (NoRouteToHostException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.go(this.LOv.toString(), 751);
        teardownConnection();
        AppMethodBeat.o(137433);
        return -1010;
        if (paramArrayOfByte.LKu.getSize() > 0L) {
          continue;
        }
        Log.e("MicroMsg.Music.FileBytesCacheMgr", "write() fileLength is error, file length is " + paramArrayOfByte.LKu.getSize());
        continue;
      }
      catch (UnknownServiceException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.go(this.LOv.toString(), 752);
        teardownConnection();
        AppMethodBeat.o(137433);
        return -1010;
        i = m + paramInt1;
        long l = i;
        if (l <= paramArrayOfByte.LKu.getSize()) {
          continue;
        }
        Log.e("MicroMsg.Music.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramArrayOfByte.LKu.getSize()) });
        continue;
      }
      catch (IOException paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => -1 " + paramArrayOfByte);
        g.go(this.LOv.toString(), 753);
        teardownConnection();
        AppMethodBeat.o(137433);
        return -1;
        if ((!paramArrayOfByte.kB(m)) || (!paramArrayOfByte.kB(i))) {
          break label1171;
        }
        if ((paramArrayOfByte.adk(m)) && (paramArrayOfByte.adk(i))) {
          continue;
        }
        if (!paramArrayOfByte.adk(m)) {
          break label1147;
        }
        paramArrayOfByte.J((byte[])localObject, m, paramInt1);
        if (paramArrayOfByte.mSize != 81920) {
          continue;
        }
        paramArrayOfByte.gmP();
        paramArrayOfByte.adl(i);
        if (i != paramArrayOfByte.LKu.getSize()) {
          continue;
        }
        paramArrayOfByte.gmP();
        paramArrayOfByte.adl(i);
        continue;
      }
      catch (Exception paramArrayOfByte)
      {
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "unknown exception ".concat(String.valueOf(paramArrayOfByte)));
        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => -1");
        g.go(this.LOv.toString(), 754);
        teardownConnection();
        AppMethodBeat.o(137433);
        return -1;
      }
      if (i > 0)
      {
        if (i != paramInt2) {
          Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "read from cache, n%d, size %d " + i + "," + paramInt2);
        }
        System.arraycopy(this.LOw, 0, paramArrayOfByte, paramInt1, i);
        AppMethodBeat.o(137433);
        return i;
        if (((com.tencent.mm.plugin.music.cache.a)localObject).LKu.getSize() <= 0L)
        {
          Log.e("MicroMsg.Music.FileBytesCacheMgr", "read(), fileLength is error, file length is " + ((com.tencent.mm.plugin.music.cache.a)localObject).LKu.getSize());
          break label1299;
        }
      }
      int m;
      label1147:
      paramArrayOfByte.gmP();
      paramArrayOfByte.adl(m);
      paramArrayOfByte.J((byte[])localObject, m, paramInt1);
      continue;
      label1171:
      if ((paramArrayOfByte.kB(m)) && (!paramArrayOfByte.kB(i)) && (paramArrayOfByte.adk(m)))
      {
        j = 81920 - paramArrayOfByte.mSize;
        int k = paramInt1 - j;
        if (j > 0) {
          paramArrayOfByte.J((byte[])localObject, m, j);
        }
        paramArrayOfByte.gmP();
        m += j;
        paramArrayOfByte.adl(m);
        if (k > 0) {
          paramArrayOfByte.j((byte[])localObject, j, m, k);
        }
      }
      else
      {
        paramArrayOfByte.gmP();
        paramArrayOfByte.adl(m);
        paramArrayOfByte.J((byte[])localObject, m, paramInt1);
        continue;
        i = paramInt2;
        continue;
        label1299:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a.a
 * JD-Core Version:    0.7.0.1
 */