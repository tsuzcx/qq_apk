import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;

class ajrx
  extends AsyncTask<Integer, Void, Bitmap>
{
  private int jdField_a_of_type_Int;
  private WeakReference<ajrw> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ajrx(ajrw paramajrw, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramajrw);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  protected Bitmap a(Integer... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 21	ajrx:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   6: invokevirtual 33	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   9: checkcast 35	ajrw
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull +317 -> 331
    //   17: aload_1
    //   18: ifnull +313 -> 331
    //   21: aload_1
    //   22: arraylength
    //   23: ifle +308 -> 331
    //   26: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +30 -> 59
    //   32: ldc 43
    //   34: iconst_2
    //   35: new 45	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   42: ldc 48
    //   44: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: iconst_0
    //   49: aaload
    //   50: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: new 45	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   66: aload_3
    //   67: getfield 66	ajrw:a	Ljava/lang/String;
    //   70: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: iconst_0
    //   75: aaload
    //   76: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_1
    //   83: iconst_0
    //   84: ifne +240 -> 324
    //   87: new 68	java/io/BufferedInputStream
    //   90: dup
    //   91: new 70	java/io/FileInputStream
    //   94: dup
    //   95: aload_1
    //   96: invokespecial 73	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   99: invokespecial 76	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   102: astore_1
    //   103: aload_1
    //   104: astore_2
    //   105: aload_1
    //   106: invokestatic 82	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   109: astore_3
    //   110: aload_3
    //   111: astore_2
    //   112: aload_1
    //   113: astore_3
    //   114: aload_2
    //   115: astore_1
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   124: aload_1
    //   125: areturn
    //   126: astore_2
    //   127: ldc 43
    //   129: iconst_1
    //   130: new 45	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   137: ldc 87
    //   139: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_2
    //   143: invokevirtual 90	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_1
    //   156: areturn
    //   157: astore_3
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: astore_2
    //   162: ldc 43
    //   164: iconst_1
    //   165: aload_3
    //   166: invokevirtual 94	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   169: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_1
    //   173: ifnull +7 -> 180
    //   176: aload_1
    //   177: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_1
    //   183: ldc 43
    //   185: iconst_1
    //   186: new 45	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   193: ldc 87
    //   195: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_1
    //   199: invokevirtual 90	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   202: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_1
    //   216: aload_1
    //   217: astore_2
    //   218: ldc 43
    //   220: iconst_1
    //   221: aload_3
    //   222: invokevirtual 90	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   225: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   236: aconst_null
    //   237: areturn
    //   238: astore_1
    //   239: ldc 43
    //   241: iconst_1
    //   242: new 45	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   249: ldc 87
    //   251: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_1
    //   255: invokevirtual 90	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aconst_null
    //   268: areturn
    //   269: astore_1
    //   270: aload_2
    //   271: ifnull +7 -> 278
    //   274: aload_2
    //   275: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   278: aload_1
    //   279: athrow
    //   280: astore_2
    //   281: ldc 43
    //   283: iconst_1
    //   284: new 45	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   291: ldc 87
    //   293: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_2
    //   297: invokevirtual 90	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   300: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: goto -31 -> 278
    //   312: astore_1
    //   313: goto -43 -> 270
    //   316: astore_3
    //   317: goto -101 -> 216
    //   320: astore_3
    //   321: goto -161 -> 160
    //   324: aconst_null
    //   325: astore_3
    //   326: aconst_null
    //   327: astore_1
    //   328: goto -212 -> 116
    //   331: aconst_null
    //   332: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	ajrx
    //   0	333	1	paramVarArgs	Integer[]
    //   1	114	2	localObject1	java.lang.Object
    //   126	17	2	localThrowable1	java.lang.Throwable
    //   161	114	2	arrayOfInteger	Integer[]
    //   280	17	2	localThrowable2	java.lang.Throwable
    //   12	109	3	localObject2	java.lang.Object
    //   157	9	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   213	9	3	localThrowable3	java.lang.Throwable
    //   316	1	3	localThrowable4	java.lang.Throwable
    //   320	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   325	1	3	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   120	124	126	java/lang/Throwable
    //   26	59	157	java/lang/OutOfMemoryError
    //   59	83	157	java/lang/OutOfMemoryError
    //   87	103	157	java/lang/OutOfMemoryError
    //   176	180	182	java/lang/Throwable
    //   26	59	213	java/lang/Throwable
    //   59	83	213	java/lang/Throwable
    //   87	103	213	java/lang/Throwable
    //   232	236	238	java/lang/Throwable
    //   26	59	269	finally
    //   59	83	269	finally
    //   87	103	269	finally
    //   274	278	280	java/lang/Throwable
    //   105	110	312	finally
    //   162	172	312	finally
    //   218	228	312	finally
    //   105	110	316	java/lang/Throwable
    //   105	110	320	java/lang/OutOfMemoryError
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    ajrw localajrw = (ajrw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localajrw != null) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {
      localajrw.a(paramBitmap, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajrx
 * JD-Core Version:    0.7.0.1
 */