class aimz
  implements bhqp
{
  aimz(aimu paramaimu) {}
  
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
    //   15: getfield 12	aimz:a	Laimu;
    //   18: getfield 43	aimu:mActivity	Lcom/tencent/mobileqq/activity/photo/album/AbstractPhotoPreviewActivity;
    //   21: checkcast 45	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   24: aload_2
    //   25: invokevirtual 49	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:getMediaType	(Ljava/lang/String;)I
    //   28: iconst_1
    //   29: if_icmpne +87 -> 116
    //   32: aload_0
    //   33: getfield 12	aimz:a	Laimu;
    //   36: getfield 53	aimu:mPhotoCommonData	Laimj;
    //   39: invokevirtual 58	aimj:a	()Z
    //   42: ifeq +41 -> 83
    //   45: new 60	android/media/MediaMetadataRetriever
    //   48: dup
    //   49: invokespecial 61	android/media/MediaMetadataRetriever:<init>	()V
    //   52: astore_1
    //   53: aload_1
    //   54: aload_2
    //   55: invokevirtual 65	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   58: aload_1
    //   59: bipush 9
    //   61: invokevirtual 69	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   64: pop
    //   65: aload_1
    //   66: invokevirtual 72	android/media/MediaMetadataRetriever:release	()V
    //   69: return
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 72	android/media/MediaMetadataRetriever:release	()V
    //   75: return
    //   76: astore_2
    //   77: aload_1
    //   78: invokevirtual 72	android/media/MediaMetadataRetriever:release	()V
    //   81: aload_2
    //   82: athrow
    //   83: aload_0
    //   84: getfield 12	aimz:a	Laimu;
    //   87: getfield 43	aimu:mActivity	Lcom/tencent/mobileqq/activity/photo/album/AbstractPhotoPreviewActivity;
    //   90: checkcast 45	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   93: getfield 76	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:mVideoPlayController	Lailq;
    //   96: ifnull -27 -> 69
    //   99: aload_0
    //   100: getfield 12	aimz:a	Laimu;
    //   103: getfield 43	aimu:mActivity	Lcom/tencent/mobileqq/activity/photo/album/AbstractPhotoPreviewActivity;
    //   106: checkcast 45	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   109: getfield 76	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:mVideoPlayController	Lailq;
    //   112: invokevirtual 81	ailq:f	()V
    //   115: return
    //   116: aload_0
    //   117: getfield 12	aimz:a	Laimu;
    //   120: getfield 84	aimu:a	Laimr;
    //   123: getfield 90	aimr:showBar	Z
    //   126: ifeq +17 -> 143
    //   129: aload_0
    //   130: getfield 12	aimz:a	Laimu;
    //   133: getfield 43	aimu:mActivity	Lcom/tencent/mobileqq/activity/photo/album/AbstractPhotoPreviewActivity;
    //   136: checkcast 45	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   139: invokevirtual 93	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:hideMenuBar	()V
    //   142: return
    //   143: aload_0
    //   144: getfield 12	aimz:a	Laimu;
    //   147: getfield 43	aimu:mActivity	Lcom/tencent/mobileqq/activity/photo/album/AbstractPhotoPreviewActivity;
    //   150: checkcast 45	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity
    //   153: invokevirtual 96	com/tencent/mobileqq/activity/photo/album/NewPhotoPreviewActivity:showMenuBar	()V
    //   156: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	aimz
    //   0	157	1	paramAdapterView	com.tencent.widget.AdapterView<?>
    //   0	157	2	paramView	android.view.View
    //   0	157	3	paramInt	int
    //   0	157	4	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   53	65	70	java/lang/Exception
    //   53	65	76	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimz
 * JD-Core Version:    0.7.0.1
 */