import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class agvk
{
  private static agvk a;
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + File.separator + "aio_lightalk_tips_config";
  public static final String c = jdField_a_of_type_JavaLangString + File.separator + "aio_lightalk_tips_icon";
  public String d;
  public String e;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "lightalkfiles";
  }
  
  public static agvk a()
  {
    long l1 = SystemClock.uptimeMillis();
    a();
    long l2 = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("read config cost ").append(l2 - l1).append(" , result is ");
      if (jdField_a_of_type_Agvk != null) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("LightalkBlueTipsBar", 2, bool);
      return jdField_a_of_type_Agvk;
    }
  }
  
  /* Error */
  private static void a()
  {
    // Byte code:
    //   0: getstatic 84	agvk:jdField_a_of_type_Agvk	Lagvk;
    //   3: ifnull +4 -> 7
    //   6: return
    //   7: new 36	java/io/File
    //   10: dup
    //   11: getstatic 54	agvk:b	Ljava/lang/String;
    //   14: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: new 36	java/io/File
    //   21: dup
    //   22: getstatic 58	agvk:c	Ljava/lang/String;
    //   25: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_0
    //   30: invokevirtual 102	java/io/File:exists	()Z
    //   33: ifeq +204 -> 237
    //   36: aload_0
    //   37: invokevirtual 105	java/io/File:length	()J
    //   40: lconst_0
    //   41: lcmp
    //   42: ifle +195 -> 237
    //   45: aload_1
    //   46: invokevirtual 102	java/io/File:exists	()Z
    //   49: ifeq +188 -> 237
    //   52: new 107	java/io/FileInputStream
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: invokevirtual 114	java/io/FileInputStream:available	()I
    //   67: newarray byte
    //   69: astore_2
    //   70: aload_1
    //   71: astore_0
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 118	java/io/FileInputStream:read	([B)I
    //   77: pop
    //   78: aload_1
    //   79: astore_0
    //   80: new 120	java/lang/String
    //   83: dup
    //   84: aload_2
    //   85: ldc 122
    //   87: invokespecial 125	java/lang/String:<init>	([BLjava/lang/String;)V
    //   90: ldc 127
    //   92: invokevirtual 131	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   95: astore_2
    //   96: aload_1
    //   97: astore_0
    //   98: aload_2
    //   99: arraylength
    //   100: iconst_2
    //   101: if_icmpne +37 -> 138
    //   104: aload_1
    //   105: astore_0
    //   106: new 2	agvk
    //   109: dup
    //   110: invokespecial 132	agvk:<init>	()V
    //   113: putstatic 84	agvk:jdField_a_of_type_Agvk	Lagvk;
    //   116: aload_1
    //   117: astore_0
    //   118: getstatic 84	agvk:jdField_a_of_type_Agvk	Lagvk;
    //   121: aload_2
    //   122: iconst_0
    //   123: aaload
    //   124: putfield 134	agvk:d	Ljava/lang/String;
    //   127: aload_1
    //   128: astore_0
    //   129: getstatic 84	agvk:jdField_a_of_type_Agvk	Lagvk;
    //   132: aload_2
    //   133: iconst_1
    //   134: aaload
    //   135: putfield 136	agvk:e	Ljava/lang/String;
    //   138: aload_1
    //   139: ifnull -133 -> 6
    //   142: aload_1
    //   143: invokevirtual 139	java/io/FileInputStream:close	()V
    //   146: return
    //   147: astore_0
    //   148: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq -145 -> 6
    //   154: ldc 86
    //   156: iconst_2
    //   157: ldc 141
    //   159: aload_0
    //   160: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   163: return
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_1
    //   167: aload_1
    //   168: astore_0
    //   169: aload_2
    //   170: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   173: aload_1
    //   174: astore_0
    //   175: aconst_null
    //   176: putstatic 84	agvk:jdField_a_of_type_Agvk	Lagvk;
    //   179: aload_1
    //   180: ifnull -174 -> 6
    //   183: aload_1
    //   184: invokevirtual 139	java/io/FileInputStream:close	()V
    //   187: return
    //   188: astore_0
    //   189: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -186 -> 6
    //   195: ldc 86
    //   197: iconst_2
    //   198: ldc 141
    //   200: aload_0
    //   201: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   204: return
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_0
    //   208: aload_0
    //   209: ifnull +7 -> 216
    //   212: aload_0
    //   213: invokevirtual 139	java/io/FileInputStream:close	()V
    //   216: aload_1
    //   217: athrow
    //   218: astore_0
    //   219: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq -6 -> 216
    //   225: ldc 86
    //   227: iconst_2
    //   228: ldc 141
    //   230: aload_0
    //   231: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: goto -18 -> 216
    //   237: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq -234 -> 6
    //   243: ldc 86
    //   245: iconst_2
    //   246: ldc 149
    //   248: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: return
    //   252: astore_1
    //   253: goto -45 -> 208
    //   256: astore_2
    //   257: goto -90 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	112	0	localObject1	Object
    //   147	13	0	localIOException1	java.io.IOException
    //   168	7	0	localObject2	Object
    //   188	13	0	localIOException2	java.io.IOException
    //   207	6	0	localObject3	Object
    //   218	13	0	localIOException3	java.io.IOException
    //   28	156	1	localObject4	Object
    //   205	12	1	localObject5	Object
    //   252	1	1	localObject6	Object
    //   69	64	2	localObject7	Object
    //   164	6	2	localException1	java.lang.Exception
    //   256	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   142	146	147	java/io/IOException
    //   52	61	164	java/lang/Exception
    //   183	187	188	java/io/IOException
    //   52	61	205	finally
    //   212	216	218	java/io/IOException
    //   63	70	252	finally
    //   72	78	252	finally
    //   80	96	252	finally
    //   98	104	252	finally
    //   106	116	252	finally
    //   118	127	252	finally
    //   129	138	252	finally
    //   169	173	252	finally
    //   175	179	252	finally
    //   63	70	256	java/lang/Exception
    //   72	78	256	java/lang/Exception
    //   80	96	256	java/lang/Exception
    //   98	104	256	java/lang/Exception
    //   106	116	256	java/lang/Exception
    //   118	127	256	java/lang/Exception
    //   129	138	256	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvk
 * JD-Core Version:    0.7.0.1
 */