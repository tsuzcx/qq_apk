package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpv
  extends buy
{
  public int Scene;
  public String wZA;
  public long wZC;
  public SKBuiltinBuffer_t wvN;
  public String xGH;
  public String xGI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(857);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wZA != null) {
        paramVarArgs.e(2, this.wZA);
      }
      paramVarArgs.am(3, this.wZC);
      if (this.wvN != null)
      {
        paramVarArgs.iQ(4, this.wvN.computeSize());
        this.wvN.writeFields(paramVarArgs);
      }
      if (this.xGH != null) {
        paramVarArgs.e(5, this.xGH);
      }
      if (this.xGI != null) {
        paramVarArgs.e(6, this.xGI);
      }
      paramVarArgs.aO(7, this.Scene);
      AppMethodBeat.o(857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label751;
      }
    }
    label751:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wZA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wZA);
      }
      i += e.a.a.b.b.a.p(3, this.wZC);
      paramInt = i;
      if (this.wvN != null) {
        paramInt = i + e.a.a.a.iP(4, this.wvN.computeSize());
      }
      i = paramInt;
      if (this.xGH != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xGH);
      }
      paramInt = i;
      if (this.xGI != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xGI);
      }
      i = e.a.a.b.b.a.bl(7, this.Scene);
      AppMethodBeat.o(857);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(857);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cpv localcpv = (cpv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(857);
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
            localcpv.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(857);
          return 0;
        case 2: 
          localcpv.wZA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(857);
          return 0;
        case 3: 
          localcpv.wZC = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(857);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcpv.wvN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(857);
          return 0;
        case 5: 
          localcpv.xGH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(857);
          return 0;
        case 6: 
          localcpv.xGI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(857);
          return 0;
        }
        localcpv.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(857);
        return 0;
      }
      AppMethodBeat.o(857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpv
 * JD-Core Version:    0.7.0.1
 */