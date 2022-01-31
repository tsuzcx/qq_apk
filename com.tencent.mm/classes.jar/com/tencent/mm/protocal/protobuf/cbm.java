package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cbm
  extends buy
{
  public int fKi;
  public SKBuiltinBuffer_t pIA;
  public float wDi;
  public int wLO;
  public int wpR;
  public int xMg;
  public float xMh;
  public float xMi;
  public int xeu;
  public int xev;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28646);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(28646);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.pIA != null)
      {
        paramVarArgs.iQ(2, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xMg);
      paramVarArgs.aO(4, this.fKi);
      paramVarArgs.q(5, this.xMh);
      paramVarArgs.aO(6, this.wLO);
      paramVarArgs.aO(7, this.wpR);
      paramVarArgs.q(8, this.xMi);
      paramVarArgs.q(9, this.wDi);
      paramVarArgs.aO(10, this.xeu);
      paramVarArgs.aO(11, this.xev);
      AppMethodBeat.o(28646);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label960;
      }
    }
    label960:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pIA != null) {
        i = paramInt + e.a.a.a.iP(2, this.pIA.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xMg);
      int j = e.a.a.b.b.a.bl(4, this.fKi);
      int k = e.a.a.b.b.a.eW(5);
      int m = e.a.a.b.b.a.bl(6, this.wLO);
      int n = e.a.a.b.b.a.bl(7, this.wpR);
      int i1 = e.a.a.b.b.a.eW(8);
      int i2 = e.a.a.b.b.a.eW(9);
      int i3 = e.a.a.b.b.a.bl(10, this.xeu);
      int i4 = e.a.a.b.b.a.bl(11, this.xev);
      AppMethodBeat.o(28646);
      return i + paramInt + j + (k + 4) + m + n + (i1 + 4) + (i2 + 4) + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(28646);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28646);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cbm localcbm = (cbm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28646);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbm.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28646);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbm.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28646);
          return 0;
        case 3: 
          localcbm.xMg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28646);
          return 0;
        case 4: 
          localcbm.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28646);
          return 0;
        case 5: 
          localcbm.xMh = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(28646);
          return 0;
        case 6: 
          localcbm.wLO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28646);
          return 0;
        case 7: 
          localcbm.wpR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28646);
          return 0;
        case 8: 
          localcbm.xMi = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(28646);
          return 0;
        case 9: 
          localcbm.wDi = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(28646);
          return 0;
        case 10: 
          localcbm.xeu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28646);
          return 0;
        }
        localcbm.xev = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28646);
        return 0;
      }
      AppMethodBeat.o(28646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbm
 * JD-Core Version:    0.7.0.1
 */