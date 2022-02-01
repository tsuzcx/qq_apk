import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.tensorflow.lite.Interpreter;

public abstract class alhb
{
  public List<String> a;
  protected Interpreter a;
  
  public alhb(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_OrgTensorflowLiteInterpreter = new Interpreter(a(paramString1));
    if ((!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists()))
    {
      paramString1 = new BufferedReader(new FileReader(paramString2));
      try
      {
        for (;;)
        {
          paramString2 = paramString1.readLine();
          if (paramString2 == null) {
            break;
          }
          paramString2 = paramString2.split(",")[0];
          this.jdField_a_of_type_JavaUtilList.add(paramString2);
        }
      }
      catch (Throwable paramString2)
      {
        throw paramString2;
      }
      finally
      {
        paramString1.close();
      }
    }
  }
  
  /* Error */
  private java.nio.MappedByteBuffer a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 38	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 7
    //   16: new 77	java/io/FileInputStream
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 84	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   32: astore_1
    //   33: aload 7
    //   35: invokevirtual 88	java/io/File:length	()J
    //   38: lstore_2
    //   39: aload_1
    //   40: getstatic 94	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   43: lconst_0
    //   44: lload_2
    //   45: invokevirtual 100	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   48: astore 5
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 101	java/nio/channels/FileChannel:close	()V
    //   58: aload 4
    //   60: ifnull +8 -> 68
    //   63: aload 4
    //   65: invokevirtual 102	java/io/FileInputStream:close	()V
    //   68: aload 5
    //   70: areturn
    //   71: astore 5
    //   73: aconst_null
    //   74: astore_1
    //   75: aload 6
    //   77: astore 4
    //   79: aload 5
    //   81: athrow
    //   82: astore 7
    //   84: aload_1
    //   85: astore 6
    //   87: aload 4
    //   89: astore 5
    //   91: aload 7
    //   93: astore_1
    //   94: aload 5
    //   96: ifnull +8 -> 104
    //   99: aload 5
    //   101: invokevirtual 101	java/nio/channels/FileChannel:close	()V
    //   104: aload 6
    //   106: ifnull +8 -> 114
    //   109: aload 6
    //   111: invokevirtual 102	java/io/FileInputStream:close	()V
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: aconst_null
    //   118: astore 6
    //   120: goto -26 -> 94
    //   123: astore_1
    //   124: aload 4
    //   126: astore 6
    //   128: goto -34 -> 94
    //   131: astore 6
    //   133: aload_1
    //   134: astore 5
    //   136: aload 6
    //   138: astore_1
    //   139: aload 4
    //   141: astore 6
    //   143: goto -49 -> 94
    //   146: astore 5
    //   148: aload 4
    //   150: astore_1
    //   151: aload 6
    //   153: astore 4
    //   155: goto -76 -> 79
    //   158: astore 5
    //   160: aload 4
    //   162: astore 6
    //   164: aload_1
    //   165: astore 4
    //   167: aload 6
    //   169: astore_1
    //   170: goto -91 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	alhb
    //   0	173	1	paramString	String
    //   38	7	2	l	long
    //   25	141	4	localObject1	Object
    //   1	68	5	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   71	9	5	localThrowable1	Throwable
    //   89	46	5	localObject2	Object
    //   146	1	5	localThrowable2	Throwable
    //   158	1	5	localThrowable3	Throwable
    //   4	123	6	localObject3	Object
    //   131	6	6	localObject4	Object
    //   141	27	6	localObject5	Object
    //   14	20	7	localFile	File
    //   82	10	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   6	27	71	java/lang/Throwable
    //   79	82	82	finally
    //   6	27	116	finally
    //   27	33	123	finally
    //   33	50	131	finally
    //   27	33	146	java/lang/Throwable
    //   33	50	158	java/lang/Throwable
  }
  
  public abstract String a();
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_OrgTensorflowLiteInterpreter != null) {
        this.jdField_a_of_type_OrgTensorflowLiteInterpreter.close();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public abstract boolean a(agpd paramagpd, String paramString, float paramFloat1, int paramInt, float paramFloat2);
  
  public float[] a(float[][][][] paramArrayOfFloat)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return null;
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { 1, i });
    this.jdField_a_of_type_OrgTensorflowLiteInterpreter.run(paramArrayOfFloat, arrayOfFloat);
    return arrayOfFloat[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhb
 * JD-Core Version:    0.7.0.1
 */