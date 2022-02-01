package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bx.a
{
  public double CGW;
  public double CGX;
  public double CGY;
  public String CGZ;
  public LinkedList<t> CHa;
  public i CHb;
  public int CHc;
  public String CHd;
  public String CHe;
  public double CHf;
  public double CHg;
  public int CHh;
  public String CHi;
  public String CHj;
  public a CHk;
  public LinkedList<g> CHl;
  public b CHm;
  
  public h()
  {
    AppMethodBeat.i(91292);
    this.CHa = new LinkedList();
    this.CHl = new LinkedList();
    AppMethodBeat.o(91292);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91293);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.CGW);
      paramVarArgs.e(2, this.CGX);
      paramVarArgs.e(3, this.CGY);
      if (this.CGZ != null) {
        paramVarArgs.d(4, this.CGZ);
      }
      paramVarArgs.e(5, 8, this.CHa);
      if (this.CHb != null)
      {
        paramVarArgs.lC(6, this.CHb.computeSize());
        this.CHb.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.CHc);
      if (this.CHd != null) {
        paramVarArgs.d(8, this.CHd);
      }
      if (this.CHe != null) {
        paramVarArgs.d(9, this.CHe);
      }
      paramVarArgs.e(10, this.CHf);
      paramVarArgs.e(11, this.CHg);
      paramVarArgs.aS(12, this.CHh);
      if (this.CHi != null) {
        paramVarArgs.d(13, this.CHi);
      }
      if (this.CHj != null) {
        paramVarArgs.d(14, this.CHj);
      }
      if (this.CHk != null)
      {
        paramVarArgs.lC(15, this.CHk.computeSize());
        this.CHk.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.CHl);
      if (this.CHm != null)
      {
        paramVarArgs.lC(17, this.CHm.computeSize());
        this.CHm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.alT(1) + 0 + f.a.a.b.b.a.alT(2) + f.a.a.b.b.a.alT(3);
      paramInt = i;
      if (this.CGZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CGZ);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.CHa);
      paramInt = i;
      if (this.CHb != null) {
        paramInt = i + f.a.a.a.lB(6, this.CHb.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.CHc);
      paramInt = i;
      if (this.CHd != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CHd);
      }
      i = paramInt;
      if (this.CHe != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CHe);
      }
      i = i + f.a.a.b.b.a.alT(10) + f.a.a.b.b.a.alT(11) + f.a.a.b.b.a.bz(12, this.CHh);
      paramInt = i;
      if (this.CHi != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CHi);
      }
      i = paramInt;
      if (this.CHj != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.CHj);
      }
      paramInt = i;
      if (this.CHk != null) {
        paramInt = i + f.a.a.a.lB(15, this.CHk.computeSize());
      }
      i = paramInt + f.a.a.a.c(16, 8, this.CHl);
      paramInt = i;
      if (this.CHm != null) {
        paramInt = i + f.a.a.a.lB(17, this.CHm.computeSize());
      }
      AppMethodBeat.o(91293);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CHa.clear();
      this.CHl.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        localh.CGW = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
        AppMethodBeat.o(91293);
        return 0;
      case 2: 
        localh.CGX = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
        AppMethodBeat.o(91293);
        return 0;
      case 3: 
        localh.CGY = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
        AppMethodBeat.o(91293);
        return 0;
      case 4: 
        localh.CGZ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.CHa.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.CHb = ((i)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 7: 
        localh.CHc = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91293);
        return 0;
      case 8: 
        localh.CHd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 9: 
        localh.CHe = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 10: 
        localh.CHf = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
        AppMethodBeat.o(91293);
        return 0;
      case 11: 
        localh.CHg = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
        AppMethodBeat.o(91293);
        return 0;
      case 12: 
        localh.CHh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91293);
        return 0;
      case 13: 
        localh.CHi = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 14: 
        localh.CHj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.CHk = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.CHl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new b();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localh.CHm = ((b)localObject1);
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