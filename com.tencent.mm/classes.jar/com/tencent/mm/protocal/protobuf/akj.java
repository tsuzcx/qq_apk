package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class akj
  extends com.tencent.mm.bx.a
{
  public boolean GiQ = false;
  public boolean GiR = false;
  public boolean GiS = false;
  public String GiV;
  public boolean GiW = false;
  public boolean GiX = false;
  public boolean GiY = false;
  public boolean GiZ = false;
  public String GjD;
  public boolean GjE = false;
  public boolean Gja = false;
  public String Gjb;
  public boolean Gjc = false;
  public boolean Gjd = false;
  public String appId;
  public long createTime;
  public String dKz;
  public String djX;
  public String dyU;
  public boolean hZR = false;
  public String link;
  public String msgId;
  public int sourceType;
  public String toUser;
  
  public final akj CM(long paramLong)
  {
    this.createTime = paramLong;
    this.hZR = true;
    return this;
  }
  
  public final akj ZR(int paramInt)
  {
    this.sourceType = paramInt;
    this.GiQ = true;
    return this;
  }
  
  public final akj aPf(String paramString)
  {
    this.dyU = paramString;
    this.GiR = true;
    return this;
  }
  
  public final akj aPg(String paramString)
  {
    this.toUser = paramString;
    this.GiS = true;
    return this;
  }
  
  public final akj aPh(String paramString)
  {
    this.GjD = paramString;
    this.GjE = true;
    return this;
  }
  
  public final akj aPi(String paramString)
  {
    this.GiV = paramString;
    this.GiW = true;
    return this;
  }
  
  public final akj aPj(String paramString)
  {
    this.msgId = paramString;
    this.GiX = true;
    return this;
  }
  
  public final akj aPk(String paramString)
  {
    this.dKz = paramString;
    this.GiY = true;
    return this;
  }
  
  public final akj aPl(String paramString)
  {
    this.appId = paramString;
    this.GiZ = true;
    return this;
  }
  
  public final akj aPm(String paramString)
  {
    this.link = paramString;
    this.Gja = true;
    return this;
  }
  
  public final akj aPn(String paramString)
  {
    this.djX = paramString;
    this.Gjd = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (!this.GiQ)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(127481);
        throw paramVarArgs;
      }
      if (this.GiQ == true) {
        paramVarArgs.aS(1, this.sourceType);
      }
      if (this.dyU != null) {
        paramVarArgs.d(2, this.dyU);
      }
      if (this.toUser != null) {
        paramVarArgs.d(3, this.toUser);
      }
      if (this.GjD != null) {
        paramVarArgs.d(4, this.GjD);
      }
      if (this.GiV != null) {
        paramVarArgs.d(5, this.GiV);
      }
      if (this.hZR == true) {
        paramVarArgs.aY(6, this.createTime);
      }
      if (this.msgId != null) {
        paramVarArgs.d(7, this.msgId);
      }
      if (this.dKz != null) {
        paramVarArgs.d(8, this.dKz);
      }
      if (this.appId != null) {
        paramVarArgs.d(9, this.appId);
      }
      if (this.link != null) {
        paramVarArgs.d(10, this.link);
      }
      if (this.Gjb != null) {
        paramVarArgs.d(11, this.Gjb);
      }
      if (this.djX != null) {
        paramVarArgs.d(12, this.djX);
      }
      AppMethodBeat.o(127481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GiQ != true) {
        break label1014;
      }
    }
    label1014:
    for (int i = f.a.a.b.b.a.bz(1, this.sourceType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dyU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyU);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.toUser);
      }
      paramInt = i;
      if (this.GjD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GjD);
      }
      i = paramInt;
      if (this.GiV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GiV);
      }
      paramInt = i;
      if (this.hZR == true) {
        paramInt = i + f.a.a.b.b.a.p(6, this.createTime);
      }
      i = paramInt;
      if (this.msgId != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.msgId);
      }
      paramInt = i;
      if (this.dKz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dKz);
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
      if (this.Gjb != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Gjb);
      }
      paramInt = i;
      if (this.djX != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.djX);
      }
      AppMethodBeat.o(127481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (!this.GiQ)
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
        akj localakj = (akj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127481);
          return -1;
        case 1: 
          localakj.sourceType = locala.NPN.zc();
          localakj.GiQ = true;
          AppMethodBeat.o(127481);
          return 0;
        case 2: 
          localakj.dyU = locala.NPN.readString();
          localakj.GiR = true;
          AppMethodBeat.o(127481);
          return 0;
        case 3: 
          localakj.toUser = locala.NPN.readString();
          localakj.GiS = true;
          AppMethodBeat.o(127481);
          return 0;
        case 4: 
          localakj.GjD = locala.NPN.readString();
          localakj.GjE = true;
          AppMethodBeat.o(127481);
          return 0;
        case 5: 
          localakj.GiV = locala.NPN.readString();
          localakj.GiW = true;
          AppMethodBeat.o(127481);
          return 0;
        case 6: 
          localakj.createTime = locala.NPN.zd();
          localakj.hZR = true;
          AppMethodBeat.o(127481);
          return 0;
        case 7: 
          localakj.msgId = locala.NPN.readString();
          localakj.GiX = true;
          AppMethodBeat.o(127481);
          return 0;
        case 8: 
          localakj.dKz = locala.NPN.readString();
          localakj.GiY = true;
          AppMethodBeat.o(127481);
          return 0;
        case 9: 
          localakj.appId = locala.NPN.readString();
          localakj.GiZ = true;
          AppMethodBeat.o(127481);
          return 0;
        case 10: 
          localakj.link = locala.NPN.readString();
          localakj.Gja = true;
          AppMethodBeat.o(127481);
          return 0;
        case 11: 
          localakj.Gjb = locala.NPN.readString();
          localakj.Gjc = true;
          AppMethodBeat.o(127481);
          return 0;
        }
        localakj.djX = locala.NPN.readString();
        localakj.Gjd = true;
        AppMethodBeat.o(127481);
        return 0;
      }
      AppMethodBeat.o(127481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akj
 * JD-Core Version:    0.7.0.1
 */