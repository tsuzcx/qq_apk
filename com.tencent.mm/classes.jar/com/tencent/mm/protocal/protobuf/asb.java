package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class asb
  extends com.tencent.mm.bx.a
{
  public boolean ZAP = false;
  public boolean ZAQ = false;
  public boolean ZAR = false;
  public String ZAT;
  public boolean ZAU = false;
  public boolean ZAV = false;
  public boolean ZAW = false;
  public boolean ZAX = false;
  public boolean ZAY = false;
  public String ZAZ;
  public String ZBB;
  public boolean ZBC = false;
  public boolean ZBa = false;
  public boolean ZBb = false;
  public String appId;
  public long createTime;
  public String eventId;
  public String hQQ;
  public String hzi;
  public String link;
  public String msgId;
  public boolean oGL = false;
  public int sourceType;
  public String toUser;
  
  public final asb axH(int paramInt)
  {
    this.sourceType = paramInt;
    this.ZAP = true;
    return this;
  }
  
  public final asb bto(String paramString)
  {
    this.hQQ = paramString;
    this.ZAQ = true;
    return this;
  }
  
  public final asb btp(String paramString)
  {
    this.toUser = paramString;
    this.ZAR = true;
    return this;
  }
  
  public final asb btq(String paramString)
  {
    this.ZBB = paramString;
    this.ZBC = true;
    return this;
  }
  
  public final asb btr(String paramString)
  {
    this.ZAT = paramString;
    this.ZAU = true;
    return this;
  }
  
  public final asb bts(String paramString)
  {
    this.msgId = paramString;
    this.ZAV = true;
    return this;
  }
  
  public final asb btt(String paramString)
  {
    this.eventId = paramString;
    this.ZAW = true;
    return this;
  }
  
  public final asb btu(String paramString)
  {
    this.appId = paramString;
    this.ZAX = true;
    return this;
  }
  
  public final asb btv(String paramString)
  {
    this.link = paramString;
    this.ZAY = true;
    return this;
  }
  
  public final asb btw(String paramString)
  {
    this.hzi = paramString;
    this.ZBb = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127481);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (!this.ZAP)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(127481);
        throw paramVarArgs;
      }
      if (this.ZAP == true) {
        paramVarArgs.bS(1, this.sourceType);
      }
      if (this.hQQ != null) {
        paramVarArgs.g(2, this.hQQ);
      }
      if (this.toUser != null) {
        paramVarArgs.g(3, this.toUser);
      }
      if (this.ZBB != null) {
        paramVarArgs.g(4, this.ZBB);
      }
      if (this.ZAT != null) {
        paramVarArgs.g(5, this.ZAT);
      }
      if (this.oGL == true) {
        paramVarArgs.bv(6, this.createTime);
      }
      if (this.msgId != null) {
        paramVarArgs.g(7, this.msgId);
      }
      if (this.eventId != null) {
        paramVarArgs.g(8, this.eventId);
      }
      if (this.appId != null) {
        paramVarArgs.g(9, this.appId);
      }
      if (this.link != null) {
        paramVarArgs.g(10, this.link);
      }
      if (this.ZAZ != null) {
        paramVarArgs.g(11, this.ZAZ);
      }
      if (this.hzi != null) {
        paramVarArgs.g(12, this.hzi);
      }
      AppMethodBeat.o(127481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZAP != true) {
        break label1010;
      }
    }
    label1010:
    for (int i = i.a.a.b.b.a.cJ(1, this.sourceType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hQQ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hQQ);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.toUser);
      }
      paramInt = i;
      if (this.ZBB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZBB);
      }
      i = paramInt;
      if (this.ZAT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZAT);
      }
      paramInt = i;
      if (this.oGL == true) {
        paramInt = i + i.a.a.b.b.a.q(6, this.createTime);
      }
      i = paramInt;
      if (this.msgId != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.msgId);
      }
      paramInt = i;
      if (this.eventId != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.eventId);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.appId);
      }
      paramInt = i;
      if (this.link != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.link);
      }
      i = paramInt;
      if (this.ZAZ != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ZAZ);
      }
      paramInt = i;
      if (this.hzi != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.hzi);
      }
      AppMethodBeat.o(127481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (!this.ZAP)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        asb localasb = (asb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127481);
          return -1;
        case 1: 
          localasb.sourceType = locala.ajGk.aar();
          localasb.ZAP = true;
          AppMethodBeat.o(127481);
          return 0;
        case 2: 
          localasb.hQQ = locala.ajGk.readString();
          localasb.ZAQ = true;
          AppMethodBeat.o(127481);
          return 0;
        case 3: 
          localasb.toUser = locala.ajGk.readString();
          localasb.ZAR = true;
          AppMethodBeat.o(127481);
          return 0;
        case 4: 
          localasb.ZBB = locala.ajGk.readString();
          localasb.ZBC = true;
          AppMethodBeat.o(127481);
          return 0;
        case 5: 
          localasb.ZAT = locala.ajGk.readString();
          localasb.ZAU = true;
          AppMethodBeat.o(127481);
          return 0;
        case 6: 
          localasb.createTime = locala.ajGk.aaw();
          localasb.oGL = true;
          AppMethodBeat.o(127481);
          return 0;
        case 7: 
          localasb.msgId = locala.ajGk.readString();
          localasb.ZAV = true;
          AppMethodBeat.o(127481);
          return 0;
        case 8: 
          localasb.eventId = locala.ajGk.readString();
          localasb.ZAW = true;
          AppMethodBeat.o(127481);
          return 0;
        case 9: 
          localasb.appId = locala.ajGk.readString();
          localasb.ZAX = true;
          AppMethodBeat.o(127481);
          return 0;
        case 10: 
          localasb.link = locala.ajGk.readString();
          localasb.ZAY = true;
          AppMethodBeat.o(127481);
          return 0;
        case 11: 
          localasb.ZAZ = locala.ajGk.readString();
          localasb.ZBa = true;
          AppMethodBeat.o(127481);
          return 0;
        }
        localasb.hzi = locala.ajGk.readString();
        localasb.ZBb = true;
        AppMethodBeat.o(127481);
        return 0;
      }
      AppMethodBeat.o(127481);
      return -1;
    }
  }
  
  public final asb yu(long paramLong)
  {
    this.createTime = paramLong;
    this.oGL = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asb
 * JD-Core Version:    0.7.0.1
 */