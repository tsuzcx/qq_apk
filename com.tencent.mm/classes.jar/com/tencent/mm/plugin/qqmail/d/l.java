package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class l
  extends com.tencent.mm.bx.a
{
  public String name;
  public String pinyin;
  public String uZn;
  public int xbE;
  public int xbF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122694);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      if (this.uZn == null)
      {
        paramVarArgs = new b("Not all required fields were included: addr");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.xbE);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.uZn != null) {
        paramVarArgs.d(3, this.uZn);
      }
      paramVarArgs.aS(4, this.xbF);
      if (this.pinyin != null) {
        paramVarArgs.d(5, this.pinyin);
      }
      AppMethodBeat.o(122694);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.xbE) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.uZn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uZn);
      }
      i += f.a.a.b.b.a.bz(4, this.xbF);
      paramInt = i;
      if (this.pinyin != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.pinyin);
      }
      AppMethodBeat.o(122694);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      if (this.uZn == null)
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
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122694);
        return -1;
      case 1: 
        locall.xbE = locala.NPN.zc();
        AppMethodBeat.o(122694);
        return 0;
      case 2: 
        locall.name = locala.NPN.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 3: 
        locall.uZn = locala.NPN.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 4: 
        locall.xbF = locala.NPN.zc();
        AppMethodBeat.o(122694);
        return 0;
      }
      locall.pinyin = locala.NPN.readString();
      AppMethodBeat.o(122694);
      return 0;
    }
    AppMethodBeat.o(122694);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.l
 * JD-Core Version:    0.7.0.1
 */