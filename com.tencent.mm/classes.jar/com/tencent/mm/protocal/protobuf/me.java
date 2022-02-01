package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class me
  extends com.tencent.mm.bx.a
{
  public long YNt = 0L;
  public long YNu = 0L;
  public long YNv = 0L;
  public long YNw = 0L;
  public int YNx;
  public int hMx;
  public int oeO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110886);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YNt);
      paramVarArgs.bv(2, this.YNu);
      paramVarArgs.bv(3, this.YNv);
      paramVarArgs.bv(4, this.YNw);
      paramVarArgs.bS(5, this.oeO);
      paramVarArgs.bS(6, this.hMx);
      paramVarArgs.bS(7, this.YNx);
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.YNt);
      int i = i.a.a.b.b.a.q(2, this.YNu);
      int j = i.a.a.b.b.a.q(3, this.YNv);
      int k = i.a.a.b.b.a.q(4, this.YNw);
      int m = i.a.a.b.b.a.cJ(5, this.oeO);
      int n = i.a.a.b.b.a.cJ(6, this.hMx);
      int i1 = i.a.a.b.b.a.cJ(7, this.YNx);
      AppMethodBeat.o(110886);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      me localme = (me)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110886);
        return -1;
      case 1: 
        localme.YNt = locala.ajGk.aaw();
        AppMethodBeat.o(110886);
        return 0;
      case 2: 
        localme.YNu = locala.ajGk.aaw();
        AppMethodBeat.o(110886);
        return 0;
      case 3: 
        localme.YNv = locala.ajGk.aaw();
        AppMethodBeat.o(110886);
        return 0;
      case 4: 
        localme.YNw = locala.ajGk.aaw();
        AppMethodBeat.o(110886);
        return 0;
      case 5: 
        localme.oeO = locala.ajGk.aar();
        AppMethodBeat.o(110886);
        return 0;
      case 6: 
        localme.hMx = locala.ajGk.aar();
        AppMethodBeat.o(110886);
        return 0;
      }
      localme.YNx = locala.ajGk.aar();
      AppMethodBeat.o(110886);
      return 0;
    }
    AppMethodBeat.o(110886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.me
 * JD-Core Version:    0.7.0.1
 */