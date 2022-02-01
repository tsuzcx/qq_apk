package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhp
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public String LensId;
  public dho aaMT;
  public dhr aaMU;
  public gok aarb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104818);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.LensId != null) {
        paramVarArgs.g(1, this.LensId);
      }
      if (this.aaMT != null)
      {
        paramVarArgs.qD(2, this.aaMT.computeSize());
        this.aaMT.writeFields(paramVarArgs);
      }
      if (this.IGU != null) {
        paramVarArgs.g(3, this.IGU);
      }
      if (this.aarb != null)
      {
        paramVarArgs.qD(4, this.aarb.computeSize());
        this.aarb.writeFields(paramVarArgs);
      }
      if (this.aaMU != null)
      {
        paramVarArgs.qD(5, this.aaMU.computeSize());
        this.aaMU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104818);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LensId == null) {
        break label668;
      }
    }
    label668:
    for (int i = i.a.a.b.b.a.h(1, this.LensId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaMT != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaMT.computeSize());
      }
      i = paramInt;
      if (this.IGU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGU);
      }
      paramInt = i;
      if (this.aarb != null) {
        paramInt = i + i.a.a.a.qC(4, this.aarb.computeSize());
      }
      i = paramInt;
      if (this.aaMU != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaMU.computeSize());
      }
      AppMethodBeat.o(104818);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dhp localdhp = (dhp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104818);
          return -1;
        case 1: 
          localdhp.LensId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dho();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dho)localObject2).parseFrom((byte[])localObject1);
            }
            localdhp.aaMT = ((dho)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        case 3: 
          localdhp.IGU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gok();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gok)localObject2).parseFrom((byte[])localObject1);
            }
            localdhp.aarb = ((gok)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dhr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dhr)localObject2).parseFrom((byte[])localObject1);
          }
          localdhp.aaMU = ((dhr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      AppMethodBeat.o(104818);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhp
 * JD-Core Version:    0.7.0.1
 */