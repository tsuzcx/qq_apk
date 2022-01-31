package com.tencent.mm.plugin.story.model.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "", "localId", "", "storyId", "", "createTime", "username", "", "(IJILjava/lang/String;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "fakeVideoData", "Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;", "getFakeVideoData", "()Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;", "setFakeVideoData", "(Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;)V", "getLocalId", "setLocalId", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/StoryLocation;)V", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getStoryId", "()J", "timeStamp", "getTimeStamp", "setTimeStamp", "(J)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "videoType", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "getVideoType", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "setVideoType", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;)V", "canPlay", "", "equals", "other", "hashCode", "isFakeVideo", "isImageVideo", "isNormalVideo", "toString", "plugin-story_release"})
public final class i
{
  public int cIp;
  public final long cJA;
  public int fDT;
  j syA;
  public chl syB;
  chj syC;
  public chf syD;
  public long timeStamp;
  public String username;
  
  public i(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    AppMethodBeat.i(109323);
    this.cIp = paramInt1;
    this.cJA = paramLong;
    this.fDT = paramInt2;
    this.username = paramString;
    this.syA = j.syH;
    paramString = new chl();
    paramString.Url = "";
    paramString.xrS = "";
    paramString.Id = "";
    this.syB = paramString;
    AppMethodBeat.o(109323);
  }
  
  private boolean cBL()
  {
    return this.syA == j.syH;
  }
  
  public final boolean cBM()
  {
    return this.syA == j.syF;
  }
  
  public final boolean cBN()
  {
    return this.syA != j.syE;
  }
  
  public final boolean cBO()
  {
    AppMethodBeat.i(151075);
    if (cBM())
    {
      Object localObject = this.syD;
      if (localObject != null)
      {
        localObject = ((chf)localObject).xSi;
        if ((localObject != null) && (((LinkedList)localObject).size() > 0))
        {
          ab.i("MicroMsg.Story.StoryVideoItem", "item" + this.timeStamp + " is fake imageVideo");
          AppMethodBeat.o(151075);
          return true;
        }
      }
    }
    AppMethodBeat.o(151075);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(109320);
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(109320);
      return false;
    }
    if ((i)this == paramObject)
    {
      AppMethodBeat.o(109320);
      return true;
    }
    if ((this.syA == j.syE) && (((i)paramObject).syA == j.syE))
    {
      AppMethodBeat.o(109320);
      return true;
    }
    if ((cBM()) && (((i)paramObject).cBM()) && (this.timeStamp == ((i)paramObject).timeStamp))
    {
      AppMethodBeat.o(109320);
      return true;
    }
    if ((cBL()) && (((i)paramObject).cBL()) && (this.cIp == ((i)paramObject).cIp))
    {
      AppMethodBeat.o(109320);
      return true;
    }
    AppMethodBeat.o(109320);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(109321);
    int i = super.hashCode();
    AppMethodBeat.o(109321);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(109322);
    String str = "[VideoItem=" + hashCode() + ",localId=:" + this.cIp + ",storyId=" + this.cJA + ",videoType:=" + this.syA + ", username=" + this.username + ", url=" + this.syB.Url + ']';
    AppMethodBeat.o(109322);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.i
 * JD-Core Version:    0.7.0.1
 */