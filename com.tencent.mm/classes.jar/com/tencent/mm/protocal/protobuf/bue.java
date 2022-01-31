package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bue
  extends buy
{
  public float cAH;
  public String cHn;
  public float cyV;
  public float xHv;
  public b xHw;
  public boolean xHx;
  public boolean xHy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89131);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.q(2, this.cAH);
      paramVarArgs.q(3, this.cyV);
      paramVarArgs.q(4, this.xHv);
      if (this.xHw != null) {
        paramVarArgs.c(5, this.xHw);
      }
      if (this.cHn != null) {
        paramVarArgs.e(6, this.cHn);
      }
      paramVarArgs.aS(7, this.xHx);
      paramVarArgs.aS(8, this.xHy);
      AppMethodBeat.o(89131);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label655;
      }
    }
    label655:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 4) + (e.a.a.b.b.a.eW(3) + 4) + (e.a.a.b.b.a.eW(4) + 4);
      paramInt = i;
      if (this.xHw != null) {
        paramInt = i + e.a.a.b.b.a.b(5, this.xHw);
      }
      i = paramInt;
      if (this.cHn != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.cHn);
      }
      paramInt = e.a.a.b.b.a.eW(7);
      int j = e.a.a.b.b.a.eW(8);
      AppMethodBeat.o(89131);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89131);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bue localbue = (bue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89131);
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
            localbue.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89131);
          return 0;
        case 2: 
          localbue.cAH = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(89131);
          return 0;
        case 3: 
          localbue.cyV = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(89131);
          return 0;
        case 4: 
          localbue.xHv = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(89131);
          return 0;
        case 5: 
          localbue.xHw = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(89131);
          return 0;
        case 6: 
          localbue.cHn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89131);
          return 0;
        case 7: 
          localbue.xHx = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(89131);
          return 0;
        }
        localbue.xHy = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(89131);
        return 0;
      }
      AppMethodBeat.o(89131);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bue
 * JD-Core Version:    0.7.0.1
 */