package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bla
  extends buy
{
  public String fKw;
  public String wJT;
  public String wKV;
  public String wKW;
  public String wKX;
  public String wKY;
  public String wvC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56885);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      if (this.wKV != null) {
        paramVarArgs.e(3, this.wKV);
      }
      if (this.wvC != null) {
        paramVarArgs.e(4, this.wvC);
      }
      if (this.wKW != null) {
        paramVarArgs.e(5, this.wKW);
      }
      if (this.wKX != null) {
        paramVarArgs.e(6, this.wKX);
      }
      if (this.wKY != null) {
        paramVarArgs.e(7, this.wKY);
      }
      if (this.wJT != null) {
        paramVarArgs.e(8, this.wJT);
      }
      AppMethodBeat.o(56885);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt;
      if (this.wKV != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wKV);
      }
      paramInt = i;
      if (this.wvC != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wvC);
      }
      i = paramInt;
      if (this.wKW != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wKW);
      }
      paramInt = i;
      if (this.wKX != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wKX);
      }
      i = paramInt;
      if (this.wKY != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wKY);
      }
      paramInt = i;
      if (this.wJT != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wJT);
      }
      AppMethodBeat.o(56885);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56885);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bla localbla = (bla)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56885);
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
            localbla.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56885);
          return 0;
        case 2: 
          localbla.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56885);
          return 0;
        case 3: 
          localbla.wKV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56885);
          return 0;
        case 4: 
          localbla.wvC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56885);
          return 0;
        case 5: 
          localbla.wKW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56885);
          return 0;
        case 6: 
          localbla.wKX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56885);
          return 0;
        case 7: 
          localbla.wKY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56885);
          return 0;
        }
        localbla.wJT = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56885);
        return 0;
      }
      AppMethodBeat.o(56885);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bla
 * JD-Core Version:    0.7.0.1
 */