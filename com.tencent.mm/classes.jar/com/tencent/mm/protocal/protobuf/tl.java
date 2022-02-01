package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tl
  extends com.tencent.mm.bx.a
{
  public int CVa;
  public String CVb;
  public int CVc;
  public String CVd;
  public int CVe;
  public String CVf;
  public String CVg;
  public String CVh;
  public String CVi;
  public int CVj;
  public String CVk;
  public String Cwo;
  public int odg;
  public String odh;
  public String odn;
  public String odo;
  public String oea;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125715);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CVa);
      if (this.oea != null) {
        paramVarArgs.d(2, this.oea);
      }
      if (this.CVb != null) {
        paramVarArgs.d(3, this.CVb);
      }
      if (this.odn != null) {
        paramVarArgs.d(4, this.odn);
      }
      paramVarArgs.aR(5, this.CVc);
      if (this.CVd != null) {
        paramVarArgs.d(6, this.CVd);
      }
      paramVarArgs.aR(7, this.CVe);
      if (this.odo != null) {
        paramVarArgs.d(8, this.odo);
      }
      if (this.Cwo != null) {
        paramVarArgs.d(9, this.Cwo);
      }
      paramVarArgs.aR(10, this.odg);
      if (this.odh != null) {
        paramVarArgs.d(11, this.odh);
      }
      if (this.CVf != null) {
        paramVarArgs.d(12, this.CVf);
      }
      if (this.CVg != null) {
        paramVarArgs.d(13, this.CVg);
      }
      if (this.CVh != null) {
        paramVarArgs.d(14, this.CVh);
      }
      if (this.CVi != null) {
        paramVarArgs.d(15, this.CVi);
      }
      paramVarArgs.aR(16, this.CVj);
      if (this.CVk != null) {
        paramVarArgs.d(17, this.CVk);
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CVa) + 0;
      paramInt = i;
      if (this.oea != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oea);
      }
      i = paramInt;
      if (this.CVb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CVb);
      }
      paramInt = i;
      if (this.odn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.odn);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CVc);
      paramInt = i;
      if (this.CVd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CVd);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.CVe);
      paramInt = i;
      if (this.odo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.odo);
      }
      i = paramInt;
      if (this.Cwo != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Cwo);
      }
      i += f.a.a.b.b.a.bA(10, this.odg);
      paramInt = i;
      if (this.odh != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.odh);
      }
      i = paramInt;
      if (this.CVf != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.CVf);
      }
      paramInt = i;
      if (this.CVg != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CVg);
      }
      i = paramInt;
      if (this.CVh != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.CVh);
      }
      paramInt = i;
      if (this.CVi != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CVi);
      }
      i = paramInt + f.a.a.b.b.a.bA(16, this.CVj);
      paramInt = i;
      if (this.CVk != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.CVk);
      }
      AppMethodBeat.o(125715);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125715);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      tl localtl = (tl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125715);
        return -1;
      case 1: 
        localtl.CVa = locala.KhF.xS();
        AppMethodBeat.o(125715);
        return 0;
      case 2: 
        localtl.oea = locala.KhF.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 3: 
        localtl.CVb = locala.KhF.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 4: 
        localtl.odn = locala.KhF.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 5: 
        localtl.CVc = locala.KhF.xS();
        AppMethodBeat.o(125715);
        return 0;
      case 6: 
        localtl.CVd = locala.KhF.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 7: 
        localtl.CVe = locala.KhF.xS();
        AppMethodBeat.o(125715);
        return 0;
      case 8: 
        localtl.odo = locala.KhF.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 9: 
        localtl.Cwo = locala.KhF.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 10: 
        localtl.odg = locala.KhF.xS();
        AppMethodBeat.o(125715);
        return 0;
      case 11: 
        localtl.odh = locala.KhF.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 12: 
        localtl.CVf = locala.KhF.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 13: 
        localtl.CVg = locala.KhF.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 14: 
        localtl.CVh = locala.KhF.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 15: 
        localtl.CVi = locala.KhF.readString();
        AppMethodBeat.o(125715);
        return 0;
      case 16: 
        localtl.CVj = locala.KhF.xS();
        AppMethodBeat.o(125715);
        return 0;
      }
      localtl.CVk = locala.KhF.readString();
      AppMethodBeat.o(125715);
      return 0;
    }
    AppMethodBeat.o(125715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tl
 * JD-Core Version:    0.7.0.1
 */