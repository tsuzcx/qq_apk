package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ck
  extends ckq
{
  public int Ctl;
  public String Ctm;
  public String Cxj;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32106);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Cxj != null) {
        paramVarArgs.d(2, this.Cxj);
      }
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aR(4, this.Ctl);
      if (this.Ctm != null) {
        paramVarArgs.d(5, this.Ctm);
      }
      AppMethodBeat.o(32106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label545;
      }
    }
    label545:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Cxj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Cxj);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Url);
      }
      i += f.a.a.b.b.a.bA(4, this.Ctl);
      paramInt = i;
      if (this.Ctm != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ctm);
      }
      AppMethodBeat.o(32106);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32106);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ck localck = (ck)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32106);
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
            localck.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32106);
          return 0;
        case 2: 
          localck.Cxj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32106);
          return 0;
        case 3: 
          localck.Url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32106);
          return 0;
        case 4: 
          localck.Ctl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32106);
          return 0;
        }
        localck.Ctm = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32106);
        return 0;
      }
      AppMethodBeat.o(32106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ck
 * JD-Core Version:    0.7.0.1
 */