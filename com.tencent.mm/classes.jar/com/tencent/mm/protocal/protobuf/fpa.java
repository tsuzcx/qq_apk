package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fpa
  extends com.tencent.mm.cd.a
{
  public String CqK;
  public String RIC;
  public int RTb;
  public int UMU;
  public String Uhg;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.f(1, this.Username);
      }
      if (this.CqK != null) {
        paramVarArgs.f(2, this.CqK);
      }
      paramVarArgs.aY(3, this.RTb);
      if (this.Uhg != null) {
        paramVarArgs.f(4, this.Uhg);
      }
      paramVarArgs.aY(5, this.UMU);
      if (this.RIC != null) {
        paramVarArgs.f(6, this.RIC);
      }
      AppMethodBeat.o(117959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label486;
      }
    }
    label486:
    for (paramInt = g.a.a.b.b.a.g(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CqK != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CqK);
      }
      i += g.a.a.b.b.a.bM(3, this.RTb);
      paramInt = i;
      if (this.Uhg != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Uhg);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.UMU);
      paramInt = i;
      if (this.RIC != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RIC);
      }
      AppMethodBeat.o(117959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117959);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fpa localfpa = (fpa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117959);
          return -1;
        case 1: 
          localfpa.Username = locala.abFh.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 2: 
          localfpa.CqK = locala.abFh.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 3: 
          localfpa.RTb = locala.abFh.AK();
          AppMethodBeat.o(117959);
          return 0;
        case 4: 
          localfpa.Uhg = locala.abFh.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 5: 
          localfpa.UMU = locala.abFh.AK();
          AppMethodBeat.o(117959);
          return 0;
        }
        localfpa.RIC = locala.abFh.readString();
        AppMethodBeat.o(117959);
        return 0;
      }
      AppMethodBeat.o(117959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpa
 * JD-Core Version:    0.7.0.1
 */