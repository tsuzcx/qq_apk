package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dol
  extends com.tencent.mm.bw.a
{
  public String DUp;
  public String EYa;
  public String Etg;
  public long FWh;
  public String Fsk;
  public String IconUrl;
  public String ncV;
  public String tkL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Etg != null) {
        paramVarArgs.d(1, this.Etg);
      }
      if (this.DUp != null) {
        paramVarArgs.d(2, this.DUp);
      }
      if (this.Fsk != null) {
        paramVarArgs.d(3, this.Fsk);
      }
      if (this.tkL != null) {
        paramVarArgs.d(4, this.tkL);
      }
      if (this.ncV != null) {
        paramVarArgs.d(5, this.ncV);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(6, this.IconUrl);
      }
      if (this.EYa != null) {
        paramVarArgs.d(7, this.EYa);
      }
      paramVarArgs.aO(8, this.FWh);
      AppMethodBeat.o(32491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Etg == null) {
        break label640;
      }
    }
    label640:
    for (int i = f.a.a.b.b.a.e(1, this.Etg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DUp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DUp);
      }
      i = paramInt;
      if (this.Fsk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fsk);
      }
      paramInt = i;
      if (this.tkL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tkL);
      }
      i = paramInt;
      if (this.ncV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ncV);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.IconUrl);
      }
      i = paramInt;
      if (this.EYa != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EYa);
      }
      paramInt = f.a.a.b.b.a.p(8, this.FWh);
      AppMethodBeat.o(32491);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32491);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dol localdol = (dol)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32491);
          return -1;
        case 1: 
          localdol.Etg = locala.LVo.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 2: 
          localdol.DUp = locala.LVo.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 3: 
          localdol.Fsk = locala.LVo.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 4: 
          localdol.tkL = locala.LVo.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 5: 
          localdol.ncV = locala.LVo.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 6: 
          localdol.IconUrl = locala.LVo.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 7: 
          localdol.EYa = locala.LVo.readString();
          AppMethodBeat.o(32491);
          return 0;
        }
        localdol.FWh = locala.LVo.xG();
        AppMethodBeat.o(32491);
        return 0;
      }
      AppMethodBeat.o(32491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dol
 * JD-Core Version:    0.7.0.1
 */