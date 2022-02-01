package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bgt
  extends com.tencent.mm.bx.a
{
  public String Dky;
  public String Ebo;
  public String JfL;
  public String ZQh;
  public long liveId;
  public int startTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257985);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.startTime);
      paramVarArgs.bv(2, this.liveId);
      if (this.JfL != null) {
        paramVarArgs.g(3, this.JfL);
      }
      if (this.Dky != null) {
        paramVarArgs.g(4, this.Dky);
      }
      if (this.Ebo != null) {
        paramVarArgs.g(5, this.Ebo);
      }
      if (this.ZQh != null) {
        paramVarArgs.g(6, this.ZQh);
      }
      AppMethodBeat.o(257985);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.startTime) + 0 + i.a.a.b.b.a.q(2, this.liveId);
      paramInt = i;
      if (this.JfL != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.JfL);
      }
      i = paramInt;
      if (this.Dky != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Dky);
      }
      paramInt = i;
      if (this.Ebo != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Ebo);
      }
      i = paramInt;
      if (this.ZQh != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZQh);
      }
      AppMethodBeat.o(257985);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257985);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bgt localbgt = (bgt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257985);
        return -1;
      case 1: 
        localbgt.startTime = locala.ajGk.aar();
        AppMethodBeat.o(257985);
        return 0;
      case 2: 
        localbgt.liveId = locala.ajGk.aaw();
        AppMethodBeat.o(257985);
        return 0;
      case 3: 
        localbgt.JfL = locala.ajGk.readString();
        AppMethodBeat.o(257985);
        return 0;
      case 4: 
        localbgt.Dky = locala.ajGk.readString();
        AppMethodBeat.o(257985);
        return 0;
      case 5: 
        localbgt.Ebo = locala.ajGk.readString();
        AppMethodBeat.o(257985);
        return 0;
      }
      localbgt.ZQh = locala.ajGk.readString();
      AppMethodBeat.o(257985);
      return 0;
    }
    AppMethodBeat.o(257985);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgt
 * JD-Core Version:    0.7.0.1
 */