package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boy
  extends com.tencent.mm.bw.a
{
  public String FOR;
  public int GSm;
  public long Hcu;
  public String ikN;
  public String nIJ;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209902);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.xrk);
      paramVarArgs.aZ(2, this.Hcu);
      if (this.ikN != null) {
        paramVarArgs.d(3, this.ikN);
      }
      paramVarArgs.aS(4, this.GSm);
      if (this.nIJ != null) {
        paramVarArgs.d(5, this.nIJ);
      }
      if (this.FOR != null) {
        paramVarArgs.d(6, this.FOR);
      }
      AppMethodBeat.o(209902);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.xrk) + 0 + f.a.a.b.b.a.p(2, this.Hcu);
      paramInt = i;
      if (this.ikN != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ikN);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GSm);
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.nIJ);
      }
      i = paramInt;
      if (this.FOR != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FOR);
      }
      AppMethodBeat.o(209902);
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
      AppMethodBeat.o(209902);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      boy localboy = (boy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209902);
        return -1;
      case 1: 
        localboy.xrk = locala.OmT.zd();
        AppMethodBeat.o(209902);
        return 0;
      case 2: 
        localboy.Hcu = locala.OmT.zd();
        AppMethodBeat.o(209902);
        return 0;
      case 3: 
        localboy.ikN = locala.OmT.readString();
        AppMethodBeat.o(209902);
        return 0;
      case 4: 
        localboy.GSm = locala.OmT.zc();
        AppMethodBeat.o(209902);
        return 0;
      case 5: 
        localboy.nIJ = locala.OmT.readString();
        AppMethodBeat.o(209902);
        return 0;
      }
      localboy.FOR = locala.OmT.readString();
      AppMethodBeat.o(209902);
      return 0;
    }
    AppMethodBeat.o(209902);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boy
 * JD-Core Version:    0.7.0.1
 */