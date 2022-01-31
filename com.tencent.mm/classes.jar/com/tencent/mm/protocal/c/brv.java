package com.tencent.mm.protocal.c;

public final class brv
  extends com.tencent.mm.bv.a
{
  public String content;
  public int state;
  public String tIo;
  public String tIp;
  public String tIq;
  public String tIr;
  public int tIs;
  public String tIt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.tIo != null) {
        paramVarArgs.d(2, this.tIo);
      }
      if (this.tIp != null) {
        paramVarArgs.d(3, this.tIp);
      }
      if (this.tIq != null) {
        paramVarArgs.d(4, this.tIq);
      }
      if (this.tIr != null) {
        paramVarArgs.d(5, this.tIr);
      }
      paramVarArgs.gB(6, this.tIs);
      paramVarArgs.gB(7, this.state);
      if (this.tIt != null) {
        paramVarArgs.d(8, this.tIt);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label536;
      }
    }
    label536:
    for (int i = d.a.a.b.b.a.e(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tIo != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tIo);
      }
      i = paramInt;
      if (this.tIp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tIp);
      }
      paramInt = i;
      if (this.tIq != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tIq);
      }
      i = paramInt;
      if (this.tIr != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tIr);
      }
      i = i + d.a.a.a.gy(6, this.tIs) + d.a.a.a.gy(7, this.state);
      paramInt = i;
      if (this.tIt != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tIt);
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
        brv localbrv = (brv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbrv.content = locala.xpH.readString();
          return 0;
        case 2: 
          localbrv.tIo = locala.xpH.readString();
          return 0;
        case 3: 
          localbrv.tIp = locala.xpH.readString();
          return 0;
        case 4: 
          localbrv.tIq = locala.xpH.readString();
          return 0;
        case 5: 
          localbrv.tIr = locala.xpH.readString();
          return 0;
        case 6: 
          localbrv.tIs = locala.xpH.oD();
          return 0;
        case 7: 
          localbrv.state = locala.xpH.oD();
          return 0;
        }
        localbrv.tIt = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.brv
 * JD-Core Version:    0.7.0.1
 */