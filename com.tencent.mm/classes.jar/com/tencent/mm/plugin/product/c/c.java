package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String AOl;
  public LinkedList<d> AZK;
  public int AZL;
  public int AZM;
  public int AZN;
  public LinkedList<String> AZO;
  public LinkedList<String> AZP;
  public LinkedList<b> AZQ;
  public LinkedList<String> AZR;
  public int AZS;
  public int AZT;
  public LinkedList<m> AZU;
  public LinkedList<a> AZV;
  public k AZW;
  public String detail;
  public String iAq;
  public String name;
  public int version;
  
  public c()
  {
    AppMethodBeat.i(91267);
    this.AZK = new LinkedList();
    this.AZO = new LinkedList();
    this.AZP = new LinkedList();
    this.AZQ = new LinkedList();
    this.AZR = new LinkedList();
    this.AZU = new LinkedList();
    this.AZV = new LinkedList();
    AppMethodBeat.o(91267);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91268);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      paramVarArgs.e(2, 8, this.AZK);
      paramVarArgs.aM(3, this.AZL);
      paramVarArgs.aM(4, this.AZM);
      paramVarArgs.aM(5, this.AZN);
      paramVarArgs.e(6, 1, this.AZO);
      if (this.iAq != null) {
        paramVarArgs.e(7, this.iAq);
      }
      if (this.detail != null) {
        paramVarArgs.e(8, this.detail);
      }
      paramVarArgs.e(9, 1, this.AZP);
      paramVarArgs.e(10, 8, this.AZQ);
      paramVarArgs.e(11, 1, this.AZR);
      paramVarArgs.aM(12, this.AZS);
      paramVarArgs.aM(13, this.AZT);
      paramVarArgs.e(14, 8, this.AZU);
      paramVarArgs.aM(15, this.version);
      paramVarArgs.e(16, 8, this.AZV);
      if (this.AOl != null) {
        paramVarArgs.e(17, this.AOl);
      }
      if (this.AZW != null)
      {
        paramVarArgs.ni(18, this.AZW.computeSize());
        this.AZW.writeFields(paramVarArgs);
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
    for (paramInt = g.a.a.b.b.a.f(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.AZK) + g.a.a.b.b.a.bu(3, this.AZL) + g.a.a.b.b.a.bu(4, this.AZM) + g.a.a.b.b.a.bu(5, this.AZN) + g.a.a.a.c(6, 1, this.AZO);
      paramInt = i;
      if (this.iAq != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.iAq);
      }
      i = paramInt;
      if (this.detail != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.detail);
      }
      i = i + g.a.a.a.c(9, 1, this.AZP) + g.a.a.a.c(10, 8, this.AZQ) + g.a.a.a.c(11, 1, this.AZR) + g.a.a.b.b.a.bu(12, this.AZS) + g.a.a.b.b.a.bu(13, this.AZT) + g.a.a.a.c(14, 8, this.AZU) + g.a.a.b.b.a.bu(15, this.version) + g.a.a.a.c(16, 8, this.AZV);
      paramInt = i;
      if (this.AOl != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.AOl);
      }
      i = paramInt;
      if (this.AZW != null) {
        i = paramInt + g.a.a.a.nh(18, this.AZW.computeSize());
      }
      AppMethodBeat.o(91268);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.AZK.clear();
        this.AZO.clear();
        this.AZP.clear();
        this.AZQ.clear();
        this.AZR.clear();
        this.AZU.clear();
        this.AZV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91268);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
          localc.name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localc.AZK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 3: 
          localc.AZL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91268);
          return 0;
        case 4: 
          localc.AZM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91268);
          return 0;
        case 5: 
          localc.AZN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91268);
          return 0;
        case 6: 
          localc.AZO.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 7: 
          localc.iAq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 8: 
          localc.detail = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 9: 
          localc.AZP.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localc.AZQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 11: 
          localc.AZR.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 12: 
          localc.AZS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91268);
          return 0;
        case 13: 
          localc.AZT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91268);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localc.AZU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 15: 
          localc.version = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91268);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localc.AZV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 17: 
          localc.AOl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91268);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localc.AZW = ((k)localObject1);
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