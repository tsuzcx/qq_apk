package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afz
  extends com.tencent.mm.bx.a
{
  public agg AWL;
  public agi Csh;
  public boolean DfS = false;
  public boolean DfT = false;
  public aga DhA;
  public boolean DhB = false;
  public agf DhC;
  public boolean DhD = false;
  public ahd DhE;
  public boolean DhF = false;
  public agn DhG;
  public boolean DhH = false;
  public agx DhI;
  public boolean DhJ = false;
  public boolean DhK = false;
  public long DhL;
  public boolean DhM = false;
  public int DhN = -1;
  public boolean DhO = false;
  public boolean DhP = false;
  public boolean DhQ = false;
  public afw DhR;
  public boolean DhS = false;
  public boolean DhT = false;
  public agg DhU;
  public boolean DhV = false;
  public ald DhW;
  public boolean DhX = false;
  public String desc;
  public String iaz;
  public long oJi;
  public String title;
  
  public final afz a(agn paramagn)
  {
    this.DhG = paramagn;
    this.DhH = true;
    return this;
  }
  
  public final afz a(agx paramagx)
  {
    this.DhI = paramagx;
    this.DhJ = true;
    return this;
  }
  
  public final afz a(ahd paramahd)
  {
    this.DhE = paramahd;
    this.DhF = true;
    return this;
  }
  
  public final afz b(afw paramafw)
  {
    this.DhR = paramafw;
    this.DhS = true;
    return this;
  }
  
  public final afz b(ald paramald)
  {
    this.DhW = paramald;
    this.DhX = true;
    return this;
  }
  
  public final afz c(aga paramaga)
  {
    this.DhA = paramaga;
    this.DhB = true;
    return this;
  }
  
  public final afz c(agf paramagf)
  {
    this.DhC = paramagf;
    this.DhD = true;
    return this;
  }
  
  public final afz d(agg paramagg)
  {
    this.AWL = paramagg;
    this.DhT = true;
    return this;
  }
  
  public final afz e(agg paramagg)
  {
    this.DhU = paramagg;
    this.DhV = true;
    return this;
  }
  
  public final aga eCm()
  {
    return this.DhA;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127458);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DhA != null)
      {
        paramVarArgs.kX(1, this.DhA.computeSize());
        this.DhA.writeFields(paramVarArgs);
      }
      if (this.DhC != null)
      {
        paramVarArgs.kX(2, this.DhC.computeSize());
        this.DhC.writeFields(paramVarArgs);
      }
      if (this.DhE != null)
      {
        paramVarArgs.kX(3, this.DhE.computeSize());
        this.DhE.writeFields(paramVarArgs);
      }
      if (this.DhG != null)
      {
        paramVarArgs.kX(4, this.DhG.computeSize());
        this.DhG.writeFields(paramVarArgs);
      }
      if (this.DhI != null)
      {
        paramVarArgs.kX(5, this.DhI.computeSize());
        this.DhI.writeFields(paramVarArgs);
      }
      if (this.iaz != null) {
        paramVarArgs.d(6, this.iaz);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(8, this.desc);
      }
      if (this.DhM == true) {
        paramVarArgs.aG(9, this.DhL);
      }
      if (this.DhO == true) {
        paramVarArgs.aR(101, this.DhN);
      }
      if (this.DhP == true) {
        paramVarArgs.aG(11, this.oJi);
      }
      if (this.Csh != null)
      {
        paramVarArgs.kX(12, this.Csh.computeSize());
        this.Csh.writeFields(paramVarArgs);
      }
      if (this.DhR != null)
      {
        paramVarArgs.kX(13, this.DhR.computeSize());
        this.DhR.writeFields(paramVarArgs);
      }
      if (this.AWL != null)
      {
        paramVarArgs.kX(14, this.AWL.computeSize());
        this.AWL.writeFields(paramVarArgs);
      }
      if (this.DhU != null)
      {
        paramVarArgs.kX(15, this.DhU.computeSize());
        this.DhU.writeFields(paramVarArgs);
      }
      if (this.DhW != null)
      {
        paramVarArgs.kX(16, this.DhW.computeSize());
        this.DhW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DhA == null) {
        break label2242;
      }
    }
    label2242:
    for (int i = f.a.a.a.kW(1, this.DhA.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DhC != null) {
        paramInt = i + f.a.a.a.kW(2, this.DhC.computeSize());
      }
      i = paramInt;
      if (this.DhE != null) {
        i = paramInt + f.a.a.a.kW(3, this.DhE.computeSize());
      }
      paramInt = i;
      if (this.DhG != null) {
        paramInt = i + f.a.a.a.kW(4, this.DhG.computeSize());
      }
      i = paramInt;
      if (this.DhI != null) {
        i = paramInt + f.a.a.a.kW(5, this.DhI.computeSize());
      }
      paramInt = i;
      if (this.iaz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iaz);
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
      if (this.DhM == true) {
        i = paramInt + f.a.a.b.b.a.q(9, this.DhL);
      }
      paramInt = i;
      if (this.DhO == true) {
        paramInt = i + f.a.a.b.b.a.bA(101, this.DhN);
      }
      i = paramInt;
      if (this.DhP == true) {
        i = paramInt + f.a.a.b.b.a.q(11, this.oJi);
      }
      paramInt = i;
      if (this.Csh != null) {
        paramInt = i + f.a.a.a.kW(12, this.Csh.computeSize());
      }
      i = paramInt;
      if (this.DhR != null) {
        i = paramInt + f.a.a.a.kW(13, this.DhR.computeSize());
      }
      paramInt = i;
      if (this.AWL != null) {
        paramInt = i + f.a.a.a.kW(14, this.AWL.computeSize());
      }
      i = paramInt;
      if (this.DhU != null) {
        i = paramInt + f.a.a.a.kW(15, this.DhU.computeSize());
      }
      paramInt = i;
      if (this.DhW != null) {
        paramInt = i + f.a.a.a.kW(16, this.DhW.computeSize());
      }
      AppMethodBeat.o(127458);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afz localafz = (afz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127458);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aga();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aga)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafz.DhA = ((aga)localObject1);
            paramInt += 1;
          }
          localafz.DhB = true;
          AppMethodBeat.o(127458);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafz.DhC = ((agf)localObject1);
            paramInt += 1;
          }
          localafz.DhD = true;
          AppMethodBeat.o(127458);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafz.DhE = ((ahd)localObject1);
            paramInt += 1;
          }
          localafz.DhF = true;
          AppMethodBeat.o(127458);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafz.DhG = ((agn)localObject1);
            paramInt += 1;
          }
          localafz.DhH = true;
          AppMethodBeat.o(127458);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafz.DhI = ((agx)localObject1);
            paramInt += 1;
          }
          localafz.DhJ = true;
          AppMethodBeat.o(127458);
          return 0;
        case 6: 
          localafz.iaz = ((f.a.a.a.a)localObject1).KhF.readString();
          localafz.DhK = true;
          AppMethodBeat.o(127458);
          return 0;
        case 7: 
          localafz.title = ((f.a.a.a.a)localObject1).KhF.readString();
          localafz.DfS = true;
          AppMethodBeat.o(127458);
          return 0;
        case 8: 
          localafz.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          localafz.DfT = true;
          AppMethodBeat.o(127458);
          return 0;
        case 9: 
          localafz.DhL = ((f.a.a.a.a)localObject1).KhF.xT();
          localafz.DhM = true;
          AppMethodBeat.o(127458);
          return 0;
        case 101: 
          localafz.DhN = ((f.a.a.a.a)localObject1).KhF.xS();
          localafz.DhO = true;
          AppMethodBeat.o(127458);
          return 0;
        case 11: 
          localafz.oJi = ((f.a.a.a.a)localObject1).KhF.xT();
          localafz.DhP = true;
          AppMethodBeat.o(127458);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafz.Csh = ((agi)localObject1);
            paramInt += 1;
          }
          localafz.DhQ = true;
          AppMethodBeat.o(127458);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafz.DhR = ((afw)localObject1);
            paramInt += 1;
          }
          localafz.DhS = true;
          AppMethodBeat.o(127458);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafz.AWL = ((agg)localObject1);
            paramInt += 1;
          }
          localafz.DhT = true;
          AppMethodBeat.o(127458);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafz.DhU = ((agg)localObject1);
            paramInt += 1;
          }
          localafz.DhV = true;
          AppMethodBeat.o(127458);
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
          localafz.DhW = ((ald)localObject1);
          paramInt += 1;
        }
        localafz.DhX = true;
        AppMethodBeat.o(127458);
        return 0;
      }
      AppMethodBeat.o(127458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afz
 * JD-Core Version:    0.7.0.1
 */