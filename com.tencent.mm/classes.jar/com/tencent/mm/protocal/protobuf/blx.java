package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blx
  extends buy
{
  public String fKw;
  public String nuz;
  public String wJT;
  public String wKV;
  public String wKW;
  public String wKX;
  public String wKY;
  public String wXP;
  public int wkX;
  public String wvC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56911);
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
      if (this.wXP != null) {
        paramVarArgs.e(9, this.wXP);
      }
      paramVarArgs.aO(10, this.wkX);
      if (this.nuz != null) {
        paramVarArgs.e(11, this.nuz);
      }
      AppMethodBeat.o(56911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
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
      i = paramInt;
      if (this.wXP != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wXP);
      }
      i += e.a.a.b.b.a.bl(10, this.wkX);
      paramInt = i;
      if (this.nuz != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.nuz);
      }
      AppMethodBeat.o(56911);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56911);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        blx localblx = (blx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56911);
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
            localblx.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56911);
          return 0;
        case 2: 
          localblx.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56911);
          return 0;
        case 3: 
          localblx.wKV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56911);
          return 0;
        case 4: 
          localblx.wvC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56911);
          return 0;
        case 5: 
          localblx.wKW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56911);
          return 0;
        case 6: 
          localblx.wKX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56911);
          return 0;
        case 7: 
          localblx.wKY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56911);
          return 0;
        case 8: 
          localblx.wJT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56911);
          return 0;
        case 9: 
          localblx.wXP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56911);
          return 0;
        case 10: 
          localblx.wkX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56911);
          return 0;
        }
        localblx.nuz = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56911);
        return 0;
      }
      AppMethodBeat.o(56911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blx
 * JD-Core Version:    0.7.0.1
 */