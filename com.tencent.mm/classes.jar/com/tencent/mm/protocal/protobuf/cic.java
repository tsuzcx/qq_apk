package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cic
  extends dop
{
  public int dYx;
  public String ixr;
  public String rJH;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32336);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.rJH == null)
      {
        paramVarArgs = new b("Not all required fields were included: appusername");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.ixr == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      if (this.rJH != null) {
        paramVarArgs.e(3, this.rJH);
      }
      paramVarArgs.aM(4, this.dYx);
      if (this.ixr != null) {
        paramVarArgs.e(5, this.ixr);
      }
      AppMethodBeat.o(32336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label697;
      }
    }
    label697:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.username);
      }
      i = paramInt;
      if (this.rJH != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.rJH);
      }
      i += g.a.a.b.b.a.bu(4, this.dYx);
      paramInt = i;
      if (this.ixr != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.ixr);
      }
      AppMethodBeat.o(32336);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        if (this.rJH == null)
        {
          paramVarArgs = new b("Not all required fields were included: appusername");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        if (this.ixr == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32336);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cic localcic = (cic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32336);
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
            localcic.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32336);
          return 0;
        case 2: 
          localcic.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32336);
          return 0;
        case 3: 
          localcic.rJH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32336);
          return 0;
        case 4: 
          localcic.dYx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32336);
          return 0;
        }
        localcic.ixr = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32336);
        return 0;
      }
      AppMethodBeat.o(32336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cic
 * JD-Core Version:    0.7.0.1
 */