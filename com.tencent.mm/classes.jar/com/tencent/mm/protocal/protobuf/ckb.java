package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ckb
  extends esc
{
  public long YFA;
  public int aasB;
  public int aasC;
  public int aasD;
  public long vhj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127496);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127496);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.YFA);
      paramVarArgs.bv(3, this.vhj);
      paramVarArgs.bS(4, this.aasB);
      paramVarArgs.bS(5, this.aasC);
      paramVarArgs.bS(6, this.aasD);
      AppMethodBeat.o(127496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label564;
      }
    }
    label564:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.YFA);
      int j = i.a.a.b.b.a.q(3, this.vhj);
      int k = i.a.a.b.b.a.cJ(4, this.aasB);
      int m = i.a.a.b.b.a.cJ(5, this.aasC);
      int n = i.a.a.b.b.a.cJ(6, this.aasD);
      AppMethodBeat.o(127496);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(127496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ckb localckb = (ckb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127496);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localckb.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(127496);
          return 0;
        case 2: 
          localckb.YFA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(127496);
          return 0;
        case 3: 
          localckb.vhj = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(127496);
          return 0;
        case 4: 
          localckb.aasB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127496);
          return 0;
        case 5: 
          localckb.aasC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127496);
          return 0;
        }
        localckb.aasD = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127496);
        return 0;
      }
      AppMethodBeat.o(127496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckb
 * JD-Core Version:    0.7.0.1
 */