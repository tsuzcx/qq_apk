package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class drs
  extends dop
{
  public dqi Lqk;
  public int MJj;
  public int MUl;
  public int OpCode;
  public SKBuiltinBuffer_t ReqBuf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152682);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqk == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152682);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Lqk != null)
      {
        paramVarArgs.ni(2, this.Lqk.computeSize());
        this.Lqk.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.OpCode);
      if (this.ReqBuf != null)
      {
        paramVarArgs.ni(4, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.MJj);
      paramVarArgs.aM(6, this.MUl);
      AppMethodBeat.o(152682);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lqk != null) {
        i = paramInt + g.a.a.a.nh(2, this.Lqk.computeSize());
      }
      i += g.a.a.b.b.a.bu(3, this.OpCode);
      paramInt = i;
      if (this.ReqBuf != null) {
        paramInt = i + g.a.a.a.nh(4, this.ReqBuf.computeSize());
      }
      i = g.a.a.b.b.a.bu(5, this.MJj);
      int j = g.a.a.b.b.a.bu(6, this.MUl);
      AppMethodBeat.o(152682);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lqk == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152682);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152682);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        drs localdrs = (drs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152682);
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
            localdrs.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrs.Lqk = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 3: 
          localdrs.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152682);
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
            localdrs.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 5: 
          localdrs.MJj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152682);
          return 0;
        }
        localdrs.MUl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152682);
        return 0;
      }
      AppMethodBeat.o(152682);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drs
 * JD-Core Version:    0.7.0.1
 */