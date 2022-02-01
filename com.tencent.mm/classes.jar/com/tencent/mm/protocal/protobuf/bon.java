package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class bon
  extends com.tencent.mm.cd.a
{
  public String CqK;
  public String SZA;
  public String SZB;
  public b SZC;
  public String UserName;
  public int jUk;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194379);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CqK != null) {
        paramVarArgs.f(1, this.CqK);
      }
      if (this.SZA != null) {
        paramVarArgs.f(2, this.SZA);
      }
      if (this.SZB != null) {
        paramVarArgs.f(3, this.SZB);
      }
      paramVarArgs.aY(4, this.jUk);
      if (this.SZC != null) {
        paramVarArgs.c(5, this.SZC);
      }
      if (this.lVG != null) {
        paramVarArgs.f(6, this.lVG);
      }
      if (this.UserName != null) {
        paramVarArgs.f(7, this.UserName);
      }
      AppMethodBeat.o(194379);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CqK == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.g(1, this.CqK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SZA != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SZA);
      }
      i = paramInt;
      if (this.SZB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SZB);
      }
      i += g.a.a.b.b.a.bM(4, this.jUk);
      paramInt = i;
      if (this.SZC != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.SZC);
      }
      i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.lVG);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UserName);
      }
      AppMethodBeat.o(194379);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194379);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bon localbon = (bon)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194379);
          return -1;
        case 1: 
          localbon.CqK = locala.abFh.readString();
          AppMethodBeat.o(194379);
          return 0;
        case 2: 
          localbon.SZA = locala.abFh.readString();
          AppMethodBeat.o(194379);
          return 0;
        case 3: 
          localbon.SZB = locala.abFh.readString();
          AppMethodBeat.o(194379);
          return 0;
        case 4: 
          localbon.jUk = locala.abFh.AK();
          AppMethodBeat.o(194379);
          return 0;
        case 5: 
          localbon.SZC = locala.abFh.iUw();
          AppMethodBeat.o(194379);
          return 0;
        case 6: 
          localbon.lVG = locala.abFh.readString();
          AppMethodBeat.o(194379);
          return 0;
        }
        localbon.UserName = locala.abFh.readString();
        AppMethodBeat.o(194379);
        return 0;
      }
      AppMethodBeat.o(194379);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bon
 * JD-Core Version:    0.7.0.1
 */