package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxx
  extends com.tencent.mm.bw.a
{
  public String FDc;
  public com.tencent.mm.bw.b Gdx;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32566);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32566);
        throw paramVarArgs;
      }
      if (this.ndW == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32566);
        throw paramVarArgs;
      }
      if (this.FDc != null) {
        paramVarArgs.d(1, this.FDc);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      if (this.Gdx != null) {
        paramVarArgs.c(3, this.Gdx);
      }
      AppMethodBeat.o(32566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDc == null) {
        break label443;
      }
    }
    label443:
    for (int i = f.a.a.b.b.a.e(1, this.FDc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ndW);
      }
      i = paramInt;
      if (this.Gdx != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Gdx);
      }
      AppMethodBeat.o(32566);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FDc == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32566);
          throw paramVarArgs;
        }
        if (this.ndW == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
          AppMethodBeat.o(32566);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32566);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxx localdxx = (dxx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32566);
          return -1;
        case 1: 
          localdxx.FDc = locala.LVo.readString();
          AppMethodBeat.o(32566);
          return 0;
        case 2: 
          localdxx.ndW = locala.LVo.readString();
          AppMethodBeat.o(32566);
          return 0;
        }
        localdxx.Gdx = locala.LVo.gfk();
        AppMethodBeat.o(32566);
        return 0;
      }
      AppMethodBeat.o(32566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxx
 * JD-Core Version:    0.7.0.1
 */