package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sa
  extends com.tencent.mm.cd.a
{
  public String OQG;
  public String Pap;
  public String RFn;
  public String RFo;
  public int RGT;
  public String icon;
  public String title;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91383);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.Pap != null) {
        paramVarArgs.f(2, this.Pap);
      }
      if (this.icon != null) {
        paramVarArgs.f(3, this.icon);
      }
      if (this.title != null) {
        paramVarArgs.f(4, this.title);
      }
      if (this.OQG != null) {
        paramVarArgs.f(5, this.OQG);
      }
      if (this.url != null) {
        paramVarArgs.f(6, this.url);
      }
      if (this.RFn != null) {
        paramVarArgs.f(7, this.RFn);
      }
      if (this.RFo != null) {
        paramVarArgs.f(8, this.RFo);
      }
      paramVarArgs.aY(9, this.RGT);
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.Pap != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Pap);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.icon);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.title);
      }
      i = paramInt;
      if (this.OQG != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.OQG);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.url);
      }
      i = paramInt;
      if (this.RFn != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RFn);
      }
      paramInt = i;
      if (this.RFo != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RFo);
      }
      i = g.a.a.b.b.a.bM(9, this.RGT);
      AppMethodBeat.o(91383);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      sa localsa = (sa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91383);
        return -1;
      case 1: 
        localsa.type = locala.abFh.AK();
        AppMethodBeat.o(91383);
        return 0;
      case 2: 
        localsa.Pap = locala.abFh.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 3: 
        localsa.icon = locala.abFh.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 4: 
        localsa.title = locala.abFh.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 5: 
        localsa.OQG = locala.abFh.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 6: 
        localsa.url = locala.abFh.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 7: 
        localsa.RFn = locala.abFh.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 8: 
        localsa.RFo = locala.abFh.readString();
        AppMethodBeat.o(91383);
        return 0;
      }
      localsa.RGT = locala.abFh.AK();
      AppMethodBeat.o(91383);
      return 0;
    }
    AppMethodBeat.o(91383);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sa
 * JD-Core Version:    0.7.0.1
 */