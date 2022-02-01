package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class jo
  extends com.tencent.mm.bw.a
{
  public String KOe;
  public String KOf;
  public String dHc;
  public String ehQ;
  public String ehR;
  public int height;
  public String iAg;
  public String iAh;
  public String iAo;
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
      if (this.KOe != null) {
        paramVarArgs.e(1, this.KOe);
      }
      if (this.videoUrl != null) {
        paramVarArgs.e(2, this.videoUrl);
      }
      if (this.KOf != null) {
        paramVarArgs.e(3, this.KOf);
      }
      if (this.title != null) {
        paramVarArgs.e(4, this.title);
      }
      if (this.iAo != null) {
        paramVarArgs.e(5, this.iAo);
      }
      paramVarArgs.aM(6, this.videoDuration);
      paramVarArgs.aM(7, this.width);
      paramVarArgs.aM(8, this.height);
      if (this.url != null) {
        paramVarArgs.e(9, this.url);
      }
      if (this.dHc != null) {
        paramVarArgs.e(10, this.dHc);
      }
      if (this.iAg != null) {
        paramVarArgs.e(11, this.iAg);
      }
      if (this.iAh != null) {
        paramVarArgs.e(12, this.iAh);
      }
      if (this.ehR != null) {
        paramVarArgs.e(13, this.ehR);
      }
      if (this.ehQ != null) {
        paramVarArgs.e(14, this.ehQ);
      }
      AppMethodBeat.o(43083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KOe == null) {
        break label962;
      }
    }
    label962:
    for (int i = g.a.a.b.b.a.f(1, this.KOe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.videoUrl);
      }
      i = paramInt;
      if (this.KOf != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KOf);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.title);
      }
      i = paramInt;
      if (this.iAo != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.iAo);
      }
      i = i + g.a.a.b.b.a.bu(6, this.videoDuration) + g.a.a.b.b.a.bu(7, this.width) + g.a.a.b.b.a.bu(8, this.height);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.url);
      }
      i = paramInt;
      if (this.dHc != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.dHc);
      }
      paramInt = i;
      if (this.iAg != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.iAg);
      }
      i = paramInt;
      if (this.iAh != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.iAh);
      }
      paramInt = i;
      if (this.ehR != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.ehR);
      }
      i = paramInt;
      if (this.ehQ != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.ehQ);
      }
      AppMethodBeat.o(43083);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(43083);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        jo localjo = (jo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43083);
          return -1;
        case 1: 
          localjo.KOe = locala.UbS.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 2: 
          localjo.videoUrl = locala.UbS.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 3: 
          localjo.KOf = locala.UbS.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 4: 
          localjo.title = locala.UbS.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 5: 
          localjo.iAo = locala.UbS.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 6: 
          localjo.videoDuration = locala.UbS.zi();
          AppMethodBeat.o(43083);
          return 0;
        case 7: 
          localjo.width = locala.UbS.zi();
          AppMethodBeat.o(43083);
          return 0;
        case 8: 
          localjo.height = locala.UbS.zi();
          AppMethodBeat.o(43083);
          return 0;
        case 9: 
          localjo.url = locala.UbS.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 10: 
          localjo.dHc = locala.UbS.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 11: 
          localjo.iAg = locala.UbS.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 12: 
          localjo.iAh = locala.UbS.readString();
          AppMethodBeat.o(43083);
          return 0;
        case 13: 
          localjo.ehR = locala.UbS.readString();
          AppMethodBeat.o(43083);
          return 0;
        }
        localjo.ehQ = locala.UbS.readString();
        AppMethodBeat.o(43083);
        return 0;
      }
      AppMethodBeat.o(43083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jo
 * JD-Core Version:    0.7.0.1
 */