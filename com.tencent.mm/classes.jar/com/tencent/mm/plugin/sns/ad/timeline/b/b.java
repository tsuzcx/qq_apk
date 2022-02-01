package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.timeline.helper.j;
import com.tencent.mm.plugin.sns.ad.timeline.video.online.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.q;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends q
{
  private boolean Qbd = false;
  private String Qbe = "";
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(311219);
    if (this.Qbd)
    {
      Log.d("SnsAd.AdSightTimeLineItem", "the new video  item is online video");
      if (paramBaseViewHolder == null)
      {
        Log.e("SnsAd.AdSightTimeLineItem", "the holder is null");
        AppMethodBeat.o(311219);
        return;
      }
      dmz localdmz = j.a(paramBaseViewHolder);
      String str1 = j.c(paramBaseViewHolder);
      SnsInfo localSnsInfo = al.hgB().aZL(paramBaseViewHolder.hES);
      l locall = j.a(this.QBJ);
      String str2 = paramBaseViewHolder.hES;
      if ((localdmz == null) || (str1 == null) || (localSnsInfo == null))
      {
        Log.e("SnsAd.AdSightTimeLineItem", "the media , timelineId, sns info is null");
        AppMethodBeat.o(311219);
        return;
      }
      com.tencent.mm.plugin.sns.ui.video.b.hsi().pause();
      hce();
      paramBaseViewHolder = (FrameLayout)paramBaseViewHolder.Qcj.RjL.findViewById(b.f.sns_video_container);
      d locald = new d("SnsAd.AdSightTimeLineItem");
      locald.mContainer = paramBaseViewHolder;
      locald.QcU = localdmz;
      locald.PJQ = localSnsInfo;
      locald.yqW = str2;
      locald.Qbe = str1;
      locald.PYh = locall;
      locald.a(1, new SnsTimelineVideoView.b()
      {
        public final void ZW(String paramAnonymousString)
        {
          AppMethodBeat.i(311177);
          if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(b.a(b.this))))
          {
            Log.w("SnsAd.AdSightTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + paramAnonymousString + ", the timelineId is " + b.a(b.this));
            b.b(b.this);
          }
          AppMethodBeat.o(311177);
        }
      });
      AppMethodBeat.o(311219);
      return;
    }
    Log.d("SnsAd.AdSightTimeLineItem", "the new video item is running, execute super play!");
    super.a(paramBaseViewHolder, paramInt);
    AppMethodBeat.o(311219);
  }
  
  /* Error */
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.ui.bo parambo, com.tencent.mm.protocal.protobuf.TimeLineObject paramTimeLineObject, int paramInt2, com.tencent.mm.plugin.sns.ui.bn parambn)
  {
    // Byte code:
    //   0: ldc 164
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: ifnull +24 -> 30
    //   9: aload_3
    //   10: getfield 167	com/tencent/mm/plugin/sns/ui/bo:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: aload_3
    //   18: getfield 167	com/tencent/mm/plugin/sns/ui/bo:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   21: invokevirtual 173	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   24: invokestatic 178	com/tencent/mm/plugin/sns/ad/timeline/helper/b:c	(Lcom/tencent/mm/plugin/sns/storage/ADXml;)Z
    //   27: putfield 19	com/tencent/mm/plugin/sns/ad/timeline/b/b:Qbd	Z
    //   30: aload 4
    //   32: ifnull +20 -> 52
    //   35: aload 4
    //   37: getfield 183	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   40: ifnull +12 -> 52
    //   43: aload_0
    //   44: aload 4
    //   46: getfield 183	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   49: putfield 23	com/tencent/mm/plugin/sns/ad/timeline/b/b:Qbe	Ljava/lang/String;
    //   52: aload 4
    //   54: getfield 187	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   57: ifnull +81 -> 138
    //   60: aload 4
    //   62: getfield 187	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   65: getfield 193	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
    //   68: invokevirtual 199	java/util/LinkedList:size	()I
    //   71: ifle +67 -> 138
    //   74: aload 4
    //   76: getfield 187	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   79: getfield 193	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
    //   82: iconst_0
    //   83: invokevirtual 203	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   86: checkcast 205	com/tencent/mm/protocal/protobuf/dmz
    //   89: astore 7
    //   91: aload_3
    //   92: getfield 208	com/tencent/mm/plugin/sns/ui/bo:Rbg	Z
    //   95: ifeq +19 -> 114
    //   98: aload_0
    //   99: getfield 19	com/tencent/mm/plugin/sns/ad/timeline/b/b:Qbd	Z
    //   102: ifeq +42 -> 144
    //   105: aload_3
    //   106: getfield 167	com/tencent/mm/plugin/sns/ui/bo:PJQ	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   109: aload 7
    //   111: invokestatic 213	com/tencent/mm/plugin/sns/ad/d/e:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/protocal/protobuf/dmz;)V
    //   114: aload_0
    //   115: aload_1
    //   116: iload_2
    //   117: aload_3
    //   118: aload 4
    //   120: iload 5
    //   122: aload 6
    //   124: invokespecial 215	com/tencent/mm/plugin/sns/ui/item/q:a	(Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder;ILcom/tencent/mm/plugin/sns/ui/bo;Lcom/tencent/mm/protocal/protobuf/TimeLineObject;ILcom/tencent/mm/plugin/sns/ui/bn;)V
    //   127: aload_3
    //   128: iconst_3
    //   129: invokestatic 218	com/tencent/mm/plugin/sns/ad/timeline/b/b:a	(Lcom/tencent/mm/plugin/sns/ui/bo;I)V
    //   132: ldc 164
    //   134: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: return
    //   138: aconst_null
    //   139: astore 7
    //   141: goto -50 -> 91
    //   144: aload 7
    //   146: iconst_0
    //   147: invokestatic 221	com/tencent/mm/plugin/sns/ad/d/e:a	(Lcom/tencent/mm/protocal/protobuf/dmz;Z)V
    //   150: goto -36 -> 114
    //   153: astore 7
    //   155: goto -125 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	b
    //   0	158	1	paramBaseViewHolder	BaseTimeLineItem.BaseViewHolder
    //   0	158	2	paramInt1	int
    //   0	158	3	parambo	com.tencent.mm.plugin.sns.ui.bo
    //   0	158	4	paramTimeLineObject	com.tencent.mm.protocal.protobuf.TimeLineObject
    //   0	158	5	paramInt2	int
    //   0	158	6	parambn	com.tencent.mm.plugin.sns.ui.bn
    //   89	56	7	localdmz	dmz
    //   153	1	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	30	153	finally
  }
  
  public final boolean hbX()
  {
    return this.Qbd;
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.b
 * JD-Core Version:    0.7.0.1
 */