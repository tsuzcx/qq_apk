package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dds
  extends esc
{
  public ddh aaIR;
  public LinkedList<fwc> aaJl;
  public LinkedList<String> aaJm;
  public String aaJn;
  public LinkedList<ddx> aaJo;
  
  public dds()
  {
    AppMethodBeat.i(82440);
    this.aaJl = new LinkedList();
    this.aaJm = new LinkedList();
    this.aaJo = new LinkedList();
    AppMethodBeat.o(82440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82441);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaIR != null)
      {
        paramVarArgs.qD(2, this.aaIR.computeSize());
        this.aaIR.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.aaJl);
      paramVarArgs.e(4, 1, this.aaJm);
      if (this.aaJn != null) {
        paramVarArgs.g(5, this.aaJn);
      }
      paramVarArgs.e(6, 8, this.aaJo);
      AppMethodBeat.o(82441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaIR != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaIR.computeSize());
      }
      i = i + i.a.a.a.c(3, 8, this.aaJl) + i.a.a.a.c(4, 1, this.aaJm);
      paramInt = i;
      if (this.aaJn != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaJn);
      }
      i = i.a.a.a.c(6, 8, this.aaJo);
      AppMethodBeat.o(82441);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaJl.clear();
        this.aaJm.clear();
        this.aaJo.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dds localdds = (dds)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82441);
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
            localdds.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ddh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ddh)localObject2).parseFrom((byte[])localObject1);
            }
            localdds.aaIR = ((ddh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fwc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fwc)localObject2).parseFrom((byte[])localObject1);
            }
            localdds.aaJl.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 4: 
          localdds.aaJm.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(82441);
          return 0;
        case 5: 
          localdds.aaJn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82441);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ddx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ddx)localObject2).parseFrom((byte[])localObject1);
          }
          localdds.aaJo.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82441);
        return 0;
      }
      AppMethodBeat.o(82441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dds
 * JD-Core Version:    0.7.0.1
 */