package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bbq
  extends com.tencent.mm.cd.a
{
  public int SNs;
  public int SNt;
  public LinkedList<bdi> SNu;
  public float SNv;
  public float SNw;
  public b SNx;
  public int height;
  public long klE;
  public int klF;
  public int klG;
  public int klH;
  public int klI;
  public int klJ;
  public int klK;
  public int klL;
  public int klM;
  public int klN;
  public int klO;
  public int klP;
  public int klQ;
  public int klR;
  public int klU;
  public int klV;
  public int klW;
  public int klX;
  public int klY;
  public String klZ;
  public int kma;
  public float kmb;
  public float kmc;
  public int width;
  
  public bbq()
  {
    AppMethodBeat.i(197826);
    this.SNu = new LinkedList();
    AppMethodBeat.o(197826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197879);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.klE);
      paramVarArgs.aY(2, this.width);
      paramVarArgs.aY(3, this.height);
      paramVarArgs.aY(4, this.klF);
      paramVarArgs.aY(5, this.klG);
      paramVarArgs.aY(6, this.klH);
      paramVarArgs.aY(7, this.klI);
      paramVarArgs.aY(8, this.klJ);
      paramVarArgs.aY(9, this.klK);
      paramVarArgs.aY(10, this.klL);
      paramVarArgs.aY(11, this.klM);
      paramVarArgs.aY(12, this.klN);
      paramVarArgs.aY(13, this.klO);
      paramVarArgs.aY(14, this.klP);
      paramVarArgs.aY(15, this.klQ);
      paramVarArgs.aY(16, this.klR);
      paramVarArgs.aY(17, this.SNs);
      paramVarArgs.aY(18, this.SNt);
      paramVarArgs.e(19, 8, this.SNu);
      paramVarArgs.aY(20, this.klU);
      paramVarArgs.aY(21, this.klV);
      paramVarArgs.aY(22, this.klW);
      paramVarArgs.aY(23, this.klX);
      paramVarArgs.aY(24, this.klY);
      if (this.klZ != null) {
        paramVarArgs.f(25, this.klZ);
      }
      paramVarArgs.aY(26, this.kma);
      paramVarArgs.i(27, this.kmb);
      paramVarArgs.i(28, this.kmc);
      paramVarArgs.i(29, this.SNv);
      paramVarArgs.i(30, this.SNw);
      if (this.SNx != null) {
        paramVarArgs.c(31, this.SNx);
      }
      AppMethodBeat.o(197879);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.klE) + 0 + g.a.a.b.b.a.bM(2, this.width) + g.a.a.b.b.a.bM(3, this.height) + g.a.a.b.b.a.bM(4, this.klF) + g.a.a.b.b.a.bM(5, this.klG) + g.a.a.b.b.a.bM(6, this.klH) + g.a.a.b.b.a.bM(7, this.klI) + g.a.a.b.b.a.bM(8, this.klJ) + g.a.a.b.b.a.bM(9, this.klK) + g.a.a.b.b.a.bM(10, this.klL) + g.a.a.b.b.a.bM(11, this.klM) + g.a.a.b.b.a.bM(12, this.klN) + g.a.a.b.b.a.bM(13, this.klO) + g.a.a.b.b.a.bM(14, this.klP) + g.a.a.b.b.a.bM(15, this.klQ) + g.a.a.b.b.a.bM(16, this.klR) + g.a.a.b.b.a.bM(17, this.SNs) + g.a.a.b.b.a.bM(18, this.SNt) + g.a.a.a.c(19, 8, this.SNu) + g.a.a.b.b.a.bM(20, this.klU) + g.a.a.b.b.a.bM(21, this.klV) + g.a.a.b.b.a.bM(22, this.klW) + g.a.a.b.b.a.bM(23, this.klX) + g.a.a.b.b.a.bM(24, this.klY);
      paramInt = i;
      if (this.klZ != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.klZ);
      }
      i = paramInt + g.a.a.b.b.a.bM(26, this.kma) + (g.a.a.b.b.a.gL(27) + 4) + (g.a.a.b.b.a.gL(28) + 4) + (g.a.a.b.b.a.gL(29) + 4) + (g.a.a.b.b.a.gL(30) + 4);
      paramInt = i;
      if (this.SNx != null) {
        paramInt = i + g.a.a.b.b.a.b(31, this.SNx);
      }
      AppMethodBeat.o(197879);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SNu.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(197879);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bbq localbbq = (bbq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(197879);
        return -1;
      case 1: 
        localbbq.klE = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(197879);
        return 0;
      case 2: 
        localbbq.width = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 3: 
        localbbq.height = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 4: 
        localbbq.klF = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 5: 
        localbbq.klG = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 6: 
        localbbq.klH = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 7: 
        localbbq.klI = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 8: 
        localbbq.klJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 9: 
        localbbq.klK = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 10: 
        localbbq.klL = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 11: 
        localbbq.klM = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 12: 
        localbbq.klN = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 13: 
        localbbq.klO = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 14: 
        localbbq.klP = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 15: 
        localbbq.klQ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 16: 
        localbbq.klR = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 17: 
        localbbq.SNs = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 18: 
        localbbq.SNt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bdi localbdi = new bdi();
          if ((localObject != null) && (localObject.length > 0)) {
            localbdi.parseFrom((byte[])localObject);
          }
          localbbq.SNu.add(localbdi);
          paramInt += 1;
        }
        AppMethodBeat.o(197879);
        return 0;
      case 20: 
        localbbq.klU = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 21: 
        localbbq.klV = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 22: 
        localbbq.klW = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 23: 
        localbbq.klX = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 24: 
        localbbq.klY = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 25: 
        localbbq.klZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(197879);
        return 0;
      case 26: 
        localbbq.kma = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197879);
        return 0;
      case 27: 
        localbbq.kmb = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
        AppMethodBeat.o(197879);
        return 0;
      case 28: 
        localbbq.kmc = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
        AppMethodBeat.o(197879);
        return 0;
      case 29: 
        localbbq.SNv = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
        AppMethodBeat.o(197879);
        return 0;
      case 30: 
        localbbq.SNw = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
        AppMethodBeat.o(197879);
        return 0;
      }
      localbbq.SNx = ((g.a.a.a.a)localObject).abFh.iUw();
      AppMethodBeat.o(197879);
      return 0;
    }
    AppMethodBeat.o(197879);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbq
 * JD-Core Version:    0.7.0.1
 */