package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ri
  extends ckq
{
  public float dpb;
  public float dqQ;
  public String dyc;
  public String nrr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113970);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nrr != null) {
        paramVarArgs.d(2, this.nrr);
      }
      paramVarArgs.x(3, this.dqQ);
      paramVarArgs.x(4, this.dpb);
      if (this.dyc != null) {
        paramVarArgs.d(5, this.dyc);
      }
      AppMethodBeat.o(113970);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nrr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nrr);
      }
      i = i + (f.a.a.b.b.a.fY(3) + 4) + (f.a.a.b.b.a.fY(4) + 4);
      paramInt = i;
      if (this.dyc != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dyc);
      }
      AppMethodBeat.o(113970);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113970);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ri localri = (ri)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113970);
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
            localri.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113970);
          return 0;
        case 2: 
          localri.nrr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113970);
          return 0;
        case 3: 
          localri.dqQ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(113970);
          return 0;
        case 4: 
          localri.dpb = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(113970);
          return 0;
        }
        localri.dyc = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113970);
        return 0;
      }
      AppMethodBeat.o(113970);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ri
 * JD-Core Version:    0.7.0.1
 */