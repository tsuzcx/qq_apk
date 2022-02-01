package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z
  extends com.tencent.mm.bx.a
{
  public int Fqw;
  public String kzK;
  public String kzL;
  public String vqB;
  public String vqC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91339);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Fqw);
      if (this.vqB != null) {
        paramVarArgs.d(2, this.vqB);
      }
      if (this.kzK != null) {
        paramVarArgs.d(3, this.kzK);
      }
      if (this.kzL != null) {
        paramVarArgs.d(4, this.kzL);
      }
      if (this.vqC != null) {
        paramVarArgs.d(5, this.vqC);
      }
      AppMethodBeat.o(91339);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Fqw) + 0;
      paramInt = i;
      if (this.vqB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vqB);
      }
      i = paramInt;
      if (this.kzK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.kzK);
      }
      paramInt = i;
      if (this.kzL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.kzL);
      }
      i = paramInt;
      if (this.vqC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.vqC);
      }
      AppMethodBeat.o(91339);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91339);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      z localz = (z)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91339);
        return -1;
      case 1: 
        localz.Fqw = locala.NPN.zc();
        AppMethodBeat.o(91339);
        return 0;
      case 2: 
        localz.vqB = locala.NPN.readString();
        AppMethodBeat.o(91339);
        return 0;
      case 3: 
        localz.kzK = locala.NPN.readString();
        AppMethodBeat.o(91339);
        return 0;
      case 4: 
        localz.kzL = locala.NPN.readString();
        AppMethodBeat.o(91339);
        return 0;
      }
      localz.vqC = locala.NPN.readString();
      AppMethodBeat.o(91339);
      return 0;
    }
    AppMethodBeat.o(91339);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.z
 * JD-Core Version:    0.7.0.1
 */