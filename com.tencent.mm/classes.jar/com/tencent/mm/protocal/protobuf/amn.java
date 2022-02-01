package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class amn
  extends com.tencent.mm.bw.a
{
  public String Gah;
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
  public boolean Lxz = false;
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
  
  public final amn Mx(long paramLong)
  {
    this.createTime = paramLong;
    this.iXH = true;
    return this;
  }
  
  public final amn ajh(int paramInt)
  {
    this.sourceType = paramInt;
    this.Lxw = true;
    return this;
  }
  
  public final amn bgO(String paramString)
  {
    this.dRL = paramString;
    this.Lxx = true;
    return this;
  }
  
  public final amn bgP(String paramString)
  {
    this.toUser = paramString;
    this.Lxy = true;
    return this;
  }
  
  public final amn bgQ(String paramString)
  {
    this.Gah = paramString;
    this.Lxz = true;
    return this;
  }
  
  public final amn bgR(String paramString)
  {
    this.LxA = paramString;
    this.LxB = true;
    return this;
  }
  
  public final amn bgS(String paramString)
  {
    this.msgId = paramString;
    this.LxC = true;
    return this;
  }
  
  public final amn bgT(String paramString)
  {
    this.appId = paramString;
    this.LxE = true;
    return this;
  }
  
  public final amn bgU(String paramString)
  {
    this.link = paramString;
    this.LxF = true;
    return this;
  }
  
  public final amn bgV(String paramString)
  {
    this.dCl = paramString;
    this.LxI = true;
    return this;
  }
  
  public final String getFromUser()
  {
    return this.dRL;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127459);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (!this.Lxw)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(127459);
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
      if (this.Gah != null) {
        paramVarArgs.e(4, this.Gah);
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
      AppMethodBeat.o(127459);
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
      if (this.Gah != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Gah);
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
      AppMethodBeat.o(127459);
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
          AppMethodBeat.o(127459);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127459);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        amn localamn = (amn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127459);
          return -1;
        case 1: 
          localamn.sourceType = locala.UbS.zi();
          localamn.Lxw = true;
          AppMethodBeat.o(127459);
          return 0;
        case 2: 
          localamn.dRL = locala.UbS.readString();
          localamn.Lxx = true;
          AppMethodBeat.o(127459);
          return 0;
        case 3: 
          localamn.toUser = locala.UbS.readString();
          localamn.Lxy = true;
          AppMethodBeat.o(127459);
          return 0;
        case 4: 
          localamn.Gah = locala.UbS.readString();
          localamn.Lxz = true;
          AppMethodBeat.o(127459);
          return 0;
        case 5: 
          localamn.LxA = locala.UbS.readString();
          localamn.LxB = true;
          AppMethodBeat.o(127459);
          return 0;
        case 6: 
          localamn.createTime = locala.UbS.zl();
          localamn.iXH = true;
          AppMethodBeat.o(127459);
          return 0;
        case 7: 
          localamn.msgId = locala.UbS.readString();
          localamn.LxC = true;
          AppMethodBeat.o(127459);
          return 0;
        case 8: 
          localamn.edD = locala.UbS.readString();
          localamn.LxD = true;
          AppMethodBeat.o(127459);
          return 0;
        case 9: 
          localamn.appId = locala.UbS.readString();
          localamn.LxE = true;
          AppMethodBeat.o(127459);
          return 0;
        case 10: 
          localamn.link = locala.UbS.readString();
          localamn.LxF = true;
          AppMethodBeat.o(127459);
          return 0;
        case 11: 
          localamn.LxG = locala.UbS.readString();
          localamn.LxH = true;
          AppMethodBeat.o(127459);
          return 0;
        }
        localamn.dCl = locala.UbS.readString();
        localamn.LxI = true;
        AppMethodBeat.o(127459);
        return 0;
      }
      AppMethodBeat.o(127459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amn
 * JD-Core Version:    0.7.0.1
 */