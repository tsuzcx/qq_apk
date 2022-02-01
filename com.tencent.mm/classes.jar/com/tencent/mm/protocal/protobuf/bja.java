package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bja
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> STk;
  public LinkedList<String> STl;
  public String cardId;
  public String rsw;
  public String title;
  public b xGO;
  
  public bja()
  {
    AppMethodBeat.i(210060);
    this.STk = new LinkedList();
    this.STl = new LinkedList();
    AppMethodBeat.o(210060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210061);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.cardId != null) {
        paramVarArgs.f(1, this.cardId);
      }
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      if (this.rsw != null) {
        paramVarArgs.f(3, this.rsw);
      }
      paramVarArgs.e(4, 1, this.STk);
      paramVarArgs.e(5, 1, this.STl);
      if (this.xGO != null) {
        paramVarArgs.c(6, this.xGO);
      }
      AppMethodBeat.o(210061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cardId == null) {
        break label510;
      }
    }
    label510:
    for (int i = g.a.a.b.b.a.g(1, this.cardId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.title);
      }
      i = paramInt;
      if (this.rsw != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.rsw);
      }
      i = i + g.a.a.a.c(4, 1, this.STk) + g.a.a.a.c(5, 1, this.STl);
      paramInt = i;
      if (this.xGO != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.xGO);
      }
      AppMethodBeat.o(210061);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.STk.clear();
        this.STl.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(210061);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bja localbja = (bja)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(210061);
          return -1;
        case 1: 
          localbja.cardId = locala.abFh.readString();
          AppMethodBeat.o(210061);
          return 0;
        case 2: 
          localbja.title = locala.abFh.readString();
          AppMethodBeat.o(210061);
          return 0;
        case 3: 
          localbja.rsw = locala.abFh.readString();
          AppMethodBeat.o(210061);
          return 0;
        case 4: 
          localbja.STk.add(locala.abFh.readString());
          AppMethodBeat.o(210061);
          return 0;
        case 5: 
          localbja.STl.add(locala.abFh.readString());
          AppMethodBeat.o(210061);
          return 0;
        }
        localbja.xGO = locala.abFh.iUw();
        AppMethodBeat.o(210061);
        return 0;
      }
      AppMethodBeat.o(210061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bja
 * JD-Core Version:    0.7.0.1
 */