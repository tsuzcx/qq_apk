package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgw
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public String ntu;
  public String nul;
  public String num;
  public int xNX;
  public int xNY;
  public int xOc;
  public String xRE;
  public String xRF;
  public int xRG;
  public int xRH;
  public int xRI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56503);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.Id);
      if (this.num != null) {
        paramVarArgs.e(2, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(3, this.nul);
      }
      if (this.xRE != null) {
        paramVarArgs.e(4, this.xRE);
      }
      if (this.xRF != null) {
        paramVarArgs.e(5, this.xRF);
      }
      paramVarArgs.aO(6, this.CreateTime);
      if (this.ntu != null) {
        paramVarArgs.e(7, this.ntu);
      }
      paramVarArgs.aO(8, this.xRG);
      paramVarArgs.aO(9, this.xOc);
      paramVarArgs.aO(10, this.xNX);
      paramVarArgs.aO(11, this.xNY);
      paramVarArgs.aO(12, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.e(13, this.ThumbUrl);
      }
      paramVarArgs.aO(14, this.xRH);
      paramVarArgs.aO(15, this.xRI);
      AppMethodBeat.o(56503);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.num != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.num);
      }
      i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nul);
      }
      paramInt = i;
      if (this.xRE != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xRE);
      }
      i = paramInt;
      if (this.xRF != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xRF);
      }
      i += e.a.a.b.b.a.bl(6, this.CreateTime);
      paramInt = i;
      if (this.ntu != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.ntu);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.xRG) + e.a.a.b.b.a.bl(9, this.xOc) + e.a.a.b.b.a.bl(10, this.xNX) + e.a.a.b.b.a.bl(11, this.xNY) + e.a.a.b.b.a.bl(12, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.ThumbUrl);
      }
      i = e.a.a.b.b.a.bl(14, this.xRH);
      int j = e.a.a.b.b.a.bl(15, this.xRI);
      AppMethodBeat.o(56503);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56503);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cgw localcgw = (cgw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56503);
        return -1;
      case 1: 
        localcgw.Id = locala.CLY.sm();
        AppMethodBeat.o(56503);
        return 0;
      case 2: 
        localcgw.num = locala.CLY.readString();
        AppMethodBeat.o(56503);
        return 0;
      case 3: 
        localcgw.nul = locala.CLY.readString();
        AppMethodBeat.o(56503);
        return 0;
      case 4: 
        localcgw.xRE = locala.CLY.readString();
        AppMethodBeat.o(56503);
        return 0;
      case 5: 
        localcgw.xRF = locala.CLY.readString();
        AppMethodBeat.o(56503);
        return 0;
      case 6: 
        localcgw.CreateTime = locala.CLY.sl();
        AppMethodBeat.o(56503);
        return 0;
      case 7: 
        localcgw.ntu = locala.CLY.readString();
        AppMethodBeat.o(56503);
        return 0;
      case 8: 
        localcgw.xRG = locala.CLY.sl();
        AppMethodBeat.o(56503);
        return 0;
      case 9: 
        localcgw.xOc = locala.CLY.sl();
        AppMethodBeat.o(56503);
        return 0;
      case 10: 
        localcgw.xNX = locala.CLY.sl();
        AppMethodBeat.o(56503);
        return 0;
      case 11: 
        localcgw.xNY = locala.CLY.sl();
        AppMethodBeat.o(56503);
        return 0;
      case 12: 
        localcgw.IsNotRichText = locala.CLY.sl();
        AppMethodBeat.o(56503);
        return 0;
      case 13: 
        localcgw.ThumbUrl = locala.CLY.readString();
        AppMethodBeat.o(56503);
        return 0;
      case 14: 
        localcgw.xRH = locala.CLY.sl();
        AppMethodBeat.o(56503);
        return 0;
      }
      localcgw.xRI = locala.CLY.sl();
      AppMethodBeat.o(56503);
      return 0;
    }
    AppMethodBeat.o(56503);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgw
 * JD-Core Version:    0.7.0.1
 */