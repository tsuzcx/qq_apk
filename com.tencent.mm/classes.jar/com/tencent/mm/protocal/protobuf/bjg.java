package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjg
  extends cvw
{
  public String GWQ;
  public String GWR;
  public int oGc;
  public String zMk;
  public String zot;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218303);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGc);
      if (this.GWQ != null) {
        paramVarArgs.d(3, this.GWQ);
      }
      if (this.zMk != null) {
        paramVarArgs.d(4, this.zMk);
      }
      if (this.GWR != null) {
        paramVarArgs.d(5, this.GWR);
      }
      if (this.zot != null) {
        paramVarArgs.d(6, this.zot);
      }
      AppMethodBeat.o(218303);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGc);
      paramInt = i;
      if (this.GWQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GWQ);
      }
      i = paramInt;
      if (this.zMk != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.zMk);
      }
      paramInt = i;
      if (this.GWR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GWR);
      }
      i = paramInt;
      if (this.zot != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.zot);
      }
      AppMethodBeat.o(218303);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218303);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjg localbjg = (bjg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218303);
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
            localbjg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218303);
          return 0;
        case 2: 
          localbjg.oGc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218303);
          return 0;
        case 3: 
          localbjg.GWQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218303);
          return 0;
        case 4: 
          localbjg.zMk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218303);
          return 0;
        case 5: 
          localbjg.GWR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218303);
          return 0;
        }
        localbjg.zot = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(218303);
        return 0;
      }
      AppMethodBeat.o(218303);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjg
 * JD-Core Version:    0.7.0.1
 */