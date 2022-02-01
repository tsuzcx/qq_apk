package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fav
  extends dpc
{
  public int KZk;
  public int MRg;
  public String MaZ;
  public int NwM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117956);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MaZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Json");
        AppMethodBeat.o(117956);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.NwM);
      paramVarArgs.aM(3, this.KZk);
      if (this.MaZ != null) {
        paramVarArgs.e(4, this.MaZ);
      }
      paramVarArgs.aM(5, this.MRg);
      AppMethodBeat.o(117956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.NwM) + g.a.a.b.b.a.bu(3, this.KZk);
      paramInt = i;
      if (this.MaZ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MaZ);
      }
      i = g.a.a.b.b.a.bu(5, this.MRg);
      AppMethodBeat.o(117956);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MaZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Json");
          AppMethodBeat.o(117956);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fav localfav = (fav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117956);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfav.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117956);
          return 0;
        case 2: 
          localfav.NwM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117956);
          return 0;
        case 3: 
          localfav.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117956);
          return 0;
        case 4: 
          localfav.MaZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117956);
          return 0;
        }
        localfav.MRg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117956);
        return 0;
      }
      AppMethodBeat.o(117956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fav
 * JD-Core Version:    0.7.0.1
 */