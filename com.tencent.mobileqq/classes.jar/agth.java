class agth
  implements bfpc
{
  agth(agtc paramagtc) {}
  
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
    //   13: astore_2
    //   14: aload_0
    //   15: getfield 12	agth:a	Lagtc;
    //   18: getfield 42	agtc:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   21: invokevirtual 48	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   24: checkcast 50	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   27: aload_2
    //   28: invokevirtual 53	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:a	(Ljava/lang/String;)I
    //   31: iconst_1
    //   32: if_icmpne +93 -> 125
    //   35: aload_0
    //   36: getfield 12	agth:a	Lagtc;
    //   39: getfield 56	agtc:jdField_a_of_type_Agsb	Lagsb;
    //   42: invokevirtual 61	agsb:a	()Z
    //   45: ifeq +41 -> 86
    //   48: new 63	android/media/MediaMetadataRetriever
    //   51: dup
    //   52: invokespecial 64	android/media/MediaMetadataRetriever:<init>	()V
    //   55: astore_1
    //   56: aload_1
    //   57: aload_2
    //   58: invokevirtual 68	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: bipush 9
    //   64: invokevirtual 72	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   67: pop
    //   68: aload_1
    //   69: invokevirtual 75	android/media/MediaMetadataRetriever:release	()V
    //   72: return
    //   73: astore_2
    //   74: aload_1
    //   75: invokevirtual 75	android/media/MediaMetadataRetriever:release	()V
    //   78: return
    //   79: astore_2
    //   80: aload_1
    //   81: invokevirtual 75	android/media/MediaMetadataRetriever:release	()V
    //   84: aload_2
    //   85: athrow
    //   86: aload_0
    //   87: getfield 12	agth:a	Lagtc;
    //   90: getfield 42	agtc:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   93: invokevirtual 48	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   96: checkcast 50	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   99: getfield 78	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:a	Lagqu;
    //   102: ifnull -30 -> 72
    //   105: aload_0
    //   106: getfield 12	agth:a	Lagtc;
    //   109: getfield 42	agtc:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   112: invokevirtual 48	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   115: checkcast 50	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   118: getfield 78	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:a	Lagqu;
    //   121: invokevirtual 83	agqu:f	()V
    //   124: return
    //   125: aload_0
    //   126: getfield 12	agth:a	Lagtc;
    //   129: getfield 86	agtc:jdField_a_of_type_Agsr	Lagsr;
    //   132: getfield 91	agsr:a	Z
    //   135: ifeq +20 -> 155
    //   138: aload_0
    //   139: getfield 12	agth:a	Lagtc;
    //   142: getfield 42	agtc:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   145: invokevirtual 48	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   148: checkcast 50	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   151: invokevirtual 93	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:a	()V
    //   154: return
    //   155: aload_0
    //   156: getfield 12	agth:a	Lagtc;
    //   159: getfield 42	agtc:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   162: invokevirtual 48	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   165: checkcast 50	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   168: invokevirtual 96	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:b	()V
    //   171: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	agth
    //   0	172	1	paramAdapterView	com.tencent.widget.AdapterView<?>
    //   0	172	2	paramView	android.view.View
    //   0	172	3	paramInt	int
    //   0	172	4	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   56	68	73	java/lang/Exception
    //   56	68	79	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agth
 * JD-Core Version:    0.7.0.1
 */