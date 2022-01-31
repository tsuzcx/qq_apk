package com.tencent.mm.protocal.c;

public final class ckp
  extends com.tencent.mm.bv.a
{
  public String hRf;
  public com.tencent.mm.bv.b tXh;
  public String tXp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXp == null) {
        throw new d.a.a.b("Not all required fields were included: Talker");
      }
      if (this.hRf == null) {
        throw new d.a.a.b("Not all required fields were included: NickName");
      }
      if (this.tXp != null) {
        paramVarArgs.d(1, this.tXp);
      }
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      if (this.tXh != null) {
        paramVarArgs.b(3, this.tXh);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tXp == null) {
        break label354;
      }
    }
    label354:
    for (int i = d.a.a.b.b.a.e(1, this.tXp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hRf);
      }
      i = paramInt;
      if (this.tXh != null) {
        i = paramInt + d.a.a.a.a(3, this.tXh);
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
        if (this.tXp == null) {
          throw new d.a.a.b("Not all required fields were included: Talker");
        }
        if (this.hRf != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: NickName");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ckp localckp = (ckp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localckp.tXp = locala.xpH.readString();
          return 0;
        case 2: 
          localckp.hRf = locala.xpH.readString();
          return 0;
        }
        localckp.tXh = locala.cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckp
 * JD-Core Version:    0.7.0.1
 */