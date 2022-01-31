package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bqp
  extends buy
{
  public long timestamp;
  public hn wKC;
  public int wLD;
  public int wLE;
  public int xEF;
  public b xEG;
  public b xEH;
  public b xEI;
  public int xEJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48949);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wKC != null)
      {
        paramVarArgs.iQ(2, this.wKC.computeSize());
        this.wKC.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xEF);
      if (this.xEG != null) {
        paramVarArgs.c(4, this.xEG);
      }
      if (this.xEH != null) {
        paramVarArgs.c(5, this.xEH);
      }
      if (this.xEI != null) {
        paramVarArgs.c(6, this.xEI);
      }
      paramVarArgs.aO(7, this.wLE);
      paramVarArgs.aO(8, this.wLD);
      paramVarArgs.aO(9, this.xEJ);
      paramVarArgs.am(10, this.timestamp);
      AppMethodBeat.o(48949);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wKC != null) {
        i = paramInt + e.a.a.a.iP(2, this.wKC.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.xEF);
      paramInt = i;
      if (this.xEG != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.xEG);
      }
      i = paramInt;
      if (this.xEH != null) {
        i = paramInt + e.a.a.b.b.a.b(5, this.xEH);
      }
      paramInt = i;
      if (this.xEI != null) {
        paramInt = i + e.a.a.b.b.a.b(6, this.xEI);
      }
      i = e.a.a.b.b.a.bl(7, this.wLE);
      int j = e.a.a.b.b.a.bl(8, this.wLD);
      int k = e.a.a.b.b.a.bl(9, this.xEJ);
      int m = e.a.a.b.b.a.p(10, this.timestamp);
      AppMethodBeat.o(48949);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48949);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bqp localbqp = (bqp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48949);
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
            localbqp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48949);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbqp.wKC = ((hn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48949);
          return 0;
        case 3: 
          localbqp.xEF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48949);
          return 0;
        case 4: 
          localbqp.xEG = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(48949);
          return 0;
        case 5: 
          localbqp.xEH = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(48949);
          return 0;
        case 6: 
          localbqp.xEI = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(48949);
          return 0;
        case 7: 
          localbqp.wLE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48949);
          return 0;
        case 8: 
          localbqp.wLD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48949);
          return 0;
        case 9: 
          localbqp.xEJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48949);
          return 0;
        }
        localbqp.timestamp = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(48949);
        return 0;
      }
      AppMethodBeat.o(48949);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqp
 * JD-Core Version:    0.7.0.1
 */