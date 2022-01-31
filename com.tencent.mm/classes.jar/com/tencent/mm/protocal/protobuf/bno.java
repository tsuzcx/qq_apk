package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bno
  extends buy
{
  public String ProductID;
  public String nuz;
  public int pqf;
  public String xBK;
  public String xBL;
  public int xBM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56931);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.e(2, this.ProductID);
      }
      if (this.xBK != null) {
        paramVarArgs.e(3, this.xBK);
      }
      if (this.xBL != null) {
        paramVarArgs.e(4, this.xBL);
      }
      paramVarArgs.aO(5, this.pqf);
      if (this.nuz != null) {
        paramVarArgs.e(7, this.nuz);
      }
      paramVarArgs.aO(8, this.xBM);
      AppMethodBeat.o(56931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ProductID);
      }
      i = paramInt;
      if (this.xBK != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xBK);
      }
      paramInt = i;
      if (this.xBL != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xBL);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.pqf);
      paramInt = i;
      if (this.nuz != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.nuz);
      }
      i = e.a.a.b.b.a.bl(8, this.xBM);
      AppMethodBeat.o(56931);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56931);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bno localbno = (bno)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(56931);
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
            localbno.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56931);
          return 0;
        case 2: 
          localbno.ProductID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56931);
          return 0;
        case 3: 
          localbno.xBK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56931);
          return 0;
        case 4: 
          localbno.xBL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56931);
          return 0;
        case 5: 
          localbno.pqf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56931);
          return 0;
        case 7: 
          localbno.nuz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56931);
          return 0;
        }
        localbno.xBM = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56931);
        return 0;
      }
      AppMethodBeat.o(56931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bno
 * JD-Core Version:    0.7.0.1
 */