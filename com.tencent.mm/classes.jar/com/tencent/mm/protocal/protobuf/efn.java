package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class efn
  extends com.tencent.mm.bw.a
{
  public int FJl;
  public String FZl;
  public String HGP;
  public boolean Ijr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32565);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32565);
        throw paramVarArgs;
      }
      if (this.FZl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32565);
        throw paramVarArgs;
      }
      if (this.HGP != null) {
        paramVarArgs.d(1, this.HGP);
      }
      if (this.FZl != null) {
        paramVarArgs.d(2, this.FZl);
      }
      paramVarArgs.bC(3, this.Ijr);
      paramVarArgs.aS(4, this.FJl);
      AppMethodBeat.o(32565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HGP == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = f.a.a.b.b.a.e(1, this.HGP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FZl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FZl);
      }
      paramInt = f.a.a.b.b.a.amF(3);
      int j = f.a.a.b.b.a.bz(4, this.FJl);
      AppMethodBeat.o(32565);
      return i + paramInt + j;
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
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32565);
          throw paramVarArgs;
        }
        if (this.FZl == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32565);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        efn localefn = (efn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32565);
          return -1;
        case 1: 
          localefn.HGP = locala.OmT.readString();
          AppMethodBeat.o(32565);
          return 0;
        case 2: 
          localefn.FZl = locala.OmT.readString();
          AppMethodBeat.o(32565);
          return 0;
        case 3: 
          localefn.Ijr = locala.OmT.gvY();
          AppMethodBeat.o(32565);
          return 0;
        }
        localefn.FJl = locala.OmT.zc();
        AppMethodBeat.o(32565);
        return 0;
      }
      AppMethodBeat.o(32565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efn
 * JD-Core Version:    0.7.0.1
 */