package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avc
  extends ckq
{
  public abq CtD;
  public String Ctm;
  public String rht;
  public String rhu;
  public String rhv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32243);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.rht != null) {
        paramVarArgs.d(2, this.rht);
      }
      if (this.rhu != null) {
        paramVarArgs.d(3, this.rhu);
      }
      if (this.rhv != null) {
        paramVarArgs.d(4, this.rhv);
      }
      if (this.Ctm != null) {
        paramVarArgs.d(5, this.Ctm);
      }
      if (this.CtD != null)
      {
        paramVarArgs.kX(6, this.CtD.computeSize());
        this.CtD.writeFields(paramVarArgs);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rht);
      }
      i = paramInt;
      if (this.rhu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rhu);
      }
      paramInt = i;
      if (this.rhv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rhv);
      }
      i = paramInt;
      if (this.Ctm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ctm);
      }
      paramInt = i;
      if (this.CtD != null) {
        paramInt = i + f.a.a.a.kW(6, this.CtD.computeSize());
      }
      AppMethodBeat.o(32243);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avc localavc = (avc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32243);
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
            localavc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32243);
          return 0;
        case 2: 
          localavc.rht = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 3: 
          localavc.rhu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 4: 
          localavc.rhv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 5: 
          localavc.Ctm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32243);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavc.CtD = ((abq)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avc
 * JD-Core Version:    0.7.0.1
 */