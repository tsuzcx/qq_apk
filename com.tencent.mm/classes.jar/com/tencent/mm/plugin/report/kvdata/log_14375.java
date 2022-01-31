package com.tencent.mm.plugin.report.kvdata;

import java.util.LinkedList;

public class log_14375
  extends com.tencent.mm.bv.a
{
  public int clientVersion_;
  public BDStatusInfo dbStatusInfo_;
  public int device_;
  public int ds_;
  public HeavyDetailInfo heavyDetailInfo_;
  public int import_ds_;
  public SDStatusInfo sdStatusInfo_;
  public long time_stamp_;
  public int type_;
  public long uin_;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.import_ds_);
      paramVarArgs.gB(2, this.ds_);
      paramVarArgs.Y(3, this.uin_);
      paramVarArgs.gB(4, this.device_);
      paramVarArgs.gB(5, this.clientVersion_);
      paramVarArgs.Y(6, this.time_stamp_);
      paramVarArgs.gB(7, this.type_);
      if (this.dbStatusInfo_ != null)
      {
        paramVarArgs.gD(8, this.dbStatusInfo_.btq());
        this.dbStatusInfo_.a(paramVarArgs);
      }
      if (this.sdStatusInfo_ != null)
      {
        paramVarArgs.gD(9, this.sdStatusInfo_.btq());
        this.sdStatusInfo_.a(paramVarArgs);
      }
      if (this.heavyDetailInfo_ != null)
      {
        paramVarArgs.gD(10, this.heavyDetailInfo_.btq());
        this.heavyDetailInfo_.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.import_ds_) + 0 + d.a.a.a.gy(2, this.ds_) + d.a.a.a.X(3, this.uin_) + d.a.a.a.gy(4, this.device_) + d.a.a.a.gy(5, this.clientVersion_) + d.a.a.a.X(6, this.time_stamp_) + d.a.a.a.gy(7, this.type_);
      paramInt = i;
      if (this.dbStatusInfo_ != null) {
        paramInt = i + d.a.a.a.gA(8, this.dbStatusInfo_.btq());
      }
      i = paramInt;
      if (this.sdStatusInfo_ != null) {
        i = paramInt + d.a.a.a.gA(9, this.sdStatusInfo_.btq());
      }
      paramInt = i;
    } while (this.heavyDetailInfo_ == null);
    return i + d.a.a.a.gA(10, this.heavyDetailInfo_.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      log_14375 locallog_14375 = (log_14375)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        locallog_14375.import_ds_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        locallog_14375.ds_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        locallog_14375.uin_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 4: 
        locallog_14375.device_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        locallog_14375.clientVersion_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        locallog_14375.time_stamp_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 7: 
        locallog_14375.type_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new BDStatusInfo();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((BDStatusInfo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallog_14375.dbStatusInfo_ = ((BDStatusInfo)localObject1);
          paramInt += 1;
        }
        return 0;
      case 9: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SDStatusInfo();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SDStatusInfo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallog_14375.sdStatusInfo_ = ((SDStatusInfo)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new HeavyDetailInfo();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((HeavyDetailInfo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        locallog_14375.heavyDetailInfo_ = ((HeavyDetailInfo)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_14375
 * JD-Core Version:    0.7.0.1
 */