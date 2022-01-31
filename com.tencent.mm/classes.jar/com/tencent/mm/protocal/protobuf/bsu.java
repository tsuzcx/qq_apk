package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsu
  extends buy
{
  public String tNy;
  public String wMw;
  public int wMx;
  public int xBA;
  public String xBE;
  public String xBF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56954);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xBA);
      if (this.xBF != null) {
        paramVarArgs.e(3, this.xBF);
      }
      if (this.wMw != null) {
        paramVarArgs.e(4, this.wMw);
      }
      paramVarArgs.aO(5, this.wMx);
      if (this.xBE != null) {
        paramVarArgs.e(6, this.xBE);
      }
      if (this.tNy != null) {
        paramVarArgs.e(100, this.tNy);
      }
      AppMethodBeat.o(56954);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xBA);
      paramInt = i;
      if (this.xBF != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xBF);
      }
      i = paramInt;
      if (this.wMw != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wMw);
      }
      i += e.a.a.b.b.a.bl(5, this.wMx);
      paramInt = i;
      if (this.xBE != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xBE);
      }
      i = paramInt;
      if (this.tNy != null) {
        i = paramInt + e.a.a.b.b.a.f(100, this.tNy);
      }
      AppMethodBeat.o(56954);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56954);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bsu localbsu = (bsu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56954);
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
            localbsu.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56954);
          return 0;
        case 2: 
          localbsu.xBA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56954);
          return 0;
        case 3: 
          localbsu.xBF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56954);
          return 0;
        case 4: 
          localbsu.wMw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56954);
          return 0;
        case 5: 
          localbsu.wMx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56954);
          return 0;
        case 6: 
          localbsu.xBE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56954);
          return 0;
        }
        localbsu.tNy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56954);
        return 0;
      }
      AppMethodBeat.o(56954);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsu
 * JD-Core Version:    0.7.0.1
 */