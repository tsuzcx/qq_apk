package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bv.a
{
  public String detail;
  public String fjL;
  public String name;
  public String ppp;
  public LinkedList<d> puK;
  public int puL;
  public int puM;
  public int puN;
  public LinkedList<String> puO;
  public LinkedList<String> puP;
  public LinkedList<b> puQ;
  public LinkedList<String> puR;
  public int puS;
  public int puT;
  public LinkedList<m> puU;
  public LinkedList<a> puV;
  public k puW;
  public int version;
  
  public c()
  {
    AppMethodBeat.i(56624);
    this.puK = new LinkedList();
    this.puO = new LinkedList();
    this.puP = new LinkedList();
    this.puQ = new LinkedList();
    this.puR = new LinkedList();
    this.puU = new LinkedList();
    this.puV = new LinkedList();
    AppMethodBeat.o(56624);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56625);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      paramVarArgs.e(2, 8, this.puK);
      paramVarArgs.aO(3, this.puL);
      paramVarArgs.aO(4, this.puM);
      paramVarArgs.aO(5, this.puN);
      paramVarArgs.e(6, 1, this.puO);
      if (this.fjL != null) {
        paramVarArgs.e(7, this.fjL);
      }
      if (this.detail != null) {
        paramVarArgs.e(8, this.detail);
      }
      paramVarArgs.e(9, 1, this.puP);
      paramVarArgs.e(10, 8, this.puQ);
      paramVarArgs.e(11, 1, this.puR);
      paramVarArgs.aO(12, this.puS);
      paramVarArgs.aO(13, this.puT);
      paramVarArgs.e(14, 8, this.puU);
      paramVarArgs.aO(15, this.version);
      paramVarArgs.e(16, 8, this.puV);
      if (this.ppp != null) {
        paramVarArgs.e(17, this.ppp);
      }
      if (this.puW != null)
      {
        paramVarArgs.iQ(18, this.puW.computeSize());
        this.puW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56625);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label1546;
      }
    }
    label1546:
    for (paramInt = e.a.a.b.b.a.f(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.puK) + e.a.a.b.b.a.bl(3, this.puL) + e.a.a.b.b.a.bl(4, this.puM) + e.a.a.b.b.a.bl(5, this.puN) + e.a.a.a.c(6, 1, this.puO);
      paramInt = i;
      if (this.fjL != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.fjL);
      }
      i = paramInt;
      if (this.detail != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.detail);
      }
      i = i + e.a.a.a.c(9, 1, this.puP) + e.a.a.a.c(10, 8, this.puQ) + e.a.a.a.c(11, 1, this.puR) + e.a.a.b.b.a.bl(12, this.puS) + e.a.a.b.b.a.bl(13, this.puT) + e.a.a.a.c(14, 8, this.puU) + e.a.a.b.b.a.bl(15, this.version) + e.a.a.a.c(16, 8, this.puV);
      paramInt = i;
      if (this.ppp != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.ppp);
      }
      i = paramInt;
      if (this.puW != null) {
        i = paramInt + e.a.a.a.iP(18, this.puW.computeSize());
      }
      AppMethodBeat.o(56625);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.puK.clear();
        this.puO.clear();
        this.puP.clear();
        this.puQ.clear();
        this.puR.clear();
        this.puU.clear();
        this.puV.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56625);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56625);
          return -1;
        case 1: 
          localc.name = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56625);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localc.puK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56625);
          return 0;
        case 3: 
          localc.puL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56625);
          return 0;
        case 4: 
          localc.puM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56625);
          return 0;
        case 5: 
          localc.puN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56625);
          return 0;
        case 6: 
          localc.puO.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(56625);
          return 0;
        case 7: 
          localc.fjL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56625);
          return 0;
        case 8: 
          localc.detail = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56625);
          return 0;
        case 9: 
          localc.puP.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(56625);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localc.puQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56625);
          return 0;
        case 11: 
          localc.puR.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(56625);
          return 0;
        case 12: 
          localc.puS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56625);
          return 0;
        case 13: 
          localc.puT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56625);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localc.puU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56625);
          return 0;
        case 15: 
          localc.version = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56625);
          return 0;
        case 16: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localc.puV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56625);
          return 0;
        case 17: 
          localc.ppp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56625);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localc.puW = ((k)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56625);
        return 0;
      }
      AppMethodBeat.o(56625);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.c
 * JD-Core Version:    0.7.0.1
 */