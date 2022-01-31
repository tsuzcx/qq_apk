package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bom
  extends buy
{
  public int jJS;
  public String num;
  public int wQP;
  public long wQQ;
  public long xCj;
  public long xCm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28591);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.num == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(28591);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.num != null) {
        paramVarArgs.e(2, this.num);
      }
      paramVarArgs.aO(3, this.wQP);
      paramVarArgs.am(4, this.wQQ);
      paramVarArgs.am(5, this.xCj);
      paramVarArgs.am(6, this.xCm);
      paramVarArgs.aO(7, this.jJS);
      AppMethodBeat.o(28591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label667;
      }
    }
    label667:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.num != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.num);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.wQP);
      int j = e.a.a.b.b.a.p(4, this.wQQ);
      int k = e.a.a.b.b.a.p(5, this.xCj);
      int m = e.a.a.b.b.a.p(6, this.xCm);
      int n = e.a.a.b.b.a.bl(7, this.jJS);
      AppMethodBeat.o(28591);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.num == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(28591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bom localbom = (bom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28591);
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
            localbom.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28591);
          return 0;
        case 2: 
          localbom.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28591);
          return 0;
        case 3: 
          localbom.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28591);
          return 0;
        case 4: 
          localbom.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28591);
          return 0;
        case 5: 
          localbom.xCj = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28591);
          return 0;
        case 6: 
          localbom.xCm = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28591);
          return 0;
        }
        localbom.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28591);
        return 0;
      }
      AppMethodBeat.o(28591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bom
 * JD-Core Version:    0.7.0.1
 */