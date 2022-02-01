package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bmn
  extends com.tencent.mm.bx.a
{
  public float COI;
  public float COJ;
  public String DJX;
  public int DJY;
  public int DJZ;
  public b DKa;
  public String DKb;
  public String DlE;
  public float bQL;
  public String country;
  public String goQ;
  public String ijO;
  public int score;
  public String xoe;
  public int xog;
  public int xoi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125739);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.COI);
      paramVarArgs.x(2, this.COJ);
      if (this.ijO != null) {
        paramVarArgs.d(3, this.ijO);
      }
      if (this.goQ != null) {
        paramVarArgs.d(4, this.goQ);
      }
      if (this.xoe != null) {
        paramVarArgs.d(5, this.xoe);
      }
      if (this.DlE != null) {
        paramVarArgs.d(6, this.DlE);
      }
      paramVarArgs.aR(7, this.xog);
      if (this.DJX != null) {
        paramVarArgs.d(8, this.DJX);
      }
      paramVarArgs.aR(9, this.DJY);
      paramVarArgs.aR(10, this.DJZ);
      paramVarArgs.aR(11, this.xoi);
      paramVarArgs.x(12, this.bQL);
      if (this.DKa != null) {
        paramVarArgs.c(13, this.DKa);
      }
      paramVarArgs.aR(14, this.score);
      if (this.DKb != null) {
        paramVarArgs.d(15, this.DKb);
      }
      if (this.country != null) {
        paramVarArgs.d(16, this.country);
      }
      AppMethodBeat.o(125739);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 4 + 0 + (f.a.a.b.b.a.fY(2) + 4);
      paramInt = i;
      if (this.ijO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ijO);
      }
      i = paramInt;
      if (this.goQ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.goQ);
      }
      paramInt = i;
      if (this.xoe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.xoe);
      }
      i = paramInt;
      if (this.DlE != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DlE);
      }
      i += f.a.a.b.b.a.bA(7, this.xog);
      paramInt = i;
      if (this.DJX != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DJX);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.DJY) + f.a.a.b.b.a.bA(10, this.DJZ) + f.a.a.b.b.a.bA(11, this.xoi) + (f.a.a.b.b.a.fY(12) + 4);
      paramInt = i;
      if (this.DKa != null) {
        paramInt = i + f.a.a.b.b.a.b(13, this.DKa);
      }
      i = paramInt + f.a.a.b.b.a.bA(14, this.score);
      paramInt = i;
      if (this.DKb != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DKb);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.country);
      }
      AppMethodBeat.o(125739);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125739);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bmn localbmn = (bmn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125739);
        return -1;
      case 1: 
        localbmn.COI = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125739);
        return 0;
      case 2: 
        localbmn.COJ = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125739);
        return 0;
      case 3: 
        localbmn.ijO = locala.KhF.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 4: 
        localbmn.goQ = locala.KhF.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 5: 
        localbmn.xoe = locala.KhF.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 6: 
        localbmn.DlE = locala.KhF.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 7: 
        localbmn.xog = locala.KhF.xS();
        AppMethodBeat.o(125739);
        return 0;
      case 8: 
        localbmn.DJX = locala.KhF.readString();
        AppMethodBeat.o(125739);
        return 0;
      case 9: 
        localbmn.DJY = locala.KhF.xS();
        AppMethodBeat.o(125739);
        return 0;
      case 10: 
        localbmn.DJZ = locala.KhF.xS();
        AppMethodBeat.o(125739);
        return 0;
      case 11: 
        localbmn.xoi = locala.KhF.xS();
        AppMethodBeat.o(125739);
        return 0;
      case 12: 
        localbmn.bQL = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125739);
        return 0;
      case 13: 
        localbmn.DKa = locala.KhF.fMu();
        AppMethodBeat.o(125739);
        return 0;
      case 14: 
        localbmn.score = locala.KhF.xS();
        AppMethodBeat.o(125739);
        return 0;
      case 15: 
        localbmn.DKb = locala.KhF.readString();
        AppMethodBeat.o(125739);
        return 0;
      }
      localbmn.country = locala.KhF.readString();
      AppMethodBeat.o(125739);
      return 0;
    }
    AppMethodBeat.o(125739);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmn
 * JD-Core Version:    0.7.0.1
 */