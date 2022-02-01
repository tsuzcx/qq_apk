package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ap
  extends ckq
{
  public int CtZ;
  public String Cua;
  public String Cub;
  public boolean Cuc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113927);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CtZ);
      if (this.Cua != null) {
        paramVarArgs.d(3, this.Cua);
      }
      if (this.Cub != null) {
        paramVarArgs.d(4, this.Cub);
      }
      paramVarArgs.bg(5, this.Cuc);
      AppMethodBeat.o(113927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CtZ);
      paramInt = i;
      if (this.Cua != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Cua);
      }
      i = paramInt;
      if (this.Cub != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Cub);
      }
      paramInt = f.a.a.b.b.a.fY(5);
      AppMethodBeat.o(113927);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113927);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113927);
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
            localap.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113927);
          return 0;
        case 2: 
          localap.CtZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113927);
          return 0;
        case 3: 
          localap.Cua = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113927);
          return 0;
        case 4: 
          localap.Cub = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113927);
          return 0;
        }
        localap.Cuc = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(113927);
        return 0;
      }
      AppMethodBeat.o(113927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ap
 * JD-Core Version:    0.7.0.1
 */