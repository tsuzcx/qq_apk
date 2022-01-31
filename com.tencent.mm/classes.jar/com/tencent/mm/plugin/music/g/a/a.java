package com.tencent.mm.plugin.music.g.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.d;
import com.tencent.mm.plugin.music.cache.d.a;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements IMediaHTTPConnection
{
  private boolean mAllowCrossDomainRedirect = true;
  private boolean mAllowCrossProtocolRedirect = true;
  private com.tencent.mm.plugin.music.cache.a mBa;
  public URL mBb = null;
  private byte[] mBc = new byte[1];
  private HttpURLConnection mConnection = null;
  private long mCurrentOffset = -1L;
  private Map<String, String> mHeaders = null;
  private InputStream mInputStream = null;
  private String mMimeType = "";
  private long mTotalSize = -1L;
  private URL mURL = null;
  
  private static final boolean isLocalHost(URL paramURL)
  {
    if (paramURL == null) {}
    for (;;)
    {
      return false;
      paramURL = paramURL.getHost();
      if (paramURL != null) {
        try
        {
          boolean bool = paramURL.equalsIgnoreCase("localhost");
          if (bool) {
            return true;
          }
        }
        catch (IllegalArgumentException paramURL)
        {
          Logger.e("MicroMsg.MMMediaHTTPConnection", "isLocalHost IllegalArgumentException:%s", new Object[] { String.valueOf(paramURL) });
        }
      }
    }
    return false;
  }
  
  private void seekTo(long paramLong)
  {
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
    label262:
    label791:
    label888:
    for (;;)
    {
      try
      {
        this.mConnection = ((HttpURLConnection)((URL)localObject1).openConnection(Proxy.NO_PROXY));
        this.mConnection.setConnectTimeout(30000);
        this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
        m = 0;
        i = 0;
        if (this.mHeaders == null) {
          break label262;
        }
        localObject1 = this.mHeaders.entrySet().iterator();
        m = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label262;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        this.mConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
        if ((i != 0) || (!"Accept-Encoding".equals(localEntry.getKey()))) {
          break label888;
        }
        i = 1;
      }
      catch (IOException localIOException1)
      {
        i = j;
        this.mTotalSize = -1L;
        this.mInputStream = null;
        this.mConnection = null;
        this.mCurrentOffset = -1L;
        Logger.e("MicroMsg.MMMediaHTTPConnection", "seekTo exception:%s", new Object[] { localIOException1 + ", response:" + i });
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
      g.ca(this.mBb.toString(), m);
      Object localObject2;
      if ((m == 300) || (m == 301) || (m == 302) || (m == 303) || (m == 307))
      {
        k += 1;
        if (k > 20)
        {
          i = m;
          throw new NoRouteToHostException("Too many redirects: " + k);
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
              throw new NoRouteToHostException("Invalid redirect");
            }
          }
        }
        i = m;
        localObject2 = this.mConnection.getHeaderField("Location");
        if (localObject2 == null)
        {
          i = m;
          throw new NoRouteToHostException("Invalid redirect");
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
            throw new NoRouteToHostException("Unsupported protocol redirect");
          }
        }
        i = m;
        boolean bool2 = this.mURL.getProtocol().equals(((URL)localObject2).getProtocol());
        i = m;
        if ((!this.mAllowCrossProtocolRedirect) && (!bool2))
        {
          i = m;
          throw new NoRouteToHostException("Cross-protocol redirects are disallowed");
        }
        i = m;
        bool2 = this.mURL.getHost().equals(((URL)localObject2).getHost());
        i = m;
        if ((!this.mAllowCrossDomainRedirect) && (!bool2))
        {
          i = m;
          throw new NoRouteToHostException("Cross-domain redirects are disallowed");
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
        for (this.mTotalSize = bk.getLong((String)localObject2, 0L); (paramLong > 0L) && (m != 206); this.mTotalSize = this.mConnection.getContentLength())
        {
          i = m;
          throw new ProtocolException();
          if (m != 200)
          {
            i = m;
            throw new IOException();
          }
          i = m;
        }
        i = m;
        this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
        i = m;
        this.mCurrentOffset = paramLong;
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label791;
      }
    }
  }
  
  private void teardownConnection()
  {
    if (this.mConnection != null)
    {
      this.mInputStream = null;
      this.mConnection.disconnect();
      this.mConnection = null;
      this.mCurrentOffset = -1L;
    }
  }
  
  public final boolean connect(URL paramURL, Map<String, String> paramMap)
  {
    Logger.i("MicroMsg.MMMediaHTTPConnection", "connect");
    Logger.i("MicroMsg.MMMediaHTTPConnection", "connect: uri=" + paramURL + ", headers=" + paramMap);
    disconnect();
    this.mAllowCrossDomainRedirect = true;
    this.mURL = paramURL;
    this.mBb = paramURL;
    this.mHeaders = paramMap;
    this.mTotalSize = -1L;
    this.mMimeType = "";
    if (ae.cqV())
    {
      paramURL = this.mURL.toString();
      if (!e.bmM()) {
        break label553;
      }
      paramURL = ((c)b.Q(c.class)).Jf(paramURL);
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramURL)) && (!paramURL.equalsIgnoreCase(this.mURL.toString()))) {
        y.i("MicroMsg.MMMediaHTTPConnection", "use temp shake music url to play:%s", new Object[] { paramURL });
      }
      try
      {
        this.mURL = new URL(paramURL);
        if (this.mURL != null)
        {
          g.n(this.mURL.toString(), paramMap);
          Logger.i("MicroMsg.MMMediaHTTPConnection", "headers=" + paramMap);
        }
        this.mBa = new com.tencent.mm.plugin.music.cache.a(this);
        paramURL = this.mBa;
        paramMap = paramURL.mxU.mBb.toString();
        paramURL.mxV = new d(paramMap);
        paramURL.mxV.eUd = paramURL.mxU.getSize();
        localObject1 = paramURL.mxV;
        y.i("MicroMsg.Music.IndexBitMgr", "initData");
        long l;
        if (((d)localObject1).eUd <= 0L)
        {
          y.e("MicroMsg.Music.IndexBitMgr", "fileLength is invalid!");
          paramURL.mxW = new com.tencent.mm.plugin.music.cache.h(paramMap);
          if (new File(paramURL.mxW.fileName).exists()) {
            break label1047;
          }
          y.i("MicroMsg.Music.FileBytesCacheMgr", "piece file not exist, clear cache!");
          paramURL.mxV.clearCache();
          l = paramURL.mxU.getSize();
          localObject1 = paramURL.mxW;
          Logger.i("MicroMsg.Music.PieceFileCache", "open");
        }
        try
        {
          localObject2 = new File(((com.tencent.mm.plugin.music.cache.h)localObject1).fileName);
          if (!((File)localObject2).exists()) {
            y.i("MicroMsg.Music.PieceFileCache", "create file:%b", new Object[] { Boolean.valueOf(((File)localObject2).createNewFile()) });
          }
          ((com.tencent.mm.plugin.music.cache.h)localObject1).randomAccessFile = new RandomAccessFile((File)localObject2, "rws");
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (;;)
          {
            Object localObject2;
            Logger.e("MicroMsg.Music.PieceFileCache", "file not found", localFileNotFoundException);
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[] { ((com.tencent.mm.plugin.music.cache.h)localObject1).fileName });
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            label553:
            Logger.e("MicroMsg.Music.PieceFileCache", "io ", localIOException);
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[] { ((com.tencent.mm.plugin.music.cache.h)localObject1).fileName });
          }
        }
        finally
        {
          Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[] { ((com.tencent.mm.plugin.music.cache.h)localObject1).fileName });
        }
        paramURL.mxW.setLength(l);
        g.ae(paramMap, l);
        y.i("MicroMsg.Music.FileBytesCacheMgr", "attach() fileLength is " + l + ",pieceFileCache length is " + paramURL.mxW.getLength());
        localObject1 = paramURL.mxU.getMIMEType();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"application/octet-stream".equalsIgnoreCase((String)localObject1))) {
          g.ed(paramMap, (String)localObject1);
        }
        paramURL.El = -1;
        paramURL.mSize = 0;
        paramURL.mxX = -1;
        paramURL.mxY = 0;
        return true;
        y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        paramURL = null;
      }
      catch (MalformedURLException paramURL)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.MMMediaHTTPConnection", paramURL, "playUrl", new Object[0]);
          continue;
          if ((((d)localObject1).eUd % 8192L == 0L) || (((d)localObject1).eUd < 8192L)) {}
          for (((d)localObject1).count = ((int)(((d)localObject1).eUd / 8192L));; ((d)localObject1).count = ((int)(((d)localObject1).eUd / 8192L) + 1))
          {
            if (((d)localObject1).eUd <= 8192L)
            {
              y.i("MicroMsg.Music.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
              ((d)localObject1).count = 1;
            }
            y.i("MicroMsg.Music.IndexBitMgr", "fileLength:%d, count:%d", new Object[] { Long.valueOf(((d)localObject1).eUd), Integer.valueOf(((d)localObject1).count) });
            ((d)localObject1).myc = new BitSet(((d)localObject1).count);
            ((d)localObject1).bSB = g.Jm(((d)localObject1).mUrl);
            if (!TextUtils.isEmpty(((d)localObject1).bSB)) {
              break label760;
            }
            y.e("MicroMsg.Music.IndexBitMgr", "initData musicId is null!'");
            break;
          }
          label760:
          y.i("MicroMsg.Music.IndexBitMgr", "musicId:%s", new Object[] { ((d)localObject1).bSB });
          localObject2 = e.Jg(((d)localObject1).bSB);
          if (localObject2 == null)
          {
            y.e("MicroMsg.Music.IndexBitMgr", "initData pMusic is null!'");
          }
          else
          {
            y.i("MicroMsg.Music.IndexBitMgr", "initData music field_fileCacheComplete:%d", new Object[] { Integer.valueOf(((com.tencent.mm.av.h)localObject2).euZ) });
            if ((((com.tencent.mm.av.h)localObject2).euY == null) || (((com.tencent.mm.av.h)localObject2).euY.length == 0))
            {
              y.e("MicroMsg.Music.IndexBitMgr", "initData field_indexBitData is null!'");
            }
            else
            {
              ((d)localObject1).myc = d.a.aE(((com.tencent.mm.av.h)localObject2).euY);
              if (((d)localObject1).myc == null)
              {
                y.e("MicroMsg.Music.IndexBitMgr", "initData bitSet is null");
                ((d)localObject1).myc = new BitSet(((d)localObject1).count);
              }
              for (;;)
              {
                y.i("MicroMsg.Music.IndexBitMgr", "initData bitSet:" + ((d)localObject1).myc.toString());
                y.i("MicroMsg.Music.IndexBitMgr", "initData bitSet count %d, cardinality:" + ((d)localObject1).count + "," + ((d)localObject1).myc.cardinality());
                break;
                if (((d)localObject1).count < ((d)localObject1).myc.cardinality())
                {
                  y.e("MicroMsg.Music.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", new Object[] { Integer.valueOf(((d)localObject1).count), Integer.valueOf(((d)localObject1).myc.cardinality()) });
                  ((d)localObject1).clearCache();
                }
              }
              label1047:
              if ((paramURL.mxW.bmN() != paramURL.mxU.getSize()) && (paramURL.mxU.getSize() != -1L))
              {
                y.i("MicroMsg.Music.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
                paramURL.mxV.clearCache();
                localObject1 = paramURL.mxW;
                Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile");
                com.tencent.mm.plugin.music.cache.h.deleteFile(((com.tencent.mm.plugin.music.cache.h)localObject1).fileName);
              }
              else if (paramURL.mxU.getSize() == -1L)
              {
                y.i("MicroMsg.Music.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
              }
              else
              {
                y.i("MicroMsg.Music.FileBytesCacheMgr", "piece file exist!");
              }
            }
          }
        }
      }
    }
  }
  
  public final void disconnect()
  {
    Logger.i("MicroMsg.MMMediaHTTPConnection", "disconnect");
    teardownConnection();
    this.mHeaders = null;
    this.mURL = null;
    if (this.mBa != null)
    {
      com.tencent.mm.plugin.music.cache.a locala = this.mBa;
      locala.bmG();
      locala.mxV.bmL();
      locala.mxW.close();
      locala.mxU = null;
      y.i("MicroMsg.Music.FileBytesCacheMgr", "detach()");
      this.mBa = null;
    }
  }
  
  public final String getMIMEType()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.mMimeType))
    {
      Logger.i("MicroMsg.MMMediaHTTPConnection", "getMIMEType mimeType:" + this.mMimeType);
      localObject = this.mMimeType;
      return localObject;
    }
    String str1 = g.Jp(this.mBb.toString());
    if (!TextUtils.isEmpty(str1))
    {
      this.mMimeType = str1;
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
        y.d("MicroMsg.MMMediaHTTPConnection", "getMIMEType cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        this.mMimeType = str1;
        localObject = str1;
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
        str1 = g.Jo(this.mBb.toString());
        this.mMimeType = str1;
        localObject = str1;
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
        return "application/octet-stream";
      }
      catch (IOException localIOException)
      {
        Logger.e("MicroMsg.MMMediaHTTPConnection", "getMIMEType exception:%s", new Object[] { String.valueOf(localIOException) });
        str2 = "";
        continue;
      }
      long l = System.currentTimeMillis();
      String str2 = this.mConnection.getContentType();
      Logger.i("MicroMsg.MMMediaHTTPConnection", "getMIMEType mimeType:" + str2);
      y.d("MicroMsg.MMMediaHTTPConnection", "getMIMEType cost time2 :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  public final long getSize()
  {
    long l1 = -1L;
    if (this.mTotalSize > 0L) {
      l1 = this.mTotalSize;
    }
    do
    {
      return l1;
      if (g.Jq(this.mBb.toString()) > 0L)
      {
        this.mTotalSize = g.Jq(this.mBb.toString());
        return this.mTotalSize;
      }
      if (this.mConnection == null) {}
      try
      {
        long l2 = System.currentTimeMillis();
        seekTo(0L);
        y.d("MicroMsg.MMMediaHTTPConnection", "getSize cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
        if (this.mTotalSize > 0L) {
          return this.mTotalSize;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Logger.e("MicroMsg.MMMediaHTTPConnection", "getSize exception:%s", new Object[] { String.valueOf(localIOException) });
          this.mTotalSize = -1L;
        }
      }
    } while (g.Jr(this.mBb.toString()) <= 0L);
    this.mTotalSize = g.Jr(this.mBb.toString());
    return this.mTotalSize;
  }
  
  public final String getUri()
  {
    return this.mURL.toString();
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 > this.mBc.length) {
      this.mBc = new byte[paramInt2];
    }
    Arrays.fill(this.mBc, 0, this.mBc.length, (byte)0);
    for (;;)
    {
      Object localObject;
      int j;
      try
      {
        if (this.mBa == null) {
          continue;
        }
        localObject = this.mBa;
        arrayOfByte = this.mBc;
        j = (int)paramLong;
        if ((arrayOfByte != null) && (j >= 0) && (paramInt2 >= 0)) {
          continue;
        }
        y.e("MicroMsg.Music.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2) });
      }
      catch (ProtocolException paramArrayOfByte)
      {
        byte[] arrayOfByte;
        Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.cb(this.mBb.toString(), 750);
        return -1010;
        i = j + paramInt2;
        l = i;
        if (l <= ((com.tencent.mm.plugin.music.cache.a)localObject).mxU.getSize()) {
          break label1122;
        }
        y.e("MicroMsg.Music.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(((com.tencent.mm.plugin.music.cache.a)localObject).mxU.getSize()) });
        i = (int)((com.tencent.mm.plugin.music.cache.a)localObject).mxU.getSize() - j;
        if (!((com.tencent.mm.plugin.music.cache.a)localObject).mxV.dn(j, i)) {
          break label1129;
        }
        i = ((com.tencent.mm.plugin.music.cache.a)localObject).mxW.b(arrayOfByte, j, i);
        continue;
        if ((this.mTotalSize <= 0L) || (paramLong < this.mTotalSize) || (paramInt2 <= 0)) {
          continue;
        }
        y.e("MicroMsg.MMMediaHTTPConnection", "offset is illegal, mTotalSize:%d, offset:%d, size:%d", new Object[] { Long.valueOf(this.mTotalSize), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
        return 0;
        Logger.d("MicroMsg.MMMediaHTTPConnection", "read from network");
        if (paramLong == this.mCurrentOffset) {
          continue;
        }
        seekTo(paramLong);
        i = this.mInputStream.read(this.mBc, 0, paramInt2);
        if (i != -1) {
          continue;
        }
        paramInt1 = 0;
        this.mCurrentOffset += paramInt1;
        if (this.mBa == null) {
          break;
        }
        paramArrayOfByte = this.mBa;
        localObject = this.mBc;
        i = (int)paramLong;
        if ((localObject != null) && (i >= 0) && (paramInt1 >= 0)) {
          continue;
        }
        y.e("MicroMsg.Music.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        return paramInt1;
      }
      catch (NoRouteToHostException paramArrayOfByte)
      {
        Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.cb(this.mBb.toString(), 751);
        return -1010;
        System.arraycopy(this.mBc, 0, paramArrayOfByte, paramInt1, i);
        paramInt1 = i;
        continue;
      }
      catch (UnknownServiceException paramArrayOfByte)
      {
        Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => " + paramArrayOfByte);
        g.cb(this.mBb.toString(), 752);
        return -1010;
        if (paramArrayOfByte.mxU.getSize() > 0L) {
          continue;
        }
        y.e("MicroMsg.Music.FileBytesCacheMgr", "write() fileLength is error, file length is " + paramArrayOfByte.mxU.getSize());
        return paramInt1;
      }
      catch (IOException paramArrayOfByte)
      {
        Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => -1 " + paramArrayOfByte);
        g.cb(this.mBb.toString(), 753);
        return -1;
        j = i + paramInt1;
        l = j;
        if (l <= paramArrayOfByte.mxU.getSize()) {
          break label963;
        }
        y.e("MicroMsg.Music.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", new Object[] { Integer.valueOf(j), Long.valueOf(paramArrayOfByte.mxU.getSize()) });
        return paramInt1;
      }
      catch (Exception paramArrayOfByte)
      {
        Logger.e("MicroMsg.MMMediaHTTPConnection", "unknown exception " + paramArrayOfByte);
        Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + paramLong + " / " + paramInt2 + " => -1");
        g.cb(this.mBb.toString(), 754);
        return -1;
      }
      if (i > 0)
      {
        if (i != paramInt2) {
          Logger.i("MicroMsg.MMMediaHTTPConnection", "read from cache, n%d, size %d " + i + "," + paramInt2);
        }
        System.arraycopy(this.mBc, 0, paramArrayOfByte, paramInt1, i);
        return i;
        if (((com.tencent.mm.plugin.music.cache.a)localObject).mxU.getSize() <= 0L)
        {
          y.e("MicroMsg.Music.FileBytesCacheMgr", "read(), fileLength is error, file length is " + ((com.tencent.mm.plugin.music.cache.a)localObject).mxU.getSize());
          break label1129;
        }
      }
      label963:
      long l = j;
      if (l == paramArrayOfByte.mxU.getSize())
      {
        paramArrayOfByte.bmG();
        paramArrayOfByte.uB(i);
        paramArrayOfByte.r((byte[])localObject, i, paramInt1);
        paramArrayOfByte.bmG();
        paramArrayOfByte.uB(i);
        return paramInt1;
      }
      if ((paramArrayOfByte.uz(i)) && (paramArrayOfByte.uz(j)))
      {
        if ((paramArrayOfByte.uA(i)) && (paramArrayOfByte.uA(j))) {
          break;
        }
        if (paramArrayOfByte.uA(i))
        {
          paramArrayOfByte.r((byte[])localObject, i, paramInt1);
          return paramInt1;
        }
        paramArrayOfByte.bmG();
        paramArrayOfByte.uB(i);
        paramArrayOfByte.r((byte[])localObject, i, paramInt1);
        return paramInt1;
      }
      paramArrayOfByte.bmG();
      paramArrayOfByte.uB(i);
      paramArrayOfByte.r((byte[])localObject, i, paramInt1);
      return paramInt1;
      label1122:
      int i = paramInt2;
      continue;
      label1129:
      i = -1;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a.a
 * JD-Core Version:    0.7.0.1
 */