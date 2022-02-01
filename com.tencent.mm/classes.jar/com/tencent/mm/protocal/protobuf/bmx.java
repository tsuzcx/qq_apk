package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bmx
  extends cqk
{
  public String DOl;
  public bmb FbT;
  public String FbV;
  public String FbW;
  public String FbX;
  public dn FbY;
  public csf Fcf;
  public aai Fcg;
  public boolean Fch;
  public dod Fci;
  public com.tencent.mm.bw.b ncy;
  public String tkL;
  
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FbT != null)
      {
        paramVarArgs.ln(2, this.FbT.computeSize());
        this.FbT.writeFields(paramVarArgs);
      }
      if (this.ncy != null) {
        paramVarArgs.c(3, this.ncy);
      }
      if (this.Fcf != null)
      {
        paramVarArgs.ln(4, this.Fcf.computeSize());
        this.Fcf.writeFields(paramVarArgs);
      }
      if (this.tkL != null) {
        paramVarArgs.d(5, this.tkL);
      }
      if (this.DOl != null) {
        paramVarArgs.d(6, this.DOl);
      }
      if (this.Fcg != null)
      {
        paramVarArgs.ln(7, this.Fcg.computeSize());
        this.Fcg.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(8, this.Fch);
      if (this.FbV != null) {
        paramVarArgs.d(9, this.FbV);
      }
      if (this.FbW != null) {
        paramVarArgs.d(10, this.FbW);
      }
      if (this.FbX != null) {
        paramVarArgs.d(11, this.FbX);
      }
      if (this.Fci != null)
      {
        paramVarArgs.ln(12, this.Fci.computeSize());
        this.Fci.writeFields(paramVarArgs);
      }
      if (this.FbY != null)
      {
        paramVarArgs.ln(13, this.FbY.computeSize());
        this.FbY.writeFields(paramVarArgs);
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
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FbT != null) {
        paramInt = i + f.a.a.a.lm(2, this.FbT.computeSize());
      }
      i = paramInt;
      if (this.ncy != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.ncy);
      }
      paramInt = i;
      if (this.Fcf != null) {
        paramInt = i + f.a.a.a.lm(4, this.Fcf.computeSize());
      }
      i = paramInt;
      if (this.tkL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tkL);
      }
      paramInt = i;
      if (this.DOl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DOl);
      }
      i = paramInt;
      if (this.Fcg != null) {
        i = paramInt + f.a.a.a.lm(7, this.Fcg.computeSize());
      }
      i += f.a.a.b.b.a.fK(8) + 1;
      paramInt = i;
      if (this.FbV != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FbV);
      }
      i = paramInt;
      if (this.FbW != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FbW);
      }
      paramInt = i;
      if (this.FbX != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FbX);
      }
      i = paramInt;
      if (this.Fci != null) {
        i = paramInt + f.a.a.a.lm(12, this.Fci.computeSize());
      }
      paramInt = i;
      if (this.FbY != null) {
        paramInt = i + f.a.a.a.lm(13, this.FbY.computeSize());
      }
      AppMethodBeat.o(123619);
      return paramInt;
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
        bmx localbmx = (bmx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123619);
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
            localbmx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
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
            localbmx.FbT = ((bmb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 3: 
          localbmx.ncy = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(123619);
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
            localbmx.Fcf = ((csf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 5: 
          localbmx.tkL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 6: 
          localbmx.DOl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aai();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmx.Fcg = ((aai)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 8: 
          localbmx.Fch = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(123619);
          return 0;
        case 9: 
          localbmx.FbV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 10: 
          localbmx.FbW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 11: 
          localbmx.FbX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmx.Fci = ((dod)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbmx.FbY = ((dn)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmx
 * JD-Core Version:    0.7.0.1
 */