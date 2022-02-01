package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfx
  extends cvw
{
  public cty FOe;
  public SKBuiltinBuffer_t HNa;
  public SKBuiltinBuffer_t HNb;
  public int HNc;
  public long Id;
  public int Scene;
  public int ucK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125766);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.Id);
      paramVarArgs.aS(3, this.Scene);
      if (this.HNa != null)
      {
        paramVarArgs.lJ(4, this.HNa.computeSize());
        this.HNa.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.ucK);
      if (this.HNb != null)
      {
        paramVarArgs.lJ(6, this.HNb.computeSize());
        this.HNb.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.HNc);
      if (this.FOe != null)
      {
        paramVarArgs.lJ(8, this.FOe.computeSize());
        this.FOe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Id) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.HNa != null) {
        paramInt = i + f.a.a.a.lI(4, this.HNa.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.ucK);
      paramInt = i;
      if (this.HNb != null) {
        paramInt = i + f.a.a.a.lI(6, this.HNb.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.HNc);
      paramInt = i;
      if (this.FOe != null) {
        paramInt = i + f.a.a.a.lI(8, this.FOe.computeSize());
      }
      AppMethodBeat.o(125766);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfx localdfx = (dfx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125766);
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
            localdfx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 2: 
          localdfx.Id = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125766);
          return 0;
        case 3: 
          localdfx.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125766);
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
            localdfx.HNa = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 5: 
          localdfx.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125766);
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
            localdfx.HNb = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 7: 
          localdfx.HNc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125766);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cty();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cty)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfx.FOe = ((cty)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      AppMethodBeat.o(125766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfx
 * JD-Core Version:    0.7.0.1
 */