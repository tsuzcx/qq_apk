package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drj
  extends com.tencent.mm.bx.a
{
  public long CCd;
  public long CCn;
  public boolean EGx;
  public com.tencent.mm.bx.b EGy;
  public String Egc;
  public String Nickname;
  public String gKr;
  public int saz;
  
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
      if (this.gKr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.Egc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      paramVarArgs.aG(1, this.CCn);
      if (this.Nickname != null) {
        paramVarArgs.d(2, this.Nickname);
      }
      if (this.gKr != null) {
        paramVarArgs.d(3, this.gKr);
      }
      paramVarArgs.aR(4, this.saz);
      if (this.Egc != null) {
        paramVarArgs.d(5, this.Egc);
      }
      paramVarArgs.aG(6, this.CCd);
      paramVarArgs.bg(7, this.EGx);
      if (this.EGy != null) {
        paramVarArgs.c(8, this.EGy);
      }
      AppMethodBeat.o(32539);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.CCn) + 0;
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Nickname);
      }
      i = paramInt;
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gKr);
      }
      i += f.a.a.b.b.a.bA(4, this.saz);
      paramInt = i;
      if (this.Egc != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Egc);
      }
      i = paramInt + f.a.a.b.b.a.q(6, this.CCd) + (f.a.a.b.b.a.fY(7) + 1);
      paramInt = i;
      if (this.EGy != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.EGy);
      }
      AppMethodBeat.o(32539);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Nickname == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.gKr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.Egc == null)
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
      drj localdrj = (drj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32539);
        return -1;
      case 1: 
        localdrj.CCn = locala.KhF.xT();
        AppMethodBeat.o(32539);
        return 0;
      case 2: 
        localdrj.Nickname = locala.KhF.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 3: 
        localdrj.gKr = locala.KhF.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 4: 
        localdrj.saz = locala.KhF.xS();
        AppMethodBeat.o(32539);
        return 0;
      case 5: 
        localdrj.Egc = locala.KhF.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 6: 
        localdrj.CCd = locala.KhF.xT();
        AppMethodBeat.o(32539);
        return 0;
      case 7: 
        localdrj.EGx = locala.KhF.fHu();
        AppMethodBeat.o(32539);
        return 0;
      }
      localdrj.EGy = locala.KhF.fMu();
      AppMethodBeat.o(32539);
      return 0;
    }
    AppMethodBeat.o(32539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drj
 * JD-Core Version:    0.7.0.1
 */