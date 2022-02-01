package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bre
  extends dop
{
  public int LYG;
  public String SessionId;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184128);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      paramVarArgs.aM(3, this.LYG);
      if (this.SessionId != null) {
        paramVarArgs.e(4, this.SessionId);
      }
      AppMethodBeat.o(184128);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.UserName);
      }
      i += g.a.a.b.b.a.bu(3, this.LYG);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.SessionId);
      }
      AppMethodBeat.o(184128);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(184128);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bre localbre = (bre)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(184128);
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
            localbre.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(184128);
          return 0;
        case 2: 
          localbre.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(184128);
          return 0;
        case 3: 
          localbre.LYG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(184128);
          return 0;
        }
        localbre.SessionId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(184128);
        return 0;
      }
      AppMethodBeat.o(184128);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bre
 * JD-Core Version:    0.7.0.1
 */