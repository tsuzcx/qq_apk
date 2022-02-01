package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aj
  extends com.tencent.mm.bx.a
{
  public String NkR;
  public String code;
  public String fileid;
  public String key;
  public String name;
  public int size;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267030);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.fileid != null) {
        paramVarArgs.g(1, this.fileid);
      }
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      paramVarArgs.bS(3, this.size);
      if (this.type != null) {
        paramVarArgs.g(4, this.type);
      }
      if (this.NkR != null) {
        paramVarArgs.g(5, this.NkR);
      }
      if (this.key != null) {
        paramVarArgs.g(6, this.key);
      }
      if (this.code != null) {
        paramVarArgs.g(7, this.code);
      }
      AppMethodBeat.o(267030);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileid == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = i.a.a.b.b.a.h(1, this.fileid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.name);
      }
      i += i.a.a.b.b.a.cJ(3, this.size);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.type);
      }
      i = paramInt;
      if (this.NkR != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.NkR);
      }
      paramInt = i;
      if (this.key != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.key);
      }
      i = paramInt;
      if (this.code != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.code);
      }
      AppMethodBeat.o(267030);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(267030);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aj localaj = (aj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(267030);
          return -1;
        case 1: 
          localaj.fileid = locala.ajGk.readString();
          AppMethodBeat.o(267030);
          return 0;
        case 2: 
          localaj.name = locala.ajGk.readString();
          AppMethodBeat.o(267030);
          return 0;
        case 3: 
          localaj.size = locala.ajGk.aar();
          AppMethodBeat.o(267030);
          return 0;
        case 4: 
          localaj.type = locala.ajGk.readString();
          AppMethodBeat.o(267030);
          return 0;
        case 5: 
          localaj.NkR = locala.ajGk.readString();
          AppMethodBeat.o(267030);
          return 0;
        case 6: 
          localaj.key = locala.ajGk.readString();
          AppMethodBeat.o(267030);
          return 0;
        }
        localaj.code = locala.ajGk.readString();
        AppMethodBeat.o(267030);
        return 0;
      }
      AppMethodBeat.o(267030);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.aj
 * JD-Core Version:    0.7.0.1
 */