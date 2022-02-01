package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tv
  extends ckq
{
  public String CVH;
  public String CVI;
  public String dca;
  public String szi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CVH != null) {
        paramVarArgs.d(2, this.CVH);
      }
      if (this.CVI != null) {
        paramVarArgs.d(3, this.CVI);
      }
      if (this.szi != null) {
        paramVarArgs.d(4, this.szi);
      }
      if (this.dca != null) {
        paramVarArgs.d(5, this.dca);
      }
      AppMethodBeat.o(72452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CVH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CVH);
      }
      i = paramInt;
      if (this.CVI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CVI);
      }
      paramInt = i;
      if (this.szi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.szi);
      }
      i = paramInt;
      if (this.dca != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dca);
      }
      AppMethodBeat.o(72452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tv localtv = (tv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72452);
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
            localtv.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72452);
          return 0;
        case 2: 
          localtv.CVH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 3: 
          localtv.CVI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72452);
          return 0;
        case 4: 
          localtv.szi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72452);
          return 0;
        }
        localtv.dca = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72452);
        return 0;
      }
      AppMethodBeat.o(72452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tv
 * JD-Core Version:    0.7.0.1
 */