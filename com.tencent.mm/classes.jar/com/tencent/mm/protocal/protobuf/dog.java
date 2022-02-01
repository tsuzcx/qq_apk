package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dog
  extends com.tencent.mm.bx.a
{
  public long EEC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147801);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aG(1, this.EEC);
      AppMethodBeat.o(147801);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.EEC);
      AppMethodBeat.o(147801);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(147801);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dog localdog = (dog)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147801);
        return -1;
      }
      localdog.EEC = locala.KhF.xT();
      AppMethodBeat.o(147801);
      return 0;
    }
    AppMethodBeat.o(147801);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dog
 * JD-Core Version:    0.7.0.1
 */