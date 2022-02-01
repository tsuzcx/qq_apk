package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.cd.a
{
  public String RDi;
  public String RDj;
  public String RDx;
  public String RDy;
  public String RDz;
  public long gbJ;
  public int role;
  public int state;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91322);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RDi != null) {
        paramVarArgs.f(1, this.RDi);
      }
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      paramVarArgs.bm(3, this.gbJ);
      if (this.RDx != null) {
        paramVarArgs.f(5, this.RDx);
      }
      paramVarArgs.aY(10, this.state);
      paramVarArgs.aY(11, this.role);
      if (this.RDy != null) {
        paramVarArgs.f(12, this.RDy);
      }
      if (this.RDj != null) {
        paramVarArgs.f(13, this.RDj);
      }
      if (this.RDz != null) {
        paramVarArgs.f(14, this.RDz);
      }
      AppMethodBeat.o(91322);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RDi == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = g.a.a.b.b.a.g(1, this.RDi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.title);
      }
      i += g.a.a.b.b.a.p(3, this.gbJ);
      paramInt = i;
      if (this.RDx != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RDx);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.state) + g.a.a.b.b.a.bM(11, this.role);
      paramInt = i;
      if (this.RDy != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.RDy);
      }
      i = paramInt;
      if (this.RDj != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.RDj);
      }
      paramInt = i;
      if (this.RDz != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.RDz);
      }
      AppMethodBeat.o(91322);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91322);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 4: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(91322);
          return -1;
        case 1: 
          localn.RDi = locala.abFh.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 2: 
          localn.title = locala.abFh.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 3: 
          localn.gbJ = locala.abFh.AN();
          AppMethodBeat.o(91322);
          return 0;
        case 5: 
          localn.RDx = locala.abFh.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 10: 
          localn.state = locala.abFh.AK();
          AppMethodBeat.o(91322);
          return 0;
        case 11: 
          localn.role = locala.abFh.AK();
          AppMethodBeat.o(91322);
          return 0;
        case 12: 
          localn.RDy = locala.abFh.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 13: 
          localn.RDj = locala.abFh.readString();
          AppMethodBeat.o(91322);
          return 0;
        }
        localn.RDz = locala.abFh.readString();
        AppMethodBeat.o(91322);
        return 0;
      }
      AppMethodBeat.o(91322);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.n
 * JD-Core Version:    0.7.0.1
 */