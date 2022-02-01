package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class def
  extends cld
{
  public String doh;
  public boolean nsQ;
  public int ntx;
  public String nty;
  public String zRV;
  public boolean zSj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72601);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.bg(4, this.nsQ);
      paramVarArgs.bg(5, this.zSj);
      if (this.zRV != null) {
        paramVarArgs.d(6, this.zRV);
      }
      if (this.doh != null) {
        paramVarArgs.d(7, this.doh);
      }
      AppMethodBeat.o(72601);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + (f.a.a.b.b.a.fY(4) + 1) + (f.a.a.b.b.a.fY(5) + 1);
      paramInt = i;
      if (this.zRV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.zRV);
      }
      i = paramInt;
      if (this.doh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.doh);
      }
      AppMethodBeat.o(72601);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72601);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        def localdef = (def)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72601);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdef.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72601);
          return 0;
        case 2: 
          localdef.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72601);
          return 0;
        case 3: 
          localdef.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72601);
          return 0;
        case 4: 
          localdef.nsQ = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(72601);
          return 0;
        case 5: 
          localdef.zSj = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(72601);
          return 0;
        case 6: 
          localdef.zRV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72601);
          return 0;
        }
        localdef.doh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72601);
        return 0;
      }
      AppMethodBeat.o(72601);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.def
 * JD-Core Version:    0.7.0.1
 */