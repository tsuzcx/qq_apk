package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dht
  extends erp
{
  public String appusername;
  public int hYl;
  public String nRL;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32336);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.appusername == null)
      {
        paramVarArgs = new b("Not all required fields were included: appusername");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.nRL == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.appusername != null) {
        paramVarArgs.g(3, this.appusername);
      }
      paramVarArgs.bS(4, this.hYl);
      if (this.nRL != null) {
        paramVarArgs.g(5, this.nRL);
      }
      AppMethodBeat.o(32336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label671;
      }
    }
    label671:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.appusername != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.appusername);
      }
      i += i.a.a.b.b.a.cJ(4, this.hYl);
      paramInt = i;
      if (this.nRL != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nRL);
      }
      AppMethodBeat.o(32336);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        if (this.appusername == null)
        {
          paramVarArgs = new b("Not all required fields were included: appusername");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        if (this.nRL == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32336);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dht localdht = (dht)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32336);
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
            localdht.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32336);
          return 0;
        case 2: 
          localdht.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32336);
          return 0;
        case 3: 
          localdht.appusername = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32336);
          return 0;
        case 4: 
          localdht.hYl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32336);
          return 0;
        }
        localdht.nRL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32336);
        return 0;
      }
      AppMethodBeat.o(32336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dht
 * JD-Core Version:    0.7.0.1
 */