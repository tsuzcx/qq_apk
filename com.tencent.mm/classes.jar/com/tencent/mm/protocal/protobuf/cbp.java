package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbp
  extends com.tencent.mm.bw.a
{
  public String ClU;
  public String ClV;
  public int ClW;
  public String id;
  public String pSm;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72499);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      if (this.ClU != null) {
        paramVarArgs.e(2, this.ClU);
      }
      if (this.ClV != null) {
        paramVarArgs.e(3, this.ClV);
      }
      if (this.pSm != null) {
        paramVarArgs.e(4, this.pSm);
      }
      paramVarArgs.bb(6, this.timestamp);
      paramVarArgs.aM(5, this.ClW);
      AppMethodBeat.o(72499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label486;
      }
    }
    label486:
    for (int i = g.a.a.b.b.a.f(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ClU != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.ClU);
      }
      i = paramInt;
      if (this.ClV != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ClV);
      }
      paramInt = i;
      if (this.pSm != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.pSm);
      }
      i = g.a.a.b.b.a.r(6, this.timestamp);
      int j = g.a.a.b.b.a.bu(5, this.ClW);
      AppMethodBeat.o(72499);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72499);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cbp localcbp = (cbp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72499);
          return -1;
        case 1: 
          localcbp.id = locala.UbS.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 2: 
          localcbp.ClU = locala.UbS.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 3: 
          localcbp.ClV = locala.UbS.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 4: 
          localcbp.pSm = locala.UbS.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 6: 
          localcbp.timestamp = locala.UbS.zl();
          AppMethodBeat.o(72499);
          return 0;
        }
        localcbp.ClW = locala.UbS.zi();
        AppMethodBeat.o(72499);
        return 0;
      }
      AppMethodBeat.o(72499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbp
 * JD-Core Version:    0.7.0.1
 */