package com.tencent.mm.protocal.c;

public final class bpy
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b tHy;
  public com.tencent.mm.bv.b tov;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tHy == null) {
        throw new d.a.a.b("Not all required fields were included: Name");
      }
      if (this.tov == null) {
        throw new d.a.a.b("Not all required fields were included: Value");
      }
      if (this.tHy != null) {
        paramVarArgs.b(1, this.tHy);
      }
      if (this.tov != null) {
        paramVarArgs.b(2, this.tov);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tHy == null) {
        break label296;
      }
    }
    label296:
    for (paramInt = d.a.a.a.a(1, this.tHy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tov != null) {
        i = paramInt + d.a.a.a.a(2, this.tov);
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
        if (this.tHy == null) {
          throw new d.a.a.b("Not all required fields were included: Name");
        }
        if (this.tov != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: Value");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bpy localbpy = (bpy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbpy.tHy = locala.cUs();
          return 0;
        }
        localbpy.tov = locala.cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bpy
 * JD-Core Version:    0.7.0.1
 */