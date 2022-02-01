package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bns
  extends com.tencent.mm.bw.a
{
  public String HaC;
  public String HaD;
  public String dEM;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72495);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HaC != null) {
        paramVarArgs.d(1, this.HaC);
      }
      if (this.HaD != null) {
        paramVarArgs.d(2, this.HaD);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.dEM != null) {
        paramVarArgs.d(4, this.dEM);
      }
      AppMethodBeat.o(72495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HaC == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.HaC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HaD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HaD);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.dEM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dEM);
      }
      AppMethodBeat.o(72495);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72495);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bns localbns = (bns)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72495);
          return -1;
        case 1: 
          localbns.HaC = locala.OmT.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 2: 
          localbns.HaD = locala.OmT.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 3: 
          localbns.url = locala.OmT.readString();
          AppMethodBeat.o(72495);
          return 0;
        }
        localbns.dEM = locala.OmT.readString();
        AppMethodBeat.o(72495);
        return 0;
      }
      AppMethodBeat.o(72495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bns
 * JD-Core Version:    0.7.0.1
 */