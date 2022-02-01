package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class jd
  extends com.tencent.mm.cd.a
{
  public String ROZ;
  public String RPa;
  public String fzT;
  public String gch;
  public String gci;
  public int height;
  public String lpC;
  public String lpD;
  public String lpK;
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ROZ != null) {
        paramVarArgs.f(1, this.ROZ);
      }
      if (this.videoUrl != null) {
        paramVarArgs.f(2, this.videoUrl);
      }
      if (this.RPa != null) {
        paramVarArgs.f(3, this.RPa);
      }
      if (this.title != null) {
        paramVarArgs.f(4, this.title);
      }
      if (this.lpK != null) {
        paramVarArgs.f(5, this.lpK);
      }
      paramVarArgs.aY(6, this.videoDuration);
      paramVarArgs.aY(7, this.width);
      paramVarArgs.aY(8, this.height);
      if (this.url != null) {
        paramVarArgs.f(9, this.url);
      }
      if (this.fzT != null) {
        paramVarArgs.f(10, this.fzT);
      }
      if (this.lpC != null) {
        paramVarArgs.f(11, this.lpC);
      }
      if (this.lpD != null) {
        paramVarArgs.f(12, this.lpD);
      }
      if (this.gci != null) {
        paramVarArgs.f(13, this.gci);
      }
      if (this.gch != null) {
        paramVarArgs.f(14, this.gch);
      }
      AppMethodBeat.o(43083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ROZ == null) {
        break label962;
      }
    }
    label962:
    for (int i = g.a.a.b.b.a.g(1, this.ROZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.videoUrl);
      }
      i = paramInt;
      if (this.RPa != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RPa);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.title);
      }
      i = paramInt;
      if (this.lpK != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.lpK);
      }
      i = i + g.a.a.b.b.a.bM(6, this.videoDuration) + g.a.a.b.b.a.bM(7, this.width) + g.a.a.b.b.a.bM(8, this.height);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.url);
      }
      i = paramInt;
      if (this.fzT != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.fzT);
      }
      paramInt = i;
      if (this.lpC != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.lpC);
      }
      i = paramInt;
      if (this.lpD != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.lpD);
      }
      paramInt = i;
      if (this.gci != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.gci);
      }
      i = paramInt;
      if (this.gch != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.gch);
      }
      AppMethodBeat.o(43083);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(43083);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        jd localjd = (jd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43083);
          return -1;
        case 1: 
          localjd.ROZ = locala.abFh.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 2: 
          localjd.videoUrl = locala.abFh.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 3: 
          localjd.RPa = locala.abFh.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 4: 
          localjd.title = locala.abFh.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 5: 
          localjd.lpK = locala.abFh.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 6: 
          localjd.videoDuration = locala.abFh.AK();
          AppMethodBeat.o(43083);
          return 0;
        case 7: 
          localjd.width = locala.abFh.AK();
          AppMethodBeat.o(43083);
          return 0;
        case 8: 
          localjd.height = locala.abFh.AK();
          AppMethodBeat.o(43083);
          return 0;
        case 9: 
          localjd.url = locala.abFh.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 10: 
          localjd.fzT = locala.abFh.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 11: 
          localjd.lpC = locala.abFh.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 12: 
          localjd.lpD = locala.abFh.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 13: 
          localjd.gci = locala.abFh.readString();
          AppMethodBeat.o(43083);
          return 0;
        }
        localjd.gch = locala.abFh.readString();
        AppMethodBeat.o(43083);
        return 0;
      }
      AppMethodBeat.o(43083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jd
 * JD-Core Version:    0.7.0.1
 */