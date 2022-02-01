package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eiz
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String ZhO;
  public String ZhP;
  public ffs aaMs;
  public ahl aaMt;
  public String aant;
  public int abnM;
  public String abnN;
  public int abnO;
  public String abnP;
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
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155448);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abnM);
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(3, this.vhX);
      }
      if (this.abnN != null) {
        paramVarArgs.g(4, this.abnN);
      }
      paramVarArgs.bS(5, this.abnO);
      if (this.abnP != null) {
        paramVarArgs.g(6, this.abnP);
      }
      paramVarArgs.bS(7, this.pSf);
      if (this.pSg != null) {
        paramVarArgs.g(8, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(9, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(10, this.pSi);
      }
      paramVarArgs.bS(11, this.pSj);
      if (this.pSk != null) {
        paramVarArgs.g(12, this.pSk);
      }
      paramVarArgs.bS(13, this.pSl);
      paramVarArgs.bS(14, this.pSm);
      if (this.pSn != null) {
        paramVarArgs.g(15, this.pSn);
      }
      if (this.aaMs != null)
      {
        paramVarArgs.qD(16, this.aaMs.computeSize());
        this.aaMs.writeFields(paramVarArgs);
      }
      if (this.pSo != null) {
        paramVarArgs.g(17, this.pSo);
      }
      if (this.pSp != null) {
        paramVarArgs.g(18, this.pSp);
      }
      if (this.aaMt != null)
      {
        paramVarArgs.qD(19, this.aaMt.computeSize());
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
      AppMethodBeat.o(155448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abnM) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.vhX);
      }
      paramInt = i;
      if (this.abnN != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abnN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abnO);
      paramInt = i;
      if (this.abnP != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abnP);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.pSf);
      paramInt = i;
      if (this.pSg != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.pSg);
      }
      i = paramInt;
      if (this.pSh != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.pSh);
      }
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.pSi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.pSj);
      paramInt = i;
      if (this.pSk != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.pSk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.pSl) + i.a.a.b.b.a.cJ(14, this.pSm);
      paramInt = i;
      if (this.pSn != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.pSn);
      }
      i = paramInt;
      if (this.aaMs != null) {
        i = paramInt + i.a.a.a.qC(16, this.aaMs.computeSize());
      }
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.pSo);
      }
      i = paramInt;
      if (this.pSp != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.pSp);
      }
      paramInt = i;
      if (this.aaMt != null) {
        paramInt = i + i.a.a.a.qC(19, this.aaMt.computeSize());
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
      AppMethodBeat.o(155448);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(155448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      eiz localeiz = (eiz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155448);
        return -1;
      case 1: 
        localeiz.abnM = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(155448);
        return 0;
      case 2: 
        localeiz.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 3: 
        localeiz.vhX = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 4: 
        localeiz.abnN = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 5: 
        localeiz.abnO = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(155448);
        return 0;
      case 6: 
        localeiz.abnP = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 7: 
        localeiz.pSf = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(155448);
        return 0;
      case 8: 
        localeiz.pSg = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 9: 
        localeiz.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 10: 
        localeiz.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 11: 
        localeiz.pSj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(155448);
        return 0;
      case 12: 
        localeiz.pSk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 13: 
        localeiz.pSl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(155448);
        return 0;
      case 14: 
        localeiz.pSm = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(155448);
        return 0;
      case 15: 
        localeiz.pSn = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 16: 
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
          localeiz.aaMs = ((ffs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 17: 
        localeiz.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 18: 
        localeiz.pSp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 19: 
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
          localeiz.aaMt = ((ahl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155448);
        return 0;
      case 20: 
        localeiz.ZhO = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      case 21: 
        localeiz.ZhP = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155448);
        return 0;
      }
      localeiz.aant = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(155448);
      return 0;
    }
    AppMethodBeat.o(155448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiz
 * JD-Core Version:    0.7.0.1
 */