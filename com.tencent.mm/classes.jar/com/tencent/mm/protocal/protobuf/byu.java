package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byu
  extends com.tencent.mm.bw.a
{
  public int Hlw;
  public int otZ;
  public long rRn;
  public int scene;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184214);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.rRn);
      paramVarArgs.aS(2, this.scene);
      paramVarArgs.aS(3, this.otZ);
      paramVarArgs.aS(4, this.Hlw);
      if (this.sessionBuffer != null) {
        paramVarArgs.d(5, this.sessionBuffer);
      }
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.rRn) + 0 + f.a.a.b.b.a.bz(2, this.scene) + f.a.a.b.b.a.bz(3, this.otZ) + f.a.a.b.b.a.bz(4, this.Hlw);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sessionBuffer);
      }
      AppMethodBeat.o(184214);
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
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byu localbyu = (byu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184214);
        return -1;
      case 1: 
        localbyu.rRn = locala.OmT.zd();
        AppMethodBeat.o(184214);
        return 0;
      case 2: 
        localbyu.scene = locala.OmT.zc();
        AppMethodBeat.o(184214);
        return 0;
      case 3: 
        localbyu.otZ = locala.OmT.zc();
        AppMethodBeat.o(184214);
        return 0;
      case 4: 
        localbyu.Hlw = locala.OmT.zc();
        AppMethodBeat.o(184214);
        return 0;
      }
      localbyu.sessionBuffer = locala.OmT.readString();
      AppMethodBeat.o(184214);
      return 0;
    }
    AppMethodBeat.o(184214);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byu
 * JD-Core Version:    0.7.0.1
 */