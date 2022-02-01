package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class anh
  extends com.tencent.mm.bw.a
{
  public String LxA;
  public boolean LxB = false;
  public boolean LxC = false;
  public boolean LxD = false;
  public boolean LxE = false;
  public boolean LxF = false;
  public String LxG;
  public boolean LxH = false;
  public boolean LxI = false;
  public boolean Lxw = false;
  public boolean Lxx = false;
  public boolean Lxy = false;
  public String Lyi;
  public boolean Lyj = false;
  public String appId;
  public long createTime;
  public String dCl;
  public String dRL;
  public String edD;
  public boolean iXH = false;
  public String link;
  public String msgId;
  public int sourceType;
  public String toUser;
  
  public final anh MA(long paramLong)
  {
    this.createTime = paramLong;
    this.iXH = true;
    return this;
  }
  
  public final anh ajm(int paramInt)
  {
    this.sourceType = paramInt;
    this.Lxw = true;
    return this;
  }
  
  public final anh bhf(String paramString)
  {
    this.dRL = paramString;
    this.Lxx = true;
    return this;
  }
  
  public final anh bhg(String paramString)
  {
    this.toUser = paramString;
    this.Lxy = true;
    return this;
  }
  
  public final anh bhh(String paramString)
  {
    this.Lyi = paramString;
    this.Lyj = true;
    return this;
  }
  
  public final anh bhi(String paramString)
  {
    this.LxA = paramString;
    this.LxB = true;
    return this;
  }
  
  public final anh bhj(String paramString)
  {
    this.msgId = paramString;
    this.LxC = true;
    return this;
  }
  
  public final anh bhk(String paramString)
  {
    this.edD = paramString;
    this.LxD = true;
    return this;
  }
  
  public final anh bhl(String paramString)
  {
    this.appId = paramString;
    this.LxE = true;
    return this;
  }
  
  public final anh bhm(String paramString)
  {
    this.link = paramString;
    this.LxF = true;
    return this;
  }
  
  public final anh bhn(String paramString)
  {
    this.dCl = paramString;
    this.LxI = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127481);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (!this.Lxw)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(127481);
        throw paramVarArgs;
      }
      if (this.Lxw == true) {
        paramVarArgs.aM(1, this.sourceType);
      }
      if (this.dRL != null) {
        paramVarArgs.e(2, this.dRL);
      }
      if (this.toUser != null) {
        paramVarArgs.e(3, this.toUser);
      }
      if (this.Lyi != null) {
        paramVarArgs.e(4, this.Lyi);
      }
      if (this.LxA != null) {
        paramVarArgs.e(5, this.LxA);
      }
      if (this.iXH == true) {
        paramVarArgs.bb(6, this.createTime);
      }
      if (this.msgId != null) {
        paramVarArgs.e(7, this.msgId);
      }
      if (this.edD != null) {
        paramVarArgs.e(8, this.edD);
      }
      if (this.appId != null) {
        paramVarArgs.e(9, this.appId);
      }
      if (this.link != null) {
        paramVarArgs.e(10, this.link);
      }
      if (this.LxG != null) {
        paramVarArgs.e(11, this.LxG);
      }
      if (this.dCl != null) {
        paramVarArgs.e(12, this.dCl);
      }
      AppMethodBeat.o(127481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lxw != true) {
        break label1014;
      }
    }
    label1014:
    for (int i = g.a.a.b.b.a.bu(1, this.sourceType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dRL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dRL);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.toUser);
      }
      paramInt = i;
      if (this.Lyi != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lyi);
      }
      i = paramInt;
      if (this.LxA != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LxA);
      }
      paramInt = i;
      if (this.iXH == true) {
        paramInt = i + g.a.a.b.b.a.r(6, this.createTime);
      }
      i = paramInt;
      if (this.msgId != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.msgId);
      }
      paramInt = i;
      if (this.edD != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.edD);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.appId);
      }
      paramInt = i;
      if (this.link != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.link);
      }
      i = paramInt;
      if (this.LxG != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.LxG);
      }
      paramInt = i;
      if (this.dCl != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.dCl);
      }
      AppMethodBeat.o(127481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (!this.Lxw)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        anh localanh = (anh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127481);
          return -1;
        case 1: 
          localanh.sourceType = locala.UbS.zi();
          localanh.Lxw = true;
          AppMethodBeat.o(127481);
          return 0;
        case 2: 
          localanh.dRL = locala.UbS.readString();
          localanh.Lxx = true;
          AppMethodBeat.o(127481);
          return 0;
        case 3: 
          localanh.toUser = locala.UbS.readString();
          localanh.Lxy = true;
          AppMethodBeat.o(127481);
          return 0;
        case 4: 
          localanh.Lyi = locala.UbS.readString();
          localanh.Lyj = true;
          AppMethodBeat.o(127481);
          return 0;
        case 5: 
          localanh.LxA = locala.UbS.readString();
          localanh.LxB = true;
          AppMethodBeat.o(127481);
          return 0;
        case 6: 
          localanh.createTime = locala.UbS.zl();
          localanh.iXH = true;
          AppMethodBeat.o(127481);
          return 0;
        case 7: 
          localanh.msgId = locala.UbS.readString();
          localanh.LxC = true;
          AppMethodBeat.o(127481);
          return 0;
        case 8: 
          localanh.edD = locala.UbS.readString();
          localanh.LxD = true;
          AppMethodBeat.o(127481);
          return 0;
        case 9: 
          localanh.appId = locala.UbS.readString();
          localanh.LxE = true;
          AppMethodBeat.o(127481);
          return 0;
        case 10: 
          localanh.link = locala.UbS.readString();
          localanh.LxF = true;
          AppMethodBeat.o(127481);
          return 0;
        case 11: 
          localanh.LxG = locala.UbS.readString();
          localanh.LxH = true;
          AppMethodBeat.o(127481);
          return 0;
        }
        localanh.dCl = locala.UbS.readString();
        localanh.LxI = true;
        AppMethodBeat.o(127481);
        return 0;
      }
      AppMethodBeat.o(127481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anh
 * JD-Core Version:    0.7.0.1
 */