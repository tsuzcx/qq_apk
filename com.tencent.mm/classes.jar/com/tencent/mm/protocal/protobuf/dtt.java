package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtt
  extends com.tencent.mm.bx.a
{
  public String EIs;
  public int EIt;
  public String Nickname;
  public String sah;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124574);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EIs != null) {
        paramVarArgs.d(1, this.EIs);
      }
      if (this.sah != null) {
        paramVarArgs.d(2, this.sah);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(3, this.Nickname);
      }
      paramVarArgs.aR(4, this.EIt);
      AppMethodBeat.o(124574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EIs == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.EIs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sah != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sah);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Nickname);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.EIt);
      AppMethodBeat.o(124574);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124574);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dtt localdtt = (dtt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124574);
          return -1;
        case 1: 
          localdtt.EIs = locala.KhF.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 2: 
          localdtt.sah = locala.KhF.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 3: 
          localdtt.Nickname = locala.KhF.readString();
          AppMethodBeat.o(124574);
          return 0;
        }
        localdtt.EIt = locala.KhF.xS();
        AppMethodBeat.o(124574);
        return 0;
      }
      AppMethodBeat.o(124574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtt
 * JD-Core Version:    0.7.0.1
 */