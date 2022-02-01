package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adn
  extends com.tencent.mm.bw.a
{
  public boolean Ewc;
  public boolean Ewd;
  public String Ewe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113998);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.Ewc);
      paramVarArgs.bl(2, this.Ewd);
      if (this.Ewe != null) {
        paramVarArgs.d(3, this.Ewe);
      }
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 1 + 0 + (f.a.a.b.b.a.fK(2) + 1);
      paramInt = i;
      if (this.Ewe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ewe);
      }
      AppMethodBeat.o(113998);
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
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      adn localadn = (adn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113998);
        return -1;
      case 1: 
        localadn.Ewc = locala.LVo.fZX();
        AppMethodBeat.o(113998);
        return 0;
      case 2: 
        localadn.Ewd = locala.LVo.fZX();
        AppMethodBeat.o(113998);
        return 0;
      }
      localadn.Ewe = locala.LVo.readString();
      AppMethodBeat.o(113998);
      return 0;
    }
    AppMethodBeat.o(113998);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adn
 * JD-Core Version:    0.7.0.1
 */