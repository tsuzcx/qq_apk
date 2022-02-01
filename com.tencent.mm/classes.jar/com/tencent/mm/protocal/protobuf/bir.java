package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bir
  extends com.tencent.mm.bw.a
{
  public long EXA;
  public long EXB;
  public int EXC;
  public String EXD;
  public String nickname;
  public String ugE;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91519);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.EXA);
      paramVarArgs.aO(2, this.EXB);
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.ugE != null) {
        paramVarArgs.d(4, this.ugE);
      }
      paramVarArgs.aR(5, this.EXC);
      if (this.username != null) {
        paramVarArgs.d(6, this.username);
      }
      if (this.EXD != null) {
        paramVarArgs.d(7, this.EXD);
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.EXA) + 0 + f.a.a.b.b.a.p(2, this.EXB);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nickname);
      }
      i = paramInt;
      if (this.ugE != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ugE);
      }
      i += f.a.a.b.b.a.bx(5, this.EXC);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.username);
      }
      i = paramInt;
      if (this.EXD != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EXD);
      }
      AppMethodBeat.o(91519);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91519);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bir localbir = (bir)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91519);
        return -1;
      case 1: 
        localbir.EXA = locala.LVo.xG();
        AppMethodBeat.o(91519);
        return 0;
      case 2: 
        localbir.EXB = locala.LVo.xG();
        AppMethodBeat.o(91519);
        return 0;
      case 3: 
        localbir.nickname = locala.LVo.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 4: 
        localbir.ugE = locala.LVo.readString();
        AppMethodBeat.o(91519);
        return 0;
      case 5: 
        localbir.EXC = locala.LVo.xF();
        AppMethodBeat.o(91519);
        return 0;
      case 6: 
        localbir.username = locala.LVo.readString();
        AppMethodBeat.o(91519);
        return 0;
      }
      localbir.EXD = locala.LVo.readString();
      AppMethodBeat.o(91519);
      return 0;
    }
    AppMethodBeat.o(91519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bir
 * JD-Core Version:    0.7.0.1
 */