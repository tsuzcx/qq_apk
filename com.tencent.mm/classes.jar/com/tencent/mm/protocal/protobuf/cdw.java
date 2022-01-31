package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdw
  extends buy
{
  public int jKs;
  public int pIx;
  public int pIy;
  public String xOt;
  public int xOu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94573);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.pIy);
      paramVarArgs.aO(3, this.pIx);
      if (this.xOt != null) {
        paramVarArgs.e(4, this.xOt);
      }
      paramVarArgs.aO(5, this.jKs);
      paramVarArgs.aO(6, this.xOu);
      AppMethodBeat.o(94573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIy) + e.a.a.b.b.a.bl(3, this.pIx);
      paramInt = i;
      if (this.xOt != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xOt);
      }
      i = e.a.a.b.b.a.bl(5, this.jKs);
      int j = e.a.a.b.b.a.bl(6, this.xOu);
      AppMethodBeat.o(94573);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cdw localcdw = (cdw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94573);
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
            localcdw.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94573);
          return 0;
        case 2: 
          localcdw.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94573);
          return 0;
        case 3: 
          localcdw.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94573);
          return 0;
        case 4: 
          localcdw.xOt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94573);
          return 0;
        case 5: 
          localcdw.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94573);
          return 0;
        }
        localcdw.xOu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94573);
        return 0;
      }
      AppMethodBeat.o(94573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdw
 * JD-Core Version:    0.7.0.1
 */