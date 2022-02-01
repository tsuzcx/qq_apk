package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxq
  extends com.tencent.mm.bw.a
{
  public String coverUrl;
  public String desc;
  public int duration;
  public int hBW;
  public int hBX = 0;
  public int hBY;
  public int hBZ;
  public String hCa;
  public int hFR = -1;
  public int videoHeight;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125740);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.hFR);
      paramVarArgs.aS(2, this.hBX);
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.aS(4, this.videoWidth);
      paramVarArgs.aS(5, this.videoHeight);
      paramVarArgs.aS(6, this.hBW);
      paramVarArgs.aS(7, this.duration);
      if (this.hCa != null) {
        paramVarArgs.d(8, this.hCa);
      }
      paramVarArgs.aS(9, this.hBZ);
      if (this.coverUrl != null) {
        paramVarArgs.d(10, this.coverUrl);
      }
      paramVarArgs.aS(11, this.hBY);
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.hFR) + 0 + f.a.a.b.b.a.bz(2, this.hBX);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.desc);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.videoWidth) + f.a.a.b.b.a.bz(5, this.videoHeight) + f.a.a.b.b.a.bz(6, this.hBW) + f.a.a.b.b.a.bz(7, this.duration);
      paramInt = i;
      if (this.hCa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hCa);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.hBZ);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.coverUrl);
      }
      i = f.a.a.b.b.a.bz(11, this.hBY);
      AppMethodBeat.o(125740);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxq localbxq = (bxq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125740);
        return -1;
      case 1: 
        localbxq.hFR = locala.OmT.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 2: 
        localbxq.hBX = locala.OmT.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 3: 
        localbxq.desc = locala.OmT.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 4: 
        localbxq.videoWidth = locala.OmT.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 5: 
        localbxq.videoHeight = locala.OmT.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 6: 
        localbxq.hBW = locala.OmT.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 7: 
        localbxq.duration = locala.OmT.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 8: 
        localbxq.hCa = locala.OmT.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 9: 
        localbxq.hBZ = locala.OmT.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 10: 
        localbxq.coverUrl = locala.OmT.readString();
        AppMethodBeat.o(125740);
        return 0;
      }
      localbxq.hBY = locala.OmT.zc();
      AppMethodBeat.o(125740);
      return 0;
    }
    AppMethodBeat.o(125740);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxq
 * JD-Core Version:    0.7.0.1
 */