package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gmj
  extends com.tencent.mm.bx.a
{
  public int achx;
  public boolean achy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260262);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.achx);
      paramVarArgs.di(2, this.achy);
      AppMethodBeat.o(260262);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.achx);
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(260262);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260262);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gmj localgmj = (gmj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260262);
        return -1;
      case 1: 
        localgmj.achx = locala.ajGk.aar();
        AppMethodBeat.o(260262);
        return 0;
      }
      localgmj.achy = locala.ajGk.aai();
      AppMethodBeat.o(260262);
      return 0;
    }
    AppMethodBeat.o(260262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmj
 * JD-Core Version:    0.7.0.1
 */