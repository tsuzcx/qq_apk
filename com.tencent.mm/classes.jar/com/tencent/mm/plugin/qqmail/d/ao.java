package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
  extends com.tencent.mm.bw.a
{
  public String md5;
  public String name;
  public int size;
  public long uin;
  public String xsY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217977);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.uin);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      paramVarArgs.aS(3, this.size);
      if (this.xsY != null) {
        paramVarArgs.d(4, this.xsY);
      }
      if (this.md5 != null) {
        paramVarArgs.d(5, this.md5);
      }
      AppMethodBeat.o(217977);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.uin) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.size);
      paramInt = i;
      if (this.xsY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xsY);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.md5);
      }
      AppMethodBeat.o(217977);
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
      AppMethodBeat.o(217977);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ao localao = (ao)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(217977);
        return -1;
      case 1: 
        localao.uin = locala.OmT.zd();
        AppMethodBeat.o(217977);
        return 0;
      case 2: 
        localao.name = locala.OmT.readString();
        AppMethodBeat.o(217977);
        return 0;
      case 3: 
        localao.size = locala.OmT.zc();
        AppMethodBeat.o(217977);
        return 0;
      case 4: 
        localao.xsY = locala.OmT.readString();
        AppMethodBeat.o(217977);
        return 0;
      }
      localao.md5 = locala.OmT.readString();
      AppMethodBeat.o(217977);
      return 0;
    }
    AppMethodBeat.o(217977);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ao
 * JD-Core Version:    0.7.0.1
 */