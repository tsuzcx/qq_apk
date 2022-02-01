package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dft
  extends cvw
{
  public cxn HMU;
  public dgc HMV;
  public cxn HMW;
  public int Scene;
  public String hFO;
  public int ucK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125762);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Action");
        AppMethodBeat.o(125762);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HMV != null)
      {
        paramVarArgs.lJ(2, this.HMV.computeSize());
        this.HMV.writeFields(paramVarArgs);
      }
      if (this.hFO != null) {
        paramVarArgs.d(3, this.hFO);
      }
      if (this.HMU != null)
      {
        paramVarArgs.lJ(4, this.HMU.computeSize());
        this.HMU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.ucK);
      if (this.HMW != null)
      {
        paramVarArgs.lJ(6, this.HMW.computeSize());
        this.HMW.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.Scene);
      AppMethodBeat.o(125762);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label974;
      }
    }
    label974:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HMV != null) {
        paramInt = i + f.a.a.a.lI(2, this.HMV.computeSize());
      }
      i = paramInt;
      if (this.hFO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hFO);
      }
      paramInt = i;
      if (this.HMU != null) {
        paramInt = i + f.a.a.a.lI(4, this.HMU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.ucK);
      paramInt = i;
      if (this.HMW != null) {
        paramInt = i + f.a.a.a.lI(6, this.HMW.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.Scene);
      AppMethodBeat.o(125762);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HMV == null)
        {
          paramVarArgs = new b("Not all required fields were included: Action");
          AppMethodBeat.o(125762);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125762);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dft localdft = (dft)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125762);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdft.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdft.HMV = ((dgc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        case 3: 
          localdft.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125762);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdft.HMU = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        case 5: 
          localdft.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125762);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdft.HMW = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125762);
          return 0;
        }
        localdft.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125762);
        return 0;
      }
      AppMethodBeat.o(125762);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dft
 * JD-Core Version:    0.7.0.1
 */