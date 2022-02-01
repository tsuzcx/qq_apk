package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ib
  extends com.tencent.mm.bx.a
{
  public ia YJK;
  public cdz YJL;
  public String YJM;
  public String YJN;
  public String YJO;
  public euq YJP;
  public ii YJQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123544);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YJK != null)
      {
        paramVarArgs.qD(1, this.YJK.computeSize());
        this.YJK.writeFields(paramVarArgs);
      }
      if (this.YJL != null)
      {
        paramVarArgs.qD(2, this.YJL.computeSize());
        this.YJL.writeFields(paramVarArgs);
      }
      if (this.YJM != null) {
        paramVarArgs.g(3, this.YJM);
      }
      if (this.YJN != null) {
        paramVarArgs.g(4, this.YJN);
      }
      if (this.YJO != null) {
        paramVarArgs.g(5, this.YJO);
      }
      if (this.YJP != null)
      {
        paramVarArgs.qD(6, this.YJP.computeSize());
        this.YJP.writeFields(paramVarArgs);
      }
      if (this.YJQ != null)
      {
        paramVarArgs.qD(7, this.YJQ.computeSize());
        this.YJQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YJK == null) {
        break label866;
      }
    }
    label866:
    for (int i = i.a.a.a.qC(1, this.YJK.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YJL != null) {
        paramInt = i + i.a.a.a.qC(2, this.YJL.computeSize());
      }
      i = paramInt;
      if (this.YJM != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YJM);
      }
      paramInt = i;
      if (this.YJN != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YJN);
      }
      i = paramInt;
      if (this.YJO != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YJO);
      }
      paramInt = i;
      if (this.YJP != null) {
        paramInt = i + i.a.a.a.qC(6, this.YJP.computeSize());
      }
      i = paramInt;
      if (this.YJQ != null) {
        i = paramInt + i.a.a.a.qC(7, this.YJQ.computeSize());
      }
      AppMethodBeat.o(123544);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ib localib = (ib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123544);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ia();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ia)localObject2).parseFrom((byte[])localObject1);
            }
            localib.YJK = ((ia)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cdz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cdz)localObject2).parseFrom((byte[])localObject1);
            }
            localib.YJL = ((cdz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 3: 
          localib.YJM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 4: 
          localib.YJN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 5: 
          localib.YJO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new euq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((euq)localObject2).parseFrom((byte[])localObject1);
            }
            localib.YJP = ((euq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ii();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ii)localObject2).parseFrom((byte[])localObject1);
          }
          localib.YJQ = ((ii)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      AppMethodBeat.o(123544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ib
 * JD-Core Version:    0.7.0.1
 */