package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abq
  extends buy
{
  public int cpt;
  public String cwc;
  public int mha;
  public String wRS;
  public long wSa;
  public String wSb;
  public String wSc;
  public int wSd;
  public float wSe;
  public int wSf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(841);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cwc != null) {
        paramVarArgs.e(2, this.cwc);
      }
      paramVarArgs.am(3, this.wSa);
      if (this.wRS != null) {
        paramVarArgs.e(4, this.wRS);
      }
      if (this.wSb != null) {
        paramVarArgs.e(5, this.wSb);
      }
      if (this.wSc != null) {
        paramVarArgs.e(6, this.wSc);
      }
      paramVarArgs.aO(7, this.cpt);
      paramVarArgs.aO(8, this.wSd);
      paramVarArgs.aO(9, this.mha);
      paramVarArgs.q(10, this.wSe);
      paramVarArgs.aO(11, this.wSf);
      AppMethodBeat.o(841);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cwc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cwc);
      }
      i += e.a.a.b.b.a.p(3, this.wSa);
      paramInt = i;
      if (this.wRS != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wRS);
      }
      i = paramInt;
      if (this.wSb != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wSb);
      }
      paramInt = i;
      if (this.wSc != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wSc);
      }
      i = e.a.a.b.b.a.bl(7, this.cpt);
      int j = e.a.a.b.b.a.bl(8, this.wSd);
      int k = e.a.a.b.b.a.bl(9, this.mha);
      int m = e.a.a.b.b.a.eW(10);
      int n = e.a.a.b.b.a.bl(11, this.wSf);
      AppMethodBeat.o(841);
      return paramInt + i + j + k + (m + 4) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(841);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        abq localabq = (abq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(841);
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
            localabq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(841);
          return 0;
        case 2: 
          localabq.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(841);
          return 0;
        case 3: 
          localabq.wSa = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(841);
          return 0;
        case 4: 
          localabq.wRS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(841);
          return 0;
        case 5: 
          localabq.wSb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(841);
          return 0;
        case 6: 
          localabq.wSc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(841);
          return 0;
        case 7: 
          localabq.cpt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(841);
          return 0;
        case 8: 
          localabq.wSd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(841);
          return 0;
        case 9: 
          localabq.mha = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(841);
          return 0;
        case 10: 
          localabq.wSe = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(841);
          return 0;
        }
        localabq.wSf = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(841);
        return 0;
      }
      AppMethodBeat.o(841);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abq
 * JD-Core Version:    0.7.0.1
 */