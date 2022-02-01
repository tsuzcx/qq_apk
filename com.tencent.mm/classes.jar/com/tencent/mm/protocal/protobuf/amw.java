package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amw
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public String MD5;
  public long Njv;
  public int NkN;
  public int NkO;
  public int ZtQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109447);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idd);
      paramVarArgs.bS(2, this.NkO);
      paramVarArgs.bS(3, this.NkN);
      if (this.MD5 != null) {
        paramVarArgs.g(4, this.MD5);
      }
      paramVarArgs.bS(5, this.ZtQ);
      paramVarArgs.bv(6, this.Njv);
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Idd) + 0 + i.a.a.b.b.a.cJ(2, this.NkO) + i.a.a.b.b.a.cJ(3, this.NkN);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MD5);
      }
      i = i.a.a.b.b.a.cJ(5, this.ZtQ);
      int j = i.a.a.b.b.a.q(6, this.Njv);
      AppMethodBeat.o(109447);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      amw localamw = (amw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(109447);
        return -1;
      case 1: 
        localamw.Idd = locala.ajGk.aar();
        AppMethodBeat.o(109447);
        return 0;
      case 2: 
        localamw.NkO = locala.ajGk.aar();
        AppMethodBeat.o(109447);
        return 0;
      case 3: 
        localamw.NkN = locala.ajGk.aar();
        AppMethodBeat.o(109447);
        return 0;
      case 4: 
        localamw.MD5 = locala.ajGk.readString();
        AppMethodBeat.o(109447);
        return 0;
      case 5: 
        localamw.ZtQ = locala.ajGk.aar();
        AppMethodBeat.o(109447);
        return 0;
      }
      localamw.Njv = locala.ajGk.aaw();
      AppMethodBeat.o(109447);
      return 0;
    }
    AppMethodBeat.o(109447);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amw
 * JD-Core Version:    0.7.0.1
 */