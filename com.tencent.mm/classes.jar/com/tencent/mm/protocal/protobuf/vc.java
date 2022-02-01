package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class vc
  extends erp
{
  public String YIV;
  public int Zbd;
  public int Zbe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91387);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIV == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqKey");
        AppMethodBeat.o(91387);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zbd);
      paramVarArgs.bS(3, this.Zbe);
      if (this.YIV != null) {
        paramVarArgs.g(4, this.YIV);
      }
      AppMethodBeat.o(91387);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label480;
      }
    }
    label480:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zbd) + i.a.a.b.b.a.cJ(3, this.Zbe);
      paramInt = i;
      if (this.YIV != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YIV);
      }
      AppMethodBeat.o(91387);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YIV == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        vc localvc = (vc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91387);
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
            localvc.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91387);
          return 0;
        case 2: 
          localvc.Zbd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91387);
          return 0;
        case 3: 
          localvc.Zbe = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91387);
          return 0;
        }
        localvc.YIV = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91387);
        return 0;
      }
      AppMethodBeat.o(91387);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vc
 * JD-Core Version:    0.7.0.1
 */