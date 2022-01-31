package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ank
  extends bvk
{
  public int OpCode;
  public String Url;
  public String wBZ;
  public String wll;
  public String wxW;
  public int wzD;
  public SKBuiltinBuffer_t xcE;
  public String xcN;
  public int xcO;
  public int xdL;
  public LinkedList<bjs> xdM;
  
  public ank()
  {
    AppMethodBeat.i(113783);
    this.xdM = new LinkedList();
    AppMethodBeat.o(113783);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113784);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(113784);
        throw paramVarArgs;
      }
      if (this.xcE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(113784);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xdL);
      paramVarArgs.e(3, 8, this.xdM);
      paramVarArgs.aO(4, this.OpCode);
      paramVarArgs.aO(5, this.wzD);
      if (this.xcE != null)
      {
        paramVarArgs.iQ(6, this.xcE.computeSize());
        this.xcE.writeFields(paramVarArgs);
      }
      if (this.Url != null) {
        paramVarArgs.e(7, this.Url);
      }
      if (this.xcN != null) {
        paramVarArgs.e(8, this.xcN);
      }
      if (this.wxW != null) {
        paramVarArgs.e(9, this.wxW);
      }
      if (this.wll != null) {
        paramVarArgs.e(10, this.wll);
      }
      paramVarArgs.aO(11, this.xcO);
      if (this.wBZ != null) {
        paramVarArgs.e(12, this.wBZ);
      }
      AppMethodBeat.o(113784);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xdL) + e.a.a.a.c(3, 8, this.xdM) + e.a.a.b.b.a.bl(4, this.OpCode) + e.a.a.b.b.a.bl(5, this.wzD);
      paramInt = i;
      if (this.xcE != null) {
        paramInt = i + e.a.a.a.iP(6, this.xcE.computeSize());
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.Url);
      }
      paramInt = i;
      if (this.xcN != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xcN);
      }
      i = paramInt;
      if (this.wxW != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wxW);
      }
      paramInt = i;
      if (this.wll != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wll);
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.xcO);
      paramInt = i;
      if (this.wBZ != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wBZ);
      }
      AppMethodBeat.o(113784);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xdM.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(113784);
          throw paramVarArgs;
        }
        if (this.xcE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(113784);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113784);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ank localank = (ank)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113784);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localank.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113784);
          return 0;
        case 2: 
          localank.xdL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113784);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjs();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localank.xdM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113784);
          return 0;
        case 4: 
          localank.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113784);
          return 0;
        case 5: 
          localank.wzD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113784);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localank.xcE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113784);
          return 0;
        case 7: 
          localank.Url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(113784);
          return 0;
        case 8: 
          localank.xcN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(113784);
          return 0;
        case 9: 
          localank.wxW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(113784);
          return 0;
        case 10: 
          localank.wll = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(113784);
          return 0;
        case 11: 
          localank.xcO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113784);
          return 0;
        }
        localank.wBZ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(113784);
        return 0;
      }
      AppMethodBeat.o(113784);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ank
 * JD-Core Version:    0.7.0.1
 */