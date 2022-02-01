package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dgp
  extends com.tencent.mm.bx.a
{
  public String aaBg;
  public String aaLE;
  public boolean aaLF;
  public String aaLG;
  public int aamK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123623);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aamK);
      if (this.aaLE != null) {
        paramVarArgs.g(2, this.aaLE);
      }
      paramVarArgs.di(3, this.aaLF);
      if (this.aaLG != null) {
        paramVarArgs.g(4, this.aaLG);
      }
      if (this.aaBg != null) {
        paramVarArgs.g(5, this.aaBg);
      }
      AppMethodBeat.o(123623);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aamK) + 0;
      paramInt = i;
      if (this.aaLE != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaLE);
      }
      i = paramInt + (i.a.a.b.b.a.ko(3) + 1);
      paramInt = i;
      if (this.aaLG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaLG);
      }
      i = paramInt;
      if (this.aaBg != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaBg);
      }
      AppMethodBeat.o(123623);
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
      AppMethodBeat.o(123623);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dgp localdgp = (dgp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123623);
        return -1;
      case 1: 
        localdgp.aamK = locala.ajGk.aar();
        AppMethodBeat.o(123623);
        return 0;
      case 2: 
        localdgp.aaLE = locala.ajGk.readString();
        AppMethodBeat.o(123623);
        return 0;
      case 3: 
        localdgp.aaLF = locala.ajGk.aai();
        AppMethodBeat.o(123623);
        return 0;
      case 4: 
        localdgp.aaLG = locala.ajGk.readString();
        AppMethodBeat.o(123623);
        return 0;
      }
      localdgp.aaBg = locala.ajGk.readString();
      AppMethodBeat.o(123623);
      return 0;
    }
    AppMethodBeat.o(123623);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgp
 * JD-Core Version:    0.7.0.1
 */