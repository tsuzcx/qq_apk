import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;

public class agcd
  implements behi
{
  public agcd(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  /* Error */
  @android.annotation.TargetApi(11)
  public void onItemClick(com.tencent.widget.AdapterView<?> paramAdapterView, android.view.View paramView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   4: getfield 29	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:b	Z
    //   7: ifeq +12 -> 19
    //   10: aload_0
    //   11: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   14: iconst_0
    //   15: invokevirtual 32	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:a	(Z)V
    //   18: return
    //   19: aload_1
    //   20: invokevirtual 38	com/tencent/widget/AdapterView:getAdapter	()Landroid/widget/Adapter;
    //   23: iload_3
    //   24: invokeinterface 44 2 0
    //   29: checkcast 46	java/lang/String
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   37: aload_1
    //   38: invokevirtual 49	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:a	(Ljava/lang/String;)I
    //   41: iconst_1
    //   42: if_icmpne +346 -> 388
    //   45: aload_0
    //   46: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   49: getfield 52	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:E	Z
    //   52: ifeq +31 -> 83
    //   55: aload_0
    //   56: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   59: getfield 55	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:a	Lagew;
    //   62: ifnull -44 -> 18
    //   65: aload_2
    //   66: invokevirtual 61	android/view/View:getContext	()Landroid/content/Context;
    //   69: ifnull -51 -> 18
    //   72: aload_0
    //   73: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   76: getfield 55	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:a	Lagew;
    //   79: invokevirtual 66	agew:f	()V
    //   82: return
    //   83: aload_0
    //   84: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   87: invokestatic 70	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:c	(Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;)Z
    //   90: ifeq +81 -> 171
    //   93: new 72	android/media/MediaMetadataRetriever
    //   96: dup
    //   97: invokespecial 73	android/media/MediaMetadataRetriever:<init>	()V
    //   100: astore_2
    //   101: aload_2
    //   102: aload_1
    //   103: invokevirtual 77	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   106: aload_2
    //   107: bipush 9
    //   109: invokevirtual 81	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   112: astore 6
    //   114: aload_2
    //   115: invokevirtual 84	android/media/MediaMetadataRetriever:release	()V
    //   118: aload_0
    //   119: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   122: getfield 87	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:o	Z
    //   125: ifeq +101 -> 226
    //   128: iconst_0
    //   129: istore_3
    //   130: ldc 89
    //   132: ldc 91
    //   134: iload_3
    //   135: iconst_0
    //   136: iconst_2
    //   137: anewarray 46	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: ldc 93
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: new 95	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   154: ldc 93
    //   156: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 6
    //   161: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: aastore
    //   168: invokestatic 109	urp:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   171: aload_0
    //   172: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   175: aload_1
    //   176: putfield 113	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:p	Ljava/lang/String;
    //   179: aload_0
    //   180: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   183: invokevirtual 116	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:a	()I
    //   186: tableswitch	default:+30 -> 216, 0:+31->217, 1:+177->363, 2:+185->371, 3:+193->379
    //   217: aload_0
    //   218: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   221: iconst_0
    //   222: invokevirtual 119	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:a	(I)V
    //   225: return
    //   226: iconst_1
    //   227: istore_3
    //   228: goto -98 -> 130
    //   231: astore 6
    //   233: aload_2
    //   234: invokevirtual 84	android/media/MediaMetadataRetriever:release	()V
    //   237: aload_0
    //   238: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   241: getfield 87	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:o	Z
    //   244: ifeq +49 -> 293
    //   247: iconst_0
    //   248: istore_3
    //   249: ldc 89
    //   251: ldc 91
    //   253: iload_3
    //   254: iconst_0
    //   255: iconst_2
    //   256: anewarray 46	java/lang/String
    //   259: dup
    //   260: iconst_0
    //   261: ldc 93
    //   263: aastore
    //   264: dup
    //   265: iconst_1
    //   266: new 95	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   273: ldc 93
    //   275: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 93
    //   280: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: aastore
    //   287: invokestatic 109	urp:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   290: goto -119 -> 171
    //   293: iconst_1
    //   294: istore_3
    //   295: goto -46 -> 249
    //   298: astore_1
    //   299: aload_2
    //   300: invokevirtual 84	android/media/MediaMetadataRetriever:release	()V
    //   303: aload_0
    //   304: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   307: getfield 87	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:o	Z
    //   310: ifeq +48 -> 358
    //   313: iconst_0
    //   314: istore_3
    //   315: ldc 89
    //   317: ldc 91
    //   319: iload_3
    //   320: iconst_0
    //   321: iconst_2
    //   322: anewarray 46	java/lang/String
    //   325: dup
    //   326: iconst_0
    //   327: ldc 93
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: new 95	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   339: ldc 93
    //   341: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc 93
    //   346: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: aastore
    //   353: invokestatic 109	urp:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   356: aload_1
    //   357: athrow
    //   358: iconst_1
    //   359: istore_3
    //   360: goto -45 -> 315
    //   363: aload_0
    //   364: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   367: invokevirtual 122	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:m	()V
    //   370: return
    //   371: aload_0
    //   372: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   375: invokevirtual 125	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:l	()V
    //   378: return
    //   379: aload_0
    //   380: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   383: iconst_0
    //   384: invokevirtual 119	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:a	(I)V
    //   387: return
    //   388: aload_0
    //   389: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   392: getfield 128	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:g	Z
    //   395: ifeq +11 -> 406
    //   398: aload_0
    //   399: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   402: invokevirtual 131	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:e	()V
    //   405: return
    //   406: aload_0
    //   407: getfield 12	agcd:a	Lcom/tencent/mobileqq/activity/photo/PhotoPreviewActivity;
    //   410: invokevirtual 132	com/tencent/mobileqq/activity/photo/PhotoPreviewActivity:f	()V
    //   413: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	agcd
    //   0	414	1	paramAdapterView	com.tencent.widget.AdapterView<?>
    //   0	414	2	paramView	android.view.View
    //   0	414	3	paramInt	int
    //   0	414	4	paramLong	long
    //   112	48	6	str	java.lang.String
    //   231	1	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   101	114	231	java/lang/Exception
    //   101	114	298	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agcd
 * JD-Core Version:    0.7.0.1
 */