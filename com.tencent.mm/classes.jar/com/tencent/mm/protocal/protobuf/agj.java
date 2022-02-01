package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agj
  extends cwj
{
  public dfb FRC;
  public bpj FWx;
  public px FWy;
  public ccw FWz;
  public String xrf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155403);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155403);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xrf != null) {
        paramVarArgs.d(2, this.xrf);
      }
      if (this.FWy != null)
      {
        paramVarArgs.lJ(3, this.FWy.computeSize());
        this.FWy.writeFields(paramVarArgs);
      }
      if (this.FWx != null)
      {
        paramVarArgs.lJ(4, this.FWx.computeSize());
        this.FWx.writeFields(paramVarArgs);
      }
      if (this.FRC != null)
      {
        paramVarArgs.lJ(5, this.FRC.computeSize());
        this.FRC.writeFields(paramVarArgs);
      }
      if (this.FWz != null)
      {
        paramVarArgs.lJ(6, this.FWz.computeSize());
        this.FWz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1038;
      }
    }
    label1038:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xrf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xrf);
      }
      i = paramInt;
      if (this.FWy != null) {
        i = paramInt + f.a.a.a.lI(3, this.FWy.computeSize());
      }
      paramInt = i;
      if (this.FWx != null) {
        paramInt = i + f.a.a.a.lI(4, this.FWx.computeSize());
      }
      i = paramInt;
      if (this.FRC != null) {
        i = paramInt + f.a.a.a.lI(5, this.FRC.computeSize());
      }
      paramInt = i;
      if (this.FWz != null) {
        paramInt = i + f.a.a.a.lI(6, this.FWz.computeSize());
      }
      AppMethodBeat.o(155403);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155403);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agj localagj = (agj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155403);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 2: 
          localagj.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155403);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new px();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((px)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagj.FWy = ((px)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagj.FWx = ((bpj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagj.FRC = ((dfb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagj.FWz = ((ccw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      AppMethodBeat.o(155403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agj
 * JD-Core Version:    0.7.0.1
 */