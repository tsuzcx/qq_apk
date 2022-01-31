package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ass
  extends buy
{
  public String cwc;
  public int type;
  public int wAy;
  public String xfV;
  public int xfY;
  public String xhH;
  public int xhI;
  public bkc xhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96234);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.type);
      if (this.cwc != null) {
        paramVarArgs.e(3, this.cwc);
      }
      paramVarArgs.aO(4, this.wAy);
      if (this.xhH != null) {
        paramVarArgs.e(5, this.xhH);
      }
      paramVarArgs.aO(6, this.xfY);
      paramVarArgs.aO(7, this.xhI);
      if (this.xfV != null) {
        paramVarArgs.e(8, this.xfV);
      }
      if (this.xhJ != null)
      {
        paramVarArgs.iQ(10, this.xhJ.computeSize());
        this.xhJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(96234);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.type);
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.cwc);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.wAy);
      paramInt = i;
      if (this.xhH != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xhH);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.xfY) + e.a.a.b.b.a.bl(7, this.xhI);
      paramInt = i;
      if (this.xfV != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xfV);
      }
      i = paramInt;
      if (this.xhJ != null) {
        i = paramInt + e.a.a.a.iP(10, this.xhJ.computeSize());
      }
      AppMethodBeat.o(96234);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96234);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ass localass = (ass)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(96234);
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
            localass.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96234);
          return 0;
        case 2: 
          localass.type = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96234);
          return 0;
        case 3: 
          localass.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96234);
          return 0;
        case 4: 
          localass.wAy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96234);
          return 0;
        case 5: 
          localass.xhH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96234);
          return 0;
        case 6: 
          localass.xfY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96234);
          return 0;
        case 7: 
          localass.xhI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96234);
          return 0;
        case 8: 
          localass.xfV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96234);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localass.xhJ = ((bkc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(96234);
        return 0;
      }
      AppMethodBeat.o(96234);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ass
 * JD-Core Version:    0.7.0.1
 */