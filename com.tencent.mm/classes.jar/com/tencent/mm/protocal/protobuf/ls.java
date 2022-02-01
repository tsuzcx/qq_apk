package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ls
  extends cvw
{
  public SKBuiltinBuffer_t FUo;
  public int FWI;
  public String FWJ;
  public String FWK;
  public String FWL;
  public int FWM;
  public cxn FWN;
  public SKBuiltinBuffer_t FWO;
  public int FWP;
  public String FWj;
  public String FWk;
  public String FWw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155396);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FWI);
      if (this.FWw != null) {
        paramVarArgs.d(3, this.FWw);
      }
      if (this.FWJ != null) {
        paramVarArgs.d(4, this.FWJ);
      }
      if (this.FWK != null) {
        paramVarArgs.d(5, this.FWK);
      }
      if (this.FWL != null) {
        paramVarArgs.d(6, this.FWL);
      }
      paramVarArgs.aS(7, this.FWM);
      if (this.FWN != null)
      {
        paramVarArgs.lJ(8, this.FWN.computeSize());
        this.FWN.writeFields(paramVarArgs);
      }
      if (this.FWO != null)
      {
        paramVarArgs.lJ(9, this.FWO.computeSize());
        this.FWO.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.FWP);
      if (this.FWj != null) {
        paramVarArgs.d(11, this.FWj);
      }
      if (this.FWk != null) {
        paramVarArgs.d(12, this.FWk);
      }
      if (this.FUo != null)
      {
        paramVarArgs.lJ(13, this.FUo.computeSize());
        this.FUo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1282;
      }
    }
    label1282:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FWI);
      paramInt = i;
      if (this.FWw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FWw);
      }
      i = paramInt;
      if (this.FWJ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FWJ);
      }
      paramInt = i;
      if (this.FWK != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FWK);
      }
      i = paramInt;
      if (this.FWL != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FWL);
      }
      i += f.a.a.b.b.a.bz(7, this.FWM);
      paramInt = i;
      if (this.FWN != null) {
        paramInt = i + f.a.a.a.lI(8, this.FWN.computeSize());
      }
      i = paramInt;
      if (this.FWO != null) {
        i = paramInt + f.a.a.a.lI(9, this.FWO.computeSize());
      }
      i += f.a.a.b.b.a.bz(10, this.FWP);
      paramInt = i;
      if (this.FWj != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FWj);
      }
      i = paramInt;
      if (this.FWk != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FWk);
      }
      paramInt = i;
      if (this.FUo != null) {
        paramInt = i + f.a.a.a.lI(13, this.FUo.computeSize());
      }
      AppMethodBeat.o(155396);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ls localls = (ls)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155396);
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
            localls.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 2: 
          localls.FWI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155396);
          return 0;
        case 3: 
          localls.FWw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 4: 
          localls.FWJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 5: 
          localls.FWK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 6: 
          localls.FWL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 7: 
          localls.FWM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155396);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localls.FWN = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localls.FWO = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 10: 
          localls.FWP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155396);
          return 0;
        case 11: 
          localls.FWj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 12: 
          localls.FWk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155396);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localls.FUo = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      AppMethodBeat.o(155396);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ls
 * JD-Core Version:    0.7.0.1
 */