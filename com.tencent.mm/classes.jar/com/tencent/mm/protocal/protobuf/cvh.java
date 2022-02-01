package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvh
  extends cvw
{
  public ze GWq;
  public LinkedList<aht> HFJ;
  public int HFK;
  public int HFL;
  public LinkedList<za> HFM;
  public int HFN;
  public long cbe;
  
  public cvh()
  {
    AppMethodBeat.i(50105);
    this.HFJ = new LinkedList();
    this.HFM = new LinkedList();
    AppMethodBeat.o(50105);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50106);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.cbe);
      paramVarArgs.e(3, 8, this.HFJ);
      paramVarArgs.aS(5, this.HFK);
      paramVarArgs.aS(6, this.HFL);
      if (this.GWq != null)
      {
        paramVarArgs.lJ(7, this.GWq.computeSize());
        this.GWq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.HFM);
      paramVarArgs.aS(9, this.HFN);
      AppMethodBeat.o(50106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.cbe) + f.a.a.a.c(3, 8, this.HFJ) + f.a.a.b.b.a.bz(5, this.HFK) + f.a.a.b.b.a.bz(6, this.HFL);
      paramInt = i;
      if (this.GWq != null) {
        paramInt = i + f.a.a.a.lI(7, this.GWq.computeSize());
      }
      i = f.a.a.a.c(8, 8, this.HFM);
      int j = f.a.a.b.b.a.bz(9, this.HFN);
      AppMethodBeat.o(50106);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HFJ.clear();
        this.HFM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(50106);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvh localcvh = (cvh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        default: 
          AppMethodBeat.o(50106);
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
            localcvh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 2: 
          localcvh.cbe = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(50106);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvh.HFJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 5: 
          localcvh.HFK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(50106);
          return 0;
        case 6: 
          localcvh.HFL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(50106);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ze();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ze)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvh.GWq = ((ze)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new za();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((za)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvh.HFM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        }
        localcvh.HFN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(50106);
        return 0;
      }
      AppMethodBeat.o(50106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvh
 * JD-Core Version:    0.7.0.1
 */