package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpa
  extends com.tencent.mm.bw.a
{
  public String GeJ;
  public String Hcv;
  public long Hcw;
  public String Hcx;
  public String Hcy;
  public String Hcz;
  public int state;
  public String title;
  public String yhW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72500);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GeJ != null) {
        paramVarArgs.d(1, this.GeJ);
      }
      paramVarArgs.aS(2, this.state);
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.Hcv != null) {
        paramVarArgs.d(4, this.Hcv);
      }
      paramVarArgs.aZ(5, this.Hcw);
      if (this.Hcx != null) {
        paramVarArgs.d(6, this.Hcx);
      }
      if (this.yhW != null) {
        paramVarArgs.d(7, this.yhW);
      }
      if (this.Hcy != null) {
        paramVarArgs.d(8, this.Hcy);
      }
      if (this.Hcz != null) {
        paramVarArgs.d(9, this.Hcz);
      }
      AppMethodBeat.o(72500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GeJ == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.GeJ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.state);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.title);
      }
      i = paramInt;
      if (this.Hcv != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hcv);
      }
      i += f.a.a.b.b.a.p(5, this.Hcw);
      paramInt = i;
      if (this.Hcx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hcx);
      }
      i = paramInt;
      if (this.yhW != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.yhW);
      }
      paramInt = i;
      if (this.Hcy != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hcy);
      }
      i = paramInt;
      if (this.Hcz != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Hcz);
      }
      AppMethodBeat.o(72500);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72500);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpa localbpa = (bpa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72500);
          return -1;
        case 1: 
          localbpa.GeJ = locala.OmT.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 2: 
          localbpa.state = locala.OmT.zc();
          AppMethodBeat.o(72500);
          return 0;
        case 3: 
          localbpa.title = locala.OmT.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 4: 
          localbpa.Hcv = locala.OmT.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 5: 
          localbpa.Hcw = locala.OmT.zd();
          AppMethodBeat.o(72500);
          return 0;
        case 6: 
          localbpa.Hcx = locala.OmT.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 7: 
          localbpa.yhW = locala.OmT.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 8: 
          localbpa.Hcy = locala.OmT.readString();
          AppMethodBeat.o(72500);
          return 0;
        }
        localbpa.Hcz = locala.OmT.readString();
        AppMethodBeat.o(72500);
        return 0;
      }
      AppMethodBeat.o(72500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpa
 * JD-Core Version:    0.7.0.1
 */