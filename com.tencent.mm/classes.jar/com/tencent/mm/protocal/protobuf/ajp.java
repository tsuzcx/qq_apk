package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ajp
  extends com.tencent.mm.bx.a
{
  public boolean GiQ = false;
  public boolean GiR = false;
  public boolean GiS = false;
  public String GiT;
  public boolean GiU = false;
  public String GiV;
  public boolean GiW = false;
  public boolean GiX = false;
  public boolean GiY = false;
  public boolean GiZ = false;
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
  
  public final ajp CJ(long paramLong)
  {
    this.createTime = paramLong;
    this.hZR = true;
    return this;
  }
  
  public final ajp ZM(int paramInt)
  {
    this.sourceType = paramInt;
    this.GiQ = true;
    return this;
  }
  
  public final ajp aOO(String paramString)
  {
    this.dyU = paramString;
    this.GiR = true;
    return this;
  }
  
  public final ajp aOP(String paramString)
  {
    this.toUser = paramString;
    this.GiS = true;
    return this;
  }
  
  public final ajp aOQ(String paramString)
  {
    this.GiT = paramString;
    this.GiU = true;
    return this;
  }
  
  public final ajp aOR(String paramString)
  {
    this.GiV = paramString;
    this.GiW = true;
    return this;
  }
  
  public final ajp aOS(String paramString)
  {
    this.msgId = paramString;
    this.GiX = true;
    return this;
  }
  
  public final ajp aOT(String paramString)
  {
    this.appId = paramString;
    this.GiZ = true;
    return this;
  }
  
  public final ajp aOU(String paramString)
  {
    this.link = paramString;
    this.Gja = true;
    return this;
  }
  
  public final ajp aOV(String paramString)
  {
    this.djX = paramString;
    this.Gjd = true;
    return this;
  }
  
  public final String fgM()
  {
    return this.dyU;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (!this.GiQ)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(127459);
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
      if (this.GiT != null) {
        paramVarArgs.d(4, this.GiT);
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
      AppMethodBeat.o(127459);
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
      if (this.GiT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GiT);
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
      AppMethodBeat.o(127459);
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
          AppMethodBeat.o(127459);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127459);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ajp localajp = (ajp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127459);
          return -1;
        case 1: 
          localajp.sourceType = locala.NPN.zc();
          localajp.GiQ = true;
          AppMethodBeat.o(127459);
          return 0;
        case 2: 
          localajp.dyU = locala.NPN.readString();
          localajp.GiR = true;
          AppMethodBeat.o(127459);
          return 0;
        case 3: 
          localajp.toUser = locala.NPN.readString();
          localajp.GiS = true;
          AppMethodBeat.o(127459);
          return 0;
        case 4: 
          localajp.GiT = locala.NPN.readString();
          localajp.GiU = true;
          AppMethodBeat.o(127459);
          return 0;
        case 5: 
          localajp.GiV = locala.NPN.readString();
          localajp.GiW = true;
          AppMethodBeat.o(127459);
          return 0;
        case 6: 
          localajp.createTime = locala.NPN.zd();
          localajp.hZR = true;
          AppMethodBeat.o(127459);
          return 0;
        case 7: 
          localajp.msgId = locala.NPN.readString();
          localajp.GiX = true;
          AppMethodBeat.o(127459);
          return 0;
        case 8: 
          localajp.dKz = locala.NPN.readString();
          localajp.GiY = true;
          AppMethodBeat.o(127459);
          return 0;
        case 9: 
          localajp.appId = locala.NPN.readString();
          localajp.GiZ = true;
          AppMethodBeat.o(127459);
          return 0;
        case 10: 
          localajp.link = locala.NPN.readString();
          localajp.Gja = true;
          AppMethodBeat.o(127459);
          return 0;
        case 11: 
          localajp.Gjb = locala.NPN.readString();
          localajp.Gjc = true;
          AppMethodBeat.o(127459);
          return 0;
        }
        localajp.djX = locala.NPN.readString();
        localajp.Gjd = true;
        AppMethodBeat.o(127459);
        return 0;
      }
      AppMethodBeat.o(127459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajp
 * JD-Core Version:    0.7.0.1
 */