package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class any
  extends erp
{
  public int IJG;
  public String Zvy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32190);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Zvy != null) {
        paramVarArgs.g(2, this.Zvy);
      }
      paramVarArgs.bS(3, this.IJG);
      AppMethodBeat.o(32190);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label397;
      }
    }
    label397:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zvy != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Zvy);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.IJG);
      AppMethodBeat.o(32190);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32190);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        any localany = (any)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32190);
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
            localany.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32190);
          return 0;
        case 2: 
          localany.Zvy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32190);
          return 0;
        }
        localany.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32190);
        return 0;
      }
      AppMethodBeat.o(32190);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.any
 * JD-Core Version:    0.7.0.1
 */