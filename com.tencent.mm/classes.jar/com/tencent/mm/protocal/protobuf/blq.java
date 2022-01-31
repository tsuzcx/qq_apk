package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class blq
  extends buy
{
  public int wDC;
  public aw wDH;
  public int wkX;
  public String xAn;
  public String xAo;
  public b xAp;
  public int xAq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56903);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xAn != null) {
        paramVarArgs.e(2, this.xAn);
      }
      if (this.xAo != null) {
        paramVarArgs.e(3, this.xAo);
      }
      if (this.xAp != null) {
        paramVarArgs.c(4, this.xAp);
      }
      paramVarArgs.aO(5, this.wDC);
      paramVarArgs.aO(6, this.wkX);
      paramVarArgs.aO(7, this.xAq);
      if (this.wDH != null)
      {
        paramVarArgs.iQ(8, this.wDH.computeSize());
        this.wDH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56903);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xAn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xAn);
      }
      i = paramInt;
      if (this.xAo != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xAo);
      }
      paramInt = i;
      if (this.xAp != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.xAp);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wDC) + e.a.a.b.b.a.bl(6, this.wkX) + e.a.a.b.b.a.bl(7, this.xAq);
      paramInt = i;
      if (this.wDH != null) {
        paramInt = i + e.a.a.a.iP(8, this.wDH.computeSize());
      }
      AppMethodBeat.o(56903);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56903);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        blq localblq = (blq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56903);
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
            localblq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56903);
          return 0;
        case 2: 
          localblq.xAn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56903);
          return 0;
        case 3: 
          localblq.xAo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56903);
          return 0;
        case 4: 
          localblq.xAp = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(56903);
          return 0;
        case 5: 
          localblq.wDC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56903);
          return 0;
        case 6: 
          localblq.wkX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56903);
          return 0;
        case 7: 
          localblq.xAq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56903);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localblq.wDH = ((aw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56903);
        return 0;
      }
      AppMethodBeat.o(56903);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blq
 * JD-Core Version:    0.7.0.1
 */