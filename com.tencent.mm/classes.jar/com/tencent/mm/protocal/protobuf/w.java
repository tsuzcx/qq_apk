package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class w
  extends buy
{
  public int limit;
  public int offset;
  public int type;
  public String wkK;
  public int wkL;
  public int wkM;
  public String wkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56692);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.limit);
      paramVarArgs.aO(3, this.offset);
      paramVarArgs.aO(4, this.type);
      if (this.wkK != null) {
        paramVarArgs.e(5, this.wkK);
      }
      paramVarArgs.aO(6, this.wkL);
      paramVarArgs.aO(7, this.wkM);
      if (this.wkN != null) {
        paramVarArgs.e(8, this.wkN);
      }
      AppMethodBeat.o(56692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.limit) + e.a.a.b.b.a.bl(3, this.offset) + e.a.a.b.b.a.bl(4, this.type);
      paramInt = i;
      if (this.wkK != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wkK);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.wkL) + e.a.a.b.b.a.bl(7, this.wkM);
      paramInt = i;
      if (this.wkN != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wkN);
      }
      AppMethodBeat.o(56692);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56692);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        w localw = (w)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56692);
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
            localw.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56692);
          return 0;
        case 2: 
          localw.limit = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56692);
          return 0;
        case 3: 
          localw.offset = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56692);
          return 0;
        case 4: 
          localw.type = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56692);
          return 0;
        case 5: 
          localw.wkK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56692);
          return 0;
        case 6: 
          localw.wkL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56692);
          return 0;
        case 7: 
          localw.wkM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56692);
          return 0;
        }
        localw.wkN = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56692);
        return 0;
      }
      AppMethodBeat.o(56692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.w
 * JD-Core Version:    0.7.0.1
 */