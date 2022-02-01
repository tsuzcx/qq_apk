package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxm
  extends com.tencent.mm.bw.a
{
  public int Height;
  public String MD5;
  public String MSF;
  public String MXn;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32452);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MD5 != null) {
        paramVarArgs.e(1, this.MD5);
      }
      paramVarArgs.aM(2, this.Width);
      paramVarArgs.aM(3, this.Height);
      if (this.MSF != null) {
        paramVarArgs.e(4, this.MSF);
      }
      if (this.MXn != null) {
        paramVarArgs.e(5, this.MXn);
      }
      AppMethodBeat.o(32452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label433;
      }
    }
    label433:
    for (paramInt = g.a.a.b.b.a.f(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Width) + g.a.a.b.b.a.bu(3, this.Height);
      paramInt = i;
      if (this.MSF != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MSF);
      }
      i = paramInt;
      if (this.MXn != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MXn);
      }
      AppMethodBeat.o(32452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32452);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dxm localdxm = (dxm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32452);
          return -1;
        case 1: 
          localdxm.MD5 = locala.UbS.readString();
          AppMethodBeat.o(32452);
          return 0;
        case 2: 
          localdxm.Width = locala.UbS.zi();
          AppMethodBeat.o(32452);
          return 0;
        case 3: 
          localdxm.Height = locala.UbS.zi();
          AppMethodBeat.o(32452);
          return 0;
        case 4: 
          localdxm.MSF = locala.UbS.readString();
          AppMethodBeat.o(32452);
          return 0;
        }
        localdxm.MXn = locala.UbS.readString();
        AppMethodBeat.o(32452);
        return 0;
      }
      AppMethodBeat.o(32452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxm
 * JD-Core Version:    0.7.0.1
 */