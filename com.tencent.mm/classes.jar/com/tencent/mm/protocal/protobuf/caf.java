package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class caf
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String DWH;
  public String DWI;
  public int DWt;
  public String scR;
  public String uoY;
  public String upa;
  public String upb;
  public int upc;
  public String upd;
  public int upe;
  public int upf;
  public String uph;
  public String upi;
  public String upj;
  public String upk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uoY != null) {
        paramVarArgs.d(1, this.uoY);
      }
      paramVarArgs.aR(2, this.DWt);
      if (this.upa != null) {
        paramVarArgs.d(3, this.upa);
      }
      paramVarArgs.aR(4, this.CreateTime);
      if (this.upb != null) {
        paramVarArgs.d(5, this.upb);
      }
      paramVarArgs.aR(6, this.upc);
      if (this.upd != null) {
        paramVarArgs.d(7, this.upd);
      }
      paramVarArgs.aR(8, this.upe);
      paramVarArgs.aR(9, this.upf);
      if (this.scR != null) {
        paramVarArgs.d(11, this.scR);
      }
      if (this.uph != null) {
        paramVarArgs.d(12, this.uph);
      }
      if (this.upi != null) {
        paramVarArgs.d(13, this.upi);
      }
      if (this.upj != null) {
        paramVarArgs.d(14, this.upj);
      }
      if (this.upk != null) {
        paramVarArgs.d(15, this.upk);
      }
      if (this.DWH != null) {
        paramVarArgs.d(18, this.DWH);
      }
      if (this.DWI != null) {
        paramVarArgs.d(19, this.DWI);
      }
      AppMethodBeat.o(91612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uoY == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.b.b.a.e(1, this.uoY) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DWt);
      paramInt = i;
      if (this.upa != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.upa);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.CreateTime);
      paramInt = i;
      if (this.upb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.upb);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.upc);
      paramInt = i;
      if (this.upd != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.upd);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.upe) + f.a.a.b.b.a.bA(9, this.upf);
      paramInt = i;
      if (this.scR != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.scR);
      }
      i = paramInt;
      if (this.uph != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.uph);
      }
      paramInt = i;
      if (this.upi != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.upi);
      }
      i = paramInt;
      if (this.upj != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.upj);
      }
      paramInt = i;
      if (this.upk != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.upk);
      }
      i = paramInt;
      if (this.DWH != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.DWH);
      }
      paramInt = i;
      if (this.DWI != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.DWI);
      }
      AppMethodBeat.o(91612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91612);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        caf localcaf = (caf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(91612);
          return -1;
        case 1: 
          localcaf.uoY = locala.KhF.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 2: 
          localcaf.DWt = locala.KhF.xS();
          AppMethodBeat.o(91612);
          return 0;
        case 3: 
          localcaf.upa = locala.KhF.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 4: 
          localcaf.CreateTime = locala.KhF.xS();
          AppMethodBeat.o(91612);
          return 0;
        case 5: 
          localcaf.upb = locala.KhF.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 6: 
          localcaf.upc = locala.KhF.xS();
          AppMethodBeat.o(91612);
          return 0;
        case 7: 
          localcaf.upd = locala.KhF.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 8: 
          localcaf.upe = locala.KhF.xS();
          AppMethodBeat.o(91612);
          return 0;
        case 9: 
          localcaf.upf = locala.KhF.xS();
          AppMethodBeat.o(91612);
          return 0;
        case 11: 
          localcaf.scR = locala.KhF.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 12: 
          localcaf.uph = locala.KhF.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 13: 
          localcaf.upi = locala.KhF.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 14: 
          localcaf.upj = locala.KhF.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 15: 
          localcaf.upk = locala.KhF.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 18: 
          localcaf.DWH = locala.KhF.readString();
          AppMethodBeat.o(91612);
          return 0;
        }
        localcaf.DWI = locala.KhF.readString();
        AppMethodBeat.o(91612);
        return 0;
      }
      AppMethodBeat.o(91612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caf
 * JD-Core Version:    0.7.0.1
 */