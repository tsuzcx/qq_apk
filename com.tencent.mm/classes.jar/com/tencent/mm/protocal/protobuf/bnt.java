package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnt
  extends com.tencent.mm.bv.a
{
  public String Name;
  public String PriceType;
  public int Scene;
  public String ThumbUrl;
  public int jJu;
  public int jKs;
  public int xBV;
  public LinkedList<ayv> xBW;
  public int xBX;
  public String xBY;
  public String xBZ;
  public int xCa;
  public String xCb;
  public int xCc;
  public LinkedList<ym> xCd;
  public String xec;
  
  public bnt()
  {
    AppMethodBeat.i(56933);
    this.xBW = new LinkedList();
    this.xCd = new LinkedList();
    AppMethodBeat.o(56933);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56934);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xBV);
      paramVarArgs.e(2, 8, this.xBW);
      paramVarArgs.aO(3, this.jJu);
      paramVarArgs.aO(4, this.xBX);
      if (this.PriceType != null) {
        paramVarArgs.e(5, this.PriceType);
      }
      if (this.xec != null) {
        paramVarArgs.e(6, this.xec);
      }
      if (this.xBY != null) {
        paramVarArgs.e(7, this.xBY);
      }
      if (this.xBZ != null) {
        paramVarArgs.e(8, this.xBZ);
      }
      paramVarArgs.aO(9, this.jKs);
      if (this.Name != null) {
        paramVarArgs.e(10, this.Name);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(11, this.ThumbUrl);
      }
      paramVarArgs.aO(12, this.xCa);
      paramVarArgs.aO(13, this.Scene);
      if (this.xCb != null) {
        paramVarArgs.e(14, this.xCb);
      }
      paramVarArgs.aO(15, this.xCc);
      paramVarArgs.e(16, 8, this.xCd);
      AppMethodBeat.o(56934);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xBV) + 0 + e.a.a.a.c(2, 8, this.xBW) + e.a.a.b.b.a.bl(3, this.jJu) + e.a.a.b.b.a.bl(4, this.xBX);
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.PriceType);
      }
      i = paramInt;
      if (this.xec != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xec);
      }
      paramInt = i;
      if (this.xBY != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xBY);
      }
      i = paramInt;
      if (this.xBZ != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xBZ);
      }
      i += e.a.a.b.b.a.bl(9, this.jKs);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.Name);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.ThumbUrl);
      }
      i = i + e.a.a.b.b.a.bl(12, this.xCa) + e.a.a.b.b.a.bl(13, this.Scene);
      paramInt = i;
      if (this.xCb != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.xCb);
      }
      i = e.a.a.b.b.a.bl(15, this.xCc);
      int j = e.a.a.a.c(16, 8, this.xCd);
      AppMethodBeat.o(56934);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xBW.clear();
      this.xCd.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56934);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bnt localbnt = (bnt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56934);
        return -1;
      case 1: 
        localbnt.xBV = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56934);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ayv();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ayv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbnt.xBW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56934);
        return 0;
      case 3: 
        localbnt.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56934);
        return 0;
      case 4: 
        localbnt.xBX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56934);
        return 0;
      case 5: 
        localbnt.PriceType = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56934);
        return 0;
      case 6: 
        localbnt.xec = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56934);
        return 0;
      case 7: 
        localbnt.xBY = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56934);
        return 0;
      case 8: 
        localbnt.xBZ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56934);
        return 0;
      case 9: 
        localbnt.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56934);
        return 0;
      case 10: 
        localbnt.Name = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56934);
        return 0;
      case 11: 
        localbnt.ThumbUrl = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56934);
        return 0;
      case 12: 
        localbnt.xCa = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56934);
        return 0;
      case 13: 
        localbnt.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56934);
        return 0;
      case 14: 
        localbnt.xCb = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56934);
        return 0;
      case 15: 
        localbnt.xCc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56934);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ym();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ym)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbnt.xCd.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(56934);
      return 0;
    }
    AppMethodBeat.o(56934);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnt
 * JD-Core Version:    0.7.0.1
 */