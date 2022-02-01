package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class w
  extends com.tencent.mm.bw.a
{
  public int dMI;
  public String hTy;
  public int id;
  public int status;
  public String xHs;
  public b xHt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(27828);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.id);
      paramVarArgs.aS(2, this.status);
      if (this.xHs != null) {
        paramVarArgs.d(3, this.xHs);
      }
      if (this.hTy != null) {
        paramVarArgs.d(4, this.hTy);
      }
      if (this.xHt != null) {
        paramVarArgs.c(5, this.xHt);
      }
      paramVarArgs.aS(6, this.dMI);
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.id) + 0 + f.a.a.b.b.a.bz(2, this.status);
      paramInt = i;
      if (this.xHs != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.xHs);
      }
      i = paramInt;
      if (this.hTy != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.hTy);
      }
      paramInt = i;
      if (this.xHt != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.xHt);
      }
      i = f.a.a.b.b.a.bz(6, this.dMI);
      AppMethodBeat.o(27828);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(27828);
        return -1;
      case 1: 
        localw.id = locala.OmT.zc();
        AppMethodBeat.o(27828);
        return 0;
      case 2: 
        localw.status = locala.OmT.zc();
        AppMethodBeat.o(27828);
        return 0;
      case 3: 
        localw.xHs = locala.OmT.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 4: 
        localw.hTy = locala.OmT.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 5: 
        localw.xHt = locala.OmT.gCk();
        AppMethodBeat.o(27828);
        return 0;
      }
      localw.dMI = locala.OmT.zc();
      AppMethodBeat.o(27828);
      return 0;
    }
    AppMethodBeat.o(27828);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.w
 * JD-Core Version:    0.7.0.1
 */