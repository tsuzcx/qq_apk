package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class asw
  extends dyy
{
  public int SFZ;
  public String thumbUrl;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210723);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(210723);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.f(2, this.thumbUrl);
      }
      paramVarArgs.aY(3, this.SFZ);
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(4, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(210723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = g.a.a.b.b.a.g(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.thumbUrl);
      }
      i += g.a.a.b.b.a.bM(3, this.SFZ);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + g.a.a.a.oD(4, this.BaseResponse.computeSize());
      }
      AppMethodBeat.o(210723);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(210723);
          throw paramVarArgs;
        }
        AppMethodBeat.o(210723);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        asw localasw = (asw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210723);
          return -1;
        case 1: 
          localasw.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(210723);
          return 0;
        case 2: 
          localasw.thumbUrl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(210723);
          return 0;
        case 3: 
          localasw.SFZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(210723);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          jh localjh = new jh();
          if ((localObject != null) && (localObject.length > 0)) {
            localjh.parseFrom((byte[])localObject);
          }
          localasw.BaseResponse = localjh;
          paramInt += 1;
        }
        AppMethodBeat.o(210723);
        return 0;
      }
      AppMethodBeat.o(210723);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asw
 * JD-Core Version:    0.7.0.1
 */