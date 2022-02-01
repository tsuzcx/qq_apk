package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eiq
  extends com.tencent.mm.bw.a
{
  public int IEj;
  public int IFn;
  public int IFo;
  public int IFp;
  public long NhO;
  public int NhP;
  public long NhQ;
  public String extInfo;
  public String icon;
  public int jlm;
  public long jmW;
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
        paramVarArgs.e(1, this.msgId);
      }
      paramVarArgs.aM(2, this.IFn);
      paramVarArgs.aM(3, this.IFo);
      paramVarArgs.bb(4, this.jmW);
      paramVarArgs.aM(5, this.IEj);
      paramVarArgs.aM(6, this.type);
      if (this.text != null) {
        paramVarArgs.e(7, this.text);
      }
      if (this.icon != null) {
        paramVarArgs.e(8, this.icon);
      }
      paramVarArgs.bb(9, this.NhO);
      paramVarArgs.aM(10, this.IFp);
      paramVarArgs.aM(11, this.NhP);
      paramVarArgs.bb(12, this.NhQ);
      paramVarArgs.aM(13, this.showFlag);
      paramVarArgs.aM(14, this.jlm);
      if (this.extInfo != null) {
        paramVarArgs.e(15, this.extInfo);
      }
      paramVarArgs.aM(16, this.priority);
      AppMethodBeat.o(153002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.msgId == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = g.a.a.b.b.a.f(1, this.msgId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.IFn) + g.a.a.b.b.a.bu(3, this.IFo) + g.a.a.b.b.a.r(4, this.jmW) + g.a.a.b.b.a.bu(5, this.IEj) + g.a.a.b.b.a.bu(6, this.type);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.text);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.icon);
      }
      i = i + g.a.a.b.b.a.r(9, this.NhO) + g.a.a.b.b.a.bu(10, this.IFp) + g.a.a.b.b.a.bu(11, this.NhP) + g.a.a.b.b.a.r(12, this.NhQ) + g.a.a.b.b.a.bu(13, this.showFlag) + g.a.a.b.b.a.bu(14, this.jlm);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.extInfo);
      }
      i = g.a.a.b.b.a.bu(16, this.priority);
      AppMethodBeat.o(153002);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153002);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eiq localeiq = (eiq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153002);
          return -1;
        case 1: 
          localeiq.msgId = locala.UbS.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 2: 
          localeiq.IFn = locala.UbS.zi();
          AppMethodBeat.o(153002);
          return 0;
        case 3: 
          localeiq.IFo = locala.UbS.zi();
          AppMethodBeat.o(153002);
          return 0;
        case 4: 
          localeiq.jmW = locala.UbS.zl();
          AppMethodBeat.o(153002);
          return 0;
        case 5: 
          localeiq.IEj = locala.UbS.zi();
          AppMethodBeat.o(153002);
          return 0;
        case 6: 
          localeiq.type = locala.UbS.zi();
          AppMethodBeat.o(153002);
          return 0;
        case 7: 
          localeiq.text = locala.UbS.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 8: 
          localeiq.icon = locala.UbS.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 9: 
          localeiq.NhO = locala.UbS.zl();
          AppMethodBeat.o(153002);
          return 0;
        case 10: 
          localeiq.IFp = locala.UbS.zi();
          AppMethodBeat.o(153002);
          return 0;
        case 11: 
          localeiq.NhP = locala.UbS.zi();
          AppMethodBeat.o(153002);
          return 0;
        case 12: 
          localeiq.NhQ = locala.UbS.zl();
          AppMethodBeat.o(153002);
          return 0;
        case 13: 
          localeiq.showFlag = locala.UbS.zi();
          AppMethodBeat.o(153002);
          return 0;
        case 14: 
          localeiq.jlm = locala.UbS.zi();
          AppMethodBeat.o(153002);
          return 0;
        case 15: 
          localeiq.extInfo = locala.UbS.readString();
          AppMethodBeat.o(153002);
          return 0;
        }
        localeiq.priority = locala.UbS.zi();
        AppMethodBeat.o(153002);
        return 0;
      }
      AppMethodBeat.o(153002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiq
 * JD-Core Version:    0.7.0.1
 */