package com.tencent.mm.plugin.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.egs;
import g.a.a.b;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bw.a
{
  public LinkedList<egs> dTe;
  public int sceneType;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(29432);
    this.dTe = new LinkedList();
    AppMethodBeat.o(29432);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(29433);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(29433);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.e(2, 8, this.dTe);
      paramVarArgs.aM(3, this.sceneType);
      AppMethodBeat.o(29433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label463;
      }
    }
    label463:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.dTe);
      int j = g.a.a.b.b.a.bu(3, this.sceneType);
      AppMethodBeat.o(29433);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.dTe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(29433);
          throw paramVarArgs;
        }
        AppMethodBeat.o(29433);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(29433);
          return -1;
        case 1: 
          locala.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(29433);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((egs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locala.dTe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(29433);
          return 0;
        }
        locala.sceneType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(29433);
        return 0;
      }
      AppMethodBeat.o(29433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.a.a
 * JD-Core Version:    0.7.0.1
 */