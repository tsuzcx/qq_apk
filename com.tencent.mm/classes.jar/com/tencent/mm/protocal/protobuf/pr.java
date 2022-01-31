package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pr
  extends buy
{
  public String kqi;
  public String nickname;
  public int okH;
  public String qjK;
  public String qjV;
  public String qjW;
  public String qkn;
  public String qkq;
  public String wHX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56746);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.okH);
      if (this.kqi != null) {
        paramVarArgs.e(3, this.kqi);
      }
      if (this.qkn != null) {
        paramVarArgs.e(4, this.qkn);
      }
      if (this.wHX != null) {
        paramVarArgs.e(5, this.wHX);
      }
      if (this.qjV != null) {
        paramVarArgs.e(6, this.qjV);
      }
      if (this.qjW != null) {
        paramVarArgs.e(7, this.qjW);
      }
      if (this.qkq != null) {
        paramVarArgs.e(8, this.qkq);
      }
      if (this.nickname != null) {
        paramVarArgs.e(9, this.nickname);
      }
      if (this.qjK != null) {
        paramVarArgs.e(10, this.qjK);
      }
      AppMethodBeat.o(56746);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.okH);
      paramInt = i;
      if (this.kqi != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kqi);
      }
      i = paramInt;
      if (this.qkn != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.qkn);
      }
      paramInt = i;
      if (this.wHX != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wHX);
      }
      i = paramInt;
      if (this.qjV != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.qjV);
      }
      paramInt = i;
      if (this.qjW != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.qjW);
      }
      i = paramInt;
      if (this.qkq != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.qkq);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.nickname);
      }
      i = paramInt;
      if (this.qjK != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.qjK);
      }
      AppMethodBeat.o(56746);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56746);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        pr localpr = (pr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56746);
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
            localpr.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56746);
          return 0;
        case 2: 
          localpr.okH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56746);
          return 0;
        case 3: 
          localpr.kqi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56746);
          return 0;
        case 4: 
          localpr.qkn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56746);
          return 0;
        case 5: 
          localpr.wHX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56746);
          return 0;
        case 6: 
          localpr.qjV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56746);
          return 0;
        case 7: 
          localpr.qjW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56746);
          return 0;
        case 8: 
          localpr.qkq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56746);
          return 0;
        case 9: 
          localpr.nickname = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56746);
          return 0;
        }
        localpr.qjK = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56746);
        return 0;
      }
      AppMethodBeat.o(56746);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pr
 * JD-Core Version:    0.7.0.1
 */