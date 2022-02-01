package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djj
  extends com.tencent.mm.cd.a
{
  public String OQG;
  public String ORY;
  public long OSt;
  public long OSu;
  public long OSv;
  public int OSw;
  public int OSx;
  public long OSy;
  public String Pap;
  public String TQO;
  public String TQP;
  public String TQQ;
  public int TQR;
  public String icon;
  public String title;
  public String type;
  public String url;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91578);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      if (this.icon != null) {
        paramVarArgs.f(3, this.icon);
      }
      if (this.Pap != null) {
        paramVarArgs.f(4, this.Pap);
      }
      if (this.ORY != null) {
        paramVarArgs.f(5, this.ORY);
      }
      if (this.TQO != null) {
        paramVarArgs.f(6, this.TQO);
      }
      if (this.type != null) {
        paramVarArgs.f(7, this.type);
      }
      if (this.title != null) {
        paramVarArgs.f(8, this.title);
      }
      paramVarArgs.bm(9, this.OSt);
      paramVarArgs.bm(10, this.OSu);
      if (this.OQG != null) {
        paramVarArgs.f(11, this.OQG);
      }
      paramVarArgs.bm(12, this.OSv);
      paramVarArgs.aY(13, this.OSw);
      paramVarArgs.aY(14, this.OSx);
      if (this.TQP != null) {
        paramVarArgs.f(15, this.TQP);
      }
      if (this.TQQ != null) {
        paramVarArgs.f(16, this.TQQ);
      }
      paramVarArgs.bm(17, this.OSy);
      paramVarArgs.aY(18, this.TQR);
      AppMethodBeat.o(91578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1146;
      }
    }
    label1146:
    for (int i = g.a.a.b.b.a.g(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.icon);
      }
      paramInt = i;
      if (this.Pap != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Pap);
      }
      i = paramInt;
      if (this.ORY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.ORY);
      }
      paramInt = i;
      if (this.TQO != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TQO);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.type);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.title);
      }
      i = paramInt + g.a.a.b.b.a.p(9, this.OSt) + g.a.a.b.b.a.p(10, this.OSu);
      paramInt = i;
      if (this.OQG != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.OQG);
      }
      i = paramInt + g.a.a.b.b.a.p(12, this.OSv) + g.a.a.b.b.a.bM(13, this.OSw) + g.a.a.b.b.a.bM(14, this.OSx);
      paramInt = i;
      if (this.TQP != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.TQP);
      }
      i = paramInt;
      if (this.TQQ != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.TQQ);
      }
      paramInt = g.a.a.b.b.a.p(17, this.OSy);
      int j = g.a.a.b.b.a.bM(18, this.TQR);
      AppMethodBeat.o(91578);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91578);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        djj localdjj = (djj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91578);
          return -1;
        case 1: 
          localdjj.url = locala.abFh.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 2: 
          localdjj.wording = locala.abFh.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 3: 
          localdjj.icon = locala.abFh.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 4: 
          localdjj.Pap = locala.abFh.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 5: 
          localdjj.ORY = locala.abFh.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 6: 
          localdjj.TQO = locala.abFh.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 7: 
          localdjj.type = locala.abFh.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 8: 
          localdjj.title = locala.abFh.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 9: 
          localdjj.OSt = locala.abFh.AN();
          AppMethodBeat.o(91578);
          return 0;
        case 10: 
          localdjj.OSu = locala.abFh.AN();
          AppMethodBeat.o(91578);
          return 0;
        case 11: 
          localdjj.OQG = locala.abFh.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 12: 
          localdjj.OSv = locala.abFh.AN();
          AppMethodBeat.o(91578);
          return 0;
        case 13: 
          localdjj.OSw = locala.abFh.AK();
          AppMethodBeat.o(91578);
          return 0;
        case 14: 
          localdjj.OSx = locala.abFh.AK();
          AppMethodBeat.o(91578);
          return 0;
        case 15: 
          localdjj.TQP = locala.abFh.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 16: 
          localdjj.TQQ = locala.abFh.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 17: 
          localdjj.OSy = locala.abFh.AN();
          AppMethodBeat.o(91578);
          return 0;
        }
        localdjj.TQR = locala.abFh.AK();
        AppMethodBeat.o(91578);
        return 0;
      }
      AppMethodBeat.o(91578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djj
 * JD-Core Version:    0.7.0.1
 */