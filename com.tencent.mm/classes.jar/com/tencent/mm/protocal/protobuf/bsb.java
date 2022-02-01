package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bsb
  extends cwj
{
  public String FLQ;
  public brf HeT;
  public String HeW;
  public String HeX;
  public String HeY;
  public do HeZ;
  public cyg Hfg;
  public acr Hfh;
  public boolean Hfi;
  public dur Hfj;
  public com.tencent.mm.bw.b nIq;
  public String uuo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123619);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123619);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HeT != null)
      {
        paramVarArgs.lJ(2, this.HeT.computeSize());
        this.HeT.writeFields(paramVarArgs);
      }
      if (this.nIq != null) {
        paramVarArgs.c(3, this.nIq);
      }
      if (this.Hfg != null)
      {
        paramVarArgs.lJ(4, this.Hfg.computeSize());
        this.Hfg.writeFields(paramVarArgs);
      }
      if (this.uuo != null) {
        paramVarArgs.d(5, this.uuo);
      }
      if (this.FLQ != null) {
        paramVarArgs.d(6, this.FLQ);
      }
      if (this.Hfh != null)
      {
        paramVarArgs.lJ(7, this.Hfh.computeSize());
        this.Hfh.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(8, this.Hfi);
      if (this.HeW != null) {
        paramVarArgs.d(9, this.HeW);
      }
      if (this.HeX != null) {
        paramVarArgs.d(10, this.HeX);
      }
      if (this.HeY != null) {
        paramVarArgs.d(11, this.HeY);
      }
      if (this.Hfj != null)
      {
        paramVarArgs.lJ(12, this.Hfj.computeSize());
        this.Hfj.writeFields(paramVarArgs);
      }
      if (this.HeZ != null)
      {
        paramVarArgs.lJ(13, this.HeZ.computeSize());
        this.HeZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1546;
      }
    }
    label1546:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HeT != null) {
        paramInt = i + f.a.a.a.lI(2, this.HeT.computeSize());
      }
      i = paramInt;
      if (this.nIq != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.nIq);
      }
      paramInt = i;
      if (this.Hfg != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hfg.computeSize());
      }
      i = paramInt;
      if (this.uuo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uuo);
      }
      paramInt = i;
      if (this.FLQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FLQ);
      }
      i = paramInt;
      if (this.Hfh != null) {
        i = paramInt + f.a.a.a.lI(7, this.Hfh.computeSize());
      }
      i += f.a.a.b.b.a.amF(8);
      paramInt = i;
      if (this.HeW != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HeW);
      }
      i = paramInt;
      if (this.HeX != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.HeX);
      }
      paramInt = i;
      if (this.HeY != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HeY);
      }
      i = paramInt;
      if (this.Hfj != null) {
        i = paramInt + f.a.a.a.lI(12, this.Hfj.computeSize());
      }
      paramInt = i;
      if (this.HeZ != null) {
        paramInt = i + f.a.a.a.lI(13, this.HeZ.computeSize());
      }
      AppMethodBeat.o(123619);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123619);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123619);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bsb localbsb = (bsb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123619);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsb.HeT = ((brf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 3: 
          localbsb.nIq = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(123619);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsb.Hfg = ((cyg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 5: 
          localbsb.uuo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 6: 
          localbsb.FLQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsb.Hfh = ((acr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 8: 
          localbsb.Hfi = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(123619);
          return 0;
        case 9: 
          localbsb.HeW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 10: 
          localbsb.HeX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 11: 
          localbsb.HeY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dur();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dur)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsb.Hfj = ((dur)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new do();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((do)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbsb.HeZ = ((do)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123619);
        return 0;
      }
      AppMethodBeat.o(123619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsb
 * JD-Core Version:    0.7.0.1
 */