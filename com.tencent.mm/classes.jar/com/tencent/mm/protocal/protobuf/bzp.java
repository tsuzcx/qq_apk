package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzp
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String IconUrl;
  public String Mfj;
  public String Mfk;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152610);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mfj != null) {
        paramVarArgs.e(1, this.Mfj);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(2, this.IconUrl);
      }
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      if (this.Mfk != null) {
        paramVarArgs.e(5, this.Mfk);
      }
      AppMethodBeat.o(152610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mfj == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.f(1, this.Mfj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.IconUrl);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Title);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.Mfk != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mfk);
      }
      AppMethodBeat.o(152610);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152610);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bzp localbzp = (bzp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152610);
          return -1;
        case 1: 
          localbzp.Mfj = locala.UbS.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 2: 
          localbzp.IconUrl = locala.UbS.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 3: 
          localbzp.Title = locala.UbS.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 4: 
          localbzp.Desc = locala.UbS.readString();
          AppMethodBeat.o(152610);
          return 0;
        }
        localbzp.Mfk = locala.UbS.readString();
        AppMethodBeat.o(152610);
        return 0;
      }
      AppMethodBeat.o(152610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzp
 * JD-Core Version:    0.7.0.1
 */