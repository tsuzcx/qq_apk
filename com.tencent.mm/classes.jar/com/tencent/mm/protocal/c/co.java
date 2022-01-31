package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class co
  extends com.tencent.mm.bv.a
{
  public int bUR;
  public int nxO;
  public String nzl;
  public int scene;
  public String swc;
  public String swd;
  public String swe;
  public yz swf;
  public String swg;
  public int swh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.swc == null) {
        throw new b("Not all required fields were included: f2f_id");
      }
      if (this.swe == null) {
        throw new b("Not all required fields were included: payok_checksign");
      }
      if (this.swc != null) {
        paramVarArgs.d(1, this.swc);
      }
      if (this.swd != null) {
        paramVarArgs.d(2, this.swd);
      }
      paramVarArgs.gB(3, this.bUR);
      paramVarArgs.gB(4, this.nxO);
      paramVarArgs.gB(5, this.scene);
      if (this.swe != null) {
        paramVarArgs.d(6, this.swe);
      }
      if (this.swf != null)
      {
        paramVarArgs.gD(7, this.swf.btq());
        this.swf.a(paramVarArgs);
      }
      if (this.swg != null) {
        paramVarArgs.d(8, this.swg);
      }
      if (this.nzl != null) {
        paramVarArgs.d(9, this.nzl);
      }
      paramVarArgs.gB(10, this.swh);
      return 0;
    }
    if (paramInt == 1) {
      if (this.swc == null) {
        break label776;
      }
    }
    label776:
    for (paramInt = d.a.a.b.b.a.e(1, this.swc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.swd != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.swd);
      }
      i = i + d.a.a.a.gy(3, this.bUR) + d.a.a.a.gy(4, this.nxO) + d.a.a.a.gy(5, this.scene);
      paramInt = i;
      if (this.swe != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.swe);
      }
      i = paramInt;
      if (this.swf != null) {
        i = paramInt + d.a.a.a.gA(7, this.swf.btq());
      }
      paramInt = i;
      if (this.swg != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.swg);
      }
      i = paramInt;
      if (this.nzl != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.nzl);
      }
      return i + d.a.a.a.gy(10, this.swh);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.swc == null) {
          throw new b("Not all required fields were included: f2f_id");
        }
        if (this.swe != null) {
          break;
        }
        throw new b("Not all required fields were included: payok_checksign");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        co localco = (co)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localco.swc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localco.swd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localco.bUR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localco.nxO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localco.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localco.swe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((yz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localco.swf = ((yz)localObject1);
            paramInt += 1;
          }
        case 8: 
          localco.swg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localco.nzl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localco.swh = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.co
 * JD-Core Version:    0.7.0.1
 */