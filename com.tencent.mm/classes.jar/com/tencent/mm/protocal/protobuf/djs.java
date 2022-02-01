package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djs
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int HNj;
  public int HNk;
  public int HNo;
  public int HRA;
  public String HRw;
  public String HRx;
  public int HRy;
  public int HRz;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public String hFS;
  public String uvF;
  public String uvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118438);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Id);
      if (this.uvG != null) {
        paramVarArgs.d(2, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(3, this.uvF);
      }
      if (this.HRw != null) {
        paramVarArgs.d(4, this.HRw);
      }
      if (this.HRx != null) {
        paramVarArgs.d(5, this.HRx);
      }
      paramVarArgs.aS(6, this.CreateTime);
      if (this.hFS != null) {
        paramVarArgs.d(7, this.hFS);
      }
      paramVarArgs.aS(8, this.HRy);
      paramVarArgs.aS(9, this.HNo);
      paramVarArgs.aS(10, this.HNj);
      paramVarArgs.aS(11, this.HNk);
      paramVarArgs.aS(12, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(13, this.ThumbUrl);
      }
      paramVarArgs.aS(14, this.HRz);
      paramVarArgs.aS(15, this.HRA);
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.uvG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uvG);
      }
      i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvF);
      }
      paramInt = i;
      if (this.HRw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HRw);
      }
      i = paramInt;
      if (this.HRx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HRx);
      }
      i += f.a.a.b.b.a.bz(6, this.CreateTime);
      paramInt = i;
      if (this.hFS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hFS);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HRy) + f.a.a.b.b.a.bz(9, this.HNo) + f.a.a.b.b.a.bz(10, this.HNj) + f.a.a.b.b.a.bz(11, this.HNk) + f.a.a.b.b.a.bz(12, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.ThumbUrl);
      }
      i = f.a.a.b.b.a.bz(14, this.HRz);
      int j = f.a.a.b.b.a.bz(15, this.HRA);
      AppMethodBeat.o(118438);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(118438);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      djs localdjs = (djs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118438);
        return -1;
      case 1: 
        localdjs.Id = locala.OmT.zd();
        AppMethodBeat.o(118438);
        return 0;
      case 2: 
        localdjs.uvG = locala.OmT.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 3: 
        localdjs.uvF = locala.OmT.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 4: 
        localdjs.HRw = locala.OmT.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 5: 
        localdjs.HRx = locala.OmT.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 6: 
        localdjs.CreateTime = locala.OmT.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 7: 
        localdjs.hFS = locala.OmT.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 8: 
        localdjs.HRy = locala.OmT.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 9: 
        localdjs.HNo = locala.OmT.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 10: 
        localdjs.HNj = locala.OmT.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 11: 
        localdjs.HNk = locala.OmT.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 12: 
        localdjs.IsNotRichText = locala.OmT.zc();
        AppMethodBeat.o(118438);
        return 0;
      case 13: 
        localdjs.ThumbUrl = locala.OmT.readString();
        AppMethodBeat.o(118438);
        return 0;
      case 14: 
        localdjs.HRz = locala.OmT.zc();
        AppMethodBeat.o(118438);
        return 0;
      }
      localdjs.HRA = locala.OmT.zc();
      AppMethodBeat.o(118438);
      return 0;
    }
    AppMethodBeat.o(118438);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djs
 * JD-Core Version:    0.7.0.1
 */