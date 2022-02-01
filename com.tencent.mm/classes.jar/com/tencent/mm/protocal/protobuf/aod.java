package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aod
  extends com.tencent.mm.bx.a
{
  public int ZvG;
  public int ZvH;
  public String ZvI;
  public String icon_url;
  public int show_type;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179487);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZvG);
      paramVarArgs.bS(2, this.ZvH);
      paramVarArgs.bS(3, this.show_type);
      if (this.wording != null) {
        paramVarArgs.g(4, this.wording);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(5, this.icon_url);
      }
      if (this.ZvI != null) {
        paramVarArgs.g(6, this.ZvI);
      }
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZvG) + 0 + i.a.a.b.b.a.cJ(2, this.ZvH) + i.a.a.b.b.a.cJ(3, this.show_type);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wording);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.icon_url);
      }
      paramInt = i;
      if (this.ZvI != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZvI);
      }
      AppMethodBeat.o(179487);
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
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aod localaod = (aod)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(179487);
        return -1;
      case 1: 
        localaod.ZvG = locala.ajGk.aar();
        AppMethodBeat.o(179487);
        return 0;
      case 2: 
        localaod.ZvH = locala.ajGk.aar();
        AppMethodBeat.o(179487);
        return 0;
      case 3: 
        localaod.show_type = locala.ajGk.aar();
        AppMethodBeat.o(179487);
        return 0;
      case 4: 
        localaod.wording = locala.ajGk.readString();
        AppMethodBeat.o(179487);
        return 0;
      case 5: 
        localaod.icon_url = locala.ajGk.readString();
        AppMethodBeat.o(179487);
        return 0;
      }
      localaod.ZvI = locala.ajGk.readString();
      AppMethodBeat.o(179487);
      return 0;
    }
    AppMethodBeat.o(179487);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aod
 * JD-Core Version:    0.7.0.1
 */