package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eue
  extends erp
{
  public boolean Zmv;
  public LinkedList<String> abxg;
  
  public eue()
  {
    AppMethodBeat.i(257727);
    this.abxg = new LinkedList();
    AppMethodBeat.o(257727);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257730);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.abxg);
      paramVarArgs.di(3, this.Zmv);
      AppMethodBeat.o(257730);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.abxg);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(257730);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abxg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257730);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eue localeue = (eue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257730);
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
            localeue.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257730);
          return 0;
        case 2: 
          localeue.abxg.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(257730);
          return 0;
        }
        localeue.Zmv = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(257730);
        return 0;
      }
      AppMethodBeat.o(257730);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eue
 * JD-Core Version:    0.7.0.1
 */