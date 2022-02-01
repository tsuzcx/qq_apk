package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fv
  extends com.tencent.mm.cd.a
{
  public int RKS;
  public int RKT;
  public long RKU;
  public int RKV;
  public int RKW;
  public int RKX;
  public String RKY;
  public int RKZ;
  public int height;
  public String url;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103201);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      paramVarArgs.aY(2, this.RKS);
      paramVarArgs.aY(3, this.RKT);
      paramVarArgs.bm(4, this.RKU);
      paramVarArgs.aY(5, this.width);
      paramVarArgs.aY(6, this.height);
      paramVarArgs.aY(10, this.RKV);
      paramVarArgs.aY(11, this.RKW);
      paramVarArgs.aY(12, this.RKX);
      if (this.RKY != null) {
        paramVarArgs.f(13, this.RKY);
      }
      paramVarArgs.aY(15, this.RKZ);
      AppMethodBeat.o(103201);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = g.a.a.b.b.a.g(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RKS) + g.a.a.b.b.a.bM(3, this.RKT) + g.a.a.b.b.a.p(4, this.RKU) + g.a.a.b.b.a.bM(5, this.width) + g.a.a.b.b.a.bM(6, this.height) + g.a.a.b.b.a.bM(10, this.RKV) + g.a.a.b.b.a.bM(11, this.RKW) + g.a.a.b.b.a.bM(12, this.RKX);
      paramInt = i;
      if (this.RKY != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.RKY);
      }
      i = g.a.a.b.b.a.bM(15, this.RKZ);
      AppMethodBeat.o(103201);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(103201);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fv localfv = (fv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        case 8: 
        case 9: 
        case 14: 
        default: 
          AppMethodBeat.o(103201);
          return -1;
        case 1: 
          localfv.url = locala.abFh.readString();
          AppMethodBeat.o(103201);
          return 0;
        case 2: 
          localfv.RKS = locala.abFh.AK();
          AppMethodBeat.o(103201);
          return 0;
        case 3: 
          localfv.RKT = locala.abFh.AK();
          AppMethodBeat.o(103201);
          return 0;
        case 4: 
          localfv.RKU = locala.abFh.AN();
          AppMethodBeat.o(103201);
          return 0;
        case 5: 
          localfv.width = locala.abFh.AK();
          AppMethodBeat.o(103201);
          return 0;
        case 6: 
          localfv.height = locala.abFh.AK();
          AppMethodBeat.o(103201);
          return 0;
        case 10: 
          localfv.RKV = locala.abFh.AK();
          AppMethodBeat.o(103201);
          return 0;
        case 11: 
          localfv.RKW = locala.abFh.AK();
          AppMethodBeat.o(103201);
          return 0;
        case 12: 
          localfv.RKX = locala.abFh.AK();
          AppMethodBeat.o(103201);
          return 0;
        case 13: 
          localfv.RKY = locala.abFh.readString();
          AppMethodBeat.o(103201);
          return 0;
        }
        localfv.RKZ = locala.abFh.AK();
        AppMethodBeat.o(103201);
        return 0;
      }
      AppMethodBeat.o(103201);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fv
 * JD-Core Version:    0.7.0.1
 */