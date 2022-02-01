package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmn
  extends com.tencent.mm.bx.a
{
  public long DVk;
  public String ZKq;
  public String ZVe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258975);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.DVk);
      if (this.ZKq != null) {
        paramVarArgs.g(2, this.ZKq);
      }
      if (this.ZVe != null) {
        paramVarArgs.g(3, this.ZVe);
      }
      AppMethodBeat.o(258975);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.DVk) + 0;
      paramInt = i;
      if (this.ZKq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZKq);
      }
      i = paramInt;
      if (this.ZVe != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZVe);
      }
      AppMethodBeat.o(258975);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258975);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bmn localbmn = (bmn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258975);
        return -1;
      case 1: 
        localbmn.DVk = locala.ajGk.aaw();
        AppMethodBeat.o(258975);
        return 0;
      case 2: 
        localbmn.ZKq = locala.ajGk.readString();
        AppMethodBeat.o(258975);
        return 0;
      }
      localbmn.ZVe = locala.ajGk.readString();
      AppMethodBeat.o(258975);
      return 0;
    }
    AppMethodBeat.o(258975);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmn
 * JD-Core Version:    0.7.0.1
 */