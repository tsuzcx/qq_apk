package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebf
  extends com.tencent.mm.bw.a
{
  public String FbF;
  public int Fbw;
  public String GgQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123706);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FbF != null) {
        paramVarArgs.d(1, this.FbF);
      }
      paramVarArgs.aR(2, this.Fbw);
      if (this.GgQ != null) {
        paramVarArgs.d(3, this.GgQ);
      }
      AppMethodBeat.o(123706);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FbF == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.FbF) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Fbw);
      paramInt = i;
      if (this.GgQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GgQ);
      }
      AppMethodBeat.o(123706);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123706);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebf localebf = (ebf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123706);
          return -1;
        case 1: 
          localebf.FbF = locala.LVo.readString();
          AppMethodBeat.o(123706);
          return 0;
        case 2: 
          localebf.Fbw = locala.LVo.xF();
          AppMethodBeat.o(123706);
          return 0;
        }
        localebf.GgQ = locala.LVo.readString();
        AppMethodBeat.o(123706);
        return 0;
      }
      AppMethodBeat.o(123706);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebf
 * JD-Core Version:    0.7.0.1
 */