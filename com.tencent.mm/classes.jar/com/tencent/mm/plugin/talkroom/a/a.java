package com.tencent.mm.plugin.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fly;
import i.a.a.b;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bx.a
{
  public LinkedList<fly> hSk;
  public int sceneType;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(29432);
    this.hSk = new LinkedList();
    AppMethodBeat.o(29432);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(29433);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(29433);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.e(2, 8, this.hSk);
      paramVarArgs.bS(3, this.sceneType);
      AppMethodBeat.o(29433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label437;
      }
    }
    label437:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.hSk);
      int j = i.a.a.b.b.a.cJ(3, this.sceneType);
      AppMethodBeat.o(29433);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hSk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(29433);
          return -1;
        case 1: 
          locala.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(29433);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fly localfly = new fly();
            if ((localObject != null) && (localObject.length > 0)) {
              localfly.parseFrom((byte[])localObject);
            }
            locala.hSk.add(localfly);
            paramInt += 1;
          }
          AppMethodBeat.o(29433);
          return 0;
        }
        locala.sceneType = ((i.a.a.a.a)localObject).ajGk.aar();
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