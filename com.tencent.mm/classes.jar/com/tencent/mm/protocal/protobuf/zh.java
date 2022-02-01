package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class zh
  extends cpx
{
  public String EtG;
  public String EtH;
  public String EtI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124479);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EtG == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124479);
        throw paramVarArgs;
      }
      if (this.EtH == null)
      {
        paramVarArgs = new b("Not all required fields were included: qychat_type");
        AppMethodBeat.o(124479);
        throw paramVarArgs;
      }
      if (this.EtI == null)
      {
        paramVarArgs = new b("Not all required fields were included: qychat_id");
        AppMethodBeat.o(124479);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EtG != null) {
        paramVarArgs.d(2, this.EtG);
      }
      if (this.EtH != null) {
        paramVarArgs.d(3, this.EtH);
      }
      if (this.EtI != null) {
        paramVarArgs.d(4, this.EtI);
      }
      AppMethodBeat.o(124479);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label634;
      }
    }
    label634:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EtG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EtG);
      }
      i = paramInt;
      if (this.EtH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EtH);
      }
      paramInt = i;
      if (this.EtI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EtI);
      }
      AppMethodBeat.o(124479);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EtG == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124479);
          throw paramVarArgs;
        }
        if (this.EtH == null)
        {
          paramVarArgs = new b("Not all required fields were included: qychat_type");
          AppMethodBeat.o(124479);
          throw paramVarArgs;
        }
        if (this.EtI == null)
        {
          paramVarArgs = new b("Not all required fields were included: qychat_id");
          AppMethodBeat.o(124479);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124479);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zh localzh = (zh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124479);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzh.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124479);
          return 0;
        case 2: 
          localzh.EtG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124479);
          return 0;
        case 3: 
          localzh.EtH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124479);
          return 0;
        }
        localzh.EtI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124479);
        return 0;
      }
      AppMethodBeat.o(124479);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zh
 * JD-Core Version:    0.7.0.1
 */