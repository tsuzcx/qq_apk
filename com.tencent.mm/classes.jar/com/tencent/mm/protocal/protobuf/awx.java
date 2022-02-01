package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awx
  extends com.tencent.mm.bw.a
{
  public int LHA;
  public int LHB;
  public LinkedList<axr> LHC;
  public int height;
  public long hyH;
  public int hyI;
  public int hyJ;
  public int hyK;
  public int hyL;
  public int hyM;
  public int hyN;
  public int hyO;
  public int hyP;
  public int hyQ;
  public int hyR;
  public int hyS;
  public int hyT;
  public int hyU;
  public int hyX;
  public int hyY;
  public int hyZ;
  public int hza;
  public int hzb;
  public String hzc;
  public int hzd;
  public float hze;
  public float hzf;
  public int width;
  
  public awx()
  {
    AppMethodBeat.i(209549);
    this.LHC = new LinkedList();
    AppMethodBeat.o(209549);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209550);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.hyH);
      paramVarArgs.aM(2, this.width);
      paramVarArgs.aM(3, this.height);
      paramVarArgs.aM(4, this.hyI);
      paramVarArgs.aM(5, this.hyJ);
      paramVarArgs.aM(6, this.hyK);
      paramVarArgs.aM(7, this.hyL);
      paramVarArgs.aM(8, this.hyM);
      paramVarArgs.aM(9, this.hyN);
      paramVarArgs.aM(10, this.hyO);
      paramVarArgs.aM(11, this.hyP);
      paramVarArgs.aM(12, this.hyQ);
      paramVarArgs.aM(13, this.hyR);
      paramVarArgs.aM(14, this.hyS);
      paramVarArgs.aM(15, this.hyT);
      paramVarArgs.aM(16, this.hyU);
      paramVarArgs.aM(17, this.LHA);
      paramVarArgs.aM(18, this.LHB);
      paramVarArgs.e(19, 8, this.LHC);
      paramVarArgs.aM(20, this.hyX);
      paramVarArgs.aM(21, this.hyY);
      paramVarArgs.aM(22, this.hyZ);
      paramVarArgs.aM(23, this.hza);
      paramVarArgs.aM(24, this.hzb);
      if (this.hzc != null) {
        paramVarArgs.e(25, this.hzc);
      }
      paramVarArgs.aM(26, this.hzd);
      paramVarArgs.E(27, this.hze);
      paramVarArgs.E(28, this.hzf);
      AppMethodBeat.o(209550);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.hyH) + 0 + g.a.a.b.b.a.bu(2, this.width) + g.a.a.b.b.a.bu(3, this.height) + g.a.a.b.b.a.bu(4, this.hyI) + g.a.a.b.b.a.bu(5, this.hyJ) + g.a.a.b.b.a.bu(6, this.hyK) + g.a.a.b.b.a.bu(7, this.hyL) + g.a.a.b.b.a.bu(8, this.hyM) + g.a.a.b.b.a.bu(9, this.hyN) + g.a.a.b.b.a.bu(10, this.hyO) + g.a.a.b.b.a.bu(11, this.hyP) + g.a.a.b.b.a.bu(12, this.hyQ) + g.a.a.b.b.a.bu(13, this.hyR) + g.a.a.b.b.a.bu(14, this.hyS) + g.a.a.b.b.a.bu(15, this.hyT) + g.a.a.b.b.a.bu(16, this.hyU) + g.a.a.b.b.a.bu(17, this.LHA) + g.a.a.b.b.a.bu(18, this.LHB) + g.a.a.a.c(19, 8, this.LHC) + g.a.a.b.b.a.bu(20, this.hyX) + g.a.a.b.b.a.bu(21, this.hyY) + g.a.a.b.b.a.bu(22, this.hyZ) + g.a.a.b.b.a.bu(23, this.hza) + g.a.a.b.b.a.bu(24, this.hzb);
      paramInt = i;
      if (this.hzc != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.hzc);
      }
      i = g.a.a.b.b.a.bu(26, this.hzd);
      int j = g.a.a.b.b.a.fS(27);
      int k = g.a.a.b.b.a.fS(28);
      AppMethodBeat.o(209550);
      return paramInt + i + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LHC.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209550);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      awx localawx = (awx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209550);
        return -1;
      case 1: 
        localawx.hyH = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209550);
        return 0;
      case 2: 
        localawx.width = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 3: 
        localawx.height = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 4: 
        localawx.hyI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 5: 
        localawx.hyJ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 6: 
        localawx.hyK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 7: 
        localawx.hyL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 8: 
        localawx.hyM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 9: 
        localawx.hyN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 10: 
        localawx.hyO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 11: 
        localawx.hyP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 12: 
        localawx.hyQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 13: 
        localawx.hyR = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 14: 
        localawx.hyS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 15: 
        localawx.hyT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 16: 
        localawx.hyU = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 17: 
        localawx.LHA = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 18: 
        localawx.LHB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new axr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((axr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localawx.LHC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209550);
        return 0;
      case 20: 
        localawx.hyX = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 21: 
        localawx.hyY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 22: 
        localawx.hyZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 23: 
        localawx.hza = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 24: 
        localawx.hzb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 25: 
        localawx.hzc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209550);
        return 0;
      case 26: 
        localawx.hzd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209550);
        return 0;
      case 27: 
        localawx.hze = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
        AppMethodBeat.o(209550);
        return 0;
      }
      localawx.hzf = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
      AppMethodBeat.o(209550);
      return 0;
    }
    AppMethodBeat.o(209550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awx
 * JD-Core Version:    0.7.0.1
 */