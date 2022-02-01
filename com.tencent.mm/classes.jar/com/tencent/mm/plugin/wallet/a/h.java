package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bw.a
{
  public double HEA;
  public int HEB;
  public String HEC;
  public String HED;
  public a HEE;
  public LinkedList<g> HEF;
  public b HEG;
  public double HEq;
  public double HEr;
  public double HEs;
  public String HEt;
  public LinkedList<t> HEu;
  public i HEv;
  public int HEw;
  public String HEx;
  public String HEy;
  public double HEz;
  
  public h()
  {
    AppMethodBeat.i(91292);
    this.HEu = new LinkedList();
    this.HEF = new LinkedList();
    AppMethodBeat.o(91292);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91293);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.HEq);
      paramVarArgs.e(2, this.HEr);
      paramVarArgs.e(3, this.HEs);
      if (this.HEt != null) {
        paramVarArgs.e(4, this.HEt);
      }
      paramVarArgs.e(5, 8, this.HEu);
      if (this.HEv != null)
      {
        paramVarArgs.ni(6, this.HEv.computeSize());
        this.HEv.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.HEw);
      if (this.HEx != null) {
        paramVarArgs.e(8, this.HEx);
      }
      if (this.HEy != null) {
        paramVarArgs.e(9, this.HEy);
      }
      paramVarArgs.e(10, this.HEz);
      paramVarArgs.e(11, this.HEA);
      paramVarArgs.aM(12, this.HEB);
      if (this.HEC != null) {
        paramVarArgs.e(13, this.HEC);
      }
      if (this.HED != null) {
        paramVarArgs.e(14, this.HED);
      }
      if (this.HEE != null)
      {
        paramVarArgs.ni(15, this.HEE.computeSize());
        this.HEE.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.HEF);
      if (this.HEG != null)
      {
        paramVarArgs.ni(17, this.HEG.computeSize());
        this.HEG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.fS(1) + 8 + 0 + (g.a.a.b.b.a.fS(2) + 8) + (g.a.a.b.b.a.fS(3) + 8);
      paramInt = i;
      if (this.HEt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.HEt);
      }
      i = paramInt + g.a.a.a.c(5, 8, this.HEu);
      paramInt = i;
      if (this.HEv != null) {
        paramInt = i + g.a.a.a.nh(6, this.HEv.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.HEw);
      paramInt = i;
      if (this.HEx != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.HEx);
      }
      i = paramInt;
      if (this.HEy != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.HEy);
      }
      i = i + (g.a.a.b.b.a.fS(10) + 8) + (g.a.a.b.b.a.fS(11) + 8) + g.a.a.b.b.a.bu(12, this.HEB);
      paramInt = i;
      if (this.HEC != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.HEC);
      }
      i = paramInt;
      if (this.HED != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.HED);
      }
      paramInt = i;
      if (this.HEE != null) {
        paramInt = i + g.a.a.a.nh(15, this.HEE.computeSize());
      }
      i = paramInt + g.a.a.a.c(16, 8, this.HEF);
      paramInt = i;
      if (this.HEG != null) {
        paramInt = i + g.a.a.a.nh(17, this.HEG.computeSize());
      }
      AppMethodBeat.o(91293);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HEu.clear();
      this.HEF.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
        localh.HEq = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91293);
        return 0;
      case 2: 
        localh.HEr = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91293);
        return 0;
      case 3: 
        localh.HEs = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91293);
        return 0;
      case 4: 
        localh.HEt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localh.HEu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localh.HEv = ((i)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 7: 
        localh.HEw = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91293);
        return 0;
      case 8: 
        localh.HEx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 9: 
        localh.HEy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 10: 
        localh.HEz = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91293);
        return 0;
      case 11: 
        localh.HEA = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91293);
        return 0;
      case 12: 
        localh.HEB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91293);
        return 0;
      case 13: 
        localh.HEC = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 14: 
        localh.HED = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localh.HEE = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localh.HEF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new b();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localh.HEG = ((b)localObject1);
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