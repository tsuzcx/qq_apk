package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ell
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String Zui;
  public String Zyp;
  public String aant;
  public int abpV;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127295);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      paramVarArgs.bS(2, this.abpV);
      if (this.vhX != null) {
        paramVarArgs.g(3, this.vhX);
      }
      if (this.Zui != null) {
        paramVarArgs.g(4, this.Zui);
      }
      if (this.Zyp != null) {
        paramVarArgs.g(5, this.Zyp);
      }
      if (this.aant != null) {
        paramVarArgs.g(6, this.aant);
      }
      AppMethodBeat.o(127295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abpV);
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.vhX);
      }
      i = paramInt;
      if (this.Zui != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Zui);
      }
      paramInt = i;
      if (this.Zyp != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Zyp);
      }
      i = paramInt;
      if (this.aant != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aant);
      }
      AppMethodBeat.o(127295);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127295);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ell localell = (ell)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127295);
          return -1;
        case 1: 
          localell.UserName = locala.ajGk.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 2: 
          localell.abpV = locala.ajGk.aar();
          AppMethodBeat.o(127295);
          return 0;
        case 3: 
          localell.vhX = locala.ajGk.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 4: 
          localell.Zui = locala.ajGk.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 5: 
          localell.Zyp = locala.ajGk.readString();
          AppMethodBeat.o(127295);
          return 0;
        }
        localell.aant = locala.ajGk.readString();
        AppMethodBeat.o(127295);
        return 0;
      }
      AppMethodBeat.o(127295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ell
 * JD-Core Version:    0.7.0.1
 */