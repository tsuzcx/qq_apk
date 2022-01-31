package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bht
  extends buy
{
  public int cCc;
  public String token;
  public String wvn;
  public String xwL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48903);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wvn != null) {
        paramVarArgs.e(2, this.wvn);
      }
      if (this.xwL != null) {
        paramVarArgs.e(3, this.xwL);
      }
      paramVarArgs.aO(4, this.cCc);
      if (this.token != null) {
        paramVarArgs.e(5, this.token);
      }
      AppMethodBeat.o(48903);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wvn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wvn);
      }
      i = paramInt;
      if (this.xwL != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xwL);
      }
      i += e.a.a.b.b.a.bl(4, this.cCc);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.token);
      }
      AppMethodBeat.o(48903);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48903);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bht localbht = (bht)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48903);
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
            localbht.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48903);
          return 0;
        case 2: 
          localbht.wvn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48903);
          return 0;
        case 3: 
          localbht.xwL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48903);
          return 0;
        case 4: 
          localbht.cCc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48903);
          return 0;
        }
        localbht.token = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48903);
        return 0;
      }
      AppMethodBeat.o(48903);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bht
 * JD-Core Version:    0.7.0.1
 */