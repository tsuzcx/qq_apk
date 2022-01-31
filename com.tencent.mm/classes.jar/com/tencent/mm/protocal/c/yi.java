package com.tencent.mm.protocal.c;

public final class yi
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String info;
  public boolean sUA = false;
  public boolean sUz = false;
  public boolean sWX = false;
  public boolean sWY = false;
  public boolean sWZ = false;
  public String thumbUrl;
  public String title;
  public int type;
  
  public final yi EN(int paramInt)
  {
    this.type = paramInt;
    this.sWZ = true;
    return this;
  }
  
  public final yi Yj(String paramString)
  {
    this.title = paramString;
    this.sUz = true;
    return this;
  }
  
  public final yi Yk(String paramString)
  {
    this.desc = paramString;
    this.sUA = true;
    return this;
  }
  
  public final yi Yl(String paramString)
  {
    this.thumbUrl = paramString;
    this.sWX = true;
    return this;
  }
  
  public final yi Ym(String paramString)
  {
    this.info = paramString;
    this.sWY = true;
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
      if (this.thumbUrl != null) {
        paramVarArgs.d(3, this.thumbUrl);
      }
      if (this.info != null) {
        paramVarArgs.d(4, this.info);
      }
      if (this.sWZ == true) {
        paramVarArgs.gB(5, this.type);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label429;
      }
    }
    label429:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.thumbUrl);
      }
      paramInt = i;
      if (this.info != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.info);
      }
      i = paramInt;
      if (this.sWZ == true) {
        i = paramInt + d.a.a.a.gy(5, this.type);
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
        yi localyi = (yi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localyi.title = locala.xpH.readString();
          localyi.sUz = true;
          return 0;
        case 2: 
          localyi.desc = locala.xpH.readString();
          localyi.sUA = true;
          return 0;
        case 3: 
          localyi.thumbUrl = locala.xpH.readString();
          localyi.sWX = true;
          return 0;
        case 4: 
          localyi.info = locala.xpH.readString();
          localyi.sWY = true;
          return 0;
        }
        localyi.type = locala.xpH.oD();
        localyi.sWZ = true;
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.yi
 * JD-Core Version:    0.7.0.1
 */