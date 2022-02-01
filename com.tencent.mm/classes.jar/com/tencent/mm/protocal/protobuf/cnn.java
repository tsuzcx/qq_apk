package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cnn
  extends esc
{
  public int aaqL;
  public vx aauO;
  public wc aauR;
  public vz aauS;
  public String aauT;
  public String wuA;
  public int wuz;
  public int xlj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260137);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(260137);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.aauR != null)
      {
        paramVarArgs.qD(4, this.aauR.computeSize());
        this.aauR.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.xlj);
      paramVarArgs.bS(6, this.aaqL);
      if (this.aauS != null)
      {
        paramVarArgs.qD(7, this.aauS.computeSize());
        this.aauS.writeFields(paramVarArgs);
      }
      if (this.aauO != null)
      {
        paramVarArgs.qD(8, this.aauO.computeSize());
        this.aauO.writeFields(paramVarArgs);
      }
      if (this.aauT != null) {
        paramVarArgs.g(9, this.aauT);
      }
      AppMethodBeat.o(260137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label986;
      }
    }
    label986:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.aauR != null) {
        i = paramInt + i.a.a.a.qC(4, this.aauR.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(5, this.xlj) + i.a.a.b.b.a.cJ(6, this.aaqL);
      paramInt = i;
      if (this.aauS != null) {
        paramInt = i + i.a.a.a.qC(7, this.aauS.computeSize());
      }
      i = paramInt;
      if (this.aauO != null) {
        i = paramInt + i.a.a.a.qC(8, this.aauO.computeSize());
      }
      paramInt = i;
      if (this.aauT != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aauT);
      }
      AppMethodBeat.o(260137);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(260137);
          throw paramVarArgs;
        }
        AppMethodBeat.o(260137);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cnn localcnn = (cnn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260137);
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
            localcnn.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260137);
          return 0;
        case 2: 
          localcnn.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260137);
          return 0;
        case 3: 
          localcnn.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260137);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wc)localObject2).parseFrom((byte[])localObject1);
            }
            localcnn.aauR = ((wc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260137);
          return 0;
        case 5: 
          localcnn.xlj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260137);
          return 0;
        case 6: 
          localcnn.aaqL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260137);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vz)localObject2).parseFrom((byte[])localObject1);
            }
            localcnn.aauS = ((vz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260137);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vx)localObject2).parseFrom((byte[])localObject1);
            }
            localcnn.aauO = ((vx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260137);
          return 0;
        }
        localcnn.aauT = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260137);
        return 0;
      }
      AppMethodBeat.o(260137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnn
 * JD-Core Version:    0.7.0.1
 */