package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avb
  extends com.tencent.mm.bv.a
{
  public String qfY;
  public int state;
  public String title;
  public String wBQ;
  public String xkq;
  public long xkr;
  public String xks;
  public String xkt;
  public String xku;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48866);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wBQ != null) {
        paramVarArgs.e(1, this.wBQ);
      }
      paramVarArgs.aO(2, this.state);
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.xkq != null) {
        paramVarArgs.e(4, this.xkq);
      }
      paramVarArgs.am(5, this.xkr);
      if (this.xks != null) {
        paramVarArgs.e(6, this.xks);
      }
      if (this.qfY != null) {
        paramVarArgs.e(7, this.qfY);
      }
      if (this.xkt != null) {
        paramVarArgs.e(8, this.xkt);
      }
      if (this.xku != null) {
        paramVarArgs.e(9, this.xku);
      }
      AppMethodBeat.o(48866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wBQ == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = e.a.a.b.b.a.f(1, this.wBQ) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.state);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.title);
      }
      i = paramInt;
      if (this.xkq != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xkq);
      }
      i += e.a.a.b.b.a.p(5, this.xkr);
      paramInt = i;
      if (this.xks != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xks);
      }
      i = paramInt;
      if (this.qfY != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.qfY);
      }
      paramInt = i;
      if (this.xkt != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xkt);
      }
      i = paramInt;
      if (this.xku != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xku);
      }
      AppMethodBeat.o(48866);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48866);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        avb localavb = (avb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48866);
          return -1;
        case 1: 
          localavb.wBQ = locala.CLY.readString();
          AppMethodBeat.o(48866);
          return 0;
        case 2: 
          localavb.state = locala.CLY.sl();
          AppMethodBeat.o(48866);
          return 0;
        case 3: 
          localavb.title = locala.CLY.readString();
          AppMethodBeat.o(48866);
          return 0;
        case 4: 
          localavb.xkq = locala.CLY.readString();
          AppMethodBeat.o(48866);
          return 0;
        case 5: 
          localavb.xkr = locala.CLY.sm();
          AppMethodBeat.o(48866);
          return 0;
        case 6: 
          localavb.xks = locala.CLY.readString();
          AppMethodBeat.o(48866);
          return 0;
        case 7: 
          localavb.qfY = locala.CLY.readString();
          AppMethodBeat.o(48866);
          return 0;
        case 8: 
          localavb.xkt = locala.CLY.readString();
          AppMethodBeat.o(48866);
          return 0;
        }
        localavb.xku = locala.CLY.readString();
        AppMethodBeat.o(48866);
        return 0;
      }
      AppMethodBeat.o(48866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avb
 * JD-Core Version:    0.7.0.1
 */