package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxc
  extends com.tencent.mm.bx.a
{
  public int GQZ;
  public int GRa;
  public int GRb;
  public int GRc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169923);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GQZ);
      paramVarArgs.aS(2, this.GRa);
      paramVarArgs.aS(3, this.GRb);
      paramVarArgs.aS(4, this.GRc);
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GQZ);
      int i = f.a.a.b.b.a.bz(2, this.GRa);
      int j = f.a.a.b.b.a.bz(3, this.GRb);
      int k = f.a.a.b.b.a.bz(4, this.GRc);
      AppMethodBeat.o(169923);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxc localbxc = (bxc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169923);
        return -1;
      case 1: 
        localbxc.GQZ = locala.NPN.zc();
        AppMethodBeat.o(169923);
        return 0;
      case 2: 
        localbxc.GRa = locala.NPN.zc();
        AppMethodBeat.o(169923);
        return 0;
      case 3: 
        localbxc.GRb = locala.NPN.zc();
        AppMethodBeat.o(169923);
        return 0;
      }
      localbxc.GRc = locala.NPN.zc();
      AppMethodBeat.o(169923);
      return 0;
    }
    AppMethodBeat.o(169923);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxc
 * JD-Core Version:    0.7.0.1
 */