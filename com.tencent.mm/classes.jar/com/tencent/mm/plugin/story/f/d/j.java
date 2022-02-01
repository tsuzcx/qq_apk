package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "", "localId", "", "storyId", "", "createTime", "username", "", "(IJILjava/lang/String;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "fakeVideoData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "getFakeVideoData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setFakeVideoData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getLocalId", "setLocalId", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getStoryId", "()J", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "getUsername", "setUsername", "videoType", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "getVideoType", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "setVideoType", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;)V", "canPlay", "", "equals", "other", "hashCode", "isFakeVideo", "isImageVideo", "isNormalVideo", "isVLogFakeVideo", "toString", "plugin-story_release"})
public final class j
{
  public int dwR;
  public final long dyg;
  public int hGU;
  public String taskId;
  public String username;
  cna wmo;
  public k zuO;
  public ddy zuP;
  public e zuQ;
  
  public j(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    AppMethodBeat.i(118941);
    this.dwR = paramInt1;
    this.dyg = paramLong;
    this.hGU = paramInt2;
    this.username = paramString;
    this.zuO = k.zuU;
    paramString = new ddy();
    paramString.Url = "";
    paramString.Fjh = "";
    paramString.Id = "";
    this.zuP = paramString;
    this.taskId = "";
    AppMethodBeat.o(118941);
  }
  
  private boolean dWw()
  {
    return this.zuO == k.zuU;
  }
  
  public final boolean dWA()
  {
    AppMethodBeat.i(118940);
    if (dWx())
    {
      Object localObject4 = (a)new adp();
      Object localObject1 = this.zuQ;
      if (localObject1 != null) {
        localObject1 = ((e)localObject1).field_baseItemData;
      }
      try
      {
        ((a)localObject4).parseFrom((byte[])localObject1);
        localObject1 = localObject4;
        localObject4 = (adp)localObject1;
        if ((localObject4 != null) && (((adp)localObject4).Ewq != null))
        {
          localObject1 = (a)new don();
          localObject4 = ((adp)localObject4).Ewq.toByteArray();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((a)localObject1).parseFrom((byte[])localObject4);
            if ((don)localObject1 == null) {
              break;
            }
            ac.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake isVLogFakeVideo");
            AppMethodBeat.o(118940);
            return true;
            localObject1 = null;
          }
          localException1 = localException1;
          ac.l("safeParser", "", new Object[] { localException1 });
          Object localObject2 = null;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ac.l("safeParser", "", new Object[] { localException2 });
            Object localObject3 = null;
          }
        }
      }
    }
    ac.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is not fake isVLogFakeVideo");
    AppMethodBeat.o(118940);
    return false;
  }
  
  public final boolean dWx()
  {
    return this.zuO == k.zuS;
  }
  
  public final boolean dWy()
  {
    return this.zuO != k.zuR;
  }
  
  public final boolean dWz()
  {
    AppMethodBeat.i(118939);
    if (dWx())
    {
      Object localObject = this.zuQ;
      if (localObject != null)
      {
        localObject = ((e)localObject).dui().Ewp;
        if ((localObject != null) && (((LinkedList)localObject).size() > 0))
        {
          ac.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake imageVideo");
          AppMethodBeat.o(118939);
          return true;
        }
      }
    }
    AppMethodBeat.o(118939);
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
    if ((this.zuO == k.zuR) && (((j)paramObject).zuO == k.zuR))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((dWx()) && (((j)paramObject).dWx()) && (bs.lr(this.taskId, ((j)paramObject).taskId)))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((dWw()) && (((j)paramObject).dWw()) && (this.dwR == ((j)paramObject).dwR))
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
    String str = "[VideoItem=" + hashCode() + ",localId=:" + this.dwR + ",storyId=" + this.dyg + ",videoType:=" + this.zuO + ", username=" + this.username + ", url=" + this.zuP.Url + ']';
    AppMethodBeat.o(118938);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.j
 * JD-Core Version:    0.7.0.1
 */