package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bue
  extends com.tencent.mm.bx.a
{
  public String EUn;
  public int EUp;
  public int aabW;
  public String aabX;
  public int bitrate;
  public String clientId;
  public String coverUrl;
  public int duration;
  public int fileSize;
  public int mediaHeight;
  public String mediaUrl;
  public int mediaWidth;
  public String thumbUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259305);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.clientId != null) {
        paramVarArgs.g(1, this.clientId);
      }
      if (this.mediaUrl != null) {
        paramVarArgs.g(2, this.mediaUrl);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.g(3, this.thumbUrl);
      }
      if (this.coverUrl != null) {
        paramVarArgs.g(4, this.coverUrl);
      }
      paramVarArgs.bS(5, this.fileSize);
      paramVarArgs.bS(6, this.bitrate);
      paramVarArgs.bS(7, this.mediaWidth);
      paramVarArgs.bS(8, this.mediaHeight);
      paramVarArgs.bS(9, this.duration);
      if (this.EUn != null) {
        paramVarArgs.g(10, this.EUn);
      }
      paramVarArgs.bS(11, this.aabW);
      if (this.aabX != null) {
        paramVarArgs.g(12, this.aabX);
      }
      paramVarArgs.bS(13, this.EUp);
      AppMethodBeat.o(259305);
      return 0;
    }
    if (paramInt == 1) {
      if (this.clientId == null) {
        break label826;
      }
    }
    label826:
    for (int i = i.a.a.b.b.a.h(1, this.clientId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mediaUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mediaUrl);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.thumbUrl);
      }
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.coverUrl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.fileSize) + i.a.a.b.b.a.cJ(6, this.bitrate) + i.a.a.b.b.a.cJ(7, this.mediaWidth) + i.a.a.b.b.a.cJ(8, this.mediaHeight) + i.a.a.b.b.a.cJ(9, this.duration);
      paramInt = i;
      if (this.EUn != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.EUn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.aabW);
      paramInt = i;
      if (this.aabX != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aabX);
      }
      i = i.a.a.b.b.a.cJ(13, this.EUp);
      AppMethodBeat.o(259305);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259305);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bue localbue = (bue)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259305);
          return -1;
        case 1: 
          localbue.clientId = locala.ajGk.readString();
          AppMethodBeat.o(259305);
          return 0;
        case 2: 
          localbue.mediaUrl = locala.ajGk.readString();
          AppMethodBeat.o(259305);
          return 0;
        case 3: 
          localbue.thumbUrl = locala.ajGk.readString();
          AppMethodBeat.o(259305);
          return 0;
        case 4: 
          localbue.coverUrl = locala.ajGk.readString();
          AppMethodBeat.o(259305);
          return 0;
        case 5: 
          localbue.fileSize = locala.ajGk.aar();
          AppMethodBeat.o(259305);
          return 0;
        case 6: 
          localbue.bitrate = locala.ajGk.aar();
          AppMethodBeat.o(259305);
          return 0;
        case 7: 
          localbue.mediaWidth = locala.ajGk.aar();
          AppMethodBeat.o(259305);
          return 0;
        case 8: 
          localbue.mediaHeight = locala.ajGk.aar();
          AppMethodBeat.o(259305);
          return 0;
        case 9: 
          localbue.duration = locala.ajGk.aar();
          AppMethodBeat.o(259305);
          return 0;
        case 10: 
          localbue.EUn = locala.ajGk.readString();
          AppMethodBeat.o(259305);
          return 0;
        case 11: 
          localbue.aabW = locala.ajGk.aar();
          AppMethodBeat.o(259305);
          return 0;
        case 12: 
          localbue.aabX = locala.ajGk.readString();
          AppMethodBeat.o(259305);
          return 0;
        }
        localbue.EUp = locala.ajGk.aar();
        AppMethodBeat.o(259305);
        return 0;
      }
      AppMethodBeat.o(259305);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bue
 * JD-Core Version:    0.7.0.1
 */