package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dvy
  extends com.tencent.mm.bx.a
{
  public b Dbv;
  public String dlB;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50124);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.Dbv != null) {
        paramVarArgs.c(2, this.Dbv);
      }
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      AppMethodBeat.o(50124);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.Dbv != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Dbv);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlB);
      }
      AppMethodBeat.o(50124);
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
      AppMethodBeat.o(50124);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dvy localdvy = (dvy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50124);
        return -1;
      case 1: 
        localdvy.type = locala.KhF.xS();
        AppMethodBeat.o(50124);
        return 0;
      case 2: 
        localdvy.Dbv = locala.KhF.fMu();
        AppMethodBeat.o(50124);
        return 0;
      }
      localdvy.dlB = locala.KhF.readString();
      AppMethodBeat.o(50124);
      return 0;
    }
    AppMethodBeat.o(50124);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvy
 * JD-Core Version:    0.7.0.1
 */