package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvu
  extends com.tencent.mm.cd.a
{
  public String TGk;
  public String UbL;
  public String UbM;
  public String UbN;
  public String rWI;
  public String vhp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134253);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rWI != null) {
        paramVarArgs.f(1, this.rWI);
      }
      if (this.UbL != null) {
        paramVarArgs.f(2, this.UbL);
      }
      if (this.TGk != null) {
        paramVarArgs.f(3, this.TGk);
      }
      if (this.UbM != null) {
        paramVarArgs.f(4, this.UbM);
      }
      if (this.vhp != null) {
        paramVarArgs.f(5, this.vhp);
      }
      if (this.UbN != null) {
        paramVarArgs.f(6, this.UbN);
      }
      AppMethodBeat.o(134253);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rWI == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.g(1, this.rWI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UbL != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UbL);
      }
      i = paramInt;
      if (this.TGk != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TGk);
      }
      paramInt = i;
      if (this.UbM != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UbM);
      }
      i = paramInt;
      if (this.vhp != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.vhp);
      }
      paramInt = i;
      if (this.UbN != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UbN);
      }
      AppMethodBeat.o(134253);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(134253);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dvu localdvu = (dvu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134253);
          return -1;
        case 1: 
          localdvu.rWI = locala.abFh.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 2: 
          localdvu.UbL = locala.abFh.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 3: 
          localdvu.TGk = locala.abFh.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 4: 
          localdvu.UbM = locala.abFh.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 5: 
          localdvu.vhp = locala.abFh.readString();
          AppMethodBeat.o(134253);
          return 0;
        }
        localdvu.UbN = locala.abFh.readString();
        AppMethodBeat.o(134253);
        return 0;
      }
      AppMethodBeat.o(134253);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvu
 * JD-Core Version:    0.7.0.1
 */