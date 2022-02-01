package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class de
  extends com.tencent.mm.cd.a
{
  public String fHp;
  public LinkedList<String> username_list;
  
  public de()
  {
    AppMethodBeat.i(243353);
    this.username_list = new LinkedList();
    AppMethodBeat.o(243353);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243355);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fHp != null) {
        paramVarArgs.f(1, this.fHp);
      }
      paramVarArgs.e(2, 1, this.username_list);
      AppMethodBeat.o(243355);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fHp == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.fHp) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.username_list);
      AppMethodBeat.o(243355);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.username_list.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243355);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        de localde = (de)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(243355);
          return -1;
        case 1: 
          localde.fHp = locala.abFh.readString();
          AppMethodBeat.o(243355);
          return 0;
        }
        localde.username_list.add(locala.abFh.readString());
        AppMethodBeat.o(243355);
        return 0;
      }
      AppMethodBeat.o(243355);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.de
 * JD-Core Version:    0.7.0.1
 */