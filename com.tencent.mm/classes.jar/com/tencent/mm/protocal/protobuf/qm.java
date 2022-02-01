package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qm
  extends cvw
{
  public dk GdN;
  public int GeH;
  public dok Gej;
  public String Gek;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91381);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gej == null)
      {
        paramVarArgs = new b("Not all required fields were included: tock_mess");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.GdN == null)
      {
        paramVarArgs = new b("Not all required fields were included: after_placeorder_comm_req");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.token == null)
      {
        paramVarArgs = new b("Not all required fields were included: token");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gej != null)
      {
        paramVarArgs.lJ(2, this.Gej.computeSize());
        this.Gej.writeFields(paramVarArgs);
      }
      if (this.GdN != null)
      {
        paramVarArgs.lJ(3, this.GdN.computeSize());
        this.GdN.writeFields(paramVarArgs);
      }
      if (this.Gek != null) {
        paramVarArgs.d(4, this.Gek);
      }
      paramVarArgs.aS(5, this.GeH);
      if (this.token != null) {
        paramVarArgs.d(6, this.token);
      }
      AppMethodBeat.o(91381);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label930;
      }
    }
    label930:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gej != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gej.computeSize());
      }
      i = paramInt;
      if (this.GdN != null) {
        i = paramInt + f.a.a.a.lI(3, this.GdN.computeSize());
      }
      paramInt = i;
      if (this.Gek != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gek);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GeH);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.token);
      }
      AppMethodBeat.o(91381);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gej == null)
        {
          paramVarArgs = new b("Not all required fields were included: tock_mess");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        if (this.GdN == null)
        {
          paramVarArgs = new b("Not all required fields were included: after_placeorder_comm_req");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        if (this.token == null)
        {
          paramVarArgs = new b("Not all required fields were included: token");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91381);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qm localqm = (qm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91381);
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
            localqm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dok();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dok)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqm.Gej = ((dok)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqm.GdN = ((dk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 4: 
          localqm.Gek = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91381);
          return 0;
        case 5: 
          localqm.GeH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91381);
          return 0;
        }
        localqm.token = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91381);
        return 0;
      }
      AppMethodBeat.o(91381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qm
 * JD-Core Version:    0.7.0.1
 */