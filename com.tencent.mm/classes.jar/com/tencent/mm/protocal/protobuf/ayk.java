package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayk
  extends com.tencent.mm.bw.a
{
  public String LBr;
  public long LCX;
  public int LEa;
  public String LIB;
  public String LIC;
  public azp LID;
  public ayn LIE;
  public ayn LIF;
  public ayl LIG;
  public LinkedList<FinderContact> LIH;
  public int LII;
  public int LIJ;
  public long LIK;
  public String LIL;
  public int cSx;
  public long commentId;
  public String description;
  public int extFlag;
  public String fQY;
  public long hFK;
  public String headUrl;
  public int iXu;
  public long id;
  public int mediaType;
  public String nickName;
  public String objectNonceId;
  public int objectType;
  public String replyNickname;
  public String thumbUrl;
  public String username;
  
  public ayk()
  {
    AppMethodBeat.i(209591);
    this.LIH = new LinkedList();
    AppMethodBeat.o(209591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169009);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.headUrl != null) {
        paramVarArgs.e(1, this.headUrl);
      }
      if (this.nickName != null) {
        paramVarArgs.e(2, this.nickName);
      }
      paramVarArgs.aM(3, this.LEa);
      if (this.LIB != null) {
        paramVarArgs.e(4, this.LIB);
      }
      paramVarArgs.aM(5, this.iXu);
      if (this.thumbUrl != null) {
        paramVarArgs.e(6, this.thumbUrl);
      }
      paramVarArgs.bb(7, this.id);
      paramVarArgs.bb(8, this.hFK);
      paramVarArgs.bb(9, this.commentId);
      paramVarArgs.aM(10, this.cSx);
      paramVarArgs.aM(11, this.extFlag);
      if (this.LIC != null) {
        paramVarArgs.e(12, this.LIC);
      }
      if (this.LID != null)
      {
        paramVarArgs.ni(13, this.LID.computeSize());
        this.LID.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.mediaType);
      if (this.description != null) {
        paramVarArgs.e(15, this.description);
      }
      if (this.replyNickname != null) {
        paramVarArgs.e(16, this.replyNickname);
      }
      if (this.LBr != null) {
        paramVarArgs.e(17, this.LBr);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.e(18, this.objectNonceId);
      }
      if (this.username != null) {
        paramVarArgs.e(19, this.username);
      }
      if (this.LIE != null)
      {
        paramVarArgs.ni(20, this.LIE.computeSize());
        this.LIE.writeFields(paramVarArgs);
      }
      if (this.LIF != null)
      {
        paramVarArgs.ni(21, this.LIF.computeSize());
        this.LIF.writeFields(paramVarArgs);
      }
      if (this.LIG != null)
      {
        paramVarArgs.ni(22, this.LIG.computeSize());
        this.LIG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.LIH);
      paramVarArgs.aM(24, this.LII);
      paramVarArgs.aM(25, this.LIJ);
      if (this.fQY != null) {
        paramVarArgs.e(26, this.fQY);
      }
      paramVarArgs.bb(27, this.LCX);
      paramVarArgs.aM(28, this.objectType);
      paramVarArgs.bb(29, this.LIK);
      if (this.LIL != null) {
        paramVarArgs.e(30, this.LIL);
      }
      AppMethodBeat.o(169009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.headUrl == null) {
        break label2238;
      }
    }
    label2238:
    for (paramInt = g.a.a.b.b.a.f(1, this.headUrl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickName != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.nickName);
      }
      i += g.a.a.b.b.a.bu(3, this.LEa);
      paramInt = i;
      if (this.LIB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LIB);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.iXu);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.thumbUrl);
      }
      i = paramInt + g.a.a.b.b.a.r(7, this.id) + g.a.a.b.b.a.r(8, this.hFK) + g.a.a.b.b.a.r(9, this.commentId) + g.a.a.b.b.a.bu(10, this.cSx) + g.a.a.b.b.a.bu(11, this.extFlag);
      paramInt = i;
      if (this.LIC != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.LIC);
      }
      i = paramInt;
      if (this.LID != null) {
        i = paramInt + g.a.a.a.nh(13, this.LID.computeSize());
      }
      i += g.a.a.b.b.a.bu(14, this.mediaType);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.description);
      }
      i = paramInt;
      if (this.replyNickname != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.replyNickname);
      }
      paramInt = i;
      if (this.LBr != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.LBr);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.objectNonceId);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.username);
      }
      i = paramInt;
      if (this.LIE != null) {
        i = paramInt + g.a.a.a.nh(20, this.LIE.computeSize());
      }
      paramInt = i;
      if (this.LIF != null) {
        paramInt = i + g.a.a.a.nh(21, this.LIF.computeSize());
      }
      i = paramInt;
      if (this.LIG != null) {
        i = paramInt + g.a.a.a.nh(22, this.LIG.computeSize());
      }
      i = i + g.a.a.a.c(23, 8, this.LIH) + g.a.a.b.b.a.bu(24, this.LII) + g.a.a.b.b.a.bu(25, this.LIJ);
      paramInt = i;
      if (this.fQY != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.fQY);
      }
      i = paramInt + g.a.a.b.b.a.r(27, this.LCX) + g.a.a.b.b.a.bu(28, this.objectType) + g.a.a.b.b.a.r(29, this.LIK);
      paramInt = i;
      if (this.LIL != null) {
        paramInt = i + g.a.a.b.b.a.f(30, this.LIL);
      }
      AppMethodBeat.o(169009);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LIH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ayk localayk = (ayk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169009);
          return -1;
        case 1: 
          localayk.headUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 2: 
          localayk.nickName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 3: 
          localayk.LEa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169009);
          return 0;
        case 4: 
          localayk.LIB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 5: 
          localayk.iXu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169009);
          return 0;
        case 6: 
          localayk.thumbUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 7: 
          localayk.id = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169009);
          return 0;
        case 8: 
          localayk.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169009);
          return 0;
        case 9: 
          localayk.commentId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169009);
          return 0;
        case 10: 
          localayk.cSx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169009);
          return 0;
        case 11: 
          localayk.extFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169009);
          return 0;
        case 12: 
          localayk.LIC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localayk.LID = ((azp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 14: 
          localayk.mediaType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169009);
          return 0;
        case 15: 
          localayk.description = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 16: 
          localayk.replyNickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 17: 
          localayk.LBr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 18: 
          localayk.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 19: 
          localayk.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ayn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ayn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localayk.LIE = ((ayn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ayn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ayn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localayk.LIF = ((ayn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ayl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ayl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localayk.LIG = ((ayl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localayk.LIH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 24: 
          localayk.LII = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169009);
          return 0;
        case 25: 
          localayk.LIJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169009);
          return 0;
        case 26: 
          localayk.fQY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 27: 
          localayk.LCX = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169009);
          return 0;
        case 28: 
          localayk.objectType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169009);
          return 0;
        case 29: 
          localayk.LIK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169009);
          return 0;
        }
        localayk.LIL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169009);
        return 0;
      }
      AppMethodBeat.o(169009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayk
 * JD-Core Version:    0.7.0.1
 */