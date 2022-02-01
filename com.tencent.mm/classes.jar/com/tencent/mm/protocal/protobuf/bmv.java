package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class bmv
  extends cqk
{
  public String DLD;
  public String DLQ;
  public String DOl;
  public LinkedList<csf> ELf;
  public bmb FbT;
  public String Fca;
  public String Fcb;
  public String Fcc;
  public int Fcd;
  public String iJW;
  public String tkL;
  
  public bmv()
  {
    AppMethodBeat.i(123616);
    this.ELf = new LinkedList();
    AppMethodBeat.o(123616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123617);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123617);
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
      paramVarArgs.e(4, 8, this.ELf);
      if (this.tkL != null) {
        paramVarArgs.d(5, this.tkL);
      }
      if (this.DOl != null) {
        paramVarArgs.d(6, this.DOl);
      }
      if (this.DLQ != null) {
        paramVarArgs.d(7, this.DLQ);
      }
      if (this.DLD != null) {
        paramVarArgs.d(8, this.DLD);
      }
      if (this.Fcc != null) {
        paramVarArgs.d(9, this.Fcc);
      }
      paramVarArgs.aR(10, this.Fcd);
      if (this.Fca != null) {
        paramVarArgs.d(11, this.Fca);
      }
      if (this.iJW != null) {
        paramVarArgs.d(12, this.iJW);
      }
      AppMethodBeat.o(123617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1190;
      }
    }
    label1190:
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
      i += f.a.a.a.c(4, 8, this.ELf);
      paramInt = i;
      if (this.tkL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.tkL);
      }
      i = paramInt;
      if (this.DOl != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DOl);
      }
      paramInt = i;
      if (this.DLQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DLQ);
      }
      i = paramInt;
      if (this.DLD != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DLD);
      }
      paramInt = i;
      if (this.Fcc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Fcc);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.Fcd);
      paramInt = i;
      if (this.Fca != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Fca);
      }
      i = paramInt;
      if (this.iJW != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.iJW);
      }
      AppMethodBeat.o(123617);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ELf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmv localbmv = (bmv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123617);
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
            localbmv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
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
            localbmv.FbT = ((bmb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
          return 0;
        case 3: 
          localbmv.Fcb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmv.ELf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
          return 0;
        case 5: 
          localbmv.tkL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 6: 
          localbmv.DOl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 7: 
          localbmv.DLQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 8: 
          localbmv.DLD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 9: 
          localbmv.Fcc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 10: 
          localbmv.Fcd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123617);
          return 0;
        case 11: 
          localbmv.Fca = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123617);
          return 0;
        }
        localbmv.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123617);
        return 0;
      }
      AppMethodBeat.o(123617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmv
 * JD-Core Version:    0.7.0.1
 */