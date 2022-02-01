package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drc
  extends com.tencent.mm.bw.a
{
  public drd KKW;
  public String scope;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225295);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.e(1, this.scope);
      }
      if (this.KKW != null)
      {
        paramVarArgs.ni(2, this.KKW.computeSize());
        this.KKW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(225295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KKW != null) {
        i = paramInt + g.a.a.a.nh(2, this.KKW.computeSize());
      }
      AppMethodBeat.o(225295);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(225295);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        drc localdrc = (drc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(225295);
          return -1;
        case 1: 
          localdrc.scope = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(225295);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new drd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((drd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdrc.KKW = ((drd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(225295);
        return 0;
      }
      AppMethodBeat.o(225295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drc
 * JD-Core Version:    0.7.0.1
 */