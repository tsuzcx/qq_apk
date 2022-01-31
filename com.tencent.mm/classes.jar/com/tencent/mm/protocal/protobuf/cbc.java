package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbc
  extends buy
{
  public String lGy;
  public String wQf;
  public SKBuiltinBuffer_t wrL;
  public int xLW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123519);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lGy != null) {
        paramVarArgs.e(2, this.lGy);
      }
      if (this.wQf != null) {
        paramVarArgs.e(3, this.wQf);
      }
      if (this.wrL != null)
      {
        paramVarArgs.iQ(4, this.wrL.computeSize());
        this.wrL.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xLW);
      AppMethodBeat.o(123519);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lGy != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.lGy);
      }
      i = paramInt;
      if (this.wQf != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wQf);
      }
      paramInt = i;
      if (this.wrL != null) {
        paramInt = i + e.a.a.a.iP(4, this.wrL.computeSize());
      }
      i = e.a.a.b.b.a.bl(5, this.xLW);
      AppMethodBeat.o(123519);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(123519);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cbc localcbc = (cbc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123519);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbc.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123519);
          return 0;
        case 2: 
          localcbc.lGy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123519);
          return 0;
        case 3: 
          localcbc.wQf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123519);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbc.wrL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123519);
          return 0;
        }
        localcbc.xLW = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(123519);
        return 0;
      }
      AppMethodBeat.o(123519);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbc
 * JD-Core Version:    0.7.0.1
 */