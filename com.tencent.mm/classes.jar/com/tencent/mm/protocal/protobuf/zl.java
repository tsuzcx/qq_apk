package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class zl
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public String nul;
  public int pIx;
  public int pIy;
  public String wQr;
  public SKBuiltinBuffer_t wQs;
  public String wQt;
  public String wQu;
  public String wQv;
  public int wQw;
  public String woU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(53871);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wQs == null)
      {
        paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(53871);
        throw paramVarArgs;
      }
      if (this.wQr != null) {
        paramVarArgs.e(1, this.wQr);
      }
      paramVarArgs.aO(2, this.pIy);
      paramVarArgs.aO(3, this.pIx);
      if (this.wQs != null)
      {
        paramVarArgs.iQ(4, this.wQs.computeSize());
        this.wQs.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.jKs);
      if (this.nul != null) {
        paramVarArgs.e(6, this.nul);
      }
      if (this.wQt != null) {
        paramVarArgs.e(7, this.wQt);
      }
      if (this.wQu != null) {
        paramVarArgs.e(8, this.wQu);
      }
      if (this.wQv != null) {
        paramVarArgs.e(9, this.wQv);
      }
      if (this.woU != null) {
        paramVarArgs.e(10, this.woU);
      }
      paramVarArgs.aO(11, this.wQw);
      AppMethodBeat.o(53871);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wQr == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = e.a.a.b.b.a.f(1, this.wQr) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIy) + e.a.a.b.b.a.bl(3, this.pIx);
      paramInt = i;
      if (this.wQs != null) {
        paramInt = i + e.a.a.a.iP(4, this.wQs.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.jKs);
      paramInt = i;
      if (this.nul != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.nul);
      }
      i = paramInt;
      if (this.wQt != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wQt);
      }
      paramInt = i;
      if (this.wQu != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wQu);
      }
      i = paramInt;
      if (this.wQv != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wQv);
      }
      paramInt = i;
      if (this.woU != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.woU);
      }
      i = e.a.a.b.b.a.bl(11, this.wQw);
      AppMethodBeat.o(53871);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wQs == null)
        {
          paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(53871);
          throw paramVarArgs;
        }
        AppMethodBeat.o(53871);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        zl localzl = (zl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(53871);
          return -1;
        case 1: 
          localzl.wQr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(53871);
          return 0;
        case 2: 
          localzl.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(53871);
          return 0;
        case 3: 
          localzl.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(53871);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localzl.wQs = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(53871);
          return 0;
        case 5: 
          localzl.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(53871);
          return 0;
        case 6: 
          localzl.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(53871);
          return 0;
        case 7: 
          localzl.wQt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(53871);
          return 0;
        case 8: 
          localzl.wQu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(53871);
          return 0;
        case 9: 
          localzl.wQv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(53871);
          return 0;
        case 10: 
          localzl.woU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(53871);
          return 0;
        }
        localzl.wQw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(53871);
        return 0;
      }
      AppMethodBeat.o(53871);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zl
 * JD-Core Version:    0.7.0.1
 */