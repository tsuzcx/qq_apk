package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abo
  extends buy
{
  public int cpt;
  public String cwc;
  public int mha;
  public String wRS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(838);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cwc != null) {
        paramVarArgs.e(2, this.cwc);
      }
      if (this.wRS != null) {
        paramVarArgs.e(3, this.wRS);
      }
      paramVarArgs.aO(4, this.cpt);
      paramVarArgs.aO(5, this.mha);
      AppMethodBeat.o(838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label533;
      }
    }
    label533:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cwc);
      }
      i = paramInt;
      if (this.wRS != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wRS);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.cpt);
      int j = e.a.a.b.b.a.bl(5, this.mha);
      AppMethodBeat.o(838);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(838);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        abo localabo = (abo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(838);
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
            localabo.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(838);
          return 0;
        case 2: 
          localabo.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(838);
          return 0;
        case 3: 
          localabo.wRS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(838);
          return 0;
        case 4: 
          localabo.cpt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(838);
          return 0;
        }
        localabo.mha = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(838);
        return 0;
      }
      AppMethodBeat.o(838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abo
 * JD-Core Version:    0.7.0.1
 */