package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxa
  extends com.tencent.mm.bw.a
{
  public long DUA;
  public long DUK;
  public String FDc;
  public boolean GdJ;
  public com.tencent.mm.bw.b GdK;
  public String Nickname;
  public String hkR;
  public int tit;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Nickname == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.hkR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.FDc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.DUK);
      if (this.Nickname != null) {
        paramVarArgs.d(2, this.Nickname);
      }
      if (this.hkR != null) {
        paramVarArgs.d(3, this.hkR);
      }
      paramVarArgs.aR(4, this.tit);
      if (this.FDc != null) {
        paramVarArgs.d(5, this.FDc);
      }
      paramVarArgs.aO(6, this.DUA);
      paramVarArgs.bl(7, this.GdJ);
      if (this.GdK != null) {
        paramVarArgs.c(8, this.GdK);
      }
      AppMethodBeat.o(32539);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.DUK) + 0;
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Nickname);
      }
      i = paramInt;
      if (this.hkR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hkR);
      }
      i += f.a.a.b.b.a.bx(4, this.tit);
      paramInt = i;
      if (this.FDc != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FDc);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.DUA) + (f.a.a.b.b.a.fK(7) + 1);
      paramInt = i;
      if (this.GdK != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.GdK);
      }
      AppMethodBeat.o(32539);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.Nickname == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.hkR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.FDc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32539);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dxa localdxa = (dxa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32539);
        return -1;
      case 1: 
        localdxa.DUK = locala.LVo.xG();
        AppMethodBeat.o(32539);
        return 0;
      case 2: 
        localdxa.Nickname = locala.LVo.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 3: 
        localdxa.hkR = locala.LVo.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 4: 
        localdxa.tit = locala.LVo.xF();
        AppMethodBeat.o(32539);
        return 0;
      case 5: 
        localdxa.FDc = locala.LVo.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 6: 
        localdxa.DUA = locala.LVo.xG();
        AppMethodBeat.o(32539);
        return 0;
      case 7: 
        localdxa.GdJ = locala.LVo.fZX();
        AppMethodBeat.o(32539);
        return 0;
      }
      localdxa.GdK = locala.LVo.gfk();
      AppMethodBeat.o(32539);
      return 0;
    }
    AppMethodBeat.o(32539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxa
 * JD-Core Version:    0.7.0.1
 */