package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cib
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public int FileSize;
  public String KMl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104821);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KMl != null) {
        paramVarArgs.e(1, this.KMl);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(2, this.AesKey);
      }
      paramVarArgs.aM(3, this.FileSize);
      AppMethodBeat.o(104821);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KMl == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.KMl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.AesKey);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.FileSize);
      AppMethodBeat.o(104821);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104821);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cib localcib = (cib)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104821);
          return -1;
        case 1: 
          localcib.KMl = locala.UbS.readString();
          AppMethodBeat.o(104821);
          return 0;
        case 2: 
          localcib.AesKey = locala.UbS.readString();
          AppMethodBeat.o(104821);
          return 0;
        }
        localcib.FileSize = locala.UbS.zi();
        AppMethodBeat.o(104821);
        return 0;
      }
      AppMethodBeat.o(104821);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cib
 * JD-Core Version:    0.7.0.1
 */