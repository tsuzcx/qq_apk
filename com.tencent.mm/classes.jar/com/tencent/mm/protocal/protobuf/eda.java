package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eda
  extends com.tencent.mm.bx.a
{
  public long FAf;
  public long FzV;
  public boolean HOP;
  public com.tencent.mm.bx.b HOQ;
  public String Hnp;
  public String Nickname;
  public String hDa;
  public int ugm;
  
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
      if (this.hDa == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.Hnp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.FAf);
      if (this.Nickname != null) {
        paramVarArgs.d(2, this.Nickname);
      }
      if (this.hDa != null) {
        paramVarArgs.d(3, this.hDa);
      }
      paramVarArgs.aS(4, this.ugm);
      if (this.Hnp != null) {
        paramVarArgs.d(5, this.Hnp);
      }
      paramVarArgs.aY(6, this.FzV);
      paramVarArgs.bt(7, this.HOP);
      if (this.HOQ != null) {
        paramVarArgs.c(8, this.HOQ);
      }
      AppMethodBeat.o(32539);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FAf) + 0;
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Nickname);
      }
      i = paramInt;
      if (this.hDa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hDa);
      }
      i += f.a.a.b.b.a.bz(4, this.ugm);
      paramInt = i;
      if (this.Hnp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hnp);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.FzV) + f.a.a.b.b.a.alV(7);
      paramInt = i;
      if (this.HOQ != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.HOQ);
      }
      AppMethodBeat.o(32539);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Nickname == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Nickname");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.hDa == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32539);
        throw paramVarArgs;
      }
      if (this.Hnp == null)
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
      eda localeda = (eda)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32539);
        return -1;
      case 1: 
        localeda.FAf = locala.NPN.zd();
        AppMethodBeat.o(32539);
        return 0;
      case 2: 
        localeda.Nickname = locala.NPN.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 3: 
        localeda.hDa = locala.NPN.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 4: 
        localeda.ugm = locala.NPN.zc();
        AppMethodBeat.o(32539);
        return 0;
      case 5: 
        localeda.Hnp = locala.NPN.readString();
        AppMethodBeat.o(32539);
        return 0;
      case 6: 
        localeda.FzV = locala.NPN.zd();
        AppMethodBeat.o(32539);
        return 0;
      case 7: 
        localeda.HOP = locala.NPN.grw();
        AppMethodBeat.o(32539);
        return 0;
      }
      localeda.HOQ = locala.NPN.gxI();
      AppMethodBeat.o(32539);
      return 0;
    }
    AppMethodBeat.o(32539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eda
 * JD-Core Version:    0.7.0.1
 */