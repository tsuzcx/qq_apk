package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddi
  extends cvw
{
  public SKBuiltinBuffer_t FRs;
  public int HLc;
  public String qkE;
  public String xrf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.qkE != null) {
        paramVarArgs.d(2, this.qkE);
      }
      if (this.xrf != null) {
        paramVarArgs.d(3, this.xrf);
      }
      if (this.FRs != null)
      {
        paramVarArgs.lJ(4, this.FRs.computeSize());
        this.FRs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.HLc);
      AppMethodBeat.o(134257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qkE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qkE);
      }
      i = paramInt;
      if (this.xrf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xrf);
      }
      paramInt = i;
      if (this.FRs != null) {
        paramInt = i + f.a.a.a.lI(4, this.FRs.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.HLc);
      AppMethodBeat.o(134257);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(134257);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddi localddi = (ddi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134257);
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
            localddi.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        case 2: 
          localddi.qkE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 3: 
          localddi.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddi.FRs = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        }
        localddi.HLc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(134257);
        return 0;
      }
      AppMethodBeat.o(134257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddi
 * JD-Core Version:    0.7.0.1
 */