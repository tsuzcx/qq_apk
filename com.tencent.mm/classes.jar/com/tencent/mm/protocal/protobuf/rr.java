package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rr
  extends buy
{
  public int Scene;
  public int niK;
  public String npZ;
  public String nul;
  public String nuz;
  public int wJO;
  public LinkedList<bwc> wJP;
  public String wJQ;
  public String wJR;
  
  public rr()
  {
    AppMethodBeat.i(11731);
    this.wJP = new LinkedList();
    AppMethodBeat.o(11731);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11732);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.niK);
      if (this.nul != null) {
        paramVarArgs.e(3, this.nul);
      }
      if (this.nuz != null) {
        paramVarArgs.e(4, this.nuz);
      }
      if (this.npZ != null) {
        paramVarArgs.e(5, this.npZ);
      }
      paramVarArgs.aO(6, this.wJO);
      paramVarArgs.e(7, 8, this.wJP);
      if (this.wJQ != null) {
        paramVarArgs.e(8, this.wJQ);
      }
      if (this.wJR != null) {
        paramVarArgs.e(9, this.wJR);
      }
      paramVarArgs.aO(10, this.Scene);
      AppMethodBeat.o(11732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.niK);
      paramInt = i;
      if (this.nul != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nul);
      }
      i = paramInt;
      if (this.nuz != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.nuz);
      }
      paramInt = i;
      if (this.npZ != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.npZ);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.wJO) + e.a.a.a.c(7, 8, this.wJP);
      paramInt = i;
      if (this.wJQ != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wJQ);
      }
      i = paramInt;
      if (this.wJR != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wJR);
      }
      paramInt = e.a.a.b.b.a.bl(10, this.Scene);
      AppMethodBeat.o(11732);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wJP.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11732);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        rr localrr = (rr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11732);
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
            localrr.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11732);
          return 0;
        case 2: 
          localrr.niK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11732);
          return 0;
        case 3: 
          localrr.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11732);
          return 0;
        case 4: 
          localrr.nuz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11732);
          return 0;
        case 5: 
          localrr.npZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11732);
          return 0;
        case 6: 
          localrr.wJO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11732);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localrr.wJP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11732);
          return 0;
        case 8: 
          localrr.wJQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11732);
          return 0;
        case 9: 
          localrr.wJR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11732);
          return 0;
        }
        localrr.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(11732);
        return 0;
      }
      AppMethodBeat.o(11732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rr
 * JD-Core Version:    0.7.0.1
 */