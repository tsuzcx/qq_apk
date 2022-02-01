package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sa
  extends com.tencent.mm.bw.a
{
  public int DPJ;
  public String Eld;
  public long Ele;
  public int Elf;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eld != null) {
        paramVarArgs.d(1, this.Eld);
      }
      paramVarArgs.aO(2, this.Ele);
      paramVarArgs.aR(3, this.Elf);
      paramVarArgs.aR(4, this.DPJ);
      paramVarArgs.aR(5, this.ndj);
      AppMethodBeat.o(93332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eld == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.e(1, this.Eld) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.Ele);
      int j = f.a.a.b.b.a.bx(3, this.Elf);
      int k = f.a.a.b.b.a.bx(4, this.DPJ);
      int m = f.a.a.b.b.a.bx(5, this.ndj);
      AppMethodBeat.o(93332);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(93332);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        sa localsa = (sa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(93332);
          return -1;
        case 1: 
          localsa.Eld = locala.LVo.readString();
          AppMethodBeat.o(93332);
          return 0;
        case 2: 
          localsa.Ele = locala.LVo.xG();
          AppMethodBeat.o(93332);
          return 0;
        case 3: 
          localsa.Elf = locala.LVo.xF();
          AppMethodBeat.o(93332);
          return 0;
        case 4: 
          localsa.DPJ = locala.LVo.xF();
          AppMethodBeat.o(93332);
          return 0;
        }
        localsa.ndj = locala.LVo.xF();
        AppMethodBeat.o(93332);
        return 0;
      }
      AppMethodBeat.o(93332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sa
 * JD-Core Version:    0.7.0.1
 */