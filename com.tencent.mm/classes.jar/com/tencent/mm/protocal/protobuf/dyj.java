package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyj
  extends com.tencent.mm.bx.a
{
  public int Cbm;
  public int Cbn;
  public String dxJ;
  public int nHv;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115904);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nHv);
      paramVarArgs.aS(2, this.Cbn);
      paramVarArgs.aS(3, this.Cbm);
      if (this.userName != null) {
        paramVarArgs.d(4, this.userName);
      }
      if (this.dxJ != null) {
        paramVarArgs.d(5, this.dxJ);
      }
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nHv) + 0 + f.a.a.b.b.a.bz(2, this.Cbn) + f.a.a.b.b.a.bz(3, this.Cbm);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.userName);
      }
      i = paramInt;
      if (this.dxJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dxJ);
      }
      AppMethodBeat.o(115904);
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
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dyj localdyj = (dyj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115904);
        return -1;
      case 1: 
        localdyj.nHv = locala.NPN.zc();
        AppMethodBeat.o(115904);
        return 0;
      case 2: 
        localdyj.Cbn = locala.NPN.zc();
        AppMethodBeat.o(115904);
        return 0;
      case 3: 
        localdyj.Cbm = locala.NPN.zc();
        AppMethodBeat.o(115904);
        return 0;
      case 4: 
        localdyj.userName = locala.NPN.readString();
        AppMethodBeat.o(115904);
        return 0;
      }
      localdyj.dxJ = locala.NPN.readString();
      AppMethodBeat.o(115904);
      return 0;
    }
    AppMethodBeat.o(115904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyj
 * JD-Core Version:    0.7.0.1
 */