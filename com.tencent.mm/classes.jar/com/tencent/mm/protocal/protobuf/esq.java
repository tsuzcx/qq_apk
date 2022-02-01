package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esq
  extends com.tencent.mm.cd.a
{
  public String Uup;
  public String Uuq;
  public String appId;
  public String avatar;
  public String desc;
  public String fWP;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153000);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      if (this.fWP != null) {
        paramVarArgs.f(3, this.fWP);
      }
      if (this.Uup != null) {
        paramVarArgs.f(4, this.Uup);
      }
      if (this.Uuq != null) {
        paramVarArgs.f(5, this.Uuq);
      }
      if (this.appId != null) {
        paramVarArgs.f(6, this.appId);
      }
      if (this.avatar != null) {
        paramVarArgs.f(7, this.avatar);
      }
      AppMethodBeat.o(153000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.desc);
      }
      i = paramInt;
      if (this.fWP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fWP);
      }
      paramInt = i;
      if (this.Uup != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Uup);
      }
      i = paramInt;
      if (this.Uuq != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Uuq);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.appId);
      }
      i = paramInt;
      if (this.avatar != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.avatar);
      }
      AppMethodBeat.o(153000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153000);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        esq localesq = (esq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153000);
          return -1;
        case 1: 
          localesq.title = locala.abFh.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 2: 
          localesq.desc = locala.abFh.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 3: 
          localesq.fWP = locala.abFh.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 4: 
          localesq.Uup = locala.abFh.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 5: 
          localesq.Uuq = locala.abFh.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 6: 
          localesq.appId = locala.abFh.readString();
          AppMethodBeat.o(153000);
          return 0;
        }
        localesq.avatar = locala.abFh.readString();
        AppMethodBeat.o(153000);
        return 0;
      }
      AppMethodBeat.o(153000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esq
 * JD-Core Version:    0.7.0.1
 */