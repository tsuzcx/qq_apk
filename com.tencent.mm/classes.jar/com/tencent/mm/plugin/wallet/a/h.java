package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bx.a
{
  public String zOA;
  public String zOB;
  public a zOC;
  public LinkedList<g> zOD;
  public b zOE;
  public double zOo;
  public double zOp;
  public double zOq;
  public String zOr;
  public LinkedList<t> zOs;
  public i zOt;
  public int zOu;
  public String zOv;
  public String zOw;
  public double zOx;
  public double zOy;
  public int zOz;
  
  public h()
  {
    AppMethodBeat.i(91292);
    this.zOs = new LinkedList();
    this.zOD = new LinkedList();
    AppMethodBeat.o(91292);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91293);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.zOo);
      paramVarArgs.e(2, this.zOp);
      paramVarArgs.e(3, this.zOq);
      if (this.zOr != null) {
        paramVarArgs.d(4, this.zOr);
      }
      paramVarArgs.e(5, 8, this.zOs);
      if (this.zOt != null)
      {
        paramVarArgs.kX(6, this.zOt.computeSize());
        this.zOt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.zOu);
      if (this.zOv != null) {
        paramVarArgs.d(8, this.zOv);
      }
      if (this.zOw != null) {
        paramVarArgs.d(9, this.zOw);
      }
      paramVarArgs.e(10, this.zOx);
      paramVarArgs.e(11, this.zOy);
      paramVarArgs.aR(12, this.zOz);
      if (this.zOA != null) {
        paramVarArgs.d(13, this.zOA);
      }
      if (this.zOB != null) {
        paramVarArgs.d(14, this.zOB);
      }
      if (this.zOC != null)
      {
        paramVarArgs.kX(15, this.zOC.computeSize());
        this.zOC.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.zOD);
      if (this.zOE != null)
      {
        paramVarArgs.kX(17, this.zOE.computeSize());
        this.zOE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.fY(1) + 8 + 0 + (f.a.a.b.b.a.fY(2) + 8) + (f.a.a.b.b.a.fY(3) + 8);
      paramInt = i;
      if (this.zOr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.zOr);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.zOs);
      paramInt = i;
      if (this.zOt != null) {
        paramInt = i + f.a.a.a.kW(6, this.zOt.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.zOu);
      paramInt = i;
      if (this.zOv != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.zOv);
      }
      i = paramInt;
      if (this.zOw != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.zOw);
      }
      i = i + (f.a.a.b.b.a.fY(10) + 8) + (f.a.a.b.b.a.fY(11) + 8) + f.a.a.b.b.a.bA(12, this.zOz);
      paramInt = i;
      if (this.zOA != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.zOA);
      }
      i = paramInt;
      if (this.zOB != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.zOB);
      }
      paramInt = i;
      if (this.zOC != null) {
        paramInt = i + f.a.a.a.kW(15, this.zOC.computeSize());
      }
      i = paramInt + f.a.a.a.c(16, 8, this.zOD);
      paramInt = i;
      if (this.zOE != null) {
        paramInt = i + f.a.a.a.kW(17, this.zOE.computeSize());
      }
      AppMethodBeat.o(91293);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.zOs.clear();
      this.zOD.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localh.zOo = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
        AppMethodBeat.o(91293);
        return 0;
      case 2: 
        localh.zOp = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
        AppMethodBeat.o(91293);
        return 0;
      case 3: 
        localh.zOq = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
        AppMethodBeat.o(91293);
        return 0;
      case 4: 
        localh.zOr = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.zOs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.zOt = ((i)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 7: 
        localh.zOu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91293);
        return 0;
      case 8: 
        localh.zOv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 9: 
        localh.zOw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 10: 
        localh.zOx = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
        AppMethodBeat.o(91293);
        return 0;
      case 11: 
        localh.zOy = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
        AppMethodBeat.o(91293);
        return 0;
      case 12: 
        localh.zOz = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91293);
        return 0;
      case 13: 
        localh.zOA = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 14: 
        localh.zOB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.zOC = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.zOD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new b();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localh.zOE = ((b)localObject1);
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