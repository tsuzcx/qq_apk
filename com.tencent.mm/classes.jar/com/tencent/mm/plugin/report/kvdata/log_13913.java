package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class log_13913
  extends com.tencent.mm.bx.a
{
  public int clientVersion_;
  public int device_;
  public int ds_;
  public String error_;
  public int import_ds_;
  public int scene_;
  public long time_stamp_;
  public long uin_;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151548);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.import_ds_);
      paramVarArgs.bS(2, this.ds_);
      paramVarArgs.bv(3, this.uin_);
      paramVarArgs.bS(4, this.device_);
      paramVarArgs.bS(5, this.clientVersion_);
      paramVarArgs.bv(6, this.time_stamp_);
      paramVarArgs.bS(7, this.scene_);
      if (this.error_ != null) {
        paramVarArgs.g(8, this.error_);
      }
      AppMethodBeat.o(151548);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.import_ds_) + 0 + i.a.a.b.b.a.cJ(2, this.ds_) + i.a.a.b.b.a.q(3, this.uin_) + i.a.a.b.b.a.cJ(4, this.device_) + i.a.a.b.b.a.cJ(5, this.clientVersion_) + i.a.a.b.b.a.q(6, this.time_stamp_) + i.a.a.b.b.a.cJ(7, this.scene_);
      paramInt = i;
      if (this.error_ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.error_);
      }
      AppMethodBeat.o(151548);
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
      AppMethodBeat.o(151548);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      log_13913 locallog_13913 = (log_13913)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151548);
        return -1;
      case 1: 
        locallog_13913.import_ds_ = locala.ajGk.aar();
        AppMethodBeat.o(151548);
        return 0;
      case 2: 
        locallog_13913.ds_ = locala.ajGk.aar();
        AppMethodBeat.o(151548);
        return 0;
      case 3: 
        locallog_13913.uin_ = locala.ajGk.aaw();
        AppMethodBeat.o(151548);
        return 0;
      case 4: 
        locallog_13913.device_ = locala.ajGk.aar();
        AppMethodBeat.o(151548);
        return 0;
      case 5: 
        locallog_13913.clientVersion_ = locala.ajGk.aar();
        AppMethodBeat.o(151548);
        return 0;
      case 6: 
        locallog_13913.time_stamp_ = locala.ajGk.aaw();
        AppMethodBeat.o(151548);
        return 0;
      case 7: 
        locallog_13913.scene_ = locala.ajGk.aar();
        AppMethodBeat.o(151548);
        return 0;
      }
      locallog_13913.error_ = locala.ajGk.readString();
      AppMethodBeat.o(151548);
      return 0;
    }
    AppMethodBeat.o(151548);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_13913
 * JD-Core Version:    0.7.0.1
 */