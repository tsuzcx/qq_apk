package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cym
  extends cvw
{
  public int GuE;
  public String HIE;
  public String HIF;
  public b HIG;
  public int HqJ;
  public LinkedList<String> HqK;
  public String dwb;
  public String state;
  
  public cym()
  {
    AppMethodBeat.i(82470);
    this.HqK = new LinkedList();
    AppMethodBeat.o(82470);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HqJ);
      paramVarArgs.e(4, 1, this.HqK);
      if (this.dwb != null) {
        paramVarArgs.d(5, this.dwb);
      }
      if (this.state != null) {
        paramVarArgs.d(6, this.state);
      }
      if (this.HIE != null) {
        paramVarArgs.d(7, this.HIE);
      }
      paramVarArgs.aS(8, this.GuE);
      if (this.HIF != null) {
        paramVarArgs.d(14, this.HIF);
      }
      if (this.HIG != null) {
        paramVarArgs.c(15, this.HIG);
      }
      AppMethodBeat.o(82471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(3, this.HqJ) + f.a.a.a.c(4, 1, this.HqK);
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dwb);
      }
      i = paramInt;
      if (this.state != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.state);
      }
      paramInt = i;
      if (this.HIE != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HIE);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.GuE);
      paramInt = i;
      if (this.HIF != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HIF);
      }
      i = paramInt;
      if (this.HIG != null) {
        i = paramInt + f.a.a.b.b.a.b(15, this.HIG);
      }
      AppMethodBeat.o(82471);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HqK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cym localcym = (cym)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(82471);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcym.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82471);
          return 0;
        case 3: 
          localcym.HqJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(82471);
          return 0;
        case 4: 
          localcym.HqK.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(82471);
          return 0;
        case 5: 
          localcym.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 6: 
          localcym.state = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 7: 
          localcym.HIE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 8: 
          localcym.GuE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(82471);
          return 0;
        case 14: 
          localcym.HIF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82471);
          return 0;
        }
        localcym.HIG = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(82471);
        return 0;
      }
      AppMethodBeat.o(82471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cym
 * JD-Core Version:    0.7.0.1
 */