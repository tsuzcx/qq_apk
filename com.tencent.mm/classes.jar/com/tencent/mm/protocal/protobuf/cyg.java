package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyg
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public int jKs;
  public String wBZ;
  public String wXt;
  public int wzS;
  public String xFD;
  public int xHM;
  public int xHQ;
  public int xIl;
  public int xTB;
  public int xpG;
  public String xpJ;
  public int xqT;
  public azu xqU;
  public String xvO;
  public LinkedList<up> yel;
  public String yfm;
  public LinkedList<String> yfn;
  public int yfo;
  
  public cyg()
  {
    AppMethodBeat.i(124379);
    this.xpG = 2;
    this.yel = new LinkedList();
    this.yfn = new LinkedList();
    AppMethodBeat.o(124379);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124380);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wzS);
      paramVarArgs.aO(2, this.xqT);
      paramVarArgs.aO(3, this.xHM);
      if (this.wXt != null) {
        paramVarArgs.e(4, this.wXt);
      }
      if (this.xqU != null)
      {
        paramVarArgs.iQ(5, this.xqU.computeSize());
        this.xqU.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.Scene);
      if (this.wBZ != null) {
        paramVarArgs.e(7, this.wBZ);
      }
      paramVarArgs.aO(8, this.xHQ);
      paramVarArgs.aO(9, this.xpG);
      paramVarArgs.e(10, 8, this.yel);
      if (this.xpJ != null) {
        paramVarArgs.e(11, this.xpJ);
      }
      if (this.xvO != null) {
        paramVarArgs.e(12, this.xvO);
      }
      paramVarArgs.aO(13, this.xTB);
      if (this.yfm != null) {
        paramVarArgs.e(14, this.yfm);
      }
      if (this.xFD != null) {
        paramVarArgs.e(15, this.xFD);
      }
      paramVarArgs.e(16, 1, this.yfn);
      paramVarArgs.aO(17, this.xIl);
      paramVarArgs.aO(18, this.jKs);
      paramVarArgs.aO(19, this.yfo);
      AppMethodBeat.o(124380);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wzS) + 0 + e.a.a.b.b.a.bl(2, this.xqT) + e.a.a.b.b.a.bl(3, this.xHM);
      paramInt = i;
      if (this.wXt != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wXt);
      }
      i = paramInt;
      if (this.xqU != null) {
        i = paramInt + e.a.a.a.iP(5, this.xqU.computeSize());
      }
      i += e.a.a.b.b.a.bl(6, this.Scene);
      paramInt = i;
      if (this.wBZ != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wBZ);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.xHQ) + e.a.a.b.b.a.bl(9, this.xpG) + e.a.a.a.c(10, 8, this.yel);
      paramInt = i;
      if (this.xpJ != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xpJ);
      }
      i = paramInt;
      if (this.xvO != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.xvO);
      }
      i += e.a.a.b.b.a.bl(13, this.xTB);
      paramInt = i;
      if (this.yfm != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.yfm);
      }
      i = paramInt;
      if (this.xFD != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.xFD);
      }
      paramInt = e.a.a.a.c(16, 1, this.yfn);
      int j = e.a.a.b.b.a.bl(17, this.xIl);
      int k = e.a.a.b.b.a.bl(18, this.jKs);
      int m = e.a.a.b.b.a.bl(19, this.yfo);
      AppMethodBeat.o(124380);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.yel.clear();
      this.yfn.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(124380);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cyg localcyg = (cyg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124380);
        return -1;
      case 1: 
        localcyg.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124380);
        return 0;
      case 2: 
        localcyg.xqT = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124380);
        return 0;
      case 3: 
        localcyg.xHM = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124380);
        return 0;
      case 4: 
        localcyg.wXt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124380);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azu();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcyg.xqU = ((azu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124380);
        return 0;
      case 6: 
        localcyg.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124380);
        return 0;
      case 7: 
        localcyg.wBZ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124380);
        return 0;
      case 8: 
        localcyg.xHQ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124380);
        return 0;
      case 9: 
        localcyg.xpG = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124380);
        return 0;
      case 10: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new up();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((up)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcyg.yel.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124380);
        return 0;
      case 11: 
        localcyg.xpJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124380);
        return 0;
      case 12: 
        localcyg.xvO = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124380);
        return 0;
      case 13: 
        localcyg.xTB = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124380);
        return 0;
      case 14: 
        localcyg.yfm = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124380);
        return 0;
      case 15: 
        localcyg.xFD = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124380);
        return 0;
      case 16: 
        localcyg.yfn.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(124380);
        return 0;
      case 17: 
        localcyg.xIl = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124380);
        return 0;
      case 18: 
        localcyg.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124380);
        return 0;
      }
      localcyg.yfo = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(124380);
      return 0;
    }
    AppMethodBeat.o(124380);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyg
 * JD-Core Version:    0.7.0.1
 */