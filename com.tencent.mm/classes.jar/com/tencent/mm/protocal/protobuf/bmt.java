package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class bmt
  extends cqk
{
  public String DLD;
  public String DLQ;
  public bmb FbT;
  public String Fca;
  public String Fcb;
  public String Fcc;
  public int Fcd;
  public String iJW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123613);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123613);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FbT != null)
      {
        paramVarArgs.ln(2, this.FbT.computeSize());
        this.FbT.writeFields(paramVarArgs);
      }
      if (this.Fcb != null) {
        paramVarArgs.d(3, this.Fcb);
      }
      if (this.DLQ != null) {
        paramVarArgs.d(4, this.DLQ);
      }
      if (this.DLD != null) {
        paramVarArgs.d(5, this.DLD);
      }
      if (this.Fcc != null) {
        paramVarArgs.d(6, this.Fcc);
      }
      paramVarArgs.aR(7, this.Fcd);
      if (this.Fca != null) {
        paramVarArgs.d(8, this.Fca);
      }
      if (this.iJW != null) {
        paramVarArgs.d(9, this.iJW);
      }
      AppMethodBeat.o(123613);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FbT != null) {
        paramInt = i + f.a.a.a.lm(2, this.FbT.computeSize());
      }
      i = paramInt;
      if (this.Fcb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fcb);
      }
      paramInt = i;
      if (this.DLQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DLQ);
      }
      i = paramInt;
      if (this.DLD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DLD);
      }
      paramInt = i;
      if (this.Fcc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fcc);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.Fcd);
      paramInt = i;
      if (this.Fca != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fca);
      }
      i = paramInt;
      if (this.iJW != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.iJW);
      }
      AppMethodBeat.o(123613);
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
          AppMethodBeat.o(123613);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123613);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmt localbmt = (bmt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123613);
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
            localbmt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmt.FbT = ((bmb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 3: 
          localbmt.Fcb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 4: 
          localbmt.DLQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 5: 
          localbmt.DLD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 6: 
          localbmt.Fcc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 7: 
          localbmt.Fcd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123613);
          return 0;
        case 8: 
          localbmt.Fca = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123613);
          return 0;
        }
        localbmt.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123613);
        return 0;
      }
      AppMethodBeat.o(123613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmt
 * JD-Core Version:    0.7.0.1
 */