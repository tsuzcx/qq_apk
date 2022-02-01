package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ess
  extends com.tencent.mm.cd.a
{
  public int Pyz;
  public int PzF;
  public int PzG;
  public int PzH;
  public long Uuu;
  public int Uuv;
  public long Uuw;
  public String extInfo;
  public String icon;
  public int mbp;
  public long mcX;
  public String msgId;
  public int priority;
  public int showFlag;
  public String text;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153002);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.msgId != null) {
        paramVarArgs.f(1, this.msgId);
      }
      paramVarArgs.aY(2, this.PzF);
      paramVarArgs.aY(3, this.PzG);
      paramVarArgs.bm(4, this.mcX);
      paramVarArgs.aY(5, this.Pyz);
      paramVarArgs.aY(6, this.type);
      if (this.text != null) {
        paramVarArgs.f(7, this.text);
      }
      if (this.icon != null) {
        paramVarArgs.f(8, this.icon);
      }
      paramVarArgs.bm(9, this.Uuu);
      paramVarArgs.aY(10, this.PzH);
      paramVarArgs.aY(11, this.Uuv);
      paramVarArgs.bm(12, this.Uuw);
      paramVarArgs.aY(13, this.showFlag);
      paramVarArgs.aY(14, this.mbp);
      if (this.extInfo != null) {
        paramVarArgs.f(15, this.extInfo);
      }
      paramVarArgs.aY(16, this.priority);
      AppMethodBeat.o(153002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.msgId == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = g.a.a.b.b.a.g(1, this.msgId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.PzF) + g.a.a.b.b.a.bM(3, this.PzG) + g.a.a.b.b.a.p(4, this.mcX) + g.a.a.b.b.a.bM(5, this.Pyz) + g.a.a.b.b.a.bM(6, this.type);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.text);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.icon);
      }
      i = i + g.a.a.b.b.a.p(9, this.Uuu) + g.a.a.b.b.a.bM(10, this.PzH) + g.a.a.b.b.a.bM(11, this.Uuv) + g.a.a.b.b.a.p(12, this.Uuw) + g.a.a.b.b.a.bM(13, this.showFlag) + g.a.a.b.b.a.bM(14, this.mbp);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.extInfo);
      }
      i = g.a.a.b.b.a.bM(16, this.priority);
      AppMethodBeat.o(153002);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153002);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ess localess = (ess)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153002);
          return -1;
        case 1: 
          localess.msgId = locala.abFh.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 2: 
          localess.PzF = locala.abFh.AK();
          AppMethodBeat.o(153002);
          return 0;
        case 3: 
          localess.PzG = locala.abFh.AK();
          AppMethodBeat.o(153002);
          return 0;
        case 4: 
          localess.mcX = locala.abFh.AN();
          AppMethodBeat.o(153002);
          return 0;
        case 5: 
          localess.Pyz = locala.abFh.AK();
          AppMethodBeat.o(153002);
          return 0;
        case 6: 
          localess.type = locala.abFh.AK();
          AppMethodBeat.o(153002);
          return 0;
        case 7: 
          localess.text = locala.abFh.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 8: 
          localess.icon = locala.abFh.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 9: 
          localess.Uuu = locala.abFh.AN();
          AppMethodBeat.o(153002);
          return 0;
        case 10: 
          localess.PzH = locala.abFh.AK();
          AppMethodBeat.o(153002);
          return 0;
        case 11: 
          localess.Uuv = locala.abFh.AK();
          AppMethodBeat.o(153002);
          return 0;
        case 12: 
          localess.Uuw = locala.abFh.AN();
          AppMethodBeat.o(153002);
          return 0;
        case 13: 
          localess.showFlag = locala.abFh.AK();
          AppMethodBeat.o(153002);
          return 0;
        case 14: 
          localess.mbp = locala.abFh.AK();
          AppMethodBeat.o(153002);
          return 0;
        case 15: 
          localess.extInfo = locala.abFh.readString();
          AppMethodBeat.o(153002);
          return 0;
        }
        localess.priority = locala.abFh.AK();
        AppMethodBeat.o(153002);
        return 0;
      }
      AppMethodBeat.o(153002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ess
 * JD-Core Version:    0.7.0.1
 */