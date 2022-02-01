package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.bx.a
{
  public String gKJ;
  public int id;
  public String name;
  public String url;
  public String zOk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91302);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.id);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.zOk != null) {
        paramVarArgs.d(4, this.zOk);
      }
      if (this.gKJ != null) {
        paramVarArgs.d(5, this.gKJ);
      }
      AppMethodBeat.o(91302);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.zOk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.zOk);
      }
      i = paramInt;
      if (this.gKJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.gKJ);
      }
      AppMethodBeat.o(91302);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localp.id = locala.KhF.xS();
        AppMethodBeat.o(91302);
        return 0;
      case 2: 
        localp.name = locala.KhF.readString();
        AppMethodBeat.o(91302);
        return 0;
      case 3: 
        localp.url = locala.KhF.readString();
        AppMethodBeat.o(91302);
        return 0;
      case 4: 
        localp.zOk = locala.KhF.readString();
        AppMethodBeat.o(91302);
        return 0;
      }
      localp.gKJ = locala.KhF.readString();
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