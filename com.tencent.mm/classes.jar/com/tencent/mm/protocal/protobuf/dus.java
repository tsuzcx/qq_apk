package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dus
  extends com.tencent.mm.bx.a
{
  public String YSS;
  public int abaE;
  public String jump_url;
  public String left_icon;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259050);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abaE);
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.left_icon != null) {
        paramVarArgs.g(3, this.left_icon);
      }
      if (this.jump_url != null) {
        paramVarArgs.g(4, this.jump_url);
      }
      if (this.YSS != null) {
        paramVarArgs.g(5, this.YSS);
      }
      AppMethodBeat.o(259050);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abaE) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.left_icon != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.left_icon);
      }
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.jump_url);
      }
      i = paramInt;
      if (this.YSS != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YSS);
      }
      AppMethodBeat.o(259050);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259050);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dus localdus = (dus)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259050);
        return -1;
      case 1: 
        localdus.abaE = locala.ajGk.aar();
        AppMethodBeat.o(259050);
        return 0;
      case 2: 
        localdus.wording = locala.ajGk.readString();
        AppMethodBeat.o(259050);
        return 0;
      case 3: 
        localdus.left_icon = locala.ajGk.readString();
        AppMethodBeat.o(259050);
        return 0;
      case 4: 
        localdus.jump_url = locala.ajGk.readString();
        AppMethodBeat.o(259050);
        return 0;
      }
      localdus.YSS = locala.ajGk.readString();
      AppMethodBeat.o(259050);
      return 0;
    }
    AppMethodBeat.o(259050);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dus
 * JD-Core Version:    0.7.0.1
 */