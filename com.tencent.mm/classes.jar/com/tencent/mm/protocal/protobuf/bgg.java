package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgg
  extends cvw
{
  public String GUN;
  public int GUO;
  public LinkedList<cxn> GUP;
  public int GUQ;
  public String uvT;
  
  public bgg()
  {
    AppMethodBeat.i(91494);
    this.GUP = new LinkedList();
    AppMethodBeat.o(91494);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91495);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GUN != null) {
        paramVarArgs.d(2, this.GUN);
      }
      paramVarArgs.aS(3, this.GUO);
      paramVarArgs.e(4, 8, this.GUP);
      if (this.uvT != null) {
        paramVarArgs.d(5, this.uvT);
      }
      paramVarArgs.aS(6, this.GUQ);
      AppMethodBeat.o(91495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GUN != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GUN);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GUO) + f.a.a.a.c(4, 8, this.GUP);
      paramInt = i;
      if (this.uvT != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.uvT);
      }
      i = f.a.a.b.b.a.bz(6, this.GUQ);
      AppMethodBeat.o(91495);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GUP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91495);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgg localbgg = (bgg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91495);
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
            localbgg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 2: 
          localbgg.GUN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91495);
          return 0;
        case 3: 
          localbgg.GUO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91495);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgg.GUP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 5: 
          localbgg.uvT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91495);
          return 0;
        }
        localbgg.GUQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91495);
        return 0;
      }
      AppMethodBeat.o(91495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgg
 * JD-Core Version:    0.7.0.1
 */