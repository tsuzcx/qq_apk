package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cie
  extends cvp
{
  public String GRx;
  public dlb HbW;
  public LinkedList<qx> HbX;
  public String HbY;
  public String HbZ;
  public String Hca;
  public dlb Hcb;
  public String Hcc;
  
  public cie()
  {
    AppMethodBeat.i(117890);
    this.HbX = new LinkedList();
    AppMethodBeat.o(117890);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117891);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GRx != null) {
        paramVarArgs.d(2, this.GRx);
      }
      if (this.HbW != null)
      {
        paramVarArgs.lC(3, this.HbW.computeSize());
        this.HbW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.HbX);
      if (this.HbY != null) {
        paramVarArgs.d(5, this.HbY);
      }
      if (this.HbZ != null) {
        paramVarArgs.d(6, this.HbZ);
      }
      if (this.Hca != null) {
        paramVarArgs.d(7, this.Hca);
      }
      if (this.Hcb != null)
      {
        paramVarArgs.lC(8, this.Hcb.computeSize());
        this.Hcb.writeFields(paramVarArgs);
      }
      if (this.Hcc != null) {
        paramVarArgs.d(9, this.Hcc);
      }
      AppMethodBeat.o(117891);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1066;
      }
    }
    label1066:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GRx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GRx);
      }
      i = paramInt;
      if (this.HbW != null) {
        i = paramInt + f.a.a.a.lB(3, this.HbW.computeSize());
      }
      i += f.a.a.a.c(4, 8, this.HbX);
      paramInt = i;
      if (this.HbY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HbY);
      }
      i = paramInt;
      if (this.HbZ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HbZ);
      }
      paramInt = i;
      if (this.Hca != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hca);
      }
      i = paramInt;
      if (this.Hcb != null) {
        i = paramInt + f.a.a.a.lB(8, this.Hcb.computeSize());
      }
      paramInt = i;
      if (this.Hcc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hcc);
      }
      AppMethodBeat.o(117891);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HbX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117891);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cie localcie = (cie)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117891);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcie.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 2: 
          localcie.GRx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcie.HbW = ((dlb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcie.HbX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 5: 
          localcie.HbY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 6: 
          localcie.HbZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 7: 
          localcie.Hca = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcie.Hcb = ((dlb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        }
        localcie.Hcc = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117891);
        return 0;
      }
      AppMethodBeat.o(117891);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cie
 * JD-Core Version:    0.7.0.1
 */