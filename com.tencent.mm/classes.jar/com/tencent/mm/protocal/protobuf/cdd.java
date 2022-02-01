package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cdd
  extends dop
{
  public String Lpg;
  public String MiU;
  public LinkedList<String> MiV;
  
  public cdd()
  {
    AppMethodBeat.i(124516);
    this.MiV = new LinkedList();
    AppMethodBeat.o(124516);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124517);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lpg == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124517);
        throw paramVarArgs;
      }
      if (this.MiU == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_name");
        AppMethodBeat.o(124517);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Lpg != null) {
        paramVarArgs.e(2, this.Lpg);
      }
      if (this.MiU != null) {
        paramVarArgs.e(3, this.MiU);
      }
      paramVarArgs.e(4, 1, this.MiV);
      AppMethodBeat.o(124517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lpg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Lpg);
      }
      i = paramInt;
      if (this.MiU != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MiU);
      }
      paramInt = g.a.a.a.c(4, 1, this.MiV);
      AppMethodBeat.o(124517);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MiV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lpg == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124517);
          throw paramVarArgs;
        }
        if (this.MiU == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cdd localcdd = (cdd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124517);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcdd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124517);
          return 0;
        case 2: 
          localcdd.Lpg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124517);
          return 0;
        case 3: 
          localcdd.MiU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124517);
          return 0;
        }
        localcdd.MiV.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(124517);
        return 0;
      }
      AppMethodBeat.o(124517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdd
 * JD-Core Version:    0.7.0.1
 */