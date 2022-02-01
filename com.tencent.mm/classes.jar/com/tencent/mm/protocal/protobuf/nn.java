package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nn
  extends com.tencent.mm.bx.a
{
  public int YPA;
  public int YPB;
  public long YPC;
  public int YPx;
  public String YPy;
  public String YPz;
  public int h;
  public String token;
  public String url;
  public int w;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258554);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YPx);
      paramVarArgs.bS(2, this.w);
      paramVarArgs.bS(3, this.h);
      if (this.YPy != null) {
        paramVarArgs.g(4, this.YPy);
      }
      if (this.YPz != null) {
        paramVarArgs.g(5, this.YPz);
      }
      paramVarArgs.bS(6, this.YPA);
      if (this.url != null) {
        paramVarArgs.g(7, this.url);
      }
      if (this.token != null) {
        paramVarArgs.g(8, this.token);
      }
      paramVarArgs.bS(9, this.YPB);
      paramVarArgs.bv(10, this.YPC);
      AppMethodBeat.o(258554);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YPx) + 0 + i.a.a.b.b.a.cJ(2, this.w) + i.a.a.b.b.a.cJ(3, this.h);
      paramInt = i;
      if (this.YPy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YPy);
      }
      i = paramInt;
      if (this.YPz != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YPz);
      }
      i += i.a.a.b.b.a.cJ(6, this.YPA);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.url);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.token);
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.YPB);
      int j = i.a.a.b.b.a.q(10, this.YPC);
      AppMethodBeat.o(258554);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258554);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      nn localnn = (nn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258554);
        return -1;
      case 1: 
        localnn.YPx = locala.ajGk.aar();
        AppMethodBeat.o(258554);
        return 0;
      case 2: 
        localnn.w = locala.ajGk.aar();
        AppMethodBeat.o(258554);
        return 0;
      case 3: 
        localnn.h = locala.ajGk.aar();
        AppMethodBeat.o(258554);
        return 0;
      case 4: 
        localnn.YPy = locala.ajGk.readString();
        AppMethodBeat.o(258554);
        return 0;
      case 5: 
        localnn.YPz = locala.ajGk.readString();
        AppMethodBeat.o(258554);
        return 0;
      case 6: 
        localnn.YPA = locala.ajGk.aar();
        AppMethodBeat.o(258554);
        return 0;
      case 7: 
        localnn.url = locala.ajGk.readString();
        AppMethodBeat.o(258554);
        return 0;
      case 8: 
        localnn.token = locala.ajGk.readString();
        AppMethodBeat.o(258554);
        return 0;
      case 9: 
        localnn.YPB = locala.ajGk.aar();
        AppMethodBeat.o(258554);
        return 0;
      }
      localnn.YPC = locala.ajGk.aaw();
      AppMethodBeat.o(258554);
      return 0;
    }
    AppMethodBeat.o(258554);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nn
 * JD-Core Version:    0.7.0.1
 */