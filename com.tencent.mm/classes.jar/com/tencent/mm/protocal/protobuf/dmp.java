package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmp
  extends com.tencent.mm.bx.a
{
  public int Tqb;
  public String aaSS;
  public String aaST;
  public String appid;
  public String icon_url;
  public String xkX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258797);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(2, this.icon_url);
      }
      if (this.aaSS != null) {
        paramVarArgs.g(3, this.aaSS);
      }
      if (this.aaST != null) {
        paramVarArgs.g(4, this.aaST);
      }
      paramVarArgs.bS(5, this.Tqb);
      if (this.xkX != null) {
        paramVarArgs.g(6, this.xkX);
      }
      AppMethodBeat.o(258797);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label498;
      }
    }
    label498:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.icon_url);
      }
      i = paramInt;
      if (this.aaSS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaSS);
      }
      paramInt = i;
      if (this.aaST != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaST);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.Tqb);
      paramInt = i;
      if (this.xkX != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.xkX);
      }
      AppMethodBeat.o(258797);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258797);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dmp localdmp = (dmp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258797);
          return -1;
        case 1: 
          localdmp.appid = locala.ajGk.readString();
          AppMethodBeat.o(258797);
          return 0;
        case 2: 
          localdmp.icon_url = locala.ajGk.readString();
          AppMethodBeat.o(258797);
          return 0;
        case 3: 
          localdmp.aaSS = locala.ajGk.readString();
          AppMethodBeat.o(258797);
          return 0;
        case 4: 
          localdmp.aaST = locala.ajGk.readString();
          AppMethodBeat.o(258797);
          return 0;
        case 5: 
          localdmp.Tqb = locala.ajGk.aar();
          AppMethodBeat.o(258797);
          return 0;
        }
        localdmp.xkX = locala.ajGk.readString();
        AppMethodBeat.o(258797);
        return 0;
      }
      AppMethodBeat.o(258797);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmp
 * JD-Core Version:    0.7.0.1
 */