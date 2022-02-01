package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dri
  extends com.tencent.mm.bx.a
{
  public String Okt;
  public long aaXf;
  public String aaXg;
  public String aaXh;
  public long ihV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260219);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaXf);
      if (this.Okt != null) {
        paramVarArgs.g(2, this.Okt);
      }
      paramVarArgs.bv(3, this.ihV);
      if (this.aaXg != null) {
        paramVarArgs.g(4, this.aaXg);
      }
      if (this.aaXh != null) {
        paramVarArgs.g(5, this.aaXh);
      }
      AppMethodBeat.o(260219);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.aaXf) + 0;
      paramInt = i;
      if (this.Okt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Okt);
      }
      i = paramInt + i.a.a.b.b.a.q(3, this.ihV);
      paramInt = i;
      if (this.aaXg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaXg);
      }
      i = paramInt;
      if (this.aaXh != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaXh);
      }
      AppMethodBeat.o(260219);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260219);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dri localdri = (dri)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260219);
        return -1;
      case 1: 
        localdri.aaXf = locala.ajGk.aaw();
        AppMethodBeat.o(260219);
        return 0;
      case 2: 
        localdri.Okt = locala.ajGk.readString();
        AppMethodBeat.o(260219);
        return 0;
      case 3: 
        localdri.ihV = locala.ajGk.aaw();
        AppMethodBeat.o(260219);
        return 0;
      case 4: 
        localdri.aaXg = locala.ajGk.readString();
        AppMethodBeat.o(260219);
        return 0;
      }
      localdri.aaXh = locala.ajGk.readString();
      AppMethodBeat.o(260219);
      return 0;
    }
    AppMethodBeat.o(260219);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dri
 * JD-Core Version:    0.7.0.1
 */