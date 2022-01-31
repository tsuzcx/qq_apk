package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atf
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String IconUrl;
  public String Title;
  public String xix;
  public String xiy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80105);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xix != null) {
        paramVarArgs.e(1, this.xix);
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
      if (this.xiy != null) {
        paramVarArgs.e(5, this.xiy);
      }
      AppMethodBeat.o(80105);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xix == null) {
        break label454;
      }
    }
    label454:
    for (int i = e.a.a.b.b.a.f(1, this.xix) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.IconUrl);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Title);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.xiy != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xiy);
      }
      AppMethodBeat.o(80105);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80105);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        atf localatf = (atf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80105);
          return -1;
        case 1: 
          localatf.xix = locala.CLY.readString();
          AppMethodBeat.o(80105);
          return 0;
        case 2: 
          localatf.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(80105);
          return 0;
        case 3: 
          localatf.Title = locala.CLY.readString();
          AppMethodBeat.o(80105);
          return 0;
        case 4: 
          localatf.Desc = locala.CLY.readString();
          AppMethodBeat.o(80105);
          return 0;
        }
        localatf.xiy = locala.CLY.readString();
        AppMethodBeat.o(80105);
        return 0;
      }
      AppMethodBeat.o(80105);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atf
 * JD-Core Version:    0.7.0.1
 */