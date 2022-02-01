package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahn
  extends com.tencent.mm.bw.a
{
  public ahf CoY;
  public ahh DKz;
  public ahe EAI;
  public boolean EAJ;
  public aic EAK;
  public boolean EAL;
  public ahm EAM;
  public boolean EAN;
  public ahw EAO;
  public boolean EAP;
  public boolean EAQ;
  public long EAR;
  public boolean EAS;
  public int EAT;
  public boolean EAU;
  public boolean EAV;
  public boolean EAW;
  public agv EAX;
  public boolean EAY;
  public boolean EAZ;
  public aht EBJ;
  public boolean EBK;
  public boolean EBL;
  public boolean EBM;
  public anx EBc;
  public boolean EBd;
  public boolean EyY;
  public boolean EyZ;
  public String desc;
  public String iAC;
  public LinkedList<agx> nxC;
  public long pmI;
  public String title;
  public int version;
  
  public ahn()
  {
    AppMethodBeat.i(127473);
    this.EBK = false;
    this.nxC = new LinkedList();
    this.EBL = false;
    this.EAJ = false;
    this.EAL = false;
    this.EAQ = false;
    this.EyY = false;
    this.EyZ = false;
    this.EAS = false;
    this.EAT = -1;
    this.EAU = false;
    this.EAN = false;
    this.EAV = false;
    this.EAP = false;
    this.EBM = false;
    this.EAW = false;
    this.EAY = false;
    this.EAZ = false;
    this.EBd = false;
    AppMethodBeat.o(127473);
  }
  
  public final ahn XT(int paramInt)
  {
    this.EAT = paramInt;
    this.EAU = true;
    return this;
  }
  
  public final ahn XU(int paramInt)
  {
    this.version = paramInt;
    this.EBM = true;
    return this;
  }
  
  public final ahn a(ahh paramahh)
  {
    this.DKz = paramahh;
    this.EAW = true;
    return this;
  }
  
  public final ahn a(aht paramaht)
  {
    this.EBJ = paramaht;
    this.EBK = true;
    return this;
  }
  
  public final ahn aJA(String paramString)
  {
    this.title = paramString;
    this.EyY = true;
    return this;
  }
  
  public final ahn aJB(String paramString)
  {
    this.desc = paramString;
    this.EyZ = true;
    return this;
  }
  
  public final ahn aJz(String paramString)
  {
    this.iAC = paramString;
    this.EAQ = true;
    return this;
  }
  
  public final ahn b(ahm paramahm)
  {
    this.EAM = paramahm;
    this.EAN = true;
    return this;
  }
  
  public final ahn b(ahw paramahw)
  {
    this.EAO = paramahw;
    this.EAP = true;
    return this;
  }
  
  public final ahn b(aic paramaic)
  {
    this.EAK = paramaic;
    this.EAL = true;
    return this;
  }
  
  public final ahn bk(LinkedList<agx> paramLinkedList)
  {
    this.nxC = paramLinkedList;
    this.EBL = true;
    return this;
  }
  
  public final ahn c(agv paramagv)
  {
    this.EAX = paramagv;
    this.EAY = true;
    return this;
  }
  
  public final ahn d(ahe paramahe)
  {
    this.EAI = paramahe;
    this.EAJ = true;
    return this;
  }
  
  public final ahn d(anx paramanx)
  {
    this.EBc = paramanx;
    this.EBd = true;
    return this;
  }
  
  public final anx eRJ()
  {
    return this.EBc;
  }
  
  public final ahn f(ahf paramahf)
  {
    this.CoY = paramahf;
    this.EAZ = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127474);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EBJ != null)
      {
        paramVarArgs.ln(1, this.EBJ.computeSize());
        this.EBJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.nxC);
      if (this.EAI != null)
      {
        paramVarArgs.ln(3, this.EAI.computeSize());
        this.EAI.writeFields(paramVarArgs);
      }
      if (this.EAK != null)
      {
        paramVarArgs.ln(4, this.EAK.computeSize());
        this.EAK.writeFields(paramVarArgs);
      }
      if (this.iAC != null) {
        paramVarArgs.d(5, this.iAC);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(7, this.desc);
      }
      if (this.EAS == true) {
        paramVarArgs.aO(8, this.EAR);
      }
      if (this.EAU == true) {
        paramVarArgs.aR(91, this.EAT);
      }
      if (this.EAM != null)
      {
        paramVarArgs.ln(10, this.EAM.computeSize());
        this.EAM.writeFields(paramVarArgs);
      }
      if (this.EAV == true) {
        paramVarArgs.aO(11, this.pmI);
      }
      if (this.EAO != null)
      {
        paramVarArgs.ln(12, this.EAO.computeSize());
        this.EAO.writeFields(paramVarArgs);
      }
      if (this.EBM == true) {
        paramVarArgs.aR(13, this.version);
      }
      if (this.DKz != null)
      {
        paramVarArgs.ln(14, this.DKz.computeSize());
        this.DKz.writeFields(paramVarArgs);
      }
      if (this.EAX != null)
      {
        paramVarArgs.ln(15, this.EAX.computeSize());
        this.EAX.writeFields(paramVarArgs);
      }
      if (this.CoY != null)
      {
        paramVarArgs.ln(16, this.CoY.computeSize());
        this.CoY.writeFields(paramVarArgs);
      }
      if (this.EBc != null)
      {
        paramVarArgs.ln(17, this.EBc.computeSize());
        this.EBc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EBJ == null) {
        break label2300;
      }
    }
    label2300:
    for (paramInt = f.a.a.a.lm(1, this.EBJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.nxC);
      paramInt = i;
      if (this.EAI != null) {
        paramInt = i + f.a.a.a.lm(3, this.EAI.computeSize());
      }
      i = paramInt;
      if (this.EAK != null) {
        i = paramInt + f.a.a.a.lm(4, this.EAK.computeSize());
      }
      paramInt = i;
      if (this.iAC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.iAC);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.title);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.desc);
      }
      i = paramInt;
      if (this.EAS == true) {
        i = paramInt + f.a.a.b.b.a.p(8, this.EAR);
      }
      paramInt = i;
      if (this.EAU == true) {
        paramInt = i + f.a.a.b.b.a.bx(91, this.EAT);
      }
      i = paramInt;
      if (this.EAM != null) {
        i = paramInt + f.a.a.a.lm(10, this.EAM.computeSize());
      }
      paramInt = i;
      if (this.EAV == true) {
        paramInt = i + f.a.a.b.b.a.p(11, this.pmI);
      }
      i = paramInt;
      if (this.EAO != null) {
        i = paramInt + f.a.a.a.lm(12, this.EAO.computeSize());
      }
      paramInt = i;
      if (this.EBM == true) {
        paramInt = i + f.a.a.b.b.a.bx(13, this.version);
      }
      i = paramInt;
      if (this.DKz != null) {
        i = paramInt + f.a.a.a.lm(14, this.DKz.computeSize());
      }
      paramInt = i;
      if (this.EAX != null) {
        paramInt = i + f.a.a.a.lm(15, this.EAX.computeSize());
      }
      i = paramInt;
      if (this.CoY != null) {
        i = paramInt + f.a.a.a.lm(16, this.CoY.computeSize());
      }
      paramInt = i;
      if (this.EBc != null) {
        paramInt = i + f.a.a.a.lm(17, this.EBc.computeSize());
      }
      AppMethodBeat.o(127474);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nxC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ahn localahn = (ahn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127474);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahn.EBJ = ((aht)localObject1);
            paramInt += 1;
          }
          localahn.EBK = true;
          AppMethodBeat.o(127474);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahn.nxC.add(localObject1);
            paramInt += 1;
          }
          localahn.EBL = true;
          AppMethodBeat.o(127474);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahn.EAI = ((ahe)localObject1);
            paramInt += 1;
          }
          localahn.EAJ = true;
          AppMethodBeat.o(127474);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aic();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aic)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahn.EAK = ((aic)localObject1);
            paramInt += 1;
          }
          localahn.EAL = true;
          AppMethodBeat.o(127474);
          return 0;
        case 5: 
          localahn.iAC = ((f.a.a.a.a)localObject1).LVo.readString();
          localahn.EAQ = true;
          AppMethodBeat.o(127474);
          return 0;
        case 6: 
          localahn.title = ((f.a.a.a.a)localObject1).LVo.readString();
          localahn.EyY = true;
          AppMethodBeat.o(127474);
          return 0;
        case 7: 
          localahn.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          localahn.EyZ = true;
          AppMethodBeat.o(127474);
          return 0;
        case 8: 
          localahn.EAR = ((f.a.a.a.a)localObject1).LVo.xG();
          localahn.EAS = true;
          AppMethodBeat.o(127474);
          return 0;
        case 91: 
          localahn.EAT = ((f.a.a.a.a)localObject1).LVo.xF();
          localahn.EAU = true;
          AppMethodBeat.o(127474);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahn.EAM = ((ahm)localObject1);
            paramInt += 1;
          }
          localahn.EAN = true;
          AppMethodBeat.o(127474);
          return 0;
        case 11: 
          localahn.pmI = ((f.a.a.a.a)localObject1).LVo.xG();
          localahn.EAV = true;
          AppMethodBeat.o(127474);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahn.EAO = ((ahw)localObject1);
            paramInt += 1;
          }
          localahn.EAP = true;
          AppMethodBeat.o(127474);
          return 0;
        case 13: 
          localahn.version = ((f.a.a.a.a)localObject1).LVo.xF();
          localahn.EBM = true;
          AppMethodBeat.o(127474);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahn.DKz = ((ahh)localObject1);
            paramInt += 1;
          }
          localahn.EAW = true;
          AppMethodBeat.o(127474);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahn.EAX = ((agv)localObject1);
            paramInt += 1;
          }
          localahn.EAY = true;
          AppMethodBeat.o(127474);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahn.CoY = ((ahf)localObject1);
            paramInt += 1;
          }
          localahn.EAZ = true;
          AppMethodBeat.o(127474);
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
          localahn.EBc = ((anx)localObject1);
          paramInt += 1;
        }
        localahn.EBd = true;
        AppMethodBeat.o(127474);
        return 0;
      }
      AppMethodBeat.o(127474);
      return -1;
    }
  }
  
  public final ahn zW(long paramLong)
  {
    this.EAR = paramLong;
    this.EAS = true;
    return this;
  }
  
  public final ahn zX(long paramLong)
  {
    this.pmI = paramLong;
    this.EAV = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahn
 * JD-Core Version:    0.7.0.1
 */