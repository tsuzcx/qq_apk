package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class mh
  extends buy
{
  public String qkn;
  public b wAN;
  public String wpp;
  public String wpq;
  public String wpr;
  public int wpu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56716);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wpp != null) {
        paramVarArgs.e(2, this.wpp);
      }
      if (this.wpq != null) {
        paramVarArgs.e(3, this.wpq);
      }
      if (this.qkn != null) {
        paramVarArgs.e(4, this.qkn);
      }
      paramVarArgs.aO(5, this.wpu);
      if (this.wAN != null) {
        paramVarArgs.c(6, this.wAN);
      }
      if (this.wpr != null) {
        paramVarArgs.e(7, this.wpr);
      }
      AppMethodBeat.o(56716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wpp != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wpp);
      }
      i = paramInt;
      if (this.wpq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wpq);
      }
      paramInt = i;
      if (this.qkn != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.qkn);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wpu);
      paramInt = i;
      if (this.wAN != null) {
        paramInt = i + e.a.a.b.b.a.b(6, this.wAN);
      }
      i = paramInt;
      if (this.wpr != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wpr);
      }
      AppMethodBeat.o(56716);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56716);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        mh localmh = (mh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56716);
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
            localmh.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56716);
          return 0;
        case 2: 
          localmh.wpp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56716);
          return 0;
        case 3: 
          localmh.wpq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56716);
          return 0;
        case 4: 
          localmh.qkn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56716);
          return 0;
        case 5: 
          localmh.wpu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56716);
          return 0;
        case 6: 
          localmh.wAN = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(56716);
          return 0;
        }
        localmh.wpr = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56716);
        return 0;
      }
      AppMethodBeat.o(56716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mh
 * JD-Core Version:    0.7.0.1
 */