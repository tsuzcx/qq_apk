package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoo
  extends erp
{
  public int IJG;
  public String ZvR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56245);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZvR != null) {
        paramVarArgs.g(2, this.ZvR);
      }
      paramVarArgs.bS(3, this.IJG);
      AppMethodBeat.o(56245);
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
      int i = paramInt;
      if (this.ZvR != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZvR);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.IJG);
      AppMethodBeat.o(56245);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(56245);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aoo localaoo = (aoo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56245);
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
            localaoo.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(56245);
          return 0;
        case 2: 
          localaoo.ZvR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(56245);
          return 0;
        }
        localaoo.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(56245);
        return 0;
      }
      AppMethodBeat.o(56245);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoo
 * JD-Core Version:    0.7.0.1
 */