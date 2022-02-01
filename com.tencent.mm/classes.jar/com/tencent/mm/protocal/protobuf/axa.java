package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axa
  extends cwj
{
  public LinkedList<String> GOw;
  public String GOx;
  public String prb;
  public String title;
  
  public axa()
  {
    AppMethodBeat.i(181502);
    this.GOw = new LinkedList();
    AppMethodBeat.o(181502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181503);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.prb != null) {
        paramVarArgs.d(2, this.prb);
      }
      paramVarArgs.e(3, 1, this.GOw);
      if (this.GOx != null) {
        paramVarArgs.d(4, this.GOx);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      AppMethodBeat.o(181503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.prb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.prb);
      }
      i += f.a.a.a.c(3, 1, this.GOw);
      paramInt = i;
      if (this.GOx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GOx);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      AppMethodBeat.o(181503);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GOw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(181503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axa localaxa = (axa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181503);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(181503);
          return 0;
        case 2: 
          localaxa.prb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(181503);
          return 0;
        case 3: 
          localaxa.GOw.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(181503);
          return 0;
        case 4: 
          localaxa.GOx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(181503);
          return 0;
        }
        localaxa.title = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(181503);
        return 0;
      }
      AppMethodBeat.o(181503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axa
 * JD-Core Version:    0.7.0.1
 */