package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aji
  extends buy
{
  public LinkedList<bwc> wou;
  public int xaL;
  public int xaM;
  public LinkedList<bwc> xaN;
  public int xaO;
  public LinkedList<bwc> xaP;
  public int xaQ;
  public bwc xaR;
  
  public aji()
  {
    AppMethodBeat.i(28428);
    this.wou = new LinkedList();
    this.xaN = new LinkedList();
    this.xaP = new LinkedList();
    AppMethodBeat.o(28428);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28429);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xaL);
      paramVarArgs.e(3, 8, this.wou);
      paramVarArgs.aO(4, this.xaM);
      paramVarArgs.e(5, 8, this.xaN);
      paramVarArgs.aO(6, this.xaO);
      paramVarArgs.e(7, 8, this.xaP);
      paramVarArgs.aO(8, this.xaQ);
      if (this.xaR != null)
      {
        paramVarArgs.iQ(9, this.xaR.computeSize());
        this.xaR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28429);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1069;
      }
    }
    label1069:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xaL) + e.a.a.a.c(3, 8, this.wou) + e.a.a.b.b.a.bl(4, this.xaM) + e.a.a.a.c(5, 8, this.xaN) + e.a.a.b.b.a.bl(6, this.xaO) + e.a.a.a.c(7, 8, this.xaP) + e.a.a.b.b.a.bl(8, this.xaQ);
      paramInt = i;
      if (this.xaR != null) {
        paramInt = i + e.a.a.a.iP(9, this.xaR.computeSize());
      }
      AppMethodBeat.o(28429);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wou.clear();
        this.xaN.clear();
        this.xaP.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28429);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aji localaji = (aji)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28429);
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
            localaji.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28429);
          return 0;
        case 2: 
          localaji.xaL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28429);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaji.wou.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28429);
          return 0;
        case 4: 
          localaji.xaM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28429);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaji.xaN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28429);
          return 0;
        case 6: 
          localaji.xaO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28429);
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
            localaji.xaP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28429);
          return 0;
        case 8: 
          localaji.xaQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28429);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaji.xaR = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28429);
        return 0;
      }
      AppMethodBeat.o(28429);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aji
 * JD-Core Version:    0.7.0.1
 */