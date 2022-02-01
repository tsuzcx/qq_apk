package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxp
  extends com.tencent.mm.bw.a
{
  public String Ekn;
  public String EvL;
  public int Fmp;
  public int Fmq;
  public String desc;
  public String drM;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91555);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.EvL != null) {
        paramVarArgs.d(3, this.EvL);
      }
      paramVarArgs.aR(4, this.Fmp);
      paramVarArgs.aR(5, this.Fmq);
      if (this.Ekn != null) {
        paramVarArgs.d(6, this.Ekn);
      }
      if (this.drM != null) {
        paramVarArgs.d(7, this.drM);
      }
      AppMethodBeat.o(91555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label546;
      }
    }
    label546:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.EvL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EvL);
      }
      i = i + f.a.a.b.b.a.bx(4, this.Fmp) + f.a.a.b.b.a.bx(5, this.Fmq);
      paramInt = i;
      if (this.Ekn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ekn);
      }
      i = paramInt;
      if (this.drM != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.drM);
      }
      AppMethodBeat.o(91555);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91555);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxp localbxp = (bxp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91555);
          return -1;
        case 1: 
          localbxp.title = locala.LVo.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 2: 
          localbxp.desc = locala.LVo.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 3: 
          localbxp.EvL = locala.LVo.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 4: 
          localbxp.Fmp = locala.LVo.xF();
          AppMethodBeat.o(91555);
          return 0;
        case 5: 
          localbxp.Fmq = locala.LVo.xF();
          AppMethodBeat.o(91555);
          return 0;
        case 6: 
          localbxp.Ekn = locala.LVo.readString();
          AppMethodBeat.o(91555);
          return 0;
        }
        localbxp.drM = locala.LVo.readString();
        AppMethodBeat.o(91555);
        return 0;
      }
      AppMethodBeat.o(91555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxp
 * JD-Core Version:    0.7.0.1
 */