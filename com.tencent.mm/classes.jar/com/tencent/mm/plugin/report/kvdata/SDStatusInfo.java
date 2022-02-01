package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class SDStatusInfo
  extends com.tencent.mm.bx.a
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.weChatSDInfo_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: weChatSDInfo_");
        AppMethodBeat.o(151538);
        throw paramVarArgs;
      }
      if (this.weChatSDInfo_ != null)
      {
        paramVarArgs.qD(1, this.weChatSDInfo_.computeSize());
        this.weChatSDInfo_.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.weChatPer_);
      paramVarArgs.bS(3, this.sizeHeavy_);
      paramVarArgs.bS(4, this.ratioHeavy_);
      paramVarArgs.bS(5, this.useExternal_);
      paramVarArgs.bS(6, this.hasUnRemovable_);
      paramVarArgs.bv(7, this.sBlockSize_);
      paramVarArgs.bv(8, this.sBlockCount_);
      paramVarArgs.bv(9, this.sTotalSize_);
      paramVarArgs.bv(10, this.sAvailableBlockCount_);
      paramVarArgs.bv(11, this.sAvailableSize_);
      paramVarArgs.bS(12, this.sAvailablePer_);
      paramVarArgs.bv(13, this.eBlockSize_);
      paramVarArgs.bv(14, this.eBlockCount_);
      paramVarArgs.bv(15, this.eTotalSize_);
      paramVarArgs.bv(16, this.eAvailableBlockCount_);
      paramVarArgs.bv(17, this.eAvailableSize_);
      paramVarArgs.bS(18, this.eAvailablePer_);
      if (this.ePath_ != null) {
        paramVarArgs.g(19, this.ePath_);
      }
      if (this.root_ != null) {
        paramVarArgs.g(20, this.root_);
      }
      if (this.fSystem_ != null) {
        paramVarArgs.g(21, this.fSystem_);
      }
      AppMethodBeat.o(151538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.weChatSDInfo_ == null) {
        break label1260;
      }
    }
    label1260:
    for (paramInt = i.a.a.a.qC(1, this.weChatSDInfo_.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.weChatPer_) + i.a.a.b.b.a.cJ(3, this.sizeHeavy_) + i.a.a.b.b.a.cJ(4, this.ratioHeavy_) + i.a.a.b.b.a.cJ(5, this.useExternal_) + i.a.a.b.b.a.cJ(6, this.hasUnRemovable_) + i.a.a.b.b.a.q(7, this.sBlockSize_) + i.a.a.b.b.a.q(8, this.sBlockCount_) + i.a.a.b.b.a.q(9, this.sTotalSize_) + i.a.a.b.b.a.q(10, this.sAvailableBlockCount_) + i.a.a.b.b.a.q(11, this.sAvailableSize_) + i.a.a.b.b.a.cJ(12, this.sAvailablePer_) + i.a.a.b.b.a.q(13, this.eBlockSize_) + i.a.a.b.b.a.q(14, this.eBlockCount_) + i.a.a.b.b.a.q(15, this.eTotalSize_) + i.a.a.b.b.a.q(16, this.eAvailableBlockCount_) + i.a.a.b.b.a.q(17, this.eAvailableSize_) + i.a.a.b.b.a.cJ(18, this.eAvailablePer_);
      paramInt = i;
      if (this.ePath_ != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.ePath_);
      }
      i = paramInt;
      if (this.root_ != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.root_);
      }
      paramInt = i;
      if (this.fSystem_ != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.fSystem_);
      }
      AppMethodBeat.o(151538);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        SDStatusInfo localSDStatusInfo = (SDStatusInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151538);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            WeChatSDInfo localWeChatSDInfo = new WeChatSDInfo();
            if ((localObject != null) && (localObject.length > 0)) {
              localWeChatSDInfo.parseFrom((byte[])localObject);
            }
            localSDStatusInfo.weChatSDInfo_ = localWeChatSDInfo;
            paramInt += 1;
          }
          AppMethodBeat.o(151538);
          return 0;
        case 2: 
          localSDStatusInfo.weChatPer_ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(151538);
          return 0;
        case 3: 
          localSDStatusInfo.sizeHeavy_ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(151538);
          return 0;
        case 4: 
          localSDStatusInfo.ratioHeavy_ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(151538);
          return 0;
        case 5: 
          localSDStatusInfo.useExternal_ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(151538);
          return 0;
        case 6: 
          localSDStatusInfo.hasUnRemovable_ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(151538);
          return 0;
        case 7: 
          localSDStatusInfo.sBlockSize_ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(151538);
          return 0;
        case 8: 
          localSDStatusInfo.sBlockCount_ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(151538);
          return 0;
        case 9: 
          localSDStatusInfo.sTotalSize_ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(151538);
          return 0;
        case 10: 
          localSDStatusInfo.sAvailableBlockCount_ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(151538);
          return 0;
        case 11: 
          localSDStatusInfo.sAvailableSize_ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(151538);
          return 0;
        case 12: 
          localSDStatusInfo.sAvailablePer_ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(151538);
          return 0;
        case 13: 
          localSDStatusInfo.eBlockSize_ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(151538);
          return 0;
        case 14: 
          localSDStatusInfo.eBlockCount_ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(151538);
          return 0;
        case 15: 
          localSDStatusInfo.eTotalSize_ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(151538);
          return 0;
        case 16: 
          localSDStatusInfo.eAvailableBlockCount_ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(151538);
          return 0;
        case 17: 
          localSDStatusInfo.eAvailableSize_ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(151538);
          return 0;
        case 18: 
          localSDStatusInfo.eAvailablePer_ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(151538);
          return 0;
        case 19: 
          localSDStatusInfo.ePath_ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(151538);
          return 0;
        case 20: 
          localSDStatusInfo.root_ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(151538);
          return 0;
        }
        localSDStatusInfo.fSystem_ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(151538);
        return 0;
      }
      AppMethodBeat.o(151538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.SDStatusInfo
 * JD-Core Version:    0.7.0.1
 */