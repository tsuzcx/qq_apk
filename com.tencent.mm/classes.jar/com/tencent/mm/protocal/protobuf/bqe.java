package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqe
  extends com.tencent.mm.bx.a
{
  public int ZFD;
  public int ZFE;
  public int ZFF;
  public int ZGZ;
  public int ZHa;
  public avl ZHb;
  public int ZYe;
  public int ZYf;
  public int ZYg;
  public int ZYh;
  public int ZYi;
  public int ZYj;
  public int ZYk;
  public String city;
  public String country;
  public String coverImgUrl;
  public String coverUrl;
  public String nVs;
  public String nickname;
  public String province;
  public int sex;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169015);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.g(1, this.nickname);
      }
      if (this.signature != null) {
        paramVarArgs.g(2, this.signature);
      }
      if (this.coverImgUrl != null) {
        paramVarArgs.g(3, this.coverImgUrl);
      }
      if (this.nVs != null) {
        paramVarArgs.g(4, this.nVs);
      }
      if (this.country != null) {
        paramVarArgs.g(5, this.country);
      }
      if (this.province != null) {
        paramVarArgs.g(6, this.province);
      }
      if (this.city != null) {
        paramVarArgs.g(7, this.city);
      }
      paramVarArgs.bS(8, this.sex);
      paramVarArgs.bS(9, this.ZFD);
      paramVarArgs.bS(10, this.ZFE);
      paramVarArgs.bS(11, this.ZFF);
      paramVarArgs.bS(12, this.ZGZ);
      paramVarArgs.bS(13, this.ZHa);
      paramVarArgs.bS(14, this.ZYe);
      paramVarArgs.bS(15, this.ZYf);
      paramVarArgs.bS(16, this.ZYg);
      paramVarArgs.bS(17, this.ZYh);
      if (this.ZHb != null)
      {
        paramVarArgs.qD(18, this.ZHb.computeSize());
        this.ZHb.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(19, this.ZYi);
      paramVarArgs.bS(20, this.ZYj);
      if (this.coverUrl != null) {
        paramVarArgs.g(21, this.coverUrl);
      }
      paramVarArgs.bS(22, this.ZYk);
      AppMethodBeat.o(169015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label1352;
      }
    }
    label1352:
    for (int i = i.a.a.b.b.a.h(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.signature);
      }
      i = paramInt;
      if (this.coverImgUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.coverImgUrl);
      }
      paramInt = i;
      if (this.nVs != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nVs);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.country);
      }
      paramInt = i;
      if (this.province != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.province);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.city);
      }
      i = i + i.a.a.b.b.a.cJ(8, this.sex) + i.a.a.b.b.a.cJ(9, this.ZFD) + i.a.a.b.b.a.cJ(10, this.ZFE) + i.a.a.b.b.a.cJ(11, this.ZFF) + i.a.a.b.b.a.cJ(12, this.ZGZ) + i.a.a.b.b.a.cJ(13, this.ZHa) + i.a.a.b.b.a.cJ(14, this.ZYe) + i.a.a.b.b.a.cJ(15, this.ZYf) + i.a.a.b.b.a.cJ(16, this.ZYg) + i.a.a.b.b.a.cJ(17, this.ZYh);
      paramInt = i;
      if (this.ZHb != null) {
        paramInt = i + i.a.a.a.qC(18, this.ZHb.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.ZYi) + i.a.a.b.b.a.cJ(20, this.ZYj);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.coverUrl);
      }
      i = i.a.a.b.b.a.cJ(22, this.ZYk);
      AppMethodBeat.o(169015);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169015);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bqe localbqe = (bqe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169015);
          return -1;
        case 1: 
          localbqe.nickname = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 2: 
          localbqe.signature = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 3: 
          localbqe.coverImgUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 4: 
          localbqe.nVs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 5: 
          localbqe.country = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 6: 
          localbqe.province = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 7: 
          localbqe.city = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 8: 
          localbqe.sex = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 9: 
          localbqe.ZFD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 10: 
          localbqe.ZFE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 11: 
          localbqe.ZFF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 12: 
          localbqe.ZGZ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 13: 
          localbqe.ZHa = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 14: 
          localbqe.ZYe = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 15: 
          localbqe.ZYf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 16: 
          localbqe.ZYg = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 17: 
          localbqe.ZYh = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            avl localavl = new avl();
            if ((localObject != null) && (localObject.length > 0)) {
              localavl.parseFrom((byte[])localObject);
            }
            localbqe.ZHb = localavl;
            paramInt += 1;
          }
          AppMethodBeat.o(169015);
          return 0;
        case 19: 
          localbqe.ZYi = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 20: 
          localbqe.ZYj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169015);
          return 0;
        case 21: 
          localbqe.coverUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169015);
          return 0;
        }
        localbqe.ZYk = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169015);
        return 0;
      }
      AppMethodBeat.o(169015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqe
 * JD-Core Version:    0.7.0.1
 */