package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public class SDStatusInfo
  extends com.tencent.mm.bv.a
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
    AppMethodBeat.i(79152);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.weChatSDInfo_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: weChatSDInfo_");
        AppMethodBeat.o(79152);
        throw paramVarArgs;
      }
      if (this.weChatSDInfo_ != null)
      {
        paramVarArgs.iQ(1, this.weChatSDInfo_.computeSize());
        this.weChatSDInfo_.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.weChatPer_);
      paramVarArgs.aO(3, this.sizeHeavy_);
      paramVarArgs.aO(4, this.ratioHeavy_);
      paramVarArgs.aO(5, this.useExternal_);
      paramVarArgs.aO(6, this.hasUnRemovable_);
      paramVarArgs.am(7, this.sBlockSize_);
      paramVarArgs.am(8, this.sBlockCount_);
      paramVarArgs.am(9, this.sTotalSize_);
      paramVarArgs.am(10, this.sAvailableBlockCount_);
      paramVarArgs.am(11, this.sAvailableSize_);
      paramVarArgs.aO(12, this.sAvailablePer_);
      paramVarArgs.am(13, this.eBlockSize_);
      paramVarArgs.am(14, this.eBlockCount_);
      paramVarArgs.am(15, this.eTotalSize_);
      paramVarArgs.am(16, this.eAvailableBlockCount_);
      paramVarArgs.am(17, this.eAvailableSize_);
      paramVarArgs.aO(18, this.eAvailablePer_);
      if (this.ePath_ != null) {
        paramVarArgs.e(19, this.ePath_);
      }
      if (this.root_ != null) {
        paramVarArgs.e(20, this.root_);
      }
      if (this.fSystem_ != null) {
        paramVarArgs.e(21, this.fSystem_);
      }
      AppMethodBeat.o(79152);
      return 0;
    }
    if (paramInt == 1) {
      if (this.weChatSDInfo_ == null) {
        break label1286;
      }
    }
    label1286:
    for (paramInt = e.a.a.a.iP(1, this.weChatSDInfo_.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.weChatPer_) + e.a.a.b.b.a.bl(3, this.sizeHeavy_) + e.a.a.b.b.a.bl(4, this.ratioHeavy_) + e.a.a.b.b.a.bl(5, this.useExternal_) + e.a.a.b.b.a.bl(6, this.hasUnRemovable_) + e.a.a.b.b.a.p(7, this.sBlockSize_) + e.a.a.b.b.a.p(8, this.sBlockCount_) + e.a.a.b.b.a.p(9, this.sTotalSize_) + e.a.a.b.b.a.p(10, this.sAvailableBlockCount_) + e.a.a.b.b.a.p(11, this.sAvailableSize_) + e.a.a.b.b.a.bl(12, this.sAvailablePer_) + e.a.a.b.b.a.p(13, this.eBlockSize_) + e.a.a.b.b.a.p(14, this.eBlockCount_) + e.a.a.b.b.a.p(15, this.eTotalSize_) + e.a.a.b.b.a.p(16, this.eAvailableBlockCount_) + e.a.a.b.b.a.p(17, this.eAvailableSize_) + e.a.a.b.b.a.bl(18, this.eAvailablePer_);
      paramInt = i;
      if (this.ePath_ != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.ePath_);
      }
      i = paramInt;
      if (this.root_ != null) {
        i = paramInt + e.a.a.b.b.a.f(20, this.root_);
      }
      paramInt = i;
      if (this.fSystem_ != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.fSystem_);
      }
      AppMethodBeat.o(79152);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.weChatSDInfo_ == null)
        {
          paramVarArgs = new b("Not all required fields were included: weChatSDInfo_");
          AppMethodBeat.o(79152);
          throw paramVarArgs;
        }
        AppMethodBeat.o(79152);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        SDStatusInfo localSDStatusInfo = (SDStatusInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(79152);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new WeChatSDInfo();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((WeChatSDInfo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localSDStatusInfo.weChatSDInfo_ = ((WeChatSDInfo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(79152);
          return 0;
        case 2: 
          localSDStatusInfo.weChatPer_ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(79152);
          return 0;
        case 3: 
          localSDStatusInfo.sizeHeavy_ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(79152);
          return 0;
        case 4: 
          localSDStatusInfo.ratioHeavy_ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(79152);
          return 0;
        case 5: 
          localSDStatusInfo.useExternal_ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(79152);
          return 0;
        case 6: 
          localSDStatusInfo.hasUnRemovable_ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(79152);
          return 0;
        case 7: 
          localSDStatusInfo.sBlockSize_ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(79152);
          return 0;
        case 8: 
          localSDStatusInfo.sBlockCount_ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(79152);
          return 0;
        case 9: 
          localSDStatusInfo.sTotalSize_ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(79152);
          return 0;
        case 10: 
          localSDStatusInfo.sAvailableBlockCount_ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(79152);
          return 0;
        case 11: 
          localSDStatusInfo.sAvailableSize_ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(79152);
          return 0;
        case 12: 
          localSDStatusInfo.sAvailablePer_ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(79152);
          return 0;
        case 13: 
          localSDStatusInfo.eBlockSize_ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(79152);
          return 0;
        case 14: 
          localSDStatusInfo.eBlockCount_ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(79152);
          return 0;
        case 15: 
          localSDStatusInfo.eTotalSize_ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(79152);
          return 0;
        case 16: 
          localSDStatusInfo.eAvailableBlockCount_ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(79152);
          return 0;
        case 17: 
          localSDStatusInfo.eAvailableSize_ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(79152);
          return 0;
        case 18: 
          localSDStatusInfo.eAvailablePer_ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(79152);
          return 0;
        case 19: 
          localSDStatusInfo.ePath_ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(79152);
          return 0;
        case 20: 
          localSDStatusInfo.root_ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(79152);
          return 0;
        }
        localSDStatusInfo.fSystem_ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(79152);
        return 0;
      }
      AppMethodBeat.o(79152);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.SDStatusInfo
 * JD-Core Version:    0.7.0.1
 */