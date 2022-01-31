package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yw
  extends buy
{
  public int pIE;
  public long pIG;
  public long wPT;
  public String wot;
  public String wpS;
  public int wyT;
  public int wzS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116802);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.pIE);
      paramVarArgs.aO(2, this.wzS);
      paramVarArgs.aO(3, this.wyT);
      if (this.wpS != null) {
        paramVarArgs.e(4, this.wpS);
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(5, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.am(6, this.pIG);
      if (this.wot != null) {
        paramVarArgs.e(7, this.wot);
      }
      paramVarArgs.am(8, this.wPT);
      AppMethodBeat.o(116802);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.pIE) + 0 + e.a.a.b.b.a.bl(2, this.wzS) + e.a.a.b.b.a.bl(3, this.wyT);
      paramInt = i;
      if (this.wpS != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wpS);
      }
      i = paramInt;
      if (this.BaseRequest != null) {
        i = paramInt + e.a.a.a.iP(5, this.BaseRequest.computeSize());
      }
      i += e.a.a.b.b.a.p(6, this.pIG);
      paramInt = i;
      if (this.wot != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wot);
      }
      i = e.a.a.b.b.a.p(8, this.wPT);
      AppMethodBeat.o(116802);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(116802);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      yw localyw = (yw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(116802);
        return -1;
      case 1: 
        localyw.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116802);
        return 0;
      case 2: 
        localyw.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116802);
        return 0;
      case 3: 
        localyw.wyT = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116802);
        return 0;
      case 4: 
        localyw.wpS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(116802);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hq();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localyw.BaseRequest = ((hq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116802);
        return 0;
      case 6: 
        localyw.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(116802);
        return 0;
      case 7: 
        localyw.wot = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(116802);
        return 0;
      }
      localyw.wPT = ((e.a.a.a.a)localObject1).CLY.sm();
      AppMethodBeat.o(116802);
      return 0;
    }
    AppMethodBeat.o(116802);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yw
 * JD-Core Version:    0.7.0.1
 */