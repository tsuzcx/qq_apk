package com.tencent.mm.plugin.report.kvdata;

import d.a.a.b;
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
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.weChatSDInfo_ == null) {
        throw new b("Not all required fields were included: weChatSDInfo_");
      }
      if (this.weChatSDInfo_ != null)
      {
        paramVarArgs.gD(1, this.weChatSDInfo_.btq());
        this.weChatSDInfo_.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.weChatPer_);
      paramVarArgs.gB(3, this.sizeHeavy_);
      paramVarArgs.gB(4, this.ratioHeavy_);
      paramVarArgs.gB(5, this.useExternal_);
      paramVarArgs.gB(6, this.hasUnRemovable_);
      paramVarArgs.Y(7, this.sBlockSize_);
      paramVarArgs.Y(8, this.sBlockCount_);
      paramVarArgs.Y(9, this.sTotalSize_);
      paramVarArgs.Y(10, this.sAvailableBlockCount_);
      paramVarArgs.Y(11, this.sAvailableSize_);
      paramVarArgs.gB(12, this.sAvailablePer_);
      paramVarArgs.Y(13, this.eBlockSize_);
      paramVarArgs.Y(14, this.eBlockCount_);
      paramVarArgs.Y(15, this.eTotalSize_);
      paramVarArgs.Y(16, this.eAvailableBlockCount_);
      paramVarArgs.Y(17, this.eAvailableSize_);
      paramVarArgs.gB(18, this.eAvailablePer_);
      if (this.ePath_ != null) {
        paramVarArgs.d(19, this.ePath_);
      }
      if (this.root_ != null) {
        paramVarArgs.d(20, this.root_);
      }
      if (this.fSystem_ != null) {
        paramVarArgs.d(21, this.fSystem_);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.weChatSDInfo_ == null) {
        break label1133;
      }
    }
    label1133:
    for (paramInt = d.a.a.a.gA(1, this.weChatSDInfo_.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.weChatPer_) + d.a.a.a.gy(3, this.sizeHeavy_) + d.a.a.a.gy(4, this.ratioHeavy_) + d.a.a.a.gy(5, this.useExternal_) + d.a.a.a.gy(6, this.hasUnRemovable_) + d.a.a.a.X(7, this.sBlockSize_) + d.a.a.a.X(8, this.sBlockCount_) + d.a.a.a.X(9, this.sTotalSize_) + d.a.a.a.X(10, this.sAvailableBlockCount_) + d.a.a.a.X(11, this.sAvailableSize_) + d.a.a.a.gy(12, this.sAvailablePer_) + d.a.a.a.X(13, this.eBlockSize_) + d.a.a.a.X(14, this.eBlockCount_) + d.a.a.a.X(15, this.eTotalSize_) + d.a.a.a.X(16, this.eAvailableBlockCount_) + d.a.a.a.X(17, this.eAvailableSize_) + d.a.a.a.gy(18, this.eAvailablePer_);
      paramInt = i;
      if (this.ePath_ != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.ePath_);
      }
      i = paramInt;
      if (this.root_ != null) {
        i = paramInt + d.a.a.b.b.a.e(20, this.root_);
      }
      paramInt = i;
      if (this.fSystem_ != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.fSystem_);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.weChatSDInfo_ != null) {
          break;
        }
        throw new b("Not all required fields were included: weChatSDInfo_");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        SDStatusInfo localSDStatusInfo = (SDStatusInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new WeChatSDInfo();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((WeChatSDInfo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localSDStatusInfo.weChatSDInfo_ = ((WeChatSDInfo)localObject1);
            paramInt += 1;
          }
        case 2: 
          localSDStatusInfo.weChatPer_ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localSDStatusInfo.sizeHeavy_ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localSDStatusInfo.ratioHeavy_ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localSDStatusInfo.useExternal_ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localSDStatusInfo.hasUnRemovable_ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localSDStatusInfo.sBlockSize_ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 8: 
          localSDStatusInfo.sBlockCount_ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 9: 
          localSDStatusInfo.sTotalSize_ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 10: 
          localSDStatusInfo.sAvailableBlockCount_ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 11: 
          localSDStatusInfo.sAvailableSize_ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 12: 
          localSDStatusInfo.sAvailablePer_ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localSDStatusInfo.eBlockSize_ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 14: 
          localSDStatusInfo.eBlockCount_ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 15: 
          localSDStatusInfo.eTotalSize_ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 16: 
          localSDStatusInfo.eAvailableBlockCount_ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 17: 
          localSDStatusInfo.eAvailableSize_ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 18: 
          localSDStatusInfo.eAvailablePer_ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localSDStatusInfo.ePath_ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          localSDStatusInfo.root_ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localSDStatusInfo.fSystem_ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.SDStatusInfo
 * JD-Core Version:    0.7.0.1
 */