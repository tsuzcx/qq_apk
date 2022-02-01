package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bcp
  extends com.tencent.mm.cd.a
{
  public String SNQ;
  public String SNR;
  public String SNS;
  public String coverUrl;
  public String desc;
  public int extFlag;
  public String feedId;
  public String headUrl;
  public float height;
  public String kwM;
  public int liveStatus;
  public String nickName;
  public String objectNonceId;
  public int sourceType;
  public String username;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208661);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.kwM != null) {
        paramVarArgs.f(1, this.kwM);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      if (this.feedId != null) {
        paramVarArgs.f(3, this.feedId);
      }
      if (this.nickName != null) {
        paramVarArgs.f(4, this.nickName);
      }
      if (this.desc != null) {
        paramVarArgs.f(5, this.desc);
      }
      if (this.coverUrl != null) {
        paramVarArgs.f(6, this.coverUrl);
      }
      paramVarArgs.i(7, this.width);
      paramVarArgs.i(8, this.height);
      if (this.SNQ != null) {
        paramVarArgs.f(9, this.SNQ);
      }
      if (this.SNR != null) {
        paramVarArgs.f(10, this.SNR);
      }
      if (this.SNS != null) {
        paramVarArgs.f(11, this.SNS);
      }
      if (this.headUrl != null) {
        paramVarArgs.f(12, this.headUrl);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.f(13, this.objectNonceId);
      }
      paramVarArgs.aY(14, this.liveStatus);
      paramVarArgs.aY(15, this.extFlag);
      paramVarArgs.aY(16, this.sourceType);
      AppMethodBeat.o(208661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kwM == null) {
        break label1060;
      }
    }
    label1060:
    for (int i = g.a.a.b.b.a.g(1, this.kwM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.username);
      }
      i = paramInt;
      if (this.feedId != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.feedId);
      }
      paramInt = i;
      if (this.nickName != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.nickName);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.desc);
      }
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.coverUrl);
      }
      i = paramInt + (g.a.a.b.b.a.gL(7) + 4) + (g.a.a.b.b.a.gL(8) + 4);
      paramInt = i;
      if (this.SNQ != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.SNQ);
      }
      i = paramInt;
      if (this.SNR != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.SNR);
      }
      paramInt = i;
      if (this.SNS != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.SNS);
      }
      i = paramInt;
      if (this.headUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.headUrl);
      }
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.objectNonceId);
      }
      i = g.a.a.b.b.a.bM(14, this.liveStatus);
      int j = g.a.a.b.b.a.bM(15, this.extFlag);
      int k = g.a.a.b.b.a.bM(16, this.sourceType);
      AppMethodBeat.o(208661);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(208661);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bcp localbcp = (bcp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(208661);
          return -1;
        case 1: 
          localbcp.kwM = locala.abFh.readString();
          AppMethodBeat.o(208661);
          return 0;
        case 2: 
          localbcp.username = locala.abFh.readString();
          AppMethodBeat.o(208661);
          return 0;
        case 3: 
          localbcp.feedId = locala.abFh.readString();
          AppMethodBeat.o(208661);
          return 0;
        case 4: 
          localbcp.nickName = locala.abFh.readString();
          AppMethodBeat.o(208661);
          return 0;
        case 5: 
          localbcp.desc = locala.abFh.readString();
          AppMethodBeat.o(208661);
          return 0;
        case 6: 
          localbcp.coverUrl = locala.abFh.readString();
          AppMethodBeat.o(208661);
          return 0;
        case 7: 
          localbcp.width = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(208661);
          return 0;
        case 8: 
          localbcp.height = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(208661);
          return 0;
        case 9: 
          localbcp.SNQ = locala.abFh.readString();
          AppMethodBeat.o(208661);
          return 0;
        case 10: 
          localbcp.SNR = locala.abFh.readString();
          AppMethodBeat.o(208661);
          return 0;
        case 11: 
          localbcp.SNS = locala.abFh.readString();
          AppMethodBeat.o(208661);
          return 0;
        case 12: 
          localbcp.headUrl = locala.abFh.readString();
          AppMethodBeat.o(208661);
          return 0;
        case 13: 
          localbcp.objectNonceId = locala.abFh.readString();
          AppMethodBeat.o(208661);
          return 0;
        case 14: 
          localbcp.liveStatus = locala.abFh.AK();
          AppMethodBeat.o(208661);
          return 0;
        case 15: 
          localbcp.extFlag = locala.abFh.AK();
          AppMethodBeat.o(208661);
          return 0;
        }
        localbcp.sourceType = locala.abFh.AK();
        AppMethodBeat.o(208661);
        return 0;
      }
      AppMethodBeat.o(208661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcp
 * JD-Core Version:    0.7.0.1
 */