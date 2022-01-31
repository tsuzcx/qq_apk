package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class csu
  extends com.tencent.mm.bv.a
{
  public int nNv;
  public cta xZX;
  public cta xZY;
  public int ybA;
  public int ybB;
  public int ybC;
  public int ybD;
  public SKBuiltinBuffer_t ybE;
  public SKBuiltinBuffer_t ybF;
  public int ybG;
  public SKBuiltinBuffer_t ybH;
  public int ybI;
  public int ybJ;
  public int ybK;
  public ayd ybL;
  public SKBuiltinBuffer_t ybM;
  public int ybN;
  public String ybO;
  public int ybP;
  public LinkedList<csv> ybQ;
  public int ybo;
  public crn ybp;
  public crn ybq;
  public int ybr;
  public int ybs;
  public int ybt;
  public int ybu;
  public SKBuiltinBuffer_t ybv;
  public int ybw;
  public crn ybx;
  public int yby;
  public int ybz;
  
  public csu()
  {
    AppMethodBeat.i(5253);
    this.ybQ = new LinkedList();
    AppMethodBeat.o(5253);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5254);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xZX == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(5254);
        throw paramVarArgs;
      }
      if (this.xZY == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(5254);
        throw paramVarArgs;
      }
      if (this.xZX != null)
      {
        paramVarArgs.iQ(1, this.xZX.computeSize());
        this.xZX.writeFields(paramVarArgs);
      }
      if (this.xZY != null)
      {
        paramVarArgs.iQ(2, this.xZY.computeSize());
        this.xZY.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.ybo);
      if (this.ybp != null)
      {
        paramVarArgs.iQ(4, this.ybp.computeSize());
        this.ybp.writeFields(paramVarArgs);
      }
      if (this.ybq != null)
      {
        paramVarArgs.iQ(5, this.ybq.computeSize());
        this.ybq.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.ybr);
      paramVarArgs.aO(7, this.ybs);
      paramVarArgs.aO(8, this.ybt);
      paramVarArgs.aO(9, this.ybu);
      if (this.ybv != null)
      {
        paramVarArgs.iQ(10, this.ybv.computeSize());
        this.ybv.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(11, this.ybw);
      if (this.ybx != null)
      {
        paramVarArgs.iQ(12, this.ybx.computeSize());
        this.ybx.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(13, this.yby);
      paramVarArgs.aO(14, this.ybz);
      paramVarArgs.aO(15, this.ybA);
      paramVarArgs.aO(16, this.ybB);
      paramVarArgs.aO(17, this.ybC);
      paramVarArgs.aO(18, this.nNv);
      paramVarArgs.aO(19, this.ybD);
      if (this.ybE != null)
      {
        paramVarArgs.iQ(20, this.ybE.computeSize());
        this.ybE.writeFields(paramVarArgs);
      }
      if (this.ybF != null)
      {
        paramVarArgs.iQ(21, this.ybF.computeSize());
        this.ybF.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(22, this.ybG);
      if (this.ybH != null)
      {
        paramVarArgs.iQ(23, this.ybH.computeSize());
        this.ybH.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(24, this.ybI);
      paramVarArgs.aO(25, this.ybJ);
      paramVarArgs.aO(26, this.ybK);
      if (this.ybL != null)
      {
        paramVarArgs.iQ(27, this.ybL.computeSize());
        this.ybL.writeFields(paramVarArgs);
      }
      if (this.ybM != null)
      {
        paramVarArgs.iQ(28, this.ybM.computeSize());
        this.ybM.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(29, this.ybN);
      if (this.ybO != null) {
        paramVarArgs.e(30, this.ybO);
      }
      paramVarArgs.aO(31, this.ybP);
      paramVarArgs.e(32, 8, this.ybQ);
      AppMethodBeat.o(5254);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xZX == null) {
        break label3060;
      }
    }
    label3060:
    for (paramInt = e.a.a.a.iP(1, this.xZX.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xZY != null) {
        i = paramInt + e.a.a.a.iP(2, this.xZY.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.ybo);
      paramInt = i;
      if (this.ybp != null) {
        paramInt = i + e.a.a.a.iP(4, this.ybp.computeSize());
      }
      i = paramInt;
      if (this.ybq != null) {
        i = paramInt + e.a.a.a.iP(5, this.ybq.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(6, this.ybr) + e.a.a.b.b.a.bl(7, this.ybs) + e.a.a.b.b.a.bl(8, this.ybt) + e.a.a.b.b.a.bl(9, this.ybu);
      paramInt = i;
      if (this.ybv != null) {
        paramInt = i + e.a.a.a.iP(10, this.ybv.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.ybw);
      paramInt = i;
      if (this.ybx != null) {
        paramInt = i + e.a.a.a.iP(12, this.ybx.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(13, this.yby) + e.a.a.b.b.a.bl(14, this.ybz) + e.a.a.b.b.a.bl(15, this.ybA) + e.a.a.b.b.a.bl(16, this.ybB) + e.a.a.b.b.a.bl(17, this.ybC) + e.a.a.b.b.a.bl(18, this.nNv) + e.a.a.b.b.a.bl(19, this.ybD);
      paramInt = i;
      if (this.ybE != null) {
        paramInt = i + e.a.a.a.iP(20, this.ybE.computeSize());
      }
      i = paramInt;
      if (this.ybF != null) {
        i = paramInt + e.a.a.a.iP(21, this.ybF.computeSize());
      }
      i += e.a.a.b.b.a.bl(22, this.ybG);
      paramInt = i;
      if (this.ybH != null) {
        paramInt = i + e.a.a.a.iP(23, this.ybH.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(24, this.ybI) + e.a.a.b.b.a.bl(25, this.ybJ) + e.a.a.b.b.a.bl(26, this.ybK);
      paramInt = i;
      if (this.ybL != null) {
        paramInt = i + e.a.a.a.iP(27, this.ybL.computeSize());
      }
      i = paramInt;
      if (this.ybM != null) {
        i = paramInt + e.a.a.a.iP(28, this.ybM.computeSize());
      }
      i += e.a.a.b.b.a.bl(29, this.ybN);
      paramInt = i;
      if (this.ybO != null) {
        paramInt = i + e.a.a.b.b.a.f(30, this.ybO);
      }
      i = e.a.a.b.b.a.bl(31, this.ybP);
      int j = e.a.a.a.c(32, 8, this.ybQ);
      AppMethodBeat.o(5254);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ybQ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xZX == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(5254);
          throw paramVarArgs;
        }
        if (this.xZY == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(5254);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5254);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        csu localcsu = (csu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5254);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cta();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsu.xZX = ((cta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5254);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cta();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsu.xZY = ((cta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5254);
          return 0;
        case 3: 
          localcsu.ybo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsu.ybp = ((crn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5254);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsu.ybq = ((crn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5254);
          return 0;
        case 6: 
          localcsu.ybr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 7: 
          localcsu.ybs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 8: 
          localcsu.ybt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 9: 
          localcsu.ybu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsu.ybv = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5254);
          return 0;
        case 11: 
          localcsu.ybw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsu.ybx = ((crn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5254);
          return 0;
        case 13: 
          localcsu.yby = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 14: 
          localcsu.ybz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 15: 
          localcsu.ybA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 16: 
          localcsu.ybB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 17: 
          localcsu.ybC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 18: 
          localcsu.nNv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 19: 
          localcsu.ybD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 20: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsu.ybE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5254);
          return 0;
        case 21: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsu.ybF = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5254);
          return 0;
        case 22: 
          localcsu.ybG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 23: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsu.ybH = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5254);
          return 0;
        case 24: 
          localcsu.ybI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 25: 
          localcsu.ybJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 26: 
          localcsu.ybK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 27: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ayd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ayd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsu.ybL = ((ayd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5254);
          return 0;
        case 28: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsu.ybM = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5254);
          return 0;
        case 29: 
          localcsu.ybN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        case 30: 
          localcsu.ybO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5254);
          return 0;
        case 31: 
          localcsu.ybP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5254);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csv();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcsu.ybQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5254);
        return 0;
      }
      AppMethodBeat.o(5254);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csu
 * JD-Core Version:    0.7.0.1
 */