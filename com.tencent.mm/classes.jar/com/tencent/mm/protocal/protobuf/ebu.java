package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ebu
  extends dyy
{
  public eae TdH;
  public long TdK;
  public String UgK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104835);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104835);
        throw paramVarArgs;
      }
      if (this.UgK == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchResult");
        AppMethodBeat.o(104835);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UgK != null) {
        paramVarArgs.f(2, this.UgK);
      }
      if (this.TdH != null)
      {
        paramVarArgs.oE(3, this.TdH.computeSize());
        this.TdH.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(4, this.TdK);
      AppMethodBeat.o(104835);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label622;
      }
    }
    label622:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UgK != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UgK);
      }
      i = paramInt;
      if (this.TdH != null) {
        i = paramInt + g.a.a.a.oD(3, this.TdH.computeSize());
      }
      paramInt = g.a.a.b.b.a.p(4, this.TdK);
      AppMethodBeat.o(104835);
      return i + paramInt;
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
          AppMethodBeat.o(104835);
          throw paramVarArgs;
        }
        if (this.UgK == null)
        {
          paramVarArgs = new b("Not all required fields were included: SearchResult");
          AppMethodBeat.o(104835);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104835);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebu localebu = (ebu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104835);
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
            localebu.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104835);
          return 0;
        case 2: 
          localebu.UgK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104835);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localebu.TdH = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104835);
          return 0;
        }
        localebu.TdK = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(104835);
        return 0;
      }
      AppMethodBeat.o(104835);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebu
 * JD-Core Version:    0.7.0.1
 */