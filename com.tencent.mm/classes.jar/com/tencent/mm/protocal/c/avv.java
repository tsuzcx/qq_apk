package com.tencent.mm.protocal.c;

public final class avv
  extends com.tencent.mm.bv.a
{
  public String bHI;
  public int bLz;
  public String bssid;
  public int kmR;
  public String ssid;
  public int trp;
  public String trq;
  
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
      paramVarArgs.gB(4, this.trp);
      if (this.trq != null) {
        paramVarArgs.d(5, this.trq);
      }
      if (this.bHI != null) {
        paramVarArgs.d(6, this.bHI);
      }
      paramVarArgs.gB(7, this.kmR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ssid == null) {
        break label461;
      }
    }
    label461:
    for (paramInt = d.a.a.b.b.a.e(1, this.ssid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bssid != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bssid);
      }
      i = i + d.a.a.a.gy(3, this.bLz) + d.a.a.a.gy(4, this.trp);
      paramInt = i;
      if (this.trq != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.trq);
      }
      i = paramInt;
      if (this.bHI != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.bHI);
      }
      return i + d.a.a.a.gy(7, this.kmR);
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
        avv localavv = (avv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localavv.ssid = locala.xpH.readString();
          return 0;
        case 2: 
          localavv.bssid = locala.xpH.readString();
          return 0;
        case 3: 
          localavv.bLz = locala.xpH.oD();
          return 0;
        case 4: 
          localavv.trp = locala.xpH.oD();
          return 0;
        case 5: 
          localavv.trq = locala.xpH.readString();
          return 0;
        case 6: 
          localavv.bHI = locala.xpH.readString();
          return 0;
        }
        localavv.kmR = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avv
 * JD-Core Version:    0.7.0.1
 */