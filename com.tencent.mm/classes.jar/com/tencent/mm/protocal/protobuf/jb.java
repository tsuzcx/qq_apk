package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class jb
  extends com.tencent.mm.bw.a
{
  public String FUw;
  public String FUx;
  public String dPN;
  public String dPO;
  public String dpP;
  public String hFW;
  public String hFX;
  public String hGe;
  public int height;
  public String title;
  public String url;
  public int videoDuration;
  public String videoUrl;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43083);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUw != null) {
        paramVarArgs.d(1, this.FUw);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(2, this.videoUrl);
      }
      if (this.FUx != null) {
        paramVarArgs.d(3, this.FUx);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.hGe != null) {
        paramVarArgs.d(5, this.hGe);
      }
      paramVarArgs.aS(6, this.videoDuration);
      paramVarArgs.aS(7, this.width);
      paramVarArgs.aS(8, this.height);
      if (this.url != null) {
        paramVarArgs.d(9, this.url);
      }
      if (this.dpP != null) {
        paramVarArgs.d(10, this.dpP);
      }
      if (this.hFW != null) {
        paramVarArgs.d(11, this.hFW);
      }
      if (this.hFX != null) {
        paramVarArgs.d(12, this.hFX);
      }
      if (this.dPO != null) {
        paramVarArgs.d(13, this.dPO);
      }
      if (this.dPN != null) {
        paramVarArgs.d(14, this.dPN);
      }
      AppMethodBeat.o(43083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FUw == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.b.b.a.e(1, this.FUw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.videoUrl);
      }
      i = paramInt;
      if (this.FUx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FUx);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt;
      if (this.hGe != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hGe);
      }
      i = i + f.a.a.b.b.a.bz(6, this.videoDuration) + f.a.a.b.b.a.bz(7, this.width) + f.a.a.b.b.a.bz(8, this.height);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.url);
      }
      i = paramInt;
      if (this.dpP != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dpP);
      }
      paramInt = i;
      if (this.hFW != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.hFW);
      }
      i = paramInt;
      if (this.hFX != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.hFX);
      }
      paramInt = i;
      if (this.dPO != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.dPO);
      }
      i = paramInt;
      if (this.dPN != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.dPN);
      }
      AppMethodBeat.o(43083);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(43083);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        jb localjb = (jb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43083);
          return -1;
        case 1: 
          localjb.FUw = locala.OmT.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 2: 
          localjb.videoUrl = locala.OmT.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 3: 
          localjb.FUx = locala.OmT.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 4: 
          localjb.title = locala.OmT.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 5: 
          localjb.hGe = locala.OmT.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 6: 
          localjb.videoDuration = locala.OmT.zc();
          AppMethodBeat.o(43083);
          return 0;
        case 7: 
          localjb.width = locala.OmT.zc();
          AppMethodBeat.o(43083);
          return 0;
        case 8: 
          localjb.height = locala.OmT.zc();
          AppMethodBeat.o(43083);
          return 0;
        case 9: 
          localjb.url = locala.OmT.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 10: 
          localjb.dpP = locala.OmT.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 11: 
          localjb.hFW = locala.OmT.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 12: 
          localjb.hFX = locala.OmT.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 13: 
          localjb.dPO = locala.OmT.readString();
          AppMethodBeat.o(43083);
          return 0;
        }
        localjb.dPN = locala.OmT.readString();
        AppMethodBeat.o(43083);
        return 0;
      }
      AppMethodBeat.o(43083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jb
 * JD-Core Version:    0.7.0.1
 */