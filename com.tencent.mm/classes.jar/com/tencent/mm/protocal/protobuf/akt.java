package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akt
  extends com.tencent.mm.cd.a
{
  public int CKC;
  public int SvA;
  public int SvB;
  public String SvC;
  public String ufC;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179487);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SvA);
      paramVarArgs.aY(2, this.SvB);
      paramVarArgs.aY(3, this.CKC);
      if (this.wording != null) {
        paramVarArgs.f(4, this.wording);
      }
      if (this.ufC != null) {
        paramVarArgs.f(5, this.ufC);
      }
      if (this.SvC != null) {
        paramVarArgs.f(6, this.SvC);
      }
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SvA) + 0 + g.a.a.b.b.a.bM(2, this.SvB) + g.a.a.b.b.a.bM(3, this.CKC);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.wording);
      }
      i = paramInt;
      if (this.ufC != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.ufC);
      }
      paramInt = i;
      if (this.SvC != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SvC);
      }
      AppMethodBeat.o(179487);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      akt localakt = (akt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(179487);
        return -1;
      case 1: 
        localakt.SvA = locala.abFh.AK();
        AppMethodBeat.o(179487);
        return 0;
      case 2: 
        localakt.SvB = locala.abFh.AK();
        AppMethodBeat.o(179487);
        return 0;
      case 3: 
        localakt.CKC = locala.abFh.AK();
        AppMethodBeat.o(179487);
        return 0;
      case 4: 
        localakt.wording = locala.abFh.readString();
        AppMethodBeat.o(179487);
        return 0;
      case 5: 
        localakt.ufC = locala.abFh.readString();
        AppMethodBeat.o(179487);
        return 0;
      }
      localakt.SvC = locala.abFh.readString();
      AppMethodBeat.o(179487);
      return 0;
    }
    AppMethodBeat.o(179487);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akt
 * JD-Core Version:    0.7.0.1
 */