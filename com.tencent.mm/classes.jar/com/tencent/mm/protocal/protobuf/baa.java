package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class baa
  extends buy
{
  public int OpCode;
  public String fLr;
  public float wDh;
  public float wDi;
  public int wSk;
  public String wSl;
  public String wSm;
  public int wSn;
  public int xpu;
  public int xpv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55530);
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
      if (this.fLr != null) {
        paramVarArgs.e(9, this.fLr);
      }
      paramVarArgs.aO(10, this.xpu);
      paramVarArgs.aO(11, this.xpv);
      AppMethodBeat.o(55530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label808;
      }
    }
    label808:
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
      if (this.fLr != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.fLr);
      }
      i = e.a.a.b.b.a.bl(10, this.xpu);
      int j = e.a.a.b.b.a.bl(11, this.xpv);
      AppMethodBeat.o(55530);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55530);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        baa localbaa = (baa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(55530);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbaa.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55530);
          return 0;
        case 2: 
          localbaa.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55530);
          return 0;
        case 3: 
          localbaa.wDh = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(55530);
          return 0;
        case 4: 
          localbaa.wDi = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(55530);
          return 0;
        case 5: 
          localbaa.wSk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55530);
          return 0;
        case 6: 
          localbaa.wSl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55530);
          return 0;
        case 7: 
          localbaa.wSm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55530);
          return 0;
        case 8: 
          localbaa.wSn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55530);
          return 0;
        case 9: 
          localbaa.fLr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55530);
          return 0;
        case 10: 
          localbaa.xpu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55530);
          return 0;
        }
        localbaa.xpv = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(55530);
        return 0;
      }
      AppMethodBeat.o(55530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baa
 * JD-Core Version:    0.7.0.1
 */