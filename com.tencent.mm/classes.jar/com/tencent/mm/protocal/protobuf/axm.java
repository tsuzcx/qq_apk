package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axm
  extends cpx
{
  public String DLQ;
  public String EPn;
  public String EPo;
  public pp EPp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114787);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EPn == null)
      {
        paramVarArgs = new b("Not all required fields were included: FunctionMsgID");
        AppMethodBeat.o(114787);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EPn != null) {
        paramVarArgs.d(2, this.EPn);
      }
      if (this.EPo != null) {
        paramVarArgs.d(3, this.EPo);
      }
      if (this.DLQ != null) {
        paramVarArgs.d(4, this.DLQ);
      }
      if (this.EPp != null)
      {
        paramVarArgs.ln(5, this.EPp.computeSize());
        this.EPp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114787);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EPn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EPn);
      }
      i = paramInt;
      if (this.EPo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EPo);
      }
      paramInt = i;
      if (this.DLQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DLQ);
      }
      i = paramInt;
      if (this.EPp != null) {
        i = paramInt + f.a.a.a.lm(5, this.EPp.computeSize());
      }
      AppMethodBeat.o(114787);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EPn == null)
        {
          paramVarArgs = new b("Not all required fields were included: FunctionMsgID");
          AppMethodBeat.o(114787);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114787);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axm localaxm = (axm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114787);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114787);
          return 0;
        case 2: 
          localaxm.EPn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114787);
          return 0;
        case 3: 
          localaxm.EPo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114787);
          return 0;
        case 4: 
          localaxm.DLQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114787);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaxm.EPp = ((pp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114787);
        return 0;
      }
      AppMethodBeat.o(114787);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axm
 * JD-Core Version:    0.7.0.1
 */