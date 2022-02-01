package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azk
  extends dyy
{
  public aze SJb;
  public bcg SLm;
  public String app_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198058);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.f(2, this.app_id);
      }
      if (this.SLm != null)
      {
        paramVarArgs.oE(3, this.SLm.computeSize());
        this.SLm.writeFields(paramVarArgs);
      }
      if (this.SJb != null)
      {
        paramVarArgs.oE(4, this.SJb.computeSize());
        this.SJb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(198058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label612;
      }
    }
    label612:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.app_id);
      }
      i = paramInt;
      if (this.SLm != null) {
        i = paramInt + g.a.a.a.oD(3, this.SLm.computeSize());
      }
      paramInt = i;
      if (this.SJb != null) {
        paramInt = i + g.a.a.a.oD(4, this.SJb.computeSize());
      }
      AppMethodBeat.o(198058);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azk localazk = (azk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198058);
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
            localazk.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198058);
          return 0;
        case 2: 
          localazk.app_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(198058);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcg)localObject2).parseFrom((byte[])localObject1);
            }
            localazk.SLm = ((bcg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198058);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aze();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aze)localObject2).parseFrom((byte[])localObject1);
          }
          localazk.SJb = ((aze)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198058);
        return 0;
      }
      AppMethodBeat.o(198058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azk
 * JD-Core Version:    0.7.0.1
 */