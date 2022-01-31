package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cqe
  extends buy
{
  public String ProductID;
  public int pqf;
  public String xBK;
  public String xBL;
  public int xBM;
  public String xBN;
  public SKBuiltinBuffer_t xYI;
  public int xYJ;
  public int xYK;
  public String xYL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56992);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xYI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Receipt");
        AppMethodBeat.o(56992);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xYI != null)
      {
        paramVarArgs.iQ(2, this.xYI.computeSize());
        this.xYI.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.e(3, this.ProductID);
      }
      paramVarArgs.aO(4, this.xYJ);
      paramVarArgs.aO(5, this.pqf);
      if (this.xBK != null) {
        paramVarArgs.e(6, this.xBK);
      }
      if (this.xBL != null) {
        paramVarArgs.e(7, this.xBL);
      }
      if (this.xBN != null) {
        paramVarArgs.e(8, this.xBN);
      }
      paramVarArgs.aO(9, this.xYK);
      if (this.xYL != null) {
        paramVarArgs.e(10, this.xYL);
      }
      paramVarArgs.aO(11, this.xBM);
      AppMethodBeat.o(56992);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label998;
      }
    }
    label998:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xYI != null) {
        paramInt = i + e.a.a.a.iP(2, this.xYI.computeSize());
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ProductID);
      }
      i = i + e.a.a.b.b.a.bl(4, this.xYJ) + e.a.a.b.b.a.bl(5, this.pqf);
      paramInt = i;
      if (this.xBK != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xBK);
      }
      i = paramInt;
      if (this.xBL != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xBL);
      }
      paramInt = i;
      if (this.xBN != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xBN);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.xYK);
      paramInt = i;
      if (this.xYL != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xYL);
      }
      i = e.a.a.b.b.a.bl(11, this.xBM);
      AppMethodBeat.o(56992);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xYI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Receipt");
          AppMethodBeat.o(56992);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56992);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cqe localcqe = (cqe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56992);
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
            localcqe.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56992);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqe.xYI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56992);
          return 0;
        case 3: 
          localcqe.ProductID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56992);
          return 0;
        case 4: 
          localcqe.xYJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56992);
          return 0;
        case 5: 
          localcqe.pqf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56992);
          return 0;
        case 6: 
          localcqe.xBK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56992);
          return 0;
        case 7: 
          localcqe.xBL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56992);
          return 0;
        case 8: 
          localcqe.xBN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56992);
          return 0;
        case 9: 
          localcqe.xYK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56992);
          return 0;
        case 10: 
          localcqe.xYL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56992);
          return 0;
        }
        localcqe.xBM = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56992);
        return 0;
      }
      AppMethodBeat.o(56992);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqe
 * JD-Core Version:    0.7.0.1
 */