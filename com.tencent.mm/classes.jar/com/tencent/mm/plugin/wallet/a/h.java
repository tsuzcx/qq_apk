package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bw.a
{
  public double CYC;
  public double CYD;
  public double CYE;
  public String CYF;
  public LinkedList<t> CYG;
  public i CYH;
  public int CYI;
  public String CYJ;
  public String CYK;
  public double CYL;
  public double CYM;
  public int CYN;
  public String CYO;
  public String CYP;
  public a CYQ;
  public LinkedList<g> CYR;
  public b CYS;
  
  public h()
  {
    AppMethodBeat.i(91292);
    this.CYG = new LinkedList();
    this.CYR = new LinkedList();
    AppMethodBeat.o(91292);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91293);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.CYC);
      paramVarArgs.e(2, this.CYD);
      paramVarArgs.e(3, this.CYE);
      if (this.CYF != null) {
        paramVarArgs.d(4, this.CYF);
      }
      paramVarArgs.e(5, 8, this.CYG);
      if (this.CYH != null)
      {
        paramVarArgs.lJ(6, this.CYH.computeSize());
        this.CYH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.CYI);
      if (this.CYJ != null) {
        paramVarArgs.d(8, this.CYJ);
      }
      if (this.CYK != null) {
        paramVarArgs.d(9, this.CYK);
      }
      paramVarArgs.e(10, this.CYL);
      paramVarArgs.e(11, this.CYM);
      paramVarArgs.aS(12, this.CYN);
      if (this.CYO != null) {
        paramVarArgs.d(13, this.CYO);
      }
      if (this.CYP != null) {
        paramVarArgs.d(14, this.CYP);
      }
      if (this.CYQ != null)
      {
        paramVarArgs.lJ(15, this.CYQ.computeSize());
        this.CYQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.CYR);
      if (this.CYS != null)
      {
        paramVarArgs.lJ(17, this.CYS.computeSize());
        this.CYS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.amD(1) + 0 + f.a.a.b.b.a.amD(2) + f.a.a.b.b.a.amD(3);
      paramInt = i;
      if (this.CYF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CYF);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.CYG);
      paramInt = i;
      if (this.CYH != null) {
        paramInt = i + f.a.a.a.lI(6, this.CYH.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.CYI);
      paramInt = i;
      if (this.CYJ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CYJ);
      }
      i = paramInt;
      if (this.CYK != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CYK);
      }
      i = i + f.a.a.b.b.a.amD(10) + f.a.a.b.b.a.amD(11) + f.a.a.b.b.a.bz(12, this.CYN);
      paramInt = i;
      if (this.CYO != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CYO);
      }
      i = paramInt;
      if (this.CYP != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.CYP);
      }
      paramInt = i;
      if (this.CYQ != null) {
        paramInt = i + f.a.a.a.lI(15, this.CYQ.computeSize());
      }
      i = paramInt + f.a.a.a.c(16, 8, this.CYR);
      paramInt = i;
      if (this.CYS != null) {
        paramInt = i + f.a.a.a.lI(17, this.CYS.computeSize());
      }
      AppMethodBeat.o(91293);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CYG.clear();
      this.CYR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91293);
        return -1;
      case 1: 
        localh.CYC = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(91293);
        return 0;
      case 2: 
        localh.CYD = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(91293);
        return 0;
      case 3: 
        localh.CYE = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(91293);
        return 0;
      case 4: 
        localh.CYF = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.CYG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.CYH = ((i)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 7: 
        localh.CYI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91293);
        return 0;
      case 8: 
        localh.CYJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 9: 
        localh.CYK = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 10: 
        localh.CYL = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(91293);
        return 0;
      case 11: 
        localh.CYM = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(91293);
        return 0;
      case 12: 
        localh.CYN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91293);
        return 0;
      case 13: 
        localh.CYO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 14: 
        localh.CYP = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.CYQ = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.CYR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new b();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localh.CYS = ((b)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    AppMethodBeat.o(91293);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.h
 * JD-Core Version:    0.7.0.1
 */