package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class bmr
  extends cqk
{
  public String DOl;
  public LinkedList<csf> ELf;
  public bmb FbT;
  public String FbV;
  public String FbW;
  public String FbX;
  public dn FbY;
  public String tkL;
  
  public bmr()
  {
    AppMethodBeat.i(123609);
    this.ELf = new LinkedList();
    AppMethodBeat.o(123609);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123610);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123610);
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
      paramVarArgs.e(3, 8, this.ELf);
      if (this.tkL != null) {
        paramVarArgs.d(4, this.tkL);
      }
      if (this.DOl != null) {
        paramVarArgs.d(5, this.DOl);
      }
      if (this.FbV != null) {
        paramVarArgs.d(6, this.FbV);
      }
      if (this.FbW != null) {
        paramVarArgs.d(7, this.FbW);
      }
      if (this.FbX != null) {
        paramVarArgs.d(8, this.FbX);
      }
      if (this.FbY != null)
      {
        paramVarArgs.ln(9, this.FbY.computeSize());
        this.FbY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FbT != null) {
        i = paramInt + f.a.a.a.lm(2, this.FbT.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.ELf);
      paramInt = i;
      if (this.tkL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tkL);
      }
      i = paramInt;
      if (this.DOl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DOl);
      }
      paramInt = i;
      if (this.FbV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FbV);
      }
      i = paramInt;
      if (this.FbW != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FbW);
      }
      paramInt = i;
      if (this.FbX != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FbX);
      }
      i = paramInt;
      if (this.FbY != null) {
        i = paramInt + f.a.a.a.lm(9, this.FbY.computeSize());
      }
      AppMethodBeat.o(123610);
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
          AppMethodBeat.o(123610);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123610);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmr localbmr = (bmr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123610);
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
            localbmr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
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
            localbmr.FbT = ((bmb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmr.ELf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 4: 
          localbmr.tkL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 5: 
          localbmr.DOl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 6: 
          localbmr.FbV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 7: 
          localbmr.FbW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 8: 
          localbmr.FbX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123610);
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
          localbmr.FbY = ((dn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123610);
        return 0;
      }
      AppMethodBeat.o(123610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmr
 * JD-Core Version:    0.7.0.1
 */