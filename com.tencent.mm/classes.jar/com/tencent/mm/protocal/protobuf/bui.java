package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bui
  extends buy
{
  public int wBk;
  public b xHB;
  public String xxV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48953);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xHB != null) {
        paramVarArgs.c(2, this.xHB);
      }
      if (this.xxV != null) {
        paramVarArgs.e(3, this.xxV);
      }
      paramVarArgs.aO(4, this.wBk);
      AppMethodBeat.o(48953);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xHB != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.xHB);
      }
      i = paramInt;
      if (this.xxV != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xxV);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.wBk);
      AppMethodBeat.o(48953);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48953);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bui localbui = (bui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48953);
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
            localbui.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48953);
          return 0;
        case 2: 
          localbui.xHB = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(48953);
          return 0;
        case 3: 
          localbui.xxV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48953);
          return 0;
        }
        localbui.wBk = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48953);
        return 0;
      }
      AppMethodBeat.o(48953);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bui
 * JD-Core Version:    0.7.0.1
 */