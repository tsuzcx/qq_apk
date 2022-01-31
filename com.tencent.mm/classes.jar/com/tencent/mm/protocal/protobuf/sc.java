package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sc
  extends buy
{
  public String wKq;
  public String wKr;
  public String wKs;
  public String wKt;
  public String wKu;
  public long wKv;
  public String wKw;
  public String wKx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28357);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wKq != null) {
        paramVarArgs.e(2, this.wKq);
      }
      if (this.wKr != null) {
        paramVarArgs.e(3, this.wKr);
      }
      if (this.wKs != null) {
        paramVarArgs.e(4, this.wKs);
      }
      if (this.wKt != null) {
        paramVarArgs.e(5, this.wKt);
      }
      if (this.wKu != null) {
        paramVarArgs.e(6, this.wKu);
      }
      paramVarArgs.am(7, this.wKv);
      if (this.wKw != null) {
        paramVarArgs.e(8, this.wKw);
      }
      if (this.wKx != null) {
        paramVarArgs.e(9, this.wKx);
      }
      AppMethodBeat.o(28357);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label797;
      }
    }
    label797:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wKq != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wKq);
      }
      i = paramInt;
      if (this.wKr != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wKr);
      }
      paramInt = i;
      if (this.wKs != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wKs);
      }
      i = paramInt;
      if (this.wKt != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wKt);
      }
      paramInt = i;
      if (this.wKu != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wKu);
      }
      i = paramInt + e.a.a.b.b.a.p(7, this.wKv);
      paramInt = i;
      if (this.wKw != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wKw);
      }
      i = paramInt;
      if (this.wKx != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wKx);
      }
      AppMethodBeat.o(28357);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28357);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        sc localsc = (sc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28357);
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
            localsc.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28357);
          return 0;
        case 2: 
          localsc.wKq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28357);
          return 0;
        case 3: 
          localsc.wKr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28357);
          return 0;
        case 4: 
          localsc.wKs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28357);
          return 0;
        case 5: 
          localsc.wKt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28357);
          return 0;
        case 6: 
          localsc.wKu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28357);
          return 0;
        case 7: 
          localsc.wKv = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28357);
          return 0;
        case 8: 
          localsc.wKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28357);
          return 0;
        }
        localsc.wKx = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28357);
        return 0;
      }
      AppMethodBeat.o(28357);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sc
 * JD-Core Version:    0.7.0.1
 */