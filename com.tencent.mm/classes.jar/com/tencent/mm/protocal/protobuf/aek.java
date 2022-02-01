package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aek
  extends com.tencent.mm.bx.a
{
  public String DeA;
  public String DeB;
  public int Dey;
  public String Dez;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32199);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dey);
      if (this.Dez != null) {
        paramVarArgs.d(2, this.Dez);
      }
      if (this.DeA != null) {
        paramVarArgs.d(3, this.DeA);
      }
      if (this.DeB != null) {
        paramVarArgs.d(4, this.DeB);
      }
      AppMethodBeat.o(32199);
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
      if (this.DeA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DeA);
      }
      paramInt = i;
      if (this.DeB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DeB);
      }
      AppMethodBeat.o(32199);
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
      AppMethodBeat.o(32199);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aek localaek = (aek)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32199);
        return -1;
      case 1: 
        localaek.Dey = locala.KhF.xS();
        AppMethodBeat.o(32199);
        return 0;
      case 2: 
        localaek.Dez = locala.KhF.readString();
        AppMethodBeat.o(32199);
        return 0;
      case 3: 
        localaek.DeA = locala.KhF.readString();
        AppMethodBeat.o(32199);
        return 0;
      }
      localaek.DeB = locala.KhF.readString();
      AppMethodBeat.o(32199);
      return 0;
    }
    AppMethodBeat.o(32199);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aek
 * JD-Core Version:    0.7.0.1
 */