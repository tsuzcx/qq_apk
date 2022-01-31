package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chz
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public int jKs;
  public String ntu;
  public String nul;
  public String num;
  public int xNX;
  public int xNY;
  public String xRE;
  public String xRF;
  public int xRH;
  public chs xRP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56544);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.Id);
      if (this.num != null) {
        paramVarArgs.e(2, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(3, this.nul);
      }
      if (this.xRE != null) {
        paramVarArgs.e(4, this.xRE);
      }
      if (this.xRF != null) {
        paramVarArgs.e(5, this.xRF);
      }
      if (this.ntu != null) {
        paramVarArgs.e(6, this.ntu);
      }
      paramVarArgs.aO(7, this.jKs);
      paramVarArgs.aO(8, this.CreateTime);
      paramVarArgs.aO(9, this.xNY);
      paramVarArgs.aO(10, this.xNX);
      paramVarArgs.aO(11, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.e(12, this.ThumbUrl);
      }
      if (this.xRP != null)
      {
        paramVarArgs.iQ(13, this.xRP.computeSize());
        this.xRP.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(14, this.xRH);
      AppMethodBeat.o(56544);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.num != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.num);
      }
      i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nul);
      }
      paramInt = i;
      if (this.xRE != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xRE);
      }
      i = paramInt;
      if (this.xRF != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xRF);
      }
      paramInt = i;
      if (this.ntu != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.ntu);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.jKs) + e.a.a.b.b.a.bl(8, this.CreateTime) + e.a.a.b.b.a.bl(9, this.xNY) + e.a.a.b.b.a.bl(10, this.xNX) + e.a.a.b.b.a.bl(11, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.ThumbUrl);
      }
      i = paramInt;
      if (this.xRP != null) {
        i = paramInt + e.a.a.a.iP(13, this.xRP.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(14, this.xRH);
      AppMethodBeat.o(56544);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56544);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      chz localchz = (chz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56544);
        return -1;
      case 1: 
        localchz.Id = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56544);
        return 0;
      case 2: 
        localchz.num = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56544);
        return 0;
      case 3: 
        localchz.nul = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56544);
        return 0;
      case 4: 
        localchz.xRE = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56544);
        return 0;
      case 5: 
        localchz.xRF = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56544);
        return 0;
      case 6: 
        localchz.ntu = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56544);
        return 0;
      case 7: 
        localchz.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56544);
        return 0;
      case 8: 
        localchz.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56544);
        return 0;
      case 9: 
        localchz.xNY = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56544);
        return 0;
      case 10: 
        localchz.xNX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56544);
        return 0;
      case 11: 
        localchz.IsNotRichText = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56544);
        return 0;
      case 12: 
        localchz.ThumbUrl = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56544);
        return 0;
      case 13: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chs();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((chs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localchz.xRP = ((chs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56544);
        return 0;
      }
      localchz.xRH = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(56544);
      return 0;
    }
    AppMethodBeat.o(56544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chz
 * JD-Core Version:    0.7.0.1
 */