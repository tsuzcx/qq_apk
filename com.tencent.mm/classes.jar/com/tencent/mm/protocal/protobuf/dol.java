package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dol
  extends com.tencent.mm.bw.a
{
  public int aHQ = 0;
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
      paramVarArgs.aS(2, this.aHQ);
      paramVarArgs.aZ(3, this.timestamp);
      AppMethodBeat.o(122553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.activityName == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.activityName) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.aHQ);
      int j = f.a.a.b.b.a.p(3, this.timestamp);
      AppMethodBeat.o(122553);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122553);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dol localdol = (dol)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122553);
          return -1;
        case 1: 
          localdol.activityName = locala.OmT.readString();
          AppMethodBeat.o(122553);
          return 0;
        case 2: 
          localdol.aHQ = locala.OmT.zc();
          AppMethodBeat.o(122553);
          return 0;
        }
        localdol.timestamp = locala.OmT.zd();
        AppMethodBeat.o(122553);
        return 0;
      }
      AppMethodBeat.o(122553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dol
 * JD-Core Version:    0.7.0.1
 */