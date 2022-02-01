package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anm
  extends com.tencent.mm.bw.a
{
  public String qom;
  public String qox;
  public int rfR;
  public int rht;
  public long sem;
  public String sen;
  public int seo;
  public int sep;
  public int ser;
  public String ses;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195108);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.d(1, this.sessionId);
      }
      if (this.qox != null) {
        paramVarArgs.d(2, this.qox);
      }
      if (this.qom != null) {
        paramVarArgs.d(3, this.qom);
      }
      if (this.sen != null) {
        paramVarArgs.d(4, this.sen);
      }
      paramVarArgs.aR(5, this.rht);
      paramVarArgs.aR(6, this.rfR);
      paramVarArgs.aO(7, this.sem);
      paramVarArgs.aR(8, this.seo);
      paramVarArgs.aR(9, this.sep);
      if (this.ses != null) {
        paramVarArgs.d(10, this.ses);
      }
      paramVarArgs.aR(11, this.ser);
      AppMethodBeat.o(195108);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.b.b.a.e(1, this.sessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qox != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qox);
      }
      i = paramInt;
      if (this.qom != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.qom);
      }
      paramInt = i;
      if (this.sen != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sen);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.rht) + f.a.a.b.b.a.bx(6, this.rfR) + f.a.a.b.b.a.p(7, this.sem) + f.a.a.b.b.a.bx(8, this.seo) + f.a.a.b.b.a.bx(9, this.sep);
      paramInt = i;
      if (this.ses != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ses);
      }
      i = f.a.a.b.b.a.bx(11, this.ser);
      AppMethodBeat.o(195108);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195108);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        anm localanm = (anm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195108);
          return -1;
        case 1: 
          localanm.sessionId = locala.LVo.readString();
          AppMethodBeat.o(195108);
          return 0;
        case 2: 
          localanm.qox = locala.LVo.readString();
          AppMethodBeat.o(195108);
          return 0;
        case 3: 
          localanm.qom = locala.LVo.readString();
          AppMethodBeat.o(195108);
          return 0;
        case 4: 
          localanm.sen = locala.LVo.readString();
          AppMethodBeat.o(195108);
          return 0;
        case 5: 
          localanm.rht = locala.LVo.xF();
          AppMethodBeat.o(195108);
          return 0;
        case 6: 
          localanm.rfR = locala.LVo.xF();
          AppMethodBeat.o(195108);
          return 0;
        case 7: 
          localanm.sem = locala.LVo.xG();
          AppMethodBeat.o(195108);
          return 0;
        case 8: 
          localanm.seo = locala.LVo.xF();
          AppMethodBeat.o(195108);
          return 0;
        case 9: 
          localanm.sep = locala.LVo.xF();
          AppMethodBeat.o(195108);
          return 0;
        case 10: 
          localanm.ses = locala.LVo.readString();
          AppMethodBeat.o(195108);
          return 0;
        }
        localanm.ser = locala.LVo.xF();
        AppMethodBeat.o(195108);
        return 0;
      }
      AppMethodBeat.o(195108);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anm
 * JD-Core Version:    0.7.0.1
 */