package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alw
  extends com.tencent.mm.bx.a
{
  public String data;
  public String zzS;
  public long zzT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257775);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.zzS != null) {
        paramVarArgs.g(1, this.zzS);
      }
      paramVarArgs.bv(2, this.zzT);
      if (this.data != null) {
        paramVarArgs.g(3, this.data);
      }
      AppMethodBeat.o(257775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zzS == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.zzS) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.zzT);
      paramInt = i;
      if (this.data != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.data);
      }
      AppMethodBeat.o(257775);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257775);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        alw localalw = (alw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257775);
          return -1;
        case 1: 
          localalw.zzS = locala.ajGk.readString();
          AppMethodBeat.o(257775);
          return 0;
        case 2: 
          localalw.zzT = locala.ajGk.aaw();
          AppMethodBeat.o(257775);
          return 0;
        }
        localalw.data = locala.ajGk.readString();
        AppMethodBeat.o(257775);
        return 0;
      }
      AppMethodBeat.o(257775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alw
 * JD-Core Version:    0.7.0.1
 */