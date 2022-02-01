package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fdk
  extends com.tencent.mm.bx.a
{
  public SnsObject abCS;
  public etl abCT;
  public etl abCU;
  public etl abCV;
  public etl abCW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125765);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abCS == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsObject");
        AppMethodBeat.o(125765);
        throw paramVarArgs;
      }
      if (this.abCS != null)
      {
        paramVarArgs.qD(1, this.abCS.computeSize());
        this.abCS.writeFields(paramVarArgs);
      }
      if (this.abCT != null)
      {
        paramVarArgs.qD(2, this.abCT.computeSize());
        this.abCT.writeFields(paramVarArgs);
      }
      if (this.abCU != null)
      {
        paramVarArgs.qD(3, this.abCU.computeSize());
        this.abCU.writeFields(paramVarArgs);
      }
      if (this.abCV != null)
      {
        paramVarArgs.qD(4, this.abCV.computeSize());
        this.abCV.writeFields(paramVarArgs);
      }
      if (this.abCW != null)
      {
        paramVarArgs.qD(5, this.abCW.computeSize());
        this.abCW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125765);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abCS == null) {
        break label860;
      }
    }
    label860:
    for (int i = i.a.a.a.qC(1, this.abCS.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abCT != null) {
        paramInt = i + i.a.a.a.qC(2, this.abCT.computeSize());
      }
      i = paramInt;
      if (this.abCU != null) {
        i = paramInt + i.a.a.a.qC(3, this.abCU.computeSize());
      }
      paramInt = i;
      if (this.abCV != null) {
        paramInt = i + i.a.a.a.qC(4, this.abCV.computeSize());
      }
      i = paramInt;
      if (this.abCW != null) {
        i = paramInt + i.a.a.a.qC(5, this.abCW.computeSize());
      }
      AppMethodBeat.o(125765);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abCS == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsObject");
          AppMethodBeat.o(125765);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125765);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fdk localfdk = (fdk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125765);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new SnsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((SnsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localfdk.abCS = ((SnsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125765);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfdk.abCT = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125765);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfdk.abCU = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125765);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfdk.abCV = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125765);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localfdk.abCW = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125765);
        return 0;
      }
      AppMethodBeat.o(125765);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdk
 * JD-Core Version:    0.7.0.1
 */