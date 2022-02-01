package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sv
  extends ckq
{
  public String CUC;
  public String CUD;
  public String CUF;
  public String CxX;
  public String dlJ;
  public int tav;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72435);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlJ != null) {
        paramVarArgs.d(2, this.dlJ);
      }
      if (this.CUF != null) {
        paramVarArgs.d(3, this.CUF);
      }
      if (this.CxX != null) {
        paramVarArgs.d(4, this.CxX);
      }
      paramVarArgs.aR(5, this.tav);
      if (this.CUD != null) {
        paramVarArgs.d(6, this.CUD);
      }
      if (this.CUC != null) {
        paramVarArgs.d(7, this.CUC);
      }
      AppMethodBeat.o(72435);
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
      if (this.dlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlJ);
      }
      i = paramInt;
      if (this.CUF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CUF);
      }
      paramInt = i;
      if (this.CxX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CxX);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.tav);
      paramInt = i;
      if (this.CUD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CUD);
      }
      i = paramInt;
      if (this.CUC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CUC);
      }
      AppMethodBeat.o(72435);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sv localsv = (sv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72435);
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
            localsv.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72435);
          return 0;
        case 2: 
          localsv.dlJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 3: 
          localsv.CUF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 4: 
          localsv.CxX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 5: 
          localsv.tav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72435);
          return 0;
        case 6: 
          localsv.CUD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72435);
          return 0;
        }
        localsv.CUC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72435);
        return 0;
      }
      AppMethodBeat.o(72435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sv
 * JD-Core Version:    0.7.0.1
 */