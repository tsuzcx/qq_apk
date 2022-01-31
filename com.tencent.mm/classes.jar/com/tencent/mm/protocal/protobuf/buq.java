package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buq
  extends buy
{
  public int Scene;
  public String fKw;
  public long xCj;
  public long xIh;
  public String xIi;
  public int xIj;
  public int xIk;
  public int xIl;
  public long xIm;
  public int xpv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151925);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.am(2, this.xIh);
      if (this.xIi != null) {
        paramVarArgs.e(3, this.xIi);
      }
      paramVarArgs.aO(4, this.Scene);
      paramVarArgs.aO(5, this.xIj);
      paramVarArgs.aO(6, this.xpv);
      paramVarArgs.aO(7, this.xIk);
      paramVarArgs.am(8, this.xCj);
      paramVarArgs.aO(9, this.xIl);
      if (this.fKw != null) {
        paramVarArgs.e(10, this.fKw);
      }
      paramVarArgs.am(11, this.xIm);
      AppMethodBeat.o(151925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.xIh);
      paramInt = i;
      if (this.xIi != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xIi);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.Scene) + e.a.a.b.b.a.bl(5, this.xIj) + e.a.a.b.b.a.bl(6, this.xpv) + e.a.a.b.b.a.bl(7, this.xIk) + e.a.a.b.b.a.p(8, this.xCj) + e.a.a.b.b.a.bl(9, this.xIl);
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.fKw);
      }
      i = e.a.a.b.b.a.p(11, this.xIm);
      AppMethodBeat.o(151925);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        buq localbuq = (buq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151925);
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
            localbuq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151925);
          return 0;
        case 2: 
          localbuq.xIh = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(151925);
          return 0;
        case 3: 
          localbuq.xIi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151925);
          return 0;
        case 4: 
          localbuq.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151925);
          return 0;
        case 5: 
          localbuq.xIj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151925);
          return 0;
        case 6: 
          localbuq.xpv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151925);
          return 0;
        case 7: 
          localbuq.xIk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151925);
          return 0;
        case 8: 
          localbuq.xCj = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(151925);
          return 0;
        case 9: 
          localbuq.xIl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151925);
          return 0;
        case 10: 
          localbuq.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151925);
          return 0;
        }
        localbuq.xIm = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(151925);
        return 0;
      }
      AppMethodBeat.o(151925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buq
 * JD-Core Version:    0.7.0.1
 */