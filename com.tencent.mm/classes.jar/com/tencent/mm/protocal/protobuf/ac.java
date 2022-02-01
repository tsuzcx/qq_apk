package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac
  extends com.tencent.mm.bx.a
{
  public String KuO;
  public String KuP;
  public int YAF;
  public String rGU;
  public String right_button_wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91339);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YAF);
      if (this.KuO != null) {
        paramVarArgs.g(2, this.KuO);
      }
      if (this.rGU != null) {
        paramVarArgs.g(3, this.rGU);
      }
      if (this.right_button_wording != null) {
        paramVarArgs.g(4, this.right_button_wording);
      }
      if (this.KuP != null) {
        paramVarArgs.g(5, this.KuP);
      }
      AppMethodBeat.o(91339);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YAF) + 0;
      paramInt = i;
      if (this.KuO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.KuO);
      }
      i = paramInt;
      if (this.rGU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.rGU);
      }
      paramInt = i;
      if (this.right_button_wording != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.right_button_wording);
      }
      i = paramInt;
      if (this.KuP != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.KuP);
      }
      AppMethodBeat.o(91339);
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
      AppMethodBeat.o(91339);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ac localac = (ac)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91339);
        return -1;
      case 1: 
        localac.YAF = locala.ajGk.aar();
        AppMethodBeat.o(91339);
        return 0;
      case 2: 
        localac.KuO = locala.ajGk.readString();
        AppMethodBeat.o(91339);
        return 0;
      case 3: 
        localac.rGU = locala.ajGk.readString();
        AppMethodBeat.o(91339);
        return 0;
      case 4: 
        localac.right_button_wording = locala.ajGk.readString();
        AppMethodBeat.o(91339);
        return 0;
      }
      localac.KuP = locala.ajGk.readString();
      AppMethodBeat.o(91339);
      return 0;
    }
    AppMethodBeat.o(91339);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ac
 * JD-Core Version:    0.7.0.1
 */