package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class auh
  extends com.tencent.mm.bw.a
{
  public int GLd = 7;
  public long GLe = 0L;
  public int GLf = 0;
  public String GLg = "";
  public boolean GLh = false;
  public int aHQ = 0;
  public int iqb = 0;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GLd);
      paramVarArgs.aZ(2, this.GLe);
      paramVarArgs.aS(3, this.GLf);
      if (this.GLg != null) {
        paramVarArgs.d(4, this.GLg);
      }
      paramVarArgs.aS(5, this.aHQ);
      paramVarArgs.aS(6, this.iqb);
      paramVarArgs.bC(7, this.GLh);
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GLd) + 0 + f.a.a.b.b.a.p(2, this.GLe) + f.a.a.b.b.a.bz(3, this.GLf);
      paramInt = i;
      if (this.GLg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GLg);
      }
      i = f.a.a.b.b.a.bz(5, this.aHQ);
      int j = f.a.a.b.b.a.bz(6, this.iqb);
      int k = f.a.a.b.b.a.amF(7);
      AppMethodBeat.o(122494);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      auh localauh = (auh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122494);
        return -1;
      case 1: 
        localauh.GLd = locala.OmT.zc();
        AppMethodBeat.o(122494);
        return 0;
      case 2: 
        localauh.GLe = locala.OmT.zd();
        AppMethodBeat.o(122494);
        return 0;
      case 3: 
        localauh.GLf = locala.OmT.zc();
        AppMethodBeat.o(122494);
        return 0;
      case 4: 
        localauh.GLg = locala.OmT.readString();
        AppMethodBeat.o(122494);
        return 0;
      case 5: 
        localauh.aHQ = locala.OmT.zc();
        AppMethodBeat.o(122494);
        return 0;
      case 6: 
        localauh.iqb = locala.OmT.zc();
        AppMethodBeat.o(122494);
        return 0;
      }
      localauh.GLh = locala.OmT.gvY();
      AppMethodBeat.o(122494);
      return 0;
    }
    AppMethodBeat.o(122494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auh
 * JD-Core Version:    0.7.0.1
 */