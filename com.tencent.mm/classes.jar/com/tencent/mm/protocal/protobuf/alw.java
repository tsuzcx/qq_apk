package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alw
  extends com.tencent.mm.bw.a
{
  public int EFo;
  public int EFp;
  public String drn;
  public String rvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184203);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.drn != null) {
        paramVarArgs.d(1, this.drn);
      }
      paramVarArgs.aR(2, this.EFo);
      paramVarArgs.aR(3, this.EFp);
      if (this.rvP != null) {
        paramVarArgs.d(4, this.rvP);
      }
      AppMethodBeat.o(184203);
      return 0;
    }
    if (paramInt == 1) {
      if (this.drn == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.drn) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EFo) + f.a.a.b.b.a.bx(3, this.EFp);
      paramInt = i;
      if (this.rvP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rvP);
      }
      AppMethodBeat.o(184203);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(184203);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        alw localalw = (alw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184203);
          return -1;
        case 1: 
          localalw.drn = locala.LVo.readString();
          AppMethodBeat.o(184203);
          return 0;
        case 2: 
          localalw.EFo = locala.LVo.xF();
          AppMethodBeat.o(184203);
          return 0;
        case 3: 
          localalw.EFp = locala.LVo.xF();
          AppMethodBeat.o(184203);
          return 0;
        }
        localalw.rvP = locala.LVo.readString();
        AppMethodBeat.o(184203);
        return 0;
      }
      AppMethodBeat.o(184203);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alw
 * JD-Core Version:    0.7.0.1
 */