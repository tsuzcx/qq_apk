package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efm
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b FQS;
  public int GaC;
  public String HGP;
  public boolean Ijp;
  public boolean Ijq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGP == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32564);
        throw paramVarArgs;
      }
      if (this.HGP != null) {
        paramVarArgs.d(1, this.HGP);
      }
      paramVarArgs.aS(2, this.GaC);
      if (this.FQS != null) {
        paramVarArgs.c(3, this.FQS);
      }
      paramVarArgs.bC(4, this.Ijp);
      paramVarArgs.bC(5, this.Ijq);
      AppMethodBeat.o(32564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HGP == null) {
        break label461;
      }
    }
    label461:
    for (paramInt = f.a.a.b.b.a.e(1, this.HGP) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GaC);
      paramInt = i;
      if (this.FQS != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.FQS);
      }
      i = f.a.a.b.b.a.amF(4);
      int j = f.a.a.b.b.a.amF(5);
      AppMethodBeat.o(32564);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HGP == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32564);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32564);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        efm localefm = (efm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32564);
          return -1;
        case 1: 
          localefm.HGP = locala.OmT.readString();
          AppMethodBeat.o(32564);
          return 0;
        case 2: 
          localefm.GaC = locala.OmT.zc();
          AppMethodBeat.o(32564);
          return 0;
        case 3: 
          localefm.FQS = locala.OmT.gCk();
          AppMethodBeat.o(32564);
          return 0;
        case 4: 
          localefm.Ijp = locala.OmT.gvY();
          AppMethodBeat.o(32564);
          return 0;
        }
        localefm.Ijq = locala.OmT.gvY();
        AppMethodBeat.o(32564);
        return 0;
      }
      AppMethodBeat.o(32564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efm
 * JD-Core Version:    0.7.0.1
 */