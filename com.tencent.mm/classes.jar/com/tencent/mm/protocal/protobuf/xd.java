package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class xd
  extends com.tencent.mm.bx.a
{
  public String YIZ;
  public String Zdw;
  public String Zdx;
  public long ZeU;
  public String ZeV;
  public String ZeW;
  public String ZeX;
  public String icon_url;
  public String lym;
  public String mdD;
  public String title;
  public String url;
  public String wsz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113980);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.wsz != null) {
        paramVarArgs.g(2, this.wsz);
      }
      if (this.lym != null) {
        paramVarArgs.g(3, this.lym);
      }
      if (this.url != null) {
        paramVarArgs.g(4, this.url);
      }
      paramVarArgs.bv(5, this.ZeU);
      if (this.ZeV != null) {
        paramVarArgs.g(6, this.ZeV);
      }
      if (this.ZeW != null) {
        paramVarArgs.g(7, this.ZeW);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(8, this.icon_url);
      }
      if (this.Zdw != null) {
        paramVarArgs.g(9, this.Zdw);
      }
      if (this.Zdx != null) {
        paramVarArgs.g(10, this.Zdx);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(11, this.YIZ);
      }
      if (this.ZeX != null) {
        paramVarArgs.g(12, this.ZeX);
      }
      if (this.mdD != null) {
        paramVarArgs.g(13, this.mdD);
      }
      AppMethodBeat.o(113980);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label930;
      }
    }
    label930:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wsz != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wsz);
      }
      i = paramInt;
      if (this.lym != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.lym);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.url);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.ZeU);
      paramInt = i;
      if (this.ZeV != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZeV);
      }
      i = paramInt;
      if (this.ZeW != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZeW);
      }
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.icon_url);
      }
      i = paramInt;
      if (this.Zdw != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.Zdw);
      }
      paramInt = i;
      if (this.Zdx != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.Zdx);
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.YIZ);
      }
      paramInt = i;
      if (this.ZeX != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ZeX);
      }
      i = paramInt;
      if (this.mdD != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.mdD);
      }
      AppMethodBeat.o(113980);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113980);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        xd localxd = (xd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113980);
          return -1;
        case 1: 
          localxd.title = locala.ajGk.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 2: 
          localxd.wsz = locala.ajGk.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 3: 
          localxd.lym = locala.ajGk.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 4: 
          localxd.url = locala.ajGk.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 5: 
          localxd.ZeU = locala.ajGk.aaw();
          AppMethodBeat.o(113980);
          return 0;
        case 6: 
          localxd.ZeV = locala.ajGk.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 7: 
          localxd.ZeW = locala.ajGk.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 8: 
          localxd.icon_url = locala.ajGk.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 9: 
          localxd.Zdw = locala.ajGk.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 10: 
          localxd.Zdx = locala.ajGk.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 11: 
          localxd.YIZ = locala.ajGk.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 12: 
          localxd.ZeX = locala.ajGk.readString();
          AppMethodBeat.o(113980);
          return 0;
        }
        localxd.mdD = locala.ajGk.readString();
        AppMethodBeat.o(113980);
        return 0;
      }
      AppMethodBeat.o(113980);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xd
 * JD-Core Version:    0.7.0.1
 */