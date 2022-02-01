package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dy
  extends com.tencent.mm.bx.a
{
  public int Crn;
  public boolean vJT;
  public boolean vJU;
  public boolean vJx;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50078);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Crn);
      if (this.value != null) {
        paramVarArgs.d(2, this.value);
      }
      paramVarArgs.bg(3, this.vJT);
      paramVarArgs.bg(4, this.vJx);
      paramVarArgs.bg(5, this.vJU);
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Crn) + 0;
      paramInt = i;
      if (this.value != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.value);
      }
      i = f.a.a.b.b.a.fY(3);
      int j = f.a.a.b.b.a.fY(4);
      int k = f.a.a.b.b.a.fY(5);
      AppMethodBeat.o(50078);
      return paramInt + (i + 1) + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dy localdy = (dy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50078);
        return -1;
      case 1: 
        localdy.Crn = locala.KhF.xS();
        AppMethodBeat.o(50078);
        return 0;
      case 2: 
        localdy.value = locala.KhF.readString();
        AppMethodBeat.o(50078);
        return 0;
      case 3: 
        localdy.vJT = locala.KhF.fHu();
        AppMethodBeat.o(50078);
        return 0;
      case 4: 
        localdy.vJx = locala.KhF.fHu();
        AppMethodBeat.o(50078);
        return 0;
      }
      localdy.vJU = locala.KhF.fHu();
      AppMethodBeat.o(50078);
      return 0;
    }
    AppMethodBeat.o(50078);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dy
 * JD-Core Version:    0.7.0.1
 */