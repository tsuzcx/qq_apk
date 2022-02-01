package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eub
  extends esc
{
  public String abxc;
  public int hAV;
  public String wYI;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91682);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91682);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      paramVarArgs.bS(4, this.wuj);
      if (this.abxc != null) {
        paramVarArgs.g(5, this.abxc);
      }
      AppMethodBeat.o(91682);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.wuj);
      paramInt = i;
      if (this.abxc != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abxc);
      }
      AppMethodBeat.o(91682);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91682);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91682);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eub localeub = (eub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91682);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localeub.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91682);
          return 0;
        case 2: 
          localeub.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91682);
          return 0;
        case 3: 
          localeub.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91682);
          return 0;
        case 4: 
          localeub.wuj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91682);
          return 0;
        }
        localeub.abxc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91682);
        return 0;
      }
      AppMethodBeat.o(91682);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eub
 * JD-Core Version:    0.7.0.1
 */