package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class log_13532
  extends com.tencent.mm.bv.a
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
    AppMethodBeat.i(79158);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.import_ds_);
      paramVarArgs.aO(2, this.ds_);
      paramVarArgs.am(3, this.uin_);
      paramVarArgs.aO(4, this.device_);
      paramVarArgs.aO(5, this.clientVersion_);
      paramVarArgs.am(6, this.time_stamp_);
      paramVarArgs.aO(7, this.type);
      AppMethodBeat.o(79158);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.import_ds_);
      int i = e.a.a.b.b.a.bl(2, this.ds_);
      int j = e.a.a.b.b.a.p(3, this.uin_);
      int k = e.a.a.b.b.a.bl(4, this.device_);
      int m = e.a.a.b.b.a.bl(5, this.clientVersion_);
      int n = e.a.a.b.b.a.p(6, this.time_stamp_);
      int i1 = e.a.a.b.b.a.bl(7, this.type);
      AppMethodBeat.o(79158);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(79158);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      log_13532 locallog_13532 = (log_13532)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(79158);
        return -1;
      case 1: 
        locallog_13532.import_ds_ = locala.CLY.sl();
        AppMethodBeat.o(79158);
        return 0;
      case 2: 
        locallog_13532.ds_ = locala.CLY.sl();
        AppMethodBeat.o(79158);
        return 0;
      case 3: 
        locallog_13532.uin_ = locala.CLY.sm();
        AppMethodBeat.o(79158);
        return 0;
      case 4: 
        locallog_13532.device_ = locala.CLY.sl();
        AppMethodBeat.o(79158);
        return 0;
      case 5: 
        locallog_13532.clientVersion_ = locala.CLY.sl();
        AppMethodBeat.o(79158);
        return 0;
      case 6: 
        locallog_13532.time_stamp_ = locala.CLY.sm();
        AppMethodBeat.o(79158);
        return 0;
      }
      locallog_13532.type = locala.CLY.sl();
      AppMethodBeat.o(79158);
      return 0;
    }
    AppMethodBeat.o(79158);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.log_13532
 * JD-Core Version:    0.7.0.1
 */