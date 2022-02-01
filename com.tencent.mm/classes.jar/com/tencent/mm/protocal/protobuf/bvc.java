package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvc
  extends ckq
{
  public String CFs;
  public String DSi;
  public int dsB;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72528);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CFs != null) {
        paramVarArgs.d(2, this.CFs);
      }
      if (this.DSi != null) {
        paramVarArgs.d(3, this.DSi);
      }
      paramVarArgs.aR(4, this.dsB);
      if (this.token != null) {
        paramVarArgs.d(5, this.token);
      }
      AppMethodBeat.o(72528);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CFs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CFs);
      }
      i = paramInt;
      if (this.DSi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DSi);
      }
      i += f.a.a.b.b.a.bA(4, this.dsB);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.token);
      }
      AppMethodBeat.o(72528);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72528);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvc localbvc = (bvc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72528);
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
            localbvc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72528);
          return 0;
        case 2: 
          localbvc.CFs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72528);
          return 0;
        case 3: 
          localbvc.DSi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72528);
          return 0;
        case 4: 
          localbvc.dsB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72528);
          return 0;
        }
        localbvc.token = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72528);
        return 0;
      }
      AppMethodBeat.o(72528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvc
 * JD-Core Version:    0.7.0.1
 */