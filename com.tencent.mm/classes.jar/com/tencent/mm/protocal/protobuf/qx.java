package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class qx
  extends com.tencent.mm.bx.a
{
  public LinkedList<ot> FMJ;
  public LinkedList<ecf> FMK;
  public LinkedList<aez> FML;
  public LinkedList<efi> FMM;
  public cua FMN;
  public b FMO;
  public LinkedList<cia> FMP;
  public int nEf;
  
  public qx()
  {
    AppMethodBeat.i(117848);
    this.FMJ = new LinkedList();
    this.FMK = new LinkedList();
    this.FML = new LinkedList();
    this.FMM = new LinkedList();
    this.FMP = new LinkedList();
    AppMethodBeat.o(117848);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117849);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      paramVarArgs.e(2, 8, this.FMJ);
      paramVarArgs.e(3, 8, this.FMK);
      paramVarArgs.e(4, 8, this.FML);
      paramVarArgs.e(5, 8, this.FMM);
      if (this.FMN != null)
      {
        paramVarArgs.lC(6, this.FMN.computeSize());
        this.FMN.writeFields(paramVarArgs);
      }
      if (this.FMO != null) {
        paramVarArgs.c(7, this.FMO);
      }
      paramVarArgs.e(8, 8, this.FMP);
      AppMethodBeat.o(117849);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nEf) + 0 + f.a.a.a.c(2, 8, this.FMJ) + f.a.a.a.c(3, 8, this.FMK) + f.a.a.a.c(4, 8, this.FML) + f.a.a.a.c(5, 8, this.FMM);
      paramInt = i;
      if (this.FMN != null) {
        paramInt = i + f.a.a.a.lB(6, this.FMN.computeSize());
      }
      i = paramInt;
      if (this.FMO != null) {
        i = paramInt + f.a.a.b.b.a.b(7, this.FMO);
      }
      paramInt = f.a.a.a.c(8, 8, this.FMP);
      AppMethodBeat.o(117849);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FMJ.clear();
      this.FMK.clear();
      this.FML.clear();
      this.FMM.clear();
      this.FMP.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      qx localqx = (qx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117849);
        return -1;
      case 1: 
        localqx.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117849);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ot();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ot)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqx.FMJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ecf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ecf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqx.FMK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aez();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aez)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqx.FML.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new efi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((efi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqx.FMM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cua();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cua)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqx.FMN = ((cua)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 7: 
        localqx.FMO = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(117849);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cia();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localqx.FMP.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    AppMethodBeat.o(117849);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qx
 * JD-Core Version:    0.7.0.1
 */