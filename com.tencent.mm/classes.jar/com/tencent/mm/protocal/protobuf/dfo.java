package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dfo
  extends ckq
{
  public String CIJ;
  public String CIQ;
  public mg EwT;
  public mg EwU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124570);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CIQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124570);
        throw paramVarArgs;
      }
      if (this.CIJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_id");
        AppMethodBeat.o(124570);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CIQ != null) {
        paramVarArgs.d(2, this.CIQ);
      }
      if (this.CIJ != null) {
        paramVarArgs.d(3, this.CIJ);
      }
      if (this.EwT != null)
      {
        paramVarArgs.kX(4, this.EwT.computeSize());
        this.EwT.writeFields(paramVarArgs);
      }
      if (this.EwU != null)
      {
        paramVarArgs.kX(5, this.EwU.computeSize());
        this.EwU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CIQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CIQ);
      }
      i = paramInt;
      if (this.CIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CIJ);
      }
      paramInt = i;
      if (this.EwT != null) {
        paramInt = i + f.a.a.a.kW(4, this.EwT.computeSize());
      }
      i = paramInt;
      if (this.EwU != null) {
        i = paramInt + f.a.a.a.kW(5, this.EwU.computeSize());
      }
      AppMethodBeat.o(124570);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CIQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124570);
          throw paramVarArgs;
        }
        if (this.CIJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_id");
          AppMethodBeat.o(124570);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfo localdfo = (dfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124570);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfo.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124570);
          return 0;
        case 2: 
          localdfo.CIQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124570);
          return 0;
        case 3: 
          localdfo.CIJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124570);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfo.EwT = ((mg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124570);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfo.EwU = ((mg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124570);
        return 0;
      }
      AppMethodBeat.o(124570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfo
 * JD-Core Version:    0.7.0.1
 */