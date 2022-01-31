package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class ccd
  extends buy
{
  public int Scene;
  public int jJu;
  public LinkedList<Integer> wuv;
  public String xMA;
  
  public ccd()
  {
    AppMethodBeat.i(51433);
    this.wuv = new LinkedList();
    AppMethodBeat.o(51433);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51434);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xMA != null) {
        paramVarArgs.e(2, this.xMA);
      }
      paramVarArgs.aO(3, this.Scene);
      paramVarArgs.aO(4, this.jJu);
      paramVarArgs.f(5, 2, this.wuv);
      AppMethodBeat.o(51434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label537;
      }
    }
    label537:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xMA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xMA);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.Scene);
      int j = e.a.a.b.b.a.bl(4, this.jJu);
      int k = e.a.a.a.d(5, 2, this.wuv);
      AppMethodBeat.o(51434);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wuv.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ccd localccd = (ccd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(51434);
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
            localccd.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(51434);
          return 0;
        case 2: 
          localccd.xMA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51434);
          return 0;
        case 3: 
          localccd.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51434);
          return 0;
        case 4: 
          localccd.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51434);
          return 0;
        }
        localccd.wuv = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
        AppMethodBeat.o(51434);
        return 0;
      }
      AppMethodBeat.o(51434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccd
 * JD-Core Version:    0.7.0.1
 */