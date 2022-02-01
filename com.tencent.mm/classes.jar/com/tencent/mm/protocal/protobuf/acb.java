package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class acb
  extends cvw
{
  public LinkedList<bzm> FNl;
  public cxn GtV;
  public SKBuiltinBuffer_t GtW;
  public String GtX;
  public int Scene;
  public int fNf;
  public String ikm;
  
  public acb()
  {
    AppMethodBeat.i(101797);
    this.FNl = new LinkedList();
    AppMethodBeat.o(101797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101798);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GtV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101798);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GtV != null)
      {
        paramVarArgs.lJ(2, this.GtV.computeSize());
        this.GtV.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.fNf);
      paramVarArgs.e(4, 8, this.FNl);
      paramVarArgs.aS(5, this.Scene);
      if (this.GtW != null)
      {
        paramVarArgs.lJ(6, this.GtW.computeSize());
        this.GtW.writeFields(paramVarArgs);
      }
      if (this.GtX != null) {
        paramVarArgs.d(7, this.GtX);
      }
      if (this.ikm != null) {
        paramVarArgs.d(8, this.ikm);
      }
      AppMethodBeat.o(101798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1018;
      }
    }
    label1018:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GtV != null) {
        i = paramInt + f.a.a.a.lI(2, this.GtV.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.fNf) + f.a.a.a.c(4, 8, this.FNl) + f.a.a.b.b.a.bz(5, this.Scene);
      paramInt = i;
      if (this.GtW != null) {
        paramInt = i + f.a.a.a.lI(6, this.GtW.computeSize());
      }
      i = paramInt;
      if (this.GtX != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GtX);
      }
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ikm);
      }
      AppMethodBeat.o(101798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FNl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GtV == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(101798);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101798);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acb localacb = (acb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101798);
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
            localacb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacb.GtV = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 3: 
          localacb.fNf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101798);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacb.FNl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 5: 
          localacb.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101798);
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
            localacb.GtW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 7: 
          localacb.GtX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101798);
          return 0;
        }
        localacb.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(101798);
        return 0;
      }
      AppMethodBeat.o(101798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acb
 * JD-Core Version:    0.7.0.1
 */