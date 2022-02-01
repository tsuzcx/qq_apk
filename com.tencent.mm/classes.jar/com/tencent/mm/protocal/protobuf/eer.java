package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eer
  extends com.tencent.mm.bw.a
{
  public long FSD;
  public long FSt;
  public String HGP;
  public boolean IiW;
  public com.tencent.mm.bw.b IiX;
  public String Nickname;
  public String hFS;
  public int urJ;
  
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
      if (this.hFS == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.HGP == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      paramVarArgs.aZ(1, this.FSD);
      if (this.Nickname != null) {
        paramVarArgs.d(2, this.Nickname);
      }
      if (this.hFS != null) {
        paramVarArgs.d(3, this.hFS);
      }
      paramVarArgs.aS(4, this.urJ);
      if (this.HGP != null) {
        paramVarArgs.d(5, this.HGP);
      }
      paramVarArgs.aZ(6, this.FSt);
      paramVarArgs.bC(7, this.IiW);
      if (this.IiX != null) {
        paramVarArgs.c(8, this.IiX);
      }
      AppMethodBeat.o(32539);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FSD) + 0;
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Nickname);
      }
      i = paramInt;
      if (this.hFS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hFS);
      }
      i += f.a.a.b.b.a.bz(4, this.urJ);
      paramInt = i;
      if (this.HGP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HGP);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.FSt) + f.a.a.b.b.a.amF(7);
      paramInt = i;
      if (this.IiX != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.IiX);
      }
      AppMethodBeat.o(32539);
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
      if (this.Nickname == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.hFS == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.HGP == null)
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
      eer localeer = (eer)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32539);
        return -1;
      case 1: 
        localeer.FSD = locala.OmT.zd();
        AppMethodBeat.o(32539);
        return 0;
      case 2: 
        localeer.Nickname = locala.OmT.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 3: 
        localeer.hFS = locala.OmT.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 4: 
        localeer.urJ = locala.OmT.zc();
        AppMethodBeat.o(32539);
        return 0;
      case 5: 
        localeer.HGP = locala.OmT.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 6: 
        localeer.FSt = locala.OmT.zd();
        AppMethodBeat.o(32539);
        return 0;
      case 7: 
        localeer.IiW = locala.OmT.gvY();
        AppMethodBeat.o(32539);
        return 0;
      }
      localeer.IiX = locala.OmT.gCk();
      AppMethodBeat.o(32539);
      return 0;
    }
    AppMethodBeat.o(32539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eer
 * JD-Core Version:    0.7.0.1
 */