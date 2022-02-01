package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhz
  extends com.tencent.mm.bw.a
{
  public String EIR = "";
  public String activityName = "";
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122553);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.activityName != null) {
        paramVarArgs.d(1, this.activityName);
      }
      if (this.EIR != null) {
        paramVarArgs.d(2, this.EIR);
      }
      paramVarArgs.aO(3, this.timestamp);
      AppMethodBeat.o(122553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.activityName == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.activityName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EIR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EIR);
      }
      paramInt = f.a.a.b.b.a.p(3, this.timestamp);
      AppMethodBeat.o(122553);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122553);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dhz localdhz = (dhz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122553);
          return -1;
        case 1: 
          localdhz.activityName = locala.LVo.readString();
          AppMethodBeat.o(122553);
          return 0;
        case 2: 
          localdhz.EIR = locala.LVo.readString();
          AppMethodBeat.o(122553);
          return 0;
        }
        localdhz.timestamp = locala.LVo.xG();
        AppMethodBeat.o(122553);
        return 0;
      }
      AppMethodBeat.o(122553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhz
 * JD-Core Version:    0.7.0.1
 */