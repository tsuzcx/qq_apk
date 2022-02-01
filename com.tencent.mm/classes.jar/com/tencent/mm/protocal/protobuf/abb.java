package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abb
  extends cvc
{
  public String FzJ;
  public String Gax;
  public String Gay;
  public String iht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gax == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceId");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.FzJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.Gay == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientInfo");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.iht == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gax != null) {
        paramVarArgs.d(2, this.Gax);
      }
      if (this.FzJ != null) {
        paramVarArgs.d(3, this.FzJ);
      }
      if (this.Gay != null) {
        paramVarArgs.d(4, this.Gay);
      }
      if (this.iht != null) {
        paramVarArgs.d(5, this.iht);
      }
      AppMethodBeat.o(32172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label761;
      }
    }
    label761:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gax != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gax);
      }
      i = paramInt;
      if (this.FzJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FzJ);
      }
      paramInt = i;
      if (this.Gay != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gay);
      }
      i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iht);
      }
      AppMethodBeat.o(32172);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gax == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceId");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.FzJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.Gay == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientInfo");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.iht == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32172);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abb localabb = (abb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32172);
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
            localabb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32172);
          return 0;
        case 2: 
          localabb.Gax = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32172);
          return 0;
        case 3: 
          localabb.FzJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32172);
          return 0;
        case 4: 
          localabb.Gay = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32172);
          return 0;
        }
        localabb.iht = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32172);
        return 0;
      }
      AppMethodBeat.o(32172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abb
 * JD-Core Version:    0.7.0.1
 */