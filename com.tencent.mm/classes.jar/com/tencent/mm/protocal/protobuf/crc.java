package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class crc
  extends esc
{
  public long aaxM;
  public LinkedList<ent> aaxP;
  public LinkedList<enb> aaxQ;
  public int aaxR;
  public int qQY;
  
  public crc()
  {
    AppMethodBeat.i(50090);
    this.aaxP = new LinkedList();
    this.aaxQ = new LinkedList();
    AppMethodBeat.o(50090);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50091);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(50091);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.qQY);
      paramVarArgs.e(3, 8, this.aaxP);
      paramVarArgs.bv(4, this.aaxM);
      paramVarArgs.e(5, 8, this.aaxQ);
      paramVarArgs.bS(6, this.aaxR);
      AppMethodBeat.o(50091);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label712;
      }
    }
    label712:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.qQY);
      int j = i.a.a.a.c(3, 8, this.aaxP);
      int k = i.a.a.b.b.a.q(4, this.aaxM);
      int m = i.a.a.a.c(5, 8, this.aaxQ);
      int n = i.a.a.b.b.a.cJ(6, this.aaxR);
      AppMethodBeat.o(50091);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaxP.clear();
        this.aaxQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(50091);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50091);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        crc localcrc = (crc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50091);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcrc.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50091);
          return 0;
        case 2: 
          localcrc.qQY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(50091);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ent();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ent)localObject2).parseFrom((byte[])localObject1);
            }
            localcrc.aaxP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50091);
          return 0;
        case 4: 
          localcrc.aaxM = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(50091);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enb)localObject2).parseFrom((byte[])localObject1);
            }
            localcrc.aaxQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50091);
          return 0;
        }
        localcrc.aaxR = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(50091);
        return 0;
      }
      AppMethodBeat.o(50091);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crc
 * JD-Core Version:    0.7.0.1
 */