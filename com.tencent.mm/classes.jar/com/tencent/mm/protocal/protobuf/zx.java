package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class zx
  extends buy
{
  public int niK;
  public b wPb;
  public b wQU;
  public String wxM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11747);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wxM != null) {
        paramVarArgs.e(2, this.wxM);
      }
      paramVarArgs.aO(3, this.niK);
      if (this.wQU != null) {
        paramVarArgs.c(4, this.wQU);
      }
      if (this.wPb != null) {
        paramVarArgs.c(5, this.wPb);
      }
      AppMethodBeat.o(11747);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label545;
      }
    }
    label545:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wxM != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wxM);
      }
      i += e.a.a.b.b.a.bl(3, this.niK);
      paramInt = i;
      if (this.wQU != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.wQU);
      }
      i = paramInt;
      if (this.wPb != null) {
        i = paramInt + e.a.a.b.b.a.b(5, this.wPb);
      }
      AppMethodBeat.o(11747);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11747);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        zx localzx = (zx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11747);
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
            localzx.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11747);
          return 0;
        case 2: 
          localzx.wxM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11747);
          return 0;
        case 3: 
          localzx.niK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11747);
          return 0;
        case 4: 
          localzx.wQU = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(11747);
          return 0;
        }
        localzx.wPb = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(11747);
        return 0;
      }
      AppMethodBeat.o(11747);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zx
 * JD-Core Version:    0.7.0.1
 */