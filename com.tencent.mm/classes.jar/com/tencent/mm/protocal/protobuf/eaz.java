package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class eaz
  extends com.tencent.mm.bw.a
{
  public b Gwe;
  public int HJB;
  public int IgH;
  public int ape;
  public String category;
  public int iqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147790);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.iqb);
      paramVarArgs.aS(2, this.ape);
      if (this.category != null) {
        paramVarArgs.d(3, this.category);
      }
      if (this.Gwe != null) {
        paramVarArgs.c(4, this.Gwe);
      }
      paramVarArgs.aS(5, this.HJB);
      paramVarArgs.aS(6, this.IgH);
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.iqb) + 0 + f.a.a.b.b.a.bz(2, this.ape);
      paramInt = i;
      if (this.category != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.category);
      }
      i = paramInt;
      if (this.Gwe != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.Gwe);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.HJB);
      int j = f.a.a.b.b.a.bz(6, this.IgH);
      AppMethodBeat.o(147790);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eaz localeaz = (eaz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147790);
        return -1;
      case 1: 
        localeaz.iqb = locala.OmT.zc();
        AppMethodBeat.o(147790);
        return 0;
      case 2: 
        localeaz.ape = locala.OmT.zc();
        AppMethodBeat.o(147790);
        return 0;
      case 3: 
        localeaz.category = locala.OmT.readString();
        AppMethodBeat.o(147790);
        return 0;
      case 4: 
        localeaz.Gwe = locala.OmT.gCk();
        AppMethodBeat.o(147790);
        return 0;
      case 5: 
        localeaz.HJB = locala.OmT.zc();
        AppMethodBeat.o(147790);
        return 0;
      }
      localeaz.IgH = locala.OmT.zc();
      AppMethodBeat.o(147790);
      return 0;
    }
    AppMethodBeat.o(147790);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaz
 * JD-Core Version:    0.7.0.1
 */