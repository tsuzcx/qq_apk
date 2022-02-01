package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bx.a
{
  public int VlA;
  public String VlB;
  public String VlC;
  public double VlD;
  public double VlE;
  public int VlF;
  public String VlG;
  public String VlH;
  public a VlI;
  public LinkedList<g> VlJ;
  public b VlK;
  public double Vlu;
  public double Vlv;
  public double Vlw;
  public String Vlx;
  public LinkedList<q> Vly;
  public i Vlz;
  
  public h()
  {
    AppMethodBeat.i(91292);
    this.Vly = new LinkedList();
    this.VlJ = new LinkedList();
    AppMethodBeat.o(91292);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91293);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, this.Vlu);
      paramVarArgs.d(2, this.Vlv);
      paramVarArgs.d(3, this.Vlw);
      if (this.Vlx != null) {
        paramVarArgs.g(4, this.Vlx);
      }
      paramVarArgs.e(5, 8, this.Vly);
      if (this.Vlz != null)
      {
        paramVarArgs.qD(6, this.Vlz.computeSize());
        this.Vlz.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.VlA);
      if (this.VlB != null) {
        paramVarArgs.g(8, this.VlB);
      }
      if (this.VlC != null) {
        paramVarArgs.g(9, this.VlC);
      }
      paramVarArgs.d(10, this.VlD);
      paramVarArgs.d(11, this.VlE);
      paramVarArgs.bS(12, this.VlF);
      if (this.VlG != null) {
        paramVarArgs.g(13, this.VlG);
      }
      if (this.VlH != null) {
        paramVarArgs.g(14, this.VlH);
      }
      if (this.VlI != null)
      {
        paramVarArgs.qD(15, this.VlI.computeSize());
        this.VlI.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.VlJ);
      if (this.VlK != null)
      {
        paramVarArgs.qD(17, this.VlK.computeSize());
        this.VlK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.ko(1) + 8 + 0 + (i.a.a.b.b.a.ko(2) + 8) + (i.a.a.b.b.a.ko(3) + 8);
      paramInt = i;
      if (this.Vlx != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Vlx);
      }
      i = paramInt + i.a.a.a.c(5, 8, this.Vly);
      paramInt = i;
      if (this.Vlz != null) {
        paramInt = i + i.a.a.a.qC(6, this.Vlz.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.VlA);
      paramInt = i;
      if (this.VlB != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.VlB);
      }
      i = paramInt;
      if (this.VlC != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.VlC);
      }
      i = i + (i.a.a.b.b.a.ko(10) + 8) + (i.a.a.b.b.a.ko(11) + 8) + i.a.a.b.b.a.cJ(12, this.VlF);
      paramInt = i;
      if (this.VlG != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.VlG);
      }
      i = paramInt;
      if (this.VlH != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.VlH);
      }
      paramInt = i;
      if (this.VlI != null) {
        paramInt = i + i.a.a.a.qC(15, this.VlI.computeSize());
      }
      i = paramInt + i.a.a.a.c(16, 8, this.VlJ);
      paramInt = i;
      if (this.VlK != null) {
        paramInt = i + i.a.a.a.qC(17, this.VlK.computeSize());
      }
      AppMethodBeat.o(91293);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Vly.clear();
      this.VlJ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91293);
        return -1;
      case 1: 
        localh.Vlu = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
        AppMethodBeat.o(91293);
        return 0;
      case 2: 
        localh.Vlv = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
        AppMethodBeat.o(91293);
        return 0;
      case 3: 
        localh.Vlw = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
        AppMethodBeat.o(91293);
        return 0;
      case 4: 
        localh.Vlx = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new q();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((q)localObject2).parseFrom((byte[])localObject1);
          }
          localh.Vly.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new i();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((i)localObject2).parseFrom((byte[])localObject1);
          }
          localh.Vlz = ((i)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 7: 
        localh.VlA = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91293);
        return 0;
      case 8: 
        localh.VlB = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 9: 
        localh.VlC = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 10: 
        localh.VlD = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
        AppMethodBeat.o(91293);
        return 0;
      case 11: 
        localh.VlE = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
        AppMethodBeat.o(91293);
        return 0;
      case 12: 
        localh.VlF = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91293);
        return 0;
      case 13: 
        localh.VlG = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 14: 
        localh.VlH = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91293);
        return 0;
      case 15: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((a)localObject2).parseFrom((byte[])localObject1);
          }
          localh.VlI = ((a)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      case 16: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new g();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((g)localObject2).parseFrom((byte[])localObject1);
          }
          localh.VlJ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91293);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new b();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((b)localObject2).parseFrom((byte[])localObject1);
        }
        localh.VlK = ((b)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91293);
      return 0;
    }
    AppMethodBeat.o(91293);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.h
 * JD-Core Version:    0.7.0.1
 */