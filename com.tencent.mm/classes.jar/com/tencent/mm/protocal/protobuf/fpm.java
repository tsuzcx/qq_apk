package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fpm
  extends com.tencent.mm.cd.a
{
  public int RSO;
  public int SbT;
  public String UNh;
  public int UNi;
  public boolean UNj = false;
  public boolean UNk = false;
  public String Uam;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117961);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RSO);
      paramVarArgs.aY(2, this.SbT);
      if (this.session_id != null) {
        paramVarArgs.f(3, this.session_id);
      }
      if (this.UNh != null) {
        paramVarArgs.f(4, this.UNh);
      }
      if (this.Uam != null) {
        paramVarArgs.f(5, this.Uam);
      }
      paramVarArgs.aY(6, this.UNi);
      paramVarArgs.co(7, this.UNj);
      paramVarArgs.co(8, this.UNk);
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RSO) + 0 + g.a.a.b.b.a.bM(2, this.SbT);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.session_id);
      }
      i = paramInt;
      if (this.UNh != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.UNh);
      }
      paramInt = i;
      if (this.Uam != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Uam);
      }
      i = g.a.a.b.b.a.bM(6, this.UNi);
      int j = g.a.a.b.b.a.gL(7);
      int k = g.a.a.b.b.a.gL(8);
      AppMethodBeat.o(117961);
      return paramInt + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fpm localfpm = (fpm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117961);
        return -1;
      case 1: 
        localfpm.RSO = locala.abFh.AK();
        AppMethodBeat.o(117961);
        return 0;
      case 2: 
        localfpm.SbT = locala.abFh.AK();
        AppMethodBeat.o(117961);
        return 0;
      case 3: 
        localfpm.session_id = locala.abFh.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 4: 
        localfpm.UNh = locala.abFh.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 5: 
        localfpm.Uam = locala.abFh.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 6: 
        localfpm.UNi = locala.abFh.AK();
        AppMethodBeat.o(117961);
        return 0;
      case 7: 
        localfpm.UNj = locala.abFh.AB();
        AppMethodBeat.o(117961);
        return 0;
      }
      localfpm.UNk = locala.abFh.AB();
      AppMethodBeat.o(117961);
      return 0;
    }
    AppMethodBeat.o(117961);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpm
 * JD-Core Version:    0.7.0.1
 */