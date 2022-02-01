package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dju
  extends cvw
{
  public String FQl;
  public djs HRD;
  public djs HRE;
  public int HRF;
  public int HRG;
  public String hFO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HRD == null)
      {
        paramVarArgs = new b("Not all required fields were included: CommentDetail");
        AppMethodBeat.o(118439);
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
      if (this.HRD != null)
      {
        paramVarArgs.lJ(3, this.HRD.computeSize());
        this.HRD.writeFields(paramVarArgs);
      }
      if (this.HRE != null)
      {
        paramVarArgs.lJ(6, this.HRE.computeSize());
        this.HRE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.HRF);
      paramVarArgs.aS(5, this.HRG);
      if (this.FQl != null) {
        paramVarArgs.d(7, this.FQl);
      }
      AppMethodBeat.o(118439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hFO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hFO);
      }
      i = paramInt;
      if (this.HRD != null) {
        i = paramInt + f.a.a.a.lI(3, this.HRD.computeSize());
      }
      paramInt = i;
      if (this.HRE != null) {
        paramInt = i + f.a.a.a.lI(6, this.HRE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HRF) + f.a.a.b.b.a.bz(5, this.HRG);
      paramInt = i;
      if (this.FQl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FQl);
      }
      AppMethodBeat.o(118439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HRD == null)
        {
          paramVarArgs = new b("Not all required fields were included: CommentDetail");
          AppMethodBeat.o(118439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dju localdju = (dju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118439);
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
            localdju.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 2: 
          localdju.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118439);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdju.HRD = ((djs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdju.HRE = ((djs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 4: 
          localdju.HRF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118439);
          return 0;
        case 5: 
          localdju.HRG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118439);
          return 0;
        }
        localdju.FQl = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(118439);
        return 0;
      }
      AppMethodBeat.o(118439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dju
 * JD-Core Version:    0.7.0.1
 */