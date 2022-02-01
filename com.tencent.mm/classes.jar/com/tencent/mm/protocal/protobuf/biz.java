package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class biz
  extends cld
{
  public String CvQ;
  public String DGB;
  public String DGC;
  public String DGD;
  public dl DGE;
  public bij DGz;
  public LinkedList<cmy> Dqc;
  public String scR;
  
  public biz()
  {
    AppMethodBeat.i(123609);
    this.Dqc = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DGz != null)
      {
        paramVarArgs.kX(2, this.DGz.computeSize());
        this.DGz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Dqc);
      if (this.scR != null) {
        paramVarArgs.d(4, this.scR);
      }
      if (this.CvQ != null) {
        paramVarArgs.d(5, this.CvQ);
      }
      if (this.DGB != null) {
        paramVarArgs.d(6, this.DGB);
      }
      if (this.DGC != null) {
        paramVarArgs.d(7, this.DGC);
      }
      if (this.DGD != null) {
        paramVarArgs.d(8, this.DGD);
      }
      if (this.DGE != null)
      {
        paramVarArgs.kX(9, this.DGE.computeSize());
        this.DGE.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DGz != null) {
        i = paramInt + f.a.a.a.kW(2, this.DGz.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.Dqc);
      paramInt = i;
      if (this.scR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.scR);
      }
      i = paramInt;
      if (this.CvQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CvQ);
      }
      paramInt = i;
      if (this.DGB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DGB);
      }
      i = paramInt;
      if (this.DGC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DGC);
      }
      paramInt = i;
      if (this.DGD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DGD);
      }
      i = paramInt;
      if (this.DGE != null) {
        i = paramInt + f.a.a.a.kW(9, this.DGE.computeSize());
      }
      AppMethodBeat.o(123610);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dqc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        biz localbiz = (biz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123610);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbiz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bij();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbiz.DGz = ((bij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbiz.Dqc.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 4: 
          localbiz.scR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 5: 
          localbiz.CvQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 6: 
          localbiz.DGB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 7: 
          localbiz.DGC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 8: 
          localbiz.DGD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123610);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbiz.DGE = ((dl)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biz
 * JD-Core Version:    0.7.0.1
 */