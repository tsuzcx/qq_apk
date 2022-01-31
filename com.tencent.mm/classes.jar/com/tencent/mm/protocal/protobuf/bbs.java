package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbs
  extends com.tencent.mm.bv.a
{
  public String desc;
  public int duration;
  public int fgi;
  public int fgj = 0;
  public int fgk;
  public String fgl;
  public String lHo;
  public int videoHeight;
  public int videoWidth;
  public int wqp = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94536);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wqp);
      paramVarArgs.aO(2, this.fgj);
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      paramVarArgs.aO(4, this.videoWidth);
      paramVarArgs.aO(5, this.videoHeight);
      paramVarArgs.aO(6, this.fgi);
      paramVarArgs.aO(7, this.duration);
      if (this.fgl != null) {
        paramVarArgs.e(8, this.fgl);
      }
      paramVarArgs.aO(9, this.fgk);
      if (this.lHo != null) {
        paramVarArgs.e(10, this.lHo);
      }
      AppMethodBeat.o(94536);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wqp) + 0 + e.a.a.b.b.a.bl(2, this.fgj);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.desc);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.videoWidth) + e.a.a.b.b.a.bl(5, this.videoHeight) + e.a.a.b.b.a.bl(6, this.fgi) + e.a.a.b.b.a.bl(7, this.duration);
      paramInt = i;
      if (this.fgl != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.fgl);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.fgk);
      paramInt = i;
      if (this.lHo != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.lHo);
      }
      AppMethodBeat.o(94536);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94536);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bbs localbbs = (bbs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94536);
        return -1;
      case 1: 
        localbbs.wqp = locala.CLY.sl();
        AppMethodBeat.o(94536);
        return 0;
      case 2: 
        localbbs.fgj = locala.CLY.sl();
        AppMethodBeat.o(94536);
        return 0;
      case 3: 
        localbbs.desc = locala.CLY.readString();
        AppMethodBeat.o(94536);
        return 0;
      case 4: 
        localbbs.videoWidth = locala.CLY.sl();
        AppMethodBeat.o(94536);
        return 0;
      case 5: 
        localbbs.videoHeight = locala.CLY.sl();
        AppMethodBeat.o(94536);
        return 0;
      case 6: 
        localbbs.fgi = locala.CLY.sl();
        AppMethodBeat.o(94536);
        return 0;
      case 7: 
        localbbs.duration = locala.CLY.sl();
        AppMethodBeat.o(94536);
        return 0;
      case 8: 
        localbbs.fgl = locala.CLY.readString();
        AppMethodBeat.o(94536);
        return 0;
      case 9: 
        localbbs.fgk = locala.CLY.sl();
        AppMethodBeat.o(94536);
        return 0;
      }
      localbbs.lHo = locala.CLY.readString();
      AppMethodBeat.o(94536);
      return 0;
    }
    AppMethodBeat.o(94536);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbs
 * JD-Core Version:    0.7.0.1
 */