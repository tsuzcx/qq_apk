package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azk
  extends buy
{
  public int cpt;
  public String query;
  public String xoI;
  public String xoJ;
  public String xoK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114976);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xoI != null) {
        paramVarArgs.e(2, this.xoI);
      }
      if (this.query != null) {
        paramVarArgs.e(3, this.query);
      }
      if (this.xoJ != null) {
        paramVarArgs.e(4, this.xoJ);
      }
      if (this.xoK != null) {
        paramVarArgs.e(5, this.xoK);
      }
      paramVarArgs.aO(6, this.cpt);
      AppMethodBeat.o(114976);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xoI != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xoI);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.query);
      }
      paramInt = i;
      if (this.xoJ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xoJ);
      }
      i = paramInt;
      if (this.xoK != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xoK);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.cpt);
      AppMethodBeat.o(114976);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114976);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        azk localazk = (azk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114976);
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
            localazk.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114976);
          return 0;
        case 2: 
          localazk.xoI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(114976);
          return 0;
        case 3: 
          localazk.query = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(114976);
          return 0;
        case 4: 
          localazk.xoJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(114976);
          return 0;
        case 5: 
          localazk.xoK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(114976);
          return 0;
        }
        localazk.cpt = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(114976);
        return 0;
      }
      AppMethodBeat.o(114976);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azk
 * JD-Core Version:    0.7.0.1
 */