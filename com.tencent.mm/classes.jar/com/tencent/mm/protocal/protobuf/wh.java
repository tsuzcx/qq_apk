package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wh
  extends cvw
{
  public String Goc;
  public String God;
  public String dlT;
  public String uVs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Goc != null) {
        paramVarArgs.d(2, this.Goc);
      }
      if (this.God != null) {
        paramVarArgs.d(3, this.God);
      }
      if (this.uVs != null) {
        paramVarArgs.d(4, this.uVs);
      }
      if (this.dlT != null) {
        paramVarArgs.d(5, this.dlT);
      }
      AppMethodBeat.o(72452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Goc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Goc);
      }
      i = paramInt;
      if (this.God != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.God);
      }
      paramInt = i;
      if (this.uVs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uVs);
      }
      i = paramInt;
      if (this.dlT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dlT);
      }
      AppMethodBeat.o(72452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wh localwh = (wh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72452);
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
            localwh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72452);
          return 0;
        case 2: 
          localwh.Goc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 3: 
          localwh.God = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 4: 
          localwh.uVs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72452);
          return 0;
        }
        localwh.dlT = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72452);
        return 0;
      }
      AppMethodBeat.o(72452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wh
 * JD-Core Version:    0.7.0.1
 */