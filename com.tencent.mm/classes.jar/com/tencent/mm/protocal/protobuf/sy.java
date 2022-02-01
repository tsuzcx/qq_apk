package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sy
  extends com.tencent.mm.bw.a
{
  public int EdN;
  public String Enf;
  public String dvO;
  public int nUv;
  public String nYx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113981);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvO != null) {
        paramVarArgs.d(1, this.dvO);
      }
      if (this.nYx != null) {
        paramVarArgs.d(2, this.nYx);
      }
      paramVarArgs.aR(3, this.nUv);
      paramVarArgs.aR(4, this.EdN);
      if (this.Enf != null) {
        paramVarArgs.d(5, this.Enf);
      }
      AppMethodBeat.o(113981);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvO == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.dvO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nYx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nYx);
      }
      i = i + f.a.a.b.b.a.bx(3, this.nUv) + f.a.a.b.b.a.bx(4, this.EdN);
      paramInt = i;
      if (this.Enf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Enf);
      }
      AppMethodBeat.o(113981);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113981);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        sy localsy = (sy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113981);
          return -1;
        case 1: 
          localsy.dvO = locala.LVo.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 2: 
          localsy.nYx = locala.LVo.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 3: 
          localsy.nUv = locala.LVo.xF();
          AppMethodBeat.o(113981);
          return 0;
        case 4: 
          localsy.EdN = locala.LVo.xF();
          AppMethodBeat.o(113981);
          return 0;
        }
        localsy.Enf = locala.LVo.readString();
        AppMethodBeat.o(113981);
        return 0;
      }
      AppMethodBeat.o(113981);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sy
 * JD-Core Version:    0.7.0.1
 */