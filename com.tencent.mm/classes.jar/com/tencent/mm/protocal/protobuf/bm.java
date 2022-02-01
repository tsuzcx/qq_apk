package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bm
  extends com.tencent.mm.bw.a
{
  public int FLW;
  public int FLX;
  public b FLY;
  public int FLZ;
  public int FMa;
  public String FMb;
  public String FMc;
  public String FMd;
  public String FMe;
  public String FMf;
  public String FMg;
  public String imei;
  public int uin;
  public String zmV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125690);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uin);
      paramVarArgs.aS(2, this.FLW);
      paramVarArgs.aS(3, this.FLX);
      if (this.FLY != null) {
        paramVarArgs.c(4, this.FLY);
      }
      paramVarArgs.aS(5, this.FLZ);
      paramVarArgs.aS(6, this.FMa);
      if (this.zmV != null) {
        paramVarArgs.d(7, this.zmV);
      }
      if (this.imei != null) {
        paramVarArgs.d(8, this.imei);
      }
      if (this.FMb != null) {
        paramVarArgs.d(9, this.FMb);
      }
      if (this.FMc != null) {
        paramVarArgs.d(10, this.FMc);
      }
      if (this.FMd != null) {
        paramVarArgs.d(11, this.FMd);
      }
      if (this.FMe != null) {
        paramVarArgs.d(12, this.FMe);
      }
      if (this.FMf != null) {
        paramVarArgs.d(13, this.FMf);
      }
      if (this.FMg != null) {
        paramVarArgs.d(14, this.FMg);
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uin) + 0 + f.a.a.b.b.a.bz(2, this.FLW) + f.a.a.b.b.a.bz(3, this.FLX);
      paramInt = i;
      if (this.FLY != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FLY);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FLZ) + f.a.a.b.b.a.bz(6, this.FMa);
      paramInt = i;
      if (this.zmV != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.zmV);
      }
      i = paramInt;
      if (this.imei != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.imei);
      }
      paramInt = i;
      if (this.FMb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FMb);
      }
      i = paramInt;
      if (this.FMc != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FMc);
      }
      paramInt = i;
      if (this.FMd != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FMd);
      }
      i = paramInt;
      if (this.FMe != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FMe);
      }
      paramInt = i;
      if (this.FMf != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FMf);
      }
      i = paramInt;
      if (this.FMg != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FMg);
      }
      AppMethodBeat.o(125690);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bm localbm = (bm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125690);
        return -1;
      case 1: 
        localbm.uin = locala.OmT.zc();
        AppMethodBeat.o(125690);
        return 0;
      case 2: 
        localbm.FLW = locala.OmT.zc();
        AppMethodBeat.o(125690);
        return 0;
      case 3: 
        localbm.FLX = locala.OmT.zc();
        AppMethodBeat.o(125690);
        return 0;
      case 4: 
        localbm.FLY = locala.OmT.gCk();
        AppMethodBeat.o(125690);
        return 0;
      case 5: 
        localbm.FLZ = locala.OmT.zc();
        AppMethodBeat.o(125690);
        return 0;
      case 6: 
        localbm.FMa = locala.OmT.zc();
        AppMethodBeat.o(125690);
        return 0;
      case 7: 
        localbm.zmV = locala.OmT.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 8: 
        localbm.imei = locala.OmT.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 9: 
        localbm.FMb = locala.OmT.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 10: 
        localbm.FMc = locala.OmT.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 11: 
        localbm.FMd = locala.OmT.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 12: 
        localbm.FMe = locala.OmT.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 13: 
        localbm.FMf = locala.OmT.readString();
        AppMethodBeat.o(125690);
        return 0;
      }
      localbm.FMg = locala.OmT.readString();
      AppMethodBeat.o(125690);
      return 0;
    }
    AppMethodBeat.o(125690);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bm
 * JD-Core Version:    0.7.0.1
 */