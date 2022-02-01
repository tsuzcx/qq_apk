package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awm
  extends com.tencent.mm.bx.a
{
  public boolean ZHh;
  public boolean ZHi;
  public boolean ZHj;
  public boolean ZHk;
  public boolean ZHl;
  public boolean ZHm;
  public boolean ZHn;
  public boolean ZHo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260072);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.ZHh);
      paramVarArgs.di(2, this.ZHi);
      paramVarArgs.di(3, this.ZHj);
      paramVarArgs.di(4, this.ZHk);
      paramVarArgs.di(5, this.ZHl);
      paramVarArgs.di(6, this.ZHm);
      paramVarArgs.di(7, this.ZHn);
      paramVarArgs.di(8, this.ZHo);
      AppMethodBeat.o(260072);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      int n = i.a.a.b.b.a.ko(6);
      int i1 = i.a.a.b.b.a.ko(7);
      int i2 = i.a.a.b.b.a.ko(8);
      AppMethodBeat.o(260072);
      return paramInt + 1 + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260072);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      awm localawm = (awm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260072);
        return -1;
      case 1: 
        localawm.ZHh = locala.ajGk.aai();
        AppMethodBeat.o(260072);
        return 0;
      case 2: 
        localawm.ZHi = locala.ajGk.aai();
        AppMethodBeat.o(260072);
        return 0;
      case 3: 
        localawm.ZHj = locala.ajGk.aai();
        AppMethodBeat.o(260072);
        return 0;
      case 4: 
        localawm.ZHk = locala.ajGk.aai();
        AppMethodBeat.o(260072);
        return 0;
      case 5: 
        localawm.ZHl = locala.ajGk.aai();
        AppMethodBeat.o(260072);
        return 0;
      case 6: 
        localawm.ZHm = locala.ajGk.aai();
        AppMethodBeat.o(260072);
        return 0;
      case 7: 
        localawm.ZHn = locala.ajGk.aai();
        AppMethodBeat.o(260072);
        return 0;
      }
      localawm.ZHo = locala.ajGk.aai();
      AppMethodBeat.o(260072);
      return 0;
    }
    AppMethodBeat.o(260072);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awm
 * JD-Core Version:    0.7.0.1
 */