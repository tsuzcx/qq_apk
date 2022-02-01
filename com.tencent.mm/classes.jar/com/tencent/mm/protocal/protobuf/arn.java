package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class arn
  extends cqk
{
  public int DLI;
  public String DLy;
  public String EKE;
  public String EKF;
  public LinkedList<bki> EKJ;
  public SKBuiltinBuffer_t EKY;
  public String EKZ;
  public String ELa;
  public bmg ELb;
  public aqx ELc;
  public String ELd;
  public int ELe;
  public LinkedList<nt> ELf;
  public String ELg;
  public aam ELh;
  public SKBuiltinBuffer_t ELi;
  public int ELj;
  public SKBuiltinBuffer_t ELk;
  public SKBuiltinBuffer_t ELl;
  public String SSID;
  public String Title;
  public String hkR;
  public String ncR;
  public String tLG;
  
  public arn()
  {
    AppMethodBeat.i(152553);
    this.ELf = new LinkedList();
    this.EKJ = new LinkedList();
    AppMethodBeat.o(152553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152554);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152554);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EKZ != null) {
        paramVarArgs.d(2, this.EKZ);
      }
      if (this.ELa != null) {
        paramVarArgs.d(3, this.ELa);
      }
      paramVarArgs.aR(4, this.DLI);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.hkR != null) {
        paramVarArgs.d(6, this.hkR);
      }
      if (this.ELb != null)
      {
        paramVarArgs.ln(7, this.ELb.computeSize());
        this.ELb.writeFields(paramVarArgs);
      }
      if (this.ELc != null)
      {
        paramVarArgs.ln(8, this.ELc.computeSize());
        this.ELc.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(9, this.ncR);
      }
      if (this.ELd != null) {
        paramVarArgs.d(15, this.ELd);
      }
      paramVarArgs.aR(16, this.ELe);
      paramVarArgs.e(17, 8, this.ELf);
      if (this.ELg != null) {
        paramVarArgs.d(18, this.ELg);
      }
      if (this.SSID != null) {
        paramVarArgs.d(20, this.SSID);
      }
      if (this.DLy != null) {
        paramVarArgs.d(21, this.DLy);
      }
      if (this.ELh != null)
      {
        paramVarArgs.ln(22, this.ELh.computeSize());
        this.ELh.writeFields(paramVarArgs);
      }
      if (this.ELi != null)
      {
        paramVarArgs.ln(23, this.ELi.computeSize());
        this.ELi.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(24, this.ELj);
      paramVarArgs.e(25, 8, this.EKJ);
      if (this.tLG != null) {
        paramVarArgs.d(26, this.tLG);
      }
      if (this.EKE != null) {
        paramVarArgs.d(27, this.EKE);
      }
      if (this.EKY != null)
      {
        paramVarArgs.ln(28, this.EKY.computeSize());
        this.EKY.writeFields(paramVarArgs);
      }
      if (this.EKF != null) {
        paramVarArgs.d(29, this.EKF);
      }
      if (this.ELk != null)
      {
        paramVarArgs.ln(30, this.ELk.computeSize());
        this.ELk.writeFields(paramVarArgs);
      }
      if (this.ELl != null)
      {
        paramVarArgs.ln(31, this.ELl.computeSize());
        this.ELl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2630;
      }
    }
    label2630:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EKZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EKZ);
      }
      i = paramInt;
      if (this.ELa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ELa);
      }
      i += f.a.a.b.b.a.bx(4, this.DLI);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.hkR != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hkR);
      }
      paramInt = i;
      if (this.ELb != null) {
        paramInt = i + f.a.a.a.lm(7, this.ELb.computeSize());
      }
      i = paramInt;
      if (this.ELc != null) {
        i = paramInt + f.a.a.a.lm(8, this.ELc.computeSize());
      }
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ncR);
      }
      i = paramInt;
      if (this.ELd != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.ELd);
      }
      i = i + f.a.a.b.b.a.bx(16, this.ELe) + f.a.a.a.c(17, 8, this.ELf);
      paramInt = i;
      if (this.ELg != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.ELg);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.SSID);
      }
      paramInt = i;
      if (this.DLy != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.DLy);
      }
      i = paramInt;
      if (this.ELh != null) {
        i = paramInt + f.a.a.a.lm(22, this.ELh.computeSize());
      }
      paramInt = i;
      if (this.ELi != null) {
        paramInt = i + f.a.a.a.lm(23, this.ELi.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(24, this.ELj) + f.a.a.a.c(25, 8, this.EKJ);
      paramInt = i;
      if (this.tLG != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.tLG);
      }
      i = paramInt;
      if (this.EKE != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.EKE);
      }
      paramInt = i;
      if (this.EKY != null) {
        paramInt = i + f.a.a.a.lm(28, this.EKY.computeSize());
      }
      i = paramInt;
      if (this.EKF != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.EKF);
      }
      paramInt = i;
      if (this.ELk != null) {
        paramInt = i + f.a.a.a.lm(30, this.ELk.computeSize());
      }
      i = paramInt;
      if (this.ELl != null) {
        i = paramInt + f.a.a.a.lm(31, this.ELl.computeSize());
      }
      AppMethodBeat.o(152554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ELf.clear();
        this.EKJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arn localarn = (arn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 19: 
        default: 
          AppMethodBeat.o(152554);
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
            localarn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 2: 
          localarn.EKZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 3: 
          localarn.ELa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 4: 
          localarn.DLI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152554);
          return 0;
        case 5: 
          localarn.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 6: 
          localarn.hkR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarn.ELb = ((bmg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarn.ELc = ((aqx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 9: 
          localarn.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 15: 
          localarn.ELd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 16: 
          localarn.ELe = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152554);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarn.ELf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 18: 
          localarn.ELg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 20: 
          localarn.SSID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 21: 
          localarn.DLy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aam();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aam)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarn.ELh = ((aam)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarn.ELi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 24: 
          localarn.ELj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152554);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bki();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bki)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarn.EKJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 26: 
          localarn.tLG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 27: 
          localarn.EKE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarn.EKY = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 29: 
          localarn.EKF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarn.ELk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarn.ELl = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      AppMethodBeat.o(152554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arn
 * JD-Core Version:    0.7.0.1
 */