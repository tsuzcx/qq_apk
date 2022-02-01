package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egd
  extends erp
{
  public int aaBP;
  public int aarf;
  public boolean ablz;
  public String appid;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123636);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.appid != null) {
        paramVarArgs.g(3, this.appid);
      }
      paramVarArgs.bS(4, this.aaBP);
      if (this.path != null) {
        paramVarArgs.g(5, this.path);
      }
      paramVarArgs.bS(6, this.aarf);
      paramVarArgs.di(7, this.ablz);
      AppMethodBeat.o(123636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label600;
      }
    }
    label600:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.appid);
      }
      i += i.a.a.b.b.a.cJ(4, this.aaBP);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.path);
      }
      i = i.a.a.b.b.a.cJ(6, this.aarf);
      int j = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(123636);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        egd localegd = (egd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123636);
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
            localegd.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(123636);
          return 0;
        case 2: 
          localegd.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 3: 
          localegd.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 4: 
          localegd.aaBP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123636);
          return 0;
        case 5: 
          localegd.path = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 6: 
          localegd.aarf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123636);
          return 0;
        }
        localegd.ablz = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(123636);
        return 0;
      }
      AppMethodBeat.o(123636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egd
 * JD-Core Version:    0.7.0.1
 */