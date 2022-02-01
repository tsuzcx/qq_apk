import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aktq
  extends AsyncTask<Void, Void, Integer>
{
  int jdField_a_of_type_Int;
  aktt jdField_a_of_type_Aktt;
  Handler jdField_a_of_type_AndroidOsHandler;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  public final int b;
  String b;
  public final int c;
  String c;
  
  public aktq(Activity paramActivity, Handler paramHandler, aktt paramaktt, String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Aktt = paramaktt;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   3: astore_1
    //   4: invokestatic 59	com/tencent/mobileqq/shortvideo/VideoEnvironment:supportSubmitCallback	()Z
    //   7: ifeq +448 -> 455
    //   10: ldc 61
    //   12: iconst_0
    //   13: invokestatic 67	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   16: new 69	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask$1
    //   19: dup
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 72	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask$1:<init>	(Laktq;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   25: invokevirtual 78	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   28: invokestatic 59	com/tencent/mobileqq/shortvideo/VideoEnvironment:supportSubmitCallback	()Z
    //   31: ifeq +202 -> 233
    //   34: lconst_0
    //   35: lstore 7
    //   37: aload_1
    //   38: getfield 81	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   41: astore 10
    //   43: aload 10
    //   45: monitorenter
    //   46: aload_1
    //   47: getfield 81	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   50: invokevirtual 86	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   53: istore 9
    //   55: lload 7
    //   57: lstore 5
    //   59: iload 9
    //   61: ifne +101 -> 162
    //   64: lload 7
    //   66: lstore_3
    //   67: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +14 -> 84
    //   73: lload 7
    //   75: lstore_3
    //   76: ldc 93
    //   78: iconst_2
    //   79: ldc 95
    //   81: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: lload 7
    //   86: lstore_3
    //   87: invokestatic 105	android/os/SystemClock:elapsedRealtime	()J
    //   90: lstore 5
    //   92: lload 7
    //   94: lstore_3
    //   95: aload_1
    //   96: getfield 81	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   99: ldc2_w 106
    //   102: invokevirtual 113	java/lang/Object:wait	(J)V
    //   105: lload 7
    //   107: lstore_3
    //   108: invokestatic 105	android/os/SystemClock:elapsedRealtime	()J
    //   111: lload 5
    //   113: lsub
    //   114: lstore 7
    //   116: lload 7
    //   118: lstore 5
    //   120: lload 7
    //   122: lstore_3
    //   123: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +36 -> 162
    //   129: lload 7
    //   131: lstore_3
    //   132: ldc 93
    //   134: iconst_2
    //   135: new 115	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   142: ldc 118
    //   144: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: lload 7
    //   149: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   152: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: lload 7
    //   160: lstore 5
    //   162: aload 10
    //   164: monitorexit
    //   165: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +11 -> 179
    //   171: ldc 93
    //   173: iconst_2
    //   174: ldc 131
    //   176: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: lload 5
    //   181: ldc2_w 132
    //   184: lcmp
    //   185: ifge +48 -> 233
    //   188: bipush 30
    //   190: lload 5
    //   192: l2i
    //   193: isub
    //   194: istore_2
    //   195: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +28 -> 226
    //   201: ldc 93
    //   203: iconst_2
    //   204: new 115	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   211: ldc 135
    //   213: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload_2
    //   217: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: iload_2
    //   227: i2l
    //   228: lstore_3
    //   229: lload_3
    //   230: invokestatic 143	java/lang/Thread:sleep	(J)V
    //   233: aload_0
    //   234: getfield 32	aktq:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   237: invokevirtual 146	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   240: ifnull +346 -> 586
    //   243: aload_1
    //   244: getfield 149	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_Double	D
    //   247: d2i
    //   248: putstatic 154	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mRecordTime	I
    //   251: aload_1
    //   252: getfield 155	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_c_of_type_Int	I
    //   255: istore_2
    //   256: iload_2
    //   257: ifgt +304 -> 561
    //   260: aload_1
    //   261: getfield 158	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   264: invokevirtual 164	com/tencent/mobileqq/shortvideo/mediadevice/PreviewContext:getFrameIndex	()I
    //   267: putstatic 167	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mRecordFrames	I
    //   270: iconst_0
    //   271: putstatic 170	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mIsSmooth	I
    //   274: iconst_0
    //   275: putstatic 173	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mEnableTotalTimeAdjust	I
    //   278: new 175	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   281: dup
    //   282: aconst_null
    //   283: aload_0
    //   284: getfield 34	aktq:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   287: aload_0
    //   288: getfield 38	aktq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   291: aconst_null
    //   292: aconst_null
    //   293: invokespecial 178	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   296: astore_1
    //   297: aload_1
    //   298: iconst_1
    //   299: invokevirtual 182	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:setEnableHardEncode	(Z)V
    //   302: aload_1
    //   303: iconst_1
    //   304: invokevirtual 185	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:setEnableDeleteCache	(Z)V
    //   307: aload_0
    //   308: getfield 42	aktq:jdField_a_of_type_Boolean	Z
    //   311: ifeq +257 -> 568
    //   314: aload_1
    //   315: iconst_1
    //   316: invokevirtual 188	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:setMuteVoice	(Z)V
    //   319: aload_1
    //   320: iconst_1
    //   321: invokevirtual 191	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:setGenerateGif	(Z)V
    //   324: aload_1
    //   325: aload_0
    //   326: getfield 40	aktq:jdField_a_of_type_Int	I
    //   329: invokevirtual 195	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:setOrientationDegree	(I)V
    //   332: aload_1
    //   333: invokevirtual 198	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   336: aload_0
    //   337: aload_1
    //   338: getfield 201	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:mTargetFilePath	Ljava/lang/String;
    //   341: putfield 203	aktq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   344: aload_0
    //   345: getfield 203	aktq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   348: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   351: ifne +56 -> 407
    //   354: new 211	java/io/File
    //   357: dup
    //   358: aload_0
    //   359: getfield 203	aktq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   362: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;)V
    //   365: astore 10
    //   367: aload 10
    //   369: invokevirtual 217	java/io/File:exists	()Z
    //   372: ifeq +35 -> 407
    //   375: new 115	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   382: aload 10
    //   384: invokevirtual 220	java/io/File:getParent	()Ljava/lang/String;
    //   387: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: getstatic 223	java/io/File:separator	Ljava/lang/String;
    //   393: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: ldc 225
    //   398: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 230	com/tencent/mobileqq/utils/FileUtils:createFileIfNotExits	(Ljava/lang/String;)V
    //   407: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +31 -> 441
    //   413: ldc 93
    //   415: iconst_2
    //   416: new 115	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   423: ldc 232
    //   425: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_0
    //   429: getfield 203	aktq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   432: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: aload_1
    //   442: getfield 235	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:errorCode	I
    //   445: ifne +136 -> 581
    //   448: iconst_0
    //   449: istore_2
    //   450: iload_2
    //   451: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: areturn
    //   455: invokestatic 246	bbva:a	()Lbbva;
    //   458: invokevirtual 249	bbva:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   461: invokevirtual 254	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   464: pop
    //   465: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq -440 -> 28
    //   471: ldc 93
    //   473: iconst_2
    //   474: ldc_w 256
    //   477: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: goto -452 -> 28
    //   483: astore 10
    //   485: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +12 -> 500
    //   491: ldc 93
    //   493: iconst_2
    //   494: ldc_w 258
    //   497: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: aload 10
    //   502: invokevirtual 261	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   505: goto -477 -> 28
    //   508: astore 11
    //   510: lload_3
    //   511: lstore 5
    //   513: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   516: ifeq -354 -> 162
    //   519: ldc 93
    //   521: iconst_2
    //   522: new 115	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   529: ldc_w 263
    //   532: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload 11
    //   537: invokevirtual 266	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   540: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   549: lload_3
    //   550: lstore 5
    //   552: goto -390 -> 162
    //   555: astore_1
    //   556: aload 10
    //   558: monitorexit
    //   559: aload_1
    //   560: athrow
    //   561: iload_2
    //   562: putstatic 167	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mRecordFrames	I
    //   565: goto -295 -> 270
    //   568: aload_1
    //   569: iconst_0
    //   570: invokevirtual 188	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:setMuteVoice	(Z)V
    //   573: aload_1
    //   574: iconst_1
    //   575: invokevirtual 269	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:setEnableBaselineMp4Encode	(Z)V
    //   578: goto -246 -> 332
    //   581: iconst_1
    //   582: istore_2
    //   583: goto -133 -> 450
    //   586: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   589: ifeq +12 -> 601
    //   592: ldc 93
    //   594: iconst_2
    //   595: ldc_w 271
    //   598: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: iconst_1
    //   602: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   605: areturn
    //   606: astore 10
    //   608: goto -375 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	611	0	this	aktq
    //   0	611	1	paramVarArgs	Void[]
    //   194	389	2	i	int
    //   66	484	3	l1	long
    //   57	494	5	l2	long
    //   35	124	7	l3	long
    //   53	7	9	bool	boolean
    //   41	342	10	localObject	java.lang.Object
    //   483	74	10	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   606	1	10	localInterruptedException1	java.lang.InterruptedException
    //   508	28	11	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   455	480	483	java/lang/UnsatisfiedLinkError
    //   67	73	508	java/lang/InterruptedException
    //   76	84	508	java/lang/InterruptedException
    //   87	92	508	java/lang/InterruptedException
    //   95	105	508	java/lang/InterruptedException
    //   108	116	508	java/lang/InterruptedException
    //   123	129	508	java/lang/InterruptedException
    //   132	158	508	java/lang/InterruptedException
    //   46	55	555	finally
    //   67	73	555	finally
    //   76	84	555	finally
    //   87	92	555	finally
    //   95	105	555	finally
    //   108	116	555	finally
    //   123	129	555	finally
    //   132	158	555	finally
    //   162	165	555	finally
    //   513	549	555	finally
    //   556	559	555	finally
    //   229	233	606	java/lang/InterruptedException
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "generate video result= " + paramInteger);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    switch (paramInteger.intValue())
    {
    default: 
      this.jdField_a_of_type_Aktt.a(false, null, null, null);
      return;
    }
    this.jdField_a_of_type_Aktt.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktq
 * JD-Core Version:    0.7.0.1
 */