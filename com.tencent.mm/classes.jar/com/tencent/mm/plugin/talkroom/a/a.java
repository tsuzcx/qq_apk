package com.tencent.mm.plugin.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.equ;
import g.a.a.b;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.cd.a
{
  public LinkedList<equ> fMA;
  public int sceneType;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(29432);
    this.fMA = new LinkedList();
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
        paramVarArgs.f(1, this.username);
      }
      paramVarArgs.e(2, 8, this.fMA);
      paramVarArgs.aY(3, this.sceneType);
      AppMethodBeat.o(29433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label441;
      }
    }
    label441:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.fMA);
      int j = g.a.a.b.b.a.bM(3, this.sceneType);
      AppMethodBeat.o(29433);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.fMA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(29433);
          return -1;
        case 1: 
          locala.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(29433);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            equ localequ = new equ();
            if ((localObject != null) && (localObject.length > 0)) {
              localequ.parseFrom((byte[])localObject);
            }
            locala.fMA.add(localequ);
            paramInt += 1;
          }
          AppMethodBeat.o(29433);
          return 0;
        }
        locala.sceneType = ((g.a.a.a.a)localObject).abFh.AK();
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