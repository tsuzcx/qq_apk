package com.tencent.mm.protocal.c;

public final class aoh
  extends com.tencent.mm.bv.a
{
  public String bVO;
  public String tjZ;
  public String tka;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tjZ != null) {
        paramVarArgs.d(1, this.tjZ);
      }
      if (this.tka != null) {
        paramVarArgs.d(2, this.tka);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.bVO != null) {
        paramVarArgs.d(4, this.bVO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tjZ == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.tjZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tka != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tka);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.bVO != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.bVO);
      }
      return paramInt;
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
        aoh localaoh = (aoh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaoh.tjZ = locala.xpH.readString();
          return 0;
        case 2: 
          localaoh.tka = locala.xpH.readString();
          return 0;
        case 3: 
          localaoh.url = locala.xpH.readString();
          return 0;
        }
        localaoh.bVO = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aoh
 * JD-Core Version:    0.7.0.1
 */