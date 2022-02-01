package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqj
  extends com.tencent.mm.cd.a
{
  public int Cqs;
  public String UsQ;
  public String UsR;
  public int UsS;
  public String UsT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211177);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UsQ != null) {
        paramVarArgs.f(1, this.UsQ);
      }
      if (this.UsR != null) {
        paramVarArgs.f(2, this.UsR);
      }
      paramVarArgs.aY(3, this.Cqs);
      paramVarArgs.aY(4, this.UsS);
      if (this.UsT != null) {
        paramVarArgs.f(5, this.UsT);
      }
      AppMethodBeat.o(211177);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UsQ == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.UsQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UsR != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UsR);
      }
      i = i + g.a.a.b.b.a.bM(3, this.Cqs) + g.a.a.b.b.a.bM(4, this.UsS);
      paramInt = i;
      if (this.UsT != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UsT);
      }
      AppMethodBeat.o(211177);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(211177);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eqj localeqj = (eqj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(211177);
          return -1;
        case 1: 
          localeqj.UsQ = locala.abFh.readString();
          AppMethodBeat.o(211177);
          return 0;
        case 2: 
          localeqj.UsR = locala.abFh.readString();
          AppMethodBeat.o(211177);
          return 0;
        case 3: 
          localeqj.Cqs = locala.abFh.AK();
          AppMethodBeat.o(211177);
          return 0;
        case 4: 
          localeqj.UsS = locala.abFh.AK();
          AppMethodBeat.o(211177);
          return 0;
        }
        localeqj.UsT = locala.abFh.readString();
        AppMethodBeat.o(211177);
        return 0;
      }
      AppMethodBeat.o(211177);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqj
 * JD-Core Version:    0.7.0.1
 */