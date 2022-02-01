package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fie
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String IMg;
  public String IMh;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public int abDg;
  public int abDh;
  public int abDl;
  public String abIW;
  public String abIX;
  public int abIY;
  public int abIZ;
  public int abJa;
  public String nUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118438);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Id);
      if (this.IMh != null) {
        paramVarArgs.g(2, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(3, this.IMg);
      }
      if (this.abIW != null) {
        paramVarArgs.g(4, this.abIW);
      }
      if (this.abIX != null) {
        paramVarArgs.g(5, this.abIX);
      }
      paramVarArgs.bS(6, this.CreateTime);
      if (this.nUB != null) {
        paramVarArgs.g(7, this.nUB);
      }
      paramVarArgs.bS(8, this.abIY);
      paramVarArgs.bS(9, this.abDl);
      paramVarArgs.bS(10, this.abDg);
      paramVarArgs.bS(11, this.abDh);
      paramVarArgs.bS(12, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.g(13, this.ThumbUrl);
      }
      paramVarArgs.bS(14, this.abIZ);
      paramVarArgs.bS(15, this.abJa);
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.Id) + 0;
      paramInt = i;
      if (this.IMh != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IMh);
      }
      i = paramInt;
      if (this.IMg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IMg);
      }
      paramInt = i;
      if (this.abIW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abIW);
      }
      i = paramInt;
      if (this.abIX != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abIX);
      }
      i += i.a.a.b.b.a.cJ(6, this.CreateTime);
      paramInt = i;
      if (this.nUB != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.nUB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.abIY) + i.a.a.b.b.a.cJ(9, this.abDl) + i.a.a.b.b.a.cJ(10, this.abDg) + i.a.a.b.b.a.cJ(11, this.abDh) + i.a.a.b.b.a.cJ(12, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.ThumbUrl);
      }
      i = i.a.a.b.b.a.cJ(14, this.abIZ);
      int j = i.a.a.b.b.a.cJ(15, this.abJa);
      AppMethodBeat.o(118438);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fie localfie = (fie)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118438);
        return -1;
      case 1: 
        localfie.Id = locala.ajGk.aaw();
        AppMethodBeat.o(118438);
        return 0;
      case 2: 
        localfie.IMh = locala.ajGk.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 3: 
        localfie.IMg = locala.ajGk.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 4: 
        localfie.abIW = locala.ajGk.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 5: 
        localfie.abIX = locala.ajGk.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 6: 
        localfie.CreateTime = locala.ajGk.aar();
        AppMethodBeat.o(118438);
        return 0;
      case 7: 
        localfie.nUB = locala.ajGk.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 8: 
        localfie.abIY = locala.ajGk.aar();
        AppMethodBeat.o(118438);
        return 0;
      case 9: 
        localfie.abDl = locala.ajGk.aar();
        AppMethodBeat.o(118438);
        return 0;
      case 10: 
        localfie.abDg = locala.ajGk.aar();
        AppMethodBeat.o(118438);
        return 0;
      case 11: 
        localfie.abDh = locala.ajGk.aar();
        AppMethodBeat.o(118438);
        return 0;
      case 12: 
        localfie.IsNotRichText = locala.ajGk.aar();
        AppMethodBeat.o(118438);
        return 0;
      case 13: 
        localfie.ThumbUrl = locala.ajGk.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 14: 
        localfie.abIZ = locala.ajGk.aar();
        AppMethodBeat.o(118438);
        return 0;
      }
      localfie.abJa = locala.ajGk.aar();
      AppMethodBeat.o(118438);
      return 0;
    }
    AppMethodBeat.o(118438);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fie
 * JD-Core Version:    0.7.0.1
 */