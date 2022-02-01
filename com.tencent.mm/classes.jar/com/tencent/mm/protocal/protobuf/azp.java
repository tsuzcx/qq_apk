package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azp
  extends esc
{
  public b Ayh;
  public LinkedList<bke> PmC;
  public bgw ZGD;
  public bjm ZGl;
  public LinkedList<FinderContact> ZJH;
  public int ZJN;
  public int ZJO;
  public int ZJP;
  public int ZJQ;
  public int ZJR;
  public int ZJS;
  public bku ZJT;
  public int ZJU;
  public LinkedList<bdm> ZJV;
  public LinkedList<bnp> ZJW;
  public bfl ZJX;
  public int ZJY;
  public long ZJZ;
  public LinkedList<bfl> ZKa;
  public bgz ZKb;
  public dit ZKc;
  public int ZKd;
  public LinkedList<Integer> ZKe;
  public LinkedList<Integer> ZKf;
  public LinkedList<Integer> ZKg;
  public long ZKh;
  public boolean ZKi;
  public bfg ZKj;
  public bip liveInfo;
  
  public azp()
  {
    AppMethodBeat.i(259031);
    this.ZJH = new LinkedList();
    this.PmC = new LinkedList();
    this.ZJV = new LinkedList();
    this.ZJW = new LinkedList();
    this.ZKa = new LinkedList();
    this.ZKe = new LinkedList();
    this.ZKf = new LinkedList();
    this.ZKg = new LinkedList();
    AppMethodBeat.o(259031);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259048);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZJH);
      paramVarArgs.e(3, 8, this.PmC);
      if (this.liveInfo != null)
      {
        paramVarArgs.qD(4, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      if (this.Ayh != null) {
        paramVarArgs.d(5, this.Ayh);
      }
      paramVarArgs.bS(6, this.ZJN);
      paramVarArgs.bS(7, this.ZJO);
      paramVarArgs.bS(8, this.ZJP);
      if (this.ZGl != null)
      {
        paramVarArgs.qD(9, this.ZGl.computeSize());
        this.ZGl.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.ZJQ);
      paramVarArgs.bS(11, this.ZJR);
      paramVarArgs.bS(12, this.ZJS);
      if (this.ZJT != null)
      {
        paramVarArgs.qD(13, this.ZJT.computeSize());
        this.ZJT.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.ZJU);
      paramVarArgs.e(15, 8, this.ZJV);
      paramVarArgs.e(16, 8, this.ZJW);
      if (this.ZJX != null)
      {
        paramVarArgs.qD(17, this.ZJX.computeSize());
        this.ZJX.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(18, this.ZJY);
      paramVarArgs.bv(19, this.ZJZ);
      paramVarArgs.e(20, 8, this.ZKa);
      if (this.ZKb != null)
      {
        paramVarArgs.qD(21, this.ZKb.computeSize());
        this.ZKb.writeFields(paramVarArgs);
      }
      if (this.ZKc != null)
      {
        paramVarArgs.qD(22, this.ZKc.computeSize());
        this.ZKc.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(23, this.ZKd);
      paramVarArgs.e(24, 2, this.ZKe);
      paramVarArgs.e(25, 2, this.ZKf);
      paramVarArgs.e(26, 2, this.ZKg);
      paramVarArgs.bv(27, this.ZKh);
      paramVarArgs.di(28, this.ZKi);
      if (this.ZGD != null)
      {
        paramVarArgs.qD(29, this.ZGD.computeSize());
        this.ZGD.writeFields(paramVarArgs);
      }
      if (this.ZKj != null)
      {
        paramVarArgs.qD(33, this.ZKj.computeSize());
        this.ZKj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2727;
      }
    }
    label2727:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZJH) + i.a.a.a.c(3, 8, this.PmC);
      paramInt = i;
      if (this.liveInfo != null) {
        paramInt = i + i.a.a.a.qC(4, this.liveInfo.computeSize());
      }
      i = paramInt;
      if (this.Ayh != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.Ayh);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.ZJN) + i.a.a.b.b.a.cJ(7, this.ZJO) + i.a.a.b.b.a.cJ(8, this.ZJP);
      paramInt = i;
      if (this.ZGl != null) {
        paramInt = i + i.a.a.a.qC(9, this.ZGl.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.ZJQ) + i.a.a.b.b.a.cJ(11, this.ZJR) + i.a.a.b.b.a.cJ(12, this.ZJS);
      paramInt = i;
      if (this.ZJT != null) {
        paramInt = i + i.a.a.a.qC(13, this.ZJT.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.ZJU) + i.a.a.a.c(15, 8, this.ZJV) + i.a.a.a.c(16, 8, this.ZJW);
      paramInt = i;
      if (this.ZJX != null) {
        paramInt = i + i.a.a.a.qC(17, this.ZJX.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(18, this.ZJY) + i.a.a.b.b.a.q(19, this.ZJZ) + i.a.a.a.c(20, 8, this.ZKa);
      paramInt = i;
      if (this.ZKb != null) {
        paramInt = i + i.a.a.a.qC(21, this.ZKb.computeSize());
      }
      i = paramInt;
      if (this.ZKc != null) {
        i = paramInt + i.a.a.a.qC(22, this.ZKc.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(23, this.ZKd) + i.a.a.a.c(24, 2, this.ZKe) + i.a.a.a.c(25, 2, this.ZKf) + i.a.a.a.c(26, 2, this.ZKg) + i.a.a.b.b.a.q(27, this.ZKh) + (i.a.a.b.b.a.ko(28) + 1);
      paramInt = i;
      if (this.ZGD != null) {
        paramInt = i + i.a.a.a.qC(29, this.ZGD.computeSize());
      }
      i = paramInt;
      if (this.ZKj != null) {
        i = paramInt + i.a.a.a.qC(33, this.ZKj.computeSize());
      }
      AppMethodBeat.o(259048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZJH.clear();
        this.PmC.clear();
        this.ZJV.clear();
        this.ZJW.clear();
        this.ZKa.clear();
        this.ZKe.clear();
        this.ZKf.clear();
        this.ZKg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azp localazp = (azp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 30: 
        case 31: 
        case 32: 
        default: 
          AppMethodBeat.o(259048);
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
            localazp.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
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
            localazp.ZJH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bke();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bke)localObject2).parseFrom((byte[])localObject1);
            }
            localazp.PmC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bip();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bip)localObject2).parseFrom((byte[])localObject1);
            }
            localazp.liveInfo = ((bip)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        case 5: 
          localazp.Ayh = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259048);
          return 0;
        case 6: 
          localazp.ZJN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259048);
          return 0;
        case 7: 
          localazp.ZJO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259048);
          return 0;
        case 8: 
          localazp.ZJP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259048);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjm)localObject2).parseFrom((byte[])localObject1);
            }
            localazp.ZGl = ((bjm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        case 10: 
          localazp.ZJQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259048);
          return 0;
        case 11: 
          localazp.ZJR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259048);
          return 0;
        case 12: 
          localazp.ZJS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259048);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bku)localObject2).parseFrom((byte[])localObject1);
            }
            localazp.ZJT = ((bku)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        case 14: 
          localazp.ZJU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259048);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdm)localObject2).parseFrom((byte[])localObject1);
            }
            localazp.ZJV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnp)localObject2).parseFrom((byte[])localObject1);
            }
            localazp.ZJW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfl)localObject2).parseFrom((byte[])localObject1);
            }
            localazp.ZJX = ((bfl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        case 18: 
          localazp.ZJY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259048);
          return 0;
        case 19: 
          localazp.ZJZ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259048);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfl)localObject2).parseFrom((byte[])localObject1);
            }
            localazp.ZKa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgz)localObject2).parseFrom((byte[])localObject1);
            }
            localazp.ZKb = ((bgz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dit();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dit)localObject2).parseFrom((byte[])localObject1);
            }
            localazp.ZKc = ((dit)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        case 23: 
          localazp.ZKd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259048);
          return 0;
        case 24: 
          localazp.ZKe.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(259048);
          return 0;
        case 25: 
          localazp.ZKf.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(259048);
          return 0;
        case 26: 
          localazp.ZKg.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(259048);
          return 0;
        case 27: 
          localazp.ZKh = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259048);
          return 0;
        case 28: 
          localazp.ZKi = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(259048);
          return 0;
        case 29: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgw)localObject2).parseFrom((byte[])localObject1);
            }
            localazp.ZGD = ((bgw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259048);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfg)localObject2).parseFrom((byte[])localObject1);
          }
          localazp.ZKj = ((bfg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259048);
        return 0;
      }
      AppMethodBeat.o(259048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azp
 * JD-Core Version:    0.7.0.1
 */