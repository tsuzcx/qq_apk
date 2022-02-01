package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class coc
  extends esc
{
  public int YME;
  public String YMF;
  public String aavo;
  public String aavp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91493);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91493);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YME);
      if (this.YMF != null) {
        paramVarArgs.g(3, this.YMF);
      }
      if (this.aavo != null) {
        paramVarArgs.g(4, this.aavo);
      }
      if (this.aavp != null) {
        paramVarArgs.g(5, this.aavp);
      }
      AppMethodBeat.o(91493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YME);
      paramInt = i;
      if (this.YMF != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YMF);
      }
      i = paramInt;
      if (this.aavo != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aavo);
      }
      paramInt = i;
      if (this.aavp != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aavp);
      }
      AppMethodBeat.o(91493);
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
          AppMethodBeat.o(91493);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91493);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        coc localcoc = (coc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91493);
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
            localcoc.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91493);
          return 0;
        case 2: 
          localcoc.YME = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91493);
          return 0;
        case 3: 
          localcoc.YMF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91493);
          return 0;
        case 4: 
          localcoc.aavo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91493);
          return 0;
        }
        localcoc.aavp = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91493);
        return 0;
      }
      AppMethodBeat.o(91493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coc
 * JD-Core Version:    0.7.0.1
 */