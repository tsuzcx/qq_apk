package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckw
  extends dop
{
  public String GaP;
  public String app_id;
  public String pWm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82453);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.e(2, this.app_id);
      }
      if (this.GaP != null) {
        paramVarArgs.e(3, this.GaP);
      }
      if (this.pWm != null) {
        paramVarArgs.e(4, this.pWm);
      }
      AppMethodBeat.o(82453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.app_id);
      }
      i = paramInt;
      if (this.GaP != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.GaP);
      }
      paramInt = i;
      if (this.pWm != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.pWm);
      }
      AppMethodBeat.o(82453);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ckw localckw = (ckw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82453);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localckw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82453);
          return 0;
        case 2: 
          localckw.app_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82453);
          return 0;
        case 3: 
          localckw.GaP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82453);
          return 0;
        }
        localckw.pWm = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(82453);
        return 0;
      }
      AppMethodBeat.o(82453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckw
 * JD-Core Version:    0.7.0.1
 */