package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bez
  extends com.tencent.mm.bx.a
{
  public long DCe;
  public long DCf;
  public int DCg;
  public String DCh;
  public String nickname;
  public String sYq;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91519);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.DCe);
      paramVarArgs.aG(2, this.DCf);
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.sYq != null) {
        paramVarArgs.d(4, this.sYq);
      }
      paramVarArgs.aR(5, this.DCg);
      if (this.username != null) {
        paramVarArgs.d(6, this.username);
      }
      if (this.DCh != null) {
        paramVarArgs.d(7, this.DCh);
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.DCe) + 0 + f.a.a.b.b.a.q(2, this.DCf);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nickname);
      }
      i = paramInt;
      if (this.sYq != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sYq);
      }
      i += f.a.a.b.b.a.bA(5, this.DCg);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.username);
      }
      i = paramInt;
      if (this.DCh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DCh);
      }
      AppMethodBeat.o(91519);
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
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bez localbez = (bez)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91519);
        return -1;
      case 1: 
        localbez.DCe = locala.KhF.xT();
        AppMethodBeat.o(91519);
        return 0;
      case 2: 
        localbez.DCf = locala.KhF.xT();
        AppMethodBeat.o(91519);
        return 0;
      case 3: 
        localbez.nickname = locala.KhF.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 4: 
        localbez.sYq = locala.KhF.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 5: 
        localbez.DCg = locala.KhF.xS();
        AppMethodBeat.o(91519);
        return 0;
      case 6: 
        localbez.username = locala.KhF.readString();
        AppMethodBeat.o(91519);
        return 0;
      }
      localbez.DCh = locala.KhF.readString();
      AppMethodBeat.o(91519);
      return 0;
    }
    AppMethodBeat.o(91519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bez
 * JD-Core Version:    0.7.0.1
 */