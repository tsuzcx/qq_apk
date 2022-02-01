package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.cd.a
{
  public String RDC;
  public long RDE;
  public int RDF;
  public long RDw;
  public String llP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91332);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.llP != null) {
        paramVarArgs.f(1, this.llP);
      }
      paramVarArgs.bm(2, this.RDw);
      paramVarArgs.bm(3, this.RDE);
      paramVarArgs.aY(4, this.RDF);
      if (this.RDC != null) {
        paramVarArgs.f(5, this.RDC);
      }
      AppMethodBeat.o(91332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.llP == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = g.a.a.b.b.a.g(1, this.llP) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.RDw) + g.a.a.b.b.a.p(3, this.RDE) + g.a.a.b.b.a.bM(4, this.RDF);
      paramInt = i;
      if (this.RDC != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RDC);
      }
      AppMethodBeat.o(91332);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91332);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91332);
          return -1;
        case 1: 
          localx.llP = locala.abFh.readString();
          AppMethodBeat.o(91332);
          return 0;
        case 2: 
          localx.RDw = locala.abFh.AN();
          AppMethodBeat.o(91332);
          return 0;
        case 3: 
          localx.RDE = locala.abFh.AN();
          AppMethodBeat.o(91332);
          return 0;
        case 4: 
          localx.RDF = locala.abFh.AK();
          AppMethodBeat.o(91332);
          return 0;
        }
        localx.RDC = locala.abFh.readString();
        AppMethodBeat.o(91332);
        return 0;
      }
      AppMethodBeat.o(91332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.x
 * JD-Core Version:    0.7.0.1
 */