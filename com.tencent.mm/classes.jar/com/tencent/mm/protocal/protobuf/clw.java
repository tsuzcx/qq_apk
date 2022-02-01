package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class clw
  extends dpc
{
  public String MaZ;
  public String Mbb;
  public int Mrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117879);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MaZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Json");
        AppMethodBeat.o(117879);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MaZ != null) {
        paramVarArgs.e(2, this.MaZ);
      }
      paramVarArgs.aM(3, this.Mrk);
      if (this.Mbb != null) {
        paramVarArgs.e(4, this.Mbb);
      }
      AppMethodBeat.o(117879);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MaZ != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MaZ);
      }
      i += g.a.a.b.b.a.bu(3, this.Mrk);
      paramInt = i;
      if (this.Mbb != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mbb);
      }
      AppMethodBeat.o(117879);
      return paramInt;
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
          AppMethodBeat.o(117879);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117879);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        clw localclw = (clw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117879);
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
            localclw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117879);
          return 0;
        case 2: 
          localclw.MaZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117879);
          return 0;
        case 3: 
          localclw.Mrk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117879);
          return 0;
        }
        localclw.Mbb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117879);
        return 0;
      }
      AppMethodBeat.o(117879);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clw
 * JD-Core Version:    0.7.0.1
 */