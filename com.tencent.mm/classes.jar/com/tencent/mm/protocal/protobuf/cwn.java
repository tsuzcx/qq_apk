package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwn
  extends com.tencent.mm.bw.a
{
  public String HHq;
  public int HHr;
  public int HHs;
  public int gxu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91673);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HHq != null) {
        paramVarArgs.d(1, this.HHq);
      }
      paramVarArgs.aS(2, this.gxu);
      paramVarArgs.aS(3, this.HHr);
      paramVarArgs.aS(4, this.HHs);
      AppMethodBeat.o(91673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HHq == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.HHq) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.gxu);
      int j = f.a.a.b.b.a.bz(3, this.HHr);
      int k = f.a.a.b.b.a.bz(4, this.HHs);
      AppMethodBeat.o(91673);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91673);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cwn localcwn = (cwn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91673);
          return -1;
        case 1: 
          localcwn.HHq = locala.OmT.readString();
          AppMethodBeat.o(91673);
          return 0;
        case 2: 
          localcwn.gxu = locala.OmT.zc();
          AppMethodBeat.o(91673);
          return 0;
        case 3: 
          localcwn.HHr = locala.OmT.zc();
          AppMethodBeat.o(91673);
          return 0;
        }
        localcwn.HHs = locala.OmT.zc();
        AppMethodBeat.o(91673);
        return 0;
      }
      AppMethodBeat.o(91673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwn
 * JD-Core Version:    0.7.0.1
 */