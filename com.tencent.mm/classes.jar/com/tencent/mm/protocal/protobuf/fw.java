package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fw
  extends com.tencent.mm.bw.a
{
  public int FQE;
  public String gvv;
  public String gvz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gvv != null) {
        paramVarArgs.d(1, this.gvv);
      }
      paramVarArgs.aS(2, this.FQE);
      if (this.gvz != null) {
        paramVarArgs.d(3, this.gvz);
      }
      AppMethodBeat.o(152494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gvv == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.gvv) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FQE);
      paramInt = i;
      if (this.gvz != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.gvz);
      }
      AppMethodBeat.o(152494);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152494);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fw localfw = (fw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152494);
          return -1;
        case 1: 
          localfw.gvv = locala.OmT.readString();
          AppMethodBeat.o(152494);
          return 0;
        case 2: 
          localfw.FQE = locala.OmT.zc();
          AppMethodBeat.o(152494);
          return 0;
        }
        localfw.gvz = locala.OmT.readString();
        AppMethodBeat.o(152494);
        return 0;
      }
      AppMethodBeat.o(152494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fw
 * JD-Core Version:    0.7.0.1
 */