package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjm
  extends com.tencent.mm.bw.a
{
  public long FLc;
  public String FLd;
  public String FLe;
  public String FLf;
  public String FLg;
  public String eRf;
  public String eRg;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152660);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.eRf != null) {
        paramVarArgs.d(1, this.eRf);
      }
      if (this.eRg != null) {
        paramVarArgs.d(2, this.eRg);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.aZ(5, this.FLc);
      if (this.FLd != null) {
        paramVarArgs.d(6, this.FLd);
      }
      if (this.FLe != null) {
        paramVarArgs.d(7, this.FLe);
      }
      if (this.FLf != null) {
        paramVarArgs.d(8, this.FLf);
      }
      if (this.FLg != null) {
        paramVarArgs.d(9, this.FLg);
      }
      AppMethodBeat.o(152660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eRf == null) {
        break label648;
      }
    }
    label648:
    for (paramInt = f.a.a.b.b.a.e(1, this.eRf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.eRg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.eRg);
      }
      i = i + f.a.a.b.b.a.amD(3) + f.a.a.b.b.a.amD(4) + f.a.a.b.b.a.p(5, this.FLc);
      paramInt = i;
      if (this.FLd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FLd);
      }
      i = paramInt;
      if (this.FLe != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FLe);
      }
      paramInt = i;
      if (this.FLf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FLf);
      }
      i = paramInt;
      if (this.FLg != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FLg);
      }
      AppMethodBeat.o(152660);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152660);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cjm localcjm = (cjm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152660);
          return -1;
        case 1: 
          localcjm.eRf = locala.OmT.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 2: 
          localcjm.eRg = locala.OmT.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 3: 
          localcjm.latitude = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(152660);
          return 0;
        case 4: 
          localcjm.longitude = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(152660);
          return 0;
        case 5: 
          localcjm.FLc = locala.OmT.zd();
          AppMethodBeat.o(152660);
          return 0;
        case 6: 
          localcjm.FLd = locala.OmT.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 7: 
          localcjm.FLe = locala.OmT.readString();
          AppMethodBeat.o(152660);
          return 0;
        case 8: 
          localcjm.FLf = locala.OmT.readString();
          AppMethodBeat.o(152660);
          return 0;
        }
        localcjm.FLg = locala.OmT.readString();
        AppMethodBeat.o(152660);
        return 0;
      }
      AppMethodBeat.o(152660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjm
 * JD-Core Version:    0.7.0.1
 */