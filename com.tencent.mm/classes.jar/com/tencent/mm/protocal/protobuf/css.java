package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class css
  extends com.tencent.mm.bw.a
{
  public int Alz;
  public String BPc;
  public String EsK;
  public String Ktn;
  public String Kto;
  public String Ktp;
  public String Ktq;
  public String albumName;
  public String extraInfo;
  public String identification;
  public long issueDate;
  public String jfz;
  public String musicGenre;
  public String singerName;
  public String songLyric;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196100);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ktn != null) {
        paramVarArgs.e(1, this.Ktn);
      }
      if (this.Kto != null) {
        paramVarArgs.e(2, this.Kto);
      }
      if (this.Ktp != null) {
        paramVarArgs.e(3, this.Ktp);
      }
      if (this.Ktq != null) {
        paramVarArgs.e(4, this.Ktq);
      }
      if (this.singerName != null) {
        paramVarArgs.e(5, this.singerName);
      }
      if (this.albumName != null) {
        paramVarArgs.e(6, this.albumName);
      }
      if (this.extraInfo != null) {
        paramVarArgs.e(7, this.extraInfo);
      }
      if (this.musicGenre != null) {
        paramVarArgs.e(8, this.musicGenre);
      }
      paramVarArgs.bb(9, this.issueDate);
      if (this.identification != null) {
        paramVarArgs.e(10, this.identification);
      }
      paramVarArgs.aM(11, this.Alz);
      if (this.jfz != null) {
        paramVarArgs.e(21, this.jfz);
      }
      if (this.BPc != null) {
        paramVarArgs.e(22, this.BPc);
      }
      if (this.songLyric != null) {
        paramVarArgs.e(23, this.songLyric);
      }
      if (this.EsK != null) {
        paramVarArgs.e(25, this.EsK);
      }
      AppMethodBeat.o(196100);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ktn == null) {
        break label1082;
      }
    }
    label1082:
    for (int i = g.a.a.b.b.a.f(1, this.Ktn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Kto != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Kto);
      }
      i = paramInt;
      if (this.Ktp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Ktp);
      }
      paramInt = i;
      if (this.Ktq != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Ktq);
      }
      i = paramInt;
      if (this.singerName != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.singerName);
      }
      paramInt = i;
      if (this.albumName != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.albumName);
      }
      i = paramInt;
      if (this.extraInfo != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.extraInfo);
      }
      paramInt = i;
      if (this.musicGenre != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.musicGenre);
      }
      i = paramInt + g.a.a.b.b.a.r(9, this.issueDate);
      paramInt = i;
      if (this.identification != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.identification);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.Alz);
      paramInt = i;
      if (this.jfz != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.jfz);
      }
      i = paramInt;
      if (this.BPc != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.BPc);
      }
      paramInt = i;
      if (this.songLyric != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.songLyric);
      }
      i = paramInt;
      if (this.EsK != null) {
        i = paramInt + g.a.a.b.b.a.f(25, this.EsK);
      }
      AppMethodBeat.o(196100);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196100);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        css localcss = (css)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        case 24: 
        default: 
          AppMethodBeat.o(196100);
          return -1;
        case 1: 
          localcss.Ktn = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        case 2: 
          localcss.Kto = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        case 3: 
          localcss.Ktp = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        case 4: 
          localcss.Ktq = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        case 5: 
          localcss.singerName = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        case 6: 
          localcss.albumName = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        case 7: 
          localcss.extraInfo = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        case 8: 
          localcss.musicGenre = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        case 9: 
          localcss.issueDate = locala.UbS.zl();
          AppMethodBeat.o(196100);
          return 0;
        case 10: 
          localcss.identification = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        case 11: 
          localcss.Alz = locala.UbS.zi();
          AppMethodBeat.o(196100);
          return 0;
        case 21: 
          localcss.jfz = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        case 22: 
          localcss.BPc = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        case 23: 
          localcss.songLyric = locala.UbS.readString();
          AppMethodBeat.o(196100);
          return 0;
        }
        localcss.EsK = locala.UbS.readString();
        AppMethodBeat.o(196100);
        return 0;
      }
      AppMethodBeat.o(196100);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.css
 * JD-Core Version:    0.7.0.1
 */