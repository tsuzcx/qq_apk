package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bic
  extends cvw
{
  public int GWn;
  public int GWo;
  public ua GWp;
  public ze GWq;
  public int GWr;
  public long cbe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50089);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GWn);
      paramVarArgs.aS(3, this.GWo);
      if (this.GWp != null)
      {
        paramVarArgs.lJ(4, this.GWp.computeSize());
        this.GWp.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(5, this.cbe);
      if (this.GWq != null)
      {
        paramVarArgs.lJ(6, this.GWq.computeSize());
        this.GWq.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.GWr);
      AppMethodBeat.o(50089);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GWn) + f.a.a.b.b.a.bz(3, this.GWo);
      paramInt = i;
      if (this.GWp != null) {
        paramInt = i + f.a.a.a.lI(4, this.GWp.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.cbe);
      paramInt = i;
      if (this.GWq != null) {
        paramInt = i + f.a.a.a.lI(6, this.GWq.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.GWr);
      AppMethodBeat.o(50089);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(50089);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bic localbic = (bic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50089);
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
            localbic.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 2: 
          localbic.GWn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(50089);
          return 0;
        case 3: 
          localbic.GWo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(50089);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ua();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ua)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbic.GWp = ((ua)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 5: 
          localbic.cbe = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(50089);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ze();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ze)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbic.GWq = ((ze)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        }
        localbic.GWr = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(50089);
        return 0;
      }
      AppMethodBeat.o(50089);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bic
 * JD-Core Version:    0.7.0.1
 */