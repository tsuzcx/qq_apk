package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class log_14375
  extends com.tencent.mm.bx.a
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.import_ds_);
      paramVarArgs.aS(2, this.ds_);
      paramVarArgs.aY(3, this.uin_);
      paramVarArgs.aS(4, this.device_);
      paramVarArgs.aS(5, this.clientVersion_);
      paramVarArgs.aY(6, this.time_stamp_);
      paramVarArgs.aS(7, this.type_);
      if (this.dbStatusInfo_ != null)
      {
        paramVarArgs.lC(8, this.dbStatusInfo_.computeSize());
        this.dbStatusInfo_.writeFields(paramVarArgs);
      }
      if (this.sdStatusInfo_ != null)
      {
        paramVarArgs.lC(9, this.sdStatusInfo_.computeSize());
        this.sdStatusInfo_.writeFields(paramVarArgs);
      }
      if (this.heavyDetailInfo_ != null)
      {
        paramVarArgs.lC(10, this.heavyDetailInfo_.computeSize());
        this.heavyDetailInfo_.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(151549);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.import_ds_) + 0 + f.a.a.b.b.a.bz(2, this.ds_) + f.a.a.b.b.a.p(3, this.uin_) + f.a.a.b.b.a.bz(4, this.device_) + f.a.a.b.b.a.bz(5, this.clientVersion_) + f.a.a.b.b.a.p(6, this.time_stamp_) + f.a.a.b.b.a.bz(7, this.type_);
      paramInt = i;
      if (this.dbStatusInfo_ != null) {
        paramInt = i + f.a.a.a.lB(8, this.dbStatusInfo_.computeSize());
      }
      i = paramInt;
      if (this.sdStatusInfo_ != null) {
        i = paramInt + f.a.a.a.lB(9, this.sdStatusInfo_.computeSize());
      }
      paramInt = i;
      if (this.heavyDetailInfo_ != null) {
        paramInt = i + f.a.a.a.lB(10, this.heavyDetailInfo_.computeSize());
      }
      AppMethodBeat.o(151549);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(151549);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      log_14375 locallog_14375 = (log_14375)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151549);
        return -1;
      case 1: 
        locallog_14375.import_ds_ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(151549);
        return 0;
      case 2: 
        locallog_14375.ds_ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(151549);
        return 0;
      case 3: 
        locallog_14375.uin_ = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(151549);
        return 0;
      case 4: 
        locallog_14375.device_ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(151549);
        return 0;
      case 5: 
        locallog_14375.clientVersion_ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(151549);
        return 0;
      case 6: 
        locallog_14375.time_stamp_ = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(151549);
        return 0;
      case 7: 
        locallog_14375.type_ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(151549);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new BDStatusInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((BDStatusInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locallog_14375.dbStatusInfo_ = ((BDStatusInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151549);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SDStatusInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SDStatusInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locallog_14375.sdStatusInfo_ = ((SDStatusInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151549);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new HeavyDetailInfo();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((HeavyDetailInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        locallog_14375.heavyDetailInfo_ = ((HeavyDetailInfo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(151549);
      return 0;
    }
    AppMethodBeat.o(151549);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_14375
 * JD-Core Version:    0.7.0.1
 */