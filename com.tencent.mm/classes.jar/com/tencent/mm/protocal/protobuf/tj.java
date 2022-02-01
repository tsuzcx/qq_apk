package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class tj
  extends ckq
{
  public String CUC;
  public String dlJ;
  public String vBp;
  public String vBv;
  public String vBw;
  public long vDB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72450);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: req_key");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.vBw == null)
      {
        paramVarArgs = new b("Not all required fields were included: transfer_id");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.vBv == null)
      {
        paramVarArgs = new b("Not all required fields were included: transaction_id");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.vBp == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_openid");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlJ != null) {
        paramVarArgs.d(2, this.dlJ);
      }
      if (this.vBw != null) {
        paramVarArgs.d(3, this.vBw);
      }
      if (this.vBv != null) {
        paramVarArgs.d(4, this.vBv);
      }
      if (this.vBp != null) {
        paramVarArgs.d(5, this.vBp);
      }
      paramVarArgs.aG(6, this.vDB);
      if (this.CUC != null) {
        paramVarArgs.d(7, this.CUC);
      }
      AppMethodBeat.o(72450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label850;
      }
    }
    label850:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlJ);
      }
      i = paramInt;
      if (this.vBw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vBw);
      }
      paramInt = i;
      if (this.vBv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vBv);
      }
      i = paramInt;
      if (this.vBp != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.vBp);
      }
      i += f.a.a.b.b.a.q(6, this.vDB);
      paramInt = i;
      if (this.CUC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CUC);
      }
      AppMethodBeat.o(72450);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.dlJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: req_key");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.vBw == null)
        {
          paramVarArgs = new b("Not all required fields were included: transfer_id");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.vBv == null)
        {
          paramVarArgs = new b("Not all required fields were included: transaction_id");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.vBp == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_openid");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72450);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tj localtj = (tj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72450);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72450);
          return 0;
        case 2: 
          localtj.dlJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 3: 
          localtj.vBw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 4: 
          localtj.vBv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 5: 
          localtj.vBp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 6: 
          localtj.vDB = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(72450);
          return 0;
        }
        localtj.CUC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72450);
        return 0;
      }
      AppMethodBeat.o(72450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tj
 * JD-Core Version:    0.7.0.1
 */