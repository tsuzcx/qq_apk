package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(79163);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.import_ds_);
      paramVarArgs.aO(2, this.ds_);
      paramVarArgs.am(3, this.uin_);
      paramVarArgs.aO(4, this.device_);
      paramVarArgs.aO(5, this.clientVersion_);
      paramVarArgs.am(6, this.time_stamp_);
      paramVarArgs.aO(7, this.type_);
      if (this.dbStatusInfo_ != null)
      {
        paramVarArgs.iQ(8, this.dbStatusInfo_.computeSize());
        this.dbStatusInfo_.writeFields(paramVarArgs);
      }
      if (this.sdStatusInfo_ != null)
      {
        paramVarArgs.iQ(9, this.sdStatusInfo_.computeSize());
        this.sdStatusInfo_.writeFields(paramVarArgs);
      }
      if (this.heavyDetailInfo_ != null)
      {
        paramVarArgs.iQ(10, this.heavyDetailInfo_.computeSize());
        this.heavyDetailInfo_.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(79163);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.import_ds_) + 0 + e.a.a.b.b.a.bl(2, this.ds_) + e.a.a.b.b.a.p(3, this.uin_) + e.a.a.b.b.a.bl(4, this.device_) + e.a.a.b.b.a.bl(5, this.clientVersion_) + e.a.a.b.b.a.p(6, this.time_stamp_) + e.a.a.b.b.a.bl(7, this.type_);
      paramInt = i;
      if (this.dbStatusInfo_ != null) {
        paramInt = i + e.a.a.a.iP(8, this.dbStatusInfo_.computeSize());
      }
      i = paramInt;
      if (this.sdStatusInfo_ != null) {
        i = paramInt + e.a.a.a.iP(9, this.sdStatusInfo_.computeSize());
      }
      paramInt = i;
      if (this.heavyDetailInfo_ != null) {
        paramInt = i + e.a.a.a.iP(10, this.heavyDetailInfo_.computeSize());
      }
      AppMethodBeat.o(79163);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(79163);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      log_14375 locallog_14375 = (log_14375)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(79163);
        return -1;
      case 1: 
        locallog_14375.import_ds_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79163);
        return 0;
      case 2: 
        locallog_14375.ds_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79163);
        return 0;
      case 3: 
        locallog_14375.uin_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79163);
        return 0;
      case 4: 
        locallog_14375.device_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79163);
        return 0;
      case 5: 
        locallog_14375.clientVersion_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79163);
        return 0;
      case 6: 
        locallog_14375.time_stamp_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79163);
        return 0;
      case 7: 
        locallog_14375.type_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79163);
        return 0;
      case 8: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new BDStatusInfo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((BDStatusInfo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locallog_14375.dbStatusInfo_ = ((BDStatusInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(79163);
        return 0;
      case 9: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SDStatusInfo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SDStatusInfo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locallog_14375.sdStatusInfo_ = ((SDStatusInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(79163);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new HeavyDetailInfo();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((HeavyDetailInfo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        locallog_14375.heavyDetailInfo_ = ((HeavyDetailInfo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(79163);
      return 0;
    }
    AppMethodBeat.o(79163);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_14375
 * JD-Core Version:    0.7.0.1
 */