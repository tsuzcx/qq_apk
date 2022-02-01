package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnd
  extends dop
{
  public SKBuiltinBuffer_t KLQ;
  public com.tencent.mm.bw.b MQx;
  public int dYp;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133192);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MQx == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: clientCheckData");
        AppMethodBeat.o(133192);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MQx != null) {
        paramVarArgs.c(2, this.MQx);
      }
      paramVarArgs.aM(3, this.dYp);
      if (this.KLQ != null)
      {
        paramVarArgs.ni(4, this.KLQ.computeSize());
        this.KLQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(5, this.timestamp);
      AppMethodBeat.o(133192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MQx != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.MQx);
      }
      i += g.a.a.b.b.a.bu(3, this.dYp);
      paramInt = i;
      if (this.KLQ != null) {
        paramInt = i + g.a.a.a.nh(4, this.KLQ.computeSize());
      }
      i = g.a.a.b.b.a.r(5, this.timestamp);
      AppMethodBeat.o(133192);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MQx == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: clientCheckData");
          AppMethodBeat.o(133192);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133192);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dnd localdnd = (dnd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133192);
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
            localdnd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133192);
          return 0;
        case 2: 
          localdnd.MQx = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(133192);
          return 0;
        case 3: 
          localdnd.dYp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133192);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdnd.KLQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133192);
          return 0;
        }
        localdnd.timestamp = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(133192);
        return 0;
      }
      AppMethodBeat.o(133192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnd
 * JD-Core Version:    0.7.0.1
 */