package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvz
  extends buy
{
  public String query;
  public int xpF;
  public String xpJ;
  public String yem;
  public String yer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93811);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.query != null) {
        paramVarArgs.e(2, this.query);
      }
      paramVarArgs.aO(3, this.xpF);
      if (this.xpJ != null) {
        paramVarArgs.e(99, this.xpJ);
      }
      if (this.yem != null) {
        paramVarArgs.e(100, this.yem);
      }
      if (this.yer != null) {
        paramVarArgs.e(101, this.yer);
      }
      AppMethodBeat.o(93811);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.query != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.query);
      }
      i += e.a.a.b.b.a.bl(3, this.xpF);
      paramInt = i;
      if (this.xpJ != null) {
        paramInt = i + e.a.a.b.b.a.f(99, this.xpJ);
      }
      i = paramInt;
      if (this.yem != null) {
        i = paramInt + e.a.a.b.b.a.f(100, this.yem);
      }
      paramInt = i;
      if (this.yer != null) {
        paramInt = i + e.a.a.b.b.a.f(101, this.yer);
      }
      AppMethodBeat.o(93811);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(93811);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cvz localcvz = (cvz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(93811);
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
            localcvz.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(93811);
          return 0;
        case 2: 
          localcvz.query = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93811);
          return 0;
        case 3: 
          localcvz.xpF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93811);
          return 0;
        case 99: 
          localcvz.xpJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93811);
          return 0;
        case 100: 
          localcvz.yem = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93811);
          return 0;
        }
        localcvz.yer = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(93811);
        return 0;
      }
      AppMethodBeat.o(93811);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvz
 * JD-Core Version:    0.7.0.1
 */