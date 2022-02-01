package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eio
  extends com.tencent.mm.bw.a
{
  public String NhJ;
  public String NhK;
  public String appId;
  public String desc;
  public String ecK;
  public String title;
  public String uNR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153000);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.ecK != null) {
        paramVarArgs.e(3, this.ecK);
      }
      if (this.NhJ != null) {
        paramVarArgs.e(4, this.NhJ);
      }
      if (this.NhK != null) {
        paramVarArgs.e(5, this.NhK);
      }
      if (this.appId != null) {
        paramVarArgs.e(6, this.appId);
      }
      if (this.uNR != null) {
        paramVarArgs.e(7, this.uNR);
      }
      AppMethodBeat.o(153000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.ecK != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ecK);
      }
      paramInt = i;
      if (this.NhJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NhJ);
      }
      i = paramInt;
      if (this.NhK != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.NhK);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.appId);
      }
      i = paramInt;
      if (this.uNR != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.uNR);
      }
      AppMethodBeat.o(153000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153000);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eio localeio = (eio)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153000);
          return -1;
        case 1: 
          localeio.title = locala.UbS.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 2: 
          localeio.desc = locala.UbS.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 3: 
          localeio.ecK = locala.UbS.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 4: 
          localeio.NhJ = locala.UbS.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 5: 
          localeio.NhK = locala.UbS.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 6: 
          localeio.appId = locala.UbS.readString();
          AppMethodBeat.o(153000);
          return 0;
        }
        localeio.uNR = locala.UbS.readString();
        AppMethodBeat.o(153000);
        return 0;
      }
      AppMethodBeat.o(153000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eio
 * JD-Core Version:    0.7.0.1
 */