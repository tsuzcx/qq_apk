package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class apd
  extends buy
{
  public float cAH;
  public float cyV;
  public long swu;
  public int xfi;
  public LinkedList<b> xfj;
  public long xfk;
  public long xfl;
  
  public apd()
  {
    AppMethodBeat.i(108894);
    this.xfj = new LinkedList();
    AppMethodBeat.o(108894);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108895);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xfi);
      paramVarArgs.q(3, this.cyV);
      paramVarArgs.q(4, this.cAH);
      paramVarArgs.e(5, 6, this.xfj);
      paramVarArgs.am(6, this.swu);
      paramVarArgs.am(7, this.xfk);
      paramVarArgs.am(8, this.xfl);
      AppMethodBeat.o(108895);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label656;
      }
    }
    label656:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xfi);
      int j = e.a.a.b.b.a.eW(3);
      int k = e.a.a.b.b.a.eW(4);
      int m = e.a.a.a.c(5, 6, this.xfj);
      int n = e.a.a.b.b.a.p(6, this.swu);
      int i1 = e.a.a.b.b.a.p(7, this.xfk);
      int i2 = e.a.a.b.b.a.p(8, this.xfl);
      AppMethodBeat.o(108895);
      return paramInt + i + (j + 4) + (k + 4) + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xfj.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(108895);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        apd localapd = (apd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(108895);
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
            localapd.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108895);
          return 0;
        case 2: 
          localapd.xfi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(108895);
          return 0;
        case 3: 
          localapd.cyV = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(108895);
          return 0;
        case 4: 
          localapd.cAH = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(108895);
          return 0;
        case 5: 
          localapd.xfj.add(((e.a.a.a.a)localObject1).CLY.eqS());
          AppMethodBeat.o(108895);
          return 0;
        case 6: 
          localapd.swu = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(108895);
          return 0;
        case 7: 
          localapd.xfk = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(108895);
          return 0;
        }
        localapd.xfl = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(108895);
        return 0;
      }
      AppMethodBeat.o(108895);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apd
 * JD-Core Version:    0.7.0.1
 */