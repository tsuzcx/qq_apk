package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ebu
  extends com.tencent.mm.bw.a
{
  public String DPS;
  public int Eae;
  public b FFq;
  public String Ghc;
  public float Ghd;
  public float Ghe;
  public int Ghf;
  public String Ghg;
  public String IconUrl;
  public String hOf;
  public String ncR;
  public String ndW;
  public String tlT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117960);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ghc != null) {
        paramVarArgs.d(1, this.Ghc);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(3, this.IconUrl);
      }
      if (this.ncR != null) {
        paramVarArgs.d(4, this.ncR);
      }
      paramVarArgs.aR(5, this.Eae);
      if (this.DPS != null) {
        paramVarArgs.d(6, this.DPS);
      }
      if (this.tlT != null) {
        paramVarArgs.d(7, this.tlT);
      }
      paramVarArgs.x(8, this.Ghd);
      paramVarArgs.x(9, this.Ghe);
      paramVarArgs.aR(10, this.Ghf);
      if (this.hOf != null) {
        paramVarArgs.d(11, this.hOf);
      }
      if (this.Ghg != null) {
        paramVarArgs.d(12, this.Ghg);
      }
      if (this.FFq != null) {
        paramVarArgs.c(13, this.FFq);
      }
      AppMethodBeat.o(117960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ghc == null) {
        break label884;
      }
    }
    label884:
    for (int i = f.a.a.b.b.a.e(1, this.Ghc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ndW);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IconUrl);
      }
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ncR);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Eae);
      paramInt = i;
      if (this.DPS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DPS);
      }
      i = paramInt;
      if (this.tlT != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.tlT);
      }
      i = i + (f.a.a.b.b.a.fK(8) + 4) + (f.a.a.b.b.a.fK(9) + 4) + f.a.a.b.b.a.bx(10, this.Ghf);
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.hOf);
      }
      i = paramInt;
      if (this.Ghg != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Ghg);
      }
      paramInt = i;
      if (this.FFq != null) {
        paramInt = i + f.a.a.b.b.a.b(13, this.FFq);
      }
      AppMethodBeat.o(117960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117960);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebu localebu = (ebu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117960);
          return -1;
        case 1: 
          localebu.Ghc = locala.LVo.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 2: 
          localebu.ndW = locala.LVo.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 3: 
          localebu.IconUrl = locala.LVo.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 4: 
          localebu.ncR = locala.LVo.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 5: 
          localebu.Eae = locala.LVo.xF();
          AppMethodBeat.o(117960);
          return 0;
        case 6: 
          localebu.DPS = locala.LVo.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 7: 
          localebu.tlT = locala.LVo.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 8: 
          localebu.Ghd = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(117960);
          return 0;
        case 9: 
          localebu.Ghe = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(117960);
          return 0;
        case 10: 
          localebu.Ghf = locala.LVo.xF();
          AppMethodBeat.o(117960);
          return 0;
        case 11: 
          localebu.hOf = locala.LVo.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 12: 
          localebu.Ghg = locala.LVo.readString();
          AppMethodBeat.o(117960);
          return 0;
        }
        localebu.FFq = locala.LVo.gfk();
        AppMethodBeat.o(117960);
        return 0;
      }
      AppMethodBeat.o(117960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebu
 * JD-Core Version:    0.7.0.1
 */