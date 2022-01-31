package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cam
  extends bly
{
  public int tcc;
  public int tcd;
  public int tce;
  public int tcf;
  public String tcg;
  public int tch;
  public String tts;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.tts != null) {
        paramVarArgs.d(2, this.tts);
      }
      if (this.tcg != null) {
        paramVarArgs.d(3, this.tcg);
      }
      paramVarArgs.gB(4, this.tcf);
      paramVarArgs.gB(5, this.tcc);
      paramVarArgs.gB(6, this.tcd);
      paramVarArgs.gB(7, this.tce);
      paramVarArgs.gB(8, this.tch);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label606;
      }
    }
    label606:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tts != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tts);
      }
      i = paramInt;
      if (this.tcg != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tcg);
      }
      return i + d.a.a.a.gy(4, this.tcf) + d.a.a.a.gy(5, this.tcc) + d.a.a.a.gy(6, this.tcd) + d.a.a.a.gy(7, this.tce) + d.a.a.a.gy(8, this.tch);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cam localcam = (cam)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcam.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcam.tts = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcam.tcg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localcam.tcf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcam.tcc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcam.tcd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcam.tce = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcam.tch = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cam
 * JD-Core Version:    0.7.0.1
 */