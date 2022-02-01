package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sd
  extends com.tencent.mm.bw.a
{
  public String FUt;
  public String Ghm;
  public int Ghn;
  public String Gho;
  public String abi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ghm != null) {
        paramVarArgs.d(1, this.Ghm);
      }
      paramVarArgs.aS(2, this.Ghn);
      if (this.abi != null) {
        paramVarArgs.d(3, this.abi);
      }
      if (this.FUt != null) {
        paramVarArgs.d(4, this.FUt);
      }
      if (this.Gho != null) {
        paramVarArgs.d(5, this.Gho);
      }
      AppMethodBeat.o(116466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ghm == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ghm) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Ghn);
      paramInt = i;
      if (this.abi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.abi);
      }
      i = paramInt;
      if (this.FUt != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FUt);
      }
      paramInt = i;
      if (this.Gho != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gho);
      }
      AppMethodBeat.o(116466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116466);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        sd localsd = (sd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116466);
          return -1;
        case 1: 
          localsd.Ghm = locala.OmT.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 2: 
          localsd.Ghn = locala.OmT.zc();
          AppMethodBeat.o(116466);
          return 0;
        case 3: 
          localsd.abi = locala.OmT.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 4: 
          localsd.FUt = locala.OmT.readString();
          AppMethodBeat.o(116466);
          return 0;
        }
        localsd.Gho = locala.OmT.readString();
        AppMethodBeat.o(116466);
        return 0;
      }
      AppMethodBeat.o(116466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sd
 * JD-Core Version:    0.7.0.1
 */