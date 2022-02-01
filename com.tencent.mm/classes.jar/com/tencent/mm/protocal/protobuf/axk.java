package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class axk
  extends esc
{
  public int EUp;
  public String thumbUrl;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259780);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259780);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.g(2, this.thumbUrl);
      }
      paramVarArgs.bS(3, this.EUp);
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(4, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.thumbUrl);
      }
      i += i.a.a.b.b.a.cJ(3, this.EUp);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + i.a.a.a.qC(4, this.BaseResponse.computeSize());
      }
      AppMethodBeat.o(259780);
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
          AppMethodBeat.o(259780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259780);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        axk localaxk = (axk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259780);
          return -1;
        case 1: 
          localaxk.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259780);
          return 0;
        case 2: 
          localaxk.thumbUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259780);
          return 0;
        case 3: 
          localaxk.EUp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259780);
          return 0;
        }
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
          localaxk.BaseResponse = localkd;
          paramInt += 1;
        }
        AppMethodBeat.o(259780);
        return 0;
      }
      AppMethodBeat.o(259780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axk
 * JD-Core Version:    0.7.0.1
 */