import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.BytesBufferPool.BytesBuffer;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLState;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.util.SecurityUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;

public class aglb
{
  private static aglb jdField_a_of_type_Aglb;
  private static aglc jdField_a_of_type_Aglc;
  private static final BytesBufferPool jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool = new BytesBufferPool(4, 204800);
  private static ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  Context jdField_a_of_type_AndroidContentContext;
  bggn jdField_a_of_type_Bggn;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  
  private aglb(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    a(paramContext);
  }
  
  public static aglb a(Context paramContext)
  {
    if (jdField_a_of_type_Aglb != null) {
      return jdField_a_of_type_Aglb;
    }
    try
    {
      if (jdField_a_of_type_Aglb == null)
      {
        jdField_a_of_type_Aglb = new aglb(paramContext);
        if (Build.BRAND.equals("Sony")) {
          jdField_a_of_type_Aglb.jdField_a_of_type_Boolean = true;
        }
      }
      paramContext = jdField_a_of_type_Aglb;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	aglb:jdField_a_of_type_Bggn	Lbggn;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 67	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   21: getstatic 73	ajsd:ba	Ljava/lang/String;
    //   24: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 79
    //   29: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 81
    //   34: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: new 87	java/io/File
    //   44: dup
    //   45: new 67	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   52: getstatic 73	ajsd:ba	Ljava/lang/String;
    //   55: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 79
    //   60: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 94	java/io/File:exists	()Z
    //   74: ifne +8 -> 82
    //   77: aload_2
    //   78: invokevirtual 97	java/io/File:mkdirs	()Z
    //   81: pop
    //   82: aload_0
    //   83: new 99	bggn
    //   86: dup
    //   87: aload_1
    //   88: sipush 2500
    //   91: ldc 100
    //   93: iconst_0
    //   94: iconst_1
    //   95: invokespecial 103	bggn:<init>	(Ljava/lang/String;IIZI)V
    //   98: putfield 65	aglb:jdField_a_of_type_Bggn	Lbggn;
    //   101: goto -90 -> 11
    //   104: astore_1
    //   105: ldc 105
    //   107: iconst_2
    //   108: ldc 107
    //   110: aload_1
    //   111: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: goto -103 -> 11
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	aglb
    //   0	122	1	paramContext	Context
    //   69	9	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   41	82	104	java/lang/Exception
    //   82	101	104	java/lang/Exception
    //   2	7	117	finally
    //   14	41	117	finally
    //   41	82	117	finally
    //   82	101	117	finally
    //   105	114	117	finally
  }
  
  private boolean a(byte[] paramArrayOfByte, long paramLong, BytesBufferPool.BytesBuffer paramBytesBuffer)
  {
    if (paramArrayOfByte == null) {}
    bggo localbggo;
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_Bggn != null) {
          break;
        }
        a(this.jdField_a_of_type_AndroidContentContext);
      } while (this.jdField_a_of_type_Bggn == null);
      try
      {
        localbggo = new bggo();
        localbggo.jdField_a_of_type_Long = paramLong;
        localbggo.jdField_a_of_type_ArrayOfByte = paramBytesBuffer.data;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (!this.jdField_a_of_type_Bggn.a(localbggo)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!a(paramArrayOfByte, localbggo.jdField_a_of_type_ArrayOfByte));
    paramBytesBuffer.data = localbggo.jdField_a_of_type_ArrayOfByte;
    paramBytesBuffer.offset = paramArrayOfByte.length;
    paramBytesBuffer.length = (localbggo.jdField_a_of_type_Int - paramBytesBuffer.offset);
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = paramArrayOfByte1.length;
    if (paramArrayOfByte2.length < j) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label34;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label34:
    return true;
  }
  
  private static byte[] a(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(65536);
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public Bitmap a(URL paramURL, aywy paramaywy)
  {
    return a(paramURL, paramaywy, null);
  }
  
  public Bitmap a(URL paramURL, aywy paramaywy, DownloadParams paramDownloadParams)
  {
    Object localObject1;
    if (this.jdField_a_of_type_Boolean) {
      if ((paramDownloadParams != null) && ((paramDownloadParams.tag instanceof LocalMediaInfo)))
      {
        localObject1 = (LocalMediaInfo)paramDownloadParams.tag;
        localObject1 = "" + ((LocalMediaInfo)localObject1).modifiedDate;
        if (!((String)localObject1).equals(""))
        {
          ??? = localObject1;
          if (!((String)localObject1).equals("0")) {}
        }
        else
        {
          localObject1 = new File(paramURL.getPath());
        }
      }
    }
    for (??? = "" + ((File)localObject1).length();; ??? = "")
    {
      ??? = SecurityUtil.a(paramURL.toString() + (String)???);
      localObject1 = jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.get();
      long l1 = SystemClock.uptimeMillis();
      long l2 = SecurityUtil.a((byte[])???);
      try
      {
        if (!a((byte[])???, l2, (BytesBufferPool.BytesBuffer)localObject1))
        {
          paramaywy = paramaywy.a(paramURL);
          if (paramaywy == null) {
            break label713;
          }
          paramDownloadParams = a(paramaywy, 70);
          ByteBuffer localByteBuffer = ByteBuffer.allocate(???.length + paramDownloadParams.length);
          localByteBuffer.put((byte[])???);
          localByteBuffer.put(paramDownloadParams);
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            try
            {
              this.jdField_a_of_type_Bggn.a(l2, localByteBuffer.array());
              if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb"))) {
                QLog.d("AlbumThumbManager", 2, "getThumb bitmap from cache,url:" + paramURL + " cost:" + (SystemClock.uptimeMillis() - l1) + " sizeDisk:" + paramDownloadParams.length + " sizeMemory:" + paramaywy.getByteCount());
              }
              return paramaywy;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                QLog.e("AlbumThumbManager", 2, "decode thumb ioexception", localIOException);
              }
            }
          }
        }
        label713:
        localObject1 = "";
      }
      catch (OutOfMemoryError paramaywy)
      {
        QLog.e("AlbumThumbManager", 2, "decode thumb", paramaywy);
        if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb"))) {
          QLog.d("AlbumThumbManager", 2, "getThumb bitmap OutOfMemoryError,url:" + paramURL + " cost:" + (SystemClock.uptimeMillis() - l1));
        }
        return null;
        paramaywy = new BitmapFactory.Options();
        paramaywy.inPreferredConfig = Bitmap.Config.RGB_565;
        if (paramDownloadParams == null) {}
        for (paramaywy.inSampleSize = 1;; paramaywy.inSampleSize = URLState.calculateInSampleSize(paramaywy, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight))
        {
          paramaywy = SafeBitmapFactory.decodeByteArray(((BytesBufferPool.BytesBuffer)localObject1).data, ((BytesBufferPool.BytesBuffer)localObject1).offset, ((BytesBufferPool.BytesBuffer)localObject1).length, paramaywy);
          if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb"))) {
            QLog.d("AlbumThumbManager", 2, "getThumb bitmap from decode,url:" + paramURL + " cost:" + (SystemClock.uptimeMillis() - l1) + " sizeDisk:" + ((BytesBufferPool.BytesBuffer)localObject1).length + " sizeMemory:" + paramaywy.getByteCount());
          }
          return paramaywy;
          paramaywy.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeByteArray(((BytesBufferPool.BytesBuffer)localObject1).data, ((BytesBufferPool.BytesBuffer)localObject1).offset, ((BytesBufferPool.BytesBuffer)localObject1).length, paramaywy);
          paramaywy.inJustDecodeBounds = false;
        }
      }
      catch (Throwable paramaywy)
      {
        for (;;)
        {
          QLog.e("AlbumThumbManager", 2, "decode thumb", paramaywy);
          if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb"))) {
            QLog.d("AlbumThumbManager", 2, "getThumb bitmap Throwable,url:" + paramURL + " cost:" + (SystemClock.uptimeMillis() - l1));
          }
          jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.recycle((BytesBufferPool.BytesBuffer)localObject1);
          continue;
          jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.recycle((BytesBufferPool.BytesBuffer)localObject1);
        }
      }
      finally
      {
        jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.recycle((BytesBufferPool.BytesBuffer)localObject1);
      }
      break;
    }
  }
  
  public void a()
  {
    try
    {
      jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.clear();
      jdField_a_of_type_Aglc = null;
      jdField_a_of_type_JavaNioByteBuffer = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aglb
 * JD-Core Version:    0.7.0.1
 */