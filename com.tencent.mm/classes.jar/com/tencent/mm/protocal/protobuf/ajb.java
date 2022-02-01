package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajb
  extends erp
{
  public boolean ZqT;
  public String appid;
  public int iaK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74652);
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
      paramVarArgs.bS(3, this.iaK);
      paramVarArgs.di(4, this.ZqT);
      AppMethodBeat.o(74652);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label432;
      }
    }
    label432:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appid);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.iaK);
      int j = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(74652);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(74652);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ajb localajb = (ajb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74652);
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
            localajb.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(74652);
          return 0;
        case 2: 
          localajb.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(74652);
          return 0;
        case 3: 
          localajb.iaK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(74652);
          return 0;
        }
        localajb.ZqT = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(74652);
        return 0;
      }
      AppMethodBeat.o(74652);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajb
 * JD-Core Version:    0.7.0.1
 */