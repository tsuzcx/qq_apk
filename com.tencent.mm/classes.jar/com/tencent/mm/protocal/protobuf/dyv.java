package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dyv
  extends ckq
{
  public String Dls;
  public b Dlt;
  public long Dlu;
  public aht Lxt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203848);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.Dlu);
      if (this.Dls != null) {
        paramVarArgs.d(3, this.Dls);
      }
      if (this.Dlt != null) {
        paramVarArgs.c(4, this.Dlt);
      }
      if (this.Lxt != null)
      {
        paramVarArgs.kX(5, this.Lxt.computeSize());
        this.Lxt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(203848);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.Dlu);
      paramInt = i;
      if (this.Dls != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Dls);
      }
      i = paramInt;
      if (this.Dlt != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.Dlt);
      }
      paramInt = i;
      if (this.Lxt != null) {
        paramInt = i + f.a.a.a.kW(5, this.Lxt.computeSize());
      }
      AppMethodBeat.o(203848);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203848);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyv localdyv = (dyv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203848);
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
            localdyv.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203848);
          return 0;
        case 2: 
          localdyv.Dlu = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(203848);
          return 0;
        case 3: 
          localdyv.Dls = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203848);
          return 0;
        case 4: 
          localdyv.Dlt = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(203848);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aht();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyv.Lxt = ((aht)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(203848);
        return 0;
      }
      AppMethodBeat.o(203848);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyv
 * JD-Core Version:    0.7.0.1
 */