package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eeh
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b IiK;
  public String hFS;
  public String nIJ;
  public String nJO;
  public int uvE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32527);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.nJO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.hFS == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.uvE);
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(3, this.nJO);
      }
      if (this.hFS != null) {
        paramVarArgs.d(4, this.hFS);
      }
      if (this.IiK != null) {
        paramVarArgs.c(5, this.IiK);
      }
      AppMethodBeat.o(32527);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uvE) + 0;
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nJO);
      }
      paramInt = i;
      if (this.hFS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hFS);
      }
      i = paramInt;
      if (this.IiK != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.IiK);
      }
      AppMethodBeat.o(32527);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.nIJ == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.nJO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.hFS == null)
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
      eeh localeeh = (eeh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32527);
        return -1;
      case 1: 
        localeeh.uvE = locala.OmT.zc();
        AppMethodBeat.o(32527);
        return 0;
      case 2: 
        localeeh.nIJ = locala.OmT.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 3: 
        localeeh.nJO = locala.OmT.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 4: 
        localeeh.hFS = locala.OmT.readString();
        AppMethodBeat.o(32527);
        return 0;
      }
      localeeh.IiK = locala.OmT.gCk();
      AppMethodBeat.o(32527);
      return 0;
    }
    AppMethodBeat.o(32527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeh
 * JD-Core Version:    0.7.0.1
 */