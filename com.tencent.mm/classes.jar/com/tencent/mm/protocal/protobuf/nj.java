package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nj
  extends com.tencent.mm.cd.a
{
  public String RUi;
  public String RUj;
  public int RUk;
  public int RUl;
  public String RUm;
  public String RUn;
  public int RUo;
  public String name;
  public int type;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RUi != null) {
        paramVarArgs.f(1, this.RUi);
      }
      paramVarArgs.aY(2, this.type);
      if (this.RUj != null) {
        paramVarArgs.f(3, this.RUj);
      }
      if (this.name != null) {
        paramVarArgs.f(4, this.name);
      }
      paramVarArgs.aY(5, this.ver);
      paramVarArgs.aY(6, this.RUk);
      paramVarArgs.aY(7, this.RUl);
      if (this.RUm != null) {
        paramVarArgs.f(8, this.RUm);
      }
      if (this.RUn != null) {
        paramVarArgs.f(9, this.RUn);
      }
      paramVarArgs.aY(10, this.RUo);
      AppMethodBeat.o(124416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RUi == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = g.a.a.b.b.a.g(1, this.RUi) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type);
      paramInt = i;
      if (this.RUj != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RUj);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.name);
      }
      i = i + g.a.a.b.b.a.bM(5, this.ver) + g.a.a.b.b.a.bM(6, this.RUk) + g.a.a.b.b.a.bM(7, this.RUl);
      paramInt = i;
      if (this.RUm != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RUm);
      }
      i = paramInt;
      if (this.RUn != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.RUn);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.RUo);
      AppMethodBeat.o(124416);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124416);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        nj localnj = (nj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124416);
          return -1;
        case 1: 
          localnj.RUi = locala.abFh.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 2: 
          localnj.type = locala.abFh.AK();
          AppMethodBeat.o(124416);
          return 0;
        case 3: 
          localnj.RUj = locala.abFh.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 4: 
          localnj.name = locala.abFh.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 5: 
          localnj.ver = locala.abFh.AK();
          AppMethodBeat.o(124416);
          return 0;
        case 6: 
          localnj.RUk = locala.abFh.AK();
          AppMethodBeat.o(124416);
          return 0;
        case 7: 
          localnj.RUl = locala.abFh.AK();
          AppMethodBeat.o(124416);
          return 0;
        case 8: 
          localnj.RUm = locala.abFh.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 9: 
          localnj.RUn = locala.abFh.readString();
          AppMethodBeat.o(124416);
          return 0;
        }
        localnj.RUo = locala.abFh.AK();
        AppMethodBeat.o(124416);
        return 0;
      }
      AppMethodBeat.o(124416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nj
 * JD-Core Version:    0.7.0.1
 */