package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnq
  extends com.tencent.mm.cd.a
{
  public String CqK;
  public String SCg;
  public String SYK;
  public String SYL;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194355);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVG != null) {
        paramVarArgs.f(1, this.lVG);
      }
      if (this.CqK != null) {
        paramVarArgs.f(2, this.CqK);
      }
      if (this.SCg != null) {
        paramVarArgs.f(3, this.SCg);
      }
      if (this.SYK != null) {
        paramVarArgs.f(4, this.SYK);
      }
      if (this.SYL != null) {
        paramVarArgs.f(5, this.SYL);
      }
      AppMethodBeat.o(194355);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lVG == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.g(1, this.lVG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CqK != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CqK);
      }
      i = paramInt;
      if (this.SCg != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SCg);
      }
      paramInt = i;
      if (this.SYK != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SYK);
      }
      i = paramInt;
      if (this.SYL != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SYL);
      }
      AppMethodBeat.o(194355);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194355);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bnq localbnq = (bnq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194355);
          return -1;
        case 1: 
          localbnq.lVG = locala.abFh.readString();
          AppMethodBeat.o(194355);
          return 0;
        case 2: 
          localbnq.CqK = locala.abFh.readString();
          AppMethodBeat.o(194355);
          return 0;
        case 3: 
          localbnq.SCg = locala.abFh.readString();
          AppMethodBeat.o(194355);
          return 0;
        case 4: 
          localbnq.SYK = locala.abFh.readString();
          AppMethodBeat.o(194355);
          return 0;
        }
        localbnq.SYL = locala.abFh.readString();
        AppMethodBeat.o(194355);
        return 0;
      }
      AppMethodBeat.o(194355);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnq
 * JD-Core Version:    0.7.0.1
 */