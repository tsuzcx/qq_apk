package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dx
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public String fKw;
  public int jKs;
  public int niK;
  public String ntu;
  public String nul;
  public String num;
  public String woU;
  public int wpR;
  public String wpS;
  public SKBuiltinBuffer_t wpT;
  public int wpU;
  public String wpV;
  public String wpW;
  public String wpX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28312);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.num != null) {
        paramVarArgs.e(1, this.num);
      }
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      paramVarArgs.aO(3, this.wpR);
      if (this.nul != null) {
        paramVarArgs.e(4, this.nul);
      }
      paramVarArgs.aO(5, this.jKs);
      if (this.ntu != null) {
        paramVarArgs.e(6, this.ntu);
      }
      paramVarArgs.aO(7, this.CreateTime);
      if (this.wpS != null) {
        paramVarArgs.e(8, this.wpS);
      }
      if (this.wpT != null)
      {
        paramVarArgs.iQ(9, this.wpT.computeSize());
        this.wpT.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(10, this.niK);
      paramVarArgs.aO(11, this.wpU);
      if (this.woU != null) {
        paramVarArgs.e(12, this.woU);
      }
      if (this.wpV != null) {
        paramVarArgs.e(13, this.wpV);
      }
      if (this.wpW != null) {
        paramVarArgs.e(14, this.wpW);
      }
      if (this.wpX != null) {
        paramVarArgs.e(15, this.wpX);
      }
      AppMethodBeat.o(28312);
      return 0;
    }
    if (paramInt == 1) {
      if (this.num == null) {
        break label1111;
      }
    }
    label1111:
    for (paramInt = e.a.a.b.b.a.f(1, this.num) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fKw != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.fKw);
      }
      i += e.a.a.b.b.a.bl(3, this.wpR);
      paramInt = i;
      if (this.nul != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nul);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.jKs);
      paramInt = i;
      if (this.ntu != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.ntu);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.CreateTime);
      paramInt = i;
      if (this.wpS != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wpS);
      }
      i = paramInt;
      if (this.wpT != null) {
        i = paramInt + e.a.a.a.iP(9, this.wpT.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(10, this.niK) + e.a.a.b.b.a.bl(11, this.wpU);
      paramInt = i;
      if (this.woU != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.woU);
      }
      i = paramInt;
      if (this.wpV != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.wpV);
      }
      paramInt = i;
      if (this.wpW != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.wpW);
      }
      i = paramInt;
      if (this.wpX != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.wpX);
      }
      AppMethodBeat.o(28312);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28312);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        dx localdx = (dx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28312);
          return -1;
        case 1: 
          localdx.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28312);
          return 0;
        case 2: 
          localdx.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28312);
          return 0;
        case 3: 
          localdx.wpR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28312);
          return 0;
        case 4: 
          localdx.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28312);
          return 0;
        case 5: 
          localdx.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28312);
          return 0;
        case 6: 
          localdx.ntu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28312);
          return 0;
        case 7: 
          localdx.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28312);
          return 0;
        case 8: 
          localdx.wpS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28312);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdx.wpT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28312);
          return 0;
        case 10: 
          localdx.niK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28312);
          return 0;
        case 11: 
          localdx.wpU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28312);
          return 0;
        case 12: 
          localdx.woU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28312);
          return 0;
        case 13: 
          localdx.wpV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28312);
          return 0;
        case 14: 
          localdx.wpW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28312);
          return 0;
        }
        localdx.wpX = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28312);
        return 0;
      }
      AppMethodBeat.o(28312);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dx
 * JD-Core Version:    0.7.0.1
 */