package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class crl
  extends bvk
{
  public int wQP;
  public long wQQ;
  public int xZW;
  public int yad;
  public csu yae;
  public int yaf;
  public int yag;
  public int yah;
  public int yai;
  public SKBuiltinBuffer_t yaj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5226);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(5226);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wQP);
      paramVarArgs.am(3, this.wQQ);
      paramVarArgs.aO(4, this.yad);
      if (this.yae != null)
      {
        paramVarArgs.iQ(5, this.yae.computeSize());
        this.yae.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.xZW);
      paramVarArgs.aO(7, this.yaf);
      paramVarArgs.aO(8, this.yag);
      paramVarArgs.aO(9, this.yah);
      paramVarArgs.aO(10, this.yai);
      if (this.yaj != null)
      {
        paramVarArgs.iQ(11, this.yaj.computeSize());
        this.yaj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(5226);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1039;
      }
    }
    label1039:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wQP) + e.a.a.b.b.a.p(3, this.wQQ) + e.a.a.b.b.a.bl(4, this.yad);
      paramInt = i;
      if (this.yae != null) {
        paramInt = i + e.a.a.a.iP(5, this.yae.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.xZW) + e.a.a.b.b.a.bl(7, this.yaf) + e.a.a.b.b.a.bl(8, this.yag) + e.a.a.b.b.a.bl(9, this.yah) + e.a.a.b.b.a.bl(10, this.yai);
      paramInt = i;
      if (this.yaj != null) {
        paramInt = i + e.a.a.a.iP(11, this.yaj.computeSize());
      }
      AppMethodBeat.o(5226);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(5226);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5226);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        crl localcrl = (crl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5226);
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
            localcrl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5226);
          return 0;
        case 2: 
          localcrl.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5226);
          return 0;
        case 3: 
          localcrl.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5226);
          return 0;
        case 4: 
          localcrl.yad = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5226);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrl.yae = ((csu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5226);
          return 0;
        case 6: 
          localcrl.xZW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5226);
          return 0;
        case 7: 
          localcrl.yaf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5226);
          return 0;
        case 8: 
          localcrl.yag = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5226);
          return 0;
        case 9: 
          localcrl.yah = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5226);
          return 0;
        case 10: 
          localcrl.yai = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5226);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcrl.yaj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5226);
        return 0;
      }
      AppMethodBeat.o(5226);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crl
 * JD-Core Version:    0.7.0.1
 */