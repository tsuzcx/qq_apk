package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class log_14375
  extends com.tencent.mm.bw.a
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.import_ds_);
      paramVarArgs.aM(2, this.ds_);
      paramVarArgs.bb(3, this.uin_);
      paramVarArgs.aM(4, this.device_);
      paramVarArgs.aM(5, this.clientVersion_);
      paramVarArgs.bb(6, this.time_stamp_);
      paramVarArgs.aM(7, this.type_);
      if (this.dbStatusInfo_ != null)
      {
        paramVarArgs.ni(8, this.dbStatusInfo_.computeSize());
        this.dbStatusInfo_.writeFields(paramVarArgs);
      }
      if (this.sdStatusInfo_ != null)
      {
        paramVarArgs.ni(9, this.sdStatusInfo_.computeSize());
        this.sdStatusInfo_.writeFields(paramVarArgs);
      }
      if (this.heavyDetailInfo_ != null)
      {
        paramVarArgs.ni(10, this.heavyDetailInfo_.computeSize());
        this.heavyDetailInfo_.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(151549);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.import_ds_) + 0 + g.a.a.b.b.a.bu(2, this.ds_) + g.a.a.b.b.a.r(3, this.uin_) + g.a.a.b.b.a.bu(4, this.device_) + g.a.a.b.b.a.bu(5, this.clientVersion_) + g.a.a.b.b.a.r(6, this.time_stamp_) + g.a.a.b.b.a.bu(7, this.type_);
      paramInt = i;
      if (this.dbStatusInfo_ != null) {
        paramInt = i + g.a.a.a.nh(8, this.dbStatusInfo_.computeSize());
      }
      i = paramInt;
      if (this.sdStatusInfo_ != null) {
        i = paramInt + g.a.a.a.nh(9, this.sdStatusInfo_.computeSize());
      }
      paramInt = i;
      if (this.heavyDetailInfo_ != null) {
        paramInt = i + g.a.a.a.nh(10, this.heavyDetailInfo_.computeSize());
      }
      AppMethodBeat.o(151549);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(151549);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
        locallog_14375.import_ds_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151549);
        return 0;
      case 2: 
        locallog_14375.ds_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151549);
        return 0;
      case 3: 
        locallog_14375.uin_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151549);
        return 0;
      case 4: 
        locallog_14375.device_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151549);
        return 0;
      case 5: 
        locallog_14375.clientVersion_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151549);
        return 0;
      case 6: 
        locallog_14375.time_stamp_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151549);
        return 0;
      case 7: 
        locallog_14375.type_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151549);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new BDStatusInfo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((BDStatusInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locallog_14375.dbStatusInfo_ = ((BDStatusInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151549);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SDStatusInfo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SDStatusInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locallog_14375.sdStatusInfo_ = ((SDStatusInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151549);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new HeavyDetailInfo();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((HeavyDetailInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
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