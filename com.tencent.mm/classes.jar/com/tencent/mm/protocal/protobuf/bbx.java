package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbx
  extends com.tencent.mm.cd.a
{
  public String SKs;
  public String SKx;
  public String SMy;
  public int SNC;
  public long begin_time;
  public int status;
  public long tsh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231106);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SKs != null) {
        paramVarArgs.f(1, this.SKs);
      }
      paramVarArgs.bm(2, this.begin_time);
      paramVarArgs.bm(3, this.tsh);
      paramVarArgs.aY(4, this.SNC);
      if (this.SKx != null) {
        paramVarArgs.f(5, this.SKx);
      }
      if (this.SMy != null) {
        paramVarArgs.f(6, this.SMy);
      }
      paramVarArgs.aY(7, this.status);
      AppMethodBeat.o(231106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SKs == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.b.b.a.g(1, this.SKs) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.begin_time) + g.a.a.b.b.a.p(3, this.tsh) + g.a.a.b.b.a.bM(4, this.SNC);
      paramInt = i;
      if (this.SKx != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SKx);
      }
      i = paramInt;
      if (this.SMy != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.SMy);
      }
      paramInt = g.a.a.b.b.a.bM(7, this.status);
      AppMethodBeat.o(231106);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231106);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bbx localbbx = (bbx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(231106);
          return -1;
        case 1: 
          localbbx.SKs = locala.abFh.readString();
          AppMethodBeat.o(231106);
          return 0;
        case 2: 
          localbbx.begin_time = locala.abFh.AN();
          AppMethodBeat.o(231106);
          return 0;
        case 3: 
          localbbx.tsh = locala.abFh.AN();
          AppMethodBeat.o(231106);
          return 0;
        case 4: 
          localbbx.SNC = locala.abFh.AK();
          AppMethodBeat.o(231106);
          return 0;
        case 5: 
          localbbx.SKx = locala.abFh.readString();
          AppMethodBeat.o(231106);
          return 0;
        case 6: 
          localbbx.SMy = locala.abFh.readString();
          AppMethodBeat.o(231106);
          return 0;
        }
        localbbx.status = locala.abFh.AK();
        AppMethodBeat.o(231106);
        return 0;
      }
      AppMethodBeat.o(231106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbx
 * JD-Core Version:    0.7.0.1
 */