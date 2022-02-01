package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apq
  extends com.tencent.mm.bw.a
{
  public String GEx;
  public int GFQ;
  public long GFv;
  public String GGK;
  public String GGL;
  public aqm GGM;
  public apt GGN;
  public apt GGO;
  public apr GGP;
  public LinkedList<FinderContact> GGQ;
  public int GGR;
  public int GGS;
  public String bVF;
  public long commentId;
  public int dEu;
  public String description;
  public int extFlag;
  public String fmu;
  public String headUrl;
  public int icw;
  public long id;
  public int mediaType;
  public String objectNonceId;
  public int objectType;
  public long rRn;
  public String replyNickname;
  public String thumbUrl;
  public String username;
  
  public apq()
  {
    AppMethodBeat.i(189371);
    this.GGQ = new LinkedList();
    AppMethodBeat.o(189371);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169009);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.headUrl != null) {
        paramVarArgs.d(1, this.headUrl);
      }
      if (this.bVF != null) {
        paramVarArgs.d(2, this.bVF);
      }
      paramVarArgs.aS(3, this.GFQ);
      if (this.GGK != null) {
        paramVarArgs.d(4, this.GGK);
      }
      paramVarArgs.aS(5, this.icw);
      if (this.thumbUrl != null) {
        paramVarArgs.d(6, this.thumbUrl);
      }
      paramVarArgs.aZ(7, this.id);
      paramVarArgs.aZ(8, this.rRn);
      paramVarArgs.aZ(9, this.commentId);
      paramVarArgs.aS(10, this.dEu);
      paramVarArgs.aS(11, this.extFlag);
      if (this.GGL != null) {
        paramVarArgs.d(12, this.GGL);
      }
      if (this.GGM != null)
      {
        paramVarArgs.lJ(13, this.GGM.computeSize());
        this.GGM.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.mediaType);
      if (this.description != null) {
        paramVarArgs.d(15, this.description);
      }
      if (this.replyNickname != null) {
        paramVarArgs.d(16, this.replyNickname);
      }
      if (this.GEx != null) {
        paramVarArgs.d(17, this.GEx);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(18, this.objectNonceId);
      }
      if (this.username != null) {
        paramVarArgs.d(19, this.username);
      }
      if (this.GGN != null)
      {
        paramVarArgs.lJ(20, this.GGN.computeSize());
        this.GGN.writeFields(paramVarArgs);
      }
      if (this.GGO != null)
      {
        paramVarArgs.lJ(21, this.GGO.computeSize());
        this.GGO.writeFields(paramVarArgs);
      }
      if (this.GGP != null)
      {
        paramVarArgs.lJ(22, this.GGP.computeSize());
        this.GGP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.GGQ);
      paramVarArgs.aS(24, this.GGR);
      paramVarArgs.aS(25, this.GGS);
      if (this.fmu != null) {
        paramVarArgs.d(26, this.fmu);
      }
      paramVarArgs.aZ(27, this.GFv);
      paramVarArgs.aS(28, this.objectType);
      AppMethodBeat.o(169009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.headUrl == null) {
        break label2138;
      }
    }
    label2138:
    for (paramInt = f.a.a.b.b.a.e(1, this.headUrl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bVF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.bVF);
      }
      i += f.a.a.b.b.a.bz(3, this.GFQ);
      paramInt = i;
      if (this.GGK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GGK);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.icw);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thumbUrl);
      }
      i = paramInt + f.a.a.b.b.a.p(7, this.id) + f.a.a.b.b.a.p(8, this.rRn) + f.a.a.b.b.a.p(9, this.commentId) + f.a.a.b.b.a.bz(10, this.dEu) + f.a.a.b.b.a.bz(11, this.extFlag);
      paramInt = i;
      if (this.GGL != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GGL);
      }
      i = paramInt;
      if (this.GGM != null) {
        i = paramInt + f.a.a.a.lI(13, this.GGM.computeSize());
      }
      i += f.a.a.b.b.a.bz(14, this.mediaType);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.description);
      }
      i = paramInt;
      if (this.replyNickname != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.replyNickname);
      }
      paramInt = i;
      if (this.GEx != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GEx);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.objectNonceId);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.username);
      }
      i = paramInt;
      if (this.GGN != null) {
        i = paramInt + f.a.a.a.lI(20, this.GGN.computeSize());
      }
      paramInt = i;
      if (this.GGO != null) {
        paramInt = i + f.a.a.a.lI(21, this.GGO.computeSize());
      }
      i = paramInt;
      if (this.GGP != null) {
        i = paramInt + f.a.a.a.lI(22, this.GGP.computeSize());
      }
      i = i + f.a.a.a.c(23, 8, this.GGQ) + f.a.a.b.b.a.bz(24, this.GGR) + f.a.a.b.b.a.bz(25, this.GGS);
      paramInt = i;
      if (this.fmu != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.fmu);
      }
      i = f.a.a.b.b.a.p(27, this.GFv);
      int j = f.a.a.b.b.a.bz(28, this.objectType);
      AppMethodBeat.o(169009);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GGQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apq localapq = (apq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169009);
          return -1;
        case 1: 
          localapq.headUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 2: 
          localapq.bVF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 3: 
          localapq.GFQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 4: 
          localapq.GGK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 5: 
          localapq.icw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 6: 
          localapq.thumbUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 7: 
          localapq.id = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169009);
          return 0;
        case 8: 
          localapq.rRn = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169009);
          return 0;
        case 9: 
          localapq.commentId = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169009);
          return 0;
        case 10: 
          localapq.dEu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 11: 
          localapq.extFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 12: 
          localapq.GGL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapq.GGM = ((aqm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 14: 
          localapq.mediaType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 15: 
          localapq.description = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 16: 
          localapq.replyNickname = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 17: 
          localapq.GEx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 18: 
          localapq.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 19: 
          localapq.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapq.GGN = ((apt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapq.GGO = ((apt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapq.GGP = ((apr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapq.GGQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 24: 
          localapq.GGR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 25: 
          localapq.GGS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 26: 
          localapq.fmu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 27: 
          localapq.GFv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169009);
          return 0;
        }
        localapq.objectType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169009);
        return 0;
      }
      AppMethodBeat.o(169009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apq
 * JD-Core Version:    0.7.0.1
 */