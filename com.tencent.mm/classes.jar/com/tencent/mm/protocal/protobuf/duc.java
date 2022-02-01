package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duc
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String YNN;
  public String Zpa;
  public int ZvY;
  public int aaIA;
  public String aaZD;
  public String vhX;
  public int yth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155445);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.yth);
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.YNN != null) {
        paramVarArgs.g(3, this.YNN);
      }
      if (this.Zpa != null) {
        paramVarArgs.g(4, this.Zpa);
      }
      if (this.UserName != null) {
        paramVarArgs.g(5, this.UserName);
      }
      paramVarArgs.bS(6, this.aaIA);
      paramVarArgs.bS(7, this.ZvY);
      if (this.aaZD != null) {
        paramVarArgs.g(8, this.aaZD);
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.yth) + 0;
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.YNN != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YNN);
      }
      paramInt = i;
      if (this.Zpa != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zpa);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.UserName);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.aaIA) + i.a.a.b.b.a.cJ(7, this.ZvY);
      paramInt = i;
      if (this.aaZD != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaZD);
      }
      AppMethodBeat.o(155445);
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
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      duc localduc = (duc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155445);
        return -1;
      case 1: 
        localduc.yth = locala.ajGk.aar();
        AppMethodBeat.o(155445);
        return 0;
      case 2: 
        localduc.vhX = locala.ajGk.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 3: 
        localduc.YNN = locala.ajGk.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 4: 
        localduc.Zpa = locala.ajGk.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 5: 
        localduc.UserName = locala.ajGk.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 6: 
        localduc.aaIA = locala.ajGk.aar();
        AppMethodBeat.o(155445);
        return 0;
      case 7: 
        localduc.ZvY = locala.ajGk.aar();
        AppMethodBeat.o(155445);
        return 0;
      }
      localduc.aaZD = locala.ajGk.readString();
      AppMethodBeat.o(155445);
      return 0;
    }
    AppMethodBeat.o(155445);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duc
 * JD-Core Version:    0.7.0.1
 */