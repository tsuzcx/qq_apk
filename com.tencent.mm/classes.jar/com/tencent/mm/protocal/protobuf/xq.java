package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class xq
  extends cvp
{
  public String CPp;
  public cjj FXm;
  public boolean FXn;
  public String Fmb;
  public int qel;
  public String qem;
  public String scene;
  public String session_id;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91417);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91417);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.qel);
      if (this.qem != null) {
        paramVarArgs.d(3, this.qem);
      }
      if (this.token != null) {
        paramVarArgs.d(4, this.token);
      }
      if (this.FXm != null)
      {
        paramVarArgs.lC(5, this.FXm.computeSize());
        this.FXm.writeFields(paramVarArgs);
      }
      if (this.Fmb != null) {
        paramVarArgs.d(6, this.Fmb);
      }
      paramVarArgs.bt(7, this.FXn);
      if (this.CPp != null) {
        paramVarArgs.d(8, this.CPp);
      }
      if (this.session_id != null) {
        paramVarArgs.d(9, this.session_id);
      }
      if (this.scene != null) {
        paramVarArgs.d(10, this.scene);
      }
      AppMethodBeat.o(91417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label966;
      }
    }
    label966:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qel);
      paramInt = i;
      if (this.qem != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qem);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.token);
      }
      paramInt = i;
      if (this.FXm != null) {
        paramInt = i + f.a.a.a.lB(5, this.FXm.computeSize());
      }
      i = paramInt;
      if (this.Fmb != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fmb);
      }
      i += f.a.a.b.b.a.alV(7);
      paramInt = i;
      if (this.CPp != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CPp);
      }
      i = paramInt;
      if (this.session_id != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.session_id);
      }
      paramInt = i;
      if (this.scene != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.scene);
      }
      AppMethodBeat.o(91417);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91417);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xq localxq = (xq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91417);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91417);
          return 0;
        case 2: 
          localxq.qel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91417);
          return 0;
        case 3: 
          localxq.qem = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 4: 
          localxq.token = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxq.FXm = ((cjj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91417);
          return 0;
        case 6: 
          localxq.Fmb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 7: 
          localxq.FXn = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91417);
          return 0;
        case 8: 
          localxq.CPp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 9: 
          localxq.session_id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91417);
          return 0;
        }
        localxq.scene = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91417);
        return 0;
      }
      AppMethodBeat.o(91417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xq
 * JD-Core Version:    0.7.0.1
 */