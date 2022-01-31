package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class crh
  extends buy
{
  public int Scene;
  public int fKi;
  public SKBuiltinBuffer_t pIA;
  public int wAK;
  public int wzS;
  public bwc xIA;
  public String xWW;
  public int xWY;
  public int xZP;
  public LinkedList<bwc> xZQ;
  public int xZR;
  
  public crh()
  {
    AppMethodBeat.i(116818);
    this.xZQ = new LinkedList();
    AppMethodBeat.o(116818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116819);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(116819);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.pIA != null)
      {
        paramVarArgs.iQ(2, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wzS);
      if (this.xWW != null) {
        paramVarArgs.e(4, this.xWW);
      }
      paramVarArgs.aO(5, this.fKi);
      paramVarArgs.aO(6, this.xWY);
      paramVarArgs.aO(7, this.wAK);
      paramVarArgs.aO(8, this.xZP);
      paramVarArgs.e(9, 8, this.xZQ);
      if (this.xIA != null)
      {
        paramVarArgs.iQ(10, this.xIA.computeSize());
        this.xIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(11, this.xZR);
      paramVarArgs.aO(12, this.Scene);
      AppMethodBeat.o(116819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1182;
      }
    }
    label1182:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pIA != null) {
        i = paramInt + e.a.a.a.iP(2, this.pIA.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.wzS);
      paramInt = i;
      if (this.xWW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xWW);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.fKi) + e.a.a.b.b.a.bl(6, this.xWY) + e.a.a.b.b.a.bl(7, this.wAK) + e.a.a.b.b.a.bl(8, this.xZP) + e.a.a.a.c(9, 8, this.xZQ);
      paramInt = i;
      if (this.xIA != null) {
        paramInt = i + e.a.a.a.iP(10, this.xIA.computeSize());
      }
      i = e.a.a.b.b.a.bl(11, this.xZR);
      int j = e.a.a.b.b.a.bl(12, this.Scene);
      AppMethodBeat.o(116819);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xZQ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(116819);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116819);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        crh localcrh = (crh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116819);
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
            localcrh.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrh.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 3: 
          localcrh.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116819);
          return 0;
        case 4: 
          localcrh.xWW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 5: 
          localcrh.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116819);
          return 0;
        case 6: 
          localcrh.xWY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116819);
          return 0;
        case 7: 
          localcrh.wAK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116819);
          return 0;
        case 8: 
          localcrh.xZP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116819);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrh.xZQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrh.xIA = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 11: 
          localcrh.xZR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116819);
          return 0;
        }
        localcrh.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116819);
        return 0;
      }
      AppMethodBeat.o(116819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crh
 * JD-Core Version:    0.7.0.1
 */