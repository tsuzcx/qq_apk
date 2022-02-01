package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aks
  extends com.tencent.mm.bx.a
{
  public boolean GgK = false;
  public boolean GgL = false;
  public boolean GhW = false;
  public String GjX;
  public boolean GjY = false;
  public int GjZ;
  public boolean Gjs = false;
  public boolean Gka = false;
  public boolean Gkb = false;
  public String Gkc;
  public boolean Gkd = false;
  public String canvasPageXml;
  public String desc;
  public int hzT;
  public String thumbUrl;
  public String title;
  
  public final aks ZS(int paramInt)
  {
    this.GjZ = paramInt;
    this.Gka = true;
    return this;
  }
  
  public final aks ZT(int paramInt)
  {
    this.hzT = paramInt;
    this.Gkb = true;
    return this;
  }
  
  public final aks aPs(String paramString)
  {
    this.title = paramString;
    this.GgK = true;
    return this;
  }
  
  public final aks aPt(String paramString)
  {
    this.desc = paramString;
    this.GgL = true;
    return this;
  }
  
  public final aks aPu(String paramString)
  {
    this.GjX = paramString;
    this.GjY = true;
    return this;
  }
  
  public final aks aPv(String paramString)
  {
    this.thumbUrl = paramString;
    this.Gjs = true;
    return this;
  }
  
  public final aks aPw(String paramString)
  {
    this.canvasPageXml = paramString;
    this.GhW = true;
    return this;
  }
  
  public final aks aPx(String paramString)
  {
    this.Gkc = paramString;
    this.Gkd = true;
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
      if (this.GjX != null) {
        paramVarArgs.d(3, this.GjX);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.d(4, this.thumbUrl);
      }
      if (this.Gka == true) {
        paramVarArgs.aS(5, this.GjZ);
      }
      if (this.Gkb == true) {
        paramVarArgs.aS(6, this.hzT);
      }
      if (this.canvasPageXml != null) {
        paramVarArgs.d(7, this.canvasPageXml);
      }
      if (this.Gkc != null) {
        paramVarArgs.d(8, this.Gkc);
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
      if (this.GjX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GjX);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.Gka == true) {
        i = paramInt + f.a.a.b.b.a.bz(5, this.GjZ);
      }
      paramInt = i;
      if (this.Gkb == true) {
        paramInt = i + f.a.a.b.b.a.bz(6, this.hzT);
      }
      i = paramInt;
      if (this.canvasPageXml != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.canvasPageXml);
      }
      paramInt = i;
      if (this.Gkc != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gkc);
      }
      AppMethodBeat.o(127493);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127493);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aks localaks = (aks)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127493);
          return -1;
        case 1: 
          localaks.title = locala.NPN.readString();
          localaks.GgK = true;
          AppMethodBeat.o(127493);
          return 0;
        case 2: 
          localaks.desc = locala.NPN.readString();
          localaks.GgL = true;
          AppMethodBeat.o(127493);
          return 0;
        case 3: 
          localaks.GjX = locala.NPN.readString();
          localaks.GjY = true;
          AppMethodBeat.o(127493);
          return 0;
        case 4: 
          localaks.thumbUrl = locala.NPN.readString();
          localaks.Gjs = true;
          AppMethodBeat.o(127493);
          return 0;
        case 5: 
          localaks.GjZ = locala.NPN.zc();
          localaks.Gka = true;
          AppMethodBeat.o(127493);
          return 0;
        case 6: 
          localaks.hzT = locala.NPN.zc();
          localaks.Gkb = true;
          AppMethodBeat.o(127493);
          return 0;
        case 7: 
          localaks.canvasPageXml = locala.NPN.readString();
          localaks.GhW = true;
          AppMethodBeat.o(127493);
          return 0;
        }
        localaks.Gkc = locala.NPN.readString();
        localaks.Gkd = true;
        AppMethodBeat.o(127493);
        return 0;
      }
      AppMethodBeat.o(127493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aks
 * JD-Core Version:    0.7.0.1
 */