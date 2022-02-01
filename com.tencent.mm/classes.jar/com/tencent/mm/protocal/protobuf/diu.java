package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class diu
  extends com.tencent.mm.cd.a
{
  public String TQk;
  public int TQl;
  public int TQm;
  public long createTime;
  public String fLi;
  public String lqH;
  public long rPF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(240874);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fLi != null) {
        paramVarArgs.f(1, this.fLi);
      }
      if (this.TQk != null) {
        paramVarArgs.f(2, this.TQk);
      }
      if (this.lqH != null) {
        paramVarArgs.f(3, this.lqH);
      }
      paramVarArgs.bm(4, this.createTime);
      paramVarArgs.aY(5, this.TQl);
      paramVarArgs.bm(6, this.rPF);
      paramVarArgs.aY(7, this.TQm);
      AppMethodBeat.o(240874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fLi == null) {
        break label522;
      }
    }
    label522:
    for (int i = g.a.a.b.b.a.g(1, this.fLi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TQk != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TQk);
      }
      i = paramInt;
      if (this.lqH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lqH);
      }
      paramInt = g.a.a.b.b.a.p(4, this.createTime);
      int j = g.a.a.b.b.a.bM(5, this.TQl);
      int k = g.a.a.b.b.a.p(6, this.rPF);
      int m = g.a.a.b.b.a.bM(7, this.TQm);
      AppMethodBeat.o(240874);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(240874);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        diu localdiu = (diu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(240874);
          return -1;
        case 1: 
          localdiu.fLi = locala.abFh.readString();
          AppMethodBeat.o(240874);
          return 0;
        case 2: 
          localdiu.TQk = locala.abFh.readString();
          AppMethodBeat.o(240874);
          return 0;
        case 3: 
          localdiu.lqH = locala.abFh.readString();
          AppMethodBeat.o(240874);
          return 0;
        case 4: 
          localdiu.createTime = locala.abFh.AN();
          AppMethodBeat.o(240874);
          return 0;
        case 5: 
          localdiu.TQl = locala.abFh.AK();
          AppMethodBeat.o(240874);
          return 0;
        case 6: 
          localdiu.rPF = locala.abFh.AN();
          AppMethodBeat.o(240874);
          return 0;
        }
        localdiu.TQm = locala.abFh.AK();
        AppMethodBeat.o(240874);
        return 0;
      }
      AppMethodBeat.o(240874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diu
 * JD-Core Version:    0.7.0.1
 */