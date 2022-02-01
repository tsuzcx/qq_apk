package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class edq
  extends com.tencent.mm.bx.a
{
  public String IHV;
  public giu abiL;
  public gix abiM;
  public giq abiN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110851);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IHV == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110851);
        throw paramVarArgs;
      }
      if (this.IHV != null) {
        paramVarArgs.g(1, this.IHV);
      }
      if (this.abiL != null)
      {
        paramVarArgs.qD(2, this.abiL.computeSize());
        this.abiL.writeFields(paramVarArgs);
      }
      if (this.abiM != null)
      {
        paramVarArgs.qD(3, this.abiM.computeSize());
        this.abiM.writeFields(paramVarArgs);
      }
      if (this.abiN != null)
      {
        paramVarArgs.qD(4, this.abiN.computeSize());
        this.abiN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110851);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IHV == null) {
        break label656;
      }
    }
    label656:
    for (int i = i.a.a.b.b.a.h(1, this.IHV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abiL != null) {
        paramInt = i + i.a.a.a.qC(2, this.abiL.computeSize());
      }
      i = paramInt;
      if (this.abiM != null) {
        i = paramInt + i.a.a.a.qC(3, this.abiM.computeSize());
      }
      paramInt = i;
      if (this.abiN != null) {
        paramInt = i + i.a.a.a.qC(4, this.abiN.computeSize());
      }
      AppMethodBeat.o(110851);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IHV == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(110851);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        edq localedq = (edq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110851);
          return -1;
        case 1: 
          localedq.IHV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(110851);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new giu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((giu)localObject2).parseFrom((byte[])localObject1);
            }
            localedq.abiL = ((giu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gix();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gix)localObject2).parseFrom((byte[])localObject1);
            }
            localedq.abiM = ((gix)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new giq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((giq)localObject2).parseFrom((byte[])localObject1);
          }
          localedq.abiN = ((giq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      AppMethodBeat.o(110851);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edq
 * JD-Core Version:    0.7.0.1
 */