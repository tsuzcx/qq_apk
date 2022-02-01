package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class auv
  extends dyy
{
  public LinkedList<bbd> LIS;
  public bau SEJ;
  public LinkedList<FinderContact> SGP;
  public int SGR;
  public int SGS;
  public int SGT;
  public int SGU;
  public int SGV;
  public int SGW;
  public bbl SGX;
  public int SGY;
  public LinkedList<axe> SGZ;
  public LinkedList<bdb> SHa;
  public ayl SHb;
  public int SHc;
  public long SHd;
  public LinkedList<ayl> SHe;
  public bac liveInfo;
  public b xak;
  
  public auv()
  {
    AppMethodBeat.i(230730);
    this.SGP = new LinkedList();
    this.LIS = new LinkedList();
    this.SGZ = new LinkedList();
    this.SHa = new LinkedList();
    this.SHe = new LinkedList();
    AppMethodBeat.o(230730);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230736);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SGP);
      paramVarArgs.e(3, 8, this.LIS);
      if (this.liveInfo != null)
      {
        paramVarArgs.oE(4, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      if (this.xak != null) {
        paramVarArgs.c(5, this.xak);
      }
      paramVarArgs.aY(6, this.SGR);
      paramVarArgs.aY(7, this.SGS);
      paramVarArgs.aY(8, this.SGT);
      if (this.SEJ != null)
      {
        paramVarArgs.oE(9, this.SEJ.computeSize());
        this.SEJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.SGU);
      paramVarArgs.aY(11, this.SGV);
      paramVarArgs.aY(12, this.SGW);
      if (this.SGX != null)
      {
        paramVarArgs.oE(13, this.SGX.computeSize());
        this.SGX.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.SGY);
      paramVarArgs.e(15, 8, this.SGZ);
      paramVarArgs.e(16, 8, this.SHa);
      if (this.SHb != null)
      {
        paramVarArgs.oE(17, this.SHb.computeSize());
        this.SHb.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(18, this.SHc);
      paramVarArgs.bm(19, this.SHd);
      paramVarArgs.e(20, 8, this.SHe);
      AppMethodBeat.o(230736);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1878;
      }
    }
    label1878:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SGP) + g.a.a.a.c(3, 8, this.LIS);
      paramInt = i;
      if (this.liveInfo != null) {
        paramInt = i + g.a.a.a.oD(4, this.liveInfo.computeSize());
      }
      i = paramInt;
      if (this.xak != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.xak);
      }
      i = i + g.a.a.b.b.a.bM(6, this.SGR) + g.a.a.b.b.a.bM(7, this.SGS) + g.a.a.b.b.a.bM(8, this.SGT);
      paramInt = i;
      if (this.SEJ != null) {
        paramInt = i + g.a.a.a.oD(9, this.SEJ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.SGU) + g.a.a.b.b.a.bM(11, this.SGV) + g.a.a.b.b.a.bM(12, this.SGW);
      paramInt = i;
      if (this.SGX != null) {
        paramInt = i + g.a.a.a.oD(13, this.SGX.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.SGY) + g.a.a.a.c(15, 8, this.SGZ) + g.a.a.a.c(16, 8, this.SHa);
      paramInt = i;
      if (this.SHb != null) {
        paramInt = i + g.a.a.a.oD(17, this.SHb.computeSize());
      }
      i = g.a.a.b.b.a.bM(18, this.SHc);
      int j = g.a.a.b.b.a.p(19, this.SHd);
      int k = g.a.a.a.c(20, 8, this.SHe);
      AppMethodBeat.o(230736);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SGP.clear();
        this.LIS.clear();
        this.SGZ.clear();
        this.SHa.clear();
        this.SHe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230736);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        auv localauv = (auv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230736);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localauv.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230736);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localauv.SGP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230736);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbd)localObject2).parseFrom((byte[])localObject1);
            }
            localauv.LIS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230736);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bac();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bac)localObject2).parseFrom((byte[])localObject1);
            }
            localauv.liveInfo = ((bac)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230736);
          return 0;
        case 5: 
          localauv.xak = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(230736);
          return 0;
        case 6: 
          localauv.SGR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230736);
          return 0;
        case 7: 
          localauv.SGS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230736);
          return 0;
        case 8: 
          localauv.SGT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230736);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bau();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bau)localObject2).parseFrom((byte[])localObject1);
            }
            localauv.SEJ = ((bau)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230736);
          return 0;
        case 10: 
          localauv.SGU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230736);
          return 0;
        case 11: 
          localauv.SGV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230736);
          return 0;
        case 12: 
          localauv.SGW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230736);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbl)localObject2).parseFrom((byte[])localObject1);
            }
            localauv.SGX = ((bbl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230736);
          return 0;
        case 14: 
          localauv.SGY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230736);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new axe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((axe)localObject2).parseFrom((byte[])localObject1);
            }
            localauv.SGZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230736);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdb)localObject2).parseFrom((byte[])localObject1);
            }
            localauv.SHa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230736);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ayl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ayl)localObject2).parseFrom((byte[])localObject1);
            }
            localauv.SHb = ((ayl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230736);
          return 0;
        case 18: 
          localauv.SHc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230736);
          return 0;
        case 19: 
          localauv.SHd = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230736);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ayl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ayl)localObject2).parseFrom((byte[])localObject1);
          }
          localauv.SHe.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(230736);
        return 0;
      }
      AppMethodBeat.o(230736);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auv
 * JD-Core Version:    0.7.0.1
 */