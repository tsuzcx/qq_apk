package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dom
  extends com.tencent.mm.bx.a
{
  public int BGb;
  public int BGr;
  public int BGs;
  public float BGt;
  public long BMD;
  public long HCU;
  public long HCV;
  public acd HCW;
  public dpu HCX;
  public long hiy;
  public String path;
  public long startTimeMs;
  public int type;
  public float volume;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(215809);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.d(1, this.path);
      }
      paramVarArgs.aS(2, this.type);
      paramVarArgs.aY(3, this.startTimeMs);
      paramVarArgs.aY(4, this.hiy);
      paramVarArgs.aY(5, this.HCU);
      paramVarArgs.aY(6, this.HCV);
      paramVarArgs.aY(7, this.BMD);
      paramVarArgs.aS(8, this.BGr);
      paramVarArgs.aS(9, this.BGs);
      paramVarArgs.z(10, this.BGt);
      paramVarArgs.z(11, this.volume);
      if (this.HCW != null)
      {
        paramVarArgs.lC(12, this.HCW.computeSize());
        this.HCW.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.BGb);
      if (this.HCX != null)
      {
        paramVarArgs.lC(14, this.HCX.computeSize());
        this.HCX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(215809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label1056;
      }
    }
    label1056:
    for (paramInt = f.a.a.b.b.a.e(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type) + f.a.a.b.b.a.p(3, this.startTimeMs) + f.a.a.b.b.a.p(4, this.hiy) + f.a.a.b.b.a.p(5, this.HCU) + f.a.a.b.b.a.p(6, this.HCV) + f.a.a.b.b.a.p(7, this.BMD) + f.a.a.b.b.a.bz(8, this.BGr) + f.a.a.b.b.a.bz(9, this.BGs) + f.a.a.b.b.a.alU(10) + f.a.a.b.b.a.alU(11);
      paramInt = i;
      if (this.HCW != null) {
        paramInt = i + f.a.a.a.lB(12, this.HCW.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.BGb);
      paramInt = i;
      if (this.HCX != null) {
        paramInt = i + f.a.a.a.lB(14, this.HCX.computeSize());
      }
      AppMethodBeat.o(215809);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(215809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(215809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dom localdom = (dom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215809);
          return -1;
        case 1: 
          localdom.path = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215809);
          return 0;
        case 2: 
          localdom.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215809);
          return 0;
        case 3: 
          localdom.startTimeMs = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(215809);
          return 0;
        case 4: 
          localdom.hiy = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(215809);
          return 0;
        case 5: 
          localdom.HCU = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(215809);
          return 0;
        case 6: 
          localdom.HCV = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(215809);
          return 0;
        case 7: 
          localdom.BMD = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(215809);
          return 0;
        case 8: 
          localdom.BGr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215809);
          return 0;
        case 9: 
          localdom.BGs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215809);
          return 0;
        case 10: 
          localdom.BGt = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(215809);
          return 0;
        case 11: 
          localdom.volume = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(215809);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdom.HCW = ((acd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215809);
          return 0;
        case 13: 
          localdom.BGb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215809);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdom.HCX = ((dpu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215809);
        return 0;
      }
      AppMethodBeat.o(215809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dom
 * JD-Core Version:    0.7.0.1
 */