package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class asd
  extends com.tencent.mm.bx.a
{
  public int Glz;
  public long Gqn;
  public String Gqo;
  public String Gqp;
  public String Gqq;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Gqn);
      if (this.Gqo != null) {
        paramVarArgs.d(2, this.Gqo);
      }
      paramVarArgs.aS(3, this.Glz);
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      if (this.Gqp != null) {
        paramVarArgs.d(5, this.Gqp);
      }
      if (this.Gqq != null) {
        paramVarArgs.d(6, this.Gqq);
      }
      AppMethodBeat.o(209369);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Gqn) + 0;
      paramInt = i;
      if (this.Gqo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gqo);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.Glz);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.username);
      }
      i = paramInt;
      if (this.Gqp != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gqp);
      }
      paramInt = i;
      if (this.Gqq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gqq);
      }
      AppMethodBeat.o(209369);
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
      AppMethodBeat.o(209369);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      asd localasd = (asd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209369);
        return -1;
      case 1: 
        localasd.Gqn = locala.NPN.zd();
        AppMethodBeat.o(209369);
        return 0;
      case 2: 
        localasd.Gqo = locala.NPN.readString();
        AppMethodBeat.o(209369);
        return 0;
      case 3: 
        localasd.Glz = locala.NPN.zc();
        AppMethodBeat.o(209369);
        return 0;
      case 4: 
        localasd.username = locala.NPN.readString();
        AppMethodBeat.o(209369);
        return 0;
      case 5: 
        localasd.Gqp = locala.NPN.readString();
        AppMethodBeat.o(209369);
        return 0;
      }
      localasd.Gqq = locala.NPN.readString();
      AppMethodBeat.o(209369);
      return 0;
    }
    AppMethodBeat.o(209369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asd
 * JD-Core Version:    0.7.0.1
 */