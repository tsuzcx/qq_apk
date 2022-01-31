package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ee
  extends com.tencent.mm.bv.a
{
  public ef sxH;
  public eg sxN;
  public com.tencent.mm.bv.b sxO;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sxN == null) {
        throw new d.a.a.b("Not all required fields were included: VoiceAttr");
      }
      if (this.sxH == null) {
        throw new d.a.a.b("Not all required fields were included: UploadCtx");
      }
      if (this.sxO == null) {
        throw new d.a.a.b("Not all required fields were included: VoiceData");
      }
      if (this.sxN != null)
      {
        paramVarArgs.gD(1, this.sxN.btq());
        this.sxN.a(paramVarArgs);
      }
      if (this.sxH != null)
      {
        paramVarArgs.gD(2, this.sxH.btq());
        this.sxH.a(paramVarArgs);
      }
      if (this.sxO != null) {
        paramVarArgs.b(3, this.sxO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sxN == null) {
        break label574;
      }
    }
    label574:
    for (int i = d.a.a.a.gA(1, this.sxN.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sxH != null) {
        paramInt = i + d.a.a.a.gA(2, this.sxH.btq());
      }
      i = paramInt;
      if (this.sxO != null) {
        i = paramInt + d.a.a.a.a(3, this.sxO);
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
        if (this.sxN == null) {
          throw new d.a.a.b("Not all required fields were included: VoiceAttr");
        }
        if (this.sxH == null) {
          throw new d.a.a.b("Not all required fields were included: UploadCtx");
        }
        if (this.sxO != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: VoiceData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ee localee = (ee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localee.sxN = ((eg)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ef();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ef)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localee.sxH = ((ef)localObject1);
            paramInt += 1;
          }
        }
        localee.sxO = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ee
 * JD-Core Version:    0.7.0.1
 */