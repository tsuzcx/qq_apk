package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cbs
  extends blm
{
  public String kWm;
  public String kWn;
  public bmk ndi;
  public int pyo;
  public String sNM;
  public cds sNN;
  public cbr sNP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sNN == null) {
        throw new b("Not all required fields were included: VoiceAttr");
      }
      if (this.sNP == null) {
        throw new b("Not all required fields were included: UploadCtx");
      }
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sNM != null) {
        paramVarArgs.d(2, this.sNM);
      }
      if (this.sNN != null)
      {
        paramVarArgs.gD(3, this.sNN.btq());
        this.sNN.a(paramVarArgs);
      }
      if (this.sNP != null)
      {
        paramVarArgs.gD(4, this.sNP.btq());
        this.sNP.a(paramVarArgs);
      }
      if (this.ndi != null)
      {
        paramVarArgs.gD(5, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.pyo);
      if (this.kWn != null) {
        paramVarArgs.d(7, this.kWn);
      }
      if (this.kWm != null) {
        paramVarArgs.d(8, this.kWm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1024;
      }
    }
    label1024:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sNM != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sNM);
      }
      i = paramInt;
      if (this.sNN != null) {
        i = paramInt + d.a.a.a.gA(3, this.sNN.btq());
      }
      paramInt = i;
      if (this.sNP != null) {
        paramInt = i + d.a.a.a.gA(4, this.sNP.btq());
      }
      i = paramInt;
      if (this.ndi != null) {
        i = paramInt + d.a.a.a.gA(5, this.ndi.btq());
      }
      i += d.a.a.a.gy(6, this.pyo);
      paramInt = i;
      if (this.kWn != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.kWn);
      }
      i = paramInt;
      if (this.kWm != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.kWm);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sNN == null) {
          throw new b("Not all required fields were included: VoiceAttr");
        }
        if (this.sNP == null) {
          throw new b("Not all required fields were included: UploadCtx");
        }
        if (this.ndi != null) {
          break;
        }
        throw new b("Not all required fields were included: Data");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cbs localcbs = (cbs)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbs.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcbs.sNM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cds();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cds)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbs.sNN = ((cds)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbr();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbs.sNP = ((cbr)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcbs.ndi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 6: 
          localcbs.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcbs.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localcbs.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbs
 * JD-Core Version:    0.7.0.1
 */