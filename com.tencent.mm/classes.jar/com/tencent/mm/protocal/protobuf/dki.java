package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dki
  extends com.tencent.mm.bx.a
{
  public int Gje;
  public String hCe;
  public String hCg;
  public String hCh;
  public String hCi;
  public String hCj;
  public String hCk;
  public String hCl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hCe != null) {
        paramVarArgs.d(1, this.hCe);
      }
      paramVarArgs.aS(2, this.Gje);
      if (this.hCh != null) {
        paramVarArgs.d(3, this.hCh);
      }
      if (this.hCi != null) {
        paramVarArgs.d(4, this.hCi);
      }
      if (this.hCg != null) {
        paramVarArgs.d(5, this.hCg);
      }
      if (this.hCj != null) {
        paramVarArgs.d(6, this.hCj);
      }
      if (this.hCk != null) {
        paramVarArgs.d(7, this.hCk);
      }
      if (this.hCl != null) {
        paramVarArgs.d(8, this.hCl);
      }
      AppMethodBeat.o(127178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hCe == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.hCe) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gje);
      paramInt = i;
      if (this.hCh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.hCh);
      }
      i = paramInt;
      if (this.hCi != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.hCi);
      }
      paramInt = i;
      if (this.hCg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hCg);
      }
      i = paramInt;
      if (this.hCj != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hCj);
      }
      paramInt = i;
      if (this.hCk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hCk);
      }
      i = paramInt;
      if (this.hCl != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.hCl);
      }
      AppMethodBeat.o(127178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127178);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dki localdki = (dki)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127178);
          return -1;
        case 1: 
          localdki.hCe = locala.NPN.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 2: 
          localdki.Gje = locala.NPN.zc();
          AppMethodBeat.o(127178);
          return 0;
        case 3: 
          localdki.hCh = locala.NPN.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 4: 
          localdki.hCi = locala.NPN.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 5: 
          localdki.hCg = locala.NPN.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 6: 
          localdki.hCj = locala.NPN.readString();
          AppMethodBeat.o(127178);
          return 0;
        case 7: 
          localdki.hCk = locala.NPN.readString();
          AppMethodBeat.o(127178);
          return 0;
        }
        localdki.hCl = locala.NPN.readString();
        AppMethodBeat.o(127178);
        return 0;
      }
      AppMethodBeat.o(127178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dki
 * JD-Core Version:    0.7.0.1
 */