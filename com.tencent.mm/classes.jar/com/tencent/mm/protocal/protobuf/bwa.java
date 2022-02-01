package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bwa
  extends dyy
{
  public cim SkR;
  public cux TdF;
  public st TfL;
  public cik TfM;
  public cka TfN;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72489);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72489);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      if (this.SkR != null)
      {
        paramVarArgs.oE(4, this.SkR.computeSize());
        this.SkR.writeFields(paramVarArgs);
      }
      if (this.TfL != null)
      {
        paramVarArgs.oE(8, this.TfL.computeSize());
        this.TfL.writeFields(paramVarArgs);
      }
      if (this.TdF != null)
      {
        paramVarArgs.oE(9, this.TdF.computeSize());
        this.TdF.writeFields(paramVarArgs);
      }
      if (this.TfM != null)
      {
        paramVarArgs.oE(10, this.TfM.computeSize());
        this.TfM.writeFields(paramVarArgs);
      }
      if (this.TfN != null)
      {
        paramVarArgs.oE(11, this.TfN.computeSize());
        this.TfN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1122;
      }
    }
    label1122:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.SkR != null) {
        i = paramInt + g.a.a.a.oD(4, this.SkR.computeSize());
      }
      paramInt = i;
      if (this.TfL != null) {
        paramInt = i + g.a.a.a.oD(8, this.TfL.computeSize());
      }
      i = paramInt;
      if (this.TdF != null) {
        i = paramInt + g.a.a.a.oD(9, this.TdF.computeSize());
      }
      paramInt = i;
      if (this.TfM != null) {
        paramInt = i + g.a.a.a.oD(10, this.TfM.computeSize());
      }
      i = paramInt;
      if (this.TfN != null) {
        i = paramInt + g.a.a.a.oD(11, this.TfN.computeSize());
      }
      AppMethodBeat.o(72489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72489);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwa localbwa = (bwa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        default: 
          AppMethodBeat.o(72489);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbwa.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 2: 
          localbwa.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72489);
          return 0;
        case 3: 
          localbwa.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72489);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cim();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cim)localObject2).parseFrom((byte[])localObject1);
            }
            localbwa.SkR = ((cim)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new st();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((st)localObject2).parseFrom((byte[])localObject1);
            }
            localbwa.TfL = ((st)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cux();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cux)localObject2).parseFrom((byte[])localObject1);
            }
            localbwa.TdF = ((cux)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cik();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cik)localObject2).parseFrom((byte[])localObject1);
            }
            localbwa.TfM = ((cik)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cka();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cka)localObject2).parseFrom((byte[])localObject1);
          }
          localbwa.TfN = ((cka)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72489);
        return 0;
      }
      AppMethodBeat.o(72489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwa
 * JD-Core Version:    0.7.0.1
 */