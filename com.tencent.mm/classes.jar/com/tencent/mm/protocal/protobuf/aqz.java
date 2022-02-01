package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqz
  extends dop
{
  public String LCL;
  public String LCM;
  public String clientId;
  public String url;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209386);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.clientId != null) {
        paramVarArgs.e(2, this.clientId);
      }
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      if (this.LCL != null) {
        paramVarArgs.e(4, this.LCL);
      }
      if (this.LCM != null) {
        paramVarArgs.e(5, this.LCM);
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(6, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209386);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label614;
      }
    }
    label614:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.clientId);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.url);
      }
      paramInt = i;
      if (this.LCL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LCL);
      }
      i = paramInt;
      if (this.LCM != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LCM);
      }
      paramInt = i;
      if (this.BaseRequest != null) {
        paramInt = i + g.a.a.a.nh(6, this.BaseRequest.computeSize());
      }
      AppMethodBeat.o(209386);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209386);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqz localaqz = (aqz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209386);
          return -1;
        case 1: 
          localaqz.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209386);
          return 0;
        case 2: 
          localaqz.clientId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209386);
          return 0;
        case 3: 
          localaqz.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209386);
          return 0;
        case 4: 
          localaqz.LCL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209386);
          return 0;
        case 5: 
          localaqz.LCM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209386);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new jr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaqz.BaseRequest = ((jr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209386);
        return 0;
      }
      AppMethodBeat.o(209386);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqz
 * JD-Core Version:    0.7.0.1
 */