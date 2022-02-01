package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayz
  extends cvw
{
  public String FJN;
  public String FJO;
  public int FJP;
  public diy FJR;
  public String GPt;
  public String dJb;
  public String dJc;
  public int dJd;
  public String oBM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114010);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dJb == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(114010);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dJb != null) {
        paramVarArgs.d(2, this.dJb);
      }
      paramVarArgs.aS(3, this.dJd);
      if (this.oBM != null) {
        paramVarArgs.d(4, this.oBM);
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
      if (this.GPt != null) {
        paramVarArgs.d(9, this.GPt);
      }
      if (this.FJR != null)
      {
        paramVarArgs.lJ(10, this.FJR.computeSize());
        this.FJR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114010);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dJb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dJb);
      }
      i += f.a.a.b.b.a.bz(3, this.dJd);
      paramInt = i;
      if (this.oBM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oBM);
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
      i += f.a.a.b.b.a.bz(8, this.FJP);
      paramInt = i;
      if (this.GPt != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GPt);
      }
      i = paramInt;
      if (this.FJR != null) {
        i = paramInt + f.a.a.a.lI(10, this.FJR.computeSize());
      }
      AppMethodBeat.o(114010);
      return i;
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
          AppMethodBeat.o(114010);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114010);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayz localayz = (ayz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114010);
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
            localayz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114010);
          return 0;
        case 2: 
          localayz.dJb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 3: 
          localayz.dJd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114010);
          return 0;
        case 4: 
          localayz.oBM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 5: 
          localayz.dJc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 6: 
          localayz.FJN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 7: 
          localayz.FJO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 8: 
          localayz.FJP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114010);
          return 0;
        case 9: 
          localayz.GPt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114010);
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
          localayz.FJR = ((diy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114010);
        return 0;
      }
      AppMethodBeat.o(114010);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayz
 * JD-Core Version:    0.7.0.1
 */