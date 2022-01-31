package com.tencent.mm.protocal.c;

public final class avu
  extends com.tencent.mm.bv.a
{
  public int bLz;
  public String bssid;
  public String ssid;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ssid != null) {
        paramVarArgs.d(1, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(2, this.bssid);
      }
      paramVarArgs.gB(3, this.bLz);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ssid == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.ssid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bssid != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bssid);
      }
      return i + d.a.a.a.gy(3, this.bLz);
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
        avu localavu = (avu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localavu.ssid = locala.xpH.readString();
          return 0;
        case 2: 
          localavu.bssid = locala.xpH.readString();
          return 0;
        }
        localavu.bLz = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avu
 * JD-Core Version:    0.7.0.1
 */