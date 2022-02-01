package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpj
  extends com.tencent.mm.bw.a
{
  public String nYC;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104816);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nYC != null) {
        paramVarArgs.d(1, this.nYC);
      }
      if (this.session_id != null) {
        paramVarArgs.d(2, this.session_id);
      }
      AppMethodBeat.o(104816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nYC == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.nYC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.session_id != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.session_id);
      }
      AppMethodBeat.o(104816);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104816);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpj localbpj = (bpj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104816);
          return -1;
        case 1: 
          localbpj.nYC = locala.LVo.readString();
          AppMethodBeat.o(104816);
          return 0;
        }
        localbpj.session_id = locala.LVo.readString();
        AppMethodBeat.o(104816);
        return 0;
      }
      AppMethodBeat.o(104816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpj
 * JD-Core Version:    0.7.0.1
 */