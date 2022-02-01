package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fhd
  extends com.tencent.mm.bx.a
{
  public long abHI;
  public long abHJ;
  public String abHK;
  public String abHL;
  public int abHM;
  public alu abHN;
  public long abHO;
  public long abHP;
  public alv abHQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257487);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.abHI);
      paramVarArgs.bv(2, this.abHJ);
      if (this.abHK != null) {
        paramVarArgs.g(3, this.abHK);
      }
      if (this.abHL != null) {
        paramVarArgs.g(4, this.abHL);
      }
      paramVarArgs.bS(5, this.abHM);
      if (this.abHN != null)
      {
        paramVarArgs.qD(6, this.abHN.computeSize());
        this.abHN.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(7, this.abHO);
      paramVarArgs.bv(8, this.abHP);
      if (this.abHQ != null)
      {
        paramVarArgs.qD(9, this.abHQ.computeSize());
        this.abHQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257487);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.abHI) + 0 + i.a.a.b.b.a.q(2, this.abHJ);
      paramInt = i;
      if (this.abHK != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abHK);
      }
      i = paramInt;
      if (this.abHL != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abHL);
      }
      i += i.a.a.b.b.a.cJ(5, this.abHM);
      paramInt = i;
      if (this.abHN != null) {
        paramInt = i + i.a.a.a.qC(6, this.abHN.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.abHO) + i.a.a.b.b.a.q(8, this.abHP);
      paramInt = i;
      if (this.abHQ != null) {
        paramInt = i + i.a.a.a.qC(9, this.abHQ.computeSize());
      }
      AppMethodBeat.o(257487);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257487);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      fhd localfhd = (fhd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257487);
        return -1;
      case 1: 
        localfhd.abHI = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257487);
        return 0;
      case 2: 
        localfhd.abHJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257487);
        return 0;
      case 3: 
        localfhd.abHK = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257487);
        return 0;
      case 4: 
        localfhd.abHL = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257487);
        return 0;
      case 5: 
        localfhd.abHM = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257487);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new alu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((alu)localObject2).parseFrom((byte[])localObject1);
          }
          localfhd.abHN = ((alu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257487);
        return 0;
      case 7: 
        localfhd.abHO = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257487);
        return 0;
      case 8: 
        localfhd.abHP = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257487);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new alv();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((alv)localObject2).parseFrom((byte[])localObject1);
        }
        localfhd.abHQ = ((alv)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(257487);
      return 0;
    }
    AppMethodBeat.o(257487);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhd
 * JD-Core Version:    0.7.0.1
 */