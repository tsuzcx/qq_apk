package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czu
  extends com.tencent.mm.bw.a
{
  public long KEC;
  public String KED;
  public String KEE;
  public String KEF;
  public String KEG;
  public String fuJ;
  public String fuK;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152660);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fuJ != null) {
        paramVarArgs.e(1, this.fuJ);
      }
      if (this.fuK != null) {
        paramVarArgs.e(2, this.fuK);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.bb(5, this.KEC);
      if (this.KED != null) {
        paramVarArgs.e(6, this.KED);
      }
      if (this.KEE != null) {
        paramVarArgs.e(7, this.KEE);
      }
      if (this.KEF != null) {
        paramVarArgs.e(8, this.KEF);
      }
      if (this.KEG != null) {
        paramVarArgs.e(9, this.KEG);
      }
      AppMethodBeat.o(152660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fuJ == null) {
        break label656;
      }
    }
    label656:
    for (paramInt = g.a.a.b.b.a.f(1, this.fuJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fuK != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.fuK);
      }
      i = i + (g.a.a.b.b.a.fS(3) + 8) + (g.a.a.b.b.a.fS(4) + 8) + g.a.a.b.b.a.r(5, this.KEC);
      paramInt = i;
      if (this.KED != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KED);
      }
      i = paramInt;
      if (this.KEE != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KEE);
      }
      paramInt = i;
      if (this.KEF != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KEF);
      }
      i = paramInt;
      if (this.KEG != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.KEG);
      }
      AppMethodBeat.o(152660);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152660);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        czu localczu = (czu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152660);
          return -1;
        case 1: 
          localczu.fuJ = locala.UbS.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 2: 
          localczu.fuK = locala.UbS.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 3: 
          localczu.latitude = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(152660);
          return 0;
        case 4: 
          localczu.longitude = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(152660);
          return 0;
        case 5: 
          localczu.KEC = locala.UbS.zl();
          AppMethodBeat.o(152660);
          return 0;
        case 6: 
          localczu.KED = locala.UbS.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 7: 
          localczu.KEE = locala.UbS.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 8: 
          localczu.KEF = locala.UbS.readString();
          AppMethodBeat.o(152660);
          return 0;
        }
        localczu.KEG = locala.UbS.readString();
        AppMethodBeat.o(152660);
        return 0;
      }
      AppMethodBeat.o(152660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czu
 * JD-Core Version:    0.7.0.1
 */