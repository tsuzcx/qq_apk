package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.a;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends a
{
  private String TAG;
  
  private q()
  {
    AppMethodBeat.i(243848);
    this.TAG = "MicroMsg.SetStatusParam";
    this.MEA = new TextStatusExtInfo();
    this.MEA.topicInfo = new TextStatusTopicInfo();
    this.MEA.mediaType = 1;
    this.MEA.topicInfo.jumpInfos = new LinkedList();
    AppMethodBeat.o(243848);
  }
  
  public static final class a
  {
    public q MzL;
    
    public a()
    {
      AppMethodBeat.i(243594);
      this.MzL = new q((byte)0);
      AppMethodBeat.o(243594);
    }
    
    public final a bec(String paramString)
    {
      this.MzL.MEA.topicInfo.iconId = paramString;
      return this;
    }
    
    public final a bed(String paramString)
    {
      this.MzL.MEA.description = paramString;
      return this;
    }
    
    public final a bee(String paramString)
    {
      this.MzL.mediaPath = paramString;
      return this;
    }
    
    public final a bef(String paramString)
    {
      this.MzL.MEA.topicInfo.sourceId = paramString;
      return this;
    }
    
    public final a beg(String paramString)
    {
      this.MzL.MEA.topicInfo.sourceActivityId = paramString;
      return this;
    }
    
    public final a beh(String paramString)
    {
      this.MzL.MEA.topicInfo.verifyInfo = paramString;
      return this;
    }
    
    public final a bei(String paramString)
    {
      this.MzL.MEA.topicInfo.sourceName = paramString;
      return this;
    }
    
    public final a bej(String paramString)
    {
      this.MzL.MEA.topicInfo.sourceIcon = paramString;
      return this;
    }
    
    public final a gkL()
    {
      this.MzL.MEA.mediaType = 2;
      return this;
    }
    
    public final a gkM()
    {
      this.MzL.MEB = false;
      return this;
    }
    
    public final a gkN()
    {
      this.MzL.enterTime = 0L;
      return this;
    }
    
    public final q gkO()
    {
      return this.MzL;
    }
    
    public final a im(List<TextStatusJumpInfo> paramList)
    {
      AppMethodBeat.i(243599);
      this.MzL.MEA.topicInfo.jumpInfos.clear();
      this.MzL.MEA.topicInfo.jumpInfos.addAll(paramList);
      this.MzL.MEA.topicInfo.sourceJumpInfos.clear();
      this.MzL.MEA.topicInfo.sourceJumpInfos.addAll(paramList);
      AppMethodBeat.o(243599);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.q
 * JD-Core Version:    0.7.0.1
 */