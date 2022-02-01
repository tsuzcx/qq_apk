package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cva
  extends erp
{
  public boolean aaAD;
  public String aaAE;
  public String appusername;
  public String nRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32281);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appusername == null)
      {
        paramVarArgs = new b("Not all required fields were included: appusername");
        AppMethodBeat.o(32281);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.aaAD);
      if (this.nRL != null) {
        paramVarArgs.g(3, this.nRL);
      }
      if (this.appusername != null) {
        paramVarArgs.g(4, this.appusername);
      }
      if (this.aaAE != null) {
        paramVarArgs.g(5, this.aaAE);
      }
      AppMethodBeat.o(32281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label567;
      }
    }
    label567:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.nRL != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.nRL);
      }
      i = paramInt;
      if (this.appusername != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.appusername);
      }
      paramInt = i;
      if (this.aaAE != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaAE);
      }
      AppMethodBeat.o(32281);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.appusername == null)
        {
          paramVarArgs = new b("Not all required fields were included: appusername");
          AppMethodBeat.o(32281);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32281);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cva localcva = (cva)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32281);
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
            localcva.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32281);
          return 0;
        case 2: 
          localcva.aaAD = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(32281);
          return 0;
        case 3: 
          localcva.nRL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32281);
          return 0;
        case 4: 
          localcva.appusername = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32281);
          return 0;
        }
        localcva.aaAE = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32281);
        return 0;
      }
      AppMethodBeat.o(32281);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cva
 * JD-Core Version:    0.7.0.1
 */