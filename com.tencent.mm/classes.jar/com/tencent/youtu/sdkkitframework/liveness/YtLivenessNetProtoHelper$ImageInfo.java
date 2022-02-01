package com.tencent.youtu.sdkkitframework.liveness;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class YtLivenessNetProtoHelper$ImageInfo
{
  public String checksum;
  public ArrayList<Float> five_points;
  public String image;
  
  public YtLivenessNetProtoHelper$ImageInfo(String paramString1, ArrayList<Float> paramArrayList, String paramString2)
  {
    this.image = paramString1;
    this.five_points = paramArrayList;
    this.checksum = paramString2;
  }
  
  public YtLivenessNetProtoHelper$ImageInfo(byte[] paramArrayOfByte, float[] paramArrayOfFloat, String paramString)
  {
    AppMethodBeat.i(247503);
    this.image = new String(Base64.encode(paramArrayOfByte, 2));
    this.five_points = new ArrayList();
    this.checksum = paramString;
    if (paramArrayOfFloat != null)
    {
      this.five_points.add(Float.valueOf(paramArrayOfFloat['°']));
      this.five_points.add(Float.valueOf(paramArrayOfFloat['±']));
      this.five_points.add(Float.valueOf(paramArrayOfFloat['²']));
      this.five_points.add(Float.valueOf(paramArrayOfFloat['³']));
      this.five_points.add(Float.valueOf(paramArrayOfFloat[64]));
      this.five_points.add(Float.valueOf(paramArrayOfFloat[65]));
      this.five_points.add(Float.valueOf(paramArrayOfFloat[90]));
      this.five_points.add(Float.valueOf(paramArrayOfFloat[91]));
      this.five_points.add(Float.valueOf(paramArrayOfFloat[102]));
      this.five_points.add(Float.valueOf(paramArrayOfFloat[103]));
    }
    AppMethodBeat.o(247503);
  }
  
  /* Error */
  private void createFileWithByte(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 69
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 71	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 78	java/io/File:exists	()Z
    //   18: ifeq +8 -> 26
    //   21: aload_1
    //   22: invokevirtual 81	java/io/File:delete	()Z
    //   25: pop
    //   26: aload_1
    //   27: invokevirtual 84	java/io/File:createNewFile	()Z
    //   30: pop
    //   31: new 86	java/io/FileOutputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore_3
    //   40: new 91	java/io/BufferedOutputStream
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 94	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   48: astore_1
    //   49: aload_1
    //   50: aload_2
    //   51: invokevirtual 97	java/io/BufferedOutputStream:write	([B)V
    //   54: aload_1
    //   55: invokevirtual 100	java/io/BufferedOutputStream:flush	()V
    //   58: aload_3
    //   59: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   62: aload_1
    //   63: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   66: ldc 69
    //   68: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: return
    //   72: astore_1
    //   73: ldc 69
    //   75: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_3
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   92: aload_1
    //   93: ifnull +48 -> 141
    //   96: aload_1
    //   97: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   100: ldc 69
    //   102: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: return
    //   106: astore_1
    //   107: ldc 69
    //   109: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: return
    //   113: astore_1
    //   114: aconst_null
    //   115: astore_2
    //   116: aconst_null
    //   117: astore_3
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   134: ldc 69
    //   136: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: athrow
    //   141: ldc 69
    //   143: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	191	0	this	ImageInfo
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.YtLivenessNetProtoHelper.ImageInfo
 * JD-Core Version:    0.7.0.1
 */