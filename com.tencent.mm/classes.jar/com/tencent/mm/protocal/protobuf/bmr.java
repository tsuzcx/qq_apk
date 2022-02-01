package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bmr
  extends com.tencent.mm.bx.a
{
  public String ZVh;
  public String ZVi;
  public String ZVj;
  public String ZVk;
  public int ZVl;
  public bip ZVm;
  public String ZVn;
  public String ZVo;
  public String ZVp;
  public String ZVq;
  public String ZVr;
  public String ZVs;
  public String ZVt;
  public String ZVu;
  public String ZVv;
  public int authIconType;
  public String coverUrl;
  public String desc;
  public String ecSource;
  public String eventId;
  public int extFlag;
  public String feedId;
  public String hTM;
  public String hUQ;
  public String headUrl;
  public float height;
  public String liveId;
  public int liveStatus;
  public int mIJ;
  public String mIK;
  public String nickName;
  public String objectNonceId;
  public int sourceType;
  public String username;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258855);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.liveId != null) {
        paramVarArgs.g(1, this.liveId);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.feedId != null) {
        paramVarArgs.g(3, this.feedId);
      }
      if (this.nickName != null) {
        paramVarArgs.g(4, this.nickName);
      }
      if (this.desc != null) {
        paramVarArgs.g(5, this.desc);
      }
      if (this.coverUrl != null) {
        paramVarArgs.g(6, this.coverUrl);
      }
      paramVarArgs.l(7, this.width);
      paramVarArgs.l(8, this.height);
      if (this.ZVh != null) {
        paramVarArgs.g(9, this.ZVh);
      }
      if (this.ZVi != null) {
        paramVarArgs.g(10, this.ZVi);
      }
      if (this.ZVj != null) {
        paramVarArgs.g(11, this.ZVj);
      }
      if (this.headUrl != null) {
        paramVarArgs.g(12, this.headUrl);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.g(13, this.objectNonceId);
      }
      paramVarArgs.bS(14, this.liveStatus);
      paramVarArgs.bS(15, this.extFlag);
      paramVarArgs.bS(16, this.sourceType);
      if (this.ecSource != null) {
        paramVarArgs.g(17, this.ecSource);
      }
      if (this.ZVk != null) {
        paramVarArgs.g(18, this.ZVk);
      }
      paramVarArgs.bS(19, this.authIconType);
      paramVarArgs.bS(20, this.mIJ);
      if (this.hUQ != null) {
        paramVarArgs.g(21, this.hUQ);
      }
      if (this.mIK != null) {
        paramVarArgs.g(22, this.mIK);
      }
      paramVarArgs.bS(23, this.ZVl);
      if (this.hTM != null) {
        paramVarArgs.g(24, this.hTM);
      }
      if (this.ZVm != null)
      {
        paramVarArgs.qD(100, this.ZVm.computeSize());
        this.ZVm.writeFields(paramVarArgs);
      }
      if (this.ZVn != null) {
        paramVarArgs.g(25, this.ZVn);
      }
      if (this.ZVo != null) {
        paramVarArgs.g(26, this.ZVo);
      }
      if (this.ZVp != null) {
        paramVarArgs.g(27, this.ZVp);
      }
      if (this.ZVq != null) {
        paramVarArgs.g(28, this.ZVq);
      }
      if (this.ZVr != null) {
        paramVarArgs.g(29, this.ZVr);
      }
      if (this.ZVs != null) {
        paramVarArgs.g(30, this.ZVs);
      }
      if (this.eventId != null) {
        paramVarArgs.g(31, this.eventId);
      }
      if (this.ZVt != null) {
        paramVarArgs.g(32, this.ZVt);
      }
      if (this.ZVu != null) {
        paramVarArgs.g(33, this.ZVu);
      }
      if (this.ZVv != null) {
        paramVarArgs.g(34, this.ZVv);
      }
      AppMethodBeat.o(258855);
      return 0;
    }
    if (paramInt == 1) {
      if (this.liveId == null) {
        break label2386;
      }
    }
    label2386:
    for (int i = i.a.a.b.b.a.h(1, this.liveId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.feedId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.feedId);
      }
      paramInt = i;
      if (this.nickName != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nickName);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.desc);
      }
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.coverUrl);
      }
      i = paramInt + (i.a.a.b.b.a.ko(7) + 4) + (i.a.a.b.b.a.ko(8) + 4);
      paramInt = i;
      if (this.ZVh != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZVh);
      }
      i = paramInt;
      if (this.ZVi != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ZVi);
      }
      paramInt = i;
      if (this.ZVj != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZVj);
      }
      i = paramInt;
      if (this.headUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.headUrl);
      }
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.objectNonceId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.liveStatus) + i.a.a.b.b.a.cJ(15, this.extFlag) + i.a.a.b.b.a.cJ(16, this.sourceType);
      paramInt = i;
      if (this.ecSource != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.ecSource);
      }
      i = paramInt;
      if (this.ZVk != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.ZVk);
      }
      i = i + i.a.a.b.b.a.cJ(19, this.authIconType) + i.a.a.b.b.a.cJ(20, this.mIJ);
      paramInt = i;
      if (this.hUQ != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.hUQ);
      }
      i = paramInt;
      if (this.mIK != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.mIK);
      }
      i += i.a.a.b.b.a.cJ(23, this.ZVl);
      paramInt = i;
      if (this.hTM != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.hTM);
      }
      i = paramInt;
      if (this.ZVm != null) {
        i = paramInt + i.a.a.a.qC(100, this.ZVm.computeSize());
      }
      paramInt = i;
      if (this.ZVn != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.ZVn);
      }
      i = paramInt;
      if (this.ZVo != null) {
        i = paramInt + i.a.a.b.b.a.h(26, this.ZVo);
      }
      paramInt = i;
      if (this.ZVp != null) {
        paramInt = i + i.a.a.b.b.a.h(27, this.ZVp);
      }
      i = paramInt;
      if (this.ZVq != null) {
        i = paramInt + i.a.a.b.b.a.h(28, this.ZVq);
      }
      paramInt = i;
      if (this.ZVr != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.ZVr);
      }
      i = paramInt;
      if (this.ZVs != null) {
        i = paramInt + i.a.a.b.b.a.h(30, this.ZVs);
      }
      paramInt = i;
      if (this.eventId != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.eventId);
      }
      i = paramInt;
      if (this.ZVt != null) {
        i = paramInt + i.a.a.b.b.a.h(32, this.ZVt);
      }
      paramInt = i;
      if (this.ZVu != null) {
        paramInt = i + i.a.a.b.b.a.h(33, this.ZVu);
      }
      i = paramInt;
      if (this.ZVv != null) {
        i = paramInt + i.a.a.b.b.a.h(34, this.ZVv);
      }
      AppMethodBeat.o(258855);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258855);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bmr localbmr = (bmr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258855);
          return -1;
        case 1: 
          localbmr.liveId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 2: 
          localbmr.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 3: 
          localbmr.feedId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 4: 
          localbmr.nickName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 5: 
          localbmr.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 6: 
          localbmr.coverUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 7: 
          localbmr.width = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(258855);
          return 0;
        case 8: 
          localbmr.height = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(258855);
          return 0;
        case 9: 
          localbmr.ZVh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 10: 
          localbmr.ZVi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 11: 
          localbmr.ZVj = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 12: 
          localbmr.headUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 13: 
          localbmr.objectNonceId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 14: 
          localbmr.liveStatus = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258855);
          return 0;
        case 15: 
          localbmr.extFlag = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258855);
          return 0;
        case 16: 
          localbmr.sourceType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258855);
          return 0;
        case 17: 
          localbmr.ecSource = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 18: 
          localbmr.ZVk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 19: 
          localbmr.authIconType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258855);
          return 0;
        case 20: 
          localbmr.mIJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258855);
          return 0;
        case 21: 
          localbmr.hUQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 22: 
          localbmr.mIK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 23: 
          localbmr.ZVl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258855);
          return 0;
        case 24: 
          localbmr.hTM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 100: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bip localbip = new bip();
            if ((localObject != null) && (localObject.length > 0)) {
              localbip.parseFrom((byte[])localObject);
            }
            localbmr.ZVm = localbip;
            paramInt += 1;
          }
          AppMethodBeat.o(258855);
          return 0;
        case 25: 
          localbmr.ZVn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 26: 
          localbmr.ZVo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 27: 
          localbmr.ZVp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 28: 
          localbmr.ZVq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 29: 
          localbmr.ZVr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 30: 
          localbmr.ZVs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 31: 
          localbmr.eventId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 32: 
          localbmr.ZVt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        case 33: 
          localbmr.ZVu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258855);
          return 0;
        }
        localbmr.ZVv = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258855);
        return 0;
      }
      AppMethodBeat.o(258855);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmr
 * JD-Core Version:    0.7.0.1
 */