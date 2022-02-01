package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdf
  extends com.tencent.mm.bx.a
{
  public int MFk;
  public String Zbg;
  public ee aatN;
  public LinkedList<ehh> abCI;
  public aou abCJ;
  public LinkedList<ems> abCK;
  public int abCL;
  
  public fdf()
  {
    AppMethodBeat.i(91694);
    this.abCI = new LinkedList();
    this.abCK = new LinkedList();
    AppMethodBeat.o(91694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91695);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.MFk);
      paramVarArgs.e(2, 8, this.abCI);
      if (this.abCJ != null)
      {
        paramVarArgs.qD(3, this.abCJ.computeSize());
        this.abCJ.writeFields(paramVarArgs);
      }
      if (this.aatN != null)
      {
        paramVarArgs.qD(4, this.aatN.computeSize());
        this.aatN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.abCK);
      paramVarArgs.bS(6, this.abCL);
      if (this.Zbg != null) {
        paramVarArgs.g(7, this.Zbg);
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.MFk) + 0 + i.a.a.a.c(2, 8, this.abCI);
      paramInt = i;
      if (this.abCJ != null) {
        paramInt = i + i.a.a.a.qC(3, this.abCJ.computeSize());
      }
      i = paramInt;
      if (this.aatN != null) {
        i = paramInt + i.a.a.a.qC(4, this.aatN.computeSize());
      }
      i = i + i.a.a.a.c(5, 8, this.abCK) + i.a.a.b.b.a.cJ(6, this.abCL);
      paramInt = i;
      if (this.Zbg != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zbg);
      }
      AppMethodBeat.o(91695);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abCI.clear();
      this.abCK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      fdf localfdf = (fdf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91695);
        return -1;
      case 1: 
        localfdf.MFk = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91695);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ehh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ehh)localObject2).parseFrom((byte[])localObject1);
          }
          localfdf.abCI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aou();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aou)localObject2).parseFrom((byte[])localObject1);
          }
          localfdf.abCJ = ((aou)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ee();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ee)localObject2).parseFrom((byte[])localObject1);
          }
          localfdf.aatN = ((ee)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ems();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ems)localObject2).parseFrom((byte[])localObject1);
          }
          localfdf.abCK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 6: 
        localfdf.abCL = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91695);
        return 0;
      }
      localfdf.Zbg = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(91695);
      return 0;
    }
    AppMethodBeat.o(91695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdf
 * JD-Core Version:    0.7.0.1
 */