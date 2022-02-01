package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alc
  extends com.tencent.mm.bw.a
{
  public boolean GAF = false;
  public String GCG;
  public boolean GCH = false;
  public int GCI;
  public boolean GCJ = false;
  public boolean GCK = false;
  public String GCL;
  public boolean GCN = false;
  public boolean GCb = false;
  public boolean Gzt = false;
  public boolean Gzu = false;
  public String canvasPageXml;
  public String desc;
  public int hCH;
  public String thumbUrl;
  public String title;
  
  public final alc aQP(String paramString)
  {
    this.title = paramString;
    this.Gzt = true;
    return this;
  }
  
  public final alc aQQ(String paramString)
  {
    this.desc = paramString;
    this.Gzu = true;
    return this;
  }
  
  public final alc aQR(String paramString)
  {
    this.GCG = paramString;
    this.GCH = true;
    return this;
  }
  
  public final alc aQS(String paramString)
  {
    this.thumbUrl = paramString;
    this.GCb = true;
    return this;
  }
  
  public final alc aQT(String paramString)
  {
    this.canvasPageXml = paramString;
    this.GAF = true;
    return this;
  }
  
  public final alc aQU(String paramString)
  {
    this.GCL = paramString;
    this.GCN = true;
    return this;
  }
  
  public final alc aay(int paramInt)
  {
    this.GCI = paramInt;
    this.GCJ = true;
    return this;
  }
  
  public final alc aaz(int paramInt)
  {
    this.hCH = paramInt;
    this.GCK = true;
    return this;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127493);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.GCG != null) {
        paramVarArgs.d(3, this.GCG);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.d(4, this.thumbUrl);
      }
      if (this.GCJ == true) {
        paramVarArgs.aS(5, this.GCI);
      }
      if (this.GCK == true) {
        paramVarArgs.aS(6, this.hCH);
      }
      if (this.canvasPageXml != null) {
        paramVarArgs.d(7, this.canvasPageXml);
      }
      if (this.GCL != null) {
        paramVarArgs.d(8, this.GCL);
      }
      AppMethodBeat.o(127493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.GCG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GCG);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.GCJ == true) {
        i = paramInt + f.a.a.b.b.a.bz(5, this.GCI);
      }
      paramInt = i;
      if (this.GCK == true) {
        paramInt = i + f.a.a.b.b.a.bz(6, this.hCH);
      }
      i = paramInt;
      if (this.canvasPageXml != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.canvasPageXml);
      }
      paramInt = i;
      if (this.GCL != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GCL);
      }
      AppMethodBeat.o(127493);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127493);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        alc localalc = (alc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127493);
          return -1;
        case 1: 
          localalc.title = locala.OmT.readString();
          localalc.Gzt = true;
          AppMethodBeat.o(127493);
          return 0;
        case 2: 
          localalc.desc = locala.OmT.readString();
          localalc.Gzu = true;
          AppMethodBeat.o(127493);
          return 0;
        case 3: 
          localalc.GCG = locala.OmT.readString();
          localalc.GCH = true;
          AppMethodBeat.o(127493);
          return 0;
        case 4: 
          localalc.thumbUrl = locala.OmT.readString();
          localalc.GCb = true;
          AppMethodBeat.o(127493);
          return 0;
        case 5: 
          localalc.GCI = locala.OmT.zc();
          localalc.GCJ = true;
          AppMethodBeat.o(127493);
          return 0;
        case 6: 
          localalc.hCH = locala.OmT.zc();
          localalc.GCK = true;
          AppMethodBeat.o(127493);
          return 0;
        case 7: 
          localalc.canvasPageXml = locala.OmT.readString();
          localalc.GAF = true;
          AppMethodBeat.o(127493);
          return 0;
        }
        localalc.GCL = locala.OmT.readString();
        localalc.GCN = true;
        AppMethodBeat.o(127493);
        return 0;
      }
      AppMethodBeat.o(127493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alc
 * JD-Core Version:    0.7.0.1
 */