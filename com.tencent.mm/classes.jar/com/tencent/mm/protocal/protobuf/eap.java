package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eap
  extends cvw
{
  public int GjP;
  public SKBuiltinBuffer_t GjQ;
  public int Gxq;
  public long Gxr;
  public String HzT;
  public long Idp;
  public dzg Igz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GjQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.Igz == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpLog");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HzT != null) {
        paramVarArgs.d(2, this.HzT);
      }
      paramVarArgs.aS(3, this.Gxq);
      if (this.GjQ != null)
      {
        paramVarArgs.lJ(4, this.GjQ.computeSize());
        this.GjQ.writeFields(paramVarArgs);
      }
      if (this.Igz != null)
      {
        paramVarArgs.lJ(5, this.Igz.computeSize());
        this.Igz.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.Gxr);
      paramVarArgs.aS(7, this.GjP);
      paramVarArgs.aZ(8, this.Idp);
      AppMethodBeat.o(115925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HzT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HzT);
      }
      i += f.a.a.b.b.a.bz(3, this.Gxq);
      paramInt = i;
      if (this.GjQ != null) {
        paramInt = i + f.a.a.a.lI(4, this.GjQ.computeSize());
      }
      i = paramInt;
      if (this.Igz != null) {
        i = paramInt + f.a.a.a.lI(5, this.Igz.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(6, this.Gxr);
      int j = f.a.a.b.b.a.bz(7, this.GjP);
      int k = f.a.a.b.b.a.p(8, this.Idp);
      AppMethodBeat.o(115925);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GjQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        if (this.Igz == null)
        {
          paramVarArgs = new b("Not all required fields were included: OpLog");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eap localeap = (eap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115925);
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
            localeap.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 2: 
          localeap.HzT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115925);
          return 0;
        case 3: 
          localeap.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115925);
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
            localeap.GjQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeap.Igz = ((dzg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 6: 
          localeap.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115925);
          return 0;
        case 7: 
          localeap.GjP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115925);
          return 0;
        }
        localeap.Idp = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(115925);
        return 0;
      }
      AppMethodBeat.o(115925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eap
 * JD-Core Version:    0.7.0.1
 */