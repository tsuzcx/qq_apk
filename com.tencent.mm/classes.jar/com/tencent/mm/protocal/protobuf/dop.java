package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dop
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String FAe;
  public int HCY;
  public int HCZ;
  public long tSu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HCY);
      if (this.FAe != null) {
        paramVarArgs.d(2, this.FAe);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(3, this.AesKey);
      }
      paramVarArgs.aS(4, this.HCZ);
      paramVarArgs.aY(5, this.tSu);
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HCY) + 0;
      paramInt = i;
      if (this.FAe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FAe);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.AesKey);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.HCZ);
      int j = f.a.a.b.b.a.p(5, this.tSu);
      AppMethodBeat.o(127506);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dop localdop = (dop)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127506);
        return -1;
      case 1: 
        localdop.HCY = locala.NPN.zc();
        AppMethodBeat.o(127506);
        return 0;
      case 2: 
        localdop.FAe = locala.NPN.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 3: 
        localdop.AesKey = locala.NPN.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 4: 
        localdop.HCZ = locala.NPN.zc();
        AppMethodBeat.o(127506);
        return 0;
      }
      localdop.tSu = locala.NPN.zd();
      AppMethodBeat.o(127506);
      return 0;
    }
    AppMethodBeat.o(127506);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dop
 * JD-Core Version:    0.7.0.1
 */