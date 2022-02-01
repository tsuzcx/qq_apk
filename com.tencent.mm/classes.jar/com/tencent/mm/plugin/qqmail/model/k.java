package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public class k
  extends com.tencent.mm.bx.a
{
  public String KbS;
  public int NjF;
  public int dIL;
  public String name;
  public String pinyin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122694);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      if (this.KbS == null)
      {
        paramVarArgs = new b("Not all required fields were included: addr");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.dIL);
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      if (this.KbS != null) {
        paramVarArgs.g(3, this.KbS);
      }
      paramVarArgs.bS(4, this.NjF);
      if (this.pinyin != null) {
        paramVarArgs.g(5, this.pinyin);
      }
      AppMethodBeat.o(122694);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.dIL) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt;
      if (this.KbS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.KbS);
      }
      i += i.a.a.b.b.a.cJ(4, this.NjF);
      paramInt = i;
      if (this.pinyin != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.pinyin);
      }
      AppMethodBeat.o(122694);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      if (this.KbS == null)
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
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122694);
        return -1;
      case 1: 
        localk.dIL = locala.ajGk.aar();
        AppMethodBeat.o(122694);
        return 0;
      case 2: 
        localk.name = locala.ajGk.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 3: 
        localk.KbS = locala.ajGk.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 4: 
        localk.NjF = locala.ajGk.aar();
        AppMethodBeat.o(122694);
        return 0;
      }
      localk.pinyin = locala.ajGk.readString();
      AppMethodBeat.o(122694);
      return 0;
    }
    AppMethodBeat.o(122694);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.k
 * JD-Core Version:    0.7.0.1
 */