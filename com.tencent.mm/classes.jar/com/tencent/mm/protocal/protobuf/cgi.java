package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgi
  extends com.tencent.mm.bv.a
{
  public int cpt;
  public String rCH;
  public int rpO;
  public String xRb;
  public String xRc;
  public int xRd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94632);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.rpO);
      if (this.xRb != null) {
        paramVarArgs.e(2, this.xRb);
      }
      if (this.xRc != null) {
        paramVarArgs.e(3, this.xRc);
      }
      paramVarArgs.aO(4, this.cpt);
      if (this.rCH != null) {
        paramVarArgs.e(5, this.rCH);
      }
      paramVarArgs.aO(6, this.xRd);
      AppMethodBeat.o(94632);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.rpO) + 0;
      paramInt = i;
      if (this.xRb != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xRb);
      }
      i = paramInt;
      if (this.xRc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xRc);
      }
      i += e.a.a.b.b.a.bl(4, this.cpt);
      paramInt = i;
      if (this.rCH != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.rCH);
      }
      i = e.a.a.b.b.a.bl(6, this.xRd);
      AppMethodBeat.o(94632);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94632);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cgi localcgi = (cgi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94632);
        return -1;
      case 1: 
        localcgi.rpO = locala.CLY.sl();
        AppMethodBeat.o(94632);
        return 0;
      case 2: 
        localcgi.xRb = locala.CLY.readString();
        AppMethodBeat.o(94632);
        return 0;
      case 3: 
        localcgi.xRc = locala.CLY.readString();
        AppMethodBeat.o(94632);
        return 0;
      case 4: 
        localcgi.cpt = locala.CLY.sl();
        AppMethodBeat.o(94632);
        return 0;
      case 5: 
        localcgi.rCH = locala.CLY.readString();
        AppMethodBeat.o(94632);
        return 0;
      }
      localcgi.xRd = locala.CLY.sl();
      AppMethodBeat.o(94632);
      return 0;
    }
    AppMethodBeat.o(94632);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgi
 * JD-Core Version:    0.7.0.1
 */