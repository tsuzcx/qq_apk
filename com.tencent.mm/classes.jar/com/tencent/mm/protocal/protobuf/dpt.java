package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpt
  extends cvw
{
  public String FSh;
  public String Gte;
  public bpm HWP;
  public int HWQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gte != null) {
        paramVarArgs.d(2, this.Gte);
      }
      if (this.FSh != null) {
        paramVarArgs.d(3, this.FSh);
      }
      if (this.HWP != null)
      {
        paramVarArgs.lJ(4, this.HWP.computeSize());
        this.HWP.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.HWQ);
      AppMethodBeat.o(32471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label641;
      }
    }
    label641:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gte != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gte);
      }
      i = paramInt;
      if (this.FSh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FSh);
      }
      paramInt = i;
      if (this.HWP != null) {
        paramInt = i + f.a.a.a.lI(4, this.HWP.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.HWQ);
      AppMethodBeat.o(32471);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpt localdpt = (dpt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32471);
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
            localdpt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32471);
          return 0;
        case 2: 
          localdpt.Gte = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32471);
          return 0;
        case 3: 
          localdpt.FSh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32471);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpt.HWP = ((bpm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32471);
          return 0;
        }
        localdpt.HWQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32471);
        return 0;
      }
      AppMethodBeat.o(32471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpt
 * JD-Core Version:    0.7.0.1
 */