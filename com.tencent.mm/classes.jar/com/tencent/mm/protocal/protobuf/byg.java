package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byg
  extends com.tencent.mm.bw.a
{
  public boolean Hla;
  public boolean Hlb;
  public int Hlc;
  public String Hld;
  public boolean Hle;
  public boolean Hlf;
  public String Hlg;
  public String dwb;
  public int sVm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.Hla);
      paramVarArgs.bC(2, this.Hlb);
      paramVarArgs.aS(3, this.sVm);
      paramVarArgs.aS(4, this.Hlc);
      if (this.Hld != null) {
        paramVarArgs.d(5, this.Hld);
      }
      paramVarArgs.bC(6, this.Hle);
      if (this.dwb != null) {
        paramVarArgs.d(7, this.dwb);
      }
      paramVarArgs.bC(8, this.Hlf);
      if (this.Hlg != null) {
        paramVarArgs.d(9, this.Hlg);
      }
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0 + f.a.a.b.b.a.amF(2) + f.a.a.b.b.a.bz(3, this.sVm) + f.a.a.b.b.a.bz(4, this.Hlc);
      paramInt = i;
      if (this.Hld != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hld);
      }
      i = paramInt + f.a.a.b.b.a.amF(6);
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dwb);
      }
      i = paramInt + f.a.a.b.b.a.amF(8);
      paramInt = i;
      if (this.Hlg != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hlg);
      }
      AppMethodBeat.o(127172);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byg localbyg = (byg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127172);
        return -1;
      case 1: 
        localbyg.Hla = locala.OmT.gvY();
        AppMethodBeat.o(127172);
        return 0;
      case 2: 
        localbyg.Hlb = locala.OmT.gvY();
        AppMethodBeat.o(127172);
        return 0;
      case 3: 
        localbyg.sVm = locala.OmT.zc();
        AppMethodBeat.o(127172);
        return 0;
      case 4: 
        localbyg.Hlc = locala.OmT.zc();
        AppMethodBeat.o(127172);
        return 0;
      case 5: 
        localbyg.Hld = locala.OmT.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 6: 
        localbyg.Hle = locala.OmT.gvY();
        AppMethodBeat.o(127172);
        return 0;
      case 7: 
        localbyg.dwb = locala.OmT.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 8: 
        localbyg.Hlf = locala.OmT.gvY();
        AppMethodBeat.o(127172);
        return 0;
      }
      localbyg.Hlg = locala.OmT.readString();
      AppMethodBeat.o(127172);
      return 0;
    }
    AppMethodBeat.o(127172);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byg
 * JD-Core Version:    0.7.0.1
 */