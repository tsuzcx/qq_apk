package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class log_13905
  extends com.tencent.mm.bw.a
{
  public int clientVersion_;
  public int device_;
  public int ds_;
  public int import_ds_;
  public long time_stamp_;
  public long uin_;
  public VoiceInputBehavior viOp_;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151547);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.viOp_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: viOp_");
        AppMethodBeat.o(151547);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.import_ds_);
      paramVarArgs.aS(2, this.ds_);
      paramVarArgs.aZ(3, this.uin_);
      paramVarArgs.aS(4, this.device_);
      paramVarArgs.aS(5, this.clientVersion_);
      paramVarArgs.aZ(6, this.time_stamp_);
      if (this.viOp_ != null)
      {
        paramVarArgs.lJ(7, this.viOp_.computeSize());
        this.viOp_.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(151547);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.import_ds_) + 0 + f.a.a.b.b.a.bz(2, this.ds_) + f.a.a.b.b.a.p(3, this.uin_) + f.a.a.b.b.a.bz(4, this.device_) + f.a.a.b.b.a.bz(5, this.clientVersion_) + f.a.a.b.b.a.p(6, this.time_stamp_);
      paramInt = i;
      if (this.viOp_ != null) {
        paramInt = i + f.a.a.a.lI(7, this.viOp_.computeSize());
      }
      AppMethodBeat.o(151547);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.viOp_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: viOp_");
        AppMethodBeat.o(151547);
        throw paramVarArgs;
      }
      AppMethodBeat.o(151547);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      log_13905 locallog_13905 = (log_13905)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151547);
        return -1;
      case 1: 
        locallog_13905.import_ds_ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(151547);
        return 0;
      case 2: 
        locallog_13905.ds_ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(151547);
        return 0;
      case 3: 
        locallog_13905.uin_ = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(151547);
        return 0;
      case 4: 
        locallog_13905.device_ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(151547);
        return 0;
      case 5: 
        locallog_13905.clientVersion_ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(151547);
        return 0;
      case 6: 
        locallog_13905.time_stamp_ = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(151547);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new VoiceInputBehavior();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((VoiceInputBehavior)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        locallog_13905.viOp_ = ((VoiceInputBehavior)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(151547);
      return 0;
    }
    AppMethodBeat.o(151547);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_13905
 * JD-Core Version:    0.7.0.1
 */