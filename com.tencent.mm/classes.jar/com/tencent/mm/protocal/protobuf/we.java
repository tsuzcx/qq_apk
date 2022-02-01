package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class we
  extends com.tencent.mm.cd.a
{
  public String SiF;
  public String announcement;
  public int end_time;
  public String fUL;
  public int update_time;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113981);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fUL != null) {
        paramVarArgs.f(1, this.fUL);
      }
      if (this.announcement != null) {
        paramVarArgs.f(2, this.announcement);
      }
      paramVarArgs.aY(3, this.end_time);
      paramVarArgs.aY(4, this.update_time);
      if (this.SiF != null) {
        paramVarArgs.f(5, this.SiF);
      }
      AppMethodBeat.o(113981);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fUL == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.fUL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.announcement != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.announcement);
      }
      i = i + g.a.a.b.b.a.bM(3, this.end_time) + g.a.a.b.b.a.bM(4, this.update_time);
      paramInt = i;
      if (this.SiF != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SiF);
      }
      AppMethodBeat.o(113981);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113981);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        we localwe = (we)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113981);
          return -1;
        case 1: 
          localwe.fUL = locala.abFh.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 2: 
          localwe.announcement = locala.abFh.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 3: 
          localwe.end_time = locala.abFh.AK();
          AppMethodBeat.o(113981);
          return 0;
        case 4: 
          localwe.update_time = locala.abFh.AK();
          AppMethodBeat.o(113981);
          return 0;
        }
        localwe.SiF = locala.abFh.readString();
        AppMethodBeat.o(113981);
        return 0;
      }
      AppMethodBeat.o(113981);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.we
 * JD-Core Version:    0.7.0.1
 */