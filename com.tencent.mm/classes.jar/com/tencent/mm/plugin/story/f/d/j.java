package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "", "localId", "", "storyId", "", "createTime", "username", "", "(IJILjava/lang/String;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "fakeVideoData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "getFakeVideoData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setFakeVideoData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getLocalId", "setLocalId", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getStoryId", "()J", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "getUsername", "setUsername", "videoType", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "getVideoType", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "setVideoType", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;)V", "canPlay", "", "equals", "other", "hashCode", "isFakeVideo", "isImageVideo", "isNormalVideo", "isVLogFakeVideo", "toString", "plugin-story_release"})
public final class j
{
  public final long dAu;
  public int dzf;
  public int hgr;
  public String taskId;
  public String username;
  chx vdy;
  public k yhO;
  public cym yhP;
  public d yhQ;
  
  public j(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    AppMethodBeat.i(118941);
    this.dzf = paramInt1;
    this.dAu = paramLong;
    this.hgr = paramInt2;
    this.username = paramString;
    this.yhO = k.yhU;
    paramString = new cym();
    paramString.Url = "";
    paramString.DMQ = "";
    paramString.Id = "";
    this.yhP = paramString;
    this.taskId = "";
    AppMethodBeat.o(118941);
  }
  
  private boolean dHV()
  {
    return this.yhO == k.yhU;
  }
  
  public final boolean dHW()
  {
    return this.yhO == k.yhS;
  }
  
  public final boolean dHX()
  {
    return this.yhO != k.yhR;
  }
  
  public final boolean dHY()
  {
    AppMethodBeat.i(118939);
    if (dHW())
    {
      Object localObject = this.yhQ;
      if (localObject != null)
      {
        localObject = ((d)localObject).dgA().Ddj;
        if ((localObject != null) && (((LinkedList)localObject).size() > 0))
        {
          ad.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake imageVideo");
          AppMethodBeat.o(118939);
          return true;
        }
      }
    }
    AppMethodBeat.o(118939);
    return false;
  }
  
  public final boolean dHZ()
  {
    AppMethodBeat.i(118940);
    if (dHW())
    {
      Object localObject4 = (a)new acq();
      Object localObject1 = this.yhQ;
      if (localObject1 != null) {
        localObject1 = ((d)localObject1).field_baseItemData;
      }
      try
      {
        ((a)localObject4).parseFrom((byte[])localObject1);
        localObject1 = localObject4;
        localObject4 = (acq)localObject1;
        if ((localObject4 != null) && (((acq)localObject4).Ddk != null))
        {
          localObject1 = (a)new diy();
          localObject4 = ((acq)localObject4).Ddk.toByteArray();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((a)localObject1).parseFrom((byte[])localObject4);
            if ((diy)localObject1 == null) {
              break;
            }
            ad.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake isVLogFakeVideo");
            AppMethodBeat.o(118940);
            return true;
            localObject1 = null;
          }
          localException1 = localException1;
          ad.l("safeParser", "", new Object[] { localException1 });
          Object localObject2 = null;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.l("safeParser", "", new Object[] { localException2 });
            Object localObject3 = null;
          }
        }
      }
    }
    ad.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is not fake isVLogFakeVideo");
    AppMethodBeat.o(118940);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118936);
    if (!(paramObject instanceof j))
    {
      AppMethodBeat.o(118936);
      return false;
    }
    if ((j)this == paramObject)
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((this.yhO == k.yhR) && (((j)paramObject).yhO == k.yhR))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((dHW()) && (((j)paramObject).dHW()) && (bt.kU(this.taskId, ((j)paramObject).taskId)))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((dHV()) && (((j)paramObject).dHV()) && (this.dzf == ((j)paramObject).dzf))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    AppMethodBeat.o(118936);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118937);
    int i = super.hashCode();
    AppMethodBeat.o(118937);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118938);
    String str = "[VideoItem=" + hashCode() + ",localId=:" + this.dzf + ",storyId=" + this.dAu + ",videoType:=" + this.yhO + ", username=" + this.username + ", url=" + this.yhP.Url + ']';
    AppMethodBeat.o(118938);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.j
 * JD-Core Version:    0.7.0.1
 */