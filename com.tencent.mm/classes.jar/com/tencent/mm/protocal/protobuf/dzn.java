package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dzn
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public String MpP;
  public double YTc;
  public double YTd;
  public String Zqh;
  public String Zqi;
  public String abeG;
  public String abeH;
  public String abeI;
  public String abeJ;
  public String pSg;
  public String pSh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56257);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGU != null) {
        paramVarArgs.g(1, this.IGU);
      }
      if (this.abeG != null) {
        paramVarArgs.g(2, this.abeG);
      }
      paramVarArgs.d(3, this.YTc);
      paramVarArgs.d(4, this.YTd);
      if (this.abeH != null) {
        paramVarArgs.g(5, this.abeH);
      }
      if (this.MpP != null) {
        paramVarArgs.g(6, this.MpP);
      }
      if (this.abeI != null) {
        paramVarArgs.g(7, this.abeI);
      }
      if (this.pSg != null) {
        paramVarArgs.g(8, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(9, this.pSh);
      }
      if (this.Zqh != null) {
        paramVarArgs.g(10, this.Zqh);
      }
      if (this.Zqi != null) {
        paramVarArgs.g(11, this.Zqi);
      }
      if (this.abeJ != null) {
        paramVarArgs.g(12, this.abeJ);
      }
      AppMethodBeat.o(56257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGU == null) {
        break label856;
      }
    }
    label856:
    for (paramInt = i.a.a.b.b.a.h(1, this.IGU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abeG != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abeG);
      }
      i = i + (i.a.a.b.b.a.ko(3) + 8) + (i.a.a.b.b.a.ko(4) + 8);
      paramInt = i;
      if (this.abeH != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abeH);
      }
      i = paramInt;
      if (this.MpP != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.MpP);
      }
      paramInt = i;
      if (this.abeI != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abeI);
      }
      i = paramInt;
      if (this.pSg != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.pSg);
      }
      paramInt = i;
      if (this.pSh != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.pSh);
      }
      i = paramInt;
      if (this.Zqh != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.Zqh);
      }
      paramInt = i;
      if (this.Zqi != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.Zqi);
      }
      i = paramInt;
      if (this.abeJ != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.abeJ);
      }
      AppMethodBeat.o(56257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(56257);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dzn localdzn = (dzn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56257);
          return -1;
        case 1: 
          localdzn.IGU = locala.ajGk.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 2: 
          localdzn.abeG = locala.ajGk.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 3: 
          localdzn.YTc = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(56257);
          return 0;
        case 4: 
          localdzn.YTd = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(56257);
          return 0;
        case 5: 
          localdzn.abeH = locala.ajGk.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 6: 
          localdzn.MpP = locala.ajGk.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 7: 
          localdzn.abeI = locala.ajGk.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 8: 
          localdzn.pSg = locala.ajGk.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 9: 
          localdzn.pSh = locala.ajGk.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 10: 
          localdzn.Zqh = locala.ajGk.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 11: 
          localdzn.Zqi = locala.ajGk.readString();
          AppMethodBeat.o(56257);
          return 0;
        }
        localdzn.abeJ = locala.ajGk.readString();
        AppMethodBeat.o(56257);
        return 0;
      }
      AppMethodBeat.o(56257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzn
 * JD-Core Version:    0.7.0.1
 */