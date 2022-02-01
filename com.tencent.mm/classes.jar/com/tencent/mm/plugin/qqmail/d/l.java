package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class l
  extends com.tencent.mm.bw.a
{
  public int Bry;
  public int bNi;
  public String name;
  public String pinyin;
  public String yFq;
  
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
      if (this.yFq == null)
      {
        paramVarArgs = new b("Not all required fields were included: addr");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.bNi);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.yFq != null) {
        paramVarArgs.e(3, this.yFq);
      }
      paramVarArgs.aM(4, this.Bry);
      if (this.pinyin != null) {
        paramVarArgs.e(5, this.pinyin);
      }
      AppMethodBeat.o(122694);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.bNi) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.yFq != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.yFq);
      }
      i += g.a.a.b.b.a.bu(4, this.Bry);
      paramInt = i;
      if (this.pinyin != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.pinyin);
      }
      AppMethodBeat.o(122694);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      if (this.yFq == null)
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
        locall.bNi = locala.UbS.zi();
        AppMethodBeat.o(122694);
        return 0;
      case 2: 
        locall.name = locala.UbS.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 3: 
        locall.yFq = locala.UbS.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 4: 
        locall.Bry = locala.UbS.zi();
        AppMethodBeat.o(122694);
        return 0;
      }
      locall.pinyin = locala.UbS.readString();
      AppMethodBeat.o(122694);
      return 0;
    }
    AppMethodBeat.o(122694);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.l
 * JD-Core Version:    0.7.0.1
 */