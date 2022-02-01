package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhq
  extends ckq
{
  public String DFx;
  public LinkedList<String> DFy;
  public String DaJ;
  
  public bhq()
  {
    AppMethodBeat.i(124516);
    this.DFy = new LinkedList();
    AppMethodBeat.o(124516);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124517);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DaJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124517);
        throw paramVarArgs;
      }
      if (this.DFx == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_name");
        AppMethodBeat.o(124517);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DaJ != null) {
        paramVarArgs.d(2, this.DaJ);
      }
      if (this.DFx != null) {
        paramVarArgs.d(3, this.DFx);
      }
      paramVarArgs.e(4, 1, this.DFy);
      AppMethodBeat.o(124517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DaJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DaJ);
      }
      i = paramInt;
      if (this.DFx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DFx);
      }
      paramInt = f.a.a.a.c(4, 1, this.DFy);
      AppMethodBeat.o(124517);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DFy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DaJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124517);
          throw paramVarArgs;
        }
        if (this.DFx == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_name");
          AppMethodBeat.o(124517);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124517);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhq localbhq = (bhq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124517);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhq.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124517);
          return 0;
        case 2: 
          localbhq.DaJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124517);
          return 0;
        case 3: 
          localbhq.DFx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124517);
          return 0;
        }
        localbhq.DFy.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(124517);
        return 0;
      }
      AppMethodBeat.o(124517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhq
 * JD-Core Version:    0.7.0.1
 */