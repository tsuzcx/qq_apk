package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aud
  extends com.tencent.mm.bx.a
{
  public boolean Gsm;
  public boolean Gsn;
  public boolean Gso;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.Gsm);
      paramVarArgs.bt(2, this.Gsn);
      paramVarArgs.bt(3, this.Gso);
      AppMethodBeat.o(116470);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alV(1);
      int i = f.a.a.b.b.a.alV(2);
      int j = f.a.a.b.b.a.alV(3);
      AppMethodBeat.o(116470);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(116470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aud localaud = (aud)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116470);
        return -1;
      case 1: 
        localaud.Gsm = locala.NPN.grw();
        AppMethodBeat.o(116470);
        return 0;
      case 2: 
        localaud.Gsn = locala.NPN.grw();
        AppMethodBeat.o(116470);
        return 0;
      }
      localaud.Gso = locala.NPN.grw();
      AppMethodBeat.o(116470);
      return 0;
    }
    AppMethodBeat.o(116470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aud
 * JD-Core Version:    0.7.0.1
 */