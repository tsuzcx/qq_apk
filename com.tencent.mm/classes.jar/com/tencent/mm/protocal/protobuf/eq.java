package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eq
  extends ckq
{
  public LinkedList<xr> CyO;
  public int CyP;
  public int CyQ;
  public String session_id;
  public String url;
  
  public eq()
  {
    AppMethodBeat.i(103186);
    this.CyO = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.e(4, 8, this.CyO);
      if (this.session_id != null) {
        paramVarArgs.d(5, this.session_id);
      }
      paramVarArgs.aR(6, this.CyP);
      paramVarArgs.aR(7, this.CyQ);
      AppMethodBeat.o(103187);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i += f.a.a.a.c(4, 8, this.CyO);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.session_id);
      }
      i = f.a.a.b.b.a.bA(6, this.CyP);
      int j = f.a.a.b.b.a.bA(7, this.CyQ);
      AppMethodBeat.o(103187);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CyO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(103187);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eq localeq = (eq)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeq.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103187);
          return 0;
        case 2: 
          localeq.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103187);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeq.CyO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103187);
          return 0;
        case 5: 
          localeq.session_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103187);
          return 0;
        case 6: 
          localeq.CyP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103187);
          return 0;
        }
        localeq.CyQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(103187);
        return 0;
      }
      AppMethodBeat.o(103187);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eq
 * JD-Core Version:    0.7.0.1
 */