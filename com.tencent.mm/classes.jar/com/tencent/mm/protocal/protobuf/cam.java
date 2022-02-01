package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cam
  extends dop
{
  public String jfi;
  public String keh;
  public String xLl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89660);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(89660);
        throw paramVarArgs;
      }
      if (this.xLl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(89660);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      if (this.xLl != null) {
        paramVarArgs.e(3, this.xLl);
      }
      if (this.keh != null) {
        paramVarArgs.e(4, this.keh);
      }
      AppMethodBeat.o(89660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.xLl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xLl);
      }
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.keh);
      }
      AppMethodBeat.o(89660);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.jfi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(89660);
          throw paramVarArgs;
        }
        if (this.xLl == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(89660);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89660);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cam localcam = (cam)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89660);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcam.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89660);
          return 0;
        case 2: 
          localcam.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89660);
          return 0;
        case 3: 
          localcam.xLl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(89660);
          return 0;
        }
        localcam.keh = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(89660);
        return 0;
      }
      AppMethodBeat.o(89660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cam
 * JD-Core Version:    0.7.0.1
 */