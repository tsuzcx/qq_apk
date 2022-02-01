package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czt
  extends com.tencent.mm.bw.a
{
  public int KOs;
  public String MEW;
  public String MEX;
  public String MEY;
  public String MEZ;
  public String MFa;
  public String MFb;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91577);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MEW != null) {
        paramVarArgs.e(1, this.MEW);
      }
      paramVarArgs.aM(2, this.oTW);
      if (this.MEX != null) {
        paramVarArgs.e(3, this.MEX);
      }
      if (this.MEY != null) {
        paramVarArgs.e(4, this.MEY);
      }
      if (this.MEZ != null) {
        paramVarArgs.e(5, this.MEZ);
      }
      paramVarArgs.aM(6, this.KOs);
      if (this.MFa != null) {
        paramVarArgs.e(7, this.MFa);
      }
      if (this.MFb != null) {
        paramVarArgs.e(8, this.MFb);
      }
      AppMethodBeat.o(91577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MEW == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = g.a.a.b.b.a.f(1, this.MEW) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oTW);
      paramInt = i;
      if (this.MEX != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MEX);
      }
      i = paramInt;
      if (this.MEY != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MEY);
      }
      paramInt = i;
      if (this.MEZ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MEZ);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.KOs);
      paramInt = i;
      if (this.MFa != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MFa);
      }
      i = paramInt;
      if (this.MFb != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MFb);
      }
      AppMethodBeat.o(91577);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91577);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        czt localczt = (czt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91577);
          return -1;
        case 1: 
          localczt.MEW = locala.UbS.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 2: 
          localczt.oTW = locala.UbS.zi();
          AppMethodBeat.o(91577);
          return 0;
        case 3: 
          localczt.MEX = locala.UbS.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 4: 
          localczt.MEY = locala.UbS.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 5: 
          localczt.MEZ = locala.UbS.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 6: 
          localczt.KOs = locala.UbS.zi();
          AppMethodBeat.o(91577);
          return 0;
        case 7: 
          localczt.MFa = locala.UbS.readString();
          AppMethodBeat.o(91577);
          return 0;
        }
        localczt.MFb = locala.UbS.readString();
        AppMethodBeat.o(91577);
        return 0;
      }
      AppMethodBeat.o(91577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czt
 * JD-Core Version:    0.7.0.1
 */