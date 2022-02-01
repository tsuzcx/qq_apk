package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class fei
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String KHk;
  public int KSa;
  public String MUT;
  public b MVf;
  public float NzA;
  public int NzB;
  public String NzC;
  public float Nzz;
  public String UserName;
  public String jfi;
  public String oUJ;
  public String xut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117960);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MUT != null) {
        paramVarArgs.e(1, this.MUT);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(3, this.IconUrl);
      }
      if (this.UserName != null) {
        paramVarArgs.e(4, this.UserName);
      }
      paramVarArgs.aM(5, this.KSa);
      if (this.KHk != null) {
        paramVarArgs.e(6, this.KHk);
      }
      if (this.xut != null) {
        paramVarArgs.e(7, this.xut);
      }
      paramVarArgs.E(8, this.Nzz);
      paramVarArgs.E(9, this.NzA);
      paramVarArgs.aM(10, this.NzB);
      if (this.jfi != null) {
        paramVarArgs.e(11, this.jfi);
      }
      if (this.NzC != null) {
        paramVarArgs.e(12, this.NzC);
      }
      if (this.MVf != null) {
        paramVarArgs.c(13, this.MVf);
      }
      AppMethodBeat.o(117960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MUT == null) {
        break label884;
      }
    }
    label884:
    for (int i = g.a.a.b.b.a.f(1, this.MUT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.IconUrl);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.UserName);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KSa);
      paramInt = i;
      if (this.KHk != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KHk);
      }
      i = paramInt;
      if (this.xut != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.xut);
      }
      i = i + (g.a.a.b.b.a.fS(8) + 4) + (g.a.a.b.b.a.fS(9) + 4) + g.a.a.b.b.a.bu(10, this.NzB);
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.jfi);
      }
      i = paramInt;
      if (this.NzC != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.NzC);
      }
      paramInt = i;
      if (this.MVf != null) {
        paramInt = i + g.a.a.b.b.a.b(13, this.MVf);
      }
      AppMethodBeat.o(117960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117960);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fei localfei = (fei)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117960);
          return -1;
        case 1: 
          localfei.MUT = locala.UbS.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 2: 
          localfei.oUJ = locala.UbS.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 3: 
          localfei.IconUrl = locala.UbS.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 4: 
          localfei.UserName = locala.UbS.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 5: 
          localfei.KSa = locala.UbS.zi();
          AppMethodBeat.o(117960);
          return 0;
        case 6: 
          localfei.KHk = locala.UbS.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 7: 
          localfei.xut = locala.UbS.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 8: 
          localfei.Nzz = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(117960);
          return 0;
        case 9: 
          localfei.NzA = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(117960);
          return 0;
        case 10: 
          localfei.NzB = locala.UbS.zi();
          AppMethodBeat.o(117960);
          return 0;
        case 11: 
          localfei.jfi = locala.UbS.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 12: 
          localfei.NzC = locala.UbS.readString();
          AppMethodBeat.o(117960);
          return 0;
        }
        localfei.MVf = locala.UbS.hPo();
        AppMethodBeat.o(117960);
        return 0;
      }
      AppMethodBeat.o(117960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fei
 * JD-Core Version:    0.7.0.1
 */