package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbs
  extends com.tencent.mm.bw.a
{
  public String CiX;
  public String KZa;
  public String MhA;
  public String MhB;
  public String MhC;
  public String Mhy;
  public long Mhz;
  public int state;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72500);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KZa != null) {
        paramVarArgs.e(1, this.KZa);
      }
      paramVarArgs.aM(2, this.state);
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.Mhy != null) {
        paramVarArgs.e(4, this.Mhy);
      }
      paramVarArgs.bb(5, this.Mhz);
      if (this.MhA != null) {
        paramVarArgs.e(6, this.MhA);
      }
      if (this.CiX != null) {
        paramVarArgs.e(7, this.CiX);
      }
      if (this.MhB != null) {
        paramVarArgs.e(8, this.MhB);
      }
      if (this.MhC != null) {
        paramVarArgs.e(9, this.MhC);
      }
      AppMethodBeat.o(72500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KZa == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = g.a.a.b.b.a.f(1, this.KZa) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.state);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.title);
      }
      i = paramInt;
      if (this.Mhy != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Mhy);
      }
      i += g.a.a.b.b.a.r(5, this.Mhz);
      paramInt = i;
      if (this.MhA != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MhA);
      }
      i = paramInt;
      if (this.CiX != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.CiX);
      }
      paramInt = i;
      if (this.MhB != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MhB);
      }
      i = paramInt;
      if (this.MhC != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.MhC);
      }
      AppMethodBeat.o(72500);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72500);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cbs localcbs = (cbs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72500);
          return -1;
        case 1: 
          localcbs.KZa = locala.UbS.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 2: 
          localcbs.state = locala.UbS.zi();
          AppMethodBeat.o(72500);
          return 0;
        case 3: 
          localcbs.title = locala.UbS.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 4: 
          localcbs.Mhy = locala.UbS.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 5: 
          localcbs.Mhz = locala.UbS.zl();
          AppMethodBeat.o(72500);
          return 0;
        case 6: 
          localcbs.MhA = locala.UbS.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 7: 
          localcbs.CiX = locala.UbS.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 8: 
          localcbs.MhB = locala.UbS.readString();
          AppMethodBeat.o(72500);
          return 0;
        }
        localcbs.MhC = locala.UbS.readString();
        AppMethodBeat.o(72500);
        return 0;
      }
      AppMethodBeat.o(72500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbs
 * JD-Core Version:    0.7.0.1
 */