package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aio
  extends com.tencent.mm.bw.a
{
  public String Gyn;
  public int mediaType;
  public long rRn;
  public String sbR;
  public String sessionBuffer;
  public int videoDuration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189299);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.rRn);
      if (this.sbR != null) {
        paramVarArgs.d(2, this.sbR);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(3, this.sessionBuffer);
      }
      if (this.Gyn != null) {
        paramVarArgs.d(4, this.Gyn);
      }
      paramVarArgs.aS(5, this.videoDuration);
      paramVarArgs.aS(6, this.mediaType);
      AppMethodBeat.o(189299);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.rRn) + 0;
      paramInt = i;
      if (this.sbR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sbR);
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sessionBuffer);
      }
      paramInt = i;
      if (this.Gyn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gyn);
      }
      i = f.a.a.b.b.a.bz(5, this.videoDuration);
      int j = f.a.a.b.b.a.bz(6, this.mediaType);
      AppMethodBeat.o(189299);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189299);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aio localaio = (aio)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189299);
        return -1;
      case 1: 
        localaio.rRn = locala.OmT.zd();
        AppMethodBeat.o(189299);
        return 0;
      case 2: 
        localaio.sbR = locala.OmT.readString();
        AppMethodBeat.o(189299);
        return 0;
      case 3: 
        localaio.sessionBuffer = locala.OmT.readString();
        AppMethodBeat.o(189299);
        return 0;
      case 4: 
        localaio.Gyn = locala.OmT.readString();
        AppMethodBeat.o(189299);
        return 0;
      case 5: 
        localaio.videoDuration = locala.OmT.zc();
        AppMethodBeat.o(189299);
        return 0;
      }
      localaio.mediaType = locala.OmT.zc();
      AppMethodBeat.o(189299);
      return 0;
    }
    AppMethodBeat.o(189299);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aio
 * JD-Core Version:    0.7.0.1
 */