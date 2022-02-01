package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csm
  extends com.tencent.mm.bx.a
{
  public int Hfa;
  public String HkR;
  public String HkS;
  public int HkT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91667);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hfa);
      if (this.HkR != null) {
        paramVarArgs.d(2, this.HkR);
      }
      if (this.HkS != null) {
        paramVarArgs.d(3, this.HkS);
      }
      paramVarArgs.aS(4, this.HkT);
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Hfa) + 0;
      paramInt = i;
      if (this.HkR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HkR);
      }
      i = paramInt;
      if (this.HkS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HkS);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.HkT);
      AppMethodBeat.o(91667);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      csm localcsm = (csm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91667);
        return -1;
      case 1: 
        localcsm.Hfa = locala.NPN.zc();
        AppMethodBeat.o(91667);
        return 0;
      case 2: 
        localcsm.HkR = locala.NPN.readString();
        AppMethodBeat.o(91667);
        return 0;
      case 3: 
        localcsm.HkS = locala.NPN.readString();
        AppMethodBeat.o(91667);
        return 0;
      }
      localcsm.HkT = locala.NPN.zc();
      AppMethodBeat.o(91667);
      return 0;
    }
    AppMethodBeat.o(91667);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csm
 * JD-Core Version:    0.7.0.1
 */