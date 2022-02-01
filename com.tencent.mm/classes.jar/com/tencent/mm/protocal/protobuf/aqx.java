package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqx
  extends dop
{
  public int LCJ;
  public int LCK;
  public long id;
  public String objectNonceId;
  public String sessionBuffer;
  public aov uli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168960);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.id);
      paramVarArgs.aM(3, this.LCJ);
      paramVarArgs.aM(4, this.LCK);
      if (this.objectNonceId != null) {
        paramVarArgs.e(5, this.objectNonceId);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(6, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.e(7, this.sessionBuffer);
      }
      AppMethodBeat.o(168960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.id) + g.a.a.b.b.a.bu(3, this.LCJ) + g.a.a.b.b.a.bu(4, this.LCK);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.objectNonceId);
      }
      i = paramInt;
      if (this.uli != null) {
        i = paramInt + g.a.a.a.nh(6, this.uli.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.sessionBuffer);
      }
      AppMethodBeat.o(168960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168960);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqx localaqx = (aqx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168960);
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
            localaqx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168960);
          return 0;
        case 2: 
          localaqx.id = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168960);
          return 0;
        case 3: 
          localaqx.LCJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168960);
          return 0;
        case 4: 
          localaqx.LCK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168960);
          return 0;
        case 5: 
          localaqx.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168960);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqx.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168960);
          return 0;
        }
        localaqx.sessionBuffer = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(168960);
        return 0;
      }
      AppMethodBeat.o(168960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqx
 * JD-Core Version:    0.7.0.1
 */