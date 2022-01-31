package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cnt
  extends buy
{
  public String fKw;
  public String jJA;
  public int jKs;
  public SKBuiltinBuffer_t pIA;
  public int pIx;
  public int pIy;
  public int pIz;
  public String wQr;
  public int wpR;
  public String xWD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28687);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(28687);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      paramVarArgs.aO(3, this.wpR);
      if (this.xWD != null) {
        paramVarArgs.e(4, this.xWD);
      }
      if (this.jJA != null) {
        paramVarArgs.e(5, this.jJA);
      }
      paramVarArgs.aO(6, this.pIx);
      paramVarArgs.aO(7, this.pIy);
      paramVarArgs.aO(8, this.pIz);
      if (this.pIA != null)
      {
        paramVarArgs.iQ(9, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(10, this.jKs);
      if (this.wQr != null) {
        paramVarArgs.e(11, this.wQr);
      }
      AppMethodBeat.o(28687);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label999;
      }
    }
    label999:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fKw != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.fKw);
      }
      i += e.a.a.b.b.a.bl(3, this.wpR);
      paramInt = i;
      if (this.xWD != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xWD);
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.jJA);
      }
      i = i + e.a.a.b.b.a.bl(6, this.pIx) + e.a.a.b.b.a.bl(7, this.pIy) + e.a.a.b.b.a.bl(8, this.pIz);
      paramInt = i;
      if (this.pIA != null) {
        paramInt = i + e.a.a.a.iP(9, this.pIA.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.jKs);
      paramInt = i;
      if (this.wQr != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wQr);
      }
      AppMethodBeat.o(28687);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(28687);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28687);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cnt localcnt = (cnt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28687);
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
            localcnt.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28687);
          return 0;
        case 2: 
          localcnt.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28687);
          return 0;
        case 3: 
          localcnt.wpR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28687);
          return 0;
        case 4: 
          localcnt.xWD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28687);
          return 0;
        case 5: 
          localcnt.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28687);
          return 0;
        case 6: 
          localcnt.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28687);
          return 0;
        case 7: 
          localcnt.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28687);
          return 0;
        case 8: 
          localcnt.pIz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28687);
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
            localcnt.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28687);
          return 0;
        case 10: 
          localcnt.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28687);
          return 0;
        }
        localcnt.wQr = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28687);
        return 0;
      }
      AppMethodBeat.o(28687);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnt
 * JD-Core Version:    0.7.0.1
 */