package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qz
  extends buy
{
  public String wJi;
  public String wJj;
  public boolean wJk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94514);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wJi != null) {
        paramVarArgs.e(2, this.wJi);
      }
      if (this.wJj != null) {
        paramVarArgs.e(3, this.wJj);
      }
      paramVarArgs.aS(4, this.wJk);
      AppMethodBeat.o(94514);
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
      if (this.wJi != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wJi);
      }
      i = paramInt;
      if (this.wJj != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wJj);
      }
      paramInt = e.a.a.b.b.a.eW(4);
      AppMethodBeat.o(94514);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94514);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qz localqz = (qz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94514);
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
            localqz.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94514);
          return 0;
        case 2: 
          localqz.wJi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94514);
          return 0;
        case 3: 
          localqz.wJj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94514);
          return 0;
        }
        localqz.wJk = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(94514);
        return 0;
      }
      AppMethodBeat.o(94514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qz
 * JD-Core Version:    0.7.0.1
 */