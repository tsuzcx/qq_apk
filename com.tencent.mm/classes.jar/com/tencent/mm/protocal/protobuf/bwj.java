package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwj
  extends com.tencent.mm.bx.a
{
  public int ZJy;
  public boolean aafn;
  public boolean aafo;
  public boolean aafp;
  public boolean aafq;
  public int aafr;
  public int aafs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258624);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.aafn);
      paramVarArgs.di(2, this.aafo);
      paramVarArgs.di(3, this.aafp);
      paramVarArgs.di(4, this.aafq);
      paramVarArgs.bS(5, this.aafr);
      paramVarArgs.bS(6, this.ZJy);
      paramVarArgs.bS(7, this.aafs);
      AppMethodBeat.o(258624);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.cJ(5, this.aafr);
      int n = i.a.a.b.b.a.cJ(6, this.ZJy);
      int i1 = i.a.a.b.b.a.cJ(7, this.aafs);
      AppMethodBeat.o(258624);
      return paramInt + 1 + 0 + (i + 1) + (j + 1) + (k + 1) + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258624);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bwj localbwj = (bwj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258624);
        return -1;
      case 1: 
        localbwj.aafn = locala.ajGk.aai();
        AppMethodBeat.o(258624);
        return 0;
      case 2: 
        localbwj.aafo = locala.ajGk.aai();
        AppMethodBeat.o(258624);
        return 0;
      case 3: 
        localbwj.aafp = locala.ajGk.aai();
        AppMethodBeat.o(258624);
        return 0;
      case 4: 
        localbwj.aafq = locala.ajGk.aai();
        AppMethodBeat.o(258624);
        return 0;
      case 5: 
        localbwj.aafr = locala.ajGk.aar();
        AppMethodBeat.o(258624);
        return 0;
      case 6: 
        localbwj.ZJy = locala.ajGk.aar();
        AppMethodBeat.o(258624);
        return 0;
      }
      localbwj.aafs = locala.ajGk.aar();
      AppMethodBeat.o(258624);
      return 0;
    }
    AppMethodBeat.o(258624);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwj
 * JD-Core Version:    0.7.0.1
 */