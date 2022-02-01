package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String detail;
  public String hDo;
  public String name;
  public int version;
  public String wCF;
  public LinkedList<b> wMA;
  public LinkedList<String> wMB;
  public int wMC;
  public int wMD;
  public LinkedList<m> wME;
  public LinkedList<a> wMF;
  public k wMG;
  public LinkedList<d> wMu;
  public int wMv;
  public int wMw;
  public int wMx;
  public LinkedList<String> wMy;
  public LinkedList<String> wMz;
  
  public c()
  {
    AppMethodBeat.i(91267);
    this.wMu = new LinkedList();
    this.wMy = new LinkedList();
    this.wMz = new LinkedList();
    this.wMA = new LinkedList();
    this.wMB = new LinkedList();
    this.wME = new LinkedList();
    this.wMF = new LinkedList();
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
      paramVarArgs.e(2, 8, this.wMu);
      paramVarArgs.aS(3, this.wMv);
      paramVarArgs.aS(4, this.wMw);
      paramVarArgs.aS(5, this.wMx);
      paramVarArgs.e(6, 1, this.wMy);
      if (this.hDo != null) {
        paramVarArgs.d(7, this.hDo);
      }
      if (this.detail != null) {
        paramVarArgs.d(8, this.detail);
      }
      paramVarArgs.e(9, 1, this.wMz);
      paramVarArgs.e(10, 8, this.wMA);
      paramVarArgs.e(11, 1, this.wMB);
      paramVarArgs.aS(12, this.wMC);
      paramVarArgs.aS(13, this.wMD);
      paramVarArgs.e(14, 8, this.wME);
      paramVarArgs.aS(15, this.version);
      paramVarArgs.e(16, 8, this.wMF);
      if (this.wCF != null) {
        paramVarArgs.d(17, this.wCF);
      }
      if (this.wMG != null)
      {
        paramVarArgs.lC(18, this.wMG.computeSize());
        this.wMG.writeFields(paramVarArgs);
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
      int i = paramInt + f.a.a.a.c(2, 8, this.wMu) + f.a.a.b.b.a.bz(3, this.wMv) + f.a.a.b.b.a.bz(4, this.wMw) + f.a.a.b.b.a.bz(5, this.wMx) + f.a.a.a.c(6, 1, this.wMy);
      paramInt = i;
      if (this.hDo != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hDo);
      }
      i = paramInt;
      if (this.detail != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.detail);
      }
      i = i + f.a.a.a.c(9, 1, this.wMz) + f.a.a.a.c(10, 8, this.wMA) + f.a.a.a.c(11, 1, this.wMB) + f.a.a.b.b.a.bz(12, this.wMC) + f.a.a.b.b.a.bz(13, this.wMD) + f.a.a.a.c(14, 8, this.wME) + f.a.a.b.b.a.bz(15, this.version) + f.a.a.a.c(16, 8, this.wMF);
      paramInt = i;
      if (this.wCF != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.wCF);
      }
      i = paramInt;
      if (this.wMG != null) {
        i = paramInt + f.a.a.a.lB(18, this.wMG.computeSize());
      }
      AppMethodBeat.o(91268);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wMu.clear();
        this.wMy.clear();
        this.wMz.clear();
        this.wMA.clear();
        this.wMB.clear();
        this.wME.clear();
        this.wMF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          localc.name = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.wMu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 3: 
          localc.wMv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 4: 
          localc.wMw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 5: 
          localc.wMx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 6: 
          localc.wMy.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 7: 
          localc.hDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 8: 
          localc.detail = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 9: 
          localc.wMz.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.wMA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 11: 
          localc.wMB.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 12: 
          localc.wMC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 13: 
          localc.wMD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.wME.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 15: 
          localc.version = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.wMF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 17: 
          localc.wCF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91268);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.wMG = ((k)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.c
 * JD-Core Version:    0.7.0.1
 */