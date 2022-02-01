package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aef
  extends com.tencent.mm.bx.a
{
  public int Deq;
  public int Der;
  public int Des;
  public String Det;
  public int Deu;
  public String Dev;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122488);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Deq);
      paramVarArgs.aR(2, this.Der);
      paramVarArgs.aR(3, this.Des);
      if (this.Det != null) {
        paramVarArgs.d(4, this.Det);
      }
      paramVarArgs.aR(5, this.Deu);
      if (this.Dev != null) {
        paramVarArgs.d(6, this.Dev);
      }
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Deq) + 0 + f.a.a.b.b.a.bA(2, this.Der) + f.a.a.b.b.a.bA(3, this.Des);
      paramInt = i;
      if (this.Det != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Det);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.Deu);
      paramInt = i;
      if (this.Dev != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dev);
      }
      AppMethodBeat.o(122488);
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
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aef localaef = (aef)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122488);
        return -1;
      case 1: 
        localaef.Deq = locala.KhF.xS();
        AppMethodBeat.o(122488);
        return 0;
      case 2: 
        localaef.Der = locala.KhF.xS();
        AppMethodBeat.o(122488);
        return 0;
      case 3: 
        localaef.Des = locala.KhF.xS();
        AppMethodBeat.o(122488);
        return 0;
      case 4: 
        localaef.Det = locala.KhF.readString();
        AppMethodBeat.o(122488);
        return 0;
      case 5: 
        localaef.Deu = locala.KhF.xS();
        AppMethodBeat.o(122488);
        return 0;
      }
      localaef.Dev = locala.KhF.readString();
      AppMethodBeat.o(122488);
      return 0;
    }
    AppMethodBeat.o(122488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aef
 * JD-Core Version:    0.7.0.1
 */