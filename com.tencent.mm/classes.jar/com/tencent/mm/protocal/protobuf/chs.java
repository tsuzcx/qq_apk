package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class chs
  extends com.tencent.mm.bv.a
{
  public int CommentCount;
  public int CreateTime;
  public int DeleteFlag;
  public long Id;
  public String jJA;
  public String jKG;
  public LinkedList<cgw> xSA;
  public int xSB;
  public int xSC;
  public int xSu;
  public int xSw;
  public SKBuiltinBuffer_t xSx;
  public LinkedList<cgw> xSy;
  public int xSz;
  
  public chs()
  {
    AppMethodBeat.i(56534);
    this.xSy = new LinkedList();
    this.xSA = new LinkedList();
    AppMethodBeat.o(56534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56535);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xSx == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(56535);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.Id);
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      if (this.jKG != null) {
        paramVarArgs.e(3, this.jKG);
      }
      paramVarArgs.aO(4, this.CreateTime);
      paramVarArgs.aO(5, this.xSw);
      if (this.xSx != null)
      {
        paramVarArgs.iQ(6, this.xSx.computeSize());
        this.xSx.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.CommentCount);
      paramVarArgs.e(8, 8, this.xSy);
      paramVarArgs.aO(9, this.xSz);
      paramVarArgs.e(10, 8, this.xSA);
      paramVarArgs.aO(11, this.DeleteFlag);
      paramVarArgs.aO(12, this.xSB);
      paramVarArgs.aO(13, this.xSu);
      paramVarArgs.aO(14, this.xSC);
      AppMethodBeat.o(56535);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jJA);
      }
      i = paramInt;
      if (this.jKG != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.jKG);
      }
      i = i + e.a.a.b.b.a.bl(4, this.CreateTime) + e.a.a.b.b.a.bl(5, this.xSw);
      paramInt = i;
      if (this.xSx != null) {
        paramInt = i + e.a.a.a.iP(6, this.xSx.computeSize());
      }
      i = e.a.a.b.b.a.bl(7, this.CommentCount);
      int j = e.a.a.a.c(8, 8, this.xSy);
      int k = e.a.a.b.b.a.bl(9, this.xSz);
      int m = e.a.a.a.c(10, 8, this.xSA);
      int n = e.a.a.b.b.a.bl(11, this.DeleteFlag);
      int i1 = e.a.a.b.b.a.bl(12, this.xSB);
      int i2 = e.a.a.b.b.a.bl(13, this.xSu);
      int i3 = e.a.a.b.b.a.bl(14, this.xSC);
      AppMethodBeat.o(56535);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xSy.clear();
      this.xSA.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xSx == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(56535);
        throw paramVarArgs;
      }
      AppMethodBeat.o(56535);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      chs localchs = (chs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56535);
        return -1;
      case 1: 
        localchs.Id = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56535);
        return 0;
      case 2: 
        localchs.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56535);
        return 0;
      case 3: 
        localchs.jKG = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56535);
        return 0;
      case 4: 
        localchs.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56535);
        return 0;
      case 5: 
        localchs.xSw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56535);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localchs.xSx = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56535);
        return 0;
      case 7: 
        localchs.CommentCount = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56535);
        return 0;
      case 8: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cgw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localchs.xSy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56535);
        return 0;
      case 9: 
        localchs.xSz = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56535);
        return 0;
      case 10: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cgw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localchs.xSA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56535);
        return 0;
      case 11: 
        localchs.DeleteFlag = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56535);
        return 0;
      case 12: 
        localchs.xSB = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56535);
        return 0;
      case 13: 
        localchs.xSu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56535);
        return 0;
      }
      localchs.xSC = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(56535);
      return 0;
    }
    AppMethodBeat.o(56535);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chs
 * JD-Core Version:    0.7.0.1
 */