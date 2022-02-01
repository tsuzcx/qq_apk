package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfc
  extends com.tencent.mm.cd.a
{
  public int SEg;
  public int SEh;
  public int SEi;
  public int SFk;
  public int SFl;
  public ard SFm;
  public int SPL;
  public int SPM;
  public int SPN;
  public int SPO;
  public int SPP;
  public int SPQ;
  public String city;
  public String country;
  public String coverImgUrl;
  public String lqp;
  public String nickname;
  public String province;
  public int sex;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169015);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.f(1, this.nickname);
      }
      if (this.signature != null) {
        paramVarArgs.f(2, this.signature);
      }
      if (this.coverImgUrl != null) {
        paramVarArgs.f(3, this.coverImgUrl);
      }
      if (this.lqp != null) {
        paramVarArgs.f(4, this.lqp);
      }
      if (this.country != null) {
        paramVarArgs.f(5, this.country);
      }
      if (this.province != null) {
        paramVarArgs.f(6, this.province);
      }
      if (this.city != null) {
        paramVarArgs.f(7, this.city);
      }
      paramVarArgs.aY(8, this.sex);
      paramVarArgs.aY(9, this.SEg);
      paramVarArgs.aY(10, this.SEh);
      paramVarArgs.aY(11, this.SEi);
      paramVarArgs.aY(12, this.SFk);
      paramVarArgs.aY(13, this.SFl);
      paramVarArgs.aY(14, this.SPL);
      paramVarArgs.aY(15, this.SPM);
      paramVarArgs.aY(16, this.SPN);
      paramVarArgs.aY(17, this.SPO);
      if (this.SFm != null)
      {
        paramVarArgs.oE(18, this.SFm.computeSize());
        this.SFm.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(19, this.SPP);
      paramVarArgs.aY(20, this.SPQ);
      AppMethodBeat.o(169015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label1252;
      }
    }
    label1252:
    for (int i = g.a.a.b.b.a.g(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.signature);
      }
      i = paramInt;
      if (this.coverImgUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.coverImgUrl);
      }
      paramInt = i;
      if (this.lqp != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lqp);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.country);
      }
      paramInt = i;
      if (this.province != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.province);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.city);
      }
      i = i + g.a.a.b.b.a.bM(8, this.sex) + g.a.a.b.b.a.bM(9, this.SEg) + g.a.a.b.b.a.bM(10, this.SEh) + g.a.a.b.b.a.bM(11, this.SEi) + g.a.a.b.b.a.bM(12, this.SFk) + g.a.a.b.b.a.bM(13, this.SFl) + g.a.a.b.b.a.bM(14, this.SPL) + g.a.a.b.b.a.bM(15, this.SPM) + g.a.a.b.b.a.bM(16, this.SPN) + g.a.a.b.b.a.bM(17, this.SPO);
      paramInt = i;
      if (this.SFm != null) {
        paramInt = i + g.a.a.a.oD(18, this.SFm.computeSize());
      }
      i = g.a.a.b.b.a.bM(19, this.SPP);
      int j = g.a.a.b.b.a.bM(20, this.SPQ);
      AppMethodBeat.o(169015);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169015);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bfc localbfc = (bfc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169015);
          return -1;
        case 1: 
          localbfc.nickname = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 2: 
          localbfc.signature = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 3: 
          localbfc.coverImgUrl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 4: 
          localbfc.lqp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 5: 
          localbfc.country = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 6: 
          localbfc.province = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 7: 
          localbfc.city = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 8: 
          localbfc.sex = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169015);
          return 0;
        case 9: 
          localbfc.SEg = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169015);
          return 0;
        case 10: 
          localbfc.SEh = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169015);
          return 0;
        case 11: 
          localbfc.SEi = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169015);
          return 0;
        case 12: 
          localbfc.SFk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169015);
          return 0;
        case 13: 
          localbfc.SFl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169015);
          return 0;
        case 14: 
          localbfc.SPL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169015);
          return 0;
        case 15: 
          localbfc.SPM = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169015);
          return 0;
        case 16: 
          localbfc.SPN = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169015);
          return 0;
        case 17: 
          localbfc.SPO = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169015);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ard localard = new ard();
            if ((localObject != null) && (localObject.length > 0)) {
              localard.parseFrom((byte[])localObject);
            }
            localbfc.SFm = localard;
            paramInt += 1;
          }
          AppMethodBeat.o(169015);
          return 0;
        case 19: 
          localbfc.SPP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169015);
          return 0;
        }
        localbfc.SPQ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(169015);
        return 0;
      }
      AppMethodBeat.o(169015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfc
 * JD-Core Version:    0.7.0.1
 */