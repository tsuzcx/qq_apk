package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tl
  extends com.tencent.mm.bx.a
{
  public String VGA;
  public String VQT;
  public String YBP;
  public String YBQ;
  public int YDV;
  public String icon;
  public String title;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91383);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.VQT != null) {
        paramVarArgs.g(2, this.VQT);
      }
      if (this.icon != null) {
        paramVarArgs.g(3, this.icon);
      }
      if (this.title != null) {
        paramVarArgs.g(4, this.title);
      }
      if (this.VGA != null) {
        paramVarArgs.g(5, this.VGA);
      }
      if (this.url != null) {
        paramVarArgs.g(6, this.url);
      }
      if (this.YBP != null) {
        paramVarArgs.g(7, this.YBP);
      }
      if (this.YBQ != null) {
        paramVarArgs.g(8, this.YBQ);
      }
      paramVarArgs.bS(9, this.YDV);
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.VQT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.VQT);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icon);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.title);
      }
      i = paramInt;
      if (this.VGA != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.VGA);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.url);
      }
      i = paramInt;
      if (this.YBP != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YBP);
      }
      paramInt = i;
      if (this.YBQ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YBQ);
      }
      i = i.a.a.b.b.a.cJ(9, this.YDV);
      AppMethodBeat.o(91383);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      tl localtl = (tl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91383);
        return -1;
      case 1: 
        localtl.type = locala.ajGk.aar();
        AppMethodBeat.o(91383);
        return 0;
      case 2: 
        localtl.VQT = locala.ajGk.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 3: 
        localtl.icon = locala.ajGk.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 4: 
        localtl.title = locala.ajGk.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 5: 
        localtl.VGA = locala.ajGk.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 6: 
        localtl.url = locala.ajGk.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 7: 
        localtl.YBP = locala.ajGk.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 8: 
        localtl.YBQ = locala.ajGk.readString();
        AppMethodBeat.o(91383);
        return 0;
      }
      localtl.YDV = locala.ajGk.aar();
      AppMethodBeat.o(91383);
      return 0;
    }
    AppMethodBeat.o(91383);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tl
 * JD-Core Version:    0.7.0.1
 */