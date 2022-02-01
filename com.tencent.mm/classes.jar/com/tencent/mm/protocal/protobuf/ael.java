package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ael
  extends com.tencent.mm.bx.a
{
  public String DeA;
  public String DeB;
  public int Dey;
  public String Dez;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32200);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dey);
      if (this.Dez != null) {
        paramVarArgs.d(2, this.Dez);
      }
      if (this.DeB != null) {
        paramVarArgs.d(3, this.DeB);
      }
      if (this.DeA != null) {
        paramVarArgs.d(4, this.DeA);
      }
      AppMethodBeat.o(32200);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Dey) + 0;
      paramInt = i;
      if (this.Dez != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dez);
      }
      i = paramInt;
      if (this.DeB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DeB);
      }
      paramInt = i;
      if (this.DeA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DeA);
      }
      AppMethodBeat.o(32200);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32200);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ael localael = (ael)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32200);
        return -1;
      case 1: 
        localael.Dey = locala.KhF.xS();
        AppMethodBeat.o(32200);
        return 0;
      case 2: 
        localael.Dez = locala.KhF.readString();
        AppMethodBeat.o(32200);
        return 0;
      case 3: 
        localael.DeB = locala.KhF.readString();
        AppMethodBeat.o(32200);
        return 0;
      }
      localael.DeA = locala.KhF.readString();
      AppMethodBeat.o(32200);
      return 0;
    }
    AppMethodBeat.o(32200);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ael
 * JD-Core Version:    0.7.0.1
 */