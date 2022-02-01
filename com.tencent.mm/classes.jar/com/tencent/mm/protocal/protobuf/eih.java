package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eih
  extends com.tencent.mm.bw.a
{
  public int aHK = 0;
  public String activityName = "";
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122553);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.activityName != null) {
        paramVarArgs.e(1, this.activityName);
      }
      paramVarArgs.aM(2, this.aHK);
      paramVarArgs.bb(3, this.timestamp);
      AppMethodBeat.o(122553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.activityName == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.activityName) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.aHK);
      int j = g.a.a.b.b.a.r(3, this.timestamp);
      AppMethodBeat.o(122553);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122553);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eih localeih = (eih)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122553);
          return -1;
        case 1: 
          localeih.activityName = locala.UbS.readString();
          AppMethodBeat.o(122553);
          return 0;
        case 2: 
          localeih.aHK = locala.UbS.zi();
          AppMethodBeat.o(122553);
          return 0;
        }
        localeih.timestamp = locala.UbS.zl();
        AppMethodBeat.o(122553);
        return 0;
      }
      AppMethodBeat.o(122553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eih
 * JD-Core Version:    0.7.0.1
 */