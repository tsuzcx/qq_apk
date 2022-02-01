package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.weChatSDInfo_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: weChatSDInfo_");
        AppMethodBeat.o(151538);
        throw paramVarArgs;
      }
      if (this.weChatSDInfo_ != null)
      {
        paramVarArgs.ni(1, this.weChatSDInfo_.computeSize());
        this.weChatSDInfo_.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.weChatPer_);
      paramVarArgs.aM(3, this.sizeHeavy_);
      paramVarArgs.aM(4, this.ratioHeavy_);
      paramVarArgs.aM(5, this.useExternal_);
      paramVarArgs.aM(6, this.hasUnRemovable_);
      paramVarArgs.bb(7, this.sBlockSize_);
      paramVarArgs.bb(8, this.sBlockCount_);
      paramVarArgs.bb(9, this.sTotalSize_);
      paramVarArgs.bb(10, this.sAvailableBlockCount_);
      paramVarArgs.bb(11, this.sAvailableSize_);
      paramVarArgs.aM(12, this.sAvailablePer_);
      paramVarArgs.bb(13, this.eBlockSize_);
      paramVarArgs.bb(14, this.eBlockCount_);
      paramVarArgs.bb(15, this.eTotalSize_);
      paramVarArgs.bb(16, this.eAvailableBlockCount_);
      paramVarArgs.bb(17, this.eAvailableSize_);
      paramVarArgs.aM(18, this.eAvailablePer_);
      if (this.ePath_ != null) {
        paramVarArgs.e(19, this.ePath_);
      }
      if (this.root_ != null) {
        paramVarArgs.e(20, this.root_);
      }
      if (this.fSystem_ != null) {
        paramVarArgs.e(21, this.fSystem_);
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
    for (paramInt = g.a.a.a.nh(1, this.weChatSDInfo_.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.weChatPer_) + g.a.a.b.b.a.bu(3, this.sizeHeavy_) + g.a.a.b.b.a.bu(4, this.ratioHeavy_) + g.a.a.b.b.a.bu(5, this.useExternal_) + g.a.a.b.b.a.bu(6, this.hasUnRemovable_) + g.a.a.b.b.a.r(7, this.sBlockSize_) + g.a.a.b.b.a.r(8, this.sBlockCount_) + g.a.a.b.b.a.r(9, this.sTotalSize_) + g.a.a.b.b.a.r(10, this.sAvailableBlockCount_) + g.a.a.b.b.a.r(11, this.sAvailableSize_) + g.a.a.b.b.a.bu(12, this.sAvailablePer_) + g.a.a.b.b.a.r(13, this.eBlockSize_) + g.a.a.b.b.a.r(14, this.eBlockCount_) + g.a.a.b.b.a.r(15, this.eTotalSize_) + g.a.a.b.b.a.r(16, this.eAvailableBlockCount_) + g.a.a.b.b.a.r(17, this.eAvailableSize_) + g.a.a.b.b.a.bu(18, this.eAvailablePer_);
      paramInt = i;
      if (this.ePath_ != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.ePath_);
      }
      i = paramInt;
      if (this.root_ != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.root_);
      }
      paramInt = i;
      if (this.fSystem_ != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.fSystem_);
      }
      AppMethodBeat.o(151538);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        SDStatusInfo localSDStatusInfo = (SDStatusInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151538);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new WeChatSDInfo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((WeChatSDInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localSDStatusInfo.weChatSDInfo_ = ((WeChatSDInfo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151538);
          return 0;
        case 2: 
          localSDStatusInfo.weChatPer_ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(151538);
          return 0;
        case 3: 
          localSDStatusInfo.sizeHeavy_ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(151538);
          return 0;
        case 4: 
          localSDStatusInfo.ratioHeavy_ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(151538);
          return 0;
        case 5: 
          localSDStatusInfo.useExternal_ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(151538);
          return 0;
        case 6: 
          localSDStatusInfo.hasUnRemovable_ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(151538);
          return 0;
        case 7: 
          localSDStatusInfo.sBlockSize_ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(151538);
          return 0;
        case 8: 
          localSDStatusInfo.sBlockCount_ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(151538);
          return 0;
        case 9: 
          localSDStatusInfo.sTotalSize_ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(151538);
          return 0;
        case 10: 
          localSDStatusInfo.sAvailableBlockCount_ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(151538);
          return 0;
        case 11: 
          localSDStatusInfo.sAvailableSize_ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(151538);
          return 0;
        case 12: 
          localSDStatusInfo.sAvailablePer_ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(151538);
          return 0;
        case 13: 
          localSDStatusInfo.eBlockSize_ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(151538);
          return 0;
        case 14: 
          localSDStatusInfo.eBlockCount_ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(151538);
          return 0;
        case 15: 
          localSDStatusInfo.eTotalSize_ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(151538);
          return 0;
        case 16: 
          localSDStatusInfo.eAvailableBlockCount_ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(151538);
          return 0;
        case 17: 
          localSDStatusInfo.eAvailableSize_ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(151538);
          return 0;
        case 18: 
          localSDStatusInfo.eAvailablePer_ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(151538);
          return 0;
        case 19: 
          localSDStatusInfo.ePath_ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(151538);
          return 0;
        case 20: 
          localSDStatusInfo.root_ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(151538);
          return 0;
        }
        localSDStatusInfo.fSystem_ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(151538);
        return 0;
      }
      AppMethodBeat.o(151538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.SDStatusInfo
 * JD-Core Version:    0.7.0.1
 */