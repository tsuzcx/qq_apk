package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aux
  extends com.tencent.mm.bw.a
{
  public String FNF;
  public String GLO;
  public String GLV;
  public int GbY;
  public String gvv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42637);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gvv == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.GLV == null)
      {
        paramVarArgs = new b("Not all required fields were included: RecommendKey");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.gvv != null) {
        paramVarArgs.d(1, this.gvv);
      }
      if (this.GLV != null) {
        paramVarArgs.d(2, this.GLV);
      }
      if (this.FNF != null) {
        paramVarArgs.d(3, this.FNF);
      }
      paramVarArgs.aS(4, this.GbY);
      if (this.GLO != null) {
        paramVarArgs.d(5, this.GLO);
      }
      AppMethodBeat.o(42637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gvv == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.b.b.a.e(1, this.gvv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GLV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GLV);
      }
      i = paramInt;
      if (this.FNF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FNF);
      }
      i += f.a.a.b.b.a.bz(4, this.GbY);
      paramInt = i;
      if (this.GLO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GLO);
      }
      AppMethodBeat.o(42637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.gvv == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        if (this.GLV == null)
        {
          paramVarArgs = new b("Not all required fields were included: RecommendKey");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42637);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aux localaux = (aux)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42637);
          return -1;
        case 1: 
          localaux.gvv = locala.OmT.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 2: 
          localaux.GLV = locala.OmT.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 3: 
          localaux.FNF = locala.OmT.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 4: 
          localaux.GbY = locala.OmT.zc();
          AppMethodBeat.o(42637);
          return 0;
        }
        localaux.GLO = locala.OmT.readString();
        AppMethodBeat.o(42637);
        return 0;
      }
      AppMethodBeat.o(42637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aux
 * JD-Core Version:    0.7.0.1
 */