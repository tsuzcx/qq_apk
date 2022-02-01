import android.os.AsyncTask;
import android.os.Environment;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class agzw
  extends AsyncTask<Integer, Integer, Integer>
{
  int jdField_a_of_type_Int;
  aham jdField_a_of_type_Aham;
  boolean jdField_a_of_type_Boolean = true;
  aham[] jdField_a_of_type_ArrayOfAham;
  
  public agzw(ArrayList<aham> paramArrayList)
  {
    Object localObject;
    this.jdField_a_of_type_ArrayOfAham = ((aham[])localObject.toArray(new aham[0]));
  }
  
  private int a(aham[] paramArrayOfaham, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, Integer... paramVarArgs)
  {
    int i;
    if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_UNMOUNT");
      }
      i = 23;
    }
    File localFile;
    Object localObject;
    int j;
    do
    {
      return i;
      localFile = new File(AppConstants.SDCARD_IMG_SAVE);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      paramInt1 = 0;
      if (paramInt1 >= paramArrayOfaham.length) {
        break label267;
      }
      localObject = paramArrayOfaham[paramInt1];
      if (!paramBoolean) {
        return 1;
      }
      if (!AIOImageData.class.isInstance(((aham)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break;
      }
      localObject = (AIOImageData)((aham)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      publishProgress(new Integer[] { Integer.valueOf(paramInt2 * 100 / paramVarArgs.length + paramInt1 * 100 / paramVarArgs.length / paramArrayOfaham.length & 0xFFFF | paramInt3 << 16) });
      j = agzo.a(this.jdField_a_of_type_Agzo, null, (AIOImageData)localObject, localFile);
      i = j;
    } while (j != 20);
    do
    {
      do
      {
        paramInt1 += 1;
        break;
      } while (!AIOFilePicData.class.isInstance(((aham)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      localObject = (AIOFilePicData)((aham)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      publishProgress(new Integer[] { Integer.valueOf(paramInt2 * 100 / paramVarArgs.length + paramInt1 * 100 / paramVarArgs.length / paramArrayOfaham.length & 0xFFFF | paramInt3 << 16) });
      i = agzo.a(this.jdField_a_of_type_Agzo, null, (AIOFilePicData)localObject, localFile);
    } while (i == 20);
    return i;
    label267:
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_COMPLETE");
    }
    return 20;
  }
  
  /* Error */
  protected Integer a(Integer... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +525 -> 528
    //   6: ldc 57
    //   8: iconst_2
    //   9: new 121	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   16: ldc 124
    //   18: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: goto +497 -> 528
    //   34: iload_3
    //   35: aload_1
    //   36: arraylength
    //   37: if_icmpge +481 -> 518
    //   40: aload_1
    //   41: iload_3
    //   42: aaload
    //   43: invokevirtual 138	java/lang/Integer:intValue	()I
    //   46: istore 4
    //   48: aload_0
    //   49: getfield 20	agzw:jdField_a_of_type_Boolean	Z
    //   52: ifne +8 -> 60
    //   55: iconst_1
    //   56: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: areturn
    //   60: iload_3
    //   61: bipush 100
    //   63: imul
    //   64: aload_1
    //   65: arraylength
    //   66: idiv
    //   67: istore 5
    //   69: aload_0
    //   70: iconst_1
    //   71: anewarray 93	java/lang/Integer
    //   74: dup
    //   75: iconst_0
    //   76: iload 4
    //   78: bipush 16
    //   80: ishl
    //   81: iload 5
    //   83: ldc 94
    //   85: iand
    //   86: ior
    //   87: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: invokevirtual 102	agzw:publishProgress	([Ljava/lang/Object;)V
    //   94: iload 4
    //   96: tableswitch	default:+439 -> 535, 0:+446->542, 1:+400->496, 2:+446->542
    //   125: aload_0
    //   126: getfield 31	agzw:jdField_a_of_type_ArrayOfAham	[Laham;
    //   129: arraylength
    //   130: if_icmpge +424 -> 554
    //   133: aload_0
    //   134: getfield 20	agzw:jdField_a_of_type_Boolean	Z
    //   137: ifne +8 -> 145
    //   140: iconst_1
    //   141: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: areturn
    //   145: aload_0
    //   146: iconst_1
    //   147: anewarray 93	java/lang/Integer
    //   150: dup
    //   151: iconst_0
    //   152: iload_3
    //   153: bipush 100
    //   155: imul
    //   156: aload_1
    //   157: arraylength
    //   158: idiv
    //   159: iload_2
    //   160: bipush 100
    //   162: imul
    //   163: aload_1
    //   164: arraylength
    //   165: idiv
    //   166: aload_0
    //   167: getfield 31	agzw:jdField_a_of_type_ArrayOfAham	[Laham;
    //   170: arraylength
    //   171: idiv
    //   172: iadd
    //   173: ldc 94
    //   175: iand
    //   176: iload 4
    //   178: bipush 16
    //   180: ishl
    //   181: ior
    //   182: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: aastore
    //   186: invokevirtual 102	agzw:publishProgress	([Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 31	agzw:jdField_a_of_type_ArrayOfAham	[Laham;
    //   193: iload_2
    //   194: aaload
    //   195: astore 7
    //   197: ldc 82
    //   199: aload 7
    //   201: getfield 85	aham:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   204: invokevirtual 91	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   207: ifeq +340 -> 547
    //   210: aload 7
    //   212: getfield 85	aham:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   215: checkcast 82	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   218: astore 6
    //   220: aload 6
    //   222: getfield 141	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   225: astore 8
    //   227: ldc 143
    //   229: aload 8
    //   231: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +6 -> 240
    //   237: goto +310 -> 547
    //   240: aload_0
    //   241: aload 7
    //   243: putfield 148	agzw:jdField_a_of_type_Aham	Laham;
    //   246: aload_0
    //   247: getfield 20	agzw:jdField_a_of_type_Boolean	Z
    //   250: ifeq +164 -> 414
    //   253: aload 8
    //   255: ifnull +18 -> 273
    //   258: new 65	java/io/File
    //   261: dup
    //   262: aload 8
    //   264: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   267: invokevirtual 77	java/io/File:exists	()Z
    //   270: ifne +144 -> 414
    //   273: aload_0
    //   274: getfield 148	agzw:jdField_a_of_type_Aham	Laham;
    //   277: iconst_1
    //   278: putfield 149	aham:jdField_a_of_type_Boolean	Z
    //   281: aload_0
    //   282: getfield 15	agzw:jdField_a_of_type_Agzo	Lagzo;
    //   285: getfield 152	agzo:jdField_a_of_type_Ahap	Lahap;
    //   288: aload 6
    //   290: getfield 156	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Long	J
    //   293: aload 6
    //   295: getfield 158	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   298: iconst_2
    //   299: invokeinterface 163 5 0
    //   304: aload_0
    //   305: getfield 148	agzw:jdField_a_of_type_Aham	Laham;
    //   308: astore 7
    //   310: aload 7
    //   312: monitorenter
    //   313: aload_0
    //   314: getfield 148	agzw:jdField_a_of_type_Aham	Laham;
    //   317: getfield 149	aham:jdField_a_of_type_Boolean	Z
    //   320: ifeq +10 -> 330
    //   323: aload_0
    //   324: getfield 148	agzw:jdField_a_of_type_Aham	Laham;
    //   327: invokevirtual 168	java/lang/Object:wait	()V
    //   330: aload 7
    //   332: monitorexit
    //   333: aload 6
    //   335: getfield 170	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Boolean	Z
    //   338: ifeq +76 -> 414
    //   341: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +41 -> 385
    //   347: ldc 57
    //   349: iconst_2
    //   350: new 121	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   357: ldc 172
    //   359: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: iload_2
    //   363: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: ldc 177
    //   368: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload 6
    //   373: getfield 141	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   376: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aload_0
    //   386: aload_0
    //   387: getfield 31	agzw:jdField_a_of_type_ArrayOfAham	[Laham;
    //   390: arraylength
    //   391: iload_2
    //   392: isub
    //   393: putfield 179	agzw:jdField_a_of_type_Int	I
    //   396: bipush 11
    //   398: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   401: areturn
    //   402: astore_1
    //   403: aload 7
    //   405: monitorexit
    //   406: aload_1
    //   407: athrow
    //   408: astore_1
    //   409: iconst_2
    //   410: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   413: areturn
    //   414: aload_0
    //   415: getfield 20	agzw:jdField_a_of_type_Boolean	Z
    //   418: ifne +8 -> 426
    //   421: iconst_1
    //   422: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   425: areturn
    //   426: aload 6
    //   428: iconst_2
    //   429: invokevirtual 182	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   432: ifnonnull +115 -> 547
    //   435: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +41 -> 479
    //   441: ldc 57
    //   443: iconst_2
    //   444: new 121	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   451: ldc 184
    //   453: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload_2
    //   457: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: ldc 177
    //   462: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload 6
    //   467: getfield 141	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   470: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: aload_0
    //   480: aload_0
    //   481: getfield 31	agzw:jdField_a_of_type_ArrayOfAham	[Laham;
    //   484: arraylength
    //   485: iload_2
    //   486: isub
    //   487: putfield 179	agzw:jdField_a_of_type_Int	I
    //   490: bipush 11
    //   492: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   495: areturn
    //   496: aload_0
    //   497: aload_0
    //   498: getfield 31	agzw:jdField_a_of_type_ArrayOfAham	[Laham;
    //   501: aload_0
    //   502: getfield 20	agzw:jdField_a_of_type_Boolean	Z
    //   505: iload 5
    //   507: iload_3
    //   508: iload 4
    //   510: aload_1
    //   511: invokespecial 186	agzw:a	([Laham;ZIII[Ljava/lang/Integer;)I
    //   514: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   517: areturn
    //   518: iload_2
    //   519: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   522: areturn
    //   523: astore 8
    //   525: goto -195 -> 330
    //   528: iconst_0
    //   529: istore_3
    //   530: iconst_0
    //   531: istore_2
    //   532: goto -498 -> 34
    //   535: iload_3
    //   536: iconst_1
    //   537: iadd
    //   538: istore_3
    //   539: goto -505 -> 34
    //   542: iconst_0
    //   543: istore_2
    //   544: goto -420 -> 124
    //   547: iload_2
    //   548: iconst_1
    //   549: iadd
    //   550: istore_2
    //   551: goto -427 -> 124
    //   554: iload 4
    //   556: iconst_2
    //   557: if_icmpne +9 -> 566
    //   560: bipush 30
    //   562: istore_2
    //   563: goto -28 -> 535
    //   566: bipush 10
    //   568: istore_2
    //   569: goto -34 -> 535
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	this	agzw
    //   0	572	1	paramVarArgs	Integer[]
    //   124	445	2	i	int
    //   34	505	3	j	int
    //   46	512	4	k	int
    //   67	439	5	m	int
    //   218	248	6	localAIOImageData	AIOImageData
    //   225	38	8	str	String
    //   523	1	8	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   313	330	402	finally
    //   330	333	402	finally
    //   403	406	402	finally
    //   0	31	408	java/lang/Throwable
    //   34	60	408	java/lang/Throwable
    //   60	94	408	java/lang/Throwable
    //   124	145	408	java/lang/Throwable
    //   145	237	408	java/lang/Throwable
    //   240	253	408	java/lang/Throwable
    //   258	273	408	java/lang/Throwable
    //   273	313	408	java/lang/Throwable
    //   333	385	408	java/lang/Throwable
    //   385	396	408	java/lang/Throwable
    //   406	408	408	java/lang/Throwable
    //   414	426	408	java/lang/Throwable
    //   426	479	408	java/lang/Throwable
    //   479	496	408	java/lang/Throwable
    //   496	518	408	java/lang/Throwable
    //   313	330	523	java/lang/InterruptedException
  }
  
  protected void a(Integer paramInteger)
  {
    this.jdField_a_of_type_Agzo.b(paramInteger.intValue(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Agzo.jdField_a_of_type_Agzw = null;
  }
  
  protected void a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[(paramVarArgs.length - 1)].intValue();
    this.jdField_a_of_type_Agzo.c(i >> 16, 0xFFFF & i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzw
 * JD-Core Version:    0.7.0.1
 */