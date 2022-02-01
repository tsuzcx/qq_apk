package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwq
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b Gdx;
  public String hkR;
  public String ncR;
  public String ndW;
  public int tlI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32527);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.ndW == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.hkR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.tlI);
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(3, this.ndW);
      }
      if (this.hkR != null) {
        paramVarArgs.d(4, this.hkR);
      }
      if (this.Gdx != null) {
        paramVarArgs.c(5, this.Gdx);
      }
      AppMethodBeat.o(32527);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.tlI) + 0;
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ndW);
      }
      paramInt = i;
      if (this.hkR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hkR);
      }
      i = paramInt;
      if (this.Gdx != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.Gdx);
      }
      AppMethodBeat.o(32527);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.ncR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.ndW == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.hkR == null)
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
      dwq localdwq = (dwq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32527);
        return -1;
      case 1: 
        localdwq.tlI = locala.LVo.xF();
        AppMethodBeat.o(32527);
        return 0;
      case 2: 
        localdwq.ncR = locala.LVo.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 3: 
        localdwq.ndW = locala.LVo.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 4: 
        localdwq.hkR = locala.LVo.readString();
        AppMethodBeat.o(32527);
        return 0;
      }
      localdwq.Gdx = locala.LVo.gfk();
      AppMethodBeat.o(32527);
      return 0;
    }
    AppMethodBeat.o(32527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwq
 * JD-Core Version:    0.7.0.1
 */