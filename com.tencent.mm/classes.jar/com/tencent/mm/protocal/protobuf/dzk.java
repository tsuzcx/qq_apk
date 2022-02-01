package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzk
  extends com.tencent.mm.bw.a
{
  public String GfE;
  public int GfF;
  public String Nickname;
  public String tia;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124574);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GfE != null) {
        paramVarArgs.d(1, this.GfE);
      }
      if (this.tia != null) {
        paramVarArgs.d(2, this.tia);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(3, this.Nickname);
      }
      paramVarArgs.aR(4, this.GfF);
      AppMethodBeat.o(124574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GfE == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.GfE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tia != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tia);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Nickname);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.GfF);
      AppMethodBeat.o(124574);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124574);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzk localdzk = (dzk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124574);
          return -1;
        case 1: 
          localdzk.GfE = locala.LVo.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 2: 
          localdzk.tia = locala.LVo.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 3: 
          localdzk.Nickname = locala.LVo.readString();
          AppMethodBeat.o(124574);
          return 0;
        }
        localdzk.GfF = locala.LVo.xF();
        AppMethodBeat.o(124574);
        return 0;
      }
      AppMethodBeat.o(124574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzk
 * JD-Core Version:    0.7.0.1
 */