package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ne
  extends com.tencent.mm.bw.a
{
  public String EcX;
  public int EcY;
  public int EcZ;
  public int Eda;
  public int Edb;
  public int Edc;
  public int drx;
  public int gIh;
  public String url;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EcX != null) {
        paramVarArgs.d(1, this.EcX);
      }
      paramVarArgs.aR(2, this.weight);
      paramVarArgs.aR(3, this.EcY);
      paramVarArgs.aR(4, this.drx);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aR(6, this.gIh);
      paramVarArgs.aR(7, this.EcZ);
      paramVarArgs.aR(8, this.Eda);
      paramVarArgs.aR(9, this.Edb);
      paramVarArgs.aR(10, this.Edc);
      AppMethodBeat.o(124437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EcX == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.b.b.a.e(1, this.EcX) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.weight) + f.a.a.b.b.a.bx(3, this.EcY) + f.a.a.b.b.a.bx(4, this.drx);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = f.a.a.b.b.a.bx(6, this.gIh);
      int j = f.a.a.b.b.a.bx(7, this.EcZ);
      int k = f.a.a.b.b.a.bx(8, this.Eda);
      int m = f.a.a.b.b.a.bx(9, this.Edb);
      int n = f.a.a.b.b.a.bx(10, this.Edc);
      AppMethodBeat.o(124437);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124437);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ne localne = (ne)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124437);
          return -1;
        case 1: 
          localne.EcX = locala.LVo.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 2: 
          localne.weight = locala.LVo.xF();
          AppMethodBeat.o(124437);
          return 0;
        case 3: 
          localne.EcY = locala.LVo.xF();
          AppMethodBeat.o(124437);
          return 0;
        case 4: 
          localne.drx = locala.LVo.xF();
          AppMethodBeat.o(124437);
          return 0;
        case 5: 
          localne.url = locala.LVo.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 6: 
          localne.gIh = locala.LVo.xF();
          AppMethodBeat.o(124437);
          return 0;
        case 7: 
          localne.EcZ = locala.LVo.xF();
          AppMethodBeat.o(124437);
          return 0;
        case 8: 
          localne.Eda = locala.LVo.xF();
          AppMethodBeat.o(124437);
          return 0;
        case 9: 
          localne.Edb = locala.LVo.xF();
          AppMethodBeat.o(124437);
          return 0;
        }
        localne.Edc = locala.LVo.xF();
        AppMethodBeat.o(124437);
        return 0;
      }
      AppMethodBeat.o(124437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ne
 * JD-Core Version:    0.7.0.1
 */