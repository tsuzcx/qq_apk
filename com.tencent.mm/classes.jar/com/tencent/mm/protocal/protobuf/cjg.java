package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjg
  extends com.tencent.mm.cd.a
{
  public String TqG;
  public String TqH;
  public String TqI;
  public String TqJ;
  public String TqK;
  public String TqL;
  public String TqM;
  public String kVK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91521);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TqG != null) {
        paramVarArgs.f(1, this.TqG);
      }
      if (this.TqH != null) {
        paramVarArgs.f(2, this.TqH);
      }
      if (this.kVK != null) {
        paramVarArgs.f(3, this.kVK);
      }
      if (this.TqI != null) {
        paramVarArgs.f(4, this.TqI);
      }
      if (this.TqJ != null) {
        paramVarArgs.f(5, this.TqJ);
      }
      if (this.TqK != null) {
        paramVarArgs.f(6, this.TqK);
      }
      if (this.TqL != null) {
        paramVarArgs.f(7, this.TqL);
      }
      if (this.TqM != null) {
        paramVarArgs.f(8, this.TqM);
      }
      AppMethodBeat.o(91521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TqG == null) {
        break label642;
      }
    }
    label642:
    for (int i = g.a.a.b.b.a.g(1, this.TqG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TqH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TqH);
      }
      i = paramInt;
      if (this.kVK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.kVK);
      }
      paramInt = i;
      if (this.TqI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TqI);
      }
      i = paramInt;
      if (this.TqJ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TqJ);
      }
      paramInt = i;
      if (this.TqK != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TqK);
      }
      i = paramInt;
      if (this.TqL != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TqL);
      }
      paramInt = i;
      if (this.TqM != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TqM);
      }
      AppMethodBeat.o(91521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91521);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cjg localcjg = (cjg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91521);
          return -1;
        case 1: 
          localcjg.TqG = locala.abFh.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 2: 
          localcjg.TqH = locala.abFh.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 3: 
          localcjg.kVK = locala.abFh.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 4: 
          localcjg.TqI = locala.abFh.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 5: 
          localcjg.TqJ = locala.abFh.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 6: 
          localcjg.TqK = locala.abFh.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 7: 
          localcjg.TqL = locala.abFh.readString();
          AppMethodBeat.o(91521);
          return 0;
        }
        localcjg.TqM = locala.abFh.readString();
        AppMethodBeat.o(91521);
        return 0;
      }
      AppMethodBeat.o(91521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjg
 * JD-Core Version:    0.7.0.1
 */