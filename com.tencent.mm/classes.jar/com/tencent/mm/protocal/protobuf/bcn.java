package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcn
  extends cqk
{
  public ciu ESC;
  public cis ESD;
  public int fZz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155413);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.ESC == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQGroup");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.ESD == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQFriend");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.fZz);
      if (this.ESC != null)
      {
        paramVarArgs.ln(3, this.ESC.computeSize());
        this.ESC.writeFields(paramVarArgs);
      }
      if (this.ESD != null)
      {
        paramVarArgs.ln(4, this.ESD.computeSize());
        this.ESD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.fZz);
      paramInt = i;
      if (this.ESC != null) {
        paramInt = i + f.a.a.a.lm(3, this.ESC.computeSize());
      }
      i = paramInt;
      if (this.ESD != null) {
        i = paramInt + f.a.a.a.lm(4, this.ESD.computeSize());
      }
      AppMethodBeat.o(155413);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        if (this.ESC == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQGroup");
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        if (this.ESD == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQFriend");
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcn localbcn = (bcn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155413);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155413);
          return 0;
        case 2: 
          localbcn.fZz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155413);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ciu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ciu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcn.ESC = ((ciu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155413);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cis();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cis)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbcn.ESD = ((cis)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155413);
        return 0;
      }
      AppMethodBeat.o(155413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcn
 * JD-Core Version:    0.7.0.1
 */