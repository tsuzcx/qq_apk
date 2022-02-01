package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class eiv
  extends com.tencent.mm.bw.a
{
  public boolean IlU;
  public String Imc;
  public b Imd;
  public int Ime;
  public int Imf;
  public int Img;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50123);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.IlU);
      if (this.Imc != null) {
        paramVarArgs.d(2, this.Imc);
      }
      if (this.Imd != null) {
        paramVarArgs.c(3, this.Imd);
      }
      paramVarArgs.aS(4, this.Ime);
      paramVarArgs.aS(5, this.Imf);
      paramVarArgs.aS(6, this.Img);
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0;
      paramInt = i;
      if (this.Imc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Imc);
      }
      i = paramInt;
      if (this.Imd != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Imd);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Ime);
      int j = f.a.a.b.b.a.bz(5, this.Imf);
      int k = f.a.a.b.b.a.bz(6, this.Img);
      AppMethodBeat.o(50123);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eiv localeiv = (eiv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50123);
        return -1;
      case 1: 
        localeiv.IlU = locala.OmT.gvY();
        AppMethodBeat.o(50123);
        return 0;
      case 2: 
        localeiv.Imc = locala.OmT.readString();
        AppMethodBeat.o(50123);
        return 0;
      case 3: 
        localeiv.Imd = locala.OmT.gCk();
        AppMethodBeat.o(50123);
        return 0;
      case 4: 
        localeiv.Ime = locala.OmT.zc();
        AppMethodBeat.o(50123);
        return 0;
      case 5: 
        localeiv.Imf = locala.OmT.zc();
        AppMethodBeat.o(50123);
        return 0;
      }
      localeiv.Img = locala.OmT.zc();
      AppMethodBeat.o(50123);
      return 0;
    }
    AppMethodBeat.o(50123);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiv
 * JD-Core Version:    0.7.0.1
 */