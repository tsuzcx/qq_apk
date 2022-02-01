package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class few
  extends esc
{
  public String aaTW;
  public SnsObject abCS;
  public ffo abEA;
  public int abEB;
  public LinkedList<etl> abEC;
  
  public few()
  {
    AppMethodBeat.i(258371);
    this.abEC = new LinkedList();
    AppMethodBeat.o(258371);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125807);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125807);
        throw paramVarArgs;
      }
      if (this.abCS == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsObject");
        AppMethodBeat.o(125807);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abCS != null)
      {
        paramVarArgs.qD(2, this.abCS.computeSize());
        this.abCS.writeFields(paramVarArgs);
      }
      if (this.aaTW != null) {
        paramVarArgs.g(3, this.aaTW);
      }
      if (this.abEA != null)
      {
        paramVarArgs.qD(4, this.abEA.computeSize());
        this.abEA.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.abEB);
      paramVarArgs.e(6, 8, this.abEC);
      AppMethodBeat.o(125807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label874;
      }
    }
    label874:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abCS != null) {
        paramInt = i + i.a.a.a.qC(2, this.abCS.computeSize());
      }
      i = paramInt;
      if (this.aaTW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaTW);
      }
      paramInt = i;
      if (this.abEA != null) {
        paramInt = i + i.a.a.a.qC(4, this.abEA.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.abEB);
      int j = i.a.a.a.c(6, 8, this.abEC);
      AppMethodBeat.o(125807);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abEC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125807);
          throw paramVarArgs;
        }
        if (this.abCS == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsObject");
          AppMethodBeat.o(125807);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        few localfew = (few)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125807);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfew.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125807);
          return 0;
        case 2: 
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
            localfew.abCS = ((SnsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125807);
          return 0;
        case 3: 
          localfew.aaTW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125807);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffo)localObject2).parseFrom((byte[])localObject1);
            }
            localfew.abEA = ((ffo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125807);
          return 0;
        case 5: 
          localfew.abEB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125807);
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
          localfew.abEC.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125807);
        return 0;
      }
      AppMethodBeat.o(125807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.few
 * JD-Core Version:    0.7.0.1
 */