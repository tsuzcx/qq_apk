package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alx
  extends com.tencent.mm.bw.a
{
  public String EDK;
  public int EEM;
  public String EFq;
  public String EFr;
  public amo EFs;
  public ama EFt;
  public ama EFu;
  public aly EFv;
  public LinkedList<FinderContact> EFw;
  public int EFx;
  public String bLs;
  public long commentId;
  public String description;
  public int drx;
  public int extFlag;
  public int hGU;
  public String headUrl;
  public long id;
  public int mediaType;
  public String objectNonceId;
  public long qXP;
  public String replyNickname;
  public String thumbUrl;
  public String username;
  
  public alx()
  {
    AppMethodBeat.i(195090);
    this.EFw = new LinkedList();
    AppMethodBeat.o(195090);
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
      if (this.bLs != null) {
        paramVarArgs.d(2, this.bLs);
      }
      paramVarArgs.aR(3, this.EEM);
      if (this.EFq != null) {
        paramVarArgs.d(4, this.EFq);
      }
      paramVarArgs.aR(5, this.hGU);
      if (this.thumbUrl != null) {
        paramVarArgs.d(6, this.thumbUrl);
      }
      paramVarArgs.aO(7, this.id);
      paramVarArgs.aO(8, this.qXP);
      paramVarArgs.aO(9, this.commentId);
      paramVarArgs.aR(10, this.drx);
      paramVarArgs.aR(11, this.extFlag);
      if (this.EFr != null) {
        paramVarArgs.d(12, this.EFr);
      }
      if (this.EFs != null)
      {
        paramVarArgs.ln(13, this.EFs.computeSize());
        this.EFs.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.mediaType);
      if (this.description != null) {
        paramVarArgs.d(15, this.description);
      }
      if (this.replyNickname != null) {
        paramVarArgs.d(16, this.replyNickname);
      }
      if (this.EDK != null) {
        paramVarArgs.d(17, this.EDK);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(18, this.objectNonceId);
      }
      if (this.username != null) {
        paramVarArgs.d(19, this.username);
      }
      if (this.EFt != null)
      {
        paramVarArgs.ln(20, this.EFt.computeSize());
        this.EFt.writeFields(paramVarArgs);
      }
      if (this.EFu != null)
      {
        paramVarArgs.ln(21, this.EFu.computeSize());
        this.EFu.writeFields(paramVarArgs);
      }
      if (this.EFv != null)
      {
        paramVarArgs.ln(22, this.EFv.computeSize());
        this.EFv.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.EFw);
      paramVarArgs.aR(24, this.EFx);
      AppMethodBeat.o(169009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.headUrl == null) {
        break label1942;
      }
    }
    label1942:
    for (paramInt = f.a.a.b.b.a.e(1, this.headUrl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bLs != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.bLs);
      }
      i += f.a.a.b.b.a.bx(3, this.EEM);
      paramInt = i;
      if (this.EFq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EFq);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.hGU);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thumbUrl);
      }
      i = paramInt + f.a.a.b.b.a.p(7, this.id) + f.a.a.b.b.a.p(8, this.qXP) + f.a.a.b.b.a.p(9, this.commentId) + f.a.a.b.b.a.bx(10, this.drx) + f.a.a.b.b.a.bx(11, this.extFlag);
      paramInt = i;
      if (this.EFr != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EFr);
      }
      i = paramInt;
      if (this.EFs != null) {
        i = paramInt + f.a.a.a.lm(13, this.EFs.computeSize());
      }
      i += f.a.a.b.b.a.bx(14, this.mediaType);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.description);
      }
      i = paramInt;
      if (this.replyNickname != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.replyNickname);
      }
      paramInt = i;
      if (this.EDK != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.EDK);
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
      if (this.EFt != null) {
        i = paramInt + f.a.a.a.lm(20, this.EFt.computeSize());
      }
      paramInt = i;
      if (this.EFu != null) {
        paramInt = i + f.a.a.a.lm(21, this.EFu.computeSize());
      }
      i = paramInt;
      if (this.EFv != null) {
        i = paramInt + f.a.a.a.lm(22, this.EFv.computeSize());
      }
      paramInt = f.a.a.a.c(23, 8, this.EFw);
      int j = f.a.a.b.b.a.bx(24, this.EFx);
      AppMethodBeat.o(169009);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EFw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        alx localalx = (alx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169009);
          return -1;
        case 1: 
          localalx.headUrl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 2: 
          localalx.bLs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 3: 
          localalx.EEM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169009);
          return 0;
        case 4: 
          localalx.EFq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 5: 
          localalx.hGU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169009);
          return 0;
        case 6: 
          localalx.thumbUrl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 7: 
          localalx.id = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169009);
          return 0;
        case 8: 
          localalx.qXP = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169009);
          return 0;
        case 9: 
          localalx.commentId = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169009);
          return 0;
        case 10: 
          localalx.drx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169009);
          return 0;
        case 11: 
          localalx.extFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169009);
          return 0;
        case 12: 
          localalx.EFr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalx.EFs = ((amo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 14: 
          localalx.mediaType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169009);
          return 0;
        case 15: 
          localalx.description = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 16: 
          localalx.replyNickname = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 17: 
          localalx.EDK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 18: 
          localalx.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 19: 
          localalx.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ama();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ama)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalx.EFt = ((ama)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ama();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ama)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalx.EFu = ((ama)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aly();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aly)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalx.EFv = ((aly)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalx.EFw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        }
        localalx.EFx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169009);
        return 0;
      }
      AppMethodBeat.o(169009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alx
 * JD-Core Version:    0.7.0.1
 */