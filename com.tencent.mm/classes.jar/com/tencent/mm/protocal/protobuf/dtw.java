package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtw
  extends com.tencent.mm.bx.a
{
  public int IIs;
  public String IMg;
  public String IMh;
  public int Njs;
  public long Njv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43113);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IMh != null) {
        paramVarArgs.g(1, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(2, this.IMg);
      }
      paramVarArgs.bS(3, this.Njs);
      paramVarArgs.bS(4, this.IIs);
      paramVarArgs.bv(5, this.Njv);
      AppMethodBeat.o(43113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IMh == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.b.b.a.h(1, this.IMh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IMg != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IMg);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.Njs);
      int j = i.a.a.b.b.a.cJ(4, this.IIs);
      int k = i.a.a.b.b.a.q(5, this.Njv);
      AppMethodBeat.o(43113);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(43113);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dtw localdtw = (dtw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43113);
          return -1;
        case 1: 
          localdtw.IMh = locala.ajGk.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 2: 
          localdtw.IMg = locala.ajGk.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 3: 
          localdtw.Njs = locala.ajGk.aar();
          AppMethodBeat.o(43113);
          return 0;
        case 4: 
          localdtw.IIs = locala.ajGk.aar();
          AppMethodBeat.o(43113);
          return 0;
        }
        localdtw.Njv = locala.ajGk.aaw();
        AppMethodBeat.o(43113);
        return 0;
      }
      AppMethodBeat.o(43113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtw
 * JD-Core Version:    0.7.0.1
 */