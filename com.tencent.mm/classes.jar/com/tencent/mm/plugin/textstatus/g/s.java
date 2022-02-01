package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class s
  extends dop
{
  public String GaI;
  public int GaR;
  public String Gas;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222841);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GaI != null) {
        paramVarArgs.e(2, this.GaI);
      }
      if (this.Gas != null) {
        paramVarArgs.e(3, this.Gas);
      }
      if (this.username != null) {
        paramVarArgs.e(4, this.username);
      }
      paramVarArgs.aM(5, this.GaR);
      paramVarArgs.aM(6, this.type);
      AppMethodBeat.o(222841);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GaI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.GaI);
      }
      i = paramInt;
      if (this.Gas != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Gas);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.username);
      }
      i = g.a.a.b.b.a.bu(5, this.GaR);
      int j = g.a.a.b.b.a.bu(6, this.type);
      AppMethodBeat.o(222841);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(222841);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        s locals = (s)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(222841);
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
            locals.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(222841);
          return 0;
        case 2: 
          locals.GaI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222841);
          return 0;
        case 3: 
          locals.Gas = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222841);
          return 0;
        case 4: 
          locals.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222841);
          return 0;
        case 5: 
          locals.GaR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(222841);
          return 0;
        }
        locals.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(222841);
        return 0;
      }
      AppMethodBeat.o(222841);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.s
 * JD-Core Version:    0.7.0.1
 */