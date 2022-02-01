package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ak
  extends cvw
{
  public String FJN;
  public String FJO;
  public int FJP;
  public int FJQ;
  public diy FJR;
  public String dJb;
  public String dJc;
  public int dJd;
  public String oBM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113922);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dJb == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(113922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oBM != null) {
        paramVarArgs.d(2, this.oBM);
      }
      paramVarArgs.aS(3, this.dJd);
      if (this.dJb != null) {
        paramVarArgs.d(4, this.dJb);
      }
      if (this.dJc != null) {
        paramVarArgs.d(5, this.dJc);
      }
      if (this.FJN != null) {
        paramVarArgs.d(6, this.FJN);
      }
      if (this.FJO != null) {
        paramVarArgs.d(7, this.FJO);
      }
      paramVarArgs.aS(8, this.FJP);
      paramVarArgs.aS(9, this.FJQ);
      if (this.FJR != null)
      {
        paramVarArgs.lJ(10, this.FJR.computeSize());
        this.FJR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oBM != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oBM);
      }
      i += f.a.a.b.b.a.bz(3, this.dJd);
      paramInt = i;
      if (this.dJb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dJb);
      }
      i = paramInt;
      if (this.dJc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dJc);
      }
      paramInt = i;
      if (this.FJN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FJN);
      }
      i = paramInt;
      if (this.FJO != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FJO);
      }
      i = i + f.a.a.b.b.a.bz(8, this.FJP) + f.a.a.b.b.a.bz(9, this.FJQ);
      paramInt = i;
      if (this.FJR != null) {
        paramInt = i + f.a.a.a.lI(10, this.FJR.computeSize());
      }
      AppMethodBeat.o(113922);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.dJb == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(113922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113922);
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
            localak.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113922);
          return 0;
        case 2: 
          localak.oBM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 3: 
          localak.dJd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113922);
          return 0;
        case 4: 
          localak.dJb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 5: 
          localak.dJc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 6: 
          localak.FJN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 7: 
          localak.FJO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 8: 
          localak.FJP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113922);
          return 0;
        case 9: 
          localak.FJQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113922);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new diy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((diy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localak.FJR = ((diy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      AppMethodBeat.o(113922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ak
 * JD-Core Version:    0.7.0.1
 */