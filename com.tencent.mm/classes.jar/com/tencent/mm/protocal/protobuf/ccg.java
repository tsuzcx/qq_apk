package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccg
  extends com.tencent.mm.bx.a
{
  public int DYD;
  public LinkedList<bkd> DYE;
  public int DYF;
  public String DYG;
  public String DYH;
  public int DYI;
  public String DYJ;
  public int DYK;
  public LinkedList<abw> DYL;
  public String DwS;
  public String Name;
  public String PriceType;
  public int Scene;
  public String ThumbUrl;
  public int mAK;
  public int mBH;
  
  public ccg()
  {
    AppMethodBeat.i(91633);
    this.DYE = new LinkedList();
    this.DYL = new LinkedList();
    AppMethodBeat.o(91633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DYD);
      paramVarArgs.e(2, 8, this.DYE);
      paramVarArgs.aR(3, this.mAK);
      paramVarArgs.aR(4, this.DYF);
      if (this.PriceType != null) {
        paramVarArgs.d(5, this.PriceType);
      }
      if (this.DwS != null) {
        paramVarArgs.d(6, this.DwS);
      }
      if (this.DYG != null) {
        paramVarArgs.d(7, this.DYG);
      }
      if (this.DYH != null) {
        paramVarArgs.d(8, this.DYH);
      }
      paramVarArgs.aR(9, this.mBH);
      if (this.Name != null) {
        paramVarArgs.d(10, this.Name);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(11, this.ThumbUrl);
      }
      paramVarArgs.aR(12, this.DYI);
      paramVarArgs.aR(13, this.Scene);
      if (this.DYJ != null) {
        paramVarArgs.d(14, this.DYJ);
      }
      paramVarArgs.aR(15, this.DYK);
      paramVarArgs.e(16, 8, this.DYL);
      AppMethodBeat.o(91634);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DYD) + 0 + f.a.a.a.c(2, 8, this.DYE) + f.a.a.b.b.a.bA(3, this.mAK) + f.a.a.b.b.a.bA(4, this.DYF);
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.PriceType);
      }
      i = paramInt;
      if (this.DwS != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DwS);
      }
      paramInt = i;
      if (this.DYG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DYG);
      }
      i = paramInt;
      if (this.DYH != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DYH);
      }
      i += f.a.a.b.b.a.bA(9, this.mBH);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Name);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ThumbUrl);
      }
      i = i + f.a.a.b.b.a.bA(12, this.DYI) + f.a.a.b.b.a.bA(13, this.Scene);
      paramInt = i;
      if (this.DYJ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DYJ);
      }
      i = f.a.a.b.b.a.bA(15, this.DYK);
      int j = f.a.a.a.c(16, 8, this.DYL);
      AppMethodBeat.o(91634);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DYE.clear();
      this.DYL.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ccg localccg = (ccg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91634);
        return -1;
      case 1: 
        localccg.DYD = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91634);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localccg.DYE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91634);
        return 0;
      case 3: 
        localccg.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91634);
        return 0;
      case 4: 
        localccg.DYF = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91634);
        return 0;
      case 5: 
        localccg.PriceType = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 6: 
        localccg.DwS = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 7: 
        localccg.DYG = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 8: 
        localccg.DYH = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 9: 
        localccg.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91634);
        return 0;
      case 10: 
        localccg.Name = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 11: 
        localccg.ThumbUrl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 12: 
        localccg.DYI = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91634);
        return 0;
      case 13: 
        localccg.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91634);
        return 0;
      case 14: 
        localccg.DYJ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 15: 
        localccg.DYK = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91634);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new abw();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((abw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localccg.DYL.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    AppMethodBeat.o(91634);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccg
 * JD-Core Version:    0.7.0.1
 */