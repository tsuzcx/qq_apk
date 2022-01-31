package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvv
  extends buy
{
  public String cpW;
  public int scene;
  public int uJc;
  public double yei;
  public double yej;
  public String yek;
  public LinkedList<cpo> yel;
  
  public cvv()
  {
    AppMethodBeat.i(93806);
    this.yel = new LinkedList();
    AppMethodBeat.o(93806);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93807);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.f(2, this.yei);
      paramVarArgs.f(3, this.yej);
      if (this.yek != null) {
        paramVarArgs.e(4, this.yek);
      }
      paramVarArgs.aO(5, this.uJc);
      if (this.cpW != null) {
        paramVarArgs.e(6, this.cpW);
      }
      paramVarArgs.aO(7, this.scene);
      paramVarArgs.e(8, 8, this.yel);
      AppMethodBeat.o(93807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label756;
      }
    }
    label756:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 8) + (e.a.a.b.b.a.eW(3) + 8);
      paramInt = i;
      if (this.yek != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.yek);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.uJc);
      paramInt = i;
      if (this.cpW != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.cpW);
      }
      i = e.a.a.b.b.a.bl(7, this.scene);
      int j = e.a.a.a.c(8, 8, this.yel);
      AppMethodBeat.o(93807);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.yel.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(93807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cvv localcvv = (cvv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(93807);
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
            localcvv.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(93807);
          return 0;
        case 2: 
          localcvv.yei = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(93807);
          return 0;
        case 3: 
          localcvv.yej = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(93807);
          return 0;
        case 4: 
          localcvv.yek = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93807);
          return 0;
        case 5: 
          localcvv.uJc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93807);
          return 0;
        case 6: 
          localcvv.cpW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93807);
          return 0;
        case 7: 
          localcvv.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93807);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cpo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cpo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcvv.yel.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(93807);
        return 0;
      }
      AppMethodBeat.o(93807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvv
 * JD-Core Version:    0.7.0.1
 */