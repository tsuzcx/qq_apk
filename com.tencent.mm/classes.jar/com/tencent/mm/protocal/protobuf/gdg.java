package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gdg
  extends com.tencent.mm.bx.a
{
  public String IHW;
  public String IMh;
  public String ablY;
  public String acbn;
  public String acbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32506);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ablY != null) {
        paramVarArgs.g(1, this.ablY);
      }
      if (this.acbn != null) {
        paramVarArgs.g(2, this.acbn);
      }
      if (this.IMh != null) {
        paramVarArgs.g(3, this.IMh);
      }
      if (this.IHW != null) {
        paramVarArgs.g(4, this.IHW);
      }
      if (this.acbo != null) {
        paramVarArgs.g(5, this.acbo);
      }
      AppMethodBeat.o(32506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ablY == null) {
        break label461;
      }
    }
    label461:
    for (int i = i.a.a.b.b.a.h(1, this.ablY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.acbn != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.acbn);
      }
      i = paramInt;
      if (this.IMh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IMh);
      }
      paramInt = i;
      if (this.IHW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IHW);
      }
      i = paramInt;
      if (this.acbo != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.acbo);
      }
      AppMethodBeat.o(32506);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32506);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gdg localgdg = (gdg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32506);
          return -1;
        case 1: 
          localgdg.ablY = locala.ajGk.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 2: 
          localgdg.acbn = locala.ajGk.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 3: 
          localgdg.IMh = locala.ajGk.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 4: 
          localgdg.IHW = locala.ajGk.readString();
          AppMethodBeat.o(32506);
          return 0;
        }
        localgdg.acbo = locala.ajGk.readString();
        AppMethodBeat.o(32506);
        return 0;
      }
      AppMethodBeat.o(32506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdg
 * JD-Core Version:    0.7.0.1
 */