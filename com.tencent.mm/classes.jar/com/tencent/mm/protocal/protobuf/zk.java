package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zk
  extends com.tencent.mm.bw.a
{
  public dhb DNJ;
  public String DWw;
  public LinkedList<dhb> EjR;
  public LinkedList<dhb> EtM;
  public String EtN;
  public int state;
  
  public zk()
  {
    AppMethodBeat.i(91427);
    this.EjR = new LinkedList();
    this.EtM = new LinkedList();
    AppMethodBeat.o(91427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.state);
      if (this.DNJ != null)
      {
        paramVarArgs.ln(2, this.DNJ.computeSize());
        this.DNJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.EjR);
      paramVarArgs.e(4, 8, this.EtM);
      if (this.EtN != null) {
        paramVarArgs.d(5, this.EtN);
      }
      if (this.DWw != null) {
        paramVarArgs.d(6, this.DWw);
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.state) + 0;
      paramInt = i;
      if (this.DNJ != null) {
        paramInt = i + f.a.a.a.lm(2, this.DNJ.computeSize());
      }
      i = paramInt + f.a.a.a.c(3, 8, this.EjR) + f.a.a.a.c(4, 8, this.EtM);
      paramInt = i;
      if (this.EtN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EtN);
      }
      i = paramInt;
      if (this.DWw != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DWw);
      }
      AppMethodBeat.o(91428);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EjR.clear();
      this.EtM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      zk localzk = (zk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91428);
        return -1;
      case 1: 
        localzk.state = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91428);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localzk.DNJ = ((dhb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localzk.EjR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localzk.EtM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 5: 
        localzk.EtN = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91428);
        return 0;
      }
      localzk.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(91428);
      return 0;
    }
    AppMethodBeat.o(91428);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zk
 * JD-Core Version:    0.7.0.1
 */