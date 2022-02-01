package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddk
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int FIY;
  public int FIZ;
  public int FJd;
  public String FNa;
  public String FNb;
  public int FNc;
  public int FNd;
  public int FNe;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public String hkR;
  public String tlJ;
  public String tlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118438);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Id);
      if (this.tlK != null) {
        paramVarArgs.d(2, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(3, this.tlJ);
      }
      if (this.FNa != null) {
        paramVarArgs.d(4, this.FNa);
      }
      if (this.FNb != null) {
        paramVarArgs.d(5, this.FNb);
      }
      paramVarArgs.aR(6, this.CreateTime);
      if (this.hkR != null) {
        paramVarArgs.d(7, this.hkR);
      }
      paramVarArgs.aR(8, this.FNc);
      paramVarArgs.aR(9, this.FJd);
      paramVarArgs.aR(10, this.FIY);
      paramVarArgs.aR(11, this.FIZ);
      paramVarArgs.aR(12, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(13, this.ThumbUrl);
      }
      paramVarArgs.aR(14, this.FNd);
      paramVarArgs.aR(15, this.FNe);
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.tlK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tlK);
      }
      i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlJ);
      }
      paramInt = i;
      if (this.FNa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FNa);
      }
      i = paramInt;
      if (this.FNb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FNb);
      }
      i += f.a.a.b.b.a.bx(6, this.CreateTime);
      paramInt = i;
      if (this.hkR != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hkR);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.FNc) + f.a.a.b.b.a.bx(9, this.FJd) + f.a.a.b.b.a.bx(10, this.FIY) + f.a.a.b.b.a.bx(11, this.FIZ) + f.a.a.b.b.a.bx(12, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.ThumbUrl);
      }
      i = f.a.a.b.b.a.bx(14, this.FNd);
      int j = f.a.a.b.b.a.bx(15, this.FNe);
      AppMethodBeat.o(118438);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ddk localddk = (ddk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118438);
        return -1;
      case 1: 
        localddk.Id = locala.LVo.xG();
        AppMethodBeat.o(118438);
        return 0;
      case 2: 
        localddk.tlK = locala.LVo.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 3: 
        localddk.tlJ = locala.LVo.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 4: 
        localddk.FNa = locala.LVo.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 5: 
        localddk.FNb = locala.LVo.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 6: 
        localddk.CreateTime = locala.LVo.xF();
        AppMethodBeat.o(118438);
        return 0;
      case 7: 
        localddk.hkR = locala.LVo.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 8: 
        localddk.FNc = locala.LVo.xF();
        AppMethodBeat.o(118438);
        return 0;
      case 9: 
        localddk.FJd = locala.LVo.xF();
        AppMethodBeat.o(118438);
        return 0;
      case 10: 
        localddk.FIY = locala.LVo.xF();
        AppMethodBeat.o(118438);
        return 0;
      case 11: 
        localddk.FIZ = locala.LVo.xF();
        AppMethodBeat.o(118438);
        return 0;
      case 12: 
        localddk.IsNotRichText = locala.LVo.xF();
        AppMethodBeat.o(118438);
        return 0;
      case 13: 
        localddk.ThumbUrl = locala.LVo.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 14: 
        localddk.FNd = locala.LVo.xF();
        AppMethodBeat.o(118438);
        return 0;
      }
      localddk.FNe = locala.LVo.xF();
      AppMethodBeat.o(118438);
      return 0;
    }
    AppMethodBeat.o(118438);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddk
 * JD-Core Version:    0.7.0.1
 */