package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebh
  extends com.tencent.mm.bw.a
{
  public int EbF;
  public boolean GgS;
  public String nickname;
  public String ugE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153328);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EbF);
      if (this.ugE != null) {
        paramVarArgs.d(2, this.ugE);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      paramVarArgs.bl(4, this.GgS);
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.EbF) + 0;
      paramInt = i;
      if (this.ugE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ugE);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = f.a.a.b.b.a.fK(4);
      AppMethodBeat.o(153328);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(153328);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ebh localebh = (ebh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153328);
        return -1;
      case 1: 
        localebh.EbF = locala.LVo.xF();
        AppMethodBeat.o(153328);
        return 0;
      case 2: 
        localebh.ugE = locala.LVo.readString();
        AppMethodBeat.o(153328);
        return 0;
      case 3: 
        localebh.nickname = locala.LVo.readString();
        AppMethodBeat.o(153328);
        return 0;
      }
      localebh.GgS = locala.LVo.fZX();
      AppMethodBeat.o(153328);
      return 0;
    }
    AppMethodBeat.o(153328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebh
 * JD-Core Version:    0.7.0.1
 */