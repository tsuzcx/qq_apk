package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class pl
  extends com.tencent.mm.bx.a
{
  public LinkedList<nh> CNI;
  public LinkedList<dqo> CNJ;
  public LinkedList<abz> CNK;
  public LinkedList<dtp> CNL;
  public cjo CNM;
  public b CNN;
  public LinkedList<byg> CNO;
  public int mBH;
  
  public pl()
  {
    AppMethodBeat.i(117848);
    this.CNI = new LinkedList();
    this.CNJ = new LinkedList();
    this.CNK = new LinkedList();
    this.CNL = new LinkedList();
    this.CNO = new LinkedList();
    AppMethodBeat.o(117848);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117849);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBH);
      paramVarArgs.e(2, 8, this.CNI);
      paramVarArgs.e(3, 8, this.CNJ);
      paramVarArgs.e(4, 8, this.CNK);
      paramVarArgs.e(5, 8, this.CNL);
      if (this.CNM != null)
      {
        paramVarArgs.kX(6, this.CNM.computeSize());
        this.CNM.writeFields(paramVarArgs);
      }
      if (this.CNN != null) {
        paramVarArgs.c(7, this.CNN);
      }
      paramVarArgs.e(8, 8, this.CNO);
      AppMethodBeat.o(117849);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.mBH) + 0 + f.a.a.a.c(2, 8, this.CNI) + f.a.a.a.c(3, 8, this.CNJ) + f.a.a.a.c(4, 8, this.CNK) + f.a.a.a.c(5, 8, this.CNL);
      paramInt = i;
      if (this.CNM != null) {
        paramInt = i + f.a.a.a.kW(6, this.CNM.computeSize());
      }
      i = paramInt;
      if (this.CNN != null) {
        i = paramInt + f.a.a.b.b.a.b(7, this.CNN);
      }
      paramInt = f.a.a.a.c(8, 8, this.CNO);
      AppMethodBeat.o(117849);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CNI.clear();
      this.CNJ.clear();
      this.CNK.clear();
      this.CNL.clear();
      this.CNO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      pl localpl = (pl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117849);
        return -1;
      case 1: 
        localpl.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117849);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpl.CNI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpl.CNJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpl.CNK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dtp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpl.CNL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpl.CNM = ((cjo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 7: 
        localpl.CNN = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(117849);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new byg();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((byg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localpl.CNO.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pl
 * JD-Core Version:    0.7.0.1
 */