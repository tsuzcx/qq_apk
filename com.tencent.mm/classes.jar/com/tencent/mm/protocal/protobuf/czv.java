package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czv
  extends com.tencent.mm.bw.a
{
  public String HYG;
  public String HZX;
  public long Iai;
  public long Iaj;
  public long Iak;
  public int Ial;
  public int Iam;
  public long Ian;
  public String IhY;
  public String MFc;
  public String MFd;
  public String MFe;
  public int MFf;
  public String dQx;
  public String icon;
  public String title;
  public String type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91578);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      if (this.icon != null) {
        paramVarArgs.e(3, this.icon);
      }
      if (this.IhY != null) {
        paramVarArgs.e(4, this.IhY);
      }
      if (this.HZX != null) {
        paramVarArgs.e(5, this.HZX);
      }
      if (this.MFc != null) {
        paramVarArgs.e(6, this.MFc);
      }
      if (this.type != null) {
        paramVarArgs.e(7, this.type);
      }
      if (this.title != null) {
        paramVarArgs.e(8, this.title);
      }
      paramVarArgs.bb(9, this.Iai);
      paramVarArgs.bb(10, this.Iaj);
      if (this.HYG != null) {
        paramVarArgs.e(11, this.HYG);
      }
      paramVarArgs.bb(12, this.Iak);
      paramVarArgs.aM(13, this.Ial);
      paramVarArgs.aM(14, this.Iam);
      if (this.MFd != null) {
        paramVarArgs.e(15, this.MFd);
      }
      if (this.MFe != null) {
        paramVarArgs.e(16, this.MFe);
      }
      paramVarArgs.bb(17, this.Ian);
      paramVarArgs.aM(18, this.MFf);
      AppMethodBeat.o(91578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1146;
      }
    }
    label1146:
    for (int i = g.a.a.b.b.a.f(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.icon);
      }
      paramInt = i;
      if (this.IhY != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.IhY);
      }
      i = paramInt;
      if (this.HZX != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.HZX);
      }
      paramInt = i;
      if (this.MFc != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MFc);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.type);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.title);
      }
      i = paramInt + g.a.a.b.b.a.r(9, this.Iai) + g.a.a.b.b.a.r(10, this.Iaj);
      paramInt = i;
      if (this.HYG != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.HYG);
      }
      i = paramInt + g.a.a.b.b.a.r(12, this.Iak) + g.a.a.b.b.a.bu(13, this.Ial) + g.a.a.b.b.a.bu(14, this.Iam);
      paramInt = i;
      if (this.MFd != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.MFd);
      }
      i = paramInt;
      if (this.MFe != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.MFe);
      }
      paramInt = g.a.a.b.b.a.r(17, this.Ian);
      int j = g.a.a.b.b.a.bu(18, this.MFf);
      AppMethodBeat.o(91578);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91578);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        czv localczv = (czv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91578);
          return -1;
        case 1: 
          localczv.url = locala.UbS.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 2: 
          localczv.dQx = locala.UbS.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 3: 
          localczv.icon = locala.UbS.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 4: 
          localczv.IhY = locala.UbS.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 5: 
          localczv.HZX = locala.UbS.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 6: 
          localczv.MFc = locala.UbS.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 7: 
          localczv.type = locala.UbS.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 8: 
          localczv.title = locala.UbS.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 9: 
          localczv.Iai = locala.UbS.zl();
          AppMethodBeat.o(91578);
          return 0;
        case 10: 
          localczv.Iaj = locala.UbS.zl();
          AppMethodBeat.o(91578);
          return 0;
        case 11: 
          localczv.HYG = locala.UbS.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 12: 
          localczv.Iak = locala.UbS.zl();
          AppMethodBeat.o(91578);
          return 0;
        case 13: 
          localczv.Ial = locala.UbS.zi();
          AppMethodBeat.o(91578);
          return 0;
        case 14: 
          localczv.Iam = locala.UbS.zi();
          AppMethodBeat.o(91578);
          return 0;
        case 15: 
          localczv.MFd = locala.UbS.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 16: 
          localczv.MFe = locala.UbS.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 17: 
          localczv.Ian = locala.UbS.zl();
          AppMethodBeat.o(91578);
          return 0;
        }
        localczv.MFf = locala.UbS.zi();
        AppMethodBeat.o(91578);
        return 0;
      }
      AppMethodBeat.o(91578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czv
 * JD-Core Version:    0.7.0.1
 */