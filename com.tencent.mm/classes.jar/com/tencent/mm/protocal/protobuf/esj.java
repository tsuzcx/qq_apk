package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esj
  extends com.tencent.mm.cd.a
{
  public int aNf = 0;
  public String activityName = "";
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122553);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.activityName != null) {
        paramVarArgs.f(1, this.activityName);
      }
      paramVarArgs.aY(2, this.aNf);
      paramVarArgs.bm(3, this.timestamp);
      AppMethodBeat.o(122553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.activityName == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.activityName) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.aNf);
      int j = g.a.a.b.b.a.p(3, this.timestamp);
      AppMethodBeat.o(122553);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122553);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        esj localesj = (esj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122553);
          return -1;
        case 1: 
          localesj.activityName = locala.abFh.readString();
          AppMethodBeat.o(122553);
          return 0;
        case 2: 
          localesj.aNf = locala.abFh.AK();
          AppMethodBeat.o(122553);
          return 0;
        }
        localesj.timestamp = locala.abFh.AN();
        AppMethodBeat.o(122553);
        return 0;
      }
      AppMethodBeat.o(122553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esj
 * JD-Core Version:    0.7.0.1
 */