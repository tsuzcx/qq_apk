package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ago
  extends com.tencent.mm.bx.a
{
  public agg AWL;
  public agi Csh;
  public boolean DfS;
  public boolean DfT;
  public agf DhC;
  public boolean DhD;
  public ahd DhE;
  public boolean DhF;
  public agn DhG;
  public boolean DhH;
  public agx DhI;
  public boolean DhJ;
  public boolean DhK;
  public long DhL;
  public boolean DhM;
  public int DhN;
  public boolean DhO;
  public boolean DhP;
  public boolean DhQ;
  public afw DhR;
  public boolean DhS;
  public boolean DhT;
  public ald DhW;
  public boolean DhX;
  public agu DiD;
  public boolean DiE;
  public boolean DiF;
  public boolean DiG;
  public String desc;
  public String iaz;
  public LinkedList<afy> mVb;
  public long oJi;
  public String title;
  public int version;
  
  public ago()
  {
    AppMethodBeat.i(127473);
    this.DiE = false;
    this.mVb = new LinkedList();
    this.DiF = false;
    this.DhD = false;
    this.DhF = false;
    this.DhK = false;
    this.DfS = false;
    this.DfT = false;
    this.DhM = false;
    this.DhN = -1;
    this.DhO = false;
    this.DhH = false;
    this.DhP = false;
    this.DhJ = false;
    this.DiG = false;
    this.DhQ = false;
    this.DhS = false;
    this.DhT = false;
    this.DhX = false;
    AppMethodBeat.o(127473);
  }
  
  public final ago VK(int paramInt)
  {
    this.DhN = paramInt;
    this.DhO = true;
    return this;
  }
  
  public final ago VL(int paramInt)
  {
    this.version = paramInt;
    this.DiG = true;
    return this;
  }
  
  public final ago a(agi paramagi)
  {
    this.Csh = paramagi;
    this.DhQ = true;
    return this;
  }
  
  public final ago a(agu paramagu)
  {
    this.DiD = paramagu;
    this.DiE = true;
    return this;
  }
  
  public final ago aEi(String paramString)
  {
    this.iaz = paramString;
    this.DhK = true;
    return this;
  }
  
  public final ago aEj(String paramString)
  {
    this.title = paramString;
    this.DfS = true;
    return this;
  }
  
  public final ago aEk(String paramString)
  {
    this.desc = paramString;
    this.DfT = true;
    return this;
  }
  
  public final ago b(agn paramagn)
  {
    this.DhG = paramagn;
    this.DhH = true;
    return this;
  }
  
  public final ago b(agx paramagx)
  {
    this.DhI = paramagx;
    this.DhJ = true;
    return this;
  }
  
  public final ago b(ahd paramahd)
  {
    this.DhE = paramahd;
    this.DhF = true;
    return this;
  }
  
  public final ago bd(LinkedList<afy> paramLinkedList)
  {
    this.mVb = paramLinkedList;
    this.DiF = true;
    return this;
  }
  
  public final ago c(afw paramafw)
  {
    this.DhR = paramafw;
    this.DhS = true;
    return this;
  }
  
  public final ago c(ald paramald)
  {
    this.DhW = paramald;
    this.DhX = true;
    return this;
  }
  
  public final ago d(agf paramagf)
  {
    this.DhC = paramagf;
    this.DhD = true;
    return this;
  }
  
  public final ald eCo()
  {
    return this.DhW;
  }
  
  public final ago f(agg paramagg)
  {
    this.AWL = paramagg;
    this.DhT = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127474);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DiD != null)
      {
        paramVarArgs.kX(1, this.DiD.computeSize());
        this.DiD.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.mVb);
      if (this.DhC != null)
      {
        paramVarArgs.kX(3, this.DhC.computeSize());
        this.DhC.writeFields(paramVarArgs);
      }
      if (this.DhE != null)
      {
        paramVarArgs.kX(4, this.DhE.computeSize());
        this.DhE.writeFields(paramVarArgs);
      }
      if (this.iaz != null) {
        paramVarArgs.d(5, this.iaz);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(7, this.desc);
      }
      if (this.DhM == true) {
        paramVarArgs.aG(8, this.DhL);
      }
      if (this.DhO == true) {
        paramVarArgs.aR(91, this.DhN);
      }
      if (this.DhG != null)
      {
        paramVarArgs.kX(10, this.DhG.computeSize());
        this.DhG.writeFields(paramVarArgs);
      }
      if (this.DhP == true) {
        paramVarArgs.aG(11, this.oJi);
      }
      if (this.DhI != null)
      {
        paramVarArgs.kX(12, this.DhI.computeSize());
        this.DhI.writeFields(paramVarArgs);
      }
      if (this.DiG == true) {
        paramVarArgs.aR(13, this.version);
      }
      if (this.Csh != null)
      {
        paramVarArgs.kX(14, this.Csh.computeSize());
        this.Csh.writeFields(paramVarArgs);
      }
      if (this.DhR != null)
      {
        paramVarArgs.kX(15, this.DhR.computeSize());
        this.DhR.writeFields(paramVarArgs);
      }
      if (this.AWL != null)
      {
        paramVarArgs.kX(16, this.AWL.computeSize());
        this.AWL.writeFields(paramVarArgs);
      }
      if (this.DhW != null)
      {
        paramVarArgs.kX(17, this.DhW.computeSize());
        this.DhW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DiD == null) {
        break label2300;
      }
    }
    label2300:
    for (paramInt = f.a.a.a.kW(1, this.DiD.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.mVb);
      paramInt = i;
      if (this.DhC != null) {
        paramInt = i + f.a.a.a.kW(3, this.DhC.computeSize());
      }
      i = paramInt;
      if (this.DhE != null) {
        i = paramInt + f.a.a.a.kW(4, this.DhE.computeSize());
      }
      paramInt = i;
      if (this.iaz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.iaz);
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
      if (this.DhM == true) {
        i = paramInt + f.a.a.b.b.a.q(8, this.DhL);
      }
      paramInt = i;
      if (this.DhO == true) {
        paramInt = i + f.a.a.b.b.a.bA(91, this.DhN);
      }
      i = paramInt;
      if (this.DhG != null) {
        i = paramInt + f.a.a.a.kW(10, this.DhG.computeSize());
      }
      paramInt = i;
      if (this.DhP == true) {
        paramInt = i + f.a.a.b.b.a.q(11, this.oJi);
      }
      i = paramInt;
      if (this.DhI != null) {
        i = paramInt + f.a.a.a.kW(12, this.DhI.computeSize());
      }
      paramInt = i;
      if (this.DiG == true) {
        paramInt = i + f.a.a.b.b.a.bA(13, this.version);
      }
      i = paramInt;
      if (this.Csh != null) {
        i = paramInt + f.a.a.a.kW(14, this.Csh.computeSize());
      }
      paramInt = i;
      if (this.DhR != null) {
        paramInt = i + f.a.a.a.kW(15, this.DhR.computeSize());
      }
      i = paramInt;
      if (this.AWL != null) {
        i = paramInt + f.a.a.a.kW(16, this.AWL.computeSize());
      }
      paramInt = i;
      if (this.DhW != null) {
        paramInt = i + f.a.a.a.kW(17, this.DhW.computeSize());
      }
      AppMethodBeat.o(127474);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mVb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ago localago = (ago)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127474);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localago.DiD = ((agu)localObject1);
            paramInt += 1;
          }
          localago.DiE = true;
          AppMethodBeat.o(127474);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localago.mVb.add(localObject1);
            paramInt += 1;
          }
          localago.DiF = true;
          AppMethodBeat.o(127474);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localago.DhC = ((agf)localObject1);
            paramInt += 1;
          }
          localago.DhD = true;
          AppMethodBeat.o(127474);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localago.DhE = ((ahd)localObject1);
            paramInt += 1;
          }
          localago.DhF = true;
          AppMethodBeat.o(127474);
          return 0;
        case 5: 
          localago.iaz = ((f.a.a.a.a)localObject1).KhF.readString();
          localago.DhK = true;
          AppMethodBeat.o(127474);
          return 0;
        case 6: 
          localago.title = ((f.a.a.a.a)localObject1).KhF.readString();
          localago.DfS = true;
          AppMethodBeat.o(127474);
          return 0;
        case 7: 
          localago.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          localago.DfT = true;
          AppMethodBeat.o(127474);
          return 0;
        case 8: 
          localago.DhL = ((f.a.a.a.a)localObject1).KhF.xT();
          localago.DhM = true;
          AppMethodBeat.o(127474);
          return 0;
        case 91: 
          localago.DhN = ((f.a.a.a.a)localObject1).KhF.xS();
          localago.DhO = true;
          AppMethodBeat.o(127474);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localago.DhG = ((agn)localObject1);
            paramInt += 1;
          }
          localago.DhH = true;
          AppMethodBeat.o(127474);
          return 0;
        case 11: 
          localago.oJi = ((f.a.a.a.a)localObject1).KhF.xT();
          localago.DhP = true;
          AppMethodBeat.o(127474);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localago.DhI = ((agx)localObject1);
            paramInt += 1;
          }
          localago.DhJ = true;
          AppMethodBeat.o(127474);
          return 0;
        case 13: 
          localago.version = ((f.a.a.a.a)localObject1).KhF.xS();
          localago.DiG = true;
          AppMethodBeat.o(127474);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localago.Csh = ((agi)localObject1);
            paramInt += 1;
          }
          localago.DhQ = true;
          AppMethodBeat.o(127474);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localago.DhR = ((afw)localObject1);
            paramInt += 1;
          }
          localago.DhS = true;
          AppMethodBeat.o(127474);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localago.AWL = ((agg)localObject1);
            paramInt += 1;
          }
          localago.DhT = true;
          AppMethodBeat.o(127474);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ald();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ald)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localago.DhW = ((ald)localObject1);
          paramInt += 1;
        }
        localago.DhX = true;
        AppMethodBeat.o(127474);
        return 0;
      }
      AppMethodBeat.o(127474);
      return -1;
    }
  }
  
  public final ago vt(long paramLong)
  {
    this.DhL = paramLong;
    this.DhM = true;
    return this;
  }
  
  public final ago vu(long paramLong)
  {
    this.oJi = paramLong;
    this.DhP = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ago
 * JD-Core Version:    0.7.0.1
 */