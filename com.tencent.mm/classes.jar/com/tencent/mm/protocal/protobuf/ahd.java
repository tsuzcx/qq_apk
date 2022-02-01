package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahd
  extends com.tencent.mm.bx.a
{
  public boolean DfS = false;
  public boolean DfT = false;
  public boolean Dhe = false;
  public boolean DiA = false;
  public String Djf;
  public boolean Djg = false;
  public int Djh;
  public boolean Dji = false;
  public boolean Djj = false;
  public String Djk;
  public boolean Djl = false;
  public String canvasPageXml;
  public String desc;
  public int gHj;
  public String thumbUrl;
  public String title;
  
  public final ahd VN(int paramInt)
  {
    this.Djh = paramInt;
    this.Dji = true;
    return this;
  }
  
  public final ahd VO(int paramInt)
  {
    this.gHj = paramInt;
    this.Djj = true;
    return this;
  }
  
  public final ahd aEA(String paramString)
  {
    this.Djf = paramString;
    this.Djg = true;
    return this;
  }
  
  public final ahd aEB(String paramString)
  {
    this.thumbUrl = paramString;
    this.DiA = true;
    return this;
  }
  
  public final ahd aEC(String paramString)
  {
    this.canvasPageXml = paramString;
    this.Dhe = true;
    return this;
  }
  
  public final ahd aED(String paramString)
  {
    this.Djk = paramString;
    this.Djl = true;
    return this;
  }
  
  public final ahd aEy(String paramString)
  {
    this.title = paramString;
    this.DfS = true;
    return this;
  }
  
  public final ahd aEz(String paramString)
  {
    this.desc = paramString;
    this.DfT = true;
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
      if (this.Djf != null) {
        paramVarArgs.d(3, this.Djf);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.d(4, this.thumbUrl);
      }
      if (this.Dji == true) {
        paramVarArgs.aR(5, this.Djh);
      }
      if (this.Djj == true) {
        paramVarArgs.aR(6, this.gHj);
      }
      if (this.canvasPageXml != null) {
        paramVarArgs.d(7, this.canvasPageXml);
      }
      if (this.Djk != null) {
        paramVarArgs.d(8, this.Djk);
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
      if (this.Djf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Djf);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.Dji == true) {
        i = paramInt + f.a.a.b.b.a.bA(5, this.Djh);
      }
      paramInt = i;
      if (this.Djj == true) {
        paramInt = i + f.a.a.b.b.a.bA(6, this.gHj);
      }
      i = paramInt;
      if (this.canvasPageXml != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.canvasPageXml);
      }
      paramInt = i;
      if (this.Djk != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Djk);
      }
      AppMethodBeat.o(127493);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127493);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ahd localahd = (ahd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127493);
          return -1;
        case 1: 
          localahd.title = locala.KhF.readString();
          localahd.DfS = true;
          AppMethodBeat.o(127493);
          return 0;
        case 2: 
          localahd.desc = locala.KhF.readString();
          localahd.DfT = true;
          AppMethodBeat.o(127493);
          return 0;
        case 3: 
          localahd.Djf = locala.KhF.readString();
          localahd.Djg = true;
          AppMethodBeat.o(127493);
          return 0;
        case 4: 
          localahd.thumbUrl = locala.KhF.readString();
          localahd.DiA = true;
          AppMethodBeat.o(127493);
          return 0;
        case 5: 
          localahd.Djh = locala.KhF.xS();
          localahd.Dji = true;
          AppMethodBeat.o(127493);
          return 0;
        case 6: 
          localahd.gHj = locala.KhF.xS();
          localahd.Djj = true;
          AppMethodBeat.o(127493);
          return 0;
        case 7: 
          localahd.canvasPageXml = locala.KhF.readString();
          localahd.Dhe = true;
          AppMethodBeat.o(127493);
          return 0;
        }
        localahd.Djk = locala.KhF.readString();
        localahd.Djl = true;
        AppMethodBeat.o(127493);
        return 0;
      }
      AppMethodBeat.o(127493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahd
 * JD-Core Version:    0.7.0.1
 */