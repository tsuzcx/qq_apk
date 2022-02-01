package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bw.a
{
  public double BgI;
  public double BgJ;
  public double BgK;
  public String BgL;
  public LinkedList<t> BgM;
  public i BgN;
  public int BgO;
  public String BgP;
  public String BgQ;
  public double BgR;
  public double BgS;
  public int BgT;
  public String BgU;
  public String BgV;
  public a BgW;
  public LinkedList<g> BgX;
  public b BgY;
  
  public h()
  {
    AppMethodBeat.i(91292);
    this.BgM = new LinkedList();
    this.BgX = new LinkedList();
    AppMethodBeat.o(91292);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91293);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.BgI);
      paramVarArgs.e(2, this.BgJ);
      paramVarArgs.e(3, this.BgK);
      if (this.BgL != null) {
        paramVarArgs.d(4, this.BgL);
      }
      paramVarArgs.e(5, 8, this.BgM);
      if (this.BgN != null)
      {
        paramVarArgs.ln(6, this.BgN.computeSize());
        this.BgN.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.BgO);
      if (this.BgP != null) {
        paramVarArgs.d(8, this.BgP);
      }
      if (this.BgQ != null) {
        paramVarArgs.d(9, this.BgQ);
      }
      paramVarArgs.e(10, this.BgR);
      paramVarArgs.e(11, this.BgS);
      paramVarArgs.aR(12, this.BgT);
      if (this.BgU != null) {
        paramVarArgs.d(13, this.BgU);
      }
      if (this.BgV != null) {
        paramVarArgs.d(14, this.BgV);
      }
      if (this.BgW != null)
      {
        paramVarArgs.ln(15, this.BgW.computeSize());
        this.BgW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.BgX);
      if (this.BgY != null)
      {
        paramVarArgs.ln(17, this.BgY.computeSize());
        this.BgY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.fK(1) + 8 + 0 + (f.a.a.b.b.a.fK(2) + 8) + (f.a.a.b.b.a.fK(3) + 8);
      paramInt = i;
      if (this.BgL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.BgL);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.BgM);
      paramInt = i;
      if (this.BgN != null) {
        paramInt = i + f.a.a.a.lm(6, this.BgN.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.BgO);
      paramInt = i;
      if (this.BgP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.BgP);
      }
      i = paramInt;
      if (this.BgQ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.BgQ);
      }
      i = i + (f.a.a.b.b.a.fK(10) + 8) + (f.a.a.b.b.a.fK(11) + 8) + f.a.a.b.b.a.bx(12, this.BgT);
      paramInt = i;
      if (this.BgU != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.BgU);
      }
      i = paramInt;
      if (this.BgV != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.BgV);
      }
      paramInt = i;
      if (this.BgW != null) {
        paramInt = i + f.a.a.a.lm(15, this.BgW.computeSize());
      }
      i = paramInt + f.a.a.a.c(16, 8, this.BgX);
      paramInt = i;
      if (this.BgY != null) {
        paramInt = i + f.a.a.a.lm(17, this.BgY.computeSize());
      }
      AppMethodBeat.o(91293);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.BgM.clear();
      this.BgX.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localh.BgI = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(91293);
        return 0;
      case 2: 
        localh.BgJ = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(91293);
        return 0;
      case 3: 
        localh.BgK = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(91293);
        return 0;
      case 4: 
        localh.BgL = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.BgM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.BgN = ((i)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 7: 
        localh.BgO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91293);
        return 0;
      case 8: 
        localh.BgP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 9: 
        localh.BgQ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 10: 
        localh.BgR = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(91293);
        return 0;
      case 11: 
        localh.BgS = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(91293);
        return 0;
      case 12: 
        localh.BgT = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91293);
        return 0;
      case 13: 
        localh.BgU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 14: 
        localh.BgV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.BgW = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.BgX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new b();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localh.BgY = ((b)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    AppMethodBeat.o(91293);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.h
 * JD-Core Version:    0.7.0.1
 */