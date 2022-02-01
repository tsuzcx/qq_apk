package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyn
  extends ckq
{
  public aht DlF;
  public int dvW;
  public String finderUsername;
  public long objectId;
  public String objectNonceId;
  public long pZL;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203837);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DlF != null)
      {
        paramVarArgs.kX(2, this.DlF.computeSize());
        this.DlF.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(3, this.objectId);
      paramVarArgs.aR(4, this.dvW);
      if (this.objectNonceId != null) {
        paramVarArgs.d(5, this.objectNonceId);
      }
      paramVarArgs.aG(6, this.pZL);
      if (this.finderUsername != null) {
        paramVarArgs.d(7, this.finderUsername);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(8, this.sessionBuffer);
      }
      AppMethodBeat.o(203837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DlF != null) {
        i = paramInt + f.a.a.a.kW(2, this.DlF.computeSize());
      }
      i = i + f.a.a.b.b.a.q(3, this.objectId) + f.a.a.b.b.a.bA(4, this.dvW);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.objectNonceId);
      }
      i = paramInt + f.a.a.b.b.a.q(6, this.pZL);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.finderUsername);
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.sessionBuffer);
      }
      AppMethodBeat.o(203837);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyn localdyn = (dyn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203837);
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
            localdyn.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203837);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyn.DlF = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203837);
          return 0;
        case 3: 
          localdyn.objectId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(203837);
          return 0;
        case 4: 
          localdyn.dvW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203837);
          return 0;
        case 5: 
          localdyn.objectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203837);
          return 0;
        case 6: 
          localdyn.pZL = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(203837);
          return 0;
        case 7: 
          localdyn.finderUsername = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203837);
          return 0;
        }
        localdyn.sessionBuffer = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(203837);
        return 0;
      }
      AppMethodBeat.o(203837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyn
 * JD-Core Version:    0.7.0.1
 */