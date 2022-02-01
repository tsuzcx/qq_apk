package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvp
  extends com.tencent.mm.bw.a
{
  public String Hiq;
  public String Hir;
  public int His;
  public int Hit;
  public long Hiu;
  public long Hiv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215587);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hiq != null) {
        paramVarArgs.d(1, this.Hiq);
      }
      if (this.Hir != null) {
        paramVarArgs.d(2, this.Hir);
      }
      paramVarArgs.aS(3, this.His);
      paramVarArgs.aS(4, this.Hit);
      paramVarArgs.aZ(5, this.Hiu);
      paramVarArgs.aZ(6, this.Hiv);
      AppMethodBeat.o(215587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hiq == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hiq) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hir != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hir);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.His);
      int j = f.a.a.b.b.a.bz(4, this.Hit);
      int k = f.a.a.b.b.a.p(5, this.Hiu);
      int m = f.a.a.b.b.a.p(6, this.Hiv);
      AppMethodBeat.o(215587);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(215587);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvp localbvp = (bvp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(215587);
          return -1;
        case 1: 
          localbvp.Hiq = locala.OmT.readString();
          AppMethodBeat.o(215587);
          return 0;
        case 2: 
          localbvp.Hir = locala.OmT.readString();
          AppMethodBeat.o(215587);
          return 0;
        case 3: 
          localbvp.His = locala.OmT.zc();
          AppMethodBeat.o(215587);
          return 0;
        case 4: 
          localbvp.Hit = locala.OmT.zc();
          AppMethodBeat.o(215587);
          return 0;
        case 5: 
          localbvp.Hiu = locala.OmT.zd();
          AppMethodBeat.o(215587);
          return 0;
        }
        localbvp.Hiv = locala.OmT.zd();
        AppMethodBeat.o(215587);
        return 0;
      }
      AppMethodBeat.o(215587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvp
 * JD-Core Version:    0.7.0.1
 */