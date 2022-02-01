package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bvl
  extends com.tencent.mm.bx.a
{
  public int GfT;
  public String aacT;
  public String aacU;
  public String aacV;
  public String aacW;
  public int aacX;
  public String aacY;
  public int authIconType;
  public String authIconUrl;
  public String avatar;
  public String desc;
  public int hGP;
  public String hUQ;
  public long localId;
  public String mIK;
  public LinkedList<bvj> mediaList;
  public String nickname;
  public String objectId;
  public String objectNonceId;
  public String username;
  
  public bvl()
  {
    AppMethodBeat.i(164046);
    this.mediaList = new LinkedList();
    AppMethodBeat.o(164046);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164047);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.objectId != null) {
        paramVarArgs.g(1, this.objectId);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(3, this.nickname);
      }
      if (this.avatar != null) {
        paramVarArgs.g(4, this.avatar);
      }
      if (this.desc != null) {
        paramVarArgs.g(5, this.desc);
      }
      paramVarArgs.bS(6, this.GfT);
      paramVarArgs.bS(7, this.hGP);
      paramVarArgs.e(8, 8, this.mediaList);
      if (this.objectNonceId != null) {
        paramVarArgs.g(9, this.objectNonceId);
      }
      paramVarArgs.bv(10, this.localId);
      if (this.aacT != null) {
        paramVarArgs.g(11, this.aacT);
      }
      if (this.aacU != null) {
        paramVarArgs.g(12, this.aacU);
      }
      if (this.hUQ != null) {
        paramVarArgs.g(13, this.hUQ);
      }
      paramVarArgs.bS(14, this.authIconType);
      if (this.authIconUrl != null) {
        paramVarArgs.g(15, this.authIconUrl);
      }
      if (this.mIK != null) {
        paramVarArgs.g(16, this.mIK);
      }
      if (this.aacV != null) {
        paramVarArgs.g(17, this.aacV);
      }
      if (this.aacW != null) {
        paramVarArgs.g(18, this.aacW);
      }
      paramVarArgs.bS(19, this.aacX);
      if (this.aacY != null) {
        paramVarArgs.g(20, this.aacY);
      }
      AppMethodBeat.o(164047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.objectId == null) {
        break label1360;
      }
    }
    label1360:
    for (int i = i.a.a.b.b.a.h(1, this.objectId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nickname);
      }
      paramInt = i;
      if (this.avatar != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.avatar);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.desc);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.GfT) + i.a.a.b.b.a.cJ(7, this.hGP) + i.a.a.a.c(8, 8, this.mediaList);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.objectNonceId);
      }
      i = paramInt + i.a.a.b.b.a.q(10, this.localId);
      paramInt = i;
      if (this.aacT != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aacT);
      }
      i = paramInt;
      if (this.aacU != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aacU);
      }
      paramInt = i;
      if (this.hUQ != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.hUQ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.authIconType);
      paramInt = i;
      if (this.authIconUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.authIconUrl);
      }
      i = paramInt;
      if (this.mIK != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.mIK);
      }
      paramInt = i;
      if (this.aacV != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.aacV);
      }
      i = paramInt;
      if (this.aacW != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.aacW);
      }
      i += i.a.a.b.b.a.cJ(19, this.aacX);
      paramInt = i;
      if (this.aacY != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.aacY);
      }
      AppMethodBeat.o(164047);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mediaList.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(164047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bvl localbvl = (bvl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164047);
          return -1;
        case 1: 
          localbvl.objectId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 2: 
          localbvl.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 3: 
          localbvl.nickname = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 4: 
          localbvl.avatar = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 5: 
          localbvl.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 6: 
          localbvl.GfT = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(164047);
          return 0;
        case 7: 
          localbvl.hGP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(164047);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bvj localbvj = new bvj();
            if ((localObject != null) && (localObject.length > 0)) {
              localbvj.parseFrom((byte[])localObject);
            }
            localbvl.mediaList.add(localbvj);
            paramInt += 1;
          }
          AppMethodBeat.o(164047);
          return 0;
        case 9: 
          localbvl.objectNonceId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 10: 
          localbvl.localId = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(164047);
          return 0;
        case 11: 
          localbvl.aacT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 12: 
          localbvl.aacU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 13: 
          localbvl.hUQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 14: 
          localbvl.authIconType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(164047);
          return 0;
        case 15: 
          localbvl.authIconUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 16: 
          localbvl.mIK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 17: 
          localbvl.aacV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 18: 
          localbvl.aacW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 19: 
          localbvl.aacX = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(164047);
          return 0;
        }
        localbvl.aacY = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(164047);
        return 0;
      }
      AppMethodBeat.o(164047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvl
 * JD-Core Version:    0.7.0.1
 */