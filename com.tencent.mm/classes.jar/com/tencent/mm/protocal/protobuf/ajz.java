package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ajz
  extends com.tencent.mm.bw.a
{
  public boolean GBA = false;
  public boolean GBB = false;
  public String GBC;
  public boolean GBD = false;
  public String GBE;
  public boolean GBF = false;
  public boolean GBG = false;
  public boolean GBH = false;
  public boolean GBI = false;
  public boolean GBJ = false;
  public String GBK;
  public boolean GBL = false;
  public boolean GBM = false;
  public boolean GBz = false;
  public String appId;
  public long createTime;
  public String dLO;
  public String dkZ;
  public String dzZ;
  public boolean icJ = false;
  public String link;
  public String msgId;
  public int sourceType;
  public String toUser;
  
  public final ajz Dh(long paramLong)
  {
    this.createTime = paramLong;
    this.icJ = true;
    return this;
  }
  
  public final ajz aQl(String paramString)
  {
    this.dzZ = paramString;
    this.GBA = true;
    return this;
  }
  
  public final ajz aQm(String paramString)
  {
    this.toUser = paramString;
    this.GBB = true;
    return this;
  }
  
  public final ajz aQn(String paramString)
  {
    this.GBC = paramString;
    this.GBD = true;
    return this;
  }
  
  public final ajz aQo(String paramString)
  {
    this.GBE = paramString;
    this.GBF = true;
    return this;
  }
  
  public final ajz aQp(String paramString)
  {
    this.msgId = paramString;
    this.GBG = true;
    return this;
  }
  
  public final ajz aQq(String paramString)
  {
    this.appId = paramString;
    this.GBI = true;
    return this;
  }
  
  public final ajz aQr(String paramString)
  {
    this.link = paramString;
    this.GBJ = true;
    return this;
  }
  
  public final ajz aQs(String paramString)
  {
    this.dkZ = paramString;
    this.GBM = true;
    return this;
  }
  
  public final ajz aas(int paramInt)
  {
    this.sourceType = paramInt;
    this.GBz = true;
    return this;
  }
  
  public final String fkD()
  {
    return this.dzZ;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (!this.GBz)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(127459);
        throw paramVarArgs;
      }
      if (this.GBz == true) {
        paramVarArgs.aS(1, this.sourceType);
      }
      if (this.dzZ != null) {
        paramVarArgs.d(2, this.dzZ);
      }
      if (this.toUser != null) {
        paramVarArgs.d(3, this.toUser);
      }
      if (this.GBC != null) {
        paramVarArgs.d(4, this.GBC);
      }
      if (this.GBE != null) {
        paramVarArgs.d(5, this.GBE);
      }
      if (this.icJ == true) {
        paramVarArgs.aZ(6, this.createTime);
      }
      if (this.msgId != null) {
        paramVarArgs.d(7, this.msgId);
      }
      if (this.dLO != null) {
        paramVarArgs.d(8, this.dLO);
      }
      if (this.appId != null) {
        paramVarArgs.d(9, this.appId);
      }
      if (this.link != null) {
        paramVarArgs.d(10, this.link);
      }
      if (this.GBK != null) {
        paramVarArgs.d(11, this.GBK);
      }
      if (this.dkZ != null) {
        paramVarArgs.d(12, this.dkZ);
      }
      AppMethodBeat.o(127459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GBz != true) {
        break label1014;
      }
    }
    label1014:
    for (int i = f.a.a.b.b.a.bz(1, this.sourceType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dzZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dzZ);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.toUser);
      }
      paramInt = i;
      if (this.GBC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GBC);
      }
      i = paramInt;
      if (this.GBE != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GBE);
      }
      paramInt = i;
      if (this.icJ == true) {
        paramInt = i + f.a.a.b.b.a.p(6, this.createTime);
      }
      i = paramInt;
      if (this.msgId != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.msgId);
      }
      paramInt = i;
      if (this.dLO != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dLO);
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
      if (this.GBK != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GBK);
      }
      paramInt = i;
      if (this.dkZ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.dkZ);
      }
      AppMethodBeat.o(127459);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (!this.GBz)
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
        ajz localajz = (ajz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127459);
          return -1;
        case 1: 
          localajz.sourceType = locala.OmT.zc();
          localajz.GBz = true;
          AppMethodBeat.o(127459);
          return 0;
        case 2: 
          localajz.dzZ = locala.OmT.readString();
          localajz.GBA = true;
          AppMethodBeat.o(127459);
          return 0;
        case 3: 
          localajz.toUser = locala.OmT.readString();
          localajz.GBB = true;
          AppMethodBeat.o(127459);
          return 0;
        case 4: 
          localajz.GBC = locala.OmT.readString();
          localajz.GBD = true;
          AppMethodBeat.o(127459);
          return 0;
        case 5: 
          localajz.GBE = locala.OmT.readString();
          localajz.GBF = true;
          AppMethodBeat.o(127459);
          return 0;
        case 6: 
          localajz.createTime = locala.OmT.zd();
          localajz.icJ = true;
          AppMethodBeat.o(127459);
          return 0;
        case 7: 
          localajz.msgId = locala.OmT.readString();
          localajz.GBG = true;
          AppMethodBeat.o(127459);
          return 0;
        case 8: 
          localajz.dLO = locala.OmT.readString();
          localajz.GBH = true;
          AppMethodBeat.o(127459);
          return 0;
        case 9: 
          localajz.appId = locala.OmT.readString();
          localajz.GBI = true;
          AppMethodBeat.o(127459);
          return 0;
        case 10: 
          localajz.link = locala.OmT.readString();
          localajz.GBJ = true;
          AppMethodBeat.o(127459);
          return 0;
        case 11: 
          localajz.GBK = locala.OmT.readString();
          localajz.GBL = true;
          AppMethodBeat.o(127459);
          return 0;
        }
        localajz.dkZ = locala.OmT.readString();
        localajz.GBM = true;
        AppMethodBeat.o(127459);
        return 0;
      }
      AppMethodBeat.o(127459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajz
 * JD-Core Version:    0.7.0.1
 */