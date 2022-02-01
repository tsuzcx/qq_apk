package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pr
  extends com.tencent.mm.bx.a
{
  public String Afa;
  public String Aox;
  public String COa;
  public String COb;
  public int Cwa;
  public String dub;
  public String title;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91383);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.Aox != null) {
        paramVarArgs.d(2, this.Aox);
      }
      if (this.dub != null) {
        paramVarArgs.d(3, this.dub);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.Afa != null) {
        paramVarArgs.d(5, this.Afa);
      }
      if (this.url != null) {
        paramVarArgs.d(6, this.url);
      }
      if (this.COa != null) {
        paramVarArgs.d(7, this.COa);
      }
      if (this.COb != null) {
        paramVarArgs.d(8, this.COb);
      }
      paramVarArgs.aR(9, this.Cwa);
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.Aox != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Aox);
      }
      i = paramInt;
      if (this.dub != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dub);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt;
      if (this.Afa != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Afa);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.url);
      }
      i = paramInt;
      if (this.COa != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.COa);
      }
      paramInt = i;
      if (this.COb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.COb);
      }
      i = f.a.a.b.b.a.bA(9, this.Cwa);
      AppMethodBeat.o(91383);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      pr localpr = (pr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91383);
        return -1;
      case 1: 
        localpr.type = locala.KhF.xS();
        AppMethodBeat.o(91383);
        return 0;
      case 2: 
        localpr.Aox = locala.KhF.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 3: 
        localpr.dub = locala.KhF.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 4: 
        localpr.title = locala.KhF.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 5: 
        localpr.Afa = locala.KhF.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 6: 
        localpr.url = locala.KhF.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 7: 
        localpr.COa = locala.KhF.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 8: 
        localpr.COb = locala.KhF.readString();
        AppMethodBeat.o(91383);
        return 0;
      }
      localpr.Cwa = locala.KhF.xS();
      AppMethodBeat.o(91383);
      return 0;
    }
    AppMethodBeat.o(91383);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pr
 * JD-Core Version:    0.7.0.1
 */