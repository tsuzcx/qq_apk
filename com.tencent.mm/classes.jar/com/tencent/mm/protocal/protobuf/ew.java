package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ew
  extends cvw
{
  public LinkedList<aal> FPa;
  public int FPb;
  public int FPc;
  public String session_id;
  public String url;
  
  public ew()
  {
    AppMethodBeat.i(103186);
    this.FPa = new LinkedList();
    AppMethodBeat.o(103186);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103187);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.e(4, 8, this.FPa);
      if (this.session_id != null) {
        paramVarArgs.d(5, this.session_id);
      }
      paramVarArgs.aS(6, this.FPb);
      paramVarArgs.aS(7, this.FPc);
      AppMethodBeat.o(103187);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i += f.a.a.a.c(4, 8, this.FPa);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.session_id);
      }
      i = f.a.a.b.b.a.bz(6, this.FPb);
      int j = f.a.a.b.b.a.bz(7, this.FPc);
      AppMethodBeat.o(103187);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FPa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(103187);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ew localew = (ew)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(103187);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localew.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103187);
          return 0;
        case 2: 
          localew.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103187);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aal();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aal)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localew.FPa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103187);
          return 0;
        case 5: 
          localew.session_id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103187);
          return 0;
        case 6: 
          localew.FPb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103187);
          return 0;
        }
        localew.FPc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(103187);
        return 0;
      }
      AppMethodBeat.o(103187);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ew
 * JD-Core Version:    0.7.0.1
 */