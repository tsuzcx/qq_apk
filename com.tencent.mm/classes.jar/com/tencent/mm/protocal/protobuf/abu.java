package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abu
  extends buy
{
  public int OpCode;
  public float wDh;
  public float wDi;
  public String wQf;
  public String wSj;
  public int wSk;
  public String wSl;
  public String wSm;
  public int wSn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28403);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.OpCode);
      if (this.wSj != null) {
        paramVarArgs.e(3, this.wSj);
      }
      paramVarArgs.q(4, this.wDh);
      paramVarArgs.q(5, this.wDi);
      paramVarArgs.aO(6, this.wSk);
      if (this.wSl != null) {
        paramVarArgs.e(7, this.wSl);
      }
      if (this.wSm != null) {
        paramVarArgs.e(8, this.wSm);
      }
      paramVarArgs.aO(9, this.wSn);
      if (this.wQf != null) {
        paramVarArgs.e(10, this.wQf);
      }
      AppMethodBeat.o(28403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label796;
      }
    }
    label796:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.OpCode);
      paramInt = i;
      if (this.wSj != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wSj);
      }
      i = paramInt + (e.a.a.b.b.a.eW(4) + 4) + (e.a.a.b.b.a.eW(5) + 4) + e.a.a.b.b.a.bl(6, this.wSk);
      paramInt = i;
      if (this.wSl != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wSl);
      }
      i = paramInt;
      if (this.wSm != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wSm);
      }
      i += e.a.a.b.b.a.bl(9, this.wSn);
      paramInt = i;
      if (this.wQf != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wQf);
      }
      AppMethodBeat.o(28403);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        abu localabu = (abu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28403);
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
            localabu.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28403);
          return 0;
        case 2: 
          localabu.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28403);
          return 0;
        case 3: 
          localabu.wSj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28403);
          return 0;
        case 4: 
          localabu.wDh = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(28403);
          return 0;
        case 5: 
          localabu.wDi = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(28403);
          return 0;
        case 6: 
          localabu.wSk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28403);
          return 0;
        case 7: 
          localabu.wSl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28403);
          return 0;
        case 8: 
          localabu.wSm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28403);
          return 0;
        case 9: 
          localabu.wSn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28403);
          return 0;
        }
        localabu.wQf = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28403);
        return 0;
      }
      AppMethodBeat.o(28403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abu
 * JD-Core Version:    0.7.0.1
 */