package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rg
  extends buy
{
  public String nLq;
  public String poq;
  public String wJx;
  public String wJy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48814);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wJx != null) {
        paramVarArgs.e(2, this.wJx);
      }
      if (this.wJy != null) {
        paramVarArgs.e(3, this.wJy);
      }
      if (this.nLq != null) {
        paramVarArgs.e(4, this.nLq);
      }
      if (this.poq != null) {
        paramVarArgs.e(5, this.poq);
      }
      AppMethodBeat.o(48814);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wJx != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wJx);
      }
      i = paramInt;
      if (this.wJy != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wJy);
      }
      paramInt = i;
      if (this.nLq != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nLq);
      }
      i = paramInt;
      if (this.poq != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.poq);
      }
      AppMethodBeat.o(48814);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48814);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        rg localrg = (rg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48814);
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
            localrg.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48814);
          return 0;
        case 2: 
          localrg.wJx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48814);
          return 0;
        case 3: 
          localrg.wJy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48814);
          return 0;
        case 4: 
          localrg.nLq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48814);
          return 0;
        }
        localrg.poq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48814);
        return 0;
      }
      AppMethodBeat.o(48814);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rg
 * JD-Core Version:    0.7.0.1
 */