package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bjf
  extends cld
{
  public String CvQ;
  public String DGB;
  public String DGC;
  public String DGD;
  public dl DGE;
  public cmy DGL;
  public zj DGM;
  public boolean DGN;
  public dio DGO;
  public bij DGz;
  public com.tencent.mm.bx.b mAx;
  public String scR;
  
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DGz != null)
      {
        paramVarArgs.kX(2, this.DGz.computeSize());
        this.DGz.writeFields(paramVarArgs);
      }
      if (this.mAx != null) {
        paramVarArgs.c(3, this.mAx);
      }
      if (this.DGL != null)
      {
        paramVarArgs.kX(4, this.DGL.computeSize());
        this.DGL.writeFields(paramVarArgs);
      }
      if (this.scR != null) {
        paramVarArgs.d(5, this.scR);
      }
      if (this.CvQ != null) {
        paramVarArgs.d(6, this.CvQ);
      }
      if (this.DGM != null)
      {
        paramVarArgs.kX(7, this.DGM.computeSize());
        this.DGM.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(8, this.DGN);
      if (this.DGB != null) {
        paramVarArgs.d(9, this.DGB);
      }
      if (this.DGC != null) {
        paramVarArgs.d(10, this.DGC);
      }
      if (this.DGD != null) {
        paramVarArgs.d(11, this.DGD);
      }
      if (this.DGO != null)
      {
        paramVarArgs.kX(12, this.DGO.computeSize());
        this.DGO.writeFields(paramVarArgs);
      }
      if (this.DGE != null)
      {
        paramVarArgs.kX(13, this.DGE.computeSize());
        this.DGE.writeFields(paramVarArgs);
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
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DGz != null) {
        paramInt = i + f.a.a.a.kW(2, this.DGz.computeSize());
      }
      i = paramInt;
      if (this.mAx != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.mAx);
      }
      paramInt = i;
      if (this.DGL != null) {
        paramInt = i + f.a.a.a.kW(4, this.DGL.computeSize());
      }
      i = paramInt;
      if (this.scR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.scR);
      }
      paramInt = i;
      if (this.CvQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CvQ);
      }
      i = paramInt;
      if (this.DGM != null) {
        i = paramInt + f.a.a.a.kW(7, this.DGM.computeSize());
      }
      i += f.a.a.b.b.a.fY(8) + 1;
      paramInt = i;
      if (this.DGB != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DGB);
      }
      i = paramInt;
      if (this.DGC != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DGC);
      }
      paramInt = i;
      if (this.DGD != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DGD);
      }
      i = paramInt;
      if (this.DGO != null) {
        i = paramInt + f.a.a.a.kW(12, this.DGO.computeSize());
      }
      paramInt = i;
      if (this.DGE != null) {
        paramInt = i + f.a.a.a.kW(13, this.DGE.computeSize());
      }
      AppMethodBeat.o(123619);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        bjf localbjf = (bjf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123619);
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
            localbjf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
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
            localbjf.DGz = ((bij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 3: 
          localbjf.mAx = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(123619);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjf.DGL = ((cmy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 5: 
          localbjf.scR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 6: 
          localbjf.CvQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjf.DGM = ((zj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 8: 
          localbjf.DGN = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(123619);
          return 0;
        case 9: 
          localbjf.DGB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 10: 
          localbjf.DGC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 11: 
          localbjf.DGD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjf.DGO = ((dio)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
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
          localbjf.DGE = ((dl)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjf
 * JD-Core Version:    0.7.0.1
 */