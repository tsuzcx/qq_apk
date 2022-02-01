package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class jb
  extends com.tencent.mm.bx.a
{
  public String FCb;
  public String FCc;
  public String dOx;
  public String dOy;
  public String doK;
  public String hDe;
  public String hDf;
  public String hDm;
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
      if (this.FCb != null) {
        paramVarArgs.d(1, this.FCb);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(2, this.videoUrl);
      }
      if (this.FCc != null) {
        paramVarArgs.d(3, this.FCc);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.hDm != null) {
        paramVarArgs.d(5, this.hDm);
      }
      paramVarArgs.aS(6, this.videoDuration);
      paramVarArgs.aS(7, this.width);
      paramVarArgs.aS(8, this.height);
      if (this.url != null) {
        paramVarArgs.d(9, this.url);
      }
      if (this.doK != null) {
        paramVarArgs.d(10, this.doK);
      }
      if (this.hDe != null) {
        paramVarArgs.d(11, this.hDe);
      }
      if (this.hDf != null) {
        paramVarArgs.d(12, this.hDf);
      }
      if (this.dOy != null) {
        paramVarArgs.d(13, this.dOy);
      }
      if (this.dOx != null) {
        paramVarArgs.d(14, this.dOx);
      }
      AppMethodBeat.o(43083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FCb == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.b.b.a.e(1, this.FCb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.videoUrl);
      }
      i = paramInt;
      if (this.FCc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FCc);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt;
      if (this.hDm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hDm);
      }
      i = i + f.a.a.b.b.a.bz(6, this.videoDuration) + f.a.a.b.b.a.bz(7, this.width) + f.a.a.b.b.a.bz(8, this.height);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.url);
      }
      i = paramInt;
      if (this.doK != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.doK);
      }
      paramInt = i;
      if (this.hDe != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.hDe);
      }
      i = paramInt;
      if (this.hDf != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.hDf);
      }
      paramInt = i;
      if (this.dOy != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.dOy);
      }
      i = paramInt;
      if (this.dOx != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.dOx);
      }
      AppMethodBeat.o(43083);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          localjb.FCb = locala.NPN.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 2: 
          localjb.videoUrl = locala.NPN.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 3: 
          localjb.FCc = locala.NPN.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 4: 
          localjb.title = locala.NPN.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 5: 
          localjb.hDm = locala.NPN.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 6: 
          localjb.videoDuration = locala.NPN.zc();
          AppMethodBeat.o(43083);
          return 0;
        case 7: 
          localjb.width = locala.NPN.zc();
          AppMethodBeat.o(43083);
          return 0;
        case 8: 
          localjb.height = locala.NPN.zc();
          AppMethodBeat.o(43083);
          return 0;
        case 9: 
          localjb.url = locala.NPN.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 10: 
          localjb.doK = locala.NPN.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 11: 
          localjb.hDe = locala.NPN.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 12: 
          localjb.hDf = locala.NPN.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 13: 
          localjb.dOy = locala.NPN.readString();
          AppMethodBeat.o(43083);
          return 0;
        }
        localjb.dOx = locala.NPN.readString();
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