package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class are
  extends com.tencent.mm.bx.a
{
  public String YQV;
  public String ZaN;
  public int ZaO;
  public String Ziv;
  public String Ziw;
  public String Zix;
  public int Ziy;
  public String Zyx;
  public int Zyy;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127456);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Ziv != null) {
        paramVarArgs.g(1, this.Ziv);
      }
      if (this.Ziw != null) {
        paramVarArgs.g(2, this.Ziw);
      }
      if (this.Zix != null) {
        paramVarArgs.g(3, this.Zix);
      }
      paramVarArgs.bS(4, this.Ziy);
      if (this.Zyx != null) {
        paramVarArgs.g(5, this.Zyx);
      }
      if (this.ZaN != null) {
        paramVarArgs.g(6, this.ZaN);
      }
      paramVarArgs.bS(7, this.ZaO);
      if (this.YQV != null) {
        paramVarArgs.g(8, this.YQV);
      }
      paramVarArgs.bS(9, this.vhk);
      paramVarArgs.bS(10, this.Zyy);
      AppMethodBeat.o(127456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ziv == null) {
        break label698;
      }
    }
    label698:
    for (int i = i.a.a.b.b.a.h(1, this.Ziv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ziw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Ziw);
      }
      i = paramInt;
      if (this.Zix != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zix);
      }
      i += i.a.a.b.b.a.cJ(4, this.Ziy);
      paramInt = i;
      if (this.Zyx != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Zyx);
      }
      i = paramInt;
      if (this.ZaN != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZaN);
      }
      i += i.a.a.b.b.a.cJ(7, this.ZaO);
      paramInt = i;
      if (this.YQV != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YQV);
      }
      i = i.a.a.b.b.a.cJ(9, this.vhk);
      int j = i.a.a.b.b.a.cJ(10, this.Zyy);
      AppMethodBeat.o(127456);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127456);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        are localare = (are)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127456);
          return -1;
        case 1: 
          localare.Ziv = locala.ajGk.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 2: 
          localare.Ziw = locala.ajGk.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 3: 
          localare.Zix = locala.ajGk.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 4: 
          localare.Ziy = locala.ajGk.aar();
          AppMethodBeat.o(127456);
          return 0;
        case 5: 
          localare.Zyx = locala.ajGk.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 6: 
          localare.ZaN = locala.ajGk.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 7: 
          localare.ZaO = locala.ajGk.aar();
          AppMethodBeat.o(127456);
          return 0;
        case 8: 
          localare.YQV = locala.ajGk.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 9: 
          localare.vhk = locala.ajGk.aar();
          AppMethodBeat.o(127456);
          return 0;
        }
        localare.Zyy = locala.ajGk.aar();
        AppMethodBeat.o(127456);
        return 0;
      }
      AppMethodBeat.o(127456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.are
 * JD-Core Version:    0.7.0.1
 */