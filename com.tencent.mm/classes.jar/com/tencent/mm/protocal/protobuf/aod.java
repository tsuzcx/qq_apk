package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aod
  extends buy
{
  public String coX;
  public String crs;
  public String mKo;
  public String mKp;
  public String mKq;
  public String wkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28458);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.coX != null) {
        paramVarArgs.e(2, this.coX);
      }
      if (this.mKo != null) {
        paramVarArgs.e(3, this.mKo);
      }
      if (this.mKp != null) {
        paramVarArgs.e(4, this.mKp);
      }
      if (this.mKq != null) {
        paramVarArgs.e(5, this.mKq);
      }
      if (this.crs != null) {
        paramVarArgs.e(6, this.crs);
      }
      if (this.wkY != null) {
        paramVarArgs.e(7, this.wkY);
      }
      AppMethodBeat.o(28458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label687;
      }
    }
    label687:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.coX != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.coX);
      }
      i = paramInt;
      if (this.mKo != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.mKo);
      }
      paramInt = i;
      if (this.mKp != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.mKp);
      }
      i = paramInt;
      if (this.mKq != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.mKq);
      }
      paramInt = i;
      if (this.crs != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.crs);
      }
      i = paramInt;
      if (this.wkY != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wkY);
      }
      AppMethodBeat.o(28458);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aod localaod = (aod)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28458);
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
            localaod.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28458);
          return 0;
        case 2: 
          localaod.coX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28458);
          return 0;
        case 3: 
          localaod.mKo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28458);
          return 0;
        case 4: 
          localaod.mKp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28458);
          return 0;
        case 5: 
          localaod.mKq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28458);
          return 0;
        case 6: 
          localaod.crs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28458);
          return 0;
        }
        localaod.wkY = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28458);
        return 0;
      }
      AppMethodBeat.o(28458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aod
 * JD-Core Version:    0.7.0.1
 */