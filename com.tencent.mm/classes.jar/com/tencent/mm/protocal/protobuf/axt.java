package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axt
  extends cvc
{
  public String CWf;
  public String FKT;
  public String GaY;
  public String GvH;
  public String GvI;
  public String oIw;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GaY == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.GvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: group_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.CWf == null)
      {
        paramVarArgs = new b("Not all required fields were included: time_stamp");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.oIw == null)
      {
        paramVarArgs = new b("Not all required fields were included: nonce_str");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.signature == null)
      {
        paramVarArgs = new b("Not all required fields were included: signature");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.FKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: from_url");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GaY != null) {
        paramVarArgs.d(2, this.GaY);
      }
      if (this.GvH != null) {
        paramVarArgs.d(3, this.GvH);
      }
      if (this.CWf != null) {
        paramVarArgs.d(4, this.CWf);
      }
      if (this.oIw != null) {
        paramVarArgs.d(5, this.oIw);
      }
      if (this.signature != null) {
        paramVarArgs.d(6, this.signature);
      }
      if (this.FKT != null) {
        paramVarArgs.d(7, this.FKT);
      }
      if (this.GvI != null) {
        paramVarArgs.d(8, this.GvI);
      }
      AppMethodBeat.o(124506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GaY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GaY);
      }
      i = paramInt;
      if (this.GvH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GvH);
      }
      paramInt = i;
      if (this.CWf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CWf);
      }
      i = paramInt;
      if (this.oIw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oIw);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.signature);
      }
      i = paramInt;
      if (this.FKT != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FKT);
      }
      paramInt = i;
      if (this.GvI != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GvI);
      }
      AppMethodBeat.o(124506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GaY == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.GvH == null)
        {
          paramVarArgs = new b("Not all required fields were included: group_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.CWf == null)
        {
          paramVarArgs = new b("Not all required fields were included: time_stamp");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.oIw == null)
        {
          paramVarArgs = new b("Not all required fields were included: nonce_str");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.signature == null)
        {
          paramVarArgs = new b("Not all required fields were included: signature");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.FKT == null)
        {
          paramVarArgs = new b("Not all required fields were included: from_url");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axt localaxt = (axt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124506);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124506);
          return 0;
        case 2: 
          localaxt.GaY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 3: 
          localaxt.GvH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 4: 
          localaxt.CWf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 5: 
          localaxt.oIw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 6: 
          localaxt.signature = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 7: 
          localaxt.FKT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124506);
          return 0;
        }
        localaxt.GvI = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124506);
        return 0;
      }
      AppMethodBeat.o(124506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axt
 * JD-Core Version:    0.7.0.1
 */