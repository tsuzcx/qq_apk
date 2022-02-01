package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abk
  extends cvw
{
  public String FSh;
  public String Gte;
  public String Gtf;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gte == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceId");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.FSh == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.Gtf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientInfo");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.ikm == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gte != null) {
        paramVarArgs.d(2, this.Gte);
      }
      if (this.FSh != null) {
        paramVarArgs.d(3, this.FSh);
      }
      if (this.Gtf != null) {
        paramVarArgs.d(4, this.Gtf);
      }
      if (this.ikm != null) {
        paramVarArgs.d(5, this.ikm);
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
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gte != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gte);
      }
      i = paramInt;
      if (this.FSh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FSh);
      }
      paramInt = i;
      if (this.Gtf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gtf);
      }
      i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ikm);
      }
      AppMethodBeat.o(32172);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gte == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceId");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.FSh == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.Gtf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientInfo");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.ikm == null)
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
        abk localabk = (abk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32172);
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
            localabk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32172);
          return 0;
        case 2: 
          localabk.Gte = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32172);
          return 0;
        case 3: 
          localabk.FSh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32172);
          return 0;
        case 4: 
          localabk.Gtf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32172);
          return 0;
        }
        localabk.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32172);
        return 0;
      }
      AppMethodBeat.o(32172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abk
 * JD-Core Version:    0.7.0.1
 */