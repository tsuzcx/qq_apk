package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bww
  extends com.tencent.mm.bx.a
{
  public String coverUrl;
  public String desc;
  public int duration;
  public int hCZ = -1;
  public int hzi;
  public int hzj = 0;
  public int hzk;
  public int hzl;
  public String hzm;
  public int videoHeight;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125740);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.hCZ);
      paramVarArgs.aS(2, this.hzj);
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.aS(4, this.videoWidth);
      paramVarArgs.aS(5, this.videoHeight);
      paramVarArgs.aS(6, this.hzi);
      paramVarArgs.aS(7, this.duration);
      if (this.hzm != null) {
        paramVarArgs.d(8, this.hzm);
      }
      paramVarArgs.aS(9, this.hzl);
      if (this.coverUrl != null) {
        paramVarArgs.d(10, this.coverUrl);
      }
      paramVarArgs.aS(11, this.hzk);
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.hCZ) + 0 + f.a.a.b.b.a.bz(2, this.hzj);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.desc);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.videoWidth) + f.a.a.b.b.a.bz(5, this.videoHeight) + f.a.a.b.b.a.bz(6, this.hzi) + f.a.a.b.b.a.bz(7, this.duration);
      paramInt = i;
      if (this.hzm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hzm);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.hzl);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.coverUrl);
      }
      i = f.a.a.b.b.a.bz(11, this.hzk);
      AppMethodBeat.o(125740);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bww localbww = (bww)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125740);
        return -1;
      case 1: 
        localbww.hCZ = locala.NPN.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 2: 
        localbww.hzj = locala.NPN.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 3: 
        localbww.desc = locala.NPN.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 4: 
        localbww.videoWidth = locala.NPN.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 5: 
        localbww.videoHeight = locala.NPN.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 6: 
        localbww.hzi = locala.NPN.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 7: 
        localbww.duration = locala.NPN.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 8: 
        localbww.hzm = locala.NPN.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 9: 
        localbww.hzl = locala.NPN.zc();
        AppMethodBeat.o(125740);
        return 0;
      case 10: 
        localbww.coverUrl = locala.NPN.readString();
        AppMethodBeat.o(125740);
        return 0;
      }
      localbww.hzk = locala.NPN.zc();
      AppMethodBeat.o(125740);
      return 0;
    }
    AppMethodBeat.o(125740);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bww
 * JD-Core Version:    0.7.0.1
 */