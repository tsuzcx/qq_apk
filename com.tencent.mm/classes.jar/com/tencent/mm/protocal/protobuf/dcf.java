package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dcf
  extends com.tencent.mm.bx.a
{
  public long Zmx;
  public long aaHU;
  public String aaHV;
  public String aaHW;
  public b aaHX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259329);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaHU);
      paramVarArgs.bv(2, this.Zmx);
      if (this.aaHV != null) {
        paramVarArgs.g(3, this.aaHV);
      }
      if (this.aaHW != null) {
        paramVarArgs.g(4, this.aaHW);
      }
      if (this.aaHX != null) {
        paramVarArgs.d(5, this.aaHX);
      }
      AppMethodBeat.o(259329);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.aaHU) + 0 + i.a.a.b.b.a.q(2, this.Zmx);
      paramInt = i;
      if (this.aaHV != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aaHV);
      }
      i = paramInt;
      if (this.aaHW != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaHW);
      }
      paramInt = i;
      if (this.aaHX != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.aaHX);
      }
      AppMethodBeat.o(259329);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259329);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dcf localdcf = (dcf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259329);
        return -1;
      case 1: 
        localdcf.aaHU = locala.ajGk.aaw();
        AppMethodBeat.o(259329);
        return 0;
      case 2: 
        localdcf.Zmx = locala.ajGk.aaw();
        AppMethodBeat.o(259329);
        return 0;
      case 3: 
        localdcf.aaHV = locala.ajGk.readString();
        AppMethodBeat.o(259329);
        return 0;
      case 4: 
        localdcf.aaHW = locala.ajGk.readString();
        AppMethodBeat.o(259329);
        return 0;
      }
      localdcf.aaHX = locala.ajGk.kFX();
      AppMethodBeat.o(259329);
      return 0;
    }
    AppMethodBeat.o(259329);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcf
 * JD-Core Version:    0.7.0.1
 */