package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmy
  extends com.tencent.mm.bx.a
{
  public String dom;
  public int mEU;
  public String userName;
  public int zjD;
  public int zjE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115904);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mEU);
      paramVarArgs.aR(2, this.zjE);
      paramVarArgs.aR(3, this.zjD);
      if (this.userName != null) {
        paramVarArgs.d(4, this.userName);
      }
      if (this.dom != null) {
        paramVarArgs.d(5, this.dom);
      }
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.mEU) + 0 + f.a.a.b.b.a.bA(2, this.zjE) + f.a.a.b.b.a.bA(3, this.zjD);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.userName);
      }
      i = paramInt;
      if (this.dom != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dom);
      }
      AppMethodBeat.o(115904);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(115904);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dmy localdmy = (dmy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115904);
        return -1;
      case 1: 
        localdmy.mEU = locala.KhF.xS();
        AppMethodBeat.o(115904);
        return 0;
      case 2: 
        localdmy.zjE = locala.KhF.xS();
        AppMethodBeat.o(115904);
        return 0;
      case 3: 
        localdmy.zjD = locala.KhF.xS();
        AppMethodBeat.o(115904);
        return 0;
      case 4: 
        localdmy.userName = locala.KhF.readString();
        AppMethodBeat.o(115904);
        return 0;
      }
      localdmy.dom = locala.KhF.readString();
      AppMethodBeat.o(115904);
      return 0;
    }
    AppMethodBeat.o(115904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmy
 * JD-Core Version:    0.7.0.1
 */