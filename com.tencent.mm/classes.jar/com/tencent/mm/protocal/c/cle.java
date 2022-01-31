package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cle
  extends com.tencent.mm.bv.a
{
  public String sYw;
  public String sYy;
  public cld tYo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sYw == null) {
        throw new b("Not all required fields were included: Rid");
      }
      if (this.sYy == null) {
        throw new b("Not all required fields were included: MimeType");
      }
      if (this.tYo == null) {
        throw new b("Not all required fields were included: DownloadInfo");
      }
      if (this.sYw != null) {
        paramVarArgs.d(1, this.sYw);
      }
      if (this.sYy != null) {
        paramVarArgs.d(2, this.sYy);
      }
      if (this.tYo != null)
      {
        paramVarArgs.gD(3, this.tYo.btq());
        this.tYo.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sYw == null) {
        break label483;
      }
    }
    label483:
    for (int i = d.a.a.b.b.a.e(1, this.sYw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sYy != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sYy);
      }
      i = paramInt;
      if (this.tYo != null) {
        i = paramInt + d.a.a.a.gA(3, this.tYo.btq());
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
        if (this.sYw == null) {
          throw new b("Not all required fields were included: Rid");
        }
        if (this.sYy == null) {
          throw new b("Not all required fields were included: MimeType");
        }
        if (this.tYo != null) {
          break;
        }
        throw new b("Not all required fields were included: DownloadInfo");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cle localcle = (cle)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localcle.sYw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localcle.sYy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cld();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cld)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcle.tYo = ((cld)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cle
 * JD-Core Version:    0.7.0.1
 */