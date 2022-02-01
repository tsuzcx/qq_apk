package com.tencent.mm.plugin.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dgr;
import f.a.a.b;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bw.a
{
  public LinkedList<dgr> dow;
  public int sceneType;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(29432);
    this.dow = new LinkedList();
    AppMethodBeat.o(29432);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(29433);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(29433);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.e(2, 8, this.dow);
      paramVarArgs.aR(3, this.sceneType);
      AppMethodBeat.o(29433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label463;
      }
    }
    label463:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.dow);
      int j = f.a.a.b.b.a.bx(3, this.sceneType);
      AppMethodBeat.o(29433);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.dow.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(29433);
          return -1;
        case 1: 
          locala.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(29433);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dgr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.dow.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(29433);
          return 0;
        }
        locala.sceneType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(29433);
        return 0;
      }
      AppMethodBeat.o(29433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.a.a
 * JD-Core Version:    0.7.0.1
 */