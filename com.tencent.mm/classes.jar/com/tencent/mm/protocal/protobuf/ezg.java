package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezg
  extends com.tencent.mm.bx.a
{
  public eah abAm;
  public ead abAn;
  public eah abAo;
  public ead abAp;
  public boolean abAq = false;
  public boolean abAr = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258838);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abAm != null)
      {
        paramVarArgs.qD(1, this.abAm.computeSize());
        this.abAm.writeFields(paramVarArgs);
      }
      if (this.abAn != null)
      {
        paramVarArgs.qD(2, this.abAn.computeSize());
        this.abAn.writeFields(paramVarArgs);
      }
      if (this.abAo != null)
      {
        paramVarArgs.qD(3, this.abAo.computeSize());
        this.abAo.writeFields(paramVarArgs);
      }
      if (this.abAp != null)
      {
        paramVarArgs.qD(4, this.abAp.computeSize());
        this.abAp.writeFields(paramVarArgs);
      }
      paramVarArgs.di(5, this.abAq);
      paramVarArgs.di(6, this.abAr);
      AppMethodBeat.o(258838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abAm == null) {
        break label770;
      }
    }
    label770:
    for (int i = i.a.a.a.qC(1, this.abAm.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abAn != null) {
        paramInt = i + i.a.a.a.qC(2, this.abAn.computeSize());
      }
      i = paramInt;
      if (this.abAo != null) {
        i = paramInt + i.a.a.a.qC(3, this.abAo.computeSize());
      }
      paramInt = i;
      if (this.abAp != null) {
        paramInt = i + i.a.a.a.qC(4, this.abAp.computeSize());
      }
      i = i.a.a.b.b.a.ko(5);
      int j = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(258838);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258838);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ezg localezg = (ezg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258838);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eah();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eah)localObject2).parseFrom((byte[])localObject1);
            }
            localezg.abAm = ((eah)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258838);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ead();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ead)localObject2).parseFrom((byte[])localObject1);
            }
            localezg.abAn = ((ead)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258838);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eah();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eah)localObject2).parseFrom((byte[])localObject1);
            }
            localezg.abAo = ((eah)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258838);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ead();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ead)localObject2).parseFrom((byte[])localObject1);
            }
            localezg.abAp = ((ead)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258838);
          return 0;
        case 5: 
          localezg.abAq = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(258838);
          return 0;
        }
        localezg.abAr = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(258838);
        return 0;
      }
      AppMethodBeat.o(258838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezg
 * JD-Core Version:    0.7.0.1
 */