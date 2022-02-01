package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cjy
  extends com.tencent.mm.cd.a
{
  public String SkU;
  public long SqZ;
  public String TfK;
  public int Trv;
  public long Trw;
  public long Trx;
  public String icon;
  public int qJt;
  public String tpo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72504);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SkU != null) {
        paramVarArgs.f(1, this.SkU);
      }
      paramVarArgs.bm(2, this.SqZ);
      paramVarArgs.aY(3, this.Trv);
      paramVarArgs.bm(4, this.Trw);
      paramVarArgs.bm(5, this.Trx);
      if (this.TfK != null) {
        paramVarArgs.f(6, this.TfK);
      }
      if (this.tpo != null) {
        paramVarArgs.f(7, this.tpo);
      }
      paramVarArgs.aY(8, this.qJt);
      if (this.icon != null) {
        paramVarArgs.f(9, this.icon);
      }
      AppMethodBeat.o(72504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SkU == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = g.a.a.b.b.a.g(1, this.SkU) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SqZ) + g.a.a.b.b.a.bM(3, this.Trv) + g.a.a.b.b.a.p(4, this.Trw) + g.a.a.b.b.a.p(5, this.Trx);
      paramInt = i;
      if (this.TfK != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TfK);
      }
      i = paramInt;
      if (this.tpo != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.tpo);
      }
      i += g.a.a.b.b.a.bM(8, this.qJt);
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.icon);
      }
      AppMethodBeat.o(72504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72504);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cjy localcjy = (cjy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72504);
          return -1;
        case 1: 
          localcjy.SkU = locala.abFh.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 2: 
          localcjy.SqZ = locala.abFh.AN();
          AppMethodBeat.o(72504);
          return 0;
        case 3: 
          localcjy.Trv = locala.abFh.AK();
          AppMethodBeat.o(72504);
          return 0;
        case 4: 
          localcjy.Trw = locala.abFh.AN();
          AppMethodBeat.o(72504);
          return 0;
        case 5: 
          localcjy.Trx = locala.abFh.AN();
          AppMethodBeat.o(72504);
          return 0;
        case 6: 
          localcjy.TfK = locala.abFh.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 7: 
          localcjy.tpo = locala.abFh.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 8: 
          localcjy.qJt = locala.abFh.AK();
          AppMethodBeat.o(72504);
          return 0;
        }
        localcjy.icon = locala.abFh.readString();
        AppMethodBeat.o(72504);
        return 0;
      }
      AppMethodBeat.o(72504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjy
 * JD-Core Version:    0.7.0.1
 */