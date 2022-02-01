package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drz
  extends com.tencent.mm.bw.a
{
  public String HeadUrl;
  public String MUC;
  public String MUD;
  public String Title;
  public String UserName;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187880);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.HeadUrl != null) {
        paramVarArgs.e(3, this.HeadUrl);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(4, this.oUJ);
      }
      if (this.MUC != null) {
        paramVarArgs.e(5, this.MUC);
      }
      if (this.MUD != null) {
        paramVarArgs.e(6, this.MUD);
      }
      AppMethodBeat.o(187880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.HeadUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.HeadUrl);
      }
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.oUJ);
      }
      i = paramInt;
      if (this.MUC != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MUC);
      }
      paramInt = i;
      if (this.MUD != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MUD);
      }
      AppMethodBeat.o(187880);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(187880);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        drz localdrz = (drz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(187880);
          return -1;
        case 1: 
          localdrz.Title = locala.UbS.readString();
          AppMethodBeat.o(187880);
          return 0;
        case 2: 
          localdrz.UserName = locala.UbS.readString();
          AppMethodBeat.o(187880);
          return 0;
        case 3: 
          localdrz.HeadUrl = locala.UbS.readString();
          AppMethodBeat.o(187880);
          return 0;
        case 4: 
          localdrz.oUJ = locala.UbS.readString();
          AppMethodBeat.o(187880);
          return 0;
        case 5: 
          localdrz.MUC = locala.UbS.readString();
          AppMethodBeat.o(187880);
          return 0;
        }
        localdrz.MUD = locala.UbS.readString();
        AppMethodBeat.o(187880);
        return 0;
      }
      AppMethodBeat.o(187880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drz
 * JD-Core Version:    0.7.0.1
 */