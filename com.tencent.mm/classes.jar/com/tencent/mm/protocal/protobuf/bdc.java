package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdc
  extends cvw
{
  public String FJg;
  public aey FJx;
  public String txG;
  public String txH;
  public String txI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32243);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.txG != null) {
        paramVarArgs.d(2, this.txG);
      }
      if (this.txH != null) {
        paramVarArgs.d(3, this.txH);
      }
      if (this.txI != null) {
        paramVarArgs.d(4, this.txI);
      }
      if (this.FJg != null) {
        paramVarArgs.d(5, this.FJg);
      }
      if (this.FJx != null)
      {
        paramVarArgs.lJ(6, this.FJx.computeSize());
        this.FJx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.txG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.txG);
      }
      i = paramInt;
      if (this.txH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.txH);
      }
      paramInt = i;
      if (this.txI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.txI);
      }
      i = paramInt;
      if (this.FJg != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FJg);
      }
      paramInt = i;
      if (this.FJx != null) {
        paramInt = i + f.a.a.a.lI(6, this.FJx.computeSize());
      }
      AppMethodBeat.o(32243);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdc localbdc = (bdc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32243);
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
            localbdc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32243);
          return 0;
        case 2: 
          localbdc.txG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 3: 
          localbdc.txH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 4: 
          localbdc.txI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 5: 
          localbdc.FJg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32243);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aey();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aey)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbdc.FJx = ((aey)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32243);
        return 0;
      }
      AppMethodBeat.o(32243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdc
 * JD-Core Version:    0.7.0.1
 */