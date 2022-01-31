package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ch
  extends buy
{
  public int jKs;
  public String pIw;
  public int woH;
  public String woI;
  public String woJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51363);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.pIw != null) {
        paramVarArgs.e(2, this.pIw);
      }
      paramVarArgs.aO(3, this.jKs);
      paramVarArgs.aO(4, this.woH);
      if (this.woI != null) {
        paramVarArgs.e(5, this.woI);
      }
      if (this.woJ != null) {
        paramVarArgs.e(6, this.woJ);
      }
      AppMethodBeat.o(51363);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pIw != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.pIw);
      }
      i = i + e.a.a.b.b.a.bl(3, this.jKs) + e.a.a.b.b.a.bl(4, this.woH);
      paramInt = i;
      if (this.woI != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.woI);
      }
      i = paramInt;
      if (this.woJ != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.woJ);
      }
      AppMethodBeat.o(51363);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51363);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ch localch = (ch)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(51363);
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
            localch.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(51363);
          return 0;
        case 2: 
          localch.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51363);
          return 0;
        case 3: 
          localch.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51363);
          return 0;
        case 4: 
          localch.woH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51363);
          return 0;
        case 5: 
          localch.woI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51363);
          return 0;
        }
        localch.woJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(51363);
        return 0;
      }
      AppMethodBeat.o(51363);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ch
 * JD-Core Version:    0.7.0.1
 */