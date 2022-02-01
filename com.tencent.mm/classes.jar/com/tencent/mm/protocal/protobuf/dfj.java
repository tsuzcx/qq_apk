package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfj
  extends com.tencent.mm.bx.a
{
  public int GOe;
  public String Gup;
  public String HtR;
  public int HtS;
  public int HtT;
  public String nDo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125773);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HtR != null) {
        paramVarArgs.d(1, this.HtR);
      }
      paramVarArgs.aS(2, this.HtS);
      if (this.nDo != null) {
        paramVarArgs.d(3, this.nDo);
      }
      if (this.Gup != null) {
        paramVarArgs.d(4, this.Gup);
      }
      paramVarArgs.aS(5, this.GOe);
      paramVarArgs.aS(6, this.HtT);
      AppMethodBeat.o(125773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HtR == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.e(1, this.HtR) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HtS);
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nDo);
      }
      i = paramInt;
      if (this.Gup != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Gup);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.GOe);
      int j = f.a.a.b.b.a.bz(6, this.HtT);
      AppMethodBeat.o(125773);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125773);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dfj localdfj = (dfj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125773);
          return -1;
        case 1: 
          localdfj.HtR = locala.NPN.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 2: 
          localdfj.HtS = locala.NPN.zc();
          AppMethodBeat.o(125773);
          return 0;
        case 3: 
          localdfj.nDo = locala.NPN.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 4: 
          localdfj.Gup = locala.NPN.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 5: 
          localdfj.GOe = locala.NPN.zc();
          AppMethodBeat.o(125773);
          return 0;
        }
        localdfj.HtT = locala.NPN.zc();
        AppMethodBeat.o(125773);
        return 0;
      }
      AppMethodBeat.o(125773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfj
 * JD-Core Version:    0.7.0.1
 */