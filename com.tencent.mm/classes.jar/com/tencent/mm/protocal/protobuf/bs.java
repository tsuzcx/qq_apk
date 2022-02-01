package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bs
  extends com.tencent.mm.bw.a
{
  public String Dsg;
  public b KFA;
  public int KFB;
  public int KFC;
  public String KFD;
  public String KFE;
  public String KFF;
  public String KFG;
  public String KFH;
  public String KFI;
  public int KFy;
  public int KFz;
  public String imei;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125690);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.uin);
      paramVarArgs.aM(2, this.KFy);
      paramVarArgs.aM(3, this.KFz);
      if (this.KFA != null) {
        paramVarArgs.c(4, this.KFA);
      }
      paramVarArgs.aM(5, this.KFB);
      paramVarArgs.aM(6, this.KFC);
      if (this.Dsg != null) {
        paramVarArgs.e(7, this.Dsg);
      }
      if (this.imei != null) {
        paramVarArgs.e(8, this.imei);
      }
      if (this.KFD != null) {
        paramVarArgs.e(9, this.KFD);
      }
      if (this.KFE != null) {
        paramVarArgs.e(10, this.KFE);
      }
      if (this.KFF != null) {
        paramVarArgs.e(11, this.KFF);
      }
      if (this.KFG != null) {
        paramVarArgs.e(12, this.KFG);
      }
      if (this.KFH != null) {
        paramVarArgs.e(13, this.KFH);
      }
      if (this.KFI != null) {
        paramVarArgs.e(14, this.KFI);
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.uin) + 0 + g.a.a.b.b.a.bu(2, this.KFy) + g.a.a.b.b.a.bu(3, this.KFz);
      paramInt = i;
      if (this.KFA != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.KFA);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KFB) + g.a.a.b.b.a.bu(6, this.KFC);
      paramInt = i;
      if (this.Dsg != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Dsg);
      }
      i = paramInt;
      if (this.imei != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.imei);
      }
      paramInt = i;
      if (this.KFD != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.KFD);
      }
      i = paramInt;
      if (this.KFE != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.KFE);
      }
      paramInt = i;
      if (this.KFF != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KFF);
      }
      i = paramInt;
      if (this.KFG != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.KFG);
      }
      paramInt = i;
      if (this.KFH != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.KFH);
      }
      i = paramInt;
      if (this.KFI != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.KFI);
      }
      AppMethodBeat.o(125690);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bs localbs = (bs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125690);
        return -1;
      case 1: 
        localbs.uin = locala.UbS.zi();
        AppMethodBeat.o(125690);
        return 0;
      case 2: 
        localbs.KFy = locala.UbS.zi();
        AppMethodBeat.o(125690);
        return 0;
      case 3: 
        localbs.KFz = locala.UbS.zi();
        AppMethodBeat.o(125690);
        return 0;
      case 4: 
        localbs.KFA = locala.UbS.hPo();
        AppMethodBeat.o(125690);
        return 0;
      case 5: 
        localbs.KFB = locala.UbS.zi();
        AppMethodBeat.o(125690);
        return 0;
      case 6: 
        localbs.KFC = locala.UbS.zi();
        AppMethodBeat.o(125690);
        return 0;
      case 7: 
        localbs.Dsg = locala.UbS.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 8: 
        localbs.imei = locala.UbS.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 9: 
        localbs.KFD = locala.UbS.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 10: 
        localbs.KFE = locala.UbS.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 11: 
        localbs.KFF = locala.UbS.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 12: 
        localbs.KFG = locala.UbS.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 13: 
        localbs.KFH = locala.UbS.readString();
        AppMethodBeat.o(125690);
        return 0;
      }
      localbs.KFI = locala.UbS.readString();
      AppMethodBeat.o(125690);
      return 0;
    }
    AppMethodBeat.o(125690);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bs
 * JD-Core Version:    0.7.0.1
 */