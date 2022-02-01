package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbr
  extends com.tencent.mm.cd.a
{
  public int FSG;
  public String HLH;
  public String KGh;
  public String Ruu;
  public String Ruv;
  public String Ruw;
  public String Rux;
  public String albumName;
  public String extraInfo;
  public String identification;
  public long issueDate;
  public String lVZ;
  public String musicGenre;
  public String singerName;
  public String songLyric;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199377);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ruu != null) {
        paramVarArgs.f(1, this.Ruu);
      }
      if (this.Ruv != null) {
        paramVarArgs.f(2, this.Ruv);
      }
      if (this.Ruw != null) {
        paramVarArgs.f(3, this.Ruw);
      }
      if (this.Rux != null) {
        paramVarArgs.f(4, this.Rux);
      }
      if (this.singerName != null) {
        paramVarArgs.f(5, this.singerName);
      }
      if (this.albumName != null) {
        paramVarArgs.f(6, this.albumName);
      }
      if (this.extraInfo != null) {
        paramVarArgs.f(7, this.extraInfo);
      }
      if (this.musicGenre != null) {
        paramVarArgs.f(8, this.musicGenre);
      }
      paramVarArgs.bm(9, this.issueDate);
      if (this.identification != null) {
        paramVarArgs.f(10, this.identification);
      }
      paramVarArgs.aY(11, this.FSG);
      if (this.lVZ != null) {
        paramVarArgs.f(21, this.lVZ);
      }
      if (this.HLH != null) {
        paramVarArgs.f(22, this.HLH);
      }
      if (this.songLyric != null) {
        paramVarArgs.f(23, this.songLyric);
      }
      if (this.KGh != null) {
        paramVarArgs.f(25, this.KGh);
      }
      AppMethodBeat.o(199377);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ruu == null) {
        break label1082;
      }
    }
    label1082:
    for (int i = g.a.a.b.b.a.g(1, this.Ruu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ruv != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Ruv);
      }
      i = paramInt;
      if (this.Ruw != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ruw);
      }
      paramInt = i;
      if (this.Rux != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Rux);
      }
      i = paramInt;
      if (this.singerName != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.singerName);
      }
      paramInt = i;
      if (this.albumName != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.albumName);
      }
      i = paramInt;
      if (this.extraInfo != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.extraInfo);
      }
      paramInt = i;
      if (this.musicGenre != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.musicGenre);
      }
      i = paramInt + g.a.a.b.b.a.p(9, this.issueDate);
      paramInt = i;
      if (this.identification != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.identification);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.FSG);
      paramInt = i;
      if (this.lVZ != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.lVZ);
      }
      i = paramInt;
      if (this.HLH != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.HLH);
      }
      paramInt = i;
      if (this.songLyric != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.songLyric);
      }
      i = paramInt;
      if (this.KGh != null) {
        i = paramInt + g.a.a.b.b.a.g(25, this.KGh);
      }
      AppMethodBeat.o(199377);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199377);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dbr localdbr = (dbr)paramVarArgs[1];
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
          AppMethodBeat.o(199377);
          return -1;
        case 1: 
          localdbr.Ruu = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        case 2: 
          localdbr.Ruv = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        case 3: 
          localdbr.Ruw = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        case 4: 
          localdbr.Rux = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        case 5: 
          localdbr.singerName = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        case 6: 
          localdbr.albumName = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        case 7: 
          localdbr.extraInfo = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        case 8: 
          localdbr.musicGenre = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        case 9: 
          localdbr.issueDate = locala.abFh.AN();
          AppMethodBeat.o(199377);
          return 0;
        case 10: 
          localdbr.identification = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        case 11: 
          localdbr.FSG = locala.abFh.AK();
          AppMethodBeat.o(199377);
          return 0;
        case 21: 
          localdbr.lVZ = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        case 22: 
          localdbr.HLH = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        case 23: 
          localdbr.songLyric = locala.abFh.readString();
          AppMethodBeat.o(199377);
          return 0;
        }
        localdbr.KGh = locala.abFh.readString();
        AppMethodBeat.o(199377);
        return 0;
      }
      AppMethodBeat.o(199377);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbr
 * JD-Core Version:    0.7.0.1
 */