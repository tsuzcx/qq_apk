package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ers
  extends erp
{
  public int Kmp;
  public String Kmq;
  public long Oll;
  public int YzO;
  public int abvq;
  public int abvr;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91671);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      paramVarArgs.bS(3, this.Kmp);
      paramVarArgs.bS(4, this.YzO);
      paramVarArgs.bv(5, this.Oll);
      paramVarArgs.bS(6, this.abvq);
      if (this.Kmq != null) {
        paramVarArgs.g(7, this.Kmq);
      }
      paramVarArgs.bS(8, this.abvr);
      AppMethodBeat.o(91671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appid);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.Kmp) + i.a.a.b.b.a.cJ(4, this.YzO) + i.a.a.b.b.a.q(5, this.Oll) + i.a.a.b.b.a.cJ(6, this.abvq);
      paramInt = i;
      if (this.Kmq != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Kmq);
      }
      i = i.a.a.b.b.a.cJ(8, this.abvr);
      AppMethodBeat.o(91671);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ers localers = (ers)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91671);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localers.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91671);
          return 0;
        case 2: 
          localers.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91671);
          return 0;
        case 3: 
          localers.Kmp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91671);
          return 0;
        case 4: 
          localers.YzO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91671);
          return 0;
        case 5: 
          localers.Oll = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(91671);
          return 0;
        case 6: 
          localers.abvq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91671);
          return 0;
        case 7: 
          localers.Kmq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91671);
          return 0;
        }
        localers.abvr = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91671);
        return 0;
      }
      AppMethodBeat.o(91671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ers
 * JD-Core Version:    0.7.0.1
 */