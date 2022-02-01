package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectImage;
import java.util.ArrayList;

public class YTImageInfo
{
  public String checksum;
  public ArrayList<Float> five_points;
  public String image;
  
  public YTImageInfo(YTActReflectImage paramYTActReflectImage)
  {
    AppMethodBeat.i(43382);
    this.image = new String(Base64.encode(paramYTActReflectImage.image, 2));
    this.checksum = paramYTActReflectImage.checksum;
    this.five_points = new ArrayList();
    if (paramYTActReflectImage.xys != null)
    {
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys['°']));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys['±']));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys['²']));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys['³']));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[64]));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[65]));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[90]));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[91]));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[102]));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[103]));
    }
    AppMethodBeat.o(43382);
  }
  
  /* Error */
  private void createFileWithByte(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 73
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 75	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 82	java/io/File:exists	()Z
    //   18: ifeq +8 -> 26
    //   21: aload_1
    //   22: invokevirtual 85	java/io/File:delete	()Z
    //   25: pop
    //   26: aload_1
    //   27: invokevirtual 88	java/io/File:createNewFile	()Z
    //   30: pop
    //   31: new 90	java/io/FileOutputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore_3
    //   40: new 95	java/io/BufferedOutputStream
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 98	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   48: astore_1
    //   49: aload_1
    //   50: aload_2
    //   51: invokevirtual 101	java/io/BufferedOutputStream:write	([B)V
    //   54: aload_1
    //   55: invokevirtual 104	java/io/BufferedOutputStream:flush	()V
    //   58: aload_3
    //   59: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   62: aload_1
    //   63: invokevirtual 108	java/io/BufferedOutputStream:close	()V
    //   66: ldc 73
    //   68: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: return
    //   72: astore_1
    //   73: ldc 73
    //   75: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_3
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   92: aload_1
    //   93: ifnull +48 -> 141
    //   96: aload_1
    //   97: invokevirtual 108	java/io/BufferedOutputStream:close	()V
    //   100: ldc 73
    //   102: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: return
    //   106: astore_1
    //   107: ldc 73
    //   109: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: return
    //   113: astore_1
    //   114: aconst_null
    //   115: astore_2
    //   116: aconst_null
    //   117: astore_3
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 108	java/io/BufferedOutputStream:close	()V
    //   134: ldc 73
    //   136: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: athrow
    //   141: ldc 73
    //   143: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: return
    //   147: astore_2
    //   148: goto -86 -> 62
    //   151: astore_2
    //   152: goto -60 -> 92
    //   155: astore_3
    //   156: goto -30 -> 126
    //   159: astore_2
    //   160: goto -26 -> 134
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_2
    //   166: goto -48 -> 118
    //   169: astore_2
    //   170: aload_1
    //   171: astore 4
    //   173: aload_2
    //   174: astore_1
    //   175: aload 4
    //   177: astore_2
    //   178: goto -60 -> 118
    //   181: astore_1
    //   182: aconst_null
    //   183: astore_1
    //   184: goto -100 -> 84
    //   187: astore_2
    //   188: goto -104 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	YTImageInfo
    //   0	191	1	paramString	String
    //   0	191	2	paramArrayOfByte	byte[]
    //   39	84	3	localFileOutputStream	java.io.FileOutputStream
    //   155	1	3	localIOException	java.io.IOException
    //   171	5	4	str	String
    // Exception table:
    //   from	to	target	type
    //   62	66	72	java/lang/Exception
    //   14	26	79	java/lang/Exception
    //   26	40	79	java/lang/Exception
    //   96	100	106	java/lang/Exception
    //   14	26	113	finally
    //   26	40	113	finally
    //   58	62	147	java/io/IOException
    //   88	92	151	java/io/IOException
    //   122	126	155	java/io/IOException
    //   130	134	159	java/lang/Exception
    //   40	49	163	finally
    //   49	58	169	finally
    //   40	49	181	java/lang/Exception
    //   49	58	187	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo
 * JD-Core Version:    0.7.0.1
 */