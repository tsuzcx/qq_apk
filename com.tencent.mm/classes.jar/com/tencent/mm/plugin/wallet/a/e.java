package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends com.tencent.mm.bw.a
{
  public String CYy;
  public String hGk;
  public String name;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91289);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.CYy != null) {
        paramVarArgs.d(3, this.CYy);
      }
      if (this.hGk != null) {
        paramVarArgs.d(4, this.hGk);
      }
      AppMethodBeat.o(91289);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.CYy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CYy);
      }
      paramInt = i;
      if (this.hGk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hGk);
      }
      AppMethodBeat.o(91289);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91289);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91289);
          return -1;
        case 1: 
          locale.url = locala.OmT.readString();
          AppMethodBeat.o(91289);
          return 0;
        case 2: 
          locale.name = locala.OmT.readString();
          AppMethodBeat.o(91289);
          return 0;
        case 3: 
          locale.CYy = locala.OmT.readString();
          AppMethodBeat.o(91289);
          return 0;
        }
        locale.hGk = locala.OmT.readString();
        AppMethodBeat.o(91289);
        return 0;
      }
      AppMethodBeat.o(91289);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.e
 * JD-Core Version:    0.7.0.1
 */