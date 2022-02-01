package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class caq
  extends com.tencent.mm.bx.a
{
  public gdy aajA;
  public gea aajB;
  public boolean aajC;
  public boolean aajD;
  public String aajE;
  public String aajF;
  public int aajG;
  public geb aajz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258451);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aajz != null)
      {
        paramVarArgs.qD(1, this.aajz.computeSize());
        this.aajz.writeFields(paramVarArgs);
      }
      if (this.aajA != null)
      {
        paramVarArgs.qD(2, this.aajA.computeSize());
        this.aajA.writeFields(paramVarArgs);
      }
      if (this.aajB != null)
      {
        paramVarArgs.qD(3, this.aajB.computeSize());
        this.aajB.writeFields(paramVarArgs);
      }
      paramVarArgs.di(4, this.aajC);
      paramVarArgs.di(5, this.aajD);
      if (this.aajE != null) {
        paramVarArgs.g(6, this.aajE);
      }
      if (this.aajF != null) {
        paramVarArgs.g(7, this.aajF);
      }
      paramVarArgs.bS(99, this.aajG);
      AppMethodBeat.o(258451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aajz == null) {
        break label828;
      }
    }
    label828:
    for (int i = i.a.a.a.qC(1, this.aajz.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aajA != null) {
        paramInt = i + i.a.a.a.qC(2, this.aajA.computeSize());
      }
      i = paramInt;
      if (this.aajB != null) {
        i = paramInt + i.a.a.a.qC(3, this.aajB.computeSize());
      }
      i = i + (i.a.a.b.b.a.ko(4) + 1) + (i.a.a.b.b.a.ko(5) + 1);
      paramInt = i;
      if (this.aajE != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aajE);
      }
      i = paramInt;
      if (this.aajF != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aajF);
      }
      paramInt = i.a.a.b.b.a.cJ(99, this.aajG);
      AppMethodBeat.o(258451);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        caq localcaq = (caq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258451);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new geb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((geb)localObject2).parseFrom((byte[])localObject1);
            }
            localcaq.aajz = ((geb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258451);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gdy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gdy)localObject2).parseFrom((byte[])localObject1);
            }
            localcaq.aajA = ((gdy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258451);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gea();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gea)localObject2).parseFrom((byte[])localObject1);
            }
            localcaq.aajB = ((gea)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258451);
          return 0;
        case 4: 
          localcaq.aajC = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(258451);
          return 0;
        case 5: 
          localcaq.aajD = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(258451);
          return 0;
        case 6: 
          localcaq.aajE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258451);
          return 0;
        case 7: 
          localcaq.aajF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258451);
          return 0;
        }
        localcaq.aajG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258451);
        return 0;
      }
      AppMethodBeat.o(258451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caq
 * JD-Core Version:    0.7.0.1
 */