import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

public class aigl
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString = "android.support.v4.";
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(1024);
  private Thread jdField_a_of_type_JavaLangThread;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "java.", "android.", "com.android.", "dalvik.", "com.google", "libcore.", "sun.", "com.qihoo360.", "com.lbe." };
  private int b;
  private int c;
  private final int d;
  
  public aigl(UnifiedMonitor paramUnifiedMonitor, int paramInt, Thread paramThread)
  {
    this.jdField_d_of_type_Int = 10;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_a_of_type_Int;
    if (UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_d_of_type_Int > UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_a_of_type_Int) {}
    for (int i = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_d_of_type_Int - UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_a_of_type_Int;; i = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_d_of_type_Int)
    {
      this.c = i;
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].c);
      this.jdField_a_of_type_JavaLangThread = paramThread;
      return;
    }
  }
  
  private String a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject = this.jdField_a_of_type_JavaLangThread.getStackTrace();
        if (localObject == null) {
          return null;
        }
        if (!paramBoolean) {
          break label271;
        }
        return Arrays.toString((Object[])localObject);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        String str;
        String[] arrayOfString;
        int m;
        if (!QLog.isColorLevel()) {
          break label264;
        }
        QLog.d("UnifiedMonitor", 2, "", localThrowable);
      }
      if (k < localObject.length)
      {
        str = localObject[k].toString();
        arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        m = arrayOfString.length;
        j = 0;
        if (j < m)
        {
          if (!str.startsWith(arrayOfString[j])) {
            break label297;
          }
          if (!str.startsWith("android.support.v4.")) {
            break label292;
          }
          j = 0;
          break label279;
        }
      }
      else
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          j = UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor)[this.jdField_a_of_type_Int].i;
          i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1 - j;
          if ((i >= 0) && (i > this.jdField_a_of_type_JavaUtilArrayList.size() - 1 - j - UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor)[this.jdField_a_of_type_Int].c))
          {
            this.jdField_a_of_type_JavaLangStringBuilder.append((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).append(",");
            i -= 1;
            continue;
            this.jdField_a_of_type_JavaUtilArrayList.add(str);
            break label315;
          }
          if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0)
          {
            localObject = this.jdField_a_of_type_JavaLangStringBuilder.toString();
            return localObject;
          }
          return null;
        }
        label264:
        return null;
      }
      int j = 0;
      break label279;
      label271:
      int k = 0;
      int i = 0;
      continue;
      for (;;)
      {
        label279:
        if (j == 0) {
          break label304;
        }
        j = i;
        if (i == 0) {
          break label315;
        }
        break;
        label292:
        j = 1;
      }
      label297:
      j += 1;
      continue;
      label304:
      j = i;
      if (i == 0)
      {
        j = 1;
        continue;
        label315:
        k += 1;
        i = j;
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 156	java/util/Random
    //   3: dup
    //   4: invokespecial 157	java/util/Random:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   13: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   16: aload_0
    //   17: getfield 61	aigl:jdField_a_of_type_Int	I
    //   20: aaload
    //   21: getfield 160	aigj:g	I
    //   24: aload_0
    //   25: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   28: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   31: aload_0
    //   32: getfield 61	aigl:jdField_a_of_type_Int	I
    //   35: aaload
    //   36: getfield 161	aigj:jdField_b_of_type_Int	I
    //   39: if_icmplt +15 -> 54
    //   42: aload_0
    //   43: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   46: aload_0
    //   47: getfield 61	aigl:jdField_a_of_type_Int	I
    //   50: invokestatic 164	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;I)V
    //   53: return
    //   54: aload_0
    //   55: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   58: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   61: aload_0
    //   62: getfield 61	aigl:jdField_a_of_type_Int	I
    //   65: aaload
    //   66: getfield 167	aigj:jdField_b_of_type_Long	J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifne +19 -> 90
    //   74: aload_0
    //   75: getfield 71	aigl:jdField_b_of_type_Int	I
    //   78: i2l
    //   79: invokestatic 171	java/lang/Thread:sleep	(J)V
    //   82: goto -73 -> 9
    //   85: astore 6
    //   87: goto -78 -> 9
    //   90: aload_0
    //   91: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   94: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   97: aload_0
    //   98: getfield 61	aigl:jdField_a_of_type_Int	I
    //   101: aaload
    //   102: getfield 167	aigj:jdField_b_of_type_Long	J
    //   105: lstore_1
    //   106: lload_1
    //   107: lconst_0
    //   108: lcmp
    //   109: ifne +19 -> 128
    //   112: aload_0
    //   113: getfield 71	aigl:jdField_b_of_type_Int	I
    //   116: i2l
    //   117: invokestatic 171	java/lang/Thread:sleep	(J)V
    //   120: goto -111 -> 9
    //   123: astore 6
    //   125: goto -116 -> 9
    //   128: invokestatic 177	android/os/SystemClock:uptimeMillis	()J
    //   131: aload_0
    //   132: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   135: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   138: aload_0
    //   139: getfield 61	aigl:jdField_a_of_type_Int	I
    //   142: aaload
    //   143: getfield 167	aigj:jdField_b_of_type_Long	J
    //   146: lsub
    //   147: aload_0
    //   148: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   151: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   154: aload_0
    //   155: getfield 61	aigl:jdField_a_of_type_Int	I
    //   158: aaload
    //   159: getfield 69	aigj:jdField_a_of_type_Int	I
    //   162: i2l
    //   163: lsub
    //   164: lstore_3
    //   165: lload_3
    //   166: ldc2_w 178
    //   169: lcmp
    //   170: ifge +10 -> 180
    //   173: lload_3
    //   174: lneg
    //   175: lstore_3
    //   176: lload_3
    //   177: invokestatic 171	java/lang/Thread:sleep	(J)V
    //   180: lload_1
    //   181: aload_0
    //   182: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   185: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   188: aload_0
    //   189: getfield 61	aigl:jdField_a_of_type_Int	I
    //   192: aaload
    //   193: getfield 167	aigj:jdField_b_of_type_Long	J
    //   196: lcmp
    //   197: ifne -188 -> 9
    //   200: aload_0
    //   201: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   204: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   207: aload_0
    //   208: getfield 61	aigl:jdField_a_of_type_Int	I
    //   211: aaload
    //   212: aload_0
    //   213: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   216: aload_0
    //   217: getfield 61	aigl:jdField_a_of_type_Int	I
    //   220: iconst_0
    //   221: invokevirtual 183	com/tencent/mobileqq/statistics/UnifiedMonitor:whetherReportThisTime	(IZ)Z
    //   224: putfield 186	aigj:jdField_b_of_type_Boolean	Z
    //   227: aload_0
    //   228: getfield 61	aigl:jdField_a_of_type_Int	I
    //   231: ifeq +30 -> 261
    //   234: aload_0
    //   235: getfield 61	aigl:jdField_a_of_type_Int	I
    //   238: bipush 10
    //   240: if_icmpeq +21 -> 261
    //   243: aload_0
    //   244: getfield 61	aigl:jdField_a_of_type_Int	I
    //   247: bipush 14
    //   249: if_icmpeq +12 -> 261
    //   252: aload_0
    //   253: getfield 61	aigl:jdField_a_of_type_Int	I
    //   256: bipush 19
    //   258: if_icmpne +131 -> 389
    //   261: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +125 -> 389
    //   267: ldc2_w 187
    //   270: invokestatic 171	java/lang/Thread:sleep	(J)V
    //   273: lload_1
    //   274: aload_0
    //   275: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   278: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   281: aload_0
    //   282: getfield 61	aigl:jdField_a_of_type_Int	I
    //   285: aaload
    //   286: getfield 167	aigj:jdField_b_of_type_Long	J
    //   289: lcmp
    //   290: ifne +80 -> 370
    //   293: aload_0
    //   294: iconst_1
    //   295: invokespecial 190	aigl:a	(Z)Ljava/lang/String;
    //   298: astore 6
    //   300: ldc 146
    //   302: iconst_2
    //   303: aload 6
    //   305: invokestatic 194	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload_0
    //   309: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   312: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   315: aload_0
    //   316: getfield 61	aigl:jdField_a_of_type_Int	I
    //   319: aaload
    //   320: aload 6
    //   322: putfield 195	aigj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   325: aload_0
    //   326: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   329: invokestatic 198	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)Landroid/os/Handler;
    //   332: iconst_2
    //   333: invokestatic 204	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   336: astore 6
    //   338: aload 6
    //   340: aload_0
    //   341: getfield 61	aigl:jdField_a_of_type_Int	I
    //   344: putfield 207	android/os/Message:arg1	I
    //   347: aload_0
    //   348: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   351: invokestatic 198	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)Landroid/os/Handler;
    //   354: aload 6
    //   356: lload_1
    //   357: invokestatic 177	android/os/SystemClock:uptimeMillis	()J
    //   360: lneg
    //   361: ladd
    //   362: ldc2_w 208
    //   365: ladd
    //   366: invokevirtual 215	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   369: pop
    //   370: aload_0
    //   371: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   374: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   377: aload_0
    //   378: getfield 61	aigl:jdField_a_of_type_Int	I
    //   381: aaload
    //   382: lconst_0
    //   383: putfield 167	aigj:jdField_b_of_type_Long	J
    //   386: goto -377 -> 9
    //   389: aload_0
    //   390: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   393: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   396: aload_0
    //   397: getfield 61	aigl:jdField_a_of_type_Int	I
    //   400: aaload
    //   401: getfield 186	aigj:jdField_b_of_type_Boolean	Z
    //   404: ifeq -34 -> 370
    //   407: aload 5
    //   409: aload_0
    //   410: getfield 74	aigl:c	I
    //   413: invokevirtual 219	java/util/Random:nextInt	(I)I
    //   416: i2l
    //   417: lstore_3
    //   418: lload_3
    //   419: invokestatic 171	java/lang/Thread:sleep	(J)V
    //   422: lload_1
    //   423: aload_0
    //   424: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   427: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   430: aload_0
    //   431: getfield 61	aigl:jdField_a_of_type_Int	I
    //   434: aaload
    //   435: getfield 167	aigj:jdField_b_of_type_Long	J
    //   438: lcmp
    //   439: ifne -69 -> 370
    //   442: aload_0
    //   443: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   446: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   449: aload_0
    //   450: getfield 61	aigl:jdField_a_of_type_Int	I
    //   453: aaload
    //   454: getfield 221	aigj:jdField_d_of_type_Boolean	Z
    //   457: ifeq +57 -> 514
    //   460: ldc 146
    //   462: iconst_1
    //   463: new 28	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   470: aload_0
    //   471: getfield 82	aigl:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   474: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   477: ldc 227
    //   479: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_0
    //   483: iconst_1
    //   484: invokespecial 190	aigl:a	(Z)Ljava/lang/String;
    //   487: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload_0
    //   497: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   500: aload_0
    //   501: getfield 61	aigl:jdField_a_of_type_Int	I
    //   504: aload_0
    //   505: getfield 82	aigl:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   508: invokestatic 232	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;ILjava/lang/Thread;)V
    //   511: goto -141 -> 370
    //   514: aload_0
    //   515: getfield 21	aigl:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   518: invokestatic 66	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Laigj;
    //   521: aload_0
    //   522: getfield 61	aigl:jdField_a_of_type_Int	I
    //   525: aaload
    //   526: aload_0
    //   527: iconst_1
    //   528: invokespecial 190	aigl:a	(Z)Ljava/lang/String;
    //   531: putfield 195	aigj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   534: goto -164 -> 370
    //   537: astore 6
    //   539: goto -530 -> 9
    //   542: astore 6
    //   544: goto -535 -> 9
    //   547: astore 6
    //   549: goto -540 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	aigl
    //   105	318	1	l1	long
    //   164	255	3	l2	long
    //   7	401	5	localRandom	java.util.Random
    //   85	1	6	localInterruptedException1	java.lang.InterruptedException
    //   123	1	6	localInterruptedException2	java.lang.InterruptedException
    //   298	57	6	localObject	Object
    //   537	1	6	localInterruptedException3	java.lang.InterruptedException
    //   542	1	6	localInterruptedException4	java.lang.InterruptedException
    //   547	1	6	localInterruptedException5	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   74	82	85	java/lang/InterruptedException
    //   112	120	123	java/lang/InterruptedException
    //   176	180	537	java/lang/InterruptedException
    //   267	273	542	java/lang/InterruptedException
    //   418	422	547	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aigl
 * JD-Core Version:    0.7.0.1
 */