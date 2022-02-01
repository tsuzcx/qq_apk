package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bqp
  extends cvp
{
  public String FDD;
  public String FXe;
  public String FXf;
  public String FXg;
  public String FXh;
  public String iht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.FXe != null) {
        paramVarArgs.d(3, this.FXe);
      }
      if (this.FDD != null) {
        paramVarArgs.d(4, this.FDD);
      }
      if (this.FXf != null) {
        paramVarArgs.d(5, this.FXf);
      }
      if (this.FXg != null) {
        paramVarArgs.d(6, this.FXg);
      }
      if (this.FXh != null) {
        paramVarArgs.d(7, this.FXh);
      }
      AppMethodBeat.o(82437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.FXe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FXe);
      }
      paramInt = i;
      if (this.FDD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FDD);
      }
      i = paramInt;
      if (this.FXf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FXf);
      }
      paramInt = i;
      if (this.FXg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FXg);
      }
      i = paramInt;
      if (this.FXh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FXh);
      }
      AppMethodBeat.o(82437);
      return i;
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
          AppMethodBeat.o(82437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqp localbqp = (bqp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82437);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82437);
          return 0;
        case 2: 
          localbqp.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 3: 
          localbqp.FXe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 4: 
          localbqp.FDD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 5: 
          localbqp.FXf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82437);
          return 0;
        case 6: 
          localbqp.FXg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82437);
          return 0;
        }
        localbqp.FXh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(82437);
        return 0;
      }
      AppMethodBeat.o(82437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqp
 * JD-Core Version:    0.7.0.1
 */