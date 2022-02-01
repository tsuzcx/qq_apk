package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tg
  extends com.tencent.mm.bw.a
{
  public String LbP;
  public int LbQ;
  public String LbR;
  public String abi;
  public String kxx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116466);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LbP != null) {
        paramVarArgs.e(1, this.LbP);
      }
      paramVarArgs.aM(2, this.LbQ);
      if (this.abi != null) {
        paramVarArgs.e(3, this.abi);
      }
      if (this.kxx != null) {
        paramVarArgs.e(4, this.kxx);
      }
      if (this.LbR != null) {
        paramVarArgs.e(5, this.LbR);
      }
      AppMethodBeat.o(116466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LbP == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.f(1, this.LbP) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LbQ);
      paramInt = i;
      if (this.abi != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.abi);
      }
      i = paramInt;
      if (this.kxx != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.kxx);
      }
      paramInt = i;
      if (this.LbR != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LbR);
      }
      AppMethodBeat.o(116466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116466);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        tg localtg = (tg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116466);
          return -1;
        case 1: 
          localtg.LbP = locala.UbS.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 2: 
          localtg.LbQ = locala.UbS.zi();
          AppMethodBeat.o(116466);
          return 0;
        case 3: 
          localtg.abi = locala.UbS.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 4: 
          localtg.kxx = locala.UbS.readString();
          AppMethodBeat.o(116466);
          return 0;
        }
        localtg.LbR = locala.UbS.readString();
        AppMethodBeat.o(116466);
        return 0;
      }
      AppMethodBeat.o(116466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tg
 * JD-Core Version:    0.7.0.1
 */