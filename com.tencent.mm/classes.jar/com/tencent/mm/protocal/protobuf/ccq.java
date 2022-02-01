package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccq
  extends ckq
{
  public String DYY;
  public String DYZ;
  public String DZa;
  public String DZb;
  public String DZc;
  public int DZd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32374);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DYY != null) {
        paramVarArgs.d(2, this.DYY);
      }
      if (this.DYZ != null) {
        paramVarArgs.d(3, this.DYZ);
      }
      if (this.DZa != null) {
        paramVarArgs.d(4, this.DZa);
      }
      if (this.DZb != null) {
        paramVarArgs.d(5, this.DZb);
      }
      if (this.DZc != null) {
        paramVarArgs.d(6, this.DZc);
      }
      paramVarArgs.aR(7, this.DZd);
      AppMethodBeat.o(32374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label671;
      }
    }
    label671:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DYY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DYY);
      }
      i = paramInt;
      if (this.DYZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DYZ);
      }
      paramInt = i;
      if (this.DZa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DZa);
      }
      i = paramInt;
      if (this.DZb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DZb);
      }
      paramInt = i;
      if (this.DZc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DZc);
      }
      i = f.a.a.b.b.a.bA(7, this.DZd);
      AppMethodBeat.o(32374);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccq localccq = (ccq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32374);
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
            localccq.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32374);
          return 0;
        case 2: 
          localccq.DYY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 3: 
          localccq.DYZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 4: 
          localccq.DZa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 5: 
          localccq.DZb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 6: 
          localccq.DZc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32374);
          return 0;
        }
        localccq.DZd = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32374);
        return 0;
      }
      AppMethodBeat.o(32374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccq
 * JD-Core Version:    0.7.0.1
 */