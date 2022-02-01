package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbq
  extends com.tencent.mm.bw.a
{
  public long Brn;
  public String KIz;
  public int LWr;
  public long Mhx;
  public String UserName;
  public String jfM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194543);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Brn);
      paramVarArgs.bb(2, this.Mhx);
      if (this.jfM != null) {
        paramVarArgs.e(3, this.jfM);
      }
      paramVarArgs.aM(4, this.LWr);
      if (this.UserName != null) {
        paramVarArgs.e(5, this.UserName);
      }
      if (this.KIz != null) {
        paramVarArgs.e(6, this.KIz);
      }
      AppMethodBeat.o(194543);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.Brn) + 0 + g.a.a.b.b.a.r(2, this.Mhx);
      paramInt = i;
      if (this.jfM != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.jfM);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.LWr);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.UserName);
      }
      i = paramInt;
      if (this.KIz != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KIz);
      }
      AppMethodBeat.o(194543);
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
      AppMethodBeat.o(194543);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cbq localcbq = (cbq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(194543);
        return -1;
      case 1: 
        localcbq.Brn = locala.UbS.zl();
        AppMethodBeat.o(194543);
        return 0;
      case 2: 
        localcbq.Mhx = locala.UbS.zl();
        AppMethodBeat.o(194543);
        return 0;
      case 3: 
        localcbq.jfM = locala.UbS.readString();
        AppMethodBeat.o(194543);
        return 0;
      case 4: 
        localcbq.LWr = locala.UbS.zi();
        AppMethodBeat.o(194543);
        return 0;
      case 5: 
        localcbq.UserName = locala.UbS.readString();
        AppMethodBeat.o(194543);
        return 0;
      }
      localcbq.KIz = locala.UbS.readString();
      AppMethodBeat.o(194543);
      return 0;
    }
    AppMethodBeat.o(194543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbq
 * JD-Core Version:    0.7.0.1
 */