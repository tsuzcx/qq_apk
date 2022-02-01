package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class agu
  extends com.tencent.mm.bx.a
{
  public boolean DhY = false;
  public boolean DhZ = false;
  public String DiL;
  public boolean DiM = false;
  public boolean Dia = false;
  public String Did;
  public boolean Die = false;
  public boolean Dif = false;
  public boolean Dig = false;
  public boolean Dih = false;
  public boolean Dii = false;
  public String Dij;
  public boolean Dik = false;
  public boolean Dil = false;
  public String appId;
  public long createTime;
  public String dAA;
  public String dbj;
  public String dpv;
  public String dvT;
  public boolean hgE = false;
  public String link;
  public int sourceType;
  public String toUser;
  
  public final agu VM(int paramInt)
  {
    this.sourceType = paramInt;
    this.DhY = true;
    return this;
  }
  
  public final agu aEl(String paramString)
  {
    this.dpv = paramString;
    this.DhZ = true;
    return this;
  }
  
  public final agu aEm(String paramString)
  {
    this.toUser = paramString;
    this.Dia = true;
    return this;
  }
  
  public final agu aEn(String paramString)
  {
    this.DiL = paramString;
    this.DiM = true;
    return this;
  }
  
  public final agu aEo(String paramString)
  {
    this.Did = paramString;
    this.Die = true;
    return this;
  }
  
  public final agu aEp(String paramString)
  {
    this.dvT = paramString;
    this.Dif = true;
    return this;
  }
  
  public final agu aEq(String paramString)
  {
    this.dAA = paramString;
    this.Dig = true;
    return this;
  }
  
  public final agu aEr(String paramString)
  {
    this.appId = paramString;
    this.Dih = true;
    return this;
  }
  
  public final agu aEs(String paramString)
  {
    this.link = paramString;
    this.Dii = true;
    return this;
  }
  
  public final agu aEt(String paramString)
  {
    this.dbj = paramString;
    this.Dil = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (!this.DhY)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(127481);
        throw paramVarArgs;
      }
      if (this.DhY == true) {
        paramVarArgs.aR(1, this.sourceType);
      }
      if (this.dpv != null) {
        paramVarArgs.d(2, this.dpv);
      }
      if (this.toUser != null) {
        paramVarArgs.d(3, this.toUser);
      }
      if (this.DiL != null) {
        paramVarArgs.d(4, this.DiL);
      }
      if (this.Did != null) {
        paramVarArgs.d(5, this.Did);
      }
      if (this.hgE == true) {
        paramVarArgs.aG(6, this.createTime);
      }
      if (this.dvT != null) {
        paramVarArgs.d(7, this.dvT);
      }
      if (this.dAA != null) {
        paramVarArgs.d(8, this.dAA);
      }
      if (this.appId != null) {
        paramVarArgs.d(9, this.appId);
      }
      if (this.link != null) {
        paramVarArgs.d(10, this.link);
      }
      if (this.Dij != null) {
        paramVarArgs.d(11, this.Dij);
      }
      if (this.dbj != null) {
        paramVarArgs.d(12, this.dbj);
      }
      AppMethodBeat.o(127481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DhY != true) {
        break label1014;
      }
    }
    label1014:
    for (int i = f.a.a.b.b.a.bA(1, this.sourceType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dpv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dpv);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.toUser);
      }
      paramInt = i;
      if (this.DiL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DiL);
      }
      i = paramInt;
      if (this.Did != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Did);
      }
      paramInt = i;
      if (this.hgE == true) {
        paramInt = i + f.a.a.b.b.a.q(6, this.createTime);
      }
      i = paramInt;
      if (this.dvT != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dvT);
      }
      paramInt = i;
      if (this.dAA != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dAA);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.appId);
      }
      paramInt = i;
      if (this.link != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.link);
      }
      i = paramInt;
      if (this.Dij != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Dij);
      }
      paramInt = i;
      if (this.dbj != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.dbj);
      }
      AppMethodBeat.o(127481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (!this.DhY)
        {
          paramVarArgs = new b("Not all required fields were included: sourceType");
          AppMethodBeat.o(127481);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127481);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agu localagu = (agu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127481);
          return -1;
        case 1: 
          localagu.sourceType = locala.KhF.xS();
          localagu.DhY = true;
          AppMethodBeat.o(127481);
          return 0;
        case 2: 
          localagu.dpv = locala.KhF.readString();
          localagu.DhZ = true;
          AppMethodBeat.o(127481);
          return 0;
        case 3: 
          localagu.toUser = locala.KhF.readString();
          localagu.Dia = true;
          AppMethodBeat.o(127481);
          return 0;
        case 4: 
          localagu.DiL = locala.KhF.readString();
          localagu.DiM = true;
          AppMethodBeat.o(127481);
          return 0;
        case 5: 
          localagu.Did = locala.KhF.readString();
          localagu.Die = true;
          AppMethodBeat.o(127481);
          return 0;
        case 6: 
          localagu.createTime = locala.KhF.xT();
          localagu.hgE = true;
          AppMethodBeat.o(127481);
          return 0;
        case 7: 
          localagu.dvT = locala.KhF.readString();
          localagu.Dif = true;
          AppMethodBeat.o(127481);
          return 0;
        case 8: 
          localagu.dAA = locala.KhF.readString();
          localagu.Dig = true;
          AppMethodBeat.o(127481);
          return 0;
        case 9: 
          localagu.appId = locala.KhF.readString();
          localagu.Dih = true;
          AppMethodBeat.o(127481);
          return 0;
        case 10: 
          localagu.link = locala.KhF.readString();
          localagu.Dii = true;
          AppMethodBeat.o(127481);
          return 0;
        case 11: 
          localagu.Dij = locala.KhF.readString();
          localagu.Dik = true;
          AppMethodBeat.o(127481);
          return 0;
        }
        localagu.dbj = locala.KhF.readString();
        localagu.Dil = true;
        AppMethodBeat.o(127481);
        return 0;
      }
      AppMethodBeat.o(127481);
      return -1;
    }
  }
  
  public final agu vv(long paramLong)
  {
    this.createTime = paramLong;
    this.hgE = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agu
 * JD-Core Version:    0.7.0.1
 */