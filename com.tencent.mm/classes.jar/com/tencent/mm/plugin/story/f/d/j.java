package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "", "localId", "", "storyId", "", "createTime", "username", "", "(IJILjava/lang/String;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "fakeVideoData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "getFakeVideoData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setFakeVideoData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getLocalId", "setLocalId", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getStoryId", "()J", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "getUsername", "setUsername", "videoType", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "getVideoType", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "setVideoType", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;)V", "canPlay", "", "equals", "other", "hashCode", "isFakeVideo", "isImageVideo", "isNormalVideo", "isVLogFakeVideo", "toString", "plugin-story_release"})
public final class j
{
  dlg BKf;
  public k Fpc;
  public edt Fpd;
  public c Fpe;
  public int ecf;
  public final long edx;
  public int iXu;
  public String taskId;
  public String username;
  
  public j(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    AppMethodBeat.i(118941);
    this.ecf = paramInt1;
    this.edx = paramLong;
    this.iXu = paramInt2;
    this.username = paramString;
    this.Fpc = k.Fpi;
    paramString = new edt();
    paramString.Url = "";
    paramString.Msz = "";
    paramString.Id = "";
    this.Fpd = paramString;
    this.taskId = "";
    AppMethodBeat.o(118941);
  }
  
  private boolean foU()
  {
    return this.Fpc == k.Fpi;
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
    if ((this.Fpc == k.Fpf) && (((j)paramObject).Fpc == k.Fpf))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((foV()) && (((j)paramObject).foV()) && (Util.isEqual(this.taskId, ((j)paramObject).taskId)))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((foU()) && (((j)paramObject).foU()) && (this.ecf == ((j)paramObject).ecf))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    AppMethodBeat.o(118936);
    return false;
  }
  
  public final boolean foV()
  {
    return this.Fpc == k.Fpg;
  }
  
  public final boolean foW()
  {
    return this.Fpc != k.Fpf;
  }
  
  public final boolean foX()
  {
    AppMethodBeat.i(118939);
    if (foV())
    {
      Object localObject = this.Fpe;
      if (localObject != null)
      {
        localObject = ((c)localObject).eII().Lsc;
        if ((localObject != null) && (((LinkedList)localObject).size() > 0))
        {
          Log.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake imageVideo");
          AppMethodBeat.o(118939);
          return true;
        }
      }
    }
    AppMethodBeat.o(118939);
    return false;
  }
  
  public final boolean foY()
  {
    AppMethodBeat.i(118940);
    if (foV())
    {
      Object localObject4 = (a)new aio();
      Object localObject1 = this.Fpe;
      if (localObject1 != null) {
        localObject1 = ((c)localObject1).field_baseItemData;
      }
      try
      {
        ((a)localObject4).parseFrom((byte[])localObject1);
        localObject1 = localObject4;
        localObject4 = (aio)localObject1;
        if ((localObject4 != null) && (((aio)localObject4).Lsd != null))
        {
          localObject1 = (a)new epc();
          localObject4 = ((aio)localObject4).Lsd.toByteArray();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((a)localObject1).parseFrom((byte[])localObject4);
            if ((epc)localObject1 == null) {
              break;
            }
            Log.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake isVLogFakeVideo");
            AppMethodBeat.o(118940);
            return true;
            localObject1 = null;
          }
          localException1 = localException1;
          Log.printDebugStack("safeParser", "", new Object[] { localException1 });
          Object localObject2 = null;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException2 });
            Object localObject3 = null;
          }
        }
      }
    }
    Log.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is not fake isVLogFakeVideo");
    AppMethodBeat.o(118940);
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
    String str = "[VideoItem=" + hashCode() + ",localId=:" + this.ecf + ",storyId=" + this.edx + ",videoType:=" + this.Fpc + ", username=" + this.username + ", url=" + this.Fpd.Url + ']';
    AppMethodBeat.o(118938);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.j
 * JD-Core Version:    0.7.0.1
 */