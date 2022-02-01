package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dlc
  extends com.tencent.mm.bw.a
{
  public String KXA;
  public b LXB;
  public b LXC;
  public String MOZ;
  public b MPa;
  public int Scene;
  public String SessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104831);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KXA != null) {
        paramVarArgs.e(1, this.KXA);
      }
      if (this.MOZ != null) {
        paramVarArgs.e(2, this.MOZ);
      }
      if (this.SessionId != null) {
        paramVarArgs.e(3, this.SessionId);
      }
      if (this.LXC != null) {
        paramVarArgs.c(4, this.LXC);
      }
      if (this.LXB != null) {
        paramVarArgs.c(5, this.LXB);
      }
      paramVarArgs.aM(6, this.Scene);
      if (this.MPa != null) {
        paramVarArgs.c(7, this.MPa);
      }
      AppMethodBeat.o(104831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KXA == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.f(1, this.KXA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MOZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MOZ);
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.SessionId);
      }
      paramInt = i;
      if (this.LXC != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.LXC);
      }
      i = paramInt;
      if (this.LXB != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.LXB);
      }
      i += g.a.a.b.b.a.bu(6, this.Scene);
      paramInt = i;
      if (this.MPa != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.MPa);
      }
      AppMethodBeat.o(104831);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104831);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dlc localdlc = (dlc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104831);
          return -1;
        case 1: 
          localdlc.KXA = locala.UbS.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 2: 
          localdlc.MOZ = locala.UbS.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 3: 
          localdlc.SessionId = locala.UbS.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 4: 
          localdlc.LXC = locala.UbS.hPo();
          AppMethodBeat.o(104831);
          return 0;
        case 5: 
          localdlc.LXB = locala.UbS.hPo();
          AppMethodBeat.o(104831);
          return 0;
        case 6: 
          localdlc.Scene = locala.UbS.zi();
          AppMethodBeat.o(104831);
          return 0;
        }
        localdlc.MPa = locala.UbS.hPo();
        AppMethodBeat.o(104831);
        return 0;
      }
      AppMethodBeat.o(104831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlc
 * JD-Core Version:    0.7.0.1
 */