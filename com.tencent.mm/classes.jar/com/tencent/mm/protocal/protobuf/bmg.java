package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmg
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String GGH;
  public String GGI;
  public String IconUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152610);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GGH != null) {
        paramVarArgs.d(1, this.GGH);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.GGI != null) {
        paramVarArgs.d(5, this.GGI);
      }
      AppMethodBeat.o(152610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GGH == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.GGH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.GGI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GGI);
      }
      AppMethodBeat.o(152610);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152610);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bmg localbmg = (bmg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152610);
          return -1;
        case 1: 
          localbmg.GGH = locala.NPN.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 2: 
          localbmg.IconUrl = locala.NPN.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 3: 
          localbmg.Title = locala.NPN.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 4: 
          localbmg.Desc = locala.NPN.readString();
          AppMethodBeat.o(152610);
          return 0;
        }
        localbmg.GGI = locala.NPN.readString();
        AppMethodBeat.o(152610);
        return 0;
      }
      AppMethodBeat.o(152610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmg
 * JD-Core Version:    0.7.0.1
 */