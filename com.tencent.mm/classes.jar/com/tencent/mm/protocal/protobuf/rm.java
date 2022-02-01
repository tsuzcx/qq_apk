package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rm
  extends com.tencent.mm.bw.a
{
  public String AZE;
  public String AZF;
  public int BGS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.AZE != null) {
        paramVarArgs.d(1, this.AZE);
      }
      if (this.AZF != null) {
        paramVarArgs.d(2, this.AZF);
      }
      paramVarArgs.aR(3, this.BGS);
      AppMethodBeat.o(113965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AZE == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.AZE) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.AZF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.AZF);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.BGS);
      AppMethodBeat.o(113965);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113965);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rm localrm = (rm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113965);
          return -1;
        case 1: 
          localrm.AZE = locala.LVo.readString();
          AppMethodBeat.o(113965);
          return 0;
        case 2: 
          localrm.AZF = locala.LVo.readString();
          AppMethodBeat.o(113965);
          return 0;
        }
        localrm.BGS = locala.LVo.xF();
        AppMethodBeat.o(113965);
        return 0;
      }
      AppMethodBeat.o(113965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rm
 * JD-Core Version:    0.7.0.1
 */