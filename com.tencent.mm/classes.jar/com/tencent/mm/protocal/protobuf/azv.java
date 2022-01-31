package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azv
  extends buy
{
  public int OpCode;
  public float wDh;
  public float wDi;
  public int wSk;
  public String wSl;
  public String wSm;
  public int wSn;
  public SKBuiltinBuffer_t wsr;
  public SKBuiltinBuffer_t wss;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55527);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.OpCode);
      paramVarArgs.q(3, this.wDh);
      paramVarArgs.q(4, this.wDi);
      paramVarArgs.aO(5, this.wSk);
      if (this.wSl != null) {
        paramVarArgs.e(6, this.wSl);
      }
      if (this.wSm != null) {
        paramVarArgs.e(7, this.wSm);
      }
      paramVarArgs.aO(8, this.wSn);
      if (this.wsr != null)
      {
        paramVarArgs.iQ(9, this.wsr.computeSize());
        this.wsr.writeFields(paramVarArgs);
      }
      if (this.wss != null)
      {
        paramVarArgs.iQ(10, this.wss.computeSize());
        this.wss.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(55527);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label964;
      }
    }
    label964:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.OpCode) + (e.a.a.b.b.a.eW(3) + 4) + (e.a.a.b.b.a.eW(4) + 4) + e.a.a.b.b.a.bl(5, this.wSk);
      paramInt = i;
      if (this.wSl != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wSl);
      }
      i = paramInt;
      if (this.wSm != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wSm);
      }
      i += e.a.a.b.b.a.bl(8, this.wSn);
      paramInt = i;
      if (this.wsr != null) {
        paramInt = i + e.a.a.a.iP(9, this.wsr.computeSize());
      }
      i = paramInt;
      if (this.wss != null) {
        i = paramInt + e.a.a.a.iP(10, this.wss.computeSize());
      }
      AppMethodBeat.o(55527);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55527);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        azv localazv = (azv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(55527);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazv.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55527);
          return 0;
        case 2: 
          localazv.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55527);
          return 0;
        case 3: 
          localazv.wDh = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(55527);
          return 0;
        case 4: 
          localazv.wDi = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(55527);
          return 0;
        case 5: 
          localazv.wSk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55527);
          return 0;
        case 6: 
          localazv.wSl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55527);
          return 0;
        case 7: 
          localazv.wSm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55527);
          return 0;
        case 8: 
          localazv.wSn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55527);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazv.wsr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55527);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localazv.wss = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(55527);
        return 0;
      }
      AppMethodBeat.o(55527);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azv
 * JD-Core Version:    0.7.0.1
 */