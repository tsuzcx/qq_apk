package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cup
  extends cvw
{
  public aez GRx;
  public LinkedList<ahw> HFr;
  public long qwd;
  public long qwe;
  
  public cup()
  {
    AppMethodBeat.i(196281);
    this.HFr = new LinkedList();
    AppMethodBeat.o(196281);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196282);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GRx == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(196282);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.qwd);
      paramVarArgs.aZ(3, this.qwe);
      paramVarArgs.e(4, 8, this.HFr);
      if (this.GRx != null)
      {
        paramVarArgs.lJ(5, this.GRx.computeSize());
        this.GRx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(196282);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.qwd) + f.a.a.b.b.a.p(3, this.qwe) + f.a.a.a.c(4, 8, this.HFr);
      paramInt = i;
      if (this.GRx != null) {
        paramInt = i + f.a.a.a.lI(5, this.GRx.computeSize());
      }
      AppMethodBeat.o(196282);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HFr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GRx == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(196282);
          throw paramVarArgs;
        }
        AppMethodBeat.o(196282);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cup localcup = (cup)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196282);
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
            localcup.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196282);
          return 0;
        case 2: 
          localcup.qwd = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(196282);
          return 0;
        case 3: 
          localcup.qwe = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(196282);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcup.HFr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196282);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aez();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aez)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcup.GRx = ((aez)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(196282);
        return 0;
      }
      AppMethodBeat.o(196282);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cup
 * JD-Core Version:    0.7.0.1
 */