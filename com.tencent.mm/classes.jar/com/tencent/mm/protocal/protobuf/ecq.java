package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecq
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b HOD;
  public String hDa;
  public String nDo;
  public String nEt;
  public int ukh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32527);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.nEt == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.hDa == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.ukh);
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(3, this.nEt);
      }
      if (this.hDa != null) {
        paramVarArgs.d(4, this.hDa);
      }
      if (this.HOD != null) {
        paramVarArgs.c(5, this.HOD);
      }
      AppMethodBeat.o(32527);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ukh) + 0;
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nEt);
      }
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hDa);
      }
      i = paramInt;
      if (this.HOD != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.HOD);
      }
      AppMethodBeat.o(32527);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.nDo == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.nEt == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.hDa == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32527);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ecq localecq = (ecq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32527);
        return -1;
      case 1: 
        localecq.ukh = locala.NPN.zc();
        AppMethodBeat.o(32527);
        return 0;
      case 2: 
        localecq.nDo = locala.NPN.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 3: 
        localecq.nEt = locala.NPN.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 4: 
        localecq.hDa = locala.NPN.readString();
        AppMethodBeat.o(32527);
        return 0;
      }
      localecq.HOD = locala.NPN.gxI();
      AppMethodBeat.o(32527);
      return 0;
    }
    AppMethodBeat.o(32527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecq
 * JD-Core Version:    0.7.0.1
 */