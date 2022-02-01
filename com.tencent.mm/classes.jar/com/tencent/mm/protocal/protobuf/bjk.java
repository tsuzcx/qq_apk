package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjk
  extends ckq
{
  public String Csj;
  public String DFR;
  public String DsB;
  public String dlB;
  public int nUh;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90969);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      if (this.Csj != null) {
        paramVarArgs.d(3, this.Csj);
      }
      if (this.signature != null) {
        paramVarArgs.d(4, this.signature);
      }
      paramVarArgs.aR(5, this.nUh);
      if (this.DFR != null) {
        paramVarArgs.d(6, this.DFR);
      }
      if (this.DsB != null) {
        paramVarArgs.d(7, this.DsB);
      }
      AppMethodBeat.o(90969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlB);
      }
      i = paramInt;
      if (this.Csj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Csj);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.signature);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.nUh);
      paramInt = i;
      if (this.DFR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DFR);
      }
      i = paramInt;
      if (this.DsB != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DsB);
      }
      AppMethodBeat.o(90969);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(90969);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjk localbjk = (bjk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90969);
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
            localbjk.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90969);
          return 0;
        case 2: 
          localbjk.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 3: 
          localbjk.Csj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 4: 
          localbjk.signature = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 5: 
          localbjk.nUh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(90969);
          return 0;
        case 6: 
          localbjk.DFR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(90969);
          return 0;
        }
        localbjk.DsB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(90969);
        return 0;
      }
      AppMethodBeat.o(90969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjk
 * JD-Core Version:    0.7.0.1
 */