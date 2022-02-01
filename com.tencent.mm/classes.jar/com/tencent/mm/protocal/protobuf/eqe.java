package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eqe
  extends erp
{
  public akf aasb;
  public LinkedList<aow> abuc;
  public long yFS;
  public long yFT;
  
  public eqe()
  {
    AppMethodBeat.i(258958);
    this.abuc = new LinkedList();
    AppMethodBeat.o(258958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258965);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aasb == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(258965);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.yFS);
      paramVarArgs.bv(3, this.yFT);
      paramVarArgs.e(4, 8, this.abuc);
      if (this.aasb != null)
      {
        paramVarArgs.qD(5, this.aasb.computeSize());
        this.aasb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.yFS) + i.a.a.b.b.a.q(3, this.yFT) + i.a.a.a.c(4, 8, this.abuc);
      paramInt = i;
      if (this.aasb != null) {
        paramInt = i + i.a.a.a.qC(5, this.aasb.computeSize());
      }
      AppMethodBeat.o(258965);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abuc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aasb == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(258965);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258965);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eqe localeqe = (eqe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258965);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localeqe.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258965);
          return 0;
        case 2: 
          localeqe.yFS = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258965);
          return 0;
        case 3: 
          localeqe.yFT = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258965);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aow();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aow)localObject2).parseFrom((byte[])localObject1);
            }
            localeqe.abuc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258965);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new akf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((akf)localObject2).parseFrom((byte[])localObject1);
          }
          localeqe.aasb = ((akf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258965);
        return 0;
      }
      AppMethodBeat.o(258965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqe
 * JD-Core Version:    0.7.0.1
 */