package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.bw.a
{
  public String HEm;
  public int id;
  public String name;
  public String url;
  public String weappPath;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91302);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.id);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      if (this.HEm != null) {
        paramVarArgs.e(4, this.HEm);
      }
      if (this.weappPath != null) {
        paramVarArgs.e(5, this.weappPath);
      }
      AppMethodBeat.o(91302);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.url);
      }
      paramInt = i;
      if (this.HEm != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.HEm);
      }
      i = paramInt;
      if (this.weappPath != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.weappPath);
      }
      AppMethodBeat.o(91302);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91302);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      p localp = (p)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91302);
        return -1;
      case 1: 
        localp.id = locala.UbS.zi();
        AppMethodBeat.o(91302);
        return 0;
      case 2: 
        localp.name = locala.UbS.readString();
        AppMethodBeat.o(91302);
        return 0;
      case 3: 
        localp.url = locala.UbS.readString();
        AppMethodBeat.o(91302);
        return 0;
      case 4: 
        localp.HEm = locala.UbS.readString();
        AppMethodBeat.o(91302);
        return 0;
      }
      localp.weappPath = locala.UbS.readString();
      AppMethodBeat.o(91302);
      return 0;
    }
    AppMethodBeat.o(91302);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.p
 * JD-Core Version:    0.7.0.1
 */