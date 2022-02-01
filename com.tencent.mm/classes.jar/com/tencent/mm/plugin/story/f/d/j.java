package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "", "localId", "", "storyId", "", "createTime", "username", "", "(IJILjava/lang/String;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "fakeVideoData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "getFakeVideoData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setFakeVideoData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getLocalId", "setLocalId", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getStoryId", "()J", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "getUsername", "setUsername", "videoType", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "getVideoType", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "setVideoType", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;)V", "canPlay", "", "equals", "other", "hashCode", "isFakeVideo", "isImageVideo", "isNormalVideo", "isVLogFakeVideo", "toString", "plugin-story_release"})
public final class j
{
  public k AMJ;
  public djl AMK;
  public c AML;
  public int dJd;
  public final long dKt;
  public int hZE;
  public String taskId;
  public String username;
  csd xue;
  
  public j(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    AppMethodBeat.i(118941);
    this.dJd = paramInt1;
    this.dKt = paramLong;
    this.hZE = paramInt2;
    this.username = paramString;
    this.AMJ = k.AMP;
    paramString = new djl();
    paramString.Url = "";
    paramString.GSI = "";
    paramString.Id = "";
    this.AMK = paramString;
    this.taskId = "";
    AppMethodBeat.o(118941);
  }
  
  private boolean eiL()
  {
    return this.AMJ == k.AMP;
  }
  
  public final boolean eiM()
  {
    return this.AMJ == k.AMN;
  }
  
  public final boolean eiN()
  {
    return this.AMJ != k.AMM;
  }
  
  public final boolean eiO()
  {
    AppMethodBeat.i(118939);
    if (eiM())
    {
      Object localObject = this.AML;
      if (localObject != null)
      {
        localObject = ((c)localObject).dEE().GdP;
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
  
  public final boolean eiP()
  {
    AppMethodBeat.i(118940);
    if (eiM())
    {
      Object localObject4 = (a)new afy();
      Object localObject1 = this.AML;
      if (localObject1 != null) {
        localObject1 = ((c)localObject1).field_baseItemData;
      }
      try
      {
        ((a)localObject4).parseFrom((byte[])localObject1);
        localObject1 = localObject4;
        localObject4 = (afy)localObject1;
        if ((localObject4 != null) && (((afy)localObject4).GdQ != null))
        {
          localObject1 = (a)new due();
          localObject4 = ((afy)localObject4).GdQ.toByteArray();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((a)localObject1).parseFrom((byte[])localObject4);
            if ((due)localObject1 == null) {
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
    if ((this.AMJ == k.AMM) && (((j)paramObject).AMJ == k.AMM))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((eiM()) && (((j)paramObject).eiM()) && (bt.lQ(this.taskId, ((j)paramObject).taskId)))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((eiL()) && (((j)paramObject).eiL()) && (this.dJd == ((j)paramObject).dJd))
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
    String str = "[VideoItem=" + hashCode() + ",localId=:" + this.dJd + ",storyId=" + this.dKt + ",videoType:=" + this.AMJ + ", username=" + this.username + ", url=" + this.AMK.Url + ']';
    AppMethodBeat.o(118938);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.j
 * JD-Core Version:    0.7.0.1
 */