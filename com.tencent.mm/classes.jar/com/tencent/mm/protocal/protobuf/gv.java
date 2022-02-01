package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class gv
  extends dyy
{
  public String RLK;
  public String jUi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104746);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104746);
        throw paramVarArgs;
      }
      if (this.RLK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqKey");
        AppMethodBeat.o(104746);
        throw paramVarArgs;
      }
      if (this.jUi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(104746);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RLK != null) {
        paramVarArgs.f(2, this.RLK);
      }
      if (this.jUi != null) {
        paramVarArgs.f(3, this.jUi);
      }
      AppMethodBeat.o(104746);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label552;
      }
    }
    label552:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLK != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RLK);
      }
      i = paramInt;
      if (this.jUi != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jUi);
      }
      AppMethodBeat.o(104746);
      return i;
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
          AppMethodBeat.o(104746);
          throw paramVarArgs;
        }
        if (this.RLK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqKey");
          AppMethodBeat.o(104746);
          throw paramVarArgs;
        }
        if (this.jUi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(104746);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104746);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        gv localgv = (gv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104746);
          return -1;
        case 1: 
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
            localgv.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(104746);
          return 0;
        case 2: 
          localgv.RLK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104746);
          return 0;
        }
        localgv.jUi = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(104746);
        return 0;
      }
      AppMethodBeat.o(104746);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gv
 * JD-Core Version:    0.7.0.1
 */