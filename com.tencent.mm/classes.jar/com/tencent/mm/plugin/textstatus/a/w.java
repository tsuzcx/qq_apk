package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.a;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends a
{
  private static String TAG = "MicroMsg.SetStatusParam";
  
  private w()
  {
    AppMethodBeat.i(289752);
    this.Tog = new TextStatusExtInfo();
    this.Tog.topicInfo = new TextStatusTopicInfo();
    this.Tog.mediaType = 1;
    this.Tog.topicInfo.jumpInfos = new LinkedList();
    AppMethodBeat.o(289752);
  }
  
  public static final class a
  {
    public w ThS;
    
    public a()
    {
      AppMethodBeat.i(289800);
      this.ThS = new w((byte)0);
      AppMethodBeat.o(289800);
    }
    
    public final a aol(int paramInt)
    {
      this.ThS.Tog.mediaType = paramInt;
      return this;
    }
    
    public final a bdr(String paramString)
    {
      this.ThS.Tog.topicInfo.iconId = paramString;
      return this;
    }
    
    public final a bds(String paramString)
    {
      this.ThS.Tog.description = paramString;
      return this;
    }
    
    public final a bdt(String paramString)
    {
      this.ThS.mediaPath = paramString;
      return this;
    }
    
    public final a bdu(String paramString)
    {
      this.ThS.Tog.topicInfo.sourceId = paramString;
      return this;
    }
    
    public final a bdv(String paramString)
    {
      this.ThS.Tog.topicInfo.sourceActivityId = paramString;
      return this;
    }
    
    public final a bdw(String paramString)
    {
      this.ThS.Tog.topicInfo.verifyInfo = paramString;
      return this;
    }
    
    public final a bdx(String paramString)
    {
      this.ThS.Tog.topicInfo.sourceName = paramString;
      return this;
    }
    
    public final a bdy(String paramString)
    {
      this.ThS.Tog.topicInfo.sourceIcon = paramString;
      return this;
    }
    
    public final a hFH()
    {
      this.ThS.Toi = 12L;
      return this;
    }
    
    public final a ls(List<TextStatusJumpInfo> paramList)
    {
      AppMethodBeat.i(289866);
      this.ThS.Tog.topicInfo.jumpInfos.clear();
      this.ThS.Tog.topicInfo.jumpInfos.addAll(paramList);
      this.ThS.Tog.topicInfo.sourceJumpInfos.clear();
      this.ThS.Tog.topicInfo.sourceJumpInfos.addAll(paramList);
      AppMethodBeat.o(289866);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.w
 * JD-Core Version:    0.7.0.1
 */