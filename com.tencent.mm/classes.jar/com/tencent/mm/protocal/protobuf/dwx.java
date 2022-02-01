package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwx
  extends com.tencent.mm.cd.a
{
  public int Jwa;
  public int UcF;
  public int UcG;
  public String jUb;
  public String jUc;
  public String jUd;
  public String jUe;
  public String rWh;
  public String sST;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123640);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rWh != null) {
        paramVarArgs.f(1, this.rWh);
      }
      paramVarArgs.aY(2, this.UcF);
      if (this.jUb != null) {
        paramVarArgs.f(3, this.jUb);
      }
      if (this.jUc != null) {
        paramVarArgs.f(4, this.jUc);
      }
      paramVarArgs.aY(5, this.Jwa);
      paramVarArgs.aY(6, this.UcG);
      if (this.jUd != null) {
        paramVarArgs.f(7, this.jUd);
      }
      if (this.jUe != null) {
        paramVarArgs.f(8, this.jUe);
      }
      if (this.sST != null) {
        paramVarArgs.f(9, this.sST);
      }
      AppMethodBeat.o(123640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rWh == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = g.a.a.b.b.a.g(1, this.rWh) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.UcF);
      paramInt = i;
      if (this.jUb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.jUb);
      }
      i = paramInt;
      if (this.jUc != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.jUc);
      }
      i = i + g.a.a.b.b.a.bM(5, this.Jwa) + g.a.a.b.b.a.bM(6, this.UcG);
      paramInt = i;
      if (this.jUd != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.jUd);
      }
      i = paramInt;
      if (this.jUe != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.jUe);
      }
      paramInt = i;
      if (this.sST != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.sST);
      }
      AppMethodBeat.o(123640);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123640);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dwx localdwx = (dwx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123640);
          return -1;
        case 1: 
          localdwx.rWh = locala.abFh.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 2: 
          localdwx.UcF = locala.abFh.AK();
          AppMethodBeat.o(123640);
          return 0;
        case 3: 
          localdwx.jUb = locala.abFh.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 4: 
          localdwx.jUc = locala.abFh.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 5: 
          localdwx.Jwa = locala.abFh.AK();
          AppMethodBeat.o(123640);
          return 0;
        case 6: 
          localdwx.UcG = locala.abFh.AK();
          AppMethodBeat.o(123640);
          return 0;
        case 7: 
          localdwx.jUd = locala.abFh.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 8: 
          localdwx.jUe = locala.abFh.readString();
          AppMethodBeat.o(123640);
          return 0;
        }
        localdwx.sST = locala.abFh.readString();
        AppMethodBeat.o(123640);
        return 0;
      }
      AppMethodBeat.o(123640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwx
 * JD-Core Version:    0.7.0.1
 */