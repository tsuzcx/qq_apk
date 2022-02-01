package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class SDStatusInfo
  extends com.tencent.mm.bw.a
{
  public long eAvailableBlockCount_;
  public int eAvailablePer_;
  public long eAvailableSize_;
  public long eBlockCount_;
  public long eBlockSize_;
  public String ePath_;
  public long eTotalSize_;
  public String fSystem_;
  public int hasUnRemovable_;
  public int ratioHeavy_;
  public String root_;
  public long sAvailableBlockCount_;
  public int sAvailablePer_;
  public long sAvailableSize_;
  public long sBlockCount_;
  public long sBlockSize_;
  public long sTotalSize_;
  public int sizeHeavy_;
  public int useExternal_;
  public int weChatPer_;
  public WeChatSDInfo weChatSDInfo_;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.weChatSDInfo_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: weChatSDInfo_");
        AppMethodBeat.o(151538);
        throw paramVarArgs;
      }
      if (this.weChatSDInfo_ != null)
      {
        paramVarArgs.ln(1, this.weChatSDInfo_.computeSize());
        this.weChatSDInfo_.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.weChatPer_);
      paramVarArgs.aR(3, this.sizeHeavy_);
      paramVarArgs.aR(4, this.ratioHeavy_);
      paramVarArgs.aR(5, this.useExternal_);
      paramVarArgs.aR(6, this.hasUnRemovable_);
      paramVarArgs.aO(7, this.sBlockSize_);
      paramVarArgs.aO(8, this.sBlockCount_);
      paramVarArgs.aO(9, this.sTotalSize_);
      paramVarArgs.aO(10, this.sAvailableBlockCount_);
      paramVarArgs.aO(11, this.sAvailableSize_);
      paramVarArgs.aR(12, this.sAvailablePer_);
      paramVarArgs.aO(13, this.eBlockSize_);
      paramVarArgs.aO(14, this.eBlockCount_);
      paramVarArgs.aO(15, this.eTotalSize_);
      paramVarArgs.aO(16, this.eAvailableBlockCount_);
      paramVarArgs.aO(17, this.eAvailableSize_);
      paramVarArgs.aR(18, this.eAvailablePer_);
      if (this.ePath_ != null) {
        paramVarArgs.d(19, this.ePath_);
      }
      if (this.root_ != null) {
        paramVarArgs.d(20, this.root_);
      }
      if (this.fSystem_ != null) {
        paramVarArgs.d(21, this.fSystem_);
      }
      AppMethodBeat.o(151538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.weChatSDInfo_ == null) {
        break label1286;
      }
    }
    label1286:
    for (paramInt = f.a.a.a.lm(1, this.weChatSDInfo_.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.weChatPer_) + f.a.a.b.b.a.bx(3, this.sizeHeavy_) + f.a.a.b.b.a.bx(4, this.ratioHeavy_) + f.a.a.b.b.a.bx(5, this.useExternal_) + f.a.a.b.b.a.bx(6, this.hasUnRemovable_) + f.a.a.b.b.a.p(7, this.sBlockSize_) + f.a.a.b.b.a.p(8, this.sBlockCount_) + f.a.a.b.b.a.p(9, this.sTotalSize_) + f.a.a.b.b.a.p(10, this.sAvailableBlockCount_) + f.a.a.b.b.a.p(11, this.sAvailableSize_) + f.a.a.b.b.a.bx(12, this.sAvailablePer_) + f.a.a.b.b.a.p(13, this.eBlockSize_) + f.a.a.b.b.a.p(14, this.eBlockCount_) + f.a.a.b.b.a.p(15, this.eTotalSize_) + f.a.a.b.b.a.p(16, this.eAvailableBlockCount_) + f.a.a.b.b.a.p(17, this.eAvailableSize_) + f.a.a.b.b.a.bx(18, this.eAvailablePer_);
      paramInt = i;
      if (this.ePath_ != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.ePath_);
      }
      i = paramInt;
      if (this.root_ != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.root_);
      }
      paramInt = i;
      if (this.fSystem_ != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.fSystem_);
      }
      AppMethodBeat.o(151538);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.weChatSDInfo_ == null)
        {
          paramVarArgs = new b("Not all required fields were included: weChatSDInfo_");
          AppMethodBeat.o(151538);
          throw paramVarArgs;
        }
        AppMethodBeat.o(151538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        SDStatusInfo localSDStatusInfo = (SDStatusInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151538);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new WeChatSDInfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((WeChatSDInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localSDStatusInfo.weChatSDInfo_ = ((WeChatSDInfo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151538);
          return 0;
        case 2: 
          localSDStatusInfo.weChatPer_ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(151538);
          return 0;
        case 3: 
          localSDStatusInfo.sizeHeavy_ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(151538);
          return 0;
        case 4: 
          localSDStatusInfo.ratioHeavy_ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(151538);
          return 0;
        case 5: 
          localSDStatusInfo.useExternal_ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(151538);
          return 0;
        case 6: 
          localSDStatusInfo.hasUnRemovable_ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(151538);
          return 0;
        case 7: 
          localSDStatusInfo.sBlockSize_ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(151538);
          return 0;
        case 8: 
          localSDStatusInfo.sBlockCount_ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(151538);
          return 0;
        case 9: 
          localSDStatusInfo.sTotalSize_ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(151538);
          return 0;
        case 10: 
          localSDStatusInfo.sAvailableBlockCount_ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(151538);
          return 0;
        case 11: 
          localSDStatusInfo.sAvailableSize_ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(151538);
          return 0;
        case 12: 
          localSDStatusInfo.sAvailablePer_ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(151538);
          return 0;
        case 13: 
          localSDStatusInfo.eBlockSize_ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(151538);
          return 0;
        case 14: 
          localSDStatusInfo.eBlockCount_ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(151538);
          return 0;
        case 15: 
          localSDStatusInfo.eTotalSize_ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(151538);
          return 0;
        case 16: 
          localSDStatusInfo.eAvailableBlockCount_ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(151538);
          return 0;
        case 17: 
          localSDStatusInfo.eAvailableSize_ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(151538);
          return 0;
        case 18: 
          localSDStatusInfo.eAvailablePer_ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(151538);
          return 0;
        case 19: 
          localSDStatusInfo.ePath_ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(151538);
          return 0;
        case 20: 
          localSDStatusInfo.root_ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(151538);
          return 0;
        }
        localSDStatusInfo.fSystem_ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(151538);
        return 0;
      }
      AppMethodBeat.o(151538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.SDStatusInfo
 * JD-Core Version:    0.7.0.1
 */