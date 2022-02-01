package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class go
  extends com.tencent.mm.bx.a
{
  public String Url;
  public long YIl;
  public int nUA;
  public String nUv;
  public int nUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124391);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nUv != null) {
        paramVarArgs.g(1, this.nUv);
      }
      if (this.Url != null) {
        paramVarArgs.g(2, this.Url);
      }
      paramVarArgs.bS(3, this.nUz);
      paramVarArgs.bS(4, this.nUA);
      paramVarArgs.bv(5, this.YIl);
      AppMethodBeat.o(124391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nUv == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.b.b.a.h(1, this.nUv) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Url != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Url);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.nUz);
      int j = i.a.a.b.b.a.cJ(4, this.nUA);
      int k = i.a.a.b.b.a.q(5, this.YIl);
      AppMethodBeat.o(124391);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124391);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        go localgo = (go)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124391);
          return -1;
        case 1: 
          localgo.nUv = locala.ajGk.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 2: 
          localgo.Url = locala.ajGk.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 3: 
          localgo.nUz = locala.ajGk.aar();
          AppMethodBeat.o(124391);
          return 0;
        case 4: 
          localgo.nUA = locala.ajGk.aar();
          AppMethodBeat.o(124391);
          return 0;
        }
        localgo.YIl = locala.ajGk.aaw();
        AppMethodBeat.o(124391);
        return 0;
      }
      AppMethodBeat.o(124391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.go
 * JD-Core Version:    0.7.0.1
 */