package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class um
  extends cld
{
  public dtz CWj;
  public boolean CWk;
  public String CWl;
  public String CWm;
  public boolean CWn;
  public String CWo;
  public String CWp;
  public String CWq;
  public String CWr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123562);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CWj != null)
      {
        paramVarArgs.kX(2, this.CWj.computeSize());
        this.CWj.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(3, this.CWk);
      if (this.CWl != null) {
        paramVarArgs.d(4, this.CWl);
      }
      if (this.CWm != null) {
        paramVarArgs.d(5, this.CWm);
      }
      paramVarArgs.bg(6, this.CWn);
      if (this.CWo != null) {
        paramVarArgs.d(7, this.CWo);
      }
      if (this.CWp != null) {
        paramVarArgs.d(8, this.CWp);
      }
      if (this.CWq != null) {
        paramVarArgs.d(9, this.CWq);
      }
      if (this.CWr != null) {
        paramVarArgs.d(10, this.CWr);
      }
      AppMethodBeat.o(123562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label966;
      }
    }
    label966:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CWj != null) {
        i = paramInt + f.a.a.a.kW(2, this.CWj.computeSize());
      }
      i += f.a.a.b.b.a.fY(3) + 1;
      paramInt = i;
      if (this.CWl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CWl);
      }
      i = paramInt;
      if (this.CWm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CWm);
      }
      i += f.a.a.b.b.a.fY(6) + 1;
      paramInt = i;
      if (this.CWo != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CWo);
      }
      i = paramInt;
      if (this.CWp != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CWp);
      }
      paramInt = i;
      if (this.CWq != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CWq);
      }
      i = paramInt;
      if (this.CWr != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CWr);
      }
      AppMethodBeat.o(123562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        um localum = (um)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123562);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localum.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localum.CWj = ((dtz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 3: 
          localum.CWk = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(123562);
          return 0;
        case 4: 
          localum.CWl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 5: 
          localum.CWm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 6: 
          localum.CWn = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(123562);
          return 0;
        case 7: 
          localum.CWo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 8: 
          localum.CWp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 9: 
          localum.CWq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123562);
          return 0;
        }
        localum.CWr = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123562);
        return 0;
      }
      AppMethodBeat.o(123562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.um
 * JD-Core Version:    0.7.0.1
 */