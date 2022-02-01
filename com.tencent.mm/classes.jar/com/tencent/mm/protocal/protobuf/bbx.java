package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbx
  extends esc
{
  public int ZEp;
  public String ZMA;
  public int ZMB;
  public bxk ZMC;
  public LinkedList<bvq> ZMD;
  public bzf ZME;
  public buo ZMF;
  public awm ZMG;
  public LinkedList<FinderContact> ZMq;
  public LinkedList<bxg> ZMr;
  public int ZMs;
  public int ZMt;
  public gdx ZMu;
  public LinkedList<bcz> ZMv;
  public int ZMw;
  public long ZMx;
  public bxl ZMy;
  public LinkedList<String> ZMz;
  public gol ZdD;
  public int continueFlag;
  public LinkedList<auw> zMR;
  
  public bbx()
  {
    AppMethodBeat.i(168998);
    this.ZMq = new LinkedList();
    this.zMR = new LinkedList();
    this.ZMr = new LinkedList();
    this.ZMv = new LinkedList();
    this.ZMz = new LinkedList();
    this.ZMD = new LinkedList();
    AppMethodBeat.o(168998);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168999);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZMq);
      if (this.ZdD != null)
      {
        paramVarArgs.qD(3, this.ZdD.computeSize());
        this.ZdD.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.zMR);
      paramVarArgs.bS(5, this.continueFlag);
      paramVarArgs.bS(6, this.ZEp);
      paramVarArgs.e(7, 8, this.ZMr);
      paramVarArgs.bS(8, this.ZMs);
      paramVarArgs.bS(9, this.ZMt);
      if (this.ZMu != null)
      {
        paramVarArgs.qD(10, this.ZMu.computeSize());
        this.ZMu.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.ZMv);
      paramVarArgs.bS(12, this.ZMw);
      paramVarArgs.bv(13, this.ZMx);
      if (this.ZMy != null)
      {
        paramVarArgs.qD(14, this.ZMy.computeSize());
        this.ZMy.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 1, this.ZMz);
      if (this.ZMA != null) {
        paramVarArgs.g(16, this.ZMA);
      }
      paramVarArgs.bS(17, this.ZMB);
      if (this.ZMC != null)
      {
        paramVarArgs.qD(18, this.ZMC.computeSize());
        this.ZMC.writeFields(paramVarArgs);
      }
      paramVarArgs.e(19, 8, this.ZMD);
      if (this.ZME != null)
      {
        paramVarArgs.qD(20, this.ZME.computeSize());
        this.ZME.writeFields(paramVarArgs);
      }
      if (this.ZMF != null)
      {
        paramVarArgs.qD(21, this.ZMF.computeSize());
        this.ZMF.writeFields(paramVarArgs);
      }
      if (this.ZMG != null)
      {
        paramVarArgs.qD(22, this.ZMG.computeSize());
        this.ZMG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2240;
      }
    }
    label2240:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZMq);
      paramInt = i;
      if (this.ZdD != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZdD.computeSize());
      }
      i = paramInt + i.a.a.a.c(4, 8, this.zMR) + i.a.a.b.b.a.cJ(5, this.continueFlag) + i.a.a.b.b.a.cJ(6, this.ZEp) + i.a.a.a.c(7, 8, this.ZMr) + i.a.a.b.b.a.cJ(8, this.ZMs) + i.a.a.b.b.a.cJ(9, this.ZMt);
      paramInt = i;
      if (this.ZMu != null) {
        paramInt = i + i.a.a.a.qC(10, this.ZMu.computeSize());
      }
      i = paramInt + i.a.a.a.c(11, 8, this.ZMv) + i.a.a.b.b.a.cJ(12, this.ZMw) + i.a.a.b.b.a.q(13, this.ZMx);
      paramInt = i;
      if (this.ZMy != null) {
        paramInt = i + i.a.a.a.qC(14, this.ZMy.computeSize());
      }
      i = paramInt + i.a.a.a.c(15, 1, this.ZMz);
      paramInt = i;
      if (this.ZMA != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.ZMA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.ZMB);
      paramInt = i;
      if (this.ZMC != null) {
        paramInt = i + i.a.a.a.qC(18, this.ZMC.computeSize());
      }
      i = paramInt + i.a.a.a.c(19, 8, this.ZMD);
      paramInt = i;
      if (this.ZME != null) {
        paramInt = i + i.a.a.a.qC(20, this.ZME.computeSize());
      }
      i = paramInt;
      if (this.ZMF != null) {
        i = paramInt + i.a.a.a.qC(21, this.ZMF.computeSize());
      }
      paramInt = i;
      if (this.ZMG != null) {
        paramInt = i + i.a.a.a.qC(22, this.ZMG.computeSize());
      }
      AppMethodBeat.o(168999);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZMq.clear();
        this.zMR.clear();
        this.ZMr.clear();
        this.ZMv.clear();
        this.ZMz.clear();
        this.ZMD.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168999);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bbx localbbx = (bbx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168999);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbbx.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbbx.ZMq.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localbbx.ZdD = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new auw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((auw)localObject2).parseFrom((byte[])localObject1);
            }
            localbbx.zMR.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 5: 
          localbbx.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168999);
          return 0;
        case 6: 
          localbbx.ZEp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168999);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bxg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bxg)localObject2).parseFrom((byte[])localObject1);
            }
            localbbx.ZMr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 8: 
          localbbx.ZMs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168999);
          return 0;
        case 9: 
          localbbx.ZMt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168999);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gdx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gdx)localObject2).parseFrom((byte[])localObject1);
            }
            localbbx.ZMu = ((gdx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcz)localObject2).parseFrom((byte[])localObject1);
            }
            localbbx.ZMv.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 12: 
          localbbx.ZMw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168999);
          return 0;
        case 13: 
          localbbx.ZMx = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168999);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bxl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bxl)localObject2).parseFrom((byte[])localObject1);
            }
            localbbx.ZMy = ((bxl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 15: 
          localbbx.ZMz.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(168999);
          return 0;
        case 16: 
          localbbx.ZMA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168999);
          return 0;
        case 17: 
          localbbx.ZMB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168999);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bxk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bxk)localObject2).parseFrom((byte[])localObject1);
            }
            localbbx.ZMC = ((bxk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvq)localObject2).parseFrom((byte[])localObject1);
            }
            localbbx.ZMD.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzf)localObject2).parseFrom((byte[])localObject1);
            }
            localbbx.ZME = ((bzf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new buo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((buo)localObject2).parseFrom((byte[])localObject1);
            }
            localbbx.ZMF = ((buo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new awm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((awm)localObject2).parseFrom((byte[])localObject1);
          }
          localbbx.ZMG = ((awm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168999);
        return 0;
      }
      AppMethodBeat.o(168999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbx
 * JD-Core Version:    0.7.0.1
 */