package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.bw.a
{
  public String CYy;
  public String hGk;
  public int id;
  public String name;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91302);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.id);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.CYy != null) {
        paramVarArgs.d(4, this.CYy);
      }
      if (this.hGk != null) {
        paramVarArgs.d(5, this.hGk);
      }
      AppMethodBeat.o(91302);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.CYy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CYy);
      }
      i = paramInt;
      if (this.hGk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hGk);
      }
      AppMethodBeat.o(91302);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91302);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      p localp = (p)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91302);
        return -1;
      case 1: 
        localp.id = locala.OmT.zc();
        AppMethodBeat.o(91302);
        return 0;
      case 2: 
        localp.name = locala.OmT.readString();
        AppMethodBeat.o(91302);
        return 0;
      case 3: 
        localp.url = locala.OmT.readString();
        AppMethodBeat.o(91302);
        return 0;
      case 4: 
        localp.CYy = locala.OmT.readString();
        AppMethodBeat.o(91302);
        return 0;
      }
      localp.hGk = locala.OmT.readString();
      AppMethodBeat.o(91302);
      return 0;
    }
    AppMethodBeat.o(91302);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.p
 * JD-Core Version:    0.7.0.1
 */