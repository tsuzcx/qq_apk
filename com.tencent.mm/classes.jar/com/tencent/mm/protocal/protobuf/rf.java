package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rf
  extends com.tencent.mm.bw.a
{
  public String Dps;
  public String DyN;
  public int FMa;
  public String GfA;
  public String GfB;
  public String dEM;
  public String title;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91383);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.DyN != null) {
        paramVarArgs.d(2, this.DyN);
      }
      if (this.dEM != null) {
        paramVarArgs.d(3, this.dEM);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.Dps != null) {
        paramVarArgs.d(5, this.Dps);
      }
      if (this.url != null) {
        paramVarArgs.d(6, this.url);
      }
      if (this.GfA != null) {
        paramVarArgs.d(7, this.GfA);
      }
      if (this.GfB != null) {
        paramVarArgs.d(8, this.GfB);
      }
      paramVarArgs.aS(9, this.FMa);
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.DyN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DyN);
      }
      i = paramInt;
      if (this.dEM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dEM);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt;
      if (this.Dps != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Dps);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.url);
      }
      i = paramInt;
      if (this.GfA != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GfA);
      }
      paramInt = i;
      if (this.GfB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GfB);
      }
      i = f.a.a.b.b.a.bz(9, this.FMa);
      AppMethodBeat.o(91383);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      rf localrf = (rf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91383);
        return -1;
      case 1: 
        localrf.type = locala.OmT.zc();
        AppMethodBeat.o(91383);
        return 0;
      case 2: 
        localrf.DyN = locala.OmT.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 3: 
        localrf.dEM = locala.OmT.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 4: 
        localrf.title = locala.OmT.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 5: 
        localrf.Dps = locala.OmT.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 6: 
        localrf.url = locala.OmT.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 7: 
        localrf.GfA = locala.OmT.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 8: 
        localrf.GfB = locala.OmT.readString();
        AppMethodBeat.o(91383);
        return 0;
      }
      localrf.FMa = locala.OmT.zc();
      AppMethodBeat.o(91383);
      return 0;
    }
    AppMethodBeat.o(91383);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rf
 * JD-Core Version:    0.7.0.1
 */