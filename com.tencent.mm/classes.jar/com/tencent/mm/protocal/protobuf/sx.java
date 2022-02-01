package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class sx
  extends ckq
{
  public int CUG;
  public String CUH;
  public int CUI;
  public b CUd;
  public int tav;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CUG);
      paramVarArgs.aR(3, this.tav);
      if (this.CUH != null) {
        paramVarArgs.d(4, this.CUH);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aR(6, this.CUI);
      if (this.CUd != null) {
        paramVarArgs.c(7, this.CUd);
      }
      AppMethodBeat.o(195466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CUG) + f.a.a.b.b.a.bA(3, this.tav);
      paramInt = i;
      if (this.CUH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CUH);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.url);
      }
      i += f.a.a.b.b.a.bA(6, this.CUI);
      paramInt = i;
      if (this.CUd != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.CUd);
      }
      AppMethodBeat.o(195466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(195466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sx localsx = (sx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195466);
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
            localsx.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195466);
          return 0;
        case 2: 
          localsx.CUG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(195466);
          return 0;
        case 3: 
          localsx.tav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(195466);
          return 0;
        case 4: 
          localsx.CUH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195466);
          return 0;
        case 5: 
          localsx.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195466);
          return 0;
        case 6: 
          localsx.CUI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(195466);
          return 0;
        }
        localsx.CUd = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(195466);
        return 0;
      }
      AppMethodBeat.o(195466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sx
 * JD-Core Version:    0.7.0.1
 */