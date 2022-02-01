package com.tencent.mm.plugin.story.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fvr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "", "localId", "", "storyId", "", "createTime", "username", "", "(IJILjava/lang/String;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "fakeVideoData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "getFakeVideoData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setFakeVideoData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getLocalId", "setLocalId", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getStoryId", "()J", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "getUsername", "setUsername", "videoType", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "getVideoType", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "setVideoType", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;)V", "canPlay", "", "equals", "other", "hashCode", "isFakeVideo", "isImageVideo", "isNormalVideo", "isVLogFakeVideo", "toString", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  enw NDO;
  public k Smw;
  public fis Smx;
  public c Smy;
  public int createTime;
  public int icg;
  public final long idH;
  public String taskId;
  public String username;
  
  public j(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    AppMethodBeat.i(118941);
    this.icg = paramInt1;
    this.idH = paramLong;
    this.createTime = paramInt2;
    this.username = paramString;
    this.Smw = k.SmC;
    paramString = new fis();
    paramString.Url = "";
    paramString.aaTl = "";
    paramString.Id = "";
    ah localah = ah.aiuX;
    this.Smx = paramString;
    this.taskId = "";
    AppMethodBeat.o(118941);
  }
  
  private boolean hwK()
  {
    return this.Smw == k.SmC;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118936);
    if (!(paramObject instanceof j))
    {
      AppMethodBeat.o(118936);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((this.Smw == k.Smz) && (((j)paramObject).Smw == k.Smz))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((hwL()) && (((j)paramObject).hwL()) && (Util.isEqual(this.taskId, ((j)paramObject).taskId)))
    {
      AppMethodBeat.o(118936);
      return true;
    }
    if ((hwK()) && (((j)paramObject).hwK()) && (this.icg == ((j)paramObject).icg))
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
  
  public final boolean heF()
  {
    return this.Smw != k.Smz;
  }
  
  public final boolean hwL()
  {
    return this.Smw == k.SmA;
  }
  
  public final boolean hwM()
  {
    AppMethodBeat.i(118939);
    if (hwL())
    {
      Object localObject = this.Smy;
      if (localObject != null)
      {
        localObject = ((c)localObject).gGD();
        if (localObject != null)
        {
          localObject = ((ami)localObject).Zto;
          if ((localObject != null) && (((LinkedList)localObject).size() > 0))
          {
            Log.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake imageVideo");
            AppMethodBeat.o(118939);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(118939);
    return false;
  }
  
  public final boolean hwN()
  {
    AppMethodBeat.i(118940);
    if (hwL())
    {
      Object localObject4 = (a)new ami();
      Object localObject1 = this.Smy;
      if (localObject1 == null) {
        localObject1 = null;
      }
      try
      {
        ((a)localObject4).parseFrom((byte[])localObject1);
        localObject1 = localObject4;
        localObject4 = (ami)localObject1;
        if ((localObject4 != null) && (((ami)localObject4).Ztp != null))
        {
          localObject1 = (a)new fvr();
          localObject4 = ((ami)localObject4).Ztp.toByteArray();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((a)localObject1).parseFrom((byte[])localObject4);
            if ((fvr)localObject1 == null) {
              break;
            }
            Log.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake isVLogFakeVideo");
            AppMethodBeat.o(118940);
            return true;
            localObject1 = ((c)localObject1).field_baseItemData;
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
  
  public final String toString()
  {
    AppMethodBeat.i(118938);
    String str = "[VideoItem=" + hashCode() + ",localId=:" + this.icg + ",storyId=" + this.idH + ",videoType:=" + this.Smw + ", username=" + this.username + ", url=" + this.Smx.Url + ']';
    AppMethodBeat.o(118938);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.j
 * JD-Core Version:    0.7.0.1
 */