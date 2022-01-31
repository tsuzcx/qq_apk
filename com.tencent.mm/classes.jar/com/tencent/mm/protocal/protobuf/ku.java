package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ku
  extends buy
{
  public String cnv;
  public int offset;
  public String wyh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11706);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyh == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(11706);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wyh != null) {
        paramVarArgs.e(2, this.wyh);
      }
      if (this.cnv != null) {
        paramVarArgs.e(3, this.cnv);
      }
      paramVarArgs.aO(4, this.offset);
      AppMethodBeat.o(11706);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label536;
      }
    }
    label536:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wyh != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wyh);
      }
      i = paramInt;
      if (this.cnv != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cnv);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.offset);
      AppMethodBeat.o(11706);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wyh == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(11706);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11706);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ku localku = (ku)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11706);
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
            localku.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11706);
          return 0;
        case 2: 
          localku.wyh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11706);
          return 0;
        case 3: 
          localku.cnv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11706);
          return 0;
        }
        localku.offset = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(11706);
        return 0;
      }
      AppMethodBeat.o(11706);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ku
 * JD-Core Version:    0.7.0.1
 */