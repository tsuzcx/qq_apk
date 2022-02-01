package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dln
  extends com.tencent.mm.bx.a
{
  public String FVn;
  public int GaO;
  public int HgN;
  public String nDo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32460);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.FVn != null) {
        paramVarArgs.d(2, this.FVn);
      }
      paramVarArgs.aS(3, this.HgN);
      paramVarArgs.aS(4, this.GaO);
      AppMethodBeat.o(32460);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FVn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FVn);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HgN);
      int j = f.a.a.b.b.a.bz(4, this.GaO);
      AppMethodBeat.o(32460);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32460);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dln localdln = (dln)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32460);
          return -1;
        case 1: 
          localdln.nDo = locala.NPN.readString();
          AppMethodBeat.o(32460);
          return 0;
        case 2: 
          localdln.FVn = locala.NPN.readString();
          AppMethodBeat.o(32460);
          return 0;
        case 3: 
          localdln.HgN = locala.NPN.zc();
          AppMethodBeat.o(32460);
          return 0;
        }
        localdln.GaO = locala.NPN.zc();
        AppMethodBeat.o(32460);
        return 0;
      }
      AppMethodBeat.o(32460);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dln
 * JD-Core Version:    0.7.0.1
 */