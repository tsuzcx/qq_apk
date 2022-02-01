package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xx
  extends com.tencent.mm.bw.a
{
  public String LiU;
  public String LiV;
  public String LiW;
  public int LiX;
  public int LiY;
  public String LiZ;
  public int Lja;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127444);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LiU != null) {
        paramVarArgs.e(1, this.LiU);
      }
      if (this.LiV != null) {
        paramVarArgs.e(2, this.LiV);
      }
      if (this.LiW != null) {
        paramVarArgs.e(3, this.LiW);
      }
      paramVarArgs.aM(4, this.LiX);
      paramVarArgs.aM(5, this.LiY);
      if (this.LiZ != null) {
        paramVarArgs.e(6, this.LiZ);
      }
      paramVarArgs.aM(7, this.Lja);
      AppMethodBeat.o(127444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LiU == null) {
        break label530;
      }
    }
    label530:
    for (int i = g.a.a.b.b.a.f(1, this.LiU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LiV != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LiV);
      }
      i = paramInt;
      if (this.LiW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LiW);
      }
      i = i + g.a.a.b.b.a.bu(4, this.LiX) + g.a.a.b.b.a.bu(5, this.LiY);
      paramInt = i;
      if (this.LiZ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LiZ);
      }
      i = g.a.a.b.b.a.bu(7, this.Lja);
      AppMethodBeat.o(127444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127444);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        xx localxx = (xx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127444);
          return -1;
        case 1: 
          localxx.LiU = locala.UbS.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 2: 
          localxx.LiV = locala.UbS.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 3: 
          localxx.LiW = locala.UbS.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 4: 
          localxx.LiX = locala.UbS.zi();
          AppMethodBeat.o(127444);
          return 0;
        case 5: 
          localxx.LiY = locala.UbS.zi();
          AppMethodBeat.o(127444);
          return 0;
        case 6: 
          localxx.LiZ = locala.UbS.readString();
          AppMethodBeat.o(127444);
          return 0;
        }
        localxx.Lja = locala.UbS.zi();
        AppMethodBeat.o(127444);
        return 0;
      }
      AppMethodBeat.o(127444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xx
 * JD-Core Version:    0.7.0.1
 */