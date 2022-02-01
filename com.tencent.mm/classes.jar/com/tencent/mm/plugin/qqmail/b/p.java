package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class p
  extends com.tencent.mm.bw.a
{
  public String name;
  public String pinyin;
  public String tWE;
  public int vUo;
  public int vUp;
  
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
      if (this.tWE == null)
      {
        paramVarArgs = new b("Not all required fields were included: addr");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.vUo);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.tWE != null) {
        paramVarArgs.d(3, this.tWE);
      }
      paramVarArgs.aR(4, this.vUp);
      if (this.pinyin != null) {
        paramVarArgs.d(5, this.pinyin);
      }
      AppMethodBeat.o(122694);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.vUo) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.tWE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tWE);
      }
      i += f.a.a.b.b.a.bx(4, this.vUp);
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
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      if (this.tWE == null)
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
      p localp = (p)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122694);
        return -1;
      case 1: 
        localp.vUo = locala.LVo.xF();
        AppMethodBeat.o(122694);
        return 0;
      case 2: 
        localp.name = locala.LVo.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 3: 
        localp.tWE = locala.LVo.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 4: 
        localp.vUp = locala.LVo.xF();
        AppMethodBeat.o(122694);
        return 0;
      }
      localp.pinyin = locala.LVo.readString();
      AppMethodBeat.o(122694);
      return 0;
    }
    AppMethodBeat.o(122694);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.p
 * JD-Core Version:    0.7.0.1
 */