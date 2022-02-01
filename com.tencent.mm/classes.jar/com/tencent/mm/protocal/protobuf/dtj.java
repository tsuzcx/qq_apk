package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtj
  extends com.tencent.mm.bx.a
{
  public int LNC;
  public String RfH;
  public String YqN;
  public String YqO;
  public String YqP;
  public String YqQ;
  public String YqY;
  public String albumName;
  public String extraInfo;
  public String identification;
  public long issueDate;
  public String musicGenre;
  public String musicOperationUrl;
  public String oOZ;
  public String oPc;
  public String singerName;
  public String songLyric;
  public String songName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259341);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YqN != null) {
        paramVarArgs.g(1, this.YqN);
      }
      if (this.YqO != null) {
        paramVarArgs.g(2, this.YqO);
      }
      if (this.YqP != null) {
        paramVarArgs.g(3, this.YqP);
      }
      if (this.YqQ != null) {
        paramVarArgs.g(4, this.YqQ);
      }
      if (this.singerName != null) {
        paramVarArgs.g(5, this.singerName);
      }
      if (this.albumName != null) {
        paramVarArgs.g(6, this.albumName);
      }
      if (this.extraInfo != null) {
        paramVarArgs.g(7, this.extraInfo);
      }
      if (this.musicGenre != null) {
        paramVarArgs.g(8, this.musicGenre);
      }
      paramVarArgs.bv(9, this.issueDate);
      if (this.identification != null) {
        paramVarArgs.g(10, this.identification);
      }
      paramVarArgs.bS(11, this.LNC);
      if (this.oOZ != null) {
        paramVarArgs.g(12, this.oOZ);
      }
      if (this.musicOperationUrl != null) {
        paramVarArgs.g(13, this.musicOperationUrl);
      }
      if (this.oPc != null) {
        paramVarArgs.g(21, this.oPc);
      }
      if (this.songName != null) {
        paramVarArgs.g(22, this.songName);
      }
      if (this.songLyric != null) {
        paramVarArgs.g(23, this.songLyric);
      }
      if (this.RfH != null) {
        paramVarArgs.g(25, this.RfH);
      }
      if (this.YqY != null) {
        paramVarArgs.g(26, this.YqY);
      }
      AppMethodBeat.o(259341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YqN == null) {
        break label1258;
      }
    }
    label1258:
    for (int i = i.a.a.b.b.a.h(1, this.YqN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YqO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YqO);
      }
      i = paramInt;
      if (this.YqP != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YqP);
      }
      paramInt = i;
      if (this.YqQ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YqQ);
      }
      i = paramInt;
      if (this.singerName != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.singerName);
      }
      paramInt = i;
      if (this.albumName != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.albumName);
      }
      i = paramInt;
      if (this.extraInfo != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.extraInfo);
      }
      paramInt = i;
      if (this.musicGenre != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.musicGenre);
      }
      i = paramInt + i.a.a.b.b.a.q(9, this.issueDate);
      paramInt = i;
      if (this.identification != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.identification);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.LNC);
      paramInt = i;
      if (this.oOZ != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.oOZ);
      }
      i = paramInt;
      if (this.musicOperationUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.musicOperationUrl);
      }
      paramInt = i;
      if (this.oPc != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.oPc);
      }
      i = paramInt;
      if (this.songName != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.songName);
      }
      paramInt = i;
      if (this.songLyric != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.songLyric);
      }
      i = paramInt;
      if (this.RfH != null) {
        i = paramInt + i.a.a.b.b.a.h(25, this.RfH);
      }
      paramInt = i;
      if (this.YqY != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.YqY);
      }
      AppMethodBeat.o(259341);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259341);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dtj localdtj = (dtj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        case 24: 
        default: 
          AppMethodBeat.o(259341);
          return -1;
        case 1: 
          localdtj.YqN = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 2: 
          localdtj.YqO = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 3: 
          localdtj.YqP = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 4: 
          localdtj.YqQ = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 5: 
          localdtj.singerName = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 6: 
          localdtj.albumName = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 7: 
          localdtj.extraInfo = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 8: 
          localdtj.musicGenre = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 9: 
          localdtj.issueDate = locala.ajGk.aaw();
          AppMethodBeat.o(259341);
          return 0;
        case 10: 
          localdtj.identification = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 11: 
          localdtj.LNC = locala.ajGk.aar();
          AppMethodBeat.o(259341);
          return 0;
        case 12: 
          localdtj.oOZ = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 13: 
          localdtj.musicOperationUrl = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 21: 
          localdtj.oPc = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 22: 
          localdtj.songName = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 23: 
          localdtj.songLyric = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        case 25: 
          localdtj.RfH = locala.ajGk.readString();
          AppMethodBeat.o(259341);
          return 0;
        }
        localdtj.YqY = locala.ajGk.readString();
        AppMethodBeat.o(259341);
        return 0;
      }
      AppMethodBeat.o(259341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtj
 * JD-Core Version:    0.7.0.1
 */