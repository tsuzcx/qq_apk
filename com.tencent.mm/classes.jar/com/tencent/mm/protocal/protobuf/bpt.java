package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpt
  extends buy
{
  public String qkt;
  public String tNy;
  public int wMx;
  public String xBE;
  public int xCQ;
  public String xDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56938);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xDG != null) {
        paramVarArgs.e(2, this.xDG);
      }
      if (this.qkt != null) {
        paramVarArgs.e(3, this.qkt);
      }
      paramVarArgs.aO(4, this.xCQ);
      paramVarArgs.aO(5, this.wMx);
      if (this.xBE != null) {
        paramVarArgs.e(6, this.xBE);
      }
      if (this.tNy != null) {
        paramVarArgs.e(100, this.tNy);
      }
      AppMethodBeat.o(56938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label666;
      }
    }
    label666:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xDG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xDG);
      }
      i = paramInt;
      if (this.qkt != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.qkt);
      }
      i = i + e.a.a.b.b.a.bl(4, this.xCQ) + e.a.a.b.b.a.bl(5, this.wMx);
      paramInt = i;
      if (this.xBE != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xBE);
      }
      i = paramInt;
      if (this.tNy != null) {
        i = paramInt + e.a.a.b.b.a.f(100, this.tNy);
      }
      AppMethodBeat.o(56938);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56938);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bpt localbpt = (bpt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56938);
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
            localbpt.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56938);
          return 0;
        case 2: 
          localbpt.xDG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56938);
          return 0;
        case 3: 
          localbpt.qkt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56938);
          return 0;
        case 4: 
          localbpt.xCQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56938);
          return 0;
        case 5: 
          localbpt.wMx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56938);
          return 0;
        case 6: 
          localbpt.xBE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56938);
          return 0;
        }
        localbpt.tNy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56938);
        return 0;
      }
      AppMethodBeat.o(56938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpt
 * JD-Core Version:    0.7.0.1
 */