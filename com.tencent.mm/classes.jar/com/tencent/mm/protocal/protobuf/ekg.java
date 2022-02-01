package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekg
  extends erp
{
  public String YYi;
  public boolean abpq;
  public int abpr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72566);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YYi != null) {
        paramVarArgs.g(2, this.YYi);
      }
      paramVarArgs.di(3, this.abpq);
      paramVarArgs.bS(4, this.abpr);
      AppMethodBeat.o(72566);
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
      if (this.YYi != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YYi);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      int j = i.a.a.b.b.a.cJ(4, this.abpr);
      AppMethodBeat.o(72566);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72566);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ekg localekg = (ekg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72566);
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
            localekg.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72566);
          return 0;
        case 2: 
          localekg.YYi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72566);
          return 0;
        case 3: 
          localekg.abpq = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(72566);
          return 0;
        }
        localekg.abpr = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72566);
        return 0;
      }
      AppMethodBeat.o(72566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekg
 * JD-Core Version:    0.7.0.1
 */