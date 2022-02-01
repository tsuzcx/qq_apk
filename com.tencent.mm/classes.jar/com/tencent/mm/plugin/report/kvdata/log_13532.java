package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class log_13532
  extends com.tencent.mm.bx.a
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.import_ds_);
      paramVarArgs.aS(2, this.ds_);
      paramVarArgs.aY(3, this.uin_);
      paramVarArgs.aS(4, this.device_);
      paramVarArgs.aS(5, this.clientVersion_);
      paramVarArgs.aY(6, this.time_stamp_);
      paramVarArgs.aS(7, this.type);
      AppMethodBeat.o(151544);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.import_ds_);
      int i = f.a.a.b.b.a.bz(2, this.ds_);
      int j = f.a.a.b.b.a.p(3, this.uin_);
      int k = f.a.a.b.b.a.bz(4, this.device_);
      int m = f.a.a.b.b.a.bz(5, this.clientVersion_);
      int n = f.a.a.b.b.a.p(6, this.time_stamp_);
      int i1 = f.a.a.b.b.a.bz(7, this.type);
      AppMethodBeat.o(151544);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(151544);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      log_13532 locallog_13532 = (log_13532)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151544);
        return -1;
      case 1: 
        locallog_13532.import_ds_ = locala.NPN.zc();
        AppMethodBeat.o(151544);
        return 0;
      case 2: 
        locallog_13532.ds_ = locala.NPN.zc();
        AppMethodBeat.o(151544);
        return 0;
      case 3: 
        locallog_13532.uin_ = locala.NPN.zd();
        AppMethodBeat.o(151544);
        return 0;
      case 4: 
        locallog_13532.device_ = locala.NPN.zc();
        AppMethodBeat.o(151544);
        return 0;
      case 5: 
        locallog_13532.clientVersion_ = locala.NPN.zc();
        AppMethodBeat.o(151544);
        return 0;
      case 6: 
        locallog_13532.time_stamp_ = locala.NPN.zd();
        AppMethodBeat.o(151544);
        return 0;
      }
      locallog_13532.type = locala.NPN.zc();
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