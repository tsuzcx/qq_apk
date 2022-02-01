package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arg
  extends com.tencent.mm.bx.a
{
  public arn WKx;
  public arp YzK;
  public boolean ZAA = false;
  public bvl ZAB;
  public boolean ZAC = false;
  public bmr ZAD;
  public boolean ZAE = false;
  public bvk ZAF;
  public boolean ZAG = false;
  public bvh ZAH;
  public boolean ZAI = false;
  public dtj ZAJ;
  public boolean ZAK = false;
  public bvn ZAL;
  public boolean ZAM = false;
  public bvn ZAN;
  public boolean ZAO = false;
  public arh ZAf;
  public boolean ZAg = false;
  public arm ZAh;
  public boolean ZAi = false;
  public ask ZAj;
  public boolean ZAk = false;
  public aru ZAl;
  public boolean ZAm = false;
  public ase ZAn;
  public boolean ZAo = false;
  public boolean ZAp = false;
  public long ZAq;
  public boolean ZAr = false;
  public int ZAs = -1;
  public boolean ZAt = false;
  public boolean ZAu = false;
  public boolean ZAv = false;
  public ard ZAw;
  public boolean ZAx = false;
  public boolean ZAy = false;
  public arn ZAz;
  public boolean ZyA = false;
  public boolean Zyz = false;
  public String desc;
  public String remark;
  public String title;
  public long ygh;
  
  public final arg a(aru paramaru)
  {
    this.ZAl = paramaru;
    this.ZAm = true;
    return this;
  }
  
  public final arg a(ase paramase)
  {
    this.ZAn = paramase;
    this.ZAo = true;
    return this;
  }
  
  public final arg a(bvk parambvk)
  {
    this.ZAF = parambvk;
    this.ZAG = true;
    return this;
  }
  
  public final arg b(ard paramard)
  {
    this.ZAw = paramard;
    this.ZAx = true;
    return this;
  }
  
  public final arg b(ask paramask)
  {
    this.ZAj = paramask;
    this.ZAk = true;
    return this;
  }
  
  public final arg c(arh paramarh)
  {
    this.ZAf = paramarh;
    this.ZAg = true;
    return this;
  }
  
  public final arg c(arm paramarm)
  {
    this.ZAh = paramarm;
    this.ZAi = true;
    return this;
  }
  
  public final arg c(bvh parambvh)
  {
    this.ZAH = parambvh;
    this.ZAI = true;
    return this;
  }
  
  public final arg c(bvn parambvn)
  {
    this.ZAL = parambvn;
    this.ZAM = true;
    return this;
  }
  
  public final arg d(arn paramarn)
  {
    this.WKx = paramarn;
    this.ZAy = true;
    return this;
  }
  
  public final arg d(bvn parambvn)
  {
    this.ZAN = parambvn;
    this.ZAO = true;
    return this;
  }
  
  public final arg e(arn paramarn)
  {
    this.ZAz = paramarn;
    this.ZAA = true;
    return this;
  }
  
  public final arg e(dtj paramdtj)
  {
    this.ZAJ = paramdtj;
    this.ZAK = true;
    return this;
  }
  
  public final arg g(bmr parambmr)
  {
    this.ZAD = parambmr;
    this.ZAE = true;
    return this;
  }
  
  public final arg g(bvl parambvl)
  {
    this.ZAB = parambvl;
    this.ZAC = true;
    return this;
  }
  
  public final arh iQn()
  {
    return this.ZAf;
  }
  
  public final aru iQo()
  {
    return this.ZAl;
  }
  
  public final ase iQp()
  {
    return this.ZAn;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127458);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZAf != null)
      {
        paramVarArgs.qD(1, this.ZAf.computeSize());
        this.ZAf.writeFields(paramVarArgs);
      }
      if (this.ZAh != null)
      {
        paramVarArgs.qD(2, this.ZAh.computeSize());
        this.ZAh.writeFields(paramVarArgs);
      }
      if (this.ZAj != null)
      {
        paramVarArgs.qD(3, this.ZAj.computeSize());
        this.ZAj.writeFields(paramVarArgs);
      }
      if (this.ZAl != null)
      {
        paramVarArgs.qD(4, this.ZAl.computeSize());
        this.ZAl.writeFields(paramVarArgs);
      }
      if (this.ZAn != null)
      {
        paramVarArgs.qD(5, this.ZAn.computeSize());
        this.ZAn.writeFields(paramVarArgs);
      }
      if (this.remark != null) {
        paramVarArgs.g(6, this.remark);
      }
      if (this.title != null) {
        paramVarArgs.g(7, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(8, this.desc);
      }
      if (this.ZAr == true) {
        paramVarArgs.bv(9, this.ZAq);
      }
      if (this.ZAt == true) {
        paramVarArgs.bS(101, this.ZAs);
      }
      if (this.ZAu == true) {
        paramVarArgs.bv(11, this.ygh);
      }
      if (this.YzK != null)
      {
        paramVarArgs.qD(12, this.YzK.computeSize());
        this.YzK.writeFields(paramVarArgs);
      }
      if (this.ZAw != null)
      {
        paramVarArgs.qD(13, this.ZAw.computeSize());
        this.ZAw.writeFields(paramVarArgs);
      }
      if (this.WKx != null)
      {
        paramVarArgs.qD(14, this.WKx.computeSize());
        this.WKx.writeFields(paramVarArgs);
      }
      if (this.ZAz != null)
      {
        paramVarArgs.qD(15, this.ZAz.computeSize());
        this.ZAz.writeFields(paramVarArgs);
      }
      if (this.ZAB != null)
      {
        paramVarArgs.qD(16, this.ZAB.computeSize());
        this.ZAB.writeFields(paramVarArgs);
      }
      if (this.ZAD != null)
      {
        paramVarArgs.qD(17, this.ZAD.computeSize());
        this.ZAD.writeFields(paramVarArgs);
      }
      if (this.ZAF != null)
      {
        paramVarArgs.qD(18, this.ZAF.computeSize());
        this.ZAF.writeFields(paramVarArgs);
      }
      if (this.ZAH != null)
      {
        paramVarArgs.qD(19, this.ZAH.computeSize());
        this.ZAH.writeFields(paramVarArgs);
      }
      if (this.ZAJ != null)
      {
        paramVarArgs.qD(20, this.ZAJ.computeSize());
        this.ZAJ.writeFields(paramVarArgs);
      }
      if (this.ZAL != null)
      {
        paramVarArgs.qD(21, this.ZAL.computeSize());
        this.ZAL.writeFields(paramVarArgs);
      }
      if (this.ZAN != null)
      {
        paramVarArgs.qD(22, this.ZAN.computeSize());
        this.ZAN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZAf == null) {
        break label2882;
      }
    }
    label2882:
    for (int i = i.a.a.a.qC(1, this.ZAf.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZAh != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZAh.computeSize());
      }
      i = paramInt;
      if (this.ZAj != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZAj.computeSize());
      }
      paramInt = i;
      if (this.ZAl != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZAl.computeSize());
      }
      i = paramInt;
      if (this.ZAn != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZAn.computeSize());
      }
      paramInt = i;
      if (this.remark != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.remark);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.desc);
      }
      i = paramInt;
      if (this.ZAr == true) {
        i = paramInt + i.a.a.b.b.a.q(9, this.ZAq);
      }
      paramInt = i;
      if (this.ZAt == true) {
        paramInt = i + i.a.a.b.b.a.cJ(101, this.ZAs);
      }
      i = paramInt;
      if (this.ZAu == true) {
        i = paramInt + i.a.a.b.b.a.q(11, this.ygh);
      }
      paramInt = i;
      if (this.YzK != null) {
        paramInt = i + i.a.a.a.qC(12, this.YzK.computeSize());
      }
      i = paramInt;
      if (this.ZAw != null) {
        i = paramInt + i.a.a.a.qC(13, this.ZAw.computeSize());
      }
      paramInt = i;
      if (this.WKx != null) {
        paramInt = i + i.a.a.a.qC(14, this.WKx.computeSize());
      }
      i = paramInt;
      if (this.ZAz != null) {
        i = paramInt + i.a.a.a.qC(15, this.ZAz.computeSize());
      }
      paramInt = i;
      if (this.ZAB != null) {
        paramInt = i + i.a.a.a.qC(16, this.ZAB.computeSize());
      }
      i = paramInt;
      if (this.ZAD != null) {
        i = paramInt + i.a.a.a.qC(17, this.ZAD.computeSize());
      }
      paramInt = i;
      if (this.ZAF != null) {
        paramInt = i + i.a.a.a.qC(18, this.ZAF.computeSize());
      }
      i = paramInt;
      if (this.ZAH != null) {
        i = paramInt + i.a.a.a.qC(19, this.ZAH.computeSize());
      }
      paramInt = i;
      if (this.ZAJ != null) {
        paramInt = i + i.a.a.a.qC(20, this.ZAJ.computeSize());
      }
      i = paramInt;
      if (this.ZAL != null) {
        i = paramInt + i.a.a.a.qC(21, this.ZAL.computeSize());
      }
      paramInt = i;
      if (this.ZAN != null) {
        paramInt = i + i.a.a.a.qC(22, this.ZAN.computeSize());
      }
      AppMethodBeat.o(127458);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        arg localarg = (arg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127458);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arh)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAf = ((arh)localObject2);
            paramInt += 1;
          }
          localarg.ZAg = true;
          AppMethodBeat.o(127458);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arm)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAh = ((arm)localObject2);
            paramInt += 1;
          }
          localarg.ZAi = true;
          AppMethodBeat.o(127458);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ask();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ask)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAj = ((ask)localObject2);
            paramInt += 1;
          }
          localarg.ZAk = true;
          AppMethodBeat.o(127458);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aru();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aru)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAl = ((aru)localObject2);
            paramInt += 1;
          }
          localarg.ZAm = true;
          AppMethodBeat.o(127458);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ase();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ase)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAn = ((ase)localObject2);
            paramInt += 1;
          }
          localarg.ZAo = true;
          AppMethodBeat.o(127458);
          return 0;
        case 6: 
          localarg.remark = ((i.a.a.a.a)localObject1).ajGk.readString();
          localarg.ZAp = true;
          AppMethodBeat.o(127458);
          return 0;
        case 7: 
          localarg.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          localarg.Zyz = true;
          AppMethodBeat.o(127458);
          return 0;
        case 8: 
          localarg.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
          localarg.ZyA = true;
          AppMethodBeat.o(127458);
          return 0;
        case 9: 
          localarg.ZAq = ((i.a.a.a.a)localObject1).ajGk.aaw();
          localarg.ZAr = true;
          AppMethodBeat.o(127458);
          return 0;
        case 101: 
          localarg.ZAs = ((i.a.a.a.a)localObject1).ajGk.aar();
          localarg.ZAt = true;
          AppMethodBeat.o(127458);
          return 0;
        case 11: 
          localarg.ygh = ((i.a.a.a.a)localObject1).ajGk.aaw();
          localarg.ZAu = true;
          AppMethodBeat.o(127458);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arp)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.YzK = ((arp)localObject2);
            paramInt += 1;
          }
          localarg.ZAv = true;
          AppMethodBeat.o(127458);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ard();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ard)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAw = ((ard)localObject2);
            paramInt += 1;
          }
          localarg.ZAx = true;
          AppMethodBeat.o(127458);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arn)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.WKx = ((arn)localObject2);
            paramInt += 1;
          }
          localarg.ZAy = true;
          AppMethodBeat.o(127458);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arn)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAz = ((arn)localObject2);
            paramInt += 1;
          }
          localarg.ZAA = true;
          AppMethodBeat.o(127458);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvl)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAB = ((bvl)localObject2);
            paramInt += 1;
          }
          localarg.ZAC = true;
          AppMethodBeat.o(127458);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmr)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAD = ((bmr)localObject2);
            paramInt += 1;
          }
          localarg.ZAE = true;
          AppMethodBeat.o(127458);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvk)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAF = ((bvk)localObject2);
            paramInt += 1;
          }
          localarg.ZAG = true;
          AppMethodBeat.o(127458);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvh)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAH = ((bvh)localObject2);
            paramInt += 1;
          }
          localarg.ZAI = true;
          AppMethodBeat.o(127458);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtj)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAJ = ((dtj)localObject2);
            paramInt += 1;
          }
          localarg.ZAK = true;
          AppMethodBeat.o(127458);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvn)localObject2).parseFrom((byte[])localObject1);
            }
            localarg.ZAL = ((bvn)localObject2);
            paramInt += 1;
          }
          localarg.ZAM = true;
          AppMethodBeat.o(127458);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bvn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bvn)localObject2).parseFrom((byte[])localObject1);
          }
          localarg.ZAN = ((bvn)localObject2);
          paramInt += 1;
        }
        localarg.ZAO = true;
        AppMethodBeat.o(127458);
        return 0;
      }
      AppMethodBeat.o(127458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arg
 * JD-Core Version:    0.7.0.1
 */