package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwb
  extends erp
{
  public int IJG;
  public int aaBl;
  public int aaBm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32307);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.IJG);
      paramVarArgs.bS(3, this.aaBl);
      paramVarArgs.bS(4, this.aaBm);
      AppMethodBeat.o(32307);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label430;
      }
    }
    label430:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.IJG);
      int j = i.a.a.b.b.a.cJ(3, this.aaBl);
      int k = i.a.a.b.b.a.cJ(4, this.aaBm);
      AppMethodBeat.o(32307);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32307);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cwb localcwb = (cwb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32307);
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
            localcwb.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32307);
          return 0;
        case 2: 
          localcwb.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32307);
          return 0;
        case 3: 
          localcwb.aaBl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32307);
          return 0;
        }
        localcwb.aaBm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32307);
        return 0;
      }
      AppMethodBeat.o(32307);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwb
 * JD-Core Version:    0.7.0.1
 */