package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dll
  extends cvw
{
  public eip GZK;
  public eiq GZL;
  public eir GZM;
  public ekk HSQ;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50115);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.GZK != null)
      {
        paramVarArgs.lJ(3, this.GZK.computeSize());
        this.GZK.writeFields(paramVarArgs);
      }
      if (this.GZL != null)
      {
        paramVarArgs.lJ(6, this.GZL.computeSize());
        this.GZL.writeFields(paramVarArgs);
      }
      if (this.GZM != null)
      {
        paramVarArgs.lJ(7, this.GZM.computeSize());
        this.GZM.writeFields(paramVarArgs);
      }
      if (this.HSQ != null)
      {
        paramVarArgs.lJ(8, this.HSQ.computeSize());
        this.HSQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50115);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1002;
      }
    }
    label1002:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.GZK != null) {
        i = paramInt + f.a.a.a.lI(3, this.GZK.computeSize());
      }
      paramInt = i;
      if (this.GZL != null) {
        paramInt = i + f.a.a.a.lI(6, this.GZL.computeSize());
      }
      i = paramInt;
      if (this.GZM != null) {
        i = paramInt + f.a.a.a.lI(7, this.GZM.computeSize());
      }
      paramInt = i;
      if (this.HSQ != null) {
        paramInt = i + f.a.a.a.lI(8, this.HSQ.computeSize());
      }
      AppMethodBeat.o(50115);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(50115);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dll localdll = (dll)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        case 5: 
        default: 
          AppMethodBeat.o(50115);
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
            localdll.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50115);
          return 0;
        case 2: 
          localdll.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(50115);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdll.GZK = ((eip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50115);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdll.GZL = ((eiq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50115);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eir();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eir)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdll.GZM = ((eir)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50115);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ekk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ekk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdll.HSQ = ((ekk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50115);
        return 0;
      }
      AppMethodBeat.o(50115);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dll
 * JD-Core Version:    0.7.0.1
 */