package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dll
  extends com.tencent.mm.bx.a
{
  public String coverUrl;
  public String desc;
  public int duration;
  public int nQn;
  public int nQo = 0;
  public int nQp;
  public int nQq;
  public int nUA = -1;
  public String vid;
  public int videoHeight;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125740);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.nUA);
      paramVarArgs.bS(2, this.nQo);
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      paramVarArgs.bS(4, this.videoWidth);
      paramVarArgs.bS(5, this.videoHeight);
      paramVarArgs.bS(6, this.nQn);
      paramVarArgs.bS(7, this.duration);
      if (this.vid != null) {
        paramVarArgs.g(8, this.vid);
      }
      paramVarArgs.bS(9, this.nQq);
      if (this.coverUrl != null) {
        paramVarArgs.g(10, this.coverUrl);
      }
      paramVarArgs.bS(11, this.nQp);
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.nUA) + 0 + i.a.a.b.b.a.cJ(2, this.nQo);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.desc);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.videoWidth) + i.a.a.b.b.a.cJ(5, this.videoHeight) + i.a.a.b.b.a.cJ(6, this.nQn) + i.a.a.b.b.a.cJ(7, this.duration);
      paramInt = i;
      if (this.vid != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.vid);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.nQq);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.coverUrl);
      }
      i = i.a.a.b.b.a.cJ(11, this.nQp);
      AppMethodBeat.o(125740);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125740);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dll localdll = (dll)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125740);
        return -1;
      case 1: 
        localdll.nUA = locala.ajGk.aar();
        AppMethodBeat.o(125740);
        return 0;
      case 2: 
        localdll.nQo = locala.ajGk.aar();
        AppMethodBeat.o(125740);
        return 0;
      case 3: 
        localdll.desc = locala.ajGk.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 4: 
        localdll.videoWidth = locala.ajGk.aar();
        AppMethodBeat.o(125740);
        return 0;
      case 5: 
        localdll.videoHeight = locala.ajGk.aar();
        AppMethodBeat.o(125740);
        return 0;
      case 6: 
        localdll.nQn = locala.ajGk.aar();
        AppMethodBeat.o(125740);
        return 0;
      case 7: 
        localdll.duration = locala.ajGk.aar();
        AppMethodBeat.o(125740);
        return 0;
      case 8: 
        localdll.vid = locala.ajGk.readString();
        AppMethodBeat.o(125740);
        return 0;
      case 9: 
        localdll.nQq = locala.ajGk.aar();
        AppMethodBeat.o(125740);
        return 0;
      case 10: 
        localdll.coverUrl = locala.ajGk.readString();
        AppMethodBeat.o(125740);
        return 0;
      }
      localdll.nQp = locala.ajGk.aar();
      AppMethodBeat.o(125740);
      return 0;
    }
    AppMethodBeat.o(125740);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dll
 * JD-Core Version:    0.7.0.1
 */