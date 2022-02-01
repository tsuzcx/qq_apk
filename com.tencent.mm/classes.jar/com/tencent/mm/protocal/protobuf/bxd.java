package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bxd
  extends dop
{
  public boolean McV;
  public String McW;
  public String ixr;
  public String rJH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32281);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rJH == null)
      {
        paramVarArgs = new b("Not all required fields were included: appusername");
        AppMethodBeat.o(32281);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(2, this.McV);
      if (this.ixr != null) {
        paramVarArgs.e(3, this.ixr);
      }
      if (this.rJH != null) {
        paramVarArgs.e(4, this.rJH);
      }
      if (this.McW != null) {
        paramVarArgs.e(5, this.McW);
      }
      AppMethodBeat.o(32281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label593;
      }
    }
    label593:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 1);
      paramInt = i;
      if (this.ixr != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.ixr);
      }
      i = paramInt;
      if (this.rJH != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.rJH);
      }
      paramInt = i;
      if (this.McW != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.McW);
      }
      AppMethodBeat.o(32281);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.rJH == null)
        {
          paramVarArgs = new b("Not all required fields were included: appusername");
          AppMethodBeat.o(32281);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32281);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bxd localbxd = (bxd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32281);
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
            localbxd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32281);
          return 0;
        case 2: 
          localbxd.McV = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(32281);
          return 0;
        case 3: 
          localbxd.ixr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32281);
          return 0;
        case 4: 
          localbxd.rJH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32281);
          return 0;
        }
        localbxd.McW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32281);
        return 0;
      }
      AppMethodBeat.o(32281);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxd
 * JD-Core Version:    0.7.0.1
 */