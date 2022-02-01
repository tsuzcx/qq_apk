package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmd
  extends com.tencent.mm.bw.a
{
  public String MPH;
  public String MPI;
  public String MPJ;
  public String Mvm;
  public String oUJ;
  public String rBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134253);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oUJ != null) {
        paramVarArgs.e(1, this.oUJ);
      }
      if (this.MPH != null) {
        paramVarArgs.e(2, this.MPH);
      }
      if (this.Mvm != null) {
        paramVarArgs.e(3, this.Mvm);
      }
      if (this.MPI != null) {
        paramVarArgs.e(4, this.MPI);
      }
      if (this.rBH != null) {
        paramVarArgs.e(5, this.rBH);
      }
      if (this.MPJ != null) {
        paramVarArgs.e(6, this.MPJ);
      }
      AppMethodBeat.o(134253);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oUJ == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.f(1, this.oUJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MPH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MPH);
      }
      i = paramInt;
      if (this.Mvm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mvm);
      }
      paramInt = i;
      if (this.MPI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MPI);
      }
      i = paramInt;
      if (this.rBH != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.rBH);
      }
      paramInt = i;
      if (this.MPJ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MPJ);
      }
      AppMethodBeat.o(134253);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(134253);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dmd localdmd = (dmd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134253);
          return -1;
        case 1: 
          localdmd.oUJ = locala.UbS.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 2: 
          localdmd.MPH = locala.UbS.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 3: 
          localdmd.Mvm = locala.UbS.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 4: 
          localdmd.MPI = locala.UbS.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 5: 
          localdmd.rBH = locala.UbS.readString();
          AppMethodBeat.o(134253);
          return 0;
        }
        localdmd.MPJ = locala.UbS.readString();
        AppMethodBeat.o(134253);
        return 0;
      }
      AppMethodBeat.o(134253);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmd
 * JD-Core Version:    0.7.0.1
 */