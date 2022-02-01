package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtm
  extends cvw
{
  public SKBuiltinBuffer_t FSj;
  public int GSk;
  public String HZe;
  public String nIJ;
  public int xsB;
  public int xsC;
  public SKBuiltinBuffer_t xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152717);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152717);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xsB);
      paramVarArgs.aS(3, this.xsC);
      paramVarArgs.aS(4, this.GSk);
      if (this.xsE != null)
      {
        paramVarArgs.lJ(5, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      if (this.HZe != null) {
        paramVarArgs.d(6, this.HZe);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(7, this.nIJ);
      }
      if (this.FSj != null)
      {
        paramVarArgs.lJ(8, this.FSj.computeSize());
        this.FSj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xsB) + f.a.a.b.b.a.bz(3, this.xsC) + f.a.a.b.b.a.bz(4, this.GSk);
      paramInt = i;
      if (this.xsE != null) {
        paramInt = i + f.a.a.a.lI(5, this.xsE.computeSize());
      }
      i = paramInt;
      if (this.HZe != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HZe);
      }
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nIJ);
      }
      i = paramInt;
      if (this.FSj != null) {
        i = paramInt + f.a.a.a.lI(8, this.FSj.computeSize());
      }
      AppMethodBeat.o(152717);
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
          AppMethodBeat.o(152717);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152717);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtm localdtm = (dtm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152717);
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
            localdtm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152717);
          return 0;
        case 2: 
          localdtm.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152717);
          return 0;
        case 3: 
          localdtm.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152717);
          return 0;
        case 4: 
          localdtm.GSk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152717);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtm.xsE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152717);
          return 0;
        case 6: 
          localdtm.HZe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152717);
          return 0;
        case 7: 
          localdtm.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152717);
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
          localdtm.FSj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152717);
        return 0;
      }
      AppMethodBeat.o(152717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtm
 * JD-Core Version:    0.7.0.1
 */