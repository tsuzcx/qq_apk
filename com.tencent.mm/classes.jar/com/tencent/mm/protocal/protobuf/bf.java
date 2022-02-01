package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bf
  extends com.tencent.mm.bw.a
{
  public long KEC;
  public String KED;
  public String KEE;
  public String KEF;
  public String KEG;
  public String KEH;
  public String fuJ;
  public String fuK;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91341);
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
      if (this.KEH != null) {
        paramVarArgs.e(10, this.KEH);
      }
      AppMethodBeat.o(91341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fuJ == null) {
        break label716;
      }
    }
    label716:
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
      paramInt = i;
      if (this.KEH != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KEH);
      }
      AppMethodBeat.o(91341);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91341);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bf localbf = (bf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91341);
          return -1;
        case 1: 
          localbf.fuJ = locala.UbS.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 2: 
          localbf.fuK = locala.UbS.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 3: 
          localbf.latitude = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(91341);
          return 0;
        case 4: 
          localbf.longitude = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(91341);
          return 0;
        case 5: 
          localbf.KEC = locala.UbS.zl();
          AppMethodBeat.o(91341);
          return 0;
        case 6: 
          localbf.KED = locala.UbS.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 7: 
          localbf.KEE = locala.UbS.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 8: 
          localbf.KEF = locala.UbS.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 9: 
          localbf.KEG = locala.UbS.readString();
          AppMethodBeat.o(91341);
          return 0;
        }
        localbf.KEH = locala.UbS.readString();
        AppMethodBeat.o(91341);
        return 0;
      }
      AppMethodBeat.o(91341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bf
 * JD-Core Version:    0.7.0.1
 */