package com.tencent.mm.protocal.c;

public final class yy
  extends com.tencent.mm.bv.a
{
  public String canvasPageXml;
  public int dQA;
  public String desc;
  public boolean sUA = false;
  public boolean sUz = false;
  public boolean sVL = false;
  public boolean sWX = false;
  public String sXG;
  public boolean sXH = false;
  public int sXI;
  public boolean sXJ = false;
  public boolean sXK = false;
  public String thumbUrl;
  public String title;
  
  public final yy ER(int paramInt)
  {
    this.sXI = paramInt;
    this.sXJ = true;
    return this;
  }
  
  public final yy ES(int paramInt)
  {
    this.dQA = paramInt;
    this.sXK = true;
    return this;
  }
  
  public final yy YD(String paramString)
  {
    this.title = paramString;
    this.sUz = true;
    return this;
  }
  
  public final yy YE(String paramString)
  {
    this.desc = paramString;
    this.sUA = true;
    return this;
  }
  
  public final yy YF(String paramString)
  {
    this.sXG = paramString;
    this.sXH = true;
    return this;
  }
  
  public final yy YG(String paramString)
  {
    this.thumbUrl = paramString;
    this.sWX = true;
    return this;
  }
  
  public final yy YH(String paramString)
  {
    this.canvasPageXml = paramString;
    this.sVL = true;
    return this;
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.sXG != null) {
        paramVarArgs.d(3, this.sXG);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.d(4, this.thumbUrl);
      }
      if (this.sXJ == true) {
        paramVarArgs.gB(5, this.sXI);
      }
      if (this.sXK == true) {
        paramVarArgs.gB(6, this.dQA);
      }
      if (this.canvasPageXml != null) {
        paramVarArgs.d(7, this.canvasPageXml);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label559;
      }
    }
    label559:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.sXG != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sXG);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.sXJ == true) {
        i = paramInt + d.a.a.a.gy(5, this.sXI);
      }
      paramInt = i;
      if (this.sXK == true) {
        paramInt = i + d.a.a.a.gy(6, this.dQA);
      }
      i = paramInt;
      if (this.canvasPageXml != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.canvasPageXml);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        yy localyy = (yy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localyy.title = locala.xpH.readString();
          localyy.sUz = true;
          return 0;
        case 2: 
          localyy.desc = locala.xpH.readString();
          localyy.sUA = true;
          return 0;
        case 3: 
          localyy.sXG = locala.xpH.readString();
          localyy.sXH = true;
          return 0;
        case 4: 
          localyy.thumbUrl = locala.xpH.readString();
          localyy.sWX = true;
          return 0;
        case 5: 
          localyy.sXI = locala.xpH.oD();
          localyy.sXJ = true;
          return 0;
        case 6: 
          localyy.dQA = locala.xpH.oD();
          localyy.sXK = true;
          return 0;
        }
        localyy.canvasPageXml = locala.xpH.readString();
        localyy.sVL = true;
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.yy
 * JD-Core Version:    0.7.0.1
 */