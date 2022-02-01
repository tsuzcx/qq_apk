package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blj
  extends cqk
{
  public String Ebs;
  public ckz Eby;
  public String EtH;
  public String EtI;
  public int EtJ;
  public apz EtK;
  public mr EtL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124518);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124518);
        throw paramVarArgs;
      }
      if (this.Eby == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(124518);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Eby != null)
      {
        paramVarArgs.ln(2, this.Eby.computeSize());
        this.Eby.writeFields(paramVarArgs);
      }
      if (this.Ebs != null) {
        paramVarArgs.d(3, this.Ebs);
      }
      paramVarArgs.aR(4, this.EtJ);
      if (this.EtK != null)
      {
        paramVarArgs.ln(5, this.EtK.computeSize());
        this.EtK.writeFields(paramVarArgs);
      }
      if (this.EtL != null)
      {
        paramVarArgs.ln(6, this.EtL.computeSize());
        this.EtL.writeFields(paramVarArgs);
      }
      if (this.EtH != null) {
        paramVarArgs.d(7, this.EtH);
      }
      if (this.EtI != null) {
        paramVarArgs.d(8, this.EtI);
      }
      AppMethodBeat.o(124518);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1098;
      }
    }
    label1098:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eby != null) {
        paramInt = i + f.a.a.a.lm(2, this.Eby.computeSize());
      }
      i = paramInt;
      if (this.Ebs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ebs);
      }
      i += f.a.a.b.b.a.bx(4, this.EtJ);
      paramInt = i;
      if (this.EtK != null) {
        paramInt = i + f.a.a.a.lm(5, this.EtK.computeSize());
      }
      i = paramInt;
      if (this.EtL != null) {
        i = paramInt + f.a.a.a.lm(6, this.EtL.computeSize());
      }
      paramInt = i;
      if (this.EtH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EtH);
      }
      i = paramInt;
      if (this.EtI != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EtI);
      }
      AppMethodBeat.o(124518);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124518);
          throw paramVarArgs;
        }
        if (this.Eby == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(124518);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124518);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blj localblj = (blj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124518);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblj.Eby = ((ckz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 3: 
          localblj.Ebs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124518);
          return 0;
        case 4: 
          localblj.EtJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124518);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblj.EtK = ((apz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblj.EtL = ((mr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 7: 
          localblj.EtH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124518);
          return 0;
        }
        localblj.EtI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124518);
        return 0;
      }
      AppMethodBeat.o(124518);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blj
 * JD-Core Version:    0.7.0.1
 */