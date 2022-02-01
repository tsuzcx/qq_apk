package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crv
  extends com.tencent.mm.cd.a
{
  public String CqZ;
  public String TyO;
  public String TyP;
  public int TyQ;
  public int TyR;
  public long TyS;
  public long TyT;
  public LinkedList<vj> TyU;
  public int TyV;
  public LinkedList<String> TyW;
  public String TyX;
  public int TyY;
  public int TyZ;
  public int Tza;
  public int Tzb;
  public int Tzc;
  public int Tzd;
  public int Tze;
  public int Tzf;
  public String Tzg;
  public int Tzh;
  public int Tzi;
  
  public crv()
  {
    AppMethodBeat.i(253393);
    this.TyU = new LinkedList();
    this.TyW = new LinkedList();
    AppMethodBeat.o(253393);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(253404);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TyO != null) {
        paramVarArgs.f(1, this.TyO);
      }
      if (this.TyP != null) {
        paramVarArgs.f(2, this.TyP);
      }
      paramVarArgs.aY(3, this.TyQ);
      paramVarArgs.aY(4, this.TyR);
      paramVarArgs.bm(5, this.TyS);
      paramVarArgs.bm(6, this.TyT);
      paramVarArgs.e(7, 8, this.TyU);
      paramVarArgs.aY(8, this.TyV);
      paramVarArgs.e(9, 1, this.TyW);
      if (this.TyX != null) {
        paramVarArgs.f(10, this.TyX);
      }
      paramVarArgs.aY(11, this.TyY);
      paramVarArgs.aY(12, this.TyZ);
      paramVarArgs.aY(13, this.Tza);
      paramVarArgs.aY(14, this.Tzb);
      paramVarArgs.aY(15, this.Tzc);
      paramVarArgs.aY(16, this.Tzd);
      paramVarArgs.aY(17, this.Tze);
      paramVarArgs.aY(18, this.Tzf);
      if (this.CqZ != null) {
        paramVarArgs.f(19, this.CqZ);
      }
      if (this.Tzg != null) {
        paramVarArgs.f(20, this.Tzg);
      }
      paramVarArgs.aY(21, this.Tzh);
      paramVarArgs.aY(22, this.Tzi);
      AppMethodBeat.o(253404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TyO == null) {
        break label1304;
      }
    }
    label1304:
    for (paramInt = g.a.a.b.b.a.g(1, this.TyO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TyP != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TyP);
      }
      i = i + g.a.a.b.b.a.bM(3, this.TyQ) + g.a.a.b.b.a.bM(4, this.TyR) + g.a.a.b.b.a.p(5, this.TyS) + g.a.a.b.b.a.p(6, this.TyT) + g.a.a.a.c(7, 8, this.TyU) + g.a.a.b.b.a.bM(8, this.TyV) + g.a.a.a.c(9, 1, this.TyW);
      paramInt = i;
      if (this.TyX != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.TyX);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.TyY) + g.a.a.b.b.a.bM(12, this.TyZ) + g.a.a.b.b.a.bM(13, this.Tza) + g.a.a.b.b.a.bM(14, this.Tzb) + g.a.a.b.b.a.bM(15, this.Tzc) + g.a.a.b.b.a.bM(16, this.Tzd) + g.a.a.b.b.a.bM(17, this.Tze) + g.a.a.b.b.a.bM(18, this.Tzf);
      paramInt = i;
      if (this.CqZ != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.CqZ);
      }
      i = paramInt;
      if (this.Tzg != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.Tzg);
      }
      paramInt = g.a.a.b.b.a.bM(21, this.Tzh);
      int j = g.a.a.b.b.a.bM(22, this.Tzi);
      AppMethodBeat.o(253404);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TyU.clear();
        this.TyW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(253404);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        crv localcrv = (crv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(253404);
          return -1;
        case 1: 
          localcrv.TyO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(253404);
          return 0;
        case 2: 
          localcrv.TyP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(253404);
          return 0;
        case 3: 
          localcrv.TyQ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        case 4: 
          localcrv.TyR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        case 5: 
          localcrv.TyS = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(253404);
          return 0;
        case 6: 
          localcrv.TyT = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(253404);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            vj localvj = new vj();
            if ((localObject != null) && (localObject.length > 0)) {
              localvj.parseFrom((byte[])localObject);
            }
            localcrv.TyU.add(localvj);
            paramInt += 1;
          }
          AppMethodBeat.o(253404);
          return 0;
        case 8: 
          localcrv.TyV = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        case 9: 
          localcrv.TyW.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(253404);
          return 0;
        case 10: 
          localcrv.TyX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(253404);
          return 0;
        case 11: 
          localcrv.TyY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        case 12: 
          localcrv.TyZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        case 13: 
          localcrv.Tza = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        case 14: 
          localcrv.Tzb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        case 15: 
          localcrv.Tzc = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        case 16: 
          localcrv.Tzd = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        case 17: 
          localcrv.Tze = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        case 18: 
          localcrv.Tzf = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        case 19: 
          localcrv.CqZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(253404);
          return 0;
        case 20: 
          localcrv.Tzg = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(253404);
          return 0;
        case 21: 
          localcrv.Tzh = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(253404);
          return 0;
        }
        localcrv.Tzi = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(253404);
        return 0;
      }
      AppMethodBeat.o(253404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crv
 * JD-Core Version:    0.7.0.1
 */