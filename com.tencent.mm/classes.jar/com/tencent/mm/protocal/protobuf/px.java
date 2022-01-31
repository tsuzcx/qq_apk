package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class px
  extends buy
{
  public String kNU;
  public int okH;
  public b wIl;
  public b wIm;
  public int wIn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56754);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.okH);
      if (this.wIl != null) {
        paramVarArgs.c(3, this.wIl);
      }
      if (this.wIm != null) {
        paramVarArgs.c(4, this.wIm);
      }
      if (this.kNU != null) {
        paramVarArgs.e(5, this.kNU);
      }
      paramVarArgs.aO(6, this.wIn);
      AppMethodBeat.o(56754);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.okH);
      paramInt = i;
      if (this.wIl != null) {
        paramInt = i + e.a.a.b.b.a.b(3, this.wIl);
      }
      i = paramInt;
      if (this.wIm != null) {
        i = paramInt + e.a.a.b.b.a.b(4, this.wIm);
      }
      paramInt = i;
      if (this.kNU != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.kNU);
      }
      i = e.a.a.b.b.a.bl(6, this.wIn);
      AppMethodBeat.o(56754);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56754);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        px localpx = (px)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56754);
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
            localpx.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56754);
          return 0;
        case 2: 
          localpx.okH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56754);
          return 0;
        case 3: 
          localpx.wIl = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(56754);
          return 0;
        case 4: 
          localpx.wIm = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(56754);
          return 0;
        case 5: 
          localpx.kNU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56754);
          return 0;
        }
        localpx.wIn = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56754);
        return 0;
      }
      AppMethodBeat.o(56754);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.px
 * JD-Core Version:    0.7.0.1
 */