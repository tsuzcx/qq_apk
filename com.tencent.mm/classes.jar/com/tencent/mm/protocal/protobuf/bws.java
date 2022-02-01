package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bws
  extends com.tencent.mm.bw.a
{
  public int KCD;
  public String LRh;
  public int Mcw;
  public String Mcx;
  public String Mcy;
  public int Ret;
  public String Title;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152608);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ret);
      if (this.LRh != null) {
        paramVarArgs.e(2, this.LRh);
      }
      paramVarArgs.aM(3, this.KCD);
      paramVarArgs.aM(4, this.Mcw);
      if (this.Title != null) {
        paramVarArgs.e(5, this.Title);
      }
      if (this.UserName != null) {
        paramVarArgs.e(6, this.UserName);
      }
      if (this.Mcx != null) {
        paramVarArgs.e(7, this.Mcx);
      }
      if (this.Mcy != null) {
        paramVarArgs.e(8, this.Mcy);
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Ret) + 0;
      paramInt = i;
      if (this.LRh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LRh);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.KCD) + g.a.a.b.b.a.bu(4, this.Mcw);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Title);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.UserName);
      }
      paramInt = i;
      if (this.Mcx != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Mcx);
      }
      i = paramInt;
      if (this.Mcy != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Mcy);
      }
      AppMethodBeat.o(152608);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bws localbws = (bws)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152608);
        return -1;
      case 1: 
        localbws.Ret = locala.UbS.zi();
        AppMethodBeat.o(152608);
        return 0;
      case 2: 
        localbws.LRh = locala.UbS.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 3: 
        localbws.KCD = locala.UbS.zi();
        AppMethodBeat.o(152608);
        return 0;
      case 4: 
        localbws.Mcw = locala.UbS.zi();
        AppMethodBeat.o(152608);
        return 0;
      case 5: 
        localbws.Title = locala.UbS.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 6: 
        localbws.UserName = locala.UbS.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 7: 
        localbws.Mcx = locala.UbS.readString();
        AppMethodBeat.o(152608);
        return 0;
      }
      localbws.Mcy = locala.UbS.readString();
      AppMethodBeat.o(152608);
      return 0;
    }
    AppMethodBeat.o(152608);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bws
 * JD-Core Version:    0.7.0.1
 */