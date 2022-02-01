package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cbb
  extends dyy
{
  public int RVf;
  public eae Thg;
  public String Tjr;
  public String Tjs;
  public String Tjt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152593);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152593);
        throw paramVarArgs;
      }
      if (this.Thg == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCode");
        AppMethodBeat.o(152593);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Thg != null)
      {
        paramVarArgs.oE(2, this.Thg.computeSize());
        this.Thg.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.RVf);
      if (this.Tjr != null) {
        paramVarArgs.f(6, this.Tjr);
      }
      if (this.Tjs != null) {
        paramVarArgs.f(7, this.Tjs);
      }
      if (this.Tjt != null) {
        paramVarArgs.f(8, this.Tjt);
      }
      AppMethodBeat.o(152593);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Thg != null) {
        i = paramInt + g.a.a.a.oD(2, this.Thg.computeSize());
      }
      i += g.a.a.b.b.a.bM(5, this.RVf);
      paramInt = i;
      if (this.Tjr != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tjr);
      }
      i = paramInt;
      if (this.Tjs != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Tjs);
      }
      paramInt = i;
      if (this.Tjt != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Tjt);
      }
      AppMethodBeat.o(152593);
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
          AppMethodBeat.o(152593);
          throw paramVarArgs;
        }
        if (this.Thg == null)
        {
          paramVarArgs = new b("Not all required fields were included: QRCode");
          AppMethodBeat.o(152593);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152593);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbb localcbb = (cbb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(152593);
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
            localcbb.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 2: 
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
            localcbb.Thg = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152593);
          return 0;
        case 5: 
          localcbb.RVf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152593);
          return 0;
        case 6: 
          localcbb.Tjr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152593);
          return 0;
        case 7: 
          localcbb.Tjs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152593);
          return 0;
        }
        localcbb.Tjt = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(152593);
        return 0;
      }
      AppMethodBeat.o(152593);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbb
 * JD-Core Version:    0.7.0.1
 */