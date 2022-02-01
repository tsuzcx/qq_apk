package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byg
  extends com.tencent.mm.bx.a
{
  public LinkedList<efk> GSA;
  public LinkedList<dpv> GSB;
  public dov GSC;
  public long GSt;
  public long GSu;
  public long GSv;
  public LinkedList<efk> GSw;
  public long GSx;
  public boolean GSy;
  public double GSz;
  public long begin_time;
  public long dle;
  public long duration;
  public long id;
  public String path;
  
  public byg()
  {
    AppMethodBeat.i(110905);
    this.GSw = new LinkedList();
    this.GSA = new LinkedList();
    this.GSB = new LinkedList();
    AppMethodBeat.o(110905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110906);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.id);
      paramVarArgs.aY(2, this.dle);
      paramVarArgs.aY(3, this.begin_time);
      paramVarArgs.aY(4, this.duration);
      paramVarArgs.aY(5, this.GSt);
      paramVarArgs.aY(6, this.GSu);
      paramVarArgs.aY(7, this.GSv);
      paramVarArgs.e(8, 8, this.GSw);
      paramVarArgs.aY(9, this.GSx);
      paramVarArgs.bt(10, this.GSy);
      paramVarArgs.e(11, this.GSz);
      paramVarArgs.e(12, 8, this.GSA);
      paramVarArgs.e(13, 8, this.GSB);
      if (this.GSC != null)
      {
        paramVarArgs.lC(14, this.GSC.computeSize());
        this.GSC.writeFields(paramVarArgs);
      }
      if (this.path != null) {
        paramVarArgs.d(15, this.path);
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.id) + 0 + f.a.a.b.b.a.p(2, this.dle) + f.a.a.b.b.a.p(3, this.begin_time) + f.a.a.b.b.a.p(4, this.duration) + f.a.a.b.b.a.p(5, this.GSt) + f.a.a.b.b.a.p(6, this.GSu) + f.a.a.b.b.a.p(7, this.GSv) + f.a.a.a.c(8, 8, this.GSw) + f.a.a.b.b.a.p(9, this.GSx) + f.a.a.b.b.a.alV(10) + f.a.a.b.b.a.alT(11) + f.a.a.a.c(12, 8, this.GSA) + f.a.a.a.c(13, 8, this.GSB);
      paramInt = i;
      if (this.GSC != null) {
        paramInt = i + f.a.a.a.lB(14, this.GSC.computeSize());
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.path);
      }
      AppMethodBeat.o(110906);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GSw.clear();
      this.GSA.clear();
      this.GSB.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(110906);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byg localbyg = (byg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110906);
        return -1;
      case 1: 
        localbyg.id = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 2: 
        localbyg.dle = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 3: 
        localbyg.begin_time = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 4: 
        localbyg.duration = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 5: 
        localbyg.GSt = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 6: 
        localbyg.GSu = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 7: 
        localbyg.GSv = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new efk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((efk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyg.GSw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 9: 
        localbyg.GSx = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110906);
        return 0;
      case 10: 
        localbyg.GSy = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(110906);
        return 0;
      case 11: 
        localbyg.GSz = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
        AppMethodBeat.o(110906);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new efk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((efk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyg.GSA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyg.GSB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dov();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyg.GSC = ((dov)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110906);
        return 0;
      }
      localbyg.path = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(110906);
      return 0;
    }
    AppMethodBeat.o(110906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byg
 * JD-Core Version:    0.7.0.1
 */