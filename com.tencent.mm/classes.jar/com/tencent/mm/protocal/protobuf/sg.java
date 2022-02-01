package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class sg
  extends cvw
{
  public String FRk;
  public int Ghu;
  public int Ghv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91387);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRk == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqKey");
        AppMethodBeat.o(91387);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Ghu);
      paramVarArgs.aS(3, this.Ghv);
      if (this.FRk != null) {
        paramVarArgs.d(4, this.FRk);
      }
      AppMethodBeat.o(91387);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Ghu) + f.a.a.b.b.a.bz(3, this.Ghv);
      paramInt = i;
      if (this.FRk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FRk);
      }
      AppMethodBeat.o(91387);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FRk == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqKey");
          AppMethodBeat.o(91387);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91387);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sg localsg = (sg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91387);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91387);
          return 0;
        case 2: 
          localsg.Ghu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91387);
          return 0;
        case 3: 
          localsg.Ghv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91387);
          return 0;
        }
        localsg.FRk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91387);
        return 0;
      }
      AppMethodBeat.o(91387);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sg
 * JD-Core Version:    0.7.0.1
 */