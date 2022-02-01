package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bad
  extends dop
{
  public String finderUsername;
  public b lastBuffer;
  public long refObjectId;
  public String refObjectNonceId;
  public aov uli;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169032);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      paramVarArgs.bb(3, this.refObjectId);
      if (this.finderUsername != null) {
        paramVarArgs.e(4, this.finderUsername);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.e(6, this.refObjectNonceId);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(7, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169032);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.username);
      }
      i += g.a.a.b.b.a.r(3, this.refObjectId);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.finderUsername);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.lastBuffer);
      }
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.uli != null) {
        i = paramInt + g.a.a.a.nh(7, this.uli.computeSize());
      }
      AppMethodBeat.o(169032);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169032);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bad localbad = (bad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169032);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbad.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169032);
          return 0;
        case 2: 
          localbad.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169032);
          return 0;
        case 3: 
          localbad.refObjectId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169032);
          return 0;
        case 4: 
          localbad.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169032);
          return 0;
        case 5: 
          localbad.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(169032);
          return 0;
        case 6: 
          localbad.refObjectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169032);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aov();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbad.uli = ((aov)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169032);
        return 0;
      }
      AppMethodBeat.o(169032);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bad
 * JD-Core Version:    0.7.0.1
 */