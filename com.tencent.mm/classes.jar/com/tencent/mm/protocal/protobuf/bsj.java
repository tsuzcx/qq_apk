package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsj
  extends com.tencent.mm.bw.a
{
  public String coverUrl;
  public String desc;
  public int duration;
  public int hgZ;
  public int hha = 0;
  public int hhb;
  public int hhc;
  public String hhd;
  public int hkQ = -1;
  public int videoHeight;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125740);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.hkQ);
      paramVarArgs.aR(2, this.hha);
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.aR(4, this.videoWidth);
      paramVarArgs.aR(5, this.videoHeight);
      paramVarArgs.aR(6, this.hgZ);
      paramVarArgs.aR(7, this.duration);
      if (this.hhd != null) {
        paramVarArgs.d(8, this.hhd);
      }
      paramVarArgs.aR(9, this.hhc);
      if (this.coverUrl != null) {
        paramVarArgs.d(10, this.coverUrl);
      }
      paramVarArgs.aR(11, this.hhb);
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.hkQ) + 0 + f.a.a.b.b.a.bx(2, this.hha);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.desc);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.videoWidth) + f.a.a.b.b.a.bx(5, this.videoHeight) + f.a.a.b.b.a.bx(6, this.hgZ) + f.a.a.b.b.a.bx(7, this.duration);
      paramInt = i;
      if (this.hhd != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hhd);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.hhc);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.coverUrl);
      }
      i = f.a.a.b.b.a.bx(11, this.hhb);
      AppMethodBeat.o(125740);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsj localbsj = (bsj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125740);
        return -1;
      case 1: 
        localbsj.hkQ = locala.LVo.xF();
        AppMethodBeat.o(125740);
        return 0;
      case 2: 
        localbsj.hha = locala.LVo.xF();
        AppMethodBeat.o(125740);
        return 0;
      case 3: 
        localbsj.desc = locala.LVo.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 4: 
        localbsj.videoWidth = locala.LVo.xF();
        AppMethodBeat.o(125740);
        return 0;
      case 5: 
        localbsj.videoHeight = locala.LVo.xF();
        AppMethodBeat.o(125740);
        return 0;
      case 6: 
        localbsj.hgZ = locala.LVo.xF();
        AppMethodBeat.o(125740);
        return 0;
      case 7: 
        localbsj.duration = locala.LVo.xF();
        AppMethodBeat.o(125740);
        return 0;
      case 8: 
        localbsj.hhd = locala.LVo.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 9: 
        localbsj.hhc = locala.LVo.xF();
        AppMethodBeat.o(125740);
        return 0;
      case 10: 
        localbsj.coverUrl = locala.LVo.readString();
        AppMethodBeat.o(125740);
        return 0;
      }
      localbsj.hhb = locala.LVo.xF();
      AppMethodBeat.o(125740);
      return 0;
    }
    AppMethodBeat.o(125740);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsj
 * JD-Core Version:    0.7.0.1
 */