package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class g
  extends dop
{
  public String appId;
  public String gTp;
  public String gTq;
  public String uxInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194679);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appId != null) {
        paramVarArgs.e(2, this.appId);
      }
      if (this.gTp != null) {
        paramVarArgs.e(3, this.gTp);
      }
      if (this.uxInfo != null) {
        paramVarArgs.e(4, this.uxInfo);
      }
      if (this.gTq != null) {
        paramVarArgs.e(5, this.gTq);
      }
      AppMethodBeat.o(194679);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.appId);
      }
      i = paramInt;
      if (this.gTp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.gTp);
      }
      paramInt = i;
      if (this.uxInfo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.uxInfo);
      }
      i = paramInt;
      if (this.gTq != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.gTq);
      }
      AppMethodBeat.o(194679);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(194679);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194679);
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
            localg.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194679);
          return 0;
        case 2: 
          localg.appId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(194679);
          return 0;
        case 3: 
          localg.gTp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(194679);
          return 0;
        case 4: 
          localg.uxInfo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(194679);
          return 0;
        }
        localg.gTq = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194679);
        return 0;
      }
      AppMethodBeat.o(194679);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.t.a.g
 * JD-Core Version:    0.7.0.1
 */