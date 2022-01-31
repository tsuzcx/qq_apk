package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qs
  extends buy
{
  public String desc;
  public boolean wIX;
  public boolean wIY;
  public LinkedList<Integer> wIy;
  
  public qs()
  {
    AppMethodBeat.i(48806);
    this.wIy = new LinkedList();
    AppMethodBeat.o(48806);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48807);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.wIy);
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      paramVarArgs.aS(4, this.wIX);
      paramVarArgs.aS(5, this.wIY);
      AppMethodBeat.o(48807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label517;
      }
    }
    label517:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 2, this.wIy);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.desc);
      }
      i = e.a.a.b.b.a.eW(4);
      int j = e.a.a.b.b.a.eW(5);
      AppMethodBeat.o(48807);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wIy.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qs localqs = (qs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48807);
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
            localqs.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48807);
          return 0;
        case 2: 
          localqs.wIy.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
          AppMethodBeat.o(48807);
          return 0;
        case 3: 
          localqs.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48807);
          return 0;
        case 4: 
          localqs.wIX = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(48807);
          return 0;
        }
        localqs.wIY = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(48807);
        return 0;
      }
      AppMethodBeat.o(48807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qs
 * JD-Core Version:    0.7.0.1
 */