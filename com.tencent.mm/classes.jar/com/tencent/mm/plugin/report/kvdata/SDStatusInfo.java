package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class SDStatusInfo
  extends com.tencent.mm.cd.a
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
        paramVarArgs.oE(1, this.weChatSDInfo_.computeSize());
        this.weChatSDInfo_.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.weChatPer_);
      paramVarArgs.aY(3, this.sizeHeavy_);
      paramVarArgs.aY(4, this.ratioHeavy_);
      paramVarArgs.aY(5, this.useExternal_);
      paramVarArgs.aY(6, this.hasUnRemovable_);
      paramVarArgs.bm(7, this.sBlockSize_);
      paramVarArgs.bm(8, this.sBlockCount_);
      paramVarArgs.bm(9, this.sTotalSize_);
      paramVarArgs.bm(10, this.sAvailableBlockCount_);
      paramVarArgs.bm(11, this.sAvailableSize_);
      paramVarArgs.aY(12, this.sAvailablePer_);
      paramVarArgs.bm(13, this.eBlockSize_);
      paramVarArgs.bm(14, this.eBlockCount_);
      paramVarArgs.bm(15, this.eTotalSize_);
      paramVarArgs.bm(16, this.eAvailableBlockCount_);
      paramVarArgs.bm(17, this.eAvailableSize_);
      paramVarArgs.aY(18, this.eAvailablePer_);
      if (this.ePath_ != null) {
        paramVarArgs.f(19, this.ePath_);
      }
      if (this.root_ != null) {
        paramVarArgs.f(20, this.root_);
      }
      if (this.fSystem_ != null) {
        paramVarArgs.f(21, this.fSystem_);
      }
      AppMethodBeat.o(151538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.weChatSDInfo_ == null) {
        break label1264;
      }
    }
    label1264:
    for (paramInt = g.a.a.a.oD(1, this.weChatSDInfo_.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.weChatPer_) + g.a.a.b.b.a.bM(3, this.sizeHeavy_) + g.a.a.b.b.a.bM(4, this.ratioHeavy_) + g.a.a.b.b.a.bM(5, this.useExternal_) + g.a.a.b.b.a.bM(6, this.hasUnRemovable_) + g.a.a.b.b.a.p(7, this.sBlockSize_) + g.a.a.b.b.a.p(8, this.sBlockCount_) + g.a.a.b.b.a.p(9, this.sTotalSize_) + g.a.a.b.b.a.p(10, this.sAvailableBlockCount_) + g.a.a.b.b.a.p(11, this.sAvailableSize_) + g.a.a.b.b.a.bM(12, this.sAvailablePer_) + g.a.a.b.b.a.p(13, this.eBlockSize_) + g.a.a.b.b.a.p(14, this.eBlockCount_) + g.a.a.b.b.a.p(15, this.eTotalSize_) + g.a.a.b.b.a.p(16, this.eAvailableBlockCount_) + g.a.a.b.b.a.p(17, this.eAvailableSize_) + g.a.a.b.b.a.bM(18, this.eAvailablePer_);
      paramInt = i;
      if (this.ePath_ != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.ePath_);
      }
      i = paramInt;
      if (this.root_ != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.root_);
      }
      paramInt = i;
      if (this.fSystem_ != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.fSystem_);
      }
      AppMethodBeat.o(151538);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        SDStatusInfo localSDStatusInfo = (SDStatusInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151538);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
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
          localSDStatusInfo.weChatPer_ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(151538);
          return 0;
        case 3: 
          localSDStatusInfo.sizeHeavy_ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(151538);
          return 0;
        case 4: 
          localSDStatusInfo.ratioHeavy_ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(151538);
          return 0;
        case 5: 
          localSDStatusInfo.useExternal_ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(151538);
          return 0;
        case 6: 
          localSDStatusInfo.hasUnRemovable_ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(151538);
          return 0;
        case 7: 
          localSDStatusInfo.sBlockSize_ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(151538);
          return 0;
        case 8: 
          localSDStatusInfo.sBlockCount_ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(151538);
          return 0;
        case 9: 
          localSDStatusInfo.sTotalSize_ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(151538);
          return 0;
        case 10: 
          localSDStatusInfo.sAvailableBlockCount_ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(151538);
          return 0;
        case 11: 
          localSDStatusInfo.sAvailableSize_ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(151538);
          return 0;
        case 12: 
          localSDStatusInfo.sAvailablePer_ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(151538);
          return 0;
        case 13: 
          localSDStatusInfo.eBlockSize_ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(151538);
          return 0;
        case 14: 
          localSDStatusInfo.eBlockCount_ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(151538);
          return 0;
        case 15: 
          localSDStatusInfo.eTotalSize_ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(151538);
          return 0;
        case 16: 
          localSDStatusInfo.eAvailableBlockCount_ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(151538);
          return 0;
        case 17: 
          localSDStatusInfo.eAvailableSize_ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(151538);
          return 0;
        case 18: 
          localSDStatusInfo.eAvailablePer_ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(151538);
          return 0;
        case 19: 
          localSDStatusInfo.ePath_ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(151538);
          return 0;
        case 20: 
          localSDStatusInfo.root_ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(151538);
          return 0;
        }
        localSDStatusInfo.fSystem_ = ((g.a.a.a.a)localObject).abFh.readString();
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