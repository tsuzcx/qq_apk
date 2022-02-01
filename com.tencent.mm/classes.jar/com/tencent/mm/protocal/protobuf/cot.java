package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cot
  extends com.tencent.mm.cd.a
{
  public int TwF;
  public String jUb;
  public String jUc;
  public String jUd;
  public String jUe;
  public String jUf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116336);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jUb != null) {
        paramVarArgs.f(1, this.jUb);
      }
      if (this.jUc != null) {
        paramVarArgs.f(2, this.jUc);
      }
      if (this.jUd != null) {
        paramVarArgs.f(3, this.jUd);
      }
      if (this.jUe != null) {
        paramVarArgs.f(4, this.jUe);
      }
      if (this.jUf != null) {
        paramVarArgs.f(5, this.jUf);
      }
      paramVarArgs.aY(6, this.TwF);
      AppMethodBeat.o(116336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jUb == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.g(1, this.jUb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jUc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jUc);
      }
      i = paramInt;
      if (this.jUd != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jUd);
      }
      paramInt = i;
      if (this.jUe != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jUe);
      }
      i = paramInt;
      if (this.jUf != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.jUf);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.TwF);
      AppMethodBeat.o(116336);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116336);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cot localcot = (cot)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116336);
          return -1;
        case 1: 
          localcot.jUb = locala.abFh.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 2: 
          localcot.jUc = locala.abFh.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 3: 
          localcot.jUd = locala.abFh.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 4: 
          localcot.jUe = locala.abFh.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 5: 
          localcot.jUf = locala.abFh.readString();
          AppMethodBeat.o(116336);
          return 0;
        }
        localcot.TwF = locala.abFh.AK();
        AppMethodBeat.o(116336);
        return 0;
      }
      AppMethodBeat.o(116336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cot
 * JD-Core Version:    0.7.0.1
 */