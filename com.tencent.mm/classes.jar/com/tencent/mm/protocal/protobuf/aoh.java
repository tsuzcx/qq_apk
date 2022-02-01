package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoh
  extends cqk
{
  public LinkedList<FinderContact> EEY;
  public LinkedList<FinderContact> EGm;
  public SKBuiltinBuffer_t EHs;
  public xw EHt;
  public int EHu;
  public int continueFlag;
  public LinkedList<aiy> qrS;
  
  public aoh()
  {
    AppMethodBeat.i(169062);
    this.EEY = new LinkedList();
    this.EGm = new LinkedList();
    this.qrS = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EHt != null)
      {
        paramVarArgs.ln(2, this.EHt.computeSize());
        this.EHt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.continueFlag);
      if (this.EHs != null)
      {
        paramVarArgs.ln(4, this.EHs.computeSize());
        this.EHs.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.EEY);
      paramVarArgs.e(6, 8, this.EGm);
      paramVarArgs.e(7, 8, this.qrS);
      paramVarArgs.aR(8, this.EHu);
      AppMethodBeat.o(169063);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1138;
      }
    }
    label1138:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EHt != null) {
        i = paramInt + f.a.a.a.lm(2, this.EHt.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.continueFlag);
      paramInt = i;
      if (this.EHs != null) {
        paramInt = i + f.a.a.a.lm(4, this.EHs.computeSize());
      }
      i = f.a.a.a.c(5, 8, this.EEY);
      int j = f.a.a.a.c(6, 8, this.EGm);
      int k = f.a.a.a.c(7, 8, this.qrS);
      int m = f.a.a.b.b.a.bx(8, this.EHu);
      AppMethodBeat.o(169063);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EEY.clear();
        this.EGm.clear();
        this.qrS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169063);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoh localaoh = (aoh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169063);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoh.EHt = ((xw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 3: 
          localaoh.continueFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169063);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoh.EHs = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoh.EEY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoh.EGm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoh.qrS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        }
        localaoh.EHu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169063);
        return 0;
      }
      AppMethodBeat.o(169063);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoh
 * JD-Core Version:    0.7.0.1
 */