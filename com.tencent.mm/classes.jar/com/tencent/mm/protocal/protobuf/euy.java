package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class euy
  extends erp
{
  public String kDf;
  public String mac;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32419);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.mac == null)
      {
        paramVarArgs = new b("Not all required fields were included: mac");
        AppMethodBeat.o(32419);
        throw paramVarArgs;
      }
      if (this.userName == null)
      {
        paramVarArgs = new b("Not all required fields were included: userName");
        AppMethodBeat.o(32419);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mac != null) {
        paramVarArgs.g(2, this.mac);
      }
      if (this.userName != null) {
        paramVarArgs.g(3, this.userName);
      }
      if (this.kDf != null) {
        paramVarArgs.g(4, this.kDf);
      }
      AppMethodBeat.o(32419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label574;
      }
    }
    label574:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mac != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mac);
      }
      i = paramInt;
      if (this.userName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.userName);
      }
      paramInt = i;
      if (this.kDf != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.kDf);
      }
      AppMethodBeat.o(32419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.mac == null)
        {
          paramVarArgs = new b("Not all required fields were included: mac");
          AppMethodBeat.o(32419);
          throw paramVarArgs;
        }
        if (this.userName == null)
        {
          paramVarArgs = new b("Not all required fields were included: userName");
          AppMethodBeat.o(32419);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32419);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        euy localeuy = (euy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32419);
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
            localeuy.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32419);
          return 0;
        case 2: 
          localeuy.mac = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32419);
          return 0;
        case 3: 
          localeuy.userName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32419);
          return 0;
        }
        localeuy.kDf = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32419);
        return 0;
      }
      AppMethodBeat.o(32419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euy
 * JD-Core Version:    0.7.0.1
 */