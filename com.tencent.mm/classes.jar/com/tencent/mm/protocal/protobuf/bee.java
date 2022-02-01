package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bee
  extends com.tencent.mm.cd.a
{
  public String SEa;
  public long SGj;
  public String SPn;
  public String SPo;
  public bfo SPp;
  public beh SPq;
  public beh SPr;
  public bef SPs;
  public LinkedList<FinderContact> SPt;
  public int SPu;
  public int SPv;
  public long SPw;
  public String SPx;
  public int cUP;
  public long commentId;
  public int createTime;
  public String description;
  public int extFlag;
  public String headUrl;
  public long id;
  public String ilo;
  public int mediaType;
  public String nickName;
  public String objectNonceId;
  public int objectType;
  public String replyNickname;
  public String thumbUrl;
  public String username;
  public long xbk;
  public int xcE;
  
  public bee()
  {
    AppMethodBeat.i(207381);
    this.SPt = new LinkedList();
    AppMethodBeat.o(207381);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169009);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.headUrl != null) {
        paramVarArgs.f(1, this.headUrl);
      }
      if (this.nickName != null) {
        paramVarArgs.f(2, this.nickName);
      }
      paramVarArgs.aY(3, this.xcE);
      if (this.SPn != null) {
        paramVarArgs.f(4, this.SPn);
      }
      paramVarArgs.aY(5, this.createTime);
      if (this.thumbUrl != null) {
        paramVarArgs.f(6, this.thumbUrl);
      }
      paramVarArgs.bm(7, this.id);
      paramVarArgs.bm(8, this.xbk);
      paramVarArgs.bm(9, this.commentId);
      paramVarArgs.aY(10, this.cUP);
      paramVarArgs.aY(11, this.extFlag);
      if (this.SPo != null) {
        paramVarArgs.f(12, this.SPo);
      }
      if (this.SPp != null)
      {
        paramVarArgs.oE(13, this.SPp.computeSize());
        this.SPp.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.mediaType);
      if (this.description != null) {
        paramVarArgs.f(15, this.description);
      }
      if (this.replyNickname != null) {
        paramVarArgs.f(16, this.replyNickname);
      }
      if (this.SEa != null) {
        paramVarArgs.f(17, this.SEa);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.f(18, this.objectNonceId);
      }
      if (this.username != null) {
        paramVarArgs.f(19, this.username);
      }
      if (this.SPq != null)
      {
        paramVarArgs.oE(20, this.SPq.computeSize());
        this.SPq.writeFields(paramVarArgs);
      }
      if (this.SPr != null)
      {
        paramVarArgs.oE(21, this.SPr.computeSize());
        this.SPr.writeFields(paramVarArgs);
      }
      if (this.SPs != null)
      {
        paramVarArgs.oE(22, this.SPs.computeSize());
        this.SPs.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.SPt);
      paramVarArgs.aY(24, this.SPu);
      paramVarArgs.aY(25, this.SPv);
      if (this.ilo != null) {
        paramVarArgs.f(26, this.ilo);
      }
      paramVarArgs.bm(27, this.SGj);
      paramVarArgs.aY(28, this.objectType);
      paramVarArgs.bm(29, this.SPw);
      if (this.SPx != null) {
        paramVarArgs.f(30, this.SPx);
      }
      AppMethodBeat.o(169009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.headUrl == null) {
        break label2128;
      }
    }
    label2128:
    for (paramInt = g.a.a.b.b.a.g(1, this.headUrl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickName != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.nickName);
      }
      i += g.a.a.b.b.a.bM(3, this.xcE);
      paramInt = i;
      if (this.SPn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SPn);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.createTime);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.thumbUrl);
      }
      i = paramInt + g.a.a.b.b.a.p(7, this.id) + g.a.a.b.b.a.p(8, this.xbk) + g.a.a.b.b.a.p(9, this.commentId) + g.a.a.b.b.a.bM(10, this.cUP) + g.a.a.b.b.a.bM(11, this.extFlag);
      paramInt = i;
      if (this.SPo != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.SPo);
      }
      i = paramInt;
      if (this.SPp != null) {
        i = paramInt + g.a.a.a.oD(13, this.SPp.computeSize());
      }
      i += g.a.a.b.b.a.bM(14, this.mediaType);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.description);
      }
      i = paramInt;
      if (this.replyNickname != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.replyNickname);
      }
      paramInt = i;
      if (this.SEa != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.SEa);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.objectNonceId);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.username);
      }
      i = paramInt;
      if (this.SPq != null) {
        i = paramInt + g.a.a.a.oD(20, this.SPq.computeSize());
      }
      paramInt = i;
      if (this.SPr != null) {
        paramInt = i + g.a.a.a.oD(21, this.SPr.computeSize());
      }
      i = paramInt;
      if (this.SPs != null) {
        i = paramInt + g.a.a.a.oD(22, this.SPs.computeSize());
      }
      i = i + g.a.a.a.c(23, 8, this.SPt) + g.a.a.b.b.a.bM(24, this.SPu) + g.a.a.b.b.a.bM(25, this.SPv);
      paramInt = i;
      if (this.ilo != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.ilo);
      }
      i = paramInt + g.a.a.b.b.a.p(27, this.SGj) + g.a.a.b.b.a.bM(28, this.objectType) + g.a.a.b.b.a.p(29, this.SPw);
      paramInt = i;
      if (this.SPx != null) {
        paramInt = i + g.a.a.b.b.a.g(30, this.SPx);
      }
      AppMethodBeat.o(169009);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SPt.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bee localbee = (bee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169009);
          return -1;
        case 1: 
          localbee.headUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 2: 
          localbee.nickName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 3: 
          localbee.xcE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169009);
          return 0;
        case 4: 
          localbee.SPn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 5: 
          localbee.createTime = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169009);
          return 0;
        case 6: 
          localbee.thumbUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 7: 
          localbee.id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169009);
          return 0;
        case 8: 
          localbee.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169009);
          return 0;
        case 9: 
          localbee.commentId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169009);
          return 0;
        case 10: 
          localbee.cUP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169009);
          return 0;
        case 11: 
          localbee.extFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169009);
          return 0;
        case 12: 
          localbee.SPo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfo)localObject2).parseFrom((byte[])localObject1);
            }
            localbee.SPp = ((bfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 14: 
          localbee.mediaType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169009);
          return 0;
        case 15: 
          localbee.description = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 16: 
          localbee.replyNickname = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 17: 
          localbee.SEa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 18: 
          localbee.objectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 19: 
          localbee.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new beh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((beh)localObject2).parseFrom((byte[])localObject1);
            }
            localbee.SPq = ((beh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new beh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((beh)localObject2).parseFrom((byte[])localObject1);
            }
            localbee.SPr = ((beh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bef();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bef)localObject2).parseFrom((byte[])localObject1);
            }
            localbee.SPs = ((bef)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbee.SPt.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 24: 
          localbee.SPu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169009);
          return 0;
        case 25: 
          localbee.SPv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169009);
          return 0;
        case 26: 
          localbee.ilo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 27: 
          localbee.SGj = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169009);
          return 0;
        case 28: 
          localbee.objectType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169009);
          return 0;
        case 29: 
          localbee.SPw = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169009);
          return 0;
        }
        localbee.SPx = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169009);
        return 0;
      }
      AppMethodBeat.o(169009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bee
 * JD-Core Version:    0.7.0.1
 */