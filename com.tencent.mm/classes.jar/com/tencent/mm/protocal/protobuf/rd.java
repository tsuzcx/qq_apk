package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rd
  extends com.tencent.mm.bx.a
{
  public String CXN;
  public String Dhj;
  public String FNb;
  public String FNc;
  public int FtC;
  public String dDH;
  public String title;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91383);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.Dhj != null) {
        paramVarArgs.d(2, this.Dhj);
      }
      if (this.dDH != null) {
        paramVarArgs.d(3, this.dDH);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.CXN != null) {
        paramVarArgs.d(5, this.CXN);
      }
      if (this.url != null) {
        paramVarArgs.d(6, this.url);
      }
      if (this.FNb != null) {
        paramVarArgs.d(7, this.FNb);
      }
      if (this.FNc != null) {
        paramVarArgs.d(8, this.FNc);
      }
      paramVarArgs.aS(9, this.FtC);
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.Dhj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dhj);
      }
      i = paramInt;
      if (this.dDH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dDH);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt;
      if (this.CXN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CXN);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.url);
      }
      i = paramInt;
      if (this.FNb != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FNb);
      }
      paramInt = i;
      if (this.FNc != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FNc);
      }
      i = f.a.a.b.b.a.bz(9, this.FtC);
      AppMethodBeat.o(91383);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      rd localrd = (rd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91383);
        return -1;
      case 1: 
        localrd.type = locala.NPN.zc();
        AppMethodBeat.o(91383);
        return 0;
      case 2: 
        localrd.Dhj = locala.NPN.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 3: 
        localrd.dDH = locala.NPN.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 4: 
        localrd.title = locala.NPN.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 5: 
        localrd.CXN = locala.NPN.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 6: 
        localrd.url = locala.NPN.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 7: 
        localrd.FNb = locala.NPN.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 8: 
        localrd.FNc = locala.NPN.readString();
        AppMethodBeat.o(91383);
        return 0;
      }
      localrd.FtC = locala.NPN.zc();
      AppMethodBeat.o(91383);
      return 0;
    }
    AppMethodBeat.o(91383);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rd
 * JD-Core Version:    0.7.0.1
 */