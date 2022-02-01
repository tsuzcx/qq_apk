package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ati
  extends com.tencent.mm.cd.a
{
  public String MFj;
  public long SGl;
  public String appid;
  public String icon;
  public String link;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204596);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.icon != null) {
        paramVarArgs.f(2, this.icon);
      }
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.link != null) {
        paramVarArgs.f(4, this.link);
      }
      paramVarArgs.bm(5, this.SGl);
      if (this.MFj != null) {
        paramVarArgs.f(6, this.MFj);
      }
      AppMethodBeat.o(204596);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.icon);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.title);
      }
      paramInt = i;
      if (this.link != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.link);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.SGl);
      paramInt = i;
      if (this.MFj != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.MFj);
      }
      AppMethodBeat.o(204596);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204596);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ati localati = (ati)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(204596);
          return -1;
        case 1: 
          localati.appid = locala.abFh.readString();
          AppMethodBeat.o(204596);
          return 0;
        case 2: 
          localati.icon = locala.abFh.readString();
          AppMethodBeat.o(204596);
          return 0;
        case 3: 
          localati.title = locala.abFh.readString();
          AppMethodBeat.o(204596);
          return 0;
        case 4: 
          localati.link = locala.abFh.readString();
          AppMethodBeat.o(204596);
          return 0;
        case 5: 
          localati.SGl = locala.abFh.AN();
          AppMethodBeat.o(204596);
          return 0;
        }
        localati.MFj = locala.abFh.readString();
        AppMethodBeat.o(204596);
        return 0;
      }
      AppMethodBeat.o(204596);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ati
 * JD-Core Version:    0.7.0.1
 */