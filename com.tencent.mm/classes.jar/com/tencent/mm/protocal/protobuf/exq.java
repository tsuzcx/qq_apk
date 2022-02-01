package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class exq
  extends com.tencent.mm.bw.a
{
  public String APs;
  public String MEq;
  public String Mbb;
  public String NuS;
  public String NuT;
  public String NuU;
  public String NuV;
  public String NuW;
  public int Scene;
  public int kcR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121110);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NuS != null) {
        paramVarArgs.e(1, this.NuS);
      }
      if (this.NuT != null) {
        paramVarArgs.e(2, this.NuT);
      }
      if (this.Mbb != null) {
        paramVarArgs.e(3, this.Mbb);
      }
      if (this.MEq != null) {
        paramVarArgs.e(4, this.MEq);
      }
      paramVarArgs.aM(5, this.kcR);
      if (this.APs != null) {
        paramVarArgs.e(6, this.APs);
      }
      if (this.NuU != null) {
        paramVarArgs.e(7, this.NuU);
      }
      if (this.NuV != null) {
        paramVarArgs.e(8, this.NuV);
      }
      paramVarArgs.aM(9, this.Scene);
      if (this.NuW != null) {
        paramVarArgs.e(19, this.NuW);
      }
      AppMethodBeat.o(121110);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NuS == null) {
        break label770;
      }
    }
    label770:
    for (int i = g.a.a.b.b.a.f(1, this.NuS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NuT != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NuT);
      }
      i = paramInt;
      if (this.Mbb != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mbb);
      }
      paramInt = i;
      if (this.MEq != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MEq);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.kcR);
      paramInt = i;
      if (this.APs != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.APs);
      }
      i = paramInt;
      if (this.NuU != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.NuU);
      }
      paramInt = i;
      if (this.NuV != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.NuV);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.Scene);
      paramInt = i;
      if (this.NuW != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.NuW);
      }
      AppMethodBeat.o(121110);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(121110);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        exq localexq = (exq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(121110);
          return -1;
        case 1: 
          localexq.NuS = locala.UbS.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 2: 
          localexq.NuT = locala.UbS.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 3: 
          localexq.Mbb = locala.UbS.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 4: 
          localexq.MEq = locala.UbS.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 5: 
          localexq.kcR = locala.UbS.zi();
          AppMethodBeat.o(121110);
          return 0;
        case 6: 
          localexq.APs = locala.UbS.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 7: 
          localexq.NuU = locala.UbS.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 8: 
          localexq.NuV = locala.UbS.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 9: 
          localexq.Scene = locala.UbS.zi();
          AppMethodBeat.o(121110);
          return 0;
        }
        localexq.NuW = locala.UbS.readString();
        AppMethodBeat.o(121110);
        return 0;
      }
      AppMethodBeat.o(121110);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exq
 * JD-Core Version:    0.7.0.1
 */