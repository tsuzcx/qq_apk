package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqq
  extends erp
{
  public String ZxK;
  public String ZxL;
  public int muC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155405);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.muC);
      if (this.ZxK != null) {
        paramVarArgs.g(3, this.ZxK);
      }
      if (this.ZxL != null) {
        paramVarArgs.g(4, this.ZxL);
      }
      AppMethodBeat.o(155405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.muC);
      paramInt = i;
      if (this.ZxK != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZxK);
      }
      i = paramInt;
      if (this.ZxL != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZxL);
      }
      AppMethodBeat.o(155405);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155405);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aqq localaqq = (aqq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155405);
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
            localaqq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(155405);
          return 0;
        case 2: 
          localaqq.muC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(155405);
          return 0;
        case 3: 
          localaqq.ZxK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155405);
          return 0;
        }
        localaqq.ZxL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(155405);
        return 0;
      }
      AppMethodBeat.o(155405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqq
 * JD-Core Version:    0.7.0.1
 */