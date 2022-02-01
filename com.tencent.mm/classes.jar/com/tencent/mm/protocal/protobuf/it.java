package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class it
  extends com.tencent.mm.cd.a
{
  public String DNV;
  public String OIl;
  public String ROB;
  public String ROC;
  public String ROD;
  public boolean ROE;
  public String ROF;
  public String fvP;
  public String tyK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72419);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.DNV != null) {
        paramVarArgs.f(1, this.DNV);
      }
      if (this.fvP != null) {
        paramVarArgs.f(2, this.fvP);
      }
      if (this.tyK != null) {
        paramVarArgs.f(3, this.tyK);
      }
      if (this.OIl != null) {
        paramVarArgs.f(4, this.OIl);
      }
      if (this.ROB != null) {
        paramVarArgs.f(5, this.ROB);
      }
      if (this.ROC != null) {
        paramVarArgs.f(6, this.ROC);
      }
      if (this.ROD != null) {
        paramVarArgs.f(8, this.ROD);
      }
      paramVarArgs.co(9, this.ROE);
      if (this.ROF != null) {
        paramVarArgs.f(10, this.ROF);
      }
      AppMethodBeat.o(72419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DNV == null) {
        break label690;
      }
    }
    label690:
    for (int i = g.a.a.b.b.a.g(1, this.DNV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fvP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fvP);
      }
      i = paramInt;
      if (this.tyK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.tyK);
      }
      paramInt = i;
      if (this.OIl != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.OIl);
      }
      i = paramInt;
      if (this.ROB != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.ROB);
      }
      paramInt = i;
      if (this.ROC != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ROC);
      }
      i = paramInt;
      if (this.ROD != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.ROD);
      }
      i += g.a.a.b.b.a.gL(9) + 1;
      paramInt = i;
      if (this.ROF != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.ROF);
      }
      AppMethodBeat.o(72419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72419);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        it localit = (it)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(72419);
          return -1;
        case 1: 
          localit.DNV = locala.abFh.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 2: 
          localit.fvP = locala.abFh.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 3: 
          localit.tyK = locala.abFh.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 4: 
          localit.OIl = locala.abFh.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 5: 
          localit.ROB = locala.abFh.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 6: 
          localit.ROC = locala.abFh.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 8: 
          localit.ROD = locala.abFh.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 9: 
          localit.ROE = locala.abFh.AB();
          AppMethodBeat.o(72419);
          return 0;
        }
        localit.ROF = locala.abFh.readString();
        AppMethodBeat.o(72419);
        return 0;
      }
      AppMethodBeat.o(72419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.it
 * JD-Core Version:    0.7.0.1
 */