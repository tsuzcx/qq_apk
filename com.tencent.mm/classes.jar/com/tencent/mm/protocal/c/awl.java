package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class awl
  extends com.tencent.mm.bv.a
{
  public String bQZ;
  public String ttb;
  public String ttc;
  public String ttd;
  public int tte;
  public int type;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bQZ == null) {
        throw new b("Not all required fields were included: wording");
      }
      paramVarArgs.gB(1, this.type);
      if (this.bQZ != null) {
        paramVarArgs.d(2, this.bQZ);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.ttb != null) {
        paramVarArgs.d(4, this.ttb);
      }
      if (this.ttc != null) {
        paramVarArgs.d(5, this.ttc);
      }
      if (this.ttd != null) {
        paramVarArgs.d(6, this.ttd);
      }
      paramVarArgs.gB(7, this.tte);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.type) + 0;
      paramInt = i;
      if (this.bQZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bQZ);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.ttb != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ttb);
      }
      i = paramInt;
      if (this.ttc != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.ttc);
      }
      paramInt = i;
      if (this.ttd != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.ttd);
      }
      return paramInt + d.a.a.a.gy(7, this.tte);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.bQZ == null) {
        throw new b("Not all required fields were included: wording");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      awl localawl = (awl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localawl.type = locala.xpH.oD();
        return 0;
      case 2: 
        localawl.bQZ = locala.xpH.readString();
        return 0;
      case 3: 
        localawl.url = locala.xpH.readString();
        return 0;
      case 4: 
        localawl.ttb = locala.xpH.readString();
        return 0;
      case 5: 
        localawl.ttc = locala.xpH.readString();
        return 0;
      case 6: 
        localawl.ttd = locala.xpH.readString();
        return 0;
      }
      localawl.tte = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awl
 * JD-Core Version:    0.7.0.1
 */