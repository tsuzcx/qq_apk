package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class log_13913
  extends com.tencent.mm.bw.a
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.import_ds_);
      paramVarArgs.aM(2, this.ds_);
      paramVarArgs.bb(3, this.uin_);
      paramVarArgs.aM(4, this.device_);
      paramVarArgs.aM(5, this.clientVersion_);
      paramVarArgs.bb(6, this.time_stamp_);
      paramVarArgs.aM(7, this.scene_);
      if (this.error_ != null) {
        paramVarArgs.e(8, this.error_);
      }
      AppMethodBeat.o(151548);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.import_ds_) + 0 + g.a.a.b.b.a.bu(2, this.ds_) + g.a.a.b.b.a.r(3, this.uin_) + g.a.a.b.b.a.bu(4, this.device_) + g.a.a.b.b.a.bu(5, this.clientVersion_) + g.a.a.b.b.a.r(6, this.time_stamp_) + g.a.a.b.b.a.bu(7, this.scene_);
      paramInt = i;
      if (this.error_ != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.error_);
      }
      AppMethodBeat.o(151548);
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
      AppMethodBeat.o(151548);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      log_13913 locallog_13913 = (log_13913)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151548);
        return -1;
      case 1: 
        locallog_13913.import_ds_ = locala.UbS.zi();
        AppMethodBeat.o(151548);
        return 0;
      case 2: 
        locallog_13913.ds_ = locala.UbS.zi();
        AppMethodBeat.o(151548);
        return 0;
      case 3: 
        locallog_13913.uin_ = locala.UbS.zl();
        AppMethodBeat.o(151548);
        return 0;
      case 4: 
        locallog_13913.device_ = locala.UbS.zi();
        AppMethodBeat.o(151548);
        return 0;
      case 5: 
        locallog_13913.clientVersion_ = locala.UbS.zi();
        AppMethodBeat.o(151548);
        return 0;
      case 6: 
        locallog_13913.time_stamp_ = locala.UbS.zl();
        AppMethodBeat.o(151548);
        return 0;
      case 7: 
        locallog_13913.scene_ = locala.UbS.zi();
        AppMethodBeat.o(151548);
        return 0;
      }
      locallog_13913.error_ = locala.UbS.readString();
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