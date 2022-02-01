package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkk
  extends com.tencent.mm.bx.a
{
  public String Nickname;
  public String Username;
  public String ZhO;
  public String ZhP;
  public ffs aaMs;
  public ahl aaMt;
  public apz aaQq;
  public String aant;
  public String pSe;
  public int pSf;
  public String pSg;
  public String pSh;
  public String pSi;
  public int pSj;
  public String pSk;
  public int pSl;
  public int pSm;
  public String pSn;
  public String pSo;
  public String pSp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155440);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.g(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.g(2, this.Nickname);
      }
      if (this.pSe != null) {
        paramVarArgs.g(3, this.pSe);
      }
      paramVarArgs.bS(4, this.pSf);
      if (this.pSg != null) {
        paramVarArgs.g(5, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(6, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(7, this.pSi);
      }
      paramVarArgs.bS(8, this.pSj);
      if (this.pSk != null) {
        paramVarArgs.g(9, this.pSk);
      }
      if (this.aaQq != null)
      {
        paramVarArgs.qD(10, this.aaQq.computeSize());
        this.aaQq.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.pSl);
      paramVarArgs.bS(12, this.pSm);
      if (this.pSn != null) {
        paramVarArgs.g(13, this.pSn);
      }
      if (this.aaMs != null)
      {
        paramVarArgs.qD(14, this.aaMs.computeSize());
        this.aaMs.writeFields(paramVarArgs);
      }
      if (this.pSo != null) {
        paramVarArgs.g(15, this.pSo);
      }
      if (this.pSp != null) {
        paramVarArgs.g(16, this.pSp);
      }
      if (this.aaMt != null)
      {
        paramVarArgs.qD(17, this.aaMt.computeSize());
        this.aaMt.writeFields(paramVarArgs);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(20, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(21, this.ZhP);
      }
      if (this.aant != null) {
        paramVarArgs.g(22, this.aant);
      }
      AppMethodBeat.o(155440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1540;
      }
    }
    label1540:
    for (int i = i.a.a.b.b.a.h(1, this.Username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Nickname);
      }
      i = paramInt;
      if (this.pSe != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.pSe);
      }
      i += i.a.a.b.b.a.cJ(4, this.pSf);
      paramInt = i;
      if (this.pSg != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.pSg);
      }
      i = paramInt;
      if (this.pSh != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.pSh);
      }
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.pSi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.pSj);
      paramInt = i;
      if (this.pSk != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.pSk);
      }
      i = paramInt;
      if (this.aaQq != null) {
        i = paramInt + i.a.a.a.qC(10, this.aaQq.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(11, this.pSl) + i.a.a.b.b.a.cJ(12, this.pSm);
      paramInt = i;
      if (this.pSn != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.pSn);
      }
      i = paramInt;
      if (this.aaMs != null) {
        i = paramInt + i.a.a.a.qC(14, this.aaMs.computeSize());
      }
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.pSo);
      }
      i = paramInt;
      if (this.pSp != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.pSp);
      }
      paramInt = i;
      if (this.aaMt != null) {
        paramInt = i + i.a.a.a.qC(17, this.aaMt.computeSize());
      }
      i = paramInt;
      if (this.ZhO != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.ZhO);
      }
      paramInt = i;
      if (this.ZhP != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.ZhP);
      }
      i = paramInt;
      if (this.aant != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.aant);
      }
      AppMethodBeat.o(155440);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dkk localdkk = (dkk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        default: 
          AppMethodBeat.o(155440);
          return -1;
        case 1: 
          localdkk.Username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 2: 
          localdkk.Nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 3: 
          localdkk.pSe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 4: 
          localdkk.pSf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155440);
          return 0;
        case 5: 
          localdkk.pSg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 6: 
          localdkk.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 7: 
          localdkk.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 8: 
          localdkk.pSj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155440);
          return 0;
        case 9: 
          localdkk.pSk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new apz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((apz)localObject2).parseFrom((byte[])localObject1);
            }
            localdkk.aaQq = ((apz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 11: 
          localdkk.pSl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155440);
          return 0;
        case 12: 
          localdkk.pSm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155440);
          return 0;
        case 13: 
          localdkk.pSn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffs)localObject2).parseFrom((byte[])localObject1);
            }
            localdkk.aaMs = ((ffs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 15: 
          localdkk.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 16: 
          localdkk.pSp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ahl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ahl)localObject2).parseFrom((byte[])localObject1);
            }
            localdkk.aaMt = ((ahl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 20: 
          localdkk.ZhO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 21: 
          localdkk.ZhP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155440);
          return 0;
        }
        localdkk.aant = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155440);
        return 0;
      }
      AppMethodBeat.o(155440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkk
 * JD-Core Version:    0.7.0.1
 */