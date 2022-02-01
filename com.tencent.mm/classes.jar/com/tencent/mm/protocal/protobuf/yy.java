package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yy
  extends com.tencent.mm.bx.a
{
  public String YEb;
  public int YPt;
  public String ZeL;
  public String ZhA;
  public int Zhs;
  public String Zht;
  public int Zhu;
  public String Zhv;
  public String Zhw;
  public String Zhx;
  public String Zhy;
  public int Zhz;
  public String icon_url;
  public String xlJ;
  public int xlv;
  public String xlw;
  public String xmv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125715);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zhs);
      if (this.xmv != null) {
        paramVarArgs.g(2, this.xmv);
      }
      if (this.Zht != null) {
        paramVarArgs.g(3, this.Zht);
      }
      if (this.xlJ != null) {
        paramVarArgs.g(4, this.xlJ);
      }
      paramVarArgs.bS(5, this.YPt);
      if (this.ZeL != null) {
        paramVarArgs.g(6, this.ZeL);
      }
      paramVarArgs.bS(7, this.Zhu);
      if (this.icon_url != null) {
        paramVarArgs.g(8, this.icon_url);
      }
      if (this.YEb != null) {
        paramVarArgs.g(9, this.YEb);
      }
      paramVarArgs.bS(10, this.xlv);
      if (this.xlw != null) {
        paramVarArgs.g(11, this.xlw);
      }
      if (this.Zhv != null) {
        paramVarArgs.g(12, this.Zhv);
      }
      if (this.Zhw != null) {
        paramVarArgs.g(13, this.Zhw);
      }
      if (this.Zhx != null) {
        paramVarArgs.g(14, this.Zhx);
      }
      if (this.Zhy != null) {
        paramVarArgs.g(15, this.Zhy);
      }
      paramVarArgs.bS(16, this.Zhz);
      if (this.ZhA != null) {
        paramVarArgs.g(17, this.ZhA);
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Zhs) + 0;
      paramInt = i;
      if (this.xmv != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.xmv);
      }
      i = paramInt;
      if (this.Zht != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zht);
      }
      paramInt = i;
      if (this.xlJ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xlJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YPt);
      paramInt = i;
      if (this.ZeL != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZeL);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.Zhu);
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.icon_url);
      }
      i = paramInt;
      if (this.YEb != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YEb);
      }
      i += i.a.a.b.b.a.cJ(10, this.xlv);
      paramInt = i;
      if (this.xlw != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.xlw);
      }
      i = paramInt;
      if (this.Zhv != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.Zhv);
      }
      paramInt = i;
      if (this.Zhw != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.Zhw);
      }
      i = paramInt;
      if (this.Zhx != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.Zhx);
      }
      paramInt = i;
      if (this.Zhy != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.Zhy);
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.Zhz);
      paramInt = i;
      if (this.ZhA != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.ZhA);
      }
      AppMethodBeat.o(125715);
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
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      yy localyy = (yy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125715);
        return -1;
      case 1: 
        localyy.Zhs = locala.ajGk.aar();
        AppMethodBeat.o(125715);
        return 0;
      case 2: 
        localyy.xmv = locala.ajGk.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 3: 
        localyy.Zht = locala.ajGk.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 4: 
        localyy.xlJ = locala.ajGk.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 5: 
        localyy.YPt = locala.ajGk.aar();
        AppMethodBeat.o(125715);
        return 0;
      case 6: 
        localyy.ZeL = locala.ajGk.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 7: 
        localyy.Zhu = locala.ajGk.aar();
        AppMethodBeat.o(125715);
        return 0;
      case 8: 
        localyy.icon_url = locala.ajGk.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 9: 
        localyy.YEb = locala.ajGk.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 10: 
        localyy.xlv = locala.ajGk.aar();
        AppMethodBeat.o(125715);
        return 0;
      case 11: 
        localyy.xlw = locala.ajGk.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 12: 
        localyy.Zhv = locala.ajGk.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 13: 
        localyy.Zhw = locala.ajGk.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 14: 
        localyy.Zhx = locala.ajGk.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 15: 
        localyy.Zhy = locala.ajGk.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 16: 
        localyy.Zhz = locala.ajGk.aar();
        AppMethodBeat.o(125715);
        return 0;
      }
      localyy.ZhA = locala.ajGk.readString();
      AppMethodBeat.o(125715);
      return 0;
    }
    AppMethodBeat.o(125715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yy
 * JD-Core Version:    0.7.0.1
 */