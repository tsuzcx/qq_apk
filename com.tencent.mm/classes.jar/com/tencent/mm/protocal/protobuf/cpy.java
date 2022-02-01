package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cpy
  extends esc
{
  public int YME;
  public String YMF;
  public String aawt;
  public String aawu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91505);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91505);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aawt != null) {
        paramVarArgs.g(2, this.aawt);
      }
      paramVarArgs.bS(3, this.YME);
      if (this.YMF != null) {
        paramVarArgs.g(4, this.YMF);
      }
      if (this.aawu != null) {
        paramVarArgs.g(5, this.aawu);
      }
      AppMethodBeat.o(91505);
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
      int i = paramInt;
      if (this.aawt != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aawt);
      }
      i += i.a.a.b.b.a.cJ(3, this.YME);
      paramInt = i;
      if (this.YMF != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YMF);
      }
      i = paramInt;
      if (this.aawu != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aawu);
      }
      AppMethodBeat.o(91505);
      return i;
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
          AppMethodBeat.o(91505);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cpy localcpy = (cpy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91505);
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
            localcpy.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91505);
          return 0;
        case 2: 
          localcpy.aawt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91505);
          return 0;
        case 3: 
          localcpy.YME = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91505);
          return 0;
        case 4: 
          localcpy.YMF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91505);
          return 0;
        }
        localcpy.aawu = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91505);
        return 0;
      }
      AppMethodBeat.o(91505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpy
 * JD-Core Version:    0.7.0.1
 */