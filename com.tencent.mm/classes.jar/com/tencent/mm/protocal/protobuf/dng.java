package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dng
  extends cvw
{
  public String HUr;
  public int HcN;
  public int HcO;
  public SKBuiltinBuffer_t HcP;
  public SKBuiltinBuffer_t Hxc;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91711);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HcP == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqText");
        AppMethodBeat.o(91711);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HcN);
      paramVarArgs.aS(3, this.HcO);
      if (this.HcP != null)
      {
        paramVarArgs.lJ(4, this.HcP.computeSize());
        this.HcP.writeFields(paramVarArgs);
      }
      if (this.Hxc != null)
      {
        paramVarArgs.lJ(5, this.Hxc.computeSize());
        this.Hxc.writeFields(paramVarArgs);
      }
      if (this.sign != null) {
        paramVarArgs.d(6, this.sign);
      }
      if (this.HUr != null) {
        paramVarArgs.d(7, this.HUr);
      }
      AppMethodBeat.o(91711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HcN) + f.a.a.b.b.a.bz(3, this.HcO);
      paramInt = i;
      if (this.HcP != null) {
        paramInt = i + f.a.a.a.lI(4, this.HcP.computeSize());
      }
      i = paramInt;
      if (this.Hxc != null) {
        i = paramInt + f.a.a.a.lI(5, this.Hxc.computeSize());
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sign);
      }
      i = paramInt;
      if (this.HUr != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HUr);
      }
      AppMethodBeat.o(91711);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HcP == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqText");
          AppMethodBeat.o(91711);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91711);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dng localdng = (dng)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91711);
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
            localdng.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 2: 
          localdng.HcN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91711);
          return 0;
        case 3: 
          localdng.HcO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91711);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdng.HcP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdng.Hxc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 6: 
          localdng.sign = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91711);
          return 0;
        }
        localdng.HUr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91711);
        return 0;
      }
      AppMethodBeat.o(91711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dng
 * JD-Core Version:    0.7.0.1
 */