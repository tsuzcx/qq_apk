package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asl
  extends cwj
{
  public LinkedList<FinderContact> GGk;
  public LinkedList<FinderContact> GHZ;
  public SKBuiltinBuffer_t GJB;
  public zy GJC;
  public int GJD;
  public int continueFlag;
  public LinkedList<ama> rjr;
  
  public asl()
  {
    AppMethodBeat.i(169062);
    this.GGk = new LinkedList();
    this.GHZ = new LinkedList();
    this.rjr = new LinkedList();
    AppMethodBeat.o(169062);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169063);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GJC != null)
      {
        paramVarArgs.lJ(2, this.GJC.computeSize());
        this.GJC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.continueFlag);
      if (this.GJB != null)
      {
        paramVarArgs.lJ(4, this.GJB.computeSize());
        this.GJB.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.GGk);
      paramVarArgs.e(6, 8, this.GHZ);
      paramVarArgs.e(7, 8, this.rjr);
      paramVarArgs.aS(8, this.GJD);
      AppMethodBeat.o(169063);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1138;
      }
    }
    label1138:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GJC != null) {
        i = paramInt + f.a.a.a.lI(2, this.GJC.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.continueFlag);
      paramInt = i;
      if (this.GJB != null) {
        paramInt = i + f.a.a.a.lI(4, this.GJB.computeSize());
      }
      i = f.a.a.a.c(5, 8, this.GGk);
      int j = f.a.a.a.c(6, 8, this.GHZ);
      int k = f.a.a.a.c(7, 8, this.rjr);
      int m = f.a.a.b.b.a.bz(8, this.GJD);
      AppMethodBeat.o(169063);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GGk.clear();
        this.GHZ.clear();
        this.rjr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169063);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asl localasl = (asl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169063);
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
            localasl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasl.GJC = ((zy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 3: 
          localasl.continueFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169063);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasl.GJB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasl.GGk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasl.GHZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ama();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ama)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasl.rjr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        }
        localasl.GJD = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169063);
        return 0;
      }
      AppMethodBeat.o(169063);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asl
 * JD-Core Version:    0.7.0.1
 */