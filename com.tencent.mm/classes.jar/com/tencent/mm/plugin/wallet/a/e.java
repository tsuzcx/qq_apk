package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends com.tencent.mm.bw.a
{
  public String HEm;
  public String name;
  public String url;
  public String weappPath;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91289);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.HEm != null) {
        paramVarArgs.e(3, this.HEm);
      }
      if (this.weappPath != null) {
        paramVarArgs.e(4, this.weappPath);
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
    for (int i = g.a.a.b.b.a.f(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.HEm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.HEm);
      }
      paramInt = i;
      if (this.weappPath != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.weappPath);
      }
      AppMethodBeat.o(91289);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91289);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91289);
          return -1;
        case 1: 
          locale.url = locala.UbS.readString();
          AppMethodBeat.o(91289);
          return 0;
        case 2: 
          locale.name = locala.UbS.readString();
          AppMethodBeat.o(91289);
          return 0;
        case 3: 
          locale.HEm = locala.UbS.readString();
          AppMethodBeat.o(91289);
          return 0;
        }
        locale.weappPath = locala.UbS.readString();
        AppMethodBeat.o(91289);
        return 0;
      }
      AppMethodBeat.o(91289);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.e
 * JD-Core Version:    0.7.0.1
 */