package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ehn
  extends com.tencent.mm.bx.a
{
  public String ZNU;
  public String ablC;
  public b abmJ;
  public String image;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258979);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.image != null) {
        paramVarArgs.g(2, this.image);
      }
      if (this.ZNU != null) {
        paramVarArgs.g(3, this.ZNU);
      }
      if (this.abmJ != null) {
        paramVarArgs.d(4, this.abmJ);
      }
      if (this.ablC != null) {
        paramVarArgs.g(5, this.ablC);
      }
      AppMethodBeat.o(258979);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.image != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.image);
      }
      i = paramInt;
      if (this.ZNU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZNU);
      }
      paramInt = i;
      if (this.abmJ != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.abmJ);
      }
      i = paramInt;
      if (this.ablC != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ablC);
      }
      AppMethodBeat.o(258979);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258979);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ehn localehn = (ehn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258979);
          return -1;
        case 1: 
          localehn.title = locala.ajGk.readString();
          AppMethodBeat.o(258979);
          return 0;
        case 2: 
          localehn.image = locala.ajGk.readString();
          AppMethodBeat.o(258979);
          return 0;
        case 3: 
          localehn.ZNU = locala.ajGk.readString();
          AppMethodBeat.o(258979);
          return 0;
        case 4: 
          localehn.abmJ = locala.ajGk.kFX();
          AppMethodBeat.o(258979);
          return 0;
        }
        localehn.ablC = locala.ajGk.readString();
        AppMethodBeat.o(258979);
        return 0;
      }
      AppMethodBeat.o(258979);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehn
 * JD-Core Version:    0.7.0.1
 */