class aghg
  implements behi
{
  aghg(aggx paramaggx) {}
  
  /* Error */
  @android.annotation.TargetApi(11)
  public void onItemClick(com.tencent.widget.AdapterView<?> paramAdapterView, android.view.View paramView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 29	com/tencent/widget/AdapterView:getAdapter	()Landroid/widget/Adapter;
    //   4: iload_3
    //   5: invokeinterface 35 2 0
    //   10: checkcast 37	java/lang/String
    //   13: astore 6
    //   15: aload_0
    //   16: getfield 12	aghg:a	Laggx;
    //   19: getfield 42	aggx:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   22: invokevirtual 48	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   25: checkcast 50	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   28: aload 6
    //   30: invokevirtual 53	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:a	(Ljava/lang/String;)I
    //   33: iconst_1
    //   34: if_icmpne +101 -> 135
    //   37: aload_0
    //   38: getfield 12	aghg:a	Laggx;
    //   41: getfield 56	aggx:jdField_a_of_type_Aggf	Laggf;
    //   44: invokevirtual 61	aggf:a	()Z
    //   47: ifeq +42 -> 89
    //   50: new 63	android/media/MediaMetadataRetriever
    //   53: dup
    //   54: invokespecial 64	android/media/MediaMetadataRetriever:<init>	()V
    //   57: astore_1
    //   58: aload_1
    //   59: aload 6
    //   61: invokevirtual 68	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   64: aload_1
    //   65: bipush 9
    //   67: invokevirtual 72	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   70: pop
    //   71: aload_1
    //   72: invokevirtual 75	android/media/MediaMetadataRetriever:release	()V
    //   75: return
    //   76: astore_2
    //   77: aload_1
    //   78: invokevirtual 75	android/media/MediaMetadataRetriever:release	()V
    //   81: return
    //   82: astore_2
    //   83: aload_1
    //   84: invokevirtual 75	android/media/MediaMetadataRetriever:release	()V
    //   87: aload_2
    //   88: athrow
    //   89: aload_0
    //   90: getfield 12	aghg:a	Laggx;
    //   93: getfield 42	aggx:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   96: invokevirtual 48	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   99: checkcast 50	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   102: getfield 78	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:a	Lagew;
    //   105: ifnull -30 -> 75
    //   108: aload_2
    //   109: invokevirtual 84	android/view/View:getContext	()Landroid/content/Context;
    //   112: ifnull -37 -> 75
    //   115: aload_0
    //   116: getfield 12	aghg:a	Laggx;
    //   119: getfield 42	aggx:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   122: invokevirtual 48	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   125: checkcast 50	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   128: getfield 78	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:a	Lagew;
    //   131: invokevirtual 89	agew:f	()V
    //   134: return
    //   135: aload_0
    //   136: getfield 12	aghg:a	Laggx;
    //   139: getfield 92	aggx:jdField_a_of_type_Aggs	Laggs;
    //   142: getfield 97	aggs:a	Z
    //   145: ifeq +20 -> 165
    //   148: aload_0
    //   149: getfield 12	aghg:a	Laggx;
    //   152: getfield 42	aggx:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   155: invokevirtual 48	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   158: checkcast 50	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   161: invokevirtual 100	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:b	()V
    //   164: return
    //   165: aload_0
    //   166: getfield 12	aghg:a	Laggx;
    //   169: getfield 42	aggx:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   172: invokevirtual 48	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   175: checkcast 50	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   178: invokevirtual 103	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:d	()V
    //   181: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	aghg
    //   0	182	1	paramAdapterView	com.tencent.widget.AdapterView<?>
    //   0	182	2	paramView	android.view.View
    //   0	182	3	paramInt	int
    //   0	182	4	paramLong	long
    //   13	47	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   58	71	76	java/lang/Exception
    //   58	71	82	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghg
 * JD-Core Version:    0.7.0.1
 */