package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bjy
  extends dpc
{
  public int KZh;
  public LinkedList<cpw> LTo;
  public int Version;
  public int oTz;
  
  public bjy()
  {
    AppMethodBeat.i(32224);
    this.LTo = new LinkedList();
    AppMethodBeat.o(32224);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32225);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32225);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oTz);
      paramVarArgs.e(5, 8, this.LTo);
      paramVarArgs.aM(6, this.Version);
      paramVarArgs.aM(7, this.KZh);
      AppMethodBeat.o(32225);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label661;
      }
    }
    label661:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.oTz);
      int j = g.a.a.a.c(5, 8, this.LTo);
      int k = g.a.a.b.b.a.bu(6, this.Version);
      int m = g.a.a.b.b.a.bu(7, this.KZh);
      AppMethodBeat.o(32225);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LTo.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32225);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32225);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bjy localbjy = (bjy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(32225);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbjy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32225);
          return 0;
        case 2: 
          localbjy.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32225);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbjy.LTo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32225);
          return 0;
        case 6: 
          localbjy.Version = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32225);
          return 0;
        }
        localbjy.KZh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32225);
        return 0;
      }
      AppMethodBeat.o(32225);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjy
 * JD-Core Version:    0.7.0.1
 */