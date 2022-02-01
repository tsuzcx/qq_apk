package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aic
  extends com.tencent.mm.bw.a
{
  public boolean EAk = false;
  public boolean EBG = false;
  public String ECl;
  public boolean ECm = false;
  public int ECn;
  public boolean ECo = false;
  public boolean ECp = false;
  public String ECq;
  public boolean ECr = false;
  public boolean EyY = false;
  public boolean EyZ = false;
  public String canvasPageXml;
  public String desc;
  public int hhK;
  public String thumbUrl;
  public String title;
  
  public final aic XW(int paramInt)
  {
    this.ECn = paramInt;
    this.ECo = true;
    return this;
  }
  
  public final aic XX(int paramInt)
  {
    this.hhK = paramInt;
    this.ECp = true;
    return this;
  }
  
  public final aic aJP(String paramString)
  {
    this.title = paramString;
    this.EyY = true;
    return this;
  }
  
  public final aic aJQ(String paramString)
  {
    this.desc = paramString;
    this.EyZ = true;
    return this;
  }
  
  public final aic aJR(String paramString)
  {
    this.ECl = paramString;
    this.ECm = true;
    return this;
  }
  
  public final aic aJS(String paramString)
  {
    this.thumbUrl = paramString;
    this.EBG = true;
    return this;
  }
  
  public final aic aJT(String paramString)
  {
    this.canvasPageXml = paramString;
    this.EAk = true;
    return this;
  }
  
  public final aic aJU(String paramString)
  {
    this.ECq = paramString;
    this.ECr = true;
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
      if (this.ECl != null) {
        paramVarArgs.d(3, this.ECl);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.d(4, this.thumbUrl);
      }
      if (this.ECo == true) {
        paramVarArgs.aR(5, this.ECn);
      }
      if (this.ECp == true) {
        paramVarArgs.aR(6, this.hhK);
      }
      if (this.canvasPageXml != null) {
        paramVarArgs.d(7, this.canvasPageXml);
      }
      if (this.ECq != null) {
        paramVarArgs.d(8, this.ECq);
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
      if (this.ECl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ECl);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.ECo == true) {
        i = paramInt + f.a.a.b.b.a.bx(5, this.ECn);
      }
      paramInt = i;
      if (this.ECp == true) {
        paramInt = i + f.a.a.b.b.a.bx(6, this.hhK);
      }
      i = paramInt;
      if (this.canvasPageXml != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.canvasPageXml);
      }
      paramInt = i;
      if (this.ECq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ECq);
      }
      AppMethodBeat.o(127493);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127493);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aic localaic = (aic)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127493);
          return -1;
        case 1: 
          localaic.title = locala.LVo.readString();
          localaic.EyY = true;
          AppMethodBeat.o(127493);
          return 0;
        case 2: 
          localaic.desc = locala.LVo.readString();
          localaic.EyZ = true;
          AppMethodBeat.o(127493);
          return 0;
        case 3: 
          localaic.ECl = locala.LVo.readString();
          localaic.ECm = true;
          AppMethodBeat.o(127493);
          return 0;
        case 4: 
          localaic.thumbUrl = locala.LVo.readString();
          localaic.EBG = true;
          AppMethodBeat.o(127493);
          return 0;
        case 5: 
          localaic.ECn = locala.LVo.xF();
          localaic.ECo = true;
          AppMethodBeat.o(127493);
          return 0;
        case 6: 
          localaic.hhK = locala.LVo.xF();
          localaic.ECp = true;
          AppMethodBeat.o(127493);
          return 0;
        case 7: 
          localaic.canvasPageXml = locala.LVo.readString();
          localaic.EAk = true;
          AppMethodBeat.o(127493);
          return 0;
        }
        localaic.ECq = locala.LVo.readString();
        localaic.ECr = true;
        AppMethodBeat.o(127493);
        return 0;
      }
      AppMethodBeat.o(127493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aic
 * JD-Core Version:    0.7.0.1
 */