package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhm
  extends cvw
{
  public String GVI;
  public String dzL;
  public String zQM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218301);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dzL != null) {
        paramVarArgs.d(2, this.dzL);
      }
      if (this.zQM != null) {
        paramVarArgs.d(3, this.zQM);
      }
      if (this.GVI != null) {
        paramVarArgs.d(4, this.GVI);
      }
      AppMethodBeat.o(218301);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dzL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dzL);
      }
      i = paramInt;
      if (this.zQM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.zQM);
      }
      paramInt = i;
      if (this.GVI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GVI);
      }
      AppMethodBeat.o(218301);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218301);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhm localbhm = (bhm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218301);
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
            localbhm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218301);
          return 0;
        case 2: 
          localbhm.dzL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218301);
          return 0;
        case 3: 
          localbhm.zQM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218301);
          return 0;
        }
        localbhm.GVI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(218301);
        return 0;
      }
      AppMethodBeat.o(218301);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhm
 * JD-Core Version:    0.7.0.1
 */