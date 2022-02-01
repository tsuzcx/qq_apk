package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eoq
  extends erp
{
  public String ZvR;
  public fvj absQ;
  public fot absR;
  public int muB;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56259);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.absQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPosition");
        AppMethodBeat.o(56259);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZvR != null) {
        paramVarArgs.g(2, this.ZvR);
      }
      paramVarArgs.bS(3, this.vhJ);
      if (this.absQ != null)
      {
        paramVarArgs.qD(4, this.absQ.computeSize());
        this.absQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.muB);
      if (this.absR != null)
      {
        paramVarArgs.qD(6, this.absR.computeSize());
        this.absR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56259);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label748;
      }
    }
    label748:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZvR != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZvR);
      }
      i += i.a.a.b.b.a.cJ(3, this.vhJ);
      paramInt = i;
      if (this.absQ != null) {
        paramInt = i + i.a.a.a.qC(4, this.absQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.muB);
      paramInt = i;
      if (this.absR != null) {
        paramInt = i + i.a.a.a.qC(6, this.absR.computeSize());
      }
      AppMethodBeat.o(56259);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.absQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserPosition");
          AppMethodBeat.o(56259);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eoq localeoq = (eoq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56259);
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
            localeoq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 2: 
          localeoq.ZvR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(56259);
          return 0;
        case 3: 
          localeoq.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(56259);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fvj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fvj)localObject2).parseFrom((byte[])localObject1);
            }
            localeoq.absQ = ((fvj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 5: 
          localeoq.muB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(56259);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fot();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fot)localObject2).parseFrom((byte[])localObject1);
          }
          localeoq.absR = ((fot)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      AppMethodBeat.o(56259);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoq
 * JD-Core Version:    0.7.0.1
 */