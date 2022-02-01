package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmi
  extends com.tencent.mm.cd.a
{
  public String CNj;
  public int RTb;
  public String TPZ;
  public String ULc;
  public String UserName;
  public String jUi;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117957);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TPZ != null) {
        paramVarArgs.f(1, this.TPZ);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(3, this.rWI);
      }
      if (this.jUi != null) {
        paramVarArgs.f(4, this.jUi);
      }
      paramVarArgs.aY(5, this.RTb);
      if (this.ULc != null) {
        paramVarArgs.f(6, this.ULc);
      }
      if (this.CNj != null) {
        paramVarArgs.f(7, this.CNj);
      }
      AppMethodBeat.o(117957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TPZ == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.g(1, this.TPZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.rWI);
      }
      paramInt = i;
      if (this.jUi != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jUi);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RTb);
      paramInt = i;
      if (this.ULc != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ULc);
      }
      i = paramInt;
      if (this.CNj != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.CNj);
      }
      AppMethodBeat.o(117957);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117957);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fmi localfmi = (fmi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117957);
          return -1;
        case 1: 
          localfmi.TPZ = locala.abFh.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 2: 
          localfmi.UserName = locala.abFh.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 3: 
          localfmi.rWI = locala.abFh.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 4: 
          localfmi.jUi = locala.abFh.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 5: 
          localfmi.RTb = locala.abFh.AK();
          AppMethodBeat.o(117957);
          return 0;
        case 6: 
          localfmi.ULc = locala.abFh.readString();
          AppMethodBeat.o(117957);
          return 0;
        }
        localfmi.CNj = locala.abFh.readString();
        AppMethodBeat.o(117957);
        return 0;
      }
      AppMethodBeat.o(117957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmi
 * JD-Core Version:    0.7.0.1
 */