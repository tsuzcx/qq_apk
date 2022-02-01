package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "", "localId", "", "storyId", "", "createTime", "username", "", "(IJILjava/lang/String;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "fakeVideoData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "getFakeVideoData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setFakeVideoData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getLocalId", "setLocalId", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getStoryId", "()J", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "getUsername", "setUsername", "videoType", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "getVideoType", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "setVideoType", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;)V", "canPlay", "", "equals", "other", "hashCode", "isFakeVideo", "isImageVideo", "isNormalVideo", "isVLogFakeVideo", "toString", "plugin-story_release"})
public final class j
{
  public k Bel;
  public dkg Bem;
  public c Ben;
  public int dKr;
  public final long dLI;
  public int icw;
  public String taskId;
  public String username;
  csx xKb;
  
  public j(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    AppMethodBeat.i(118941);
    this.dKr = paramInt1;
    this.dLI = paramLong;
    this.icw = paramInt2;
    this.username = paramString;
    this.Bel = k.Ber;
    paramString = new dkg();
    paramString.Url = "";
    paramString.Hmj = "";
    paramString.Id = "";
    this.Bem = paramString;
    this.taskId = "";
    AppMethodBeat.o(118941);
  }
  
  private boolean emt()
  {
    return this.Bel == k.Ber;
  }
  
  public final boolean emu()
  {
    return this.Bel == k.Bep;
  }
  
  public final boolean emv()
  {
    return this.Bel != k.Beo;
  }
  
  public final boolean emw()
  {
    AppMethodBeat.i(118939);
    if (emu())
    {
      Object localObject = this.Ben;
      if (localObject != null)
      {
        localObject = ((c)localObject).dHV().Gww;
        if ((localObject != null) && (((LinkedList)localObject).size() > 0))
        {
          ae.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake imageVideo");
          AppMethodBeat.o(118939);
          return true;
        }
      }
    }
    AppMethodBeat.o(118939);
    return false;
  }
  
  public final boolean emx()
  {
    AppMethodBeat.i(118940);
    if (emu())
    {
      Object localObject4 = (a)new agh();
      Object localObject1 = this.Ben;
      if (localObject1 != null) {
        localObject1 = ((c)localObject1).field_baseItemData;
      }
      try
      {
        ((a)localObject4).parseFrom((byte[])localObject1);
        localObject1 = localObject4;
        localObject4 = (agh)localObject1;
        if ((localObject4 != null) && (((agh)localObject4).Gwx != null))
        {
          localObject1 = (a)new dvb();
          localObject4 = ((agh)localObject4).Gwx.toByteArray();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((a)localObject1).parseFrom((byte[])localObject4);
            if ((dvb)localObject1 == null) {
              break;
            }
            ae.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake isVLogFakeVideo");
            AppMethodBeat.o(118940);
            return true;
            localObject1 = null;
          }
          localException1 = localException1;
          ae.l("safeParser", "", new Object[] { localException1 });
          Object localObject2 = null;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ae.l("safeParser", "", new Object[] { localException2 });
            Object localObject3 = null;
          }
        }
      }
    }
    ae.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is not fake isVLogFakeVideo");
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
    if ((this.Bel == k.Beo) && (((j)paramObject).Bel == k.Beo))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((emu()) && (((j)paramObject).emu()) && (bu.lX(this.taskId, ((j)paramObject).taskId)))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((emt()) && (((j)paramObject).emt()) && (this.dKr == ((j)paramObject).dKr))
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
    String str = "[VideoItem=" + hashCode() + ",localId=:" + this.dKr + ",storyId=" + this.dLI + ",videoType:=" + this.Bel + ", username=" + this.username + ", url=" + this.Bem.Url + ']';
    AppMethodBeat.o(118938);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.j
 * JD-Core Version:    0.7.0.1
 */