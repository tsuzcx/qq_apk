package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class np
  extends com.tencent.mm.bw.a
{
  public int KSY;
  public int KSZ;
  public int KTa;
  public String KTb;
  public String KTc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124410);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KSY);
      paramVarArgs.aM(2, this.KSZ);
      paramVarArgs.aM(3, this.KTa);
      if (this.KTb != null) {
        paramVarArgs.e(4, this.KTb);
      }
      if (this.KTc != null) {
        paramVarArgs.e(5, this.KTc);
      }
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KSY) + 0 + g.a.a.b.b.a.bu(2, this.KSZ) + g.a.a.b.b.a.bu(3, this.KTa);
      paramInt = i;
      if (this.KTb != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KTb);
      }
      i = paramInt;
      if (this.KTc != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KTc);
      }
      AppMethodBeat.o(124410);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      np localnp = (np)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124410);
        return -1;
      case 1: 
        localnp.KSY = locala.UbS.zi();
        AppMethodBeat.o(124410);
        return 0;
      case 2: 
        localnp.KSZ = locala.UbS.zi();
        AppMethodBeat.o(124410);
        return 0;
      case 3: 
        localnp.KTa = locala.UbS.zi();
        AppMethodBeat.o(124410);
        return 0;
      case 4: 
        localnp.KTb = locala.UbS.readString();
        AppMethodBeat.o(124410);
        return 0;
      }
      localnp.KTc = locala.UbS.readString();
      AppMethodBeat.o(124410);
      return 0;
    }
    AppMethodBeat.o(124410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.np
 * JD-Core Version:    0.7.0.1
 */