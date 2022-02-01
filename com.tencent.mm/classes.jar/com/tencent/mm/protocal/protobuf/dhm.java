package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhm
  extends cwj
{
  public int GeQ;
  public SKBuiltinBuffer_t GjQ;
  public zy GjT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125815);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125815);
        throw paramVarArgs;
      }
      if (this.GjT == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(125815);
        throw paramVarArgs;
      }
      if (this.GjQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(125815);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GjT != null)
      {
        paramVarArgs.lJ(2, this.GjT.computeSize());
        this.GjT.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GeQ);
      if (this.GjQ != null)
      {
        paramVarArgs.lJ(4, this.GjQ.computeSize());
        this.GjQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GjT != null) {
        i = paramInt + f.a.a.a.lI(2, this.GjT.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.GeQ);
      paramInt = i;
      if (this.GjQ != null) {
        paramInt = i + f.a.a.a.lI(4, this.GjQ.computeSize());
      }
      AppMethodBeat.o(125815);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125815);
          throw paramVarArgs;
        }
        if (this.GjT == null)
        {
          paramVarArgs = new b("Not all required fields were included: CmdList");
          AppMethodBeat.o(125815);
          throw paramVarArgs;
        }
        if (this.GjQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(125815);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhm localdhm = (dhm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125815);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125815);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhm.GjT = ((zy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125815);
          return 0;
        case 3: 
          localdhm.GeQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125815);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdhm.GjQ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125815);
        return 0;
      }
      AppMethodBeat.o(125815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhm
 * JD-Core Version:    0.7.0.1
 */