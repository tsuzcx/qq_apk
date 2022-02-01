package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class log_13905
  extends com.tencent.mm.bx.a
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.viOp_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: viOp_");
        AppMethodBeat.o(151547);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.import_ds_);
      paramVarArgs.bS(2, this.ds_);
      paramVarArgs.bv(3, this.uin_);
      paramVarArgs.bS(4, this.device_);
      paramVarArgs.bS(5, this.clientVersion_);
      paramVarArgs.bv(6, this.time_stamp_);
      if (this.viOp_ != null)
      {
        paramVarArgs.qD(7, this.viOp_.computeSize());
        this.viOp_.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(151547);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.import_ds_) + 0 + i.a.a.b.b.a.cJ(2, this.ds_) + i.a.a.b.b.a.q(3, this.uin_) + i.a.a.b.b.a.cJ(4, this.device_) + i.a.a.b.b.a.cJ(5, this.clientVersion_) + i.a.a.b.b.a.q(6, this.time_stamp_);
      paramInt = i;
      if (this.viOp_ != null) {
        paramInt = i + i.a.a.a.qC(7, this.viOp_.computeSize());
      }
      AppMethodBeat.o(151547);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
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
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      log_13905 locallog_13905 = (log_13905)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151547);
        return -1;
      case 1: 
        locallog_13905.import_ds_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151547);
        return 0;
      case 2: 
        locallog_13905.ds_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151547);
        return 0;
      case 3: 
        locallog_13905.uin_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151547);
        return 0;
      case 4: 
        locallog_13905.device_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151547);
        return 0;
      case 5: 
        locallog_13905.clientVersion_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151547);
        return 0;
      case 6: 
        locallog_13905.time_stamp_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151547);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
        if ((localObject != null) && (localObject.length > 0)) {
          localVoiceInputBehavior.parseFrom((byte[])localObject);
        }
        locallog_13905.viOp_ = localVoiceInputBehavior;
        paramInt += 1;
      }
      AppMethodBeat.o(151547);
      return 0;
    }
    AppMethodBeat.o(151547);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_13905
 * JD-Core Version:    0.7.0.1
 */