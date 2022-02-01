package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtc
  extends cvw
{
  public String GuS;
  public String hFO;
  public int xsB;
  public int xsC;
  public int xsD;
  public SKBuiltinBuffer_t xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90777);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(90777);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hFO != null) {
        paramVarArgs.d(2, this.hFO);
      }
      paramVarArgs.aS(3, this.xsB);
      paramVarArgs.aS(4, this.xsC);
      paramVarArgs.aS(5, this.xsD);
      if (this.xsE != null)
      {
        paramVarArgs.lJ(6, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      if (this.GuS != null) {
        paramVarArgs.d(7, this.GuS);
      }
      AppMethodBeat.o(90777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hFO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hFO);
      }
      i = i + f.a.a.b.b.a.bz(3, this.xsB) + f.a.a.b.b.a.bz(4, this.xsC) + f.a.a.b.b.a.bz(5, this.xsD);
      paramInt = i;
      if (this.xsE != null) {
        paramInt = i + f.a.a.a.lI(6, this.xsE.computeSize());
      }
      i = paramInt;
      if (this.GuS != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GuS);
      }
      AppMethodBeat.o(90777);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.xsE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(90777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(90777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtc localdtc = (dtc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90777);
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
            localdtc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        case 2: 
          localdtc.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(90777);
          return 0;
        case 3: 
          localdtc.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(90777);
          return 0;
        case 4: 
          localdtc.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(90777);
          return 0;
        case 5: 
          localdtc.xsD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(90777);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtc.xsE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        }
        localdtc.GuS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(90777);
        return 0;
      }
      AppMethodBeat.o(90777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtc
 * JD-Core Version:    0.7.0.1
 */