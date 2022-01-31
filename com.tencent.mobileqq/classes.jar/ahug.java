import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ahug
  extends AsyncTask<Void, Void, Integer>
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  String f;
  String g;
  
  public ahug(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    paramBaseActivity = paramBaseActivity.getIntent();
    if (paramIntent != null) {}
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
      this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("file_send_duration");
      this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("file_send_size");
      this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("uin");
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("file_source");
      this.jdField_e_of_type_JavaLangString = paramIntent.getExtras().getString("file_shortvideo_md5");
      this.jdField_a_of_type_JavaLangString = paramIntent.getExtras().getString("activity_before_enter_send_video");
      this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("send_in_background");
      if (paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 2) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_b_of_type_Boolean = bool;
        if (QLog.isColorLevel()) {
          QLog.d("SendVideoActivity", 2, " SendVideoTask(),  mVideoPath :" + this.jdField_b_of_type_JavaLangString + ", mDuration:" + this.jdField_b_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Long + ",mUin" + this.jdField_c_of_type_JavaLangString + ",mUinType:" + this.jdField_a_of_type_Int + ",mFileSource:" + this.jdField_d_of_type_JavaLangString + ",mSendBackground = " + this.jdField_a_of_type_Boolean + ", mSendRawVideo:" + this.jdField_b_of_type_Boolean);
        }
        return;
      }
      paramIntent = paramBaseActivity;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, boolean paramBoolean)
  {
    bafb localbafb = babr.a(paramBaseActivity, 232, null, paramBaseActivity.getString(paramInt), new ahuh(paramBoolean, paramBaseActivity), null);
    if (!paramBaseActivity.isFinishing()) {
      localbafb.show();
    }
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	ahug:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 191	android/content/Context
    //   10: astore 11
    //   12: aload 11
    //   14: ifnonnull +7 -> 21
    //   17: iconst_5
    //   18: istore_1
    //   19: iload_1
    //   20: ireturn
    //   21: sipush 1280
    //   24: istore_2
    //   25: invokestatic 197	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   28: invokevirtual 201	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   31: checkcast 203	com/tencent/mobileqq/app/QQAppInterface
    //   34: astore 7
    //   36: iload_2
    //   37: istore_1
    //   38: aload 7
    //   40: ifnull +106 -> 146
    //   43: aload 11
    //   45: aload 7
    //   47: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   50: invokestatic 212	baig:o	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 7
    //   55: iload_2
    //   56: istore_1
    //   57: aload 7
    //   59: ifnull +87 -> 146
    //   62: iload_2
    //   63: istore_1
    //   64: aload 7
    //   66: invokevirtual 217	java/lang/String:length	()I
    //   69: ifle +77 -> 146
    //   72: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +29 -> 104
    //   78: ldc 114
    //   80: iconst_2
    //   81: new 116	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   88: ldc 219
    //   90: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 7
    //   95: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: aload 7
    //   106: ldc 221
    //   108: invokevirtual 225	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   111: astore 7
    //   113: iload_2
    //   114: istore_1
    //   115: aload 7
    //   117: ifnull +29 -> 146
    //   120: aload 7
    //   122: arraylength
    //   123: istore_3
    //   124: iload_2
    //   125: istore_1
    //   126: iload_3
    //   127: iconst_5
    //   128: if_icmplt +18 -> 146
    //   131: aload 7
    //   133: iconst_0
    //   134: aaload
    //   135: invokestatic 231	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   138: invokevirtual 234	java/lang/Integer:intValue	()I
    //   141: istore_1
    //   142: iload_1
    //   143: ifle +1218 -> 1361
    //   146: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +28 -> 177
    //   152: ldc 114
    //   154: iconst_2
    //   155: new 116	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   162: ldc 236
    //   164: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: iload_1
    //   168: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 11
    //   179: aload_0
    //   180: getfield 55	ahug:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   183: iload_1
    //   184: invokestatic 241	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   187: astore 8
    //   189: aload 8
    //   191: ifnonnull +1167 -> 1358
    //   194: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +11 -> 208
    //   200: ldc 114
    //   202: iconst_2
    //   203: ldc 243
    //   205: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload_0
    //   209: getfield 247	ahug:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   212: ifnull +201 -> 413
    //   215: aload_0
    //   216: getfield 247	ahug:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   219: astore 8
    //   221: aload_0
    //   222: aload 8
    //   224: invokevirtual 252	android/graphics/Bitmap:getWidth	()I
    //   227: putfield 254	ahug:jdField_b_of_type_Int	I
    //   230: aload_0
    //   231: aload 8
    //   233: invokevirtual 257	android/graphics/Bitmap:getHeight	()I
    //   236: putfield 259	ahug:jdField_c_of_type_Int	I
    //   239: aload_0
    //   240: getfield 254	ahug:jdField_b_of_type_Int	I
    //   243: ifeq +10 -> 253
    //   246: aload_0
    //   247: getfield 259	ahug:jdField_c_of_type_Int	I
    //   250: ifne +201 -> 451
    //   253: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +12 -> 268
    //   259: ldc 114
    //   261: iconst_2
    //   262: ldc_w 261
    //   265: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: iconst_0
    //   269: ifeq +11 -> 280
    //   272: new 263	java/lang/NullPointerException
    //   275: dup
    //   276: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   279: athrow
    //   280: iconst_0
    //   281: ifeq +11 -> 292
    //   284: new 263	java/lang/NullPointerException
    //   287: dup
    //   288: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   291: athrow
    //   292: iconst_0
    //   293: ifeq +11 -> 304
    //   296: new 263	java/lang/NullPointerException
    //   299: dup
    //   300: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   303: athrow
    //   304: iconst_2
    //   305: ireturn
    //   306: astore 7
    //   308: iload_2
    //   309: istore_1
    //   310: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq -167 -> 146
    //   316: ldc 114
    //   318: iconst_2
    //   319: ldc_w 266
    //   322: aload 7
    //   324: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   327: iload_2
    //   328: istore_1
    //   329: goto -183 -> 146
    //   332: astore 11
    //   334: aconst_null
    //   335: astore 7
    //   337: aconst_null
    //   338: astore 10
    //   340: aload 7
    //   342: astore 9
    //   344: aload 10
    //   346: astore 8
    //   348: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +22 -> 373
    //   354: aload 7
    //   356: astore 9
    //   358: aload 10
    //   360: astore 8
    //   362: ldc 114
    //   364: iconst_2
    //   365: ldc_w 271
    //   368: aload 11
    //   370: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   373: iconst_3
    //   374: istore_1
    //   375: iconst_0
    //   376: ifeq +11 -> 387
    //   379: new 263	java/lang/NullPointerException
    //   382: dup
    //   383: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   386: athrow
    //   387: aload 7
    //   389: ifnull +8 -> 397
    //   392: aload 7
    //   394: invokevirtual 276	java/io/BufferedOutputStream:close	()V
    //   397: aload 10
    //   399: ifnull -380 -> 19
    //   402: aload 10
    //   404: invokevirtual 279	java/io/FileInputStream:close	()V
    //   407: iconst_3
    //   408: ireturn
    //   409: astore 7
    //   411: iconst_3
    //   412: ireturn
    //   413: iconst_0
    //   414: ifeq +11 -> 425
    //   417: new 263	java/lang/NullPointerException
    //   420: dup
    //   421: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   424: athrow
    //   425: iconst_0
    //   426: ifeq +11 -> 437
    //   429: new 263	java/lang/NullPointerException
    //   432: dup
    //   433: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   436: athrow
    //   437: iconst_0
    //   438: ifeq +11 -> 449
    //   441: new 263	java/lang/NullPointerException
    //   444: dup
    //   445: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   448: athrow
    //   449: iconst_2
    //   450: ireturn
    //   451: new 116	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   458: ldc_w 281
    //   461: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   467: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: ldc_w 289
    //   476: invokestatic 292	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   479: astore 13
    //   481: new 116	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   488: invokestatic 294	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   491: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 296
    //   497: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 301	bace:c	(Ljava/lang/String;)V
    //   506: new 303	java/io/File
    //   509: dup
    //   510: aload 13
    //   512: invokespecial 305	java/io/File:<init>	(Ljava/lang/String;)V
    //   515: astore 12
    //   517: new 303	java/io/File
    //   520: dup
    //   521: aload 12
    //   523: invokevirtual 308	java/io/File:getParent	()Ljava/lang/String;
    //   526: invokespecial 305	java/io/File:<init>	(Ljava/lang/String;)V
    //   529: astore 7
    //   531: aload 7
    //   533: invokevirtual 311	java/io/File:exists	()Z
    //   536: ifeq +11 -> 547
    //   539: aload 7
    //   541: invokevirtual 314	java/io/File:isDirectory	()Z
    //   544: ifne +9 -> 553
    //   547: aload 7
    //   549: invokevirtual 317	java/io/File:mkdirs	()Z
    //   552: pop
    //   553: aload 12
    //   555: invokevirtual 311	java/io/File:exists	()Z
    //   558: ifeq +11 -> 569
    //   561: aload 12
    //   563: invokevirtual 320	java/io/File:isFile	()Z
    //   566: ifne +9 -> 575
    //   569: aload 12
    //   571: invokevirtual 323	java/io/File:createNewFile	()Z
    //   574: pop
    //   575: new 273	java/io/BufferedOutputStream
    //   578: dup
    //   579: new 325	java/io/FileOutputStream
    //   582: dup
    //   583: aload 12
    //   585: invokespecial 328	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   588: invokespecial 331	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   591: astore 7
    //   593: aload 8
    //   595: getstatic 337	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   598: bipush 80
    //   600: aload 7
    //   602: invokevirtual 341	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   605: pop
    //   606: aload 7
    //   608: invokevirtual 344	java/io/BufferedOutputStream:flush	()V
    //   611: new 278	java/io/FileInputStream
    //   614: dup
    //   615: aload 12
    //   617: invokespecial 345	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   620: astore 10
    //   622: aload 7
    //   624: astore 9
    //   626: aload 10
    //   628: astore 8
    //   630: aload 12
    //   632: invokevirtual 347	java/io/File:length	()J
    //   635: lstore 5
    //   637: aload 7
    //   639: astore 9
    //   641: aload 10
    //   643: astore 8
    //   645: aload_0
    //   646: aload 10
    //   648: lload 5
    //   650: invokestatic 353	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   653: invokestatic 359	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   656: putfield 361	ahug:g	Ljava/lang/String;
    //   659: aload 7
    //   661: astore 9
    //   663: aload 10
    //   665: astore 8
    //   667: aload_0
    //   668: getfield 361	ahug:g	Ljava/lang/String;
    //   671: invokestatic 367	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   674: ifeq +88 -> 762
    //   677: aload 7
    //   679: astore 9
    //   681: aload 10
    //   683: astore 8
    //   685: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq +40 -> 728
    //   691: aload 7
    //   693: astore 9
    //   695: aload 10
    //   697: astore 8
    //   699: ldc 114
    //   701: iconst_2
    //   702: new 116	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   709: ldc_w 369
    //   712: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload_0
    //   716: getfield 361	ahug:g	Ljava/lang/String;
    //   719: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   728: iconst_0
    //   729: ifeq +11 -> 740
    //   732: new 263	java/lang/NullPointerException
    //   735: dup
    //   736: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   739: athrow
    //   740: aload 7
    //   742: ifnull +8 -> 750
    //   745: aload 7
    //   747: invokevirtual 276	java/io/BufferedOutputStream:close	()V
    //   750: aload 10
    //   752: ifnull +8 -> 760
    //   755: aload 10
    //   757: invokevirtual 279	java/io/FileInputStream:close	()V
    //   760: iconst_5
    //   761: ireturn
    //   762: aload 7
    //   764: astore 9
    //   766: aload 10
    //   768: astore 8
    //   770: aload_0
    //   771: aload_0
    //   772: getfield 361	ahug:g	Ljava/lang/String;
    //   775: ldc_w 289
    //   778: invokestatic 292	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   781: putfield 371	ahug:f	Ljava/lang/String;
    //   784: aload 7
    //   786: astore 9
    //   788: aload 10
    //   790: astore 8
    //   792: aload 13
    //   794: aload_0
    //   795: getfield 371	ahug:f	Ljava/lang/String;
    //   798: invokestatic 374	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   801: istore 4
    //   803: iload 4
    //   805: ifne +37 -> 842
    //   808: iconst_0
    //   809: ifeq +11 -> 820
    //   812: new 263	java/lang/NullPointerException
    //   815: dup
    //   816: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   819: athrow
    //   820: aload 7
    //   822: ifnull +8 -> 830
    //   825: aload 7
    //   827: invokevirtual 276	java/io/BufferedOutputStream:close	()V
    //   830: aload 10
    //   832: ifnull +8 -> 840
    //   835: aload 10
    //   837: invokevirtual 279	java/io/FileInputStream:close	()V
    //   840: iconst_5
    //   841: ireturn
    //   842: aload 7
    //   844: astore 9
    //   846: aload 10
    //   848: astore 8
    //   850: aload 11
    //   852: lload 5
    //   854: invokestatic 380	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
    //   857: astore 11
    //   859: aload 7
    //   861: astore 9
    //   863: aload 10
    //   865: astore 8
    //   867: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   870: ifeq +38 -> 908
    //   873: aload 7
    //   875: astore 9
    //   877: aload 10
    //   879: astore 8
    //   881: ldc 114
    //   883: iconst_2
    //   884: new 116	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   891: ldc_w 382
    //   894: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: aload 11
    //   899: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   908: aload 7
    //   910: astore 9
    //   912: aload 10
    //   914: astore 8
    //   916: aload_0
    //   917: getfield 63	ahug:jdField_b_of_type_Long	J
    //   920: lconst_0
    //   921: lcmp
    //   922: ifne +22 -> 944
    //   925: aload 7
    //   927: astore 9
    //   929: aload 10
    //   931: astore 8
    //   933: aload_0
    //   934: aload_0
    //   935: getfield 55	ahug:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   938: invokestatic 384	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)J
    //   941: putfield 63	ahug:jdField_b_of_type_Long	J
    //   944: iconst_0
    //   945: ifeq +11 -> 956
    //   948: new 263	java/lang/NullPointerException
    //   951: dup
    //   952: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   955: athrow
    //   956: aload 7
    //   958: ifnull +8 -> 966
    //   961: aload 7
    //   963: invokevirtual 276	java/io/BufferedOutputStream:close	()V
    //   966: aload 10
    //   968: ifnull +8 -> 976
    //   971: aload 10
    //   973: invokevirtual 279	java/io/FileInputStream:close	()V
    //   976: iconst_1
    //   977: ireturn
    //   978: astore 11
    //   980: aconst_null
    //   981: astore 7
    //   983: aconst_null
    //   984: astore 10
    //   986: aload 7
    //   988: astore 9
    //   990: aload 10
    //   992: astore 8
    //   994: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   997: ifeq +22 -> 1019
    //   1000: aload 7
    //   1002: astore 9
    //   1004: aload 10
    //   1006: astore 8
    //   1008: ldc 114
    //   1010: iconst_2
    //   1011: ldc_w 271
    //   1014: aload 11
    //   1016: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1019: iconst_0
    //   1020: ifeq +11 -> 1031
    //   1023: new 263	java/lang/NullPointerException
    //   1026: dup
    //   1027: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   1030: athrow
    //   1031: aload 7
    //   1033: ifnull +8 -> 1041
    //   1036: aload 7
    //   1038: invokevirtual 276	java/io/BufferedOutputStream:close	()V
    //   1041: aload 10
    //   1043: ifnull +8 -> 1051
    //   1046: aload 10
    //   1048: invokevirtual 279	java/io/FileInputStream:close	()V
    //   1051: iconst_5
    //   1052: ireturn
    //   1053: astore 11
    //   1055: aconst_null
    //   1056: astore 7
    //   1058: aconst_null
    //   1059: astore 10
    //   1061: aload 7
    //   1063: astore 9
    //   1065: aload 10
    //   1067: astore 8
    //   1069: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1072: ifeq +22 -> 1094
    //   1075: aload 7
    //   1077: astore 9
    //   1079: aload 10
    //   1081: astore 8
    //   1083: ldc 114
    //   1085: iconst_2
    //   1086: ldc_w 386
    //   1089: aload 11
    //   1091: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1094: iconst_4
    //   1095: istore_1
    //   1096: iconst_0
    //   1097: ifeq +11 -> 1108
    //   1100: new 263	java/lang/NullPointerException
    //   1103: dup
    //   1104: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   1107: athrow
    //   1108: aload 7
    //   1110: ifnull +8 -> 1118
    //   1113: aload 7
    //   1115: invokevirtual 276	java/io/BufferedOutputStream:close	()V
    //   1118: aload 10
    //   1120: ifnull -1101 -> 19
    //   1123: aload 10
    //   1125: invokevirtual 279	java/io/FileInputStream:close	()V
    //   1128: iconst_4
    //   1129: ireturn
    //   1130: astore 7
    //   1132: iconst_4
    //   1133: ireturn
    //   1134: astore 10
    //   1136: aconst_null
    //   1137: astore 7
    //   1139: aconst_null
    //   1140: astore 8
    //   1142: iconst_0
    //   1143: ifeq +11 -> 1154
    //   1146: new 263	java/lang/NullPointerException
    //   1149: dup
    //   1150: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   1153: athrow
    //   1154: aload 7
    //   1156: ifnull +8 -> 1164
    //   1159: aload 7
    //   1161: invokevirtual 276	java/io/BufferedOutputStream:close	()V
    //   1164: aload 8
    //   1166: ifnull +8 -> 1174
    //   1169: aload 8
    //   1171: invokevirtual 279	java/io/FileInputStream:close	()V
    //   1174: aload 10
    //   1176: athrow
    //   1177: astore 7
    //   1179: goto -754 -> 425
    //   1182: astore 7
    //   1184: goto -747 -> 437
    //   1187: astore 7
    //   1189: goto -740 -> 449
    //   1192: astore 7
    //   1194: goto -914 -> 280
    //   1197: astore 7
    //   1199: goto -907 -> 292
    //   1202: astore 7
    //   1204: goto -900 -> 304
    //   1207: astore 8
    //   1209: goto -469 -> 740
    //   1212: astore 7
    //   1214: goto -464 -> 750
    //   1217: astore 7
    //   1219: goto -459 -> 760
    //   1222: astore 8
    //   1224: goto -404 -> 820
    //   1227: astore 7
    //   1229: goto -399 -> 830
    //   1232: astore 7
    //   1234: goto -394 -> 840
    //   1237: astore 8
    //   1239: goto -283 -> 956
    //   1242: astore 7
    //   1244: goto -278 -> 966
    //   1247: astore 7
    //   1249: goto -273 -> 976
    //   1252: astore 8
    //   1254: goto -867 -> 387
    //   1257: astore 7
    //   1259: goto -862 -> 397
    //   1262: astore 8
    //   1264: goto -233 -> 1031
    //   1267: astore 7
    //   1269: goto -228 -> 1041
    //   1272: astore 7
    //   1274: goto -223 -> 1051
    //   1277: astore 8
    //   1279: goto -171 -> 1108
    //   1282: astore 7
    //   1284: goto -166 -> 1118
    //   1287: astore 9
    //   1289: goto -135 -> 1154
    //   1292: astore 7
    //   1294: goto -130 -> 1164
    //   1297: astore 7
    //   1299: goto -125 -> 1174
    //   1302: astore 10
    //   1304: aconst_null
    //   1305: astore 8
    //   1307: goto -165 -> 1142
    //   1310: astore 10
    //   1312: aload 9
    //   1314: astore 7
    //   1316: goto -174 -> 1142
    //   1319: astore 11
    //   1321: aconst_null
    //   1322: astore 10
    //   1324: goto -263 -> 1061
    //   1327: astore 11
    //   1329: goto -268 -> 1061
    //   1332: astore 11
    //   1334: aconst_null
    //   1335: astore 10
    //   1337: goto -351 -> 986
    //   1340: astore 11
    //   1342: goto -356 -> 986
    //   1345: astore 11
    //   1347: aconst_null
    //   1348: astore 10
    //   1350: goto -1010 -> 340
    //   1353: astore 11
    //   1355: goto -1015 -> 340
    //   1358: goto -1137 -> 221
    //   1361: sipush 1280
    //   1364: istore_1
    //   1365: goto -1219 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1368	0	this	ahug
    //   18	1347	1	i	int
    //   24	304	2	j	int
    //   123	6	3	k	int
    //   801	3	4	bool	boolean
    //   635	218	5	l	long
    //   34	98	7	localObject1	Object
    //   306	17	7	localNumberFormatException	java.lang.NumberFormatException
    //   335	58	7	localObject2	Object
    //   409	1	7	localIOException1	java.io.IOException
    //   529	585	7	localObject3	Object
    //   1130	1	7	localIOException2	java.io.IOException
    //   1137	23	7	localObject4	Object
    //   1177	1	7	localIOException3	java.io.IOException
    //   1182	1	7	localIOException4	java.io.IOException
    //   1187	1	7	localIOException5	java.io.IOException
    //   1192	1	7	localIOException6	java.io.IOException
    //   1197	1	7	localIOException7	java.io.IOException
    //   1202	1	7	localIOException8	java.io.IOException
    //   1212	1	7	localIOException9	java.io.IOException
    //   1217	1	7	localIOException10	java.io.IOException
    //   1227	1	7	localIOException11	java.io.IOException
    //   1232	1	7	localIOException12	java.io.IOException
    //   1242	1	7	localIOException13	java.io.IOException
    //   1247	1	7	localIOException14	java.io.IOException
    //   1257	1	7	localIOException15	java.io.IOException
    //   1267	1	7	localIOException16	java.io.IOException
    //   1272	1	7	localIOException17	java.io.IOException
    //   1282	1	7	localIOException18	java.io.IOException
    //   1292	1	7	localIOException19	java.io.IOException
    //   1297	1	7	localIOException20	java.io.IOException
    //   1314	1	7	localObject5	Object
    //   187	983	8	localObject6	Object
    //   1207	1	8	localIOException21	java.io.IOException
    //   1222	1	8	localIOException22	java.io.IOException
    //   1237	1	8	localIOException23	java.io.IOException
    //   1252	1	8	localIOException24	java.io.IOException
    //   1262	1	8	localIOException25	java.io.IOException
    //   1277	1	8	localIOException26	java.io.IOException
    //   1305	1	8	localObject7	Object
    //   342	736	9	localObject8	Object
    //   1287	26	9	localIOException27	java.io.IOException
    //   338	786	10	localFileInputStream	java.io.FileInputStream
    //   1134	41	10	localObject9	Object
    //   1302	1	10	localObject10	Object
    //   1310	1	10	localObject11	Object
    //   1322	27	10	localObject12	Object
    //   10	168	11	localContext	Context
    //   332	519	11	localIOException28	java.io.IOException
    //   857	41	11	str1	String
    //   978	37	11	localException1	Exception
    //   1053	37	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1319	1	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1327	1	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1332	1	11	localException2	Exception
    //   1340	1	11	localException3	Exception
    //   1345	1	11	localIOException29	java.io.IOException
    //   1353	1	11	localIOException30	java.io.IOException
    //   515	116	12	localFile	java.io.File
    //   479	314	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   131	142	306	java/lang/NumberFormatException
    //   25	36	332	java/io/IOException
    //   43	55	332	java/io/IOException
    //   64	104	332	java/io/IOException
    //   104	113	332	java/io/IOException
    //   120	124	332	java/io/IOException
    //   131	142	332	java/io/IOException
    //   146	177	332	java/io/IOException
    //   177	189	332	java/io/IOException
    //   194	208	332	java/io/IOException
    //   208	221	332	java/io/IOException
    //   221	253	332	java/io/IOException
    //   253	268	332	java/io/IOException
    //   310	327	332	java/io/IOException
    //   451	547	332	java/io/IOException
    //   547	553	332	java/io/IOException
    //   553	569	332	java/io/IOException
    //   569	575	332	java/io/IOException
    //   575	593	332	java/io/IOException
    //   402	407	409	java/io/IOException
    //   25	36	978	java/lang/Exception
    //   43	55	978	java/lang/Exception
    //   64	104	978	java/lang/Exception
    //   104	113	978	java/lang/Exception
    //   120	124	978	java/lang/Exception
    //   131	142	978	java/lang/Exception
    //   146	177	978	java/lang/Exception
    //   177	189	978	java/lang/Exception
    //   194	208	978	java/lang/Exception
    //   208	221	978	java/lang/Exception
    //   221	253	978	java/lang/Exception
    //   253	268	978	java/lang/Exception
    //   310	327	978	java/lang/Exception
    //   451	547	978	java/lang/Exception
    //   547	553	978	java/lang/Exception
    //   553	569	978	java/lang/Exception
    //   569	575	978	java/lang/Exception
    //   575	593	978	java/lang/Exception
    //   25	36	1053	java/lang/OutOfMemoryError
    //   43	55	1053	java/lang/OutOfMemoryError
    //   64	104	1053	java/lang/OutOfMemoryError
    //   104	113	1053	java/lang/OutOfMemoryError
    //   120	124	1053	java/lang/OutOfMemoryError
    //   131	142	1053	java/lang/OutOfMemoryError
    //   146	177	1053	java/lang/OutOfMemoryError
    //   177	189	1053	java/lang/OutOfMemoryError
    //   194	208	1053	java/lang/OutOfMemoryError
    //   208	221	1053	java/lang/OutOfMemoryError
    //   221	253	1053	java/lang/OutOfMemoryError
    //   253	268	1053	java/lang/OutOfMemoryError
    //   310	327	1053	java/lang/OutOfMemoryError
    //   451	547	1053	java/lang/OutOfMemoryError
    //   547	553	1053	java/lang/OutOfMemoryError
    //   553	569	1053	java/lang/OutOfMemoryError
    //   569	575	1053	java/lang/OutOfMemoryError
    //   575	593	1053	java/lang/OutOfMemoryError
    //   1123	1128	1130	java/io/IOException
    //   25	36	1134	finally
    //   43	55	1134	finally
    //   64	104	1134	finally
    //   104	113	1134	finally
    //   120	124	1134	finally
    //   131	142	1134	finally
    //   146	177	1134	finally
    //   177	189	1134	finally
    //   194	208	1134	finally
    //   208	221	1134	finally
    //   221	253	1134	finally
    //   253	268	1134	finally
    //   310	327	1134	finally
    //   451	547	1134	finally
    //   547	553	1134	finally
    //   553	569	1134	finally
    //   569	575	1134	finally
    //   575	593	1134	finally
    //   417	425	1177	java/io/IOException
    //   429	437	1182	java/io/IOException
    //   441	449	1187	java/io/IOException
    //   272	280	1192	java/io/IOException
    //   284	292	1197	java/io/IOException
    //   296	304	1202	java/io/IOException
    //   732	740	1207	java/io/IOException
    //   745	750	1212	java/io/IOException
    //   755	760	1217	java/io/IOException
    //   812	820	1222	java/io/IOException
    //   825	830	1227	java/io/IOException
    //   835	840	1232	java/io/IOException
    //   948	956	1237	java/io/IOException
    //   961	966	1242	java/io/IOException
    //   971	976	1247	java/io/IOException
    //   379	387	1252	java/io/IOException
    //   392	397	1257	java/io/IOException
    //   1023	1031	1262	java/io/IOException
    //   1036	1041	1267	java/io/IOException
    //   1046	1051	1272	java/io/IOException
    //   1100	1108	1277	java/io/IOException
    //   1113	1118	1282	java/io/IOException
    //   1146	1154	1287	java/io/IOException
    //   1159	1164	1292	java/io/IOException
    //   1169	1174	1297	java/io/IOException
    //   593	622	1302	finally
    //   348	354	1310	finally
    //   362	373	1310	finally
    //   630	637	1310	finally
    //   645	659	1310	finally
    //   667	677	1310	finally
    //   685	691	1310	finally
    //   699	728	1310	finally
    //   770	784	1310	finally
    //   792	803	1310	finally
    //   850	859	1310	finally
    //   867	873	1310	finally
    //   881	908	1310	finally
    //   916	925	1310	finally
    //   933	944	1310	finally
    //   994	1000	1310	finally
    //   1008	1019	1310	finally
    //   1069	1075	1310	finally
    //   1083	1094	1310	finally
    //   593	622	1319	java/lang/OutOfMemoryError
    //   630	637	1327	java/lang/OutOfMemoryError
    //   645	659	1327	java/lang/OutOfMemoryError
    //   667	677	1327	java/lang/OutOfMemoryError
    //   685	691	1327	java/lang/OutOfMemoryError
    //   699	728	1327	java/lang/OutOfMemoryError
    //   770	784	1327	java/lang/OutOfMemoryError
    //   792	803	1327	java/lang/OutOfMemoryError
    //   850	859	1327	java/lang/OutOfMemoryError
    //   867	873	1327	java/lang/OutOfMemoryError
    //   881	908	1327	java/lang/OutOfMemoryError
    //   916	925	1327	java/lang/OutOfMemoryError
    //   933	944	1327	java/lang/OutOfMemoryError
    //   593	622	1332	java/lang/Exception
    //   630	637	1340	java/lang/Exception
    //   645	659	1340	java/lang/Exception
    //   667	677	1340	java/lang/Exception
    //   685	691	1340	java/lang/Exception
    //   699	728	1340	java/lang/Exception
    //   770	784	1340	java/lang/Exception
    //   792	803	1340	java/lang/Exception
    //   850	859	1340	java/lang/Exception
    //   867	873	1340	java/lang/Exception
    //   881	908	1340	java/lang/Exception
    //   916	925	1340	java/lang/Exception
    //   933	944	1340	java/lang/Exception
    //   593	622	1345	java/io/IOException
    //   630	637	1353	java/io/IOException
    //   645	659	1353	java/io/IOException
    //   667	677	1353	java/io/IOException
    //   685	691	1353	java/io/IOException
    //   699	728	1353	java/io/IOException
    //   770	784	1353	java/io/IOException
    //   792	803	1353	java/io/IOException
    //   850	859	1353	java/io/IOException
    //   867	873	1353	java/io/IOException
    //   881	908	1353	java/io/IOException
    //   916	925	1353	java/io/IOException
    //   933	944	1353	java/io/IOException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a());
  }
  
  public void a()
  {
    Intent localIntent = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("file_send_path", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("file_send_size", this.jdField_a_of_type_Long);
    localIntent.putExtra("file_send_duration", (int)(this.jdField_b_of_type_Long / 1000L));
    localIntent.putExtra("file_source", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("thumbfile_send_path", this.f);
    localIntent.putExtra("file_shortvideo_md5", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("thumbfile_send_width", this.jdField_b_of_type_Int);
    localIntent.putExtra("thumbfile_send_height", this.jdField_c_of_type_Int);
    localIntent.putExtra("thumbfile_md5", this.g);
    localIntent.putExtra("file_width", this.jdField_d_of_type_Int);
    localIntent.putExtra("file_height", this.jdField_e_of_type_Int);
    localIntent.putExtra("file_raw_size", this.jdField_b_of_type_Boolean);
    Object localObject1;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(ShortVideoPreviewActivity.class.getName())))
    {
      localIntent.putExtra("file_send_business_type", 2);
      localObject1 = aweg.a(0, 2);
      ((awey)localObject1).a(aweg.a(2, localIntent, (awey)localObject1));
      aweg.a((awey)localObject1, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject1 = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getIntent();
        if (((Intent)localObject1).getBooleanExtra("start_init_activity_after_sended", true))
        {
          localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          localIntent.setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "SendVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=" + (String)localObject2);
          }
          localIntent.addFlags(603979776);
          ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(localIntent);
        }
        ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
        ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).overridePendingTransition(0, 2130771980);
      }
      return;
      localIntent.putExtra("file_send_business_type", 0);
      Object localObject2 = aweg.a(0, 0);
      localObject1 = aweg.a(0, localIntent, (awey)localObject2);
      ((awey)localObject2).a((awfo)localObject1);
      localObject2 = new awdq(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app);
      localObject1 = ((awdq)localObject2).a((awfo)localObject1);
      if (((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app != null) {
        ((avau)((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.getManager(326)).a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).uniseq);
      }
      ((awdq)localObject2).a((MessageRecord)localObject1);
    }
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
          break label63;
        }
        b();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
      }
      catch (Throwable paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SendVideoActivity", 2, "showProgressDialog", paramContext);
      return;
      label63:
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131690181);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131493818);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131305861));
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    b();
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case 1: 
      a();
      return;
    case 2: 
    case 6: 
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131653713, this.jdField_a_of_type_Boolean);
      return;
    case 3: 
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131653708, this.jdField_a_of_type_Boolean);
      return;
    case 4: 
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131653678, this.jdField_a_of_type_Boolean);
      return;
    }
    a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131653705, this.jdField_a_of_type_Boolean);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
        {
          this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131629444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahug
 * JD-Core Version:    0.7.0.1
 */