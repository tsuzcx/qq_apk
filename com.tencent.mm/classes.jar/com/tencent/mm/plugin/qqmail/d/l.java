package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class l
  extends com.tencent.mm.cd.a
{
  public String Ejj;
  public int HlR;
  public int bPh;
  public String name;
  public String pinyin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122694);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      if (this.Ejj == null)
      {
        paramVarArgs = new b("Not all required fields were included: addr");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.bPh);
      if (this.name != null) {
        paramVarArgs.f(2, this.name);
      }
      if (this.Ejj != null) {
        paramVarArgs.f(3, this.Ejj);
      }
      paramVarArgs.aY(4, this.HlR);
      if (this.pinyin != null) {
        paramVarArgs.f(5, this.pinyin);
      }
      AppMethodBeat.o(122694);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.bPh) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.name);
      }
      i = paramInt;
      if (this.Ejj != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ejj);
      }
      i += g.a.a.b.b.a.bM(4, this.HlR);
      paramInt = i;
      if (this.pinyin != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.pinyin);
      }
      AppMethodBeat.o(122694);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      if (this.Ejj == null)
      {
        paramVarArgs = new b("Not all required fields were included: addr");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      AppMethodBeat.o(122694);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122694);
        return -1;
      case 1: 
        locall.bPh = locala.abFh.AK();
        AppMethodBeat.o(122694);
        return 0;
      case 2: 
        locall.name = locala.abFh.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 3: 
        locall.Ejj = locala.abFh.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 4: 
        locall.HlR = locala.abFh.AK();
        AppMethodBeat.o(122694);
        return 0;
      }
      locall.pinyin = locala.abFh.readString();
      AppMethodBeat.o(122694);
      return 0;
    }
    AppMethodBeat.o(122694);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.l
 * JD-Core Version:    0.7.0.1
 */