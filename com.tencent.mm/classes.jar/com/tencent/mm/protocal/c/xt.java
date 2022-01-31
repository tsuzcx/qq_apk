package com.tencent.mm.protocal.c;

public final class xt
  extends com.tencent.mm.bv.a
{
  public String appId;
  public String bFw;
  public int bOa;
  public String iconUrl;
  public String sUv;
  public int type;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.appId != null) {
        paramVarArgs.d(2, this.appId);
      }
      paramVarArgs.gB(3, this.bOa);
      if (this.iconUrl != null) {
        paramVarArgs.d(4, this.iconUrl);
      }
      paramVarArgs.gB(5, this.type);
      if (this.bFw != null) {
        paramVarArgs.d(6, this.bFw);
      }
      if (this.sUv != null) {
        paramVarArgs.d(7, this.sUv);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label481;
      }
    }
    label481:
    for (paramInt = d.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appId != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.appId);
      }
      i += d.a.a.a.gy(3, this.bOa);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.iconUrl);
      }
      i = paramInt + d.a.a.a.gy(5, this.type);
      paramInt = i;
      if (this.bFw != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.bFw);
      }
      i = paramInt;
      if (this.sUv != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sUv);
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
        xt localxt = (xt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localxt.username = locala.xpH.readString();
          return 0;
        case 2: 
          localxt.appId = locala.xpH.readString();
          return 0;
        case 3: 
          localxt.bOa = locala.xpH.oD();
          return 0;
        case 4: 
          localxt.iconUrl = locala.xpH.readString();
          return 0;
        case 5: 
          localxt.type = locala.xpH.oD();
          return 0;
        case 6: 
          localxt.bFw = locala.xpH.readString();
          return 0;
        }
        localxt.sUv = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xt
 * JD-Core Version:    0.7.0.1
 */