package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eog
  extends dyy
{
  public int UqV;
  public int UqW;
  public eob Uqi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118470);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118470);
        throw paramVarArgs;
      }
      if (this.Uqi == null)
      {
        paramVarArgs = new b("Not all required fields were included: StoryObject");
        AppMethodBeat.o(118470);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Uqi != null)
      {
        paramVarArgs.oE(2, this.Uqi.computeSize());
        this.Uqi.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.UqV);
      paramVarArgs.aY(4, this.UqW);
      AppMethodBeat.o(118470);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Uqi != null) {
        i = paramInt + g.a.a.a.oD(2, this.Uqi.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(3, this.UqV);
      int j = g.a.a.b.b.a.bM(4, this.UqW);
      AppMethodBeat.o(118470);
      return i + paramInt + j;
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
          AppMethodBeat.o(118470);
          throw paramVarArgs;
        }
        if (this.Uqi == null)
        {
          paramVarArgs = new b("Not all required fields were included: StoryObject");
          AppMethodBeat.o(118470);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118470);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eog localeog = (eog)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118470);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localeog.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118470);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eob();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eob)localObject2).parseFrom((byte[])localObject1);
            }
            localeog.Uqi = ((eob)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118470);
          return 0;
        case 3: 
          localeog.UqV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(118470);
          return 0;
        }
        localeog.UqW = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118470);
        return 0;
      }
      AppMethodBeat.o(118470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eog
 * JD-Core Version:    0.7.0.1
 */