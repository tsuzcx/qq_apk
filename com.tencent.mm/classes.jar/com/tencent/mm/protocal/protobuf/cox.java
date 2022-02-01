package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cox
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String iwv;
  public String path;
  public String title;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iwv != null) {
        paramVarArgs.e(1, this.iwv);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      if (this.username != null) {
        paramVarArgs.e(4, this.username);
      }
      if (this.path != null) {
        paramVarArgs.e(5, this.path);
      }
      AppMethodBeat.o(91539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iwv == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.f(1, this.iwv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.desc);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.path);
      }
      AppMethodBeat.o(91539);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91539);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cox localcox = (cox)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91539);
          return -1;
        case 1: 
          localcox.iwv = locala.UbS.readString();
          AppMethodBeat.o(91539);
          return 0;
        case 2: 
          localcox.title = locala.UbS.readString();
          AppMethodBeat.o(91539);
          return 0;
        case 3: 
          localcox.desc = locala.UbS.readString();
          AppMethodBeat.o(91539);
          return 0;
        case 4: 
          localcox.username = locala.UbS.readString();
          AppMethodBeat.o(91539);
          return 0;
        }
        localcox.path = locala.UbS.readString();
        AppMethodBeat.o(91539);
        return 0;
      }
      AppMethodBeat.o(91539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cox
 * JD-Core Version:    0.7.0.1
 */