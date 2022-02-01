package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnr
  extends com.tencent.mm.bx.a
{
  public int ZIA;
  public int ZIB;
  public int ZIy;
  public int ZIz;
  public int aaUT;
  public int aaUU;
  public int aaUV;
  public int aaUW;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258444);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.scene);
      paramVarArgs.bS(2, this.ZIy);
      paramVarArgs.bS(3, this.aaUT);
      paramVarArgs.bS(4, this.aaUU);
      paramVarArgs.bS(5, this.ZIz);
      paramVarArgs.bS(6, this.ZIA);
      paramVarArgs.bS(7, this.ZIB);
      paramVarArgs.bS(8, this.aaUV);
      paramVarArgs.bS(9, this.aaUW);
      AppMethodBeat.o(258444);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.scene);
      int i = i.a.a.b.b.a.cJ(2, this.ZIy);
      int j = i.a.a.b.b.a.cJ(3, this.aaUT);
      int k = i.a.a.b.b.a.cJ(4, this.aaUU);
      int m = i.a.a.b.b.a.cJ(5, this.ZIz);
      int n = i.a.a.b.b.a.cJ(6, this.ZIA);
      int i1 = i.a.a.b.b.a.cJ(7, this.ZIB);
      int i2 = i.a.a.b.b.a.cJ(8, this.aaUV);
      int i3 = i.a.a.b.b.a.cJ(9, this.aaUW);
      AppMethodBeat.o(258444);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258444);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dnr localdnr = (dnr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258444);
        return -1;
      case 1: 
        localdnr.scene = locala.ajGk.aar();
        AppMethodBeat.o(258444);
        return 0;
      case 2: 
        localdnr.ZIy = locala.ajGk.aar();
        AppMethodBeat.o(258444);
        return 0;
      case 3: 
        localdnr.aaUT = locala.ajGk.aar();
        AppMethodBeat.o(258444);
        return 0;
      case 4: 
        localdnr.aaUU = locala.ajGk.aar();
        AppMethodBeat.o(258444);
        return 0;
      case 5: 
        localdnr.ZIz = locala.ajGk.aar();
        AppMethodBeat.o(258444);
        return 0;
      case 6: 
        localdnr.ZIA = locala.ajGk.aar();
        AppMethodBeat.o(258444);
        return 0;
      case 7: 
        localdnr.ZIB = locala.ajGk.aar();
        AppMethodBeat.o(258444);
        return 0;
      case 8: 
        localdnr.aaUV = locala.ajGk.aar();
        AppMethodBeat.o(258444);
        return 0;
      }
      localdnr.aaUW = locala.ajGk.aar();
      AppMethodBeat.o(258444);
      return 0;
    }
    AppMethodBeat.o(258444);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnr
 * JD-Core Version:    0.7.0.1
 */