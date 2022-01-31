package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abg
  extends buy
{
  public String city;
  public String lHq;
  public String province;
  public String wRH;
  public String wRI;
  public long wRJ;
  public double wRK;
  public double wRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56784);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lHq != null) {
        paramVarArgs.e(2, this.lHq);
      }
      if (this.city != null) {
        paramVarArgs.e(3, this.city);
      }
      if (this.province != null) {
        paramVarArgs.e(4, this.province);
      }
      if (this.wRH != null) {
        paramVarArgs.e(5, this.wRH);
      }
      if (this.wRI != null) {
        paramVarArgs.e(6, this.wRI);
      }
      paramVarArgs.am(7, this.wRJ);
      paramVarArgs.f(8, this.wRK);
      paramVarArgs.f(9, this.wRL);
      AppMethodBeat.o(56784);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label760;
      }
    }
    label760:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lHq != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.lHq);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.city);
      }
      paramInt = i;
      if (this.province != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.province);
      }
      i = paramInt;
      if (this.wRH != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wRH);
      }
      paramInt = i;
      if (this.wRI != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wRI);
      }
      i = e.a.a.b.b.a.p(7, this.wRJ);
      int j = e.a.a.b.b.a.eW(8);
      int k = e.a.a.b.b.a.eW(9);
      AppMethodBeat.o(56784);
      return paramInt + i + (j + 8) + (k + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56784);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        abg localabg = (abg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56784);
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
            localabg.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56784);
          return 0;
        case 2: 
          localabg.lHq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56784);
          return 0;
        case 3: 
          localabg.city = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56784);
          return 0;
        case 4: 
          localabg.province = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56784);
          return 0;
        case 5: 
          localabg.wRH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56784);
          return 0;
        case 6: 
          localabg.wRI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56784);
          return 0;
        case 7: 
          localabg.wRJ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56784);
          return 0;
        case 8: 
          localabg.wRK = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(56784);
          return 0;
        }
        localabg.wRL = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
        AppMethodBeat.o(56784);
        return 0;
      }
      AppMethodBeat.o(56784);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abg
 * JD-Core Version:    0.7.0.1
 */