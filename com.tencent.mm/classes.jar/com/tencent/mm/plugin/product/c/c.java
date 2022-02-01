package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String detail;
  public String gKF;
  public String name;
  public String uop;
  public LinkedList<String> uwA;
  public LinkedList<b> uwB;
  public LinkedList<String> uwC;
  public int uwD;
  public int uwE;
  public LinkedList<m> uwF;
  public LinkedList<a> uwG;
  public k uwH;
  public LinkedList<d> uwv;
  public int uww;
  public int uwx;
  public int uwy;
  public LinkedList<String> uwz;
  public int version;
  
  public c()
  {
    AppMethodBeat.i(91267);
    this.uwv = new LinkedList();
    this.uwz = new LinkedList();
    this.uwA = new LinkedList();
    this.uwB = new LinkedList();
    this.uwC = new LinkedList();
    this.uwF = new LinkedList();
    this.uwG = new LinkedList();
    AppMethodBeat.o(91267);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91268);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      paramVarArgs.e(2, 8, this.uwv);
      paramVarArgs.aR(3, this.uww);
      paramVarArgs.aR(4, this.uwx);
      paramVarArgs.aR(5, this.uwy);
      paramVarArgs.e(6, 1, this.uwz);
      if (this.gKF != null) {
        paramVarArgs.d(7, this.gKF);
      }
      if (this.detail != null) {
        paramVarArgs.d(8, this.detail);
      }
      paramVarArgs.e(9, 1, this.uwA);
      paramVarArgs.e(10, 8, this.uwB);
      paramVarArgs.e(11, 1, this.uwC);
      paramVarArgs.aR(12, this.uwD);
      paramVarArgs.aR(13, this.uwE);
      paramVarArgs.e(14, 8, this.uwF);
      paramVarArgs.aR(15, this.version);
      paramVarArgs.e(16, 8, this.uwG);
      if (this.uop != null) {
        paramVarArgs.d(17, this.uop);
      }
      if (this.uwH != null)
      {
        paramVarArgs.kX(18, this.uwH.computeSize());
        this.uwH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91268);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label1546;
      }
    }
    label1546:
    for (paramInt = f.a.a.b.b.a.e(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.uwv) + f.a.a.b.b.a.bA(3, this.uww) + f.a.a.b.b.a.bA(4, this.uwx) + f.a.a.b.b.a.bA(5, this.uwy) + f.a.a.a.c(6, 1, this.uwz);
      paramInt = i;
      if (this.gKF != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.gKF);
      }
      i = paramInt;
      if (this.detail != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.detail);
      }
      i = i + f.a.a.a.c(9, 1, this.uwA) + f.a.a.a.c(10, 8, this.uwB) + f.a.a.a.c(11, 1, this.uwC) + f.a.a.b.b.a.bA(12, this.uwD) + f.a.a.b.b.a.bA(13, this.uwE) + f.a.a.a.c(14, 8, this.uwF) + f.a.a.b.b.a.bA(15, this.version) + f.a.a.a.c(16, 8, this.uwG);
      paramInt = i;
      if (this.uop != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.uop);
      }
      i = paramInt;
      if (this.uwH != null) {
        i = paramInt + f.a.a.a.kW(18, this.uwH.computeSize());
      }
      AppMethodBeat.o(91268);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uwv.clear();
        this.uwz.clear();
        this.uwA.clear();
        this.uwB.clear();
        this.uwC.clear();
        this.uwF.clear();
        this.uwG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91268);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91268);
          return -1;
        case 1: 
          localc.name = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.uwv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 3: 
          localc.uww = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91268);
          return 0;
        case 4: 
          localc.uwx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91268);
          return 0;
        case 5: 
          localc.uwy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91268);
          return 0;
        case 6: 
          localc.uwz.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 7: 
          localc.gKF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 8: 
          localc.detail = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 9: 
          localc.uwA.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.uwB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 11: 
          localc.uwC.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 12: 
          localc.uwD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91268);
          return 0;
        case 13: 
          localc.uwE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91268);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.uwF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 15: 
          localc.version = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91268);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.uwG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 17: 
          localc.uop = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91268);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.uwH = ((k)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91268);
        return 0;
      }
      AppMethodBeat.o(91268);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.c
 * JD-Core Version:    0.7.0.1
 */