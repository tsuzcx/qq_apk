package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class iu
  extends com.tencent.mm.bw.a
{
  public String DWF;
  public String DWG;
  public String dCk;
  public String dCl;
  public String ddo;
  public int height;
  public String hkV;
  public String hkW;
  public String hld;
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
      if (this.DWF != null) {
        paramVarArgs.d(1, this.DWF);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(2, this.videoUrl);
      }
      if (this.DWG != null) {
        paramVarArgs.d(3, this.DWG);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.hld != null) {
        paramVarArgs.d(5, this.hld);
      }
      paramVarArgs.aR(6, this.videoDuration);
      paramVarArgs.aR(7, this.width);
      paramVarArgs.aR(8, this.height);
      if (this.url != null) {
        paramVarArgs.d(9, this.url);
      }
      if (this.ddo != null) {
        paramVarArgs.d(10, this.ddo);
      }
      if (this.hkV != null) {
        paramVarArgs.d(11, this.hkV);
      }
      if (this.hkW != null) {
        paramVarArgs.d(12, this.hkW);
      }
      if (this.dCl != null) {
        paramVarArgs.d(13, this.dCl);
      }
      if (this.dCk != null) {
        paramVarArgs.d(14, this.dCk);
      }
      AppMethodBeat.o(43083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DWF == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.b.b.a.e(1, this.DWF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.videoUrl);
      }
      i = paramInt;
      if (this.DWG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DWG);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt;
      if (this.hld != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hld);
      }
      i = i + f.a.a.b.b.a.bx(6, this.videoDuration) + f.a.a.b.b.a.bx(7, this.width) + f.a.a.b.b.a.bx(8, this.height);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.url);
      }
      i = paramInt;
      if (this.ddo != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.ddo);
      }
      paramInt = i;
      if (this.hkV != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.hkV);
      }
      i = paramInt;
      if (this.hkW != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.hkW);
      }
      paramInt = i;
      if (this.dCl != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.dCl);
      }
      i = paramInt;
      if (this.dCk != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.dCk);
      }
      AppMethodBeat.o(43083);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(43083);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        iu localiu = (iu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43083);
          return -1;
        case 1: 
          localiu.DWF = locala.LVo.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 2: 
          localiu.videoUrl = locala.LVo.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 3: 
          localiu.DWG = locala.LVo.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 4: 
          localiu.title = locala.LVo.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 5: 
          localiu.hld = locala.LVo.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 6: 
          localiu.videoDuration = locala.LVo.xF();
          AppMethodBeat.o(43083);
          return 0;
        case 7: 
          localiu.width = locala.LVo.xF();
          AppMethodBeat.o(43083);
          return 0;
        case 8: 
          localiu.height = locala.LVo.xF();
          AppMethodBeat.o(43083);
          return 0;
        case 9: 
          localiu.url = locala.LVo.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 10: 
          localiu.ddo = locala.LVo.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 11: 
          localiu.hkV = locala.LVo.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 12: 
          localiu.hkW = locala.LVo.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 13: 
          localiu.dCl = locala.LVo.readString();
          AppMethodBeat.o(43083);
          return 0;
        }
        localiu.dCk = locala.LVo.readString();
        AppMethodBeat.o(43083);
        return 0;
      }
      AppMethodBeat.o(43083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iu
 * JD-Core Version:    0.7.0.1
 */