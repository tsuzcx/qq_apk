package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class log_13532
  extends com.tencent.mm.bw.a
{
  public int clientVersion_;
  public int device_;
  public int ds_;
  public int import_ds_;
  public long time_stamp_;
  public int type;
  public long uin_;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151544);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.import_ds_);
      paramVarArgs.aM(2, this.ds_);
      paramVarArgs.bb(3, this.uin_);
      paramVarArgs.aM(4, this.device_);
      paramVarArgs.aM(5, this.clientVersion_);
      paramVarArgs.bb(6, this.time_stamp_);
      paramVarArgs.aM(7, this.type);
      AppMethodBeat.o(151544);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.import_ds_);
      int i = g.a.a.b.b.a.bu(2, this.ds_);
      int j = g.a.a.b.b.a.r(3, this.uin_);
      int k = g.a.a.b.b.a.bu(4, this.device_);
      int m = g.a.a.b.b.a.bu(5, this.clientVersion_);
      int n = g.a.a.b.b.a.r(6, this.time_stamp_);
      int i1 = g.a.a.b.b.a.bu(7, this.type);
      AppMethodBeat.o(151544);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(151544);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      log_13532 locallog_13532 = (log_13532)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151544);
        return -1;
      case 1: 
        locallog_13532.import_ds_ = locala.UbS.zi();
        AppMethodBeat.o(151544);
        return 0;
      case 2: 
        locallog_13532.ds_ = locala.UbS.zi();
        AppMethodBeat.o(151544);
        return 0;
      case 3: 
        locallog_13532.uin_ = locala.UbS.zl();
        AppMethodBeat.o(151544);
        return 0;
      case 4: 
        locallog_13532.device_ = locala.UbS.zi();
        AppMethodBeat.o(151544);
        return 0;
      case 5: 
        locallog_13532.clientVersion_ = locala.UbS.zi();
        AppMethodBeat.o(151544);
        return 0;
      case 6: 
        locallog_13532.time_stamp_ = locala.UbS.zl();
        AppMethodBeat.o(151544);
        return 0;
      }
      locallog_13532.type = locala.UbS.zi();
      AppMethodBeat.o(151544);
      return 0;
    }
    AppMethodBeat.o(151544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_13532
 * JD-Core Version:    0.7.0.1
 */