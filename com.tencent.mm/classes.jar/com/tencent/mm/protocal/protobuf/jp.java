package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jp
  extends cvw
{
  public LinkedList<String> FUN;
  public LinkedList<cvu> FUO;
  public long FUP;
  public int FUQ;
  public int FUR;
  public String oxI;
  
  public jp()
  {
    AppMethodBeat.i(6394);
    this.FUN = new LinkedList();
    this.FUO = new LinkedList();
    AppMethodBeat.o(6394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.FUN);
      paramVarArgs.e(3, 8, this.FUO);
      if (this.oxI != null) {
        paramVarArgs.d(4, this.oxI);
      }
      paramVarArgs.aZ(5, this.FUP);
      paramVarArgs.aS(6, this.FUQ);
      paramVarArgs.aS(7, this.FUR);
      AppMethodBeat.o(6395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label719;
      }
    }
    label719:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.FUN) + f.a.a.a.c(3, 8, this.FUO);
      paramInt = i;
      if (this.oxI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oxI);
      }
      i = f.a.a.b.b.a.p(5, this.FUP);
      int j = f.a.a.b.b.a.bz(6, this.FUQ);
      int k = f.a.a.b.b.a.bz(7, this.FUR);
      AppMethodBeat.o(6395);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUN.clear();
        this.FUO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(6395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        jp localjp = (jp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6395);
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
            localjp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 2: 
          localjp.FUN.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(6395);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localjp.FUO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 4: 
          localjp.oxI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(6395);
          return 0;
        case 5: 
          localjp.FUP = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(6395);
          return 0;
        case 6: 
          localjp.FUQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6395);
          return 0;
        }
        localjp.FUR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(6395);
        return 0;
      }
      AppMethodBeat.o(6395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jp
 * JD-Core Version:    0.7.0.1
 */