package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eim
  extends com.tencent.mm.bx.a
{
  public String HTb;
  public String HTc;
  public String duW;
  public int mtG;
  public int mvi;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      if (this.HTb != null) {
        paramVarArgs.d(3, this.HTb);
      }
      if (this.HTc != null) {
        paramVarArgs.d(4, this.HTc);
      }
      paramVarArgs.aS(5, this.mtG);
      paramVarArgs.aS(6, this.mvi);
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.duW);
      }
      i = paramInt;
      if (this.HTb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HTb);
      }
      paramInt = i;
      if (this.HTc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HTc);
      }
      i = f.a.a.b.b.a.bz(5, this.mtG);
      int j = f.a.a.b.b.a.bz(6, this.mvi);
      AppMethodBeat.o(123710);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eim localeim = (eim)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123710);
        return -1;
      case 1: 
        localeim.type = locala.NPN.zc();
        AppMethodBeat.o(123710);
        return 0;
      case 2: 
        localeim.duW = locala.NPN.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 3: 
        localeim.HTb = locala.NPN.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 4: 
        localeim.HTc = locala.NPN.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 5: 
        localeim.mtG = locala.NPN.zc();
        AppMethodBeat.o(123710);
        return 0;
      }
      localeim.mvi = locala.NPN.zc();
      AppMethodBeat.o(123710);
      return 0;
    }
    AppMethodBeat.o(123710);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eim
 * JD-Core Version:    0.7.0.1
 */