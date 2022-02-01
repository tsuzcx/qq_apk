package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ajg
  extends com.tencent.mm.bw.a
{
  public int KHa;
  public String LsK;
  public String LsL;
  public String LsM;
  public String LsN;
  public String LsO;
  public int LsP;
  public int LsQ;
  public String LsR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104780);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LsK == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegWord");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.LsL == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.LsM == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.LsK != null) {
        paramVarArgs.e(1, this.LsK);
      }
      if (this.LsL != null) {
        paramVarArgs.e(2, this.LsL);
      }
      if (this.LsM != null) {
        paramVarArgs.e(3, this.LsM);
      }
      if (this.LsN != null) {
        paramVarArgs.e(4, this.LsN);
      }
      if (this.LsO != null) {
        paramVarArgs.e(5, this.LsO);
      }
      paramVarArgs.aM(6, this.LsP);
      paramVarArgs.aM(7, this.LsQ);
      if (this.LsR != null) {
        paramVarArgs.e(8, this.LsR);
      }
      paramVarArgs.aM(9, this.KHa);
      AppMethodBeat.o(104780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LsK == null) {
        break label798;
      }
    }
    label798:
    for (int i = g.a.a.b.b.a.f(1, this.LsK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LsL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LsL);
      }
      i = paramInt;
      if (this.LsM != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LsM);
      }
      paramInt = i;
      if (this.LsN != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LsN);
      }
      i = paramInt;
      if (this.LsO != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LsO);
      }
      i = i + g.a.a.b.b.a.bu(6, this.LsP) + g.a.a.b.b.a.bu(7, this.LsQ);
      paramInt = i;
      if (this.LsR != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LsR);
      }
      i = g.a.a.b.b.a.bu(9, this.KHa);
      AppMethodBeat.o(104780);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LsK == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegWord");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.LsL == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.LsM == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104780);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ajg localajg = (ajg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104780);
          return -1;
        case 1: 
          localajg.LsK = locala.UbS.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 2: 
          localajg.LsL = locala.UbS.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 3: 
          localajg.LsM = locala.UbS.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 4: 
          localajg.LsN = locala.UbS.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 5: 
          localajg.LsO = locala.UbS.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 6: 
          localajg.LsP = locala.UbS.zi();
          AppMethodBeat.o(104780);
          return 0;
        case 7: 
          localajg.LsQ = locala.UbS.zi();
          AppMethodBeat.o(104780);
          return 0;
        case 8: 
          localajg.LsR = locala.UbS.readString();
          AppMethodBeat.o(104780);
          return 0;
        }
        localajg.KHa = locala.UbS.zi();
        AppMethodBeat.o(104780);
        return 0;
      }
      AppMethodBeat.o(104780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajg
 * JD-Core Version:    0.7.0.1
 */