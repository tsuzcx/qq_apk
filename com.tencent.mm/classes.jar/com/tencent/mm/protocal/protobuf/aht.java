package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aht
  extends com.tencent.mm.bw.a
{
  public String EBR;
  public boolean EBS = false;
  public boolean EBe = false;
  public boolean EBf = false;
  public boolean EBg = false;
  public String EBj;
  public boolean EBk = false;
  public boolean EBl = false;
  public boolean EBm = false;
  public boolean EBn = false;
  public boolean EBo = false;
  public String EBp;
  public boolean EBq = false;
  public boolean EBr = false;
  public String appId;
  public String cYF;
  public long createTime;
  public String dng;
  public String dtG;
  public String dym;
  public boolean hHh = false;
  public String link;
  public int sourceType;
  public String toUser;
  
  public final aht XV(int paramInt)
  {
    this.sourceType = paramInt;
    this.EBe = true;
    return this;
  }
  
  public final aht aJC(String paramString)
  {
    this.dng = paramString;
    this.EBf = true;
    return this;
  }
  
  public final aht aJD(String paramString)
  {
    this.toUser = paramString;
    this.EBg = true;
    return this;
  }
  
  public final aht aJE(String paramString)
  {
    this.EBR = paramString;
    this.EBS = true;
    return this;
  }
  
  public final aht aJF(String paramString)
  {
    this.EBj = paramString;
    this.EBk = true;
    return this;
  }
  
  public final aht aJG(String paramString)
  {
    this.dtG = paramString;
    this.EBl = true;
    return this;
  }
  
  public final aht aJH(String paramString)
  {
    this.dym = paramString;
    this.EBm = true;
    return this;
  }
  
  public final aht aJI(String paramString)
  {
    this.appId = paramString;
    this.EBn = true;
    return this;
  }
  
  public final aht aJJ(String paramString)
  {
    this.link = paramString;
    this.EBo = true;
    return this;
  }
  
  public final aht aJK(String paramString)
  {
    this.cYF = paramString;
    this.EBr = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (!this.EBe)
      {
        paramVarArgs = new b("Not all required fields were included: sourceType");
        AppMethodBeat.o(127481);
        throw paramVarArgs;
      }
      if (this.EBe == true) {
        paramVarArgs.aR(1, this.sourceType);
      }
      if (this.dng != null) {
        paramVarArgs.d(2, this.dng);
      }
      if (this.toUser != null) {
        paramVarArgs.d(3, this.toUser);
      }
      if (this.EBR != null) {
        paramVarArgs.d(4, this.EBR);
      }
      if (this.EBj != null) {
        paramVarArgs.d(5, this.EBj);
      }
      if (this.hHh == true) {
        paramVarArgs.aO(6, this.createTime);
      }
      if (this.dtG != null) {
        paramVarArgs.d(7, this.dtG);
      }
      if (this.dym != null) {
        paramVarArgs.d(8, this.dym);
      }
      if (this.appId != null) {
        paramVarArgs.d(9, this.appId);
      }
      if (this.link != null) {
        paramVarArgs.d(10, this.link);
      }
      if (this.EBp != null) {
        paramVarArgs.d(11, this.EBp);
      }
      if (this.cYF != null) {
        paramVarArgs.d(12, this.cYF);
      }
      AppMethodBeat.o(127481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EBe != true) {
        break label1014;
      }
    }
    label1014:
    for (int i = f.a.a.b.b.a.bx(1, this.sourceType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dng != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dng);
      }
      i = paramInt;
      if (this.toUser != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.toUser);
      }
      paramInt = i;
      if (this.EBR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EBR);
      }
      i = paramInt;
      if (this.EBj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EBj);
      }
      paramInt = i;
      if (this.hHh == true) {
        paramInt = i + f.a.a.b.b.a.p(6, this.createTime);
      }
      i = paramInt;
      if (this.dtG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dtG);
      }
      paramInt = i;
      if (this.dym != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dym);
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
      if (this.EBp != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.EBp);
      }
      paramInt = i;
      if (this.cYF != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.cYF);
      }
      AppMethodBeat.o(127481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (!this.EBe)
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
        aht localaht = (aht)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127481);
          return -1;
        case 1: 
          localaht.sourceType = locala.LVo.xF();
          localaht.EBe = true;
          AppMethodBeat.o(127481);
          return 0;
        case 2: 
          localaht.dng = locala.LVo.readString();
          localaht.EBf = true;
          AppMethodBeat.o(127481);
          return 0;
        case 3: 
          localaht.toUser = locala.LVo.readString();
          localaht.EBg = true;
          AppMethodBeat.o(127481);
          return 0;
        case 4: 
          localaht.EBR = locala.LVo.readString();
          localaht.EBS = true;
          AppMethodBeat.o(127481);
          return 0;
        case 5: 
          localaht.EBj = locala.LVo.readString();
          localaht.EBk = true;
          AppMethodBeat.o(127481);
          return 0;
        case 6: 
          localaht.createTime = locala.LVo.xG();
          localaht.hHh = true;
          AppMethodBeat.o(127481);
          return 0;
        case 7: 
          localaht.dtG = locala.LVo.readString();
          localaht.EBl = true;
          AppMethodBeat.o(127481);
          return 0;
        case 8: 
          localaht.dym = locala.LVo.readString();
          localaht.EBm = true;
          AppMethodBeat.o(127481);
          return 0;
        case 9: 
          localaht.appId = locala.LVo.readString();
          localaht.EBn = true;
          AppMethodBeat.o(127481);
          return 0;
        case 10: 
          localaht.link = locala.LVo.readString();
          localaht.EBo = true;
          AppMethodBeat.o(127481);
          return 0;
        case 11: 
          localaht.EBp = locala.LVo.readString();
          localaht.EBq = true;
          AppMethodBeat.o(127481);
          return 0;
        }
        localaht.cYF = locala.LVo.readString();
        localaht.EBr = true;
        AppMethodBeat.o(127481);
        return 0;
      }
      AppMethodBeat.o(127481);
      return -1;
    }
  }
  
  public final aht zY(long paramLong)
  {
    this.createTime = paramLong;
    this.hHh = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aht
 * JD-Core Version:    0.7.0.1
 */