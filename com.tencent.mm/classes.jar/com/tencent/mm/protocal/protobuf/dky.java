package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dky
  extends com.tencent.mm.cd.a
{
  public String Smr;
  public boolean TSe;
  public boolean TSf;
  public String bhm;
  public String fLC;
  public String qBF;
  public String qBG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123634);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fLC != null) {
        paramVarArgs.f(1, this.fLC);
      }
      if (this.Smr != null) {
        paramVarArgs.f(2, this.Smr);
      }
      paramVarArgs.co(3, this.TSe);
      paramVarArgs.co(4, this.TSf);
      if (this.qBF != null) {
        paramVarArgs.f(5, this.qBF);
      }
      if (this.bhm != null) {
        paramVarArgs.f(6, this.bhm);
      }
      if (this.qBG != null) {
        paramVarArgs.f(7, this.qBG);
      }
      AppMethodBeat.o(123634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fLC == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = g.a.a.b.b.a.g(1, this.fLC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Smr != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Smr);
      }
      i = i + (g.a.a.b.b.a.gL(3) + 1) + (g.a.a.b.b.a.gL(4) + 1);
      paramInt = i;
      if (this.qBF != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.qBF);
      }
      i = paramInt;
      if (this.bhm != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.bhm);
      }
      paramInt = i;
      if (this.qBG != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.qBG);
      }
      AppMethodBeat.o(123634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123634);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dky localdky = (dky)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123634);
          return -1;
        case 1: 
          localdky.fLC = locala.abFh.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 2: 
          localdky.Smr = locala.abFh.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 3: 
          localdky.TSe = locala.abFh.AB();
          AppMethodBeat.o(123634);
          return 0;
        case 4: 
          localdky.TSf = locala.abFh.AB();
          AppMethodBeat.o(123634);
          return 0;
        case 5: 
          localdky.qBF = locala.abFh.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 6: 
          localdky.bhm = locala.abFh.readString();
          AppMethodBeat.o(123634);
          return 0;
        }
        localdky.qBG = locala.abFh.readString();
        AppMethodBeat.o(123634);
        return 0;
      }
      AppMethodBeat.o(123634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dky
 * JD-Core Version:    0.7.0.1
 */