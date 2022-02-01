package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dxa
  extends com.tencent.mm.bx.a
{
  public int EKV;
  public int EKW;
  public int EKX;
  public int score;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32570);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(32570);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aR(2, this.score);
      paramVarArgs.aR(3, this.EKV);
      paramVarArgs.aR(4, this.EKW);
      paramVarArgs.aR(5, this.EKX);
      AppMethodBeat.o(32570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label457;
      }
    }
    label457:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.score);
      int j = f.a.a.b.b.a.bA(3, this.EKV);
      int k = f.a.a.b.b.a.bA(4, this.EKW);
      int m = f.a.a.b.b.a.bA(5, this.EKX);
      AppMethodBeat.o(32570);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(32570);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32570);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxa localdxa = (dxa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32570);
          return -1;
        case 1: 
          localdxa.username = locala.KhF.readString();
          AppMethodBeat.o(32570);
          return 0;
        case 2: 
          localdxa.score = locala.KhF.xS();
          AppMethodBeat.o(32570);
          return 0;
        case 3: 
          localdxa.EKV = locala.KhF.xS();
          AppMethodBeat.o(32570);
          return 0;
        case 4: 
          localdxa.EKW = locala.KhF.xS();
          AppMethodBeat.o(32570);
          return 0;
        }
        localdxa.EKX = locala.KhF.xS();
        AppMethodBeat.o(32570);
        return 0;
      }
      AppMethodBeat.o(32570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxa
 * JD-Core Version:    0.7.0.1
 */