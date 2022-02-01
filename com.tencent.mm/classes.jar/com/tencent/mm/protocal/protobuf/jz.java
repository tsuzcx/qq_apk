package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class jz
  extends com.tencent.mm.bx.a
{
  public String YMm;
  public String YMn;
  public String hEE;
  public int height;
  public String iit;
  public String iiu;
  public String mso;
  public String nUF;
  public String nUM;
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YMm != null) {
        paramVarArgs.g(1, this.YMm);
      }
      if (this.videoUrl != null) {
        paramVarArgs.g(2, this.videoUrl);
      }
      if (this.YMn != null) {
        paramVarArgs.g(3, this.YMn);
      }
      if (this.title != null) {
        paramVarArgs.g(4, this.title);
      }
      if (this.nUM != null) {
        paramVarArgs.g(5, this.nUM);
      }
      paramVarArgs.bS(6, this.videoDuration);
      paramVarArgs.bS(7, this.width);
      paramVarArgs.bS(8, this.height);
      if (this.url != null) {
        paramVarArgs.g(9, this.url);
      }
      if (this.hEE != null) {
        paramVarArgs.g(10, this.hEE);
      }
      if (this.nUF != null) {
        paramVarArgs.g(11, this.nUF);
      }
      if (this.mso != null) {
        paramVarArgs.g(12, this.mso);
      }
      if (this.iiu != null) {
        paramVarArgs.g(13, this.iiu);
      }
      if (this.iit != null) {
        paramVarArgs.g(14, this.iit);
      }
      AppMethodBeat.o(43083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YMm == null) {
        break label958;
      }
    }
    label958:
    for (int i = i.a.a.b.b.a.h(1, this.YMm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.videoUrl);
      }
      i = paramInt;
      if (this.YMn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YMn);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.title);
      }
      i = paramInt;
      if (this.nUM != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.nUM);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.videoDuration) + i.a.a.b.b.a.cJ(7, this.width) + i.a.a.b.b.a.cJ(8, this.height);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.url);
      }
      i = paramInt;
      if (this.hEE != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.hEE);
      }
      paramInt = i;
      if (this.nUF != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.nUF);
      }
      i = paramInt;
      if (this.mso != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.mso);
      }
      paramInt = i;
      if (this.iiu != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.iiu);
      }
      i = paramInt;
      if (this.iit != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.iit);
      }
      AppMethodBeat.o(43083);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(43083);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        jz localjz = (jz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43083);
          return -1;
        case 1: 
          localjz.YMm = locala.ajGk.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 2: 
          localjz.videoUrl = locala.ajGk.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 3: 
          localjz.YMn = locala.ajGk.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 4: 
          localjz.title = locala.ajGk.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 5: 
          localjz.nUM = locala.ajGk.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 6: 
          localjz.videoDuration = locala.ajGk.aar();
          AppMethodBeat.o(43083);
          return 0;
        case 7: 
          localjz.width = locala.ajGk.aar();
          AppMethodBeat.o(43083);
          return 0;
        case 8: 
          localjz.height = locala.ajGk.aar();
          AppMethodBeat.o(43083);
          return 0;
        case 9: 
          localjz.url = locala.ajGk.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 10: 
          localjz.hEE = locala.ajGk.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 11: 
          localjz.nUF = locala.ajGk.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 12: 
          localjz.mso = locala.ajGk.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 13: 
          localjz.iiu = locala.ajGk.readString();
          AppMethodBeat.o(43083);
          return 0;
        }
        localjz.iit = locala.ajGk.readString();
        AppMethodBeat.o(43083);
        return 0;
      }
      AppMethodBeat.o(43083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jz
 * JD-Core Version:    0.7.0.1
 */