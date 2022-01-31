package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class vr
  extends buy
{
  public aeh wOs;
  public String wyh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11743);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOs == null)
      {
        paramVarArgs = new b("Not all required fields were included: full_chat");
        AppMethodBeat.o(11743);
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
      if (this.wOs != null)
      {
        paramVarArgs.iQ(3, this.wOs.computeSize());
        this.wOs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(11743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label583;
      }
    }
    label583:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wyh != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wyh);
      }
      i = paramInt;
      if (this.wOs != null) {
        i = paramInt + e.a.a.a.iP(3, this.wOs.computeSize());
      }
      AppMethodBeat.o(11743);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOs == null)
        {
          paramVarArgs = new b("Not all required fields were included: full_chat");
          AppMethodBeat.o(11743);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        vr localvr = (vr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11743);
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
            localvr.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11743);
          return 0;
        case 2: 
          localvr.wyh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11743);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aeh();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aeh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localvr.wOs = ((aeh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(11743);
        return 0;
      }
      AppMethodBeat.o(11743);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vr
 * JD-Core Version:    0.7.0.1
 */