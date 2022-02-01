package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mi
  extends com.tencent.mm.cd.a
{
  public int RRX;
  public String RRY;
  public String RRZ;
  public int RSa;
  public int RSb;
  public long RSc;
  public int h;
  public String token;
  public String url;
  public int w;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208012);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RRX);
      paramVarArgs.aY(2, this.w);
      paramVarArgs.aY(3, this.h);
      if (this.RRY != null) {
        paramVarArgs.f(4, this.RRY);
      }
      if (this.RRZ != null) {
        paramVarArgs.f(5, this.RRZ);
      }
      paramVarArgs.aY(6, this.RSa);
      if (this.url != null) {
        paramVarArgs.f(7, this.url);
      }
      if (this.token != null) {
        paramVarArgs.f(8, this.token);
      }
      paramVarArgs.aY(9, this.RSb);
      paramVarArgs.bm(10, this.RSc);
      AppMethodBeat.o(208012);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RRX) + 0 + g.a.a.b.b.a.bM(2, this.w) + g.a.a.b.b.a.bM(3, this.h);
      paramInt = i;
      if (this.RRY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RRY);
      }
      i = paramInt;
      if (this.RRZ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RRZ);
      }
      i += g.a.a.b.b.a.bM(6, this.RSa);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.url);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.token);
      }
      paramInt = g.a.a.b.b.a.bM(9, this.RSb);
      int j = g.a.a.b.b.a.p(10, this.RSc);
      AppMethodBeat.o(208012);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(208012);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      mi localmi = (mi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208012);
        return -1;
      case 1: 
        localmi.RRX = locala.abFh.AK();
        AppMethodBeat.o(208012);
        return 0;
      case 2: 
        localmi.w = locala.abFh.AK();
        AppMethodBeat.o(208012);
        return 0;
      case 3: 
        localmi.h = locala.abFh.AK();
        AppMethodBeat.o(208012);
        return 0;
      case 4: 
        localmi.RRY = locala.abFh.readString();
        AppMethodBeat.o(208012);
        return 0;
      case 5: 
        localmi.RRZ = locala.abFh.readString();
        AppMethodBeat.o(208012);
        return 0;
      case 6: 
        localmi.RSa = locala.abFh.AK();
        AppMethodBeat.o(208012);
        return 0;
      case 7: 
        localmi.url = locala.abFh.readString();
        AppMethodBeat.o(208012);
        return 0;
      case 8: 
        localmi.token = locala.abFh.readString();
        AppMethodBeat.o(208012);
        return 0;
      case 9: 
        localmi.RSb = locala.abFh.AK();
        AppMethodBeat.o(208012);
        return 0;
      }
      localmi.RSc = locala.abFh.AN();
      AppMethodBeat.o(208012);
      return 0;
    }
    AppMethodBeat.o(208012);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mi
 * JD-Core Version:    0.7.0.1
 */