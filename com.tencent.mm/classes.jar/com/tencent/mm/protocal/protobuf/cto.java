package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cto
  extends cvw
{
  public SKBuiltinBuffer_t FWl;
  public String GOU;
  public long GOW;
  public String HEC;
  public String HED;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104375);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.GOW);
      if (this.HEC != null) {
        paramVarArgs.d(3, this.HEC);
      }
      if (this.HED != null) {
        paramVarArgs.d(4, this.HED);
      }
      if (this.GOU != null) {
        paramVarArgs.d(5, this.GOU);
      }
      if (this.FWl != null)
      {
        paramVarArgs.lJ(6, this.FWl.computeSize());
        this.FWl.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.Scene);
      AppMethodBeat.o(104375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GOW);
      paramInt = i;
      if (this.HEC != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HEC);
      }
      i = paramInt;
      if (this.HED != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HED);
      }
      paramInt = i;
      if (this.GOU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GOU);
      }
      i = paramInt;
      if (this.FWl != null) {
        i = paramInt + f.a.a.a.lI(6, this.FWl.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(7, this.Scene);
      AppMethodBeat.o(104375);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cto localcto = (cto)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104375);
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
            localcto.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104375);
          return 0;
        case 2: 
          localcto.GOW = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(104375);
          return 0;
        case 3: 
          localcto.HEC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 4: 
          localcto.HED = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 5: 
          localcto.GOU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104375);
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
            localcto.FWl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104375);
          return 0;
        }
        localcto.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104375);
        return 0;
      }
      AppMethodBeat.o(104375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cto
 * JD-Core Version:    0.7.0.1
 */