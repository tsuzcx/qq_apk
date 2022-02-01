package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aga
  extends com.tencent.mm.bx.a
{
  public boolean DhY = false;
  public boolean DhZ = false;
  public boolean Dia = false;
  public String Dib;
  public boolean Dic = false;
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
  
  public final aga VH(int paramInt)
  {
    this.sourceType = paramInt;
    this.DhY = true;
    return this;
  }
  
  public final aga aDU(String paramString)
  {
    this.dpv = paramString;
    this.DhZ = true;
    return this;
  }
  
  public final aga aDV(String paramString)
  {
    this.toUser = paramString;
    this.Dia = true;
    return this;
  }
  
  public final aga aDW(String paramString)
  {
    this.Dib = paramString;
    this.Dic = true;
    return this;
  }
  
  public final aga aDX(String paramString)
  {
    this.Did = paramString;
    this.Die = true;
    return this;
  }
  
  public final aga aDY(String paramString)
  {
    this.dvT = paramString;
    this.Dif = true;
    return this;
  }
  
  public final aga aDZ(String paramString)
  {
    this.appId = paramString;
    this.Dih = true;
    return this;
  }
  
  public final aga aEa(String paramString)
  {
    this.link = paramString;
    this.Dii = true;
    return this;
  }
  
  public final aga aEb(String paramString)
  {
    this.dbj = paramString;
    this.Dil = true;
    return this;
  }
  
  public final String eCn()
  {
    return this.dpv;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (!this.DhY)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(127459);
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
      if (this.Dib != null) {
        paramVarArgs.d(4, this.Dib);
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
      AppMethodBeat.o(127459);
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
      if (this.Dib != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dib);
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
      AppMethodBeat.o(127459);
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
          AppMethodBeat.o(127459);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127459);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aga localaga = (aga)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127459);
          return -1;
        case 1: 
          localaga.sourceType = locala.KhF.xS();
          localaga.DhY = true;
          AppMethodBeat.o(127459);
          return 0;
        case 2: 
          localaga.dpv = locala.KhF.readString();
          localaga.DhZ = true;
          AppMethodBeat.o(127459);
          return 0;
        case 3: 
          localaga.toUser = locala.KhF.readString();
          localaga.Dia = true;
          AppMethodBeat.o(127459);
          return 0;
        case 4: 
          localaga.Dib = locala.KhF.readString();
          localaga.Dic = true;
          AppMethodBeat.o(127459);
          return 0;
        case 5: 
          localaga.Did = locala.KhF.readString();
          localaga.Die = true;
          AppMethodBeat.o(127459);
          return 0;
        case 6: 
          localaga.createTime = locala.KhF.xT();
          localaga.hgE = true;
          AppMethodBeat.o(127459);
          return 0;
        case 7: 
          localaga.dvT = locala.KhF.readString();
          localaga.Dif = true;
          AppMethodBeat.o(127459);
          return 0;
        case 8: 
          localaga.dAA = locala.KhF.readString();
          localaga.Dig = true;
          AppMethodBeat.o(127459);
          return 0;
        case 9: 
          localaga.appId = locala.KhF.readString();
          localaga.Dih = true;
          AppMethodBeat.o(127459);
          return 0;
        case 10: 
          localaga.link = locala.KhF.readString();
          localaga.Dii = true;
          AppMethodBeat.o(127459);
          return 0;
        case 11: 
          localaga.Dij = locala.KhF.readString();
          localaga.Dik = true;
          AppMethodBeat.o(127459);
          return 0;
        }
        localaga.dbj = locala.KhF.readString();
        localaga.Dil = true;
        AppMethodBeat.o(127459);
        return 0;
      }
      AppMethodBeat.o(127459);
      return -1;
    }
  }
  
  public final aga vs(long paramLong)
  {
    this.createTime = paramLong;
    this.hgE = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aga
 * JD-Core Version:    0.7.0.1
 */