package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czk
  extends com.tencent.mm.bw.a
{
  public String HJf;
  public int HJg;
  public String dAs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152686);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HJf != null) {
        paramVarArgs.d(1, this.HJf);
      }
      if (this.dAs != null) {
        paramVarArgs.d(2, this.dAs);
      }
      paramVarArgs.aS(3, this.HJg);
      AppMethodBeat.o(152686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HJf == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.HJf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dAs != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dAs);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HJg);
      AppMethodBeat.o(152686);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152686);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        czk localczk = (czk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152686);
          return -1;
        case 1: 
          localczk.HJf = locala.OmT.readString();
          AppMethodBeat.o(152686);
          return 0;
        case 2: 
          localczk.dAs = locala.OmT.readString();
          AppMethodBeat.o(152686);
          return 0;
        }
        localczk.HJg = locala.OmT.zc();
        AppMethodBeat.o(152686);
        return 0;
      }
      AppMethodBeat.o(152686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czk
 * JD-Core Version:    0.7.0.1
 */