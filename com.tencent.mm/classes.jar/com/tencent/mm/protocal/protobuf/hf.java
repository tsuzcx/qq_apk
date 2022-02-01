package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hf
  extends erp
{
  public String OcL;
  public String YIK;
  public String hAk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72417);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.OcL != null) {
        paramVarArgs.g(2, this.OcL);
      }
      if (this.hAk != null) {
        paramVarArgs.g(3, this.hAk);
      }
      if (this.YIK != null) {
        paramVarArgs.g(4, this.YIK);
      }
      AppMethodBeat.o(72417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.OcL != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.OcL);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hAk);
      }
      paramInt = i;
      if (this.YIK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YIK);
      }
      AppMethodBeat.o(72417);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        hf localhf = (hf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72417);
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
            localhf.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72417);
          return 0;
        case 2: 
          localhf.OcL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72417);
          return 0;
        case 3: 
          localhf.hAk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72417);
          return 0;
        }
        localhf.YIK = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72417);
        return 0;
      }
      AppMethodBeat.o(72417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hf
 * JD-Core Version:    0.7.0.1
 */