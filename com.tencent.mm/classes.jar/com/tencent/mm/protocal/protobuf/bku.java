package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bku
  extends buy
{
  public String ppY;
  public int pqf;
  public String pqq;
  public aw wDH;
  public int xzv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56880);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xzv);
      if (this.ppY != null) {
        paramVarArgs.e(3, this.ppY);
      }
      paramVarArgs.aO(4, this.pqf);
      if (this.pqq != null) {
        paramVarArgs.e(5, this.pqq);
      }
      if (this.wDH != null)
      {
        paramVarArgs.iQ(6, this.wDH.computeSize());
        this.wDH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xzv);
      paramInt = i;
      if (this.ppY != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.ppY);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.pqf);
      paramInt = i;
      if (this.pqq != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.pqq);
      }
      i = paramInt;
      if (this.wDH != null) {
        i = paramInt + e.a.a.a.iP(6, this.wDH.computeSize());
      }
      AppMethodBeat.o(56880);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56880);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bku localbku = (bku)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56880);
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
            localbku.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56880);
          return 0;
        case 2: 
          localbku.xzv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56880);
          return 0;
        case 3: 
          localbku.ppY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56880);
          return 0;
        case 4: 
          localbku.pqf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56880);
          return 0;
        case 5: 
          localbku.pqq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56880);
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
          localbku.wDH = ((aw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56880);
        return 0;
      }
      AppMethodBeat.o(56880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bku
 * JD-Core Version:    0.7.0.1
 */