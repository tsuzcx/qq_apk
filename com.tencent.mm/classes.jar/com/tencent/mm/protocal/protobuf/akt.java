package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class akt
  extends com.tencent.mm.bw.a
{
  public boolean GBA = false;
  public boolean GBB = false;
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
  public String GCm;
  public boolean GCn = false;
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
  
  public final akt Dk(long paramLong)
  {
    this.createTime = paramLong;
    this.icJ = true;
    return this;
  }
  
  public final akt aQC(String paramString)
  {
    this.dzZ = paramString;
    this.GBA = true;
    return this;
  }
  
  public final akt aQD(String paramString)
  {
    this.toUser = paramString;
    this.GBB = true;
    return this;
  }
  
  public final akt aQE(String paramString)
  {
    this.GCm = paramString;
    this.GCn = true;
    return this;
  }
  
  public final akt aQF(String paramString)
  {
    this.GBE = paramString;
    this.GBF = true;
    return this;
  }
  
  public final akt aQG(String paramString)
  {
    this.msgId = paramString;
    this.GBG = true;
    return this;
  }
  
  public final akt aQH(String paramString)
  {
    this.dLO = paramString;
    this.GBH = true;
    return this;
  }
  
  public final akt aQI(String paramString)
  {
    this.appId = paramString;
    this.GBI = true;
    return this;
  }
  
  public final akt aQJ(String paramString)
  {
    this.link = paramString;
    this.GBJ = true;
    return this;
  }
  
  public final akt aQK(String paramString)
  {
    this.dkZ = paramString;
    this.GBM = true;
    return this;
  }
  
  public final akt aax(int paramInt)
  {
    this.sourceType = paramInt;
    this.GBz = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (!this.GBz)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(127481);
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
      if (this.GCm != null) {
        paramVarArgs.d(4, this.GCm);
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
      AppMethodBeat.o(127481);
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
      if (this.GCm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GCm);
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
      AppMethodBeat.o(127481);
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
          AppMethodBeat.o(127481);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127481);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        akt localakt = (akt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127481);
          return -1;
        case 1: 
          localakt.sourceType = locala.OmT.zc();
          localakt.GBz = true;
          AppMethodBeat.o(127481);
          return 0;
        case 2: 
          localakt.dzZ = locala.OmT.readString();
          localakt.GBA = true;
          AppMethodBeat.o(127481);
          return 0;
        case 3: 
          localakt.toUser = locala.OmT.readString();
          localakt.GBB = true;
          AppMethodBeat.o(127481);
          return 0;
        case 4: 
          localakt.GCm = locala.OmT.readString();
          localakt.GCn = true;
          AppMethodBeat.o(127481);
          return 0;
        case 5: 
          localakt.GBE = locala.OmT.readString();
          localakt.GBF = true;
          AppMethodBeat.o(127481);
          return 0;
        case 6: 
          localakt.createTime = locala.OmT.zd();
          localakt.icJ = true;
          AppMethodBeat.o(127481);
          return 0;
        case 7: 
          localakt.msgId = locala.OmT.readString();
          localakt.GBG = true;
          AppMethodBeat.o(127481);
          return 0;
        case 8: 
          localakt.dLO = locala.OmT.readString();
          localakt.GBH = true;
          AppMethodBeat.o(127481);
          return 0;
        case 9: 
          localakt.appId = locala.OmT.readString();
          localakt.GBI = true;
          AppMethodBeat.o(127481);
          return 0;
        case 10: 
          localakt.link = locala.OmT.readString();
          localakt.GBJ = true;
          AppMethodBeat.o(127481);
          return 0;
        case 11: 
          localakt.GBK = locala.OmT.readString();
          localakt.GBL = true;
          AppMethodBeat.o(127481);
          return 0;
        }
        localakt.dkZ = locala.OmT.readString();
        localakt.GBM = true;
        AppMethodBeat.o(127481);
        return 0;
      }
      AppMethodBeat.o(127481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akt
 * JD-Core Version:    0.7.0.1
 */