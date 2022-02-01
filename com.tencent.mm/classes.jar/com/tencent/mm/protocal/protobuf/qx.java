package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qx
  extends com.tencent.mm.bx.a
{
  public String CQK;
  public String CQL;
  public String CQM;
  public int CQN;
  public String CQO;
  public rc CQP;
  public String CQQ;
  public int CQR;
  public int CQS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CQK != null) {
        paramVarArgs.d(1, this.CQK);
      }
      if (this.CQL != null) {
        paramVarArgs.d(2, this.CQL);
      }
      if (this.CQM != null) {
        paramVarArgs.d(3, this.CQM);
      }
      paramVarArgs.aR(4, this.CQN);
      if (this.CQO != null) {
        paramVarArgs.d(5, this.CQO);
      }
      if (this.CQP != null)
      {
        paramVarArgs.kX(6, this.CQP.computeSize());
        this.CQP.writeFields(paramVarArgs);
      }
      if (this.CQQ != null) {
        paramVarArgs.d(7, this.CQQ);
      }
      paramVarArgs.aR(8, this.CQR);
      paramVarArgs.aR(9, this.CQS);
      AppMethodBeat.o(113959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CQK == null) {
        break label754;
      }
    }
    label754:
    for (int i = f.a.a.b.b.a.e(1, this.CQK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CQL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CQL);
      }
      i = paramInt;
      if (this.CQM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CQM);
      }
      i += f.a.a.b.b.a.bA(4, this.CQN);
      paramInt = i;
      if (this.CQO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CQO);
      }
      i = paramInt;
      if (this.CQP != null) {
        i = paramInt + f.a.a.a.kW(6, this.CQP.computeSize());
      }
      paramInt = i;
      if (this.CQQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CQQ);
      }
      i = f.a.a.b.b.a.bA(8, this.CQR);
      int j = f.a.a.b.b.a.bA(9, this.CQS);
      AppMethodBeat.o(113959);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qx localqx = (qx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113959);
          return -1;
        case 1: 
          localqx.CQK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 2: 
          localqx.CQL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 3: 
          localqx.CQM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 4: 
          localqx.CQN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113959);
          return 0;
        case 5: 
          localqx.CQO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqx.CQP = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113959);
          return 0;
        case 7: 
          localqx.CQQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 8: 
          localqx.CQR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113959);
          return 0;
        }
        localqx.CQS = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113959);
        return 0;
      }
      AppMethodBeat.o(113959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qx
 * JD-Core Version:    0.7.0.1
 */