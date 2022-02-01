package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class km
  extends com.tencent.mm.bx.a
{
  public int IHj;
  public LinkedList<String> YMx;
  public b YMy;
  public int crs;
  public int nUz;
  
  public km()
  {
    AppMethodBeat.i(104755);
    this.YMx = new LinkedList();
    this.IHj = 0;
    AppMethodBeat.o(104755);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104756);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.crs);
      paramVarArgs.bS(2, this.nUz);
      paramVarArgs.e(3, 1, this.YMx);
      paramVarArgs.bS(4, this.IHj);
      if (this.YMy != null) {
        paramVarArgs.d(5, this.YMy);
      }
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.crs) + 0 + i.a.a.b.b.a.cJ(2, this.nUz) + i.a.a.a.c(3, 1, this.YMx) + i.a.a.b.b.a.cJ(4, this.IHj);
      paramInt = i;
      if (this.YMy != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.YMy);
      }
      AppMethodBeat.o(104756);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YMx.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      km localkm = (km)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104756);
        return -1;
      case 1: 
        localkm.crs = locala.ajGk.aar();
        AppMethodBeat.o(104756);
        return 0;
      case 2: 
        localkm.nUz = locala.ajGk.aar();
        AppMethodBeat.o(104756);
        return 0;
      case 3: 
        localkm.YMx.add(locala.ajGk.readString());
        AppMethodBeat.o(104756);
        return 0;
      case 4: 
        localkm.IHj = locala.ajGk.aar();
        AppMethodBeat.o(104756);
        return 0;
      }
      localkm.YMy = locala.ajGk.kFX();
      AppMethodBeat.o(104756);
      return 0;
    }
    AppMethodBeat.o(104756);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.km
 * JD-Core Version:    0.7.0.1
 */