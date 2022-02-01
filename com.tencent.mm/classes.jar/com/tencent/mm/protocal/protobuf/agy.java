package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agy
  extends com.tencent.mm.bw.a
{
  public ahf CoY;
  public ahh DKz;
  public agz EAG;
  public boolean EAH = false;
  public ahe EAI;
  public boolean EAJ = false;
  public aic EAK;
  public boolean EAL = false;
  public ahm EAM;
  public boolean EAN = false;
  public ahw EAO;
  public boolean EAP = false;
  public boolean EAQ = false;
  public long EAR;
  public boolean EAS = false;
  public int EAT = -1;
  public boolean EAU = false;
  public boolean EAV = false;
  public boolean EAW = false;
  public agv EAX;
  public boolean EAY = false;
  public boolean EAZ = false;
  public ahf EBa;
  public boolean EBb = false;
  public anx EBc;
  public boolean EBd = false;
  public boolean EyY = false;
  public boolean EyZ = false;
  public String desc;
  public String iAC;
  public long pmI;
  public String title;
  
  public final agy a(ahm paramahm)
  {
    this.EAM = paramahm;
    this.EAN = true;
    return this;
  }
  
  public final agy a(ahw paramahw)
  {
    this.EAO = paramahw;
    this.EAP = true;
    return this;
  }
  
  public final agy a(aic paramaic)
  {
    this.EAK = paramaic;
    this.EAL = true;
    return this;
  }
  
  public final agy b(agv paramagv)
  {
    this.EAX = paramagv;
    this.EAY = true;
    return this;
  }
  
  public final agy c(agz paramagz)
  {
    this.EAG = paramagz;
    this.EAH = true;
    return this;
  }
  
  public final agy c(ahe paramahe)
  {
    this.EAI = paramahe;
    this.EAJ = true;
    return this;
  }
  
  public final agy c(anx paramanx)
  {
    this.EBc = paramanx;
    this.EBd = true;
    return this;
  }
  
  public final agy d(ahf paramahf)
  {
    this.CoY = paramahf;
    this.EAZ = true;
    return this;
  }
  
  public final agy e(ahf paramahf)
  {
    this.EBa = paramahf;
    this.EBb = true;
    return this;
  }
  
  public final agz eRH()
  {
    return this.EAG;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127458);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EAG != null)
      {
        paramVarArgs.ln(1, this.EAG.computeSize());
        this.EAG.writeFields(paramVarArgs);
      }
      if (this.EAI != null)
      {
        paramVarArgs.ln(2, this.EAI.computeSize());
        this.EAI.writeFields(paramVarArgs);
      }
      if (this.EAK != null)
      {
        paramVarArgs.ln(3, this.EAK.computeSize());
        this.EAK.writeFields(paramVarArgs);
      }
      if (this.EAM != null)
      {
        paramVarArgs.ln(4, this.EAM.computeSize());
        this.EAM.writeFields(paramVarArgs);
      }
      if (this.EAO != null)
      {
        paramVarArgs.ln(5, this.EAO.computeSize());
        this.EAO.writeFields(paramVarArgs);
      }
      if (this.iAC != null) {
        paramVarArgs.d(6, this.iAC);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(8, this.desc);
      }
      if (this.EAS == true) {
        paramVarArgs.aO(9, this.EAR);
      }
      if (this.EAU == true) {
        paramVarArgs.aR(101, this.EAT);
      }
      if (this.EAV == true) {
        paramVarArgs.aO(11, this.pmI);
      }
      if (this.DKz != null)
      {
        paramVarArgs.ln(12, this.DKz.computeSize());
        this.DKz.writeFields(paramVarArgs);
      }
      if (this.EAX != null)
      {
        paramVarArgs.ln(13, this.EAX.computeSize());
        this.EAX.writeFields(paramVarArgs);
      }
      if (this.CoY != null)
      {
        paramVarArgs.ln(14, this.CoY.computeSize());
        this.CoY.writeFields(paramVarArgs);
      }
      if (this.EBa != null)
      {
        paramVarArgs.ln(15, this.EBa.computeSize());
        this.EBa.writeFields(paramVarArgs);
      }
      if (this.EBc != null)
      {
        paramVarArgs.ln(16, this.EBc.computeSize());
        this.EBc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EAG == null) {
        break label2242;
      }
    }
    label2242:
    for (int i = f.a.a.a.lm(1, this.EAG.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EAI != null) {
        paramInt = i + f.a.a.a.lm(2, this.EAI.computeSize());
      }
      i = paramInt;
      if (this.EAK != null) {
        i = paramInt + f.a.a.a.lm(3, this.EAK.computeSize());
      }
      paramInt = i;
      if (this.EAM != null) {
        paramInt = i + f.a.a.a.lm(4, this.EAM.computeSize());
      }
      i = paramInt;
      if (this.EAO != null) {
        i = paramInt + f.a.a.a.lm(5, this.EAO.computeSize());
      }
      paramInt = i;
      if (this.iAC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iAC);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.desc);
      }
      i = paramInt;
      if (this.EAS == true) {
        i = paramInt + f.a.a.b.b.a.p(9, this.EAR);
      }
      paramInt = i;
      if (this.EAU == true) {
        paramInt = i + f.a.a.b.b.a.bx(101, this.EAT);
      }
      i = paramInt;
      if (this.EAV == true) {
        i = paramInt + f.a.a.b.b.a.p(11, this.pmI);
      }
      paramInt = i;
      if (this.DKz != null) {
        paramInt = i + f.a.a.a.lm(12, this.DKz.computeSize());
      }
      i = paramInt;
      if (this.EAX != null) {
        i = paramInt + f.a.a.a.lm(13, this.EAX.computeSize());
      }
      paramInt = i;
      if (this.CoY != null) {
        paramInt = i + f.a.a.a.lm(14, this.CoY.computeSize());
      }
      i = paramInt;
      if (this.EBa != null) {
        i = paramInt + f.a.a.a.lm(15, this.EBa.computeSize());
      }
      paramInt = i;
      if (this.EBc != null) {
        paramInt = i + f.a.a.a.lm(16, this.EBc.computeSize());
      }
      AppMethodBeat.o(127458);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agy localagy = (agy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127458);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagy.EAG = ((agz)localObject1);
            paramInt += 1;
          }
          localagy.EAH = true;
          AppMethodBeat.o(127458);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagy.EAI = ((ahe)localObject1);
            paramInt += 1;
          }
          localagy.EAJ = true;
          AppMethodBeat.o(127458);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aic();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aic)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagy.EAK = ((aic)localObject1);
            paramInt += 1;
          }
          localagy.EAL = true;
          AppMethodBeat.o(127458);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagy.EAM = ((ahm)localObject1);
            paramInt += 1;
          }
          localagy.EAN = true;
          AppMethodBeat.o(127458);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagy.EAO = ((ahw)localObject1);
            paramInt += 1;
          }
          localagy.EAP = true;
          AppMethodBeat.o(127458);
          return 0;
        case 6: 
          localagy.iAC = ((f.a.a.a.a)localObject1).LVo.readString();
          localagy.EAQ = true;
          AppMethodBeat.o(127458);
          return 0;
        case 7: 
          localagy.title = ((f.a.a.a.a)localObject1).LVo.readString();
          localagy.EyY = true;
          AppMethodBeat.o(127458);
          return 0;
        case 8: 
          localagy.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          localagy.EyZ = true;
          AppMethodBeat.o(127458);
          return 0;
        case 9: 
          localagy.EAR = ((f.a.a.a.a)localObject1).LVo.xG();
          localagy.EAS = true;
          AppMethodBeat.o(127458);
          return 0;
        case 101: 
          localagy.EAT = ((f.a.a.a.a)localObject1).LVo.xF();
          localagy.EAU = true;
          AppMethodBeat.o(127458);
          return 0;
        case 11: 
          localagy.pmI = ((f.a.a.a.a)localObject1).LVo.xG();
          localagy.EAV = true;
          AppMethodBeat.o(127458);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagy.DKz = ((ahh)localObject1);
            paramInt += 1;
          }
          localagy.EAW = true;
          AppMethodBeat.o(127458);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagy.EAX = ((agv)localObject1);
            paramInt += 1;
          }
          localagy.EAY = true;
          AppMethodBeat.o(127458);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagy.CoY = ((ahf)localObject1);
            paramInt += 1;
          }
          localagy.EAZ = true;
          AppMethodBeat.o(127458);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagy.EBa = ((ahf)localObject1);
            paramInt += 1;
          }
          localagy.EBb = true;
          AppMethodBeat.o(127458);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new anx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((anx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagy.EBc = ((anx)localObject1);
          paramInt += 1;
        }
        localagy.EBd = true;
        AppMethodBeat.o(127458);
        return 0;
      }
      AppMethodBeat.o(127458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agy
 * JD-Core Version:    0.7.0.1
 */