package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cxh
  extends erp
{
  public int aaCP;
  public String iaI;
  public String waL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114041);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.iaI == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(114041);
        throw paramVarArgs;
      }
      if (this.waL == null)
      {
        paramVarArgs = new b("Not all required fields were included: to_username");
        AppMethodBeat.o(114041);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iaI != null) {
        paramVarArgs.g(2, this.iaI);
      }
      if (this.waL != null) {
        paramVarArgs.g(3, this.waL);
      }
      paramVarArgs.bS(4, this.aaCP);
      AppMethodBeat.o(114041);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label544;
      }
    }
    label544:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iaI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.iaI);
      }
      i = paramInt;
      if (this.waL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.waL);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.aaCP);
      AppMethodBeat.o(114041);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.iaI == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(114041);
          throw paramVarArgs;
        }
        if (this.waL == null)
        {
          paramVarArgs = new b("Not all required fields were included: to_username");
          AppMethodBeat.o(114041);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114041);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cxh localcxh = (cxh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114041);
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
            localcxh.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(114041);
          return 0;
        case 2: 
          localcxh.iaI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114041);
          return 0;
        case 3: 
          localcxh.waL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114041);
          return 0;
        }
        localcxh.aaCP = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(114041);
        return 0;
      }
      AppMethodBeat.o(114041);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxh
 * JD-Core Version:    0.7.0.1
 */