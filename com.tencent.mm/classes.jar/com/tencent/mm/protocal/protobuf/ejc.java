package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ejc
  extends com.tencent.mm.bw.a
{
  public int FZN;
  public boolean Imm;
  public String nickname;
  public String vvt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153328);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FZN);
      if (this.vvt != null) {
        paramVarArgs.d(2, this.vvt);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      paramVarArgs.bC(4, this.Imm);
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FZN) + 0;
      paramInt = i;
      if (this.vvt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vvt);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = f.a.a.b.b.a.amF(4);
      AppMethodBeat.o(153328);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ejc localejc = (ejc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153328);
        return -1;
      case 1: 
        localejc.FZN = locala.OmT.zc();
        AppMethodBeat.o(153328);
        return 0;
      case 2: 
        localejc.vvt = locala.OmT.readString();
        AppMethodBeat.o(153328);
        return 0;
      case 3: 
        localejc.nickname = locala.OmT.readString();
        AppMethodBeat.o(153328);
        return 0;
      }
      localejc.Imm = locala.OmT.gvY();
      AppMethodBeat.o(153328);
      return 0;
    }
    AppMethodBeat.o(153328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejc
 * JD-Core Version:    0.7.0.1
 */