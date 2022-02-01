package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnt
  extends com.tencent.mm.bx.a
{
  public String coverUrl;
  public String desc;
  public int duration;
  public int gGA;
  public int gGB;
  public String gGC;
  public int gGy;
  public int gGz = 0;
  public int gKq = -1;
  public int videoHeight;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125740);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.gKq);
      paramVarArgs.aR(2, this.gGz);
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.aR(4, this.videoWidth);
      paramVarArgs.aR(5, this.videoHeight);
      paramVarArgs.aR(6, this.gGy);
      paramVarArgs.aR(7, this.duration);
      if (this.gGC != null) {
        paramVarArgs.d(8, this.gGC);
      }
      paramVarArgs.aR(9, this.gGB);
      if (this.coverUrl != null) {
        paramVarArgs.d(10, this.coverUrl);
      }
      paramVarArgs.aR(11, this.gGA);
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.gKq) + 0 + f.a.a.b.b.a.bA(2, this.gGz);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.desc);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.videoWidth) + f.a.a.b.b.a.bA(5, this.videoHeight) + f.a.a.b.b.a.bA(6, this.gGy) + f.a.a.b.b.a.bA(7, this.duration);
      paramInt = i;
      if (this.gGC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.gGC);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.gGB);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.coverUrl);
      }
      i = f.a.a.b.b.a.bA(11, this.gGA);
      AppMethodBeat.o(125740);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bnt localbnt = (bnt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125740);
        return -1;
      case 1: 
        localbnt.gKq = locala.KhF.xS();
        AppMethodBeat.o(125740);
        return 0;
      case 2: 
        localbnt.gGz = locala.KhF.xS();
        AppMethodBeat.o(125740);
        return 0;
      case 3: 
        localbnt.desc = locala.KhF.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 4: 
        localbnt.videoWidth = locala.KhF.xS();
        AppMethodBeat.o(125740);
        return 0;
      case 5: 
        localbnt.videoHeight = locala.KhF.xS();
        AppMethodBeat.o(125740);
        return 0;
      case 6: 
        localbnt.gGy = locala.KhF.xS();
        AppMethodBeat.o(125740);
        return 0;
      case 7: 
        localbnt.duration = locala.KhF.xS();
        AppMethodBeat.o(125740);
        return 0;
      case 8: 
        localbnt.gGC = locala.KhF.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 9: 
        localbnt.gGB = locala.KhF.xS();
        AppMethodBeat.o(125740);
        return 0;
      case 10: 
        localbnt.coverUrl = locala.KhF.readString();
        AppMethodBeat.o(125740);
        return 0;
      }
      localbnt.gGA = locala.KhF.xS();
      AppMethodBeat.o(125740);
      return 0;
    }
    AppMethodBeat.o(125740);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnt
 * JD-Core Version:    0.7.0.1
 */