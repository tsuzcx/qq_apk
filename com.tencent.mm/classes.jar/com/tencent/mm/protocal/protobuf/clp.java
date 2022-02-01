package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clp
  extends com.tencent.mm.bx.a
{
  public int HeQ;
  public int HeR;
  public String HeS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125754);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HeQ);
      paramVarArgs.aS(2, this.HeR);
      if (this.HeS != null) {
        paramVarArgs.d(3, this.HeS);
      }
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HeQ) + 0 + f.a.a.b.b.a.bz(2, this.HeR);
      paramInt = i;
      if (this.HeS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HeS);
      }
      AppMethodBeat.o(125754);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      clp localclp = (clp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125754);
        return -1;
      case 1: 
        localclp.HeQ = locala.NPN.zc();
        AppMethodBeat.o(125754);
        return 0;
      case 2: 
        localclp.HeR = locala.NPN.zc();
        AppMethodBeat.o(125754);
        return 0;
      }
      localclp.HeS = locala.NPN.readString();
      AppMethodBeat.o(125754);
      return 0;
    }
    AppMethodBeat.o(125754);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clp
 * JD-Core Version:    0.7.0.1
 */