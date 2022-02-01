package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dev
  extends com.tencent.mm.bw.a
{
  public String LZy;
  public int MJO;
  public LinkedList<cfw> MJP;
  public int MJQ;
  public String MJR;
  public String MJS;
  public int MJT;
  public String MJU;
  public int MJV;
  public LinkedList<ahl> MJW;
  public String Name;
  public String PriceType;
  public int Scene;
  public String ThumbUrl;
  public int oTz;
  public int oUv;
  
  public dev()
  {
    AppMethodBeat.i(91633);
    this.MJP = new LinkedList();
    this.MJW = new LinkedList();
    AppMethodBeat.o(91633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91634);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MJO);
      paramVarArgs.e(2, 8, this.MJP);
      paramVarArgs.aM(3, this.oTz);
      paramVarArgs.aM(4, this.MJQ);
      if (this.PriceType != null) {
        paramVarArgs.e(5, this.PriceType);
      }
      if (this.LZy != null) {
        paramVarArgs.e(6, this.LZy);
      }
      if (this.MJR != null) {
        paramVarArgs.e(7, this.MJR);
      }
      if (this.MJS != null) {
        paramVarArgs.e(8, this.MJS);
      }
      paramVarArgs.aM(9, this.oUv);
      if (this.Name != null) {
        paramVarArgs.e(10, this.Name);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(11, this.ThumbUrl);
      }
      paramVarArgs.aM(12, this.MJT);
      paramVarArgs.aM(13, this.Scene);
      if (this.MJU != null) {
        paramVarArgs.e(14, this.MJU);
      }
      paramVarArgs.aM(15, this.MJV);
      paramVarArgs.e(16, 8, this.MJW);
      AppMethodBeat.o(91634);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MJO) + 0 + g.a.a.a.c(2, 8, this.MJP) + g.a.a.b.b.a.bu(3, this.oTz) + g.a.a.b.b.a.bu(4, this.MJQ);
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.PriceType);
      }
      i = paramInt;
      if (this.LZy != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LZy);
      }
      paramInt = i;
      if (this.MJR != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MJR);
      }
      i = paramInt;
      if (this.MJS != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MJS);
      }
      i += g.a.a.b.b.a.bu(9, this.oUv);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Name);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.ThumbUrl);
      }
      i = i + g.a.a.b.b.a.bu(12, this.MJT) + g.a.a.b.b.a.bu(13, this.Scene);
      paramInt = i;
      if (this.MJU != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.MJU);
      }
      i = g.a.a.b.b.a.bu(15, this.MJV);
      int j = g.a.a.a.c(16, 8, this.MJW);
      AppMethodBeat.o(91634);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MJP.clear();
      this.MJW.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dev localdev = (dev)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91634);
        return -1;
      case 1: 
        localdev.MJO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91634);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdev.MJP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91634);
        return 0;
      case 3: 
        localdev.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91634);
        return 0;
      case 4: 
        localdev.MJQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91634);
        return 0;
      case 5: 
        localdev.PriceType = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 6: 
        localdev.LZy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 7: 
        localdev.MJR = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 8: 
        localdev.MJS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 9: 
        localdev.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91634);
        return 0;
      case 10: 
        localdev.Name = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 11: 
        localdev.ThumbUrl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 12: 
        localdev.MJT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91634);
        return 0;
      case 13: 
        localdev.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91634);
        return 0;
      case 14: 
        localdev.MJU = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 15: 
        localdev.MJV = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91634);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ahl();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ahl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdev.MJW.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    AppMethodBeat.o(91634);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dev
 * JD-Core Version:    0.7.0.1
 */