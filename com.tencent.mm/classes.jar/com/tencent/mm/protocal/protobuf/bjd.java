package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class bjd
  extends cld
{
  public String Ctm;
  public String Ctz;
  public String CvQ;
  public String DGG;
  public String DGH;
  public String DGI;
  public int DGJ;
  public bij DGz;
  public LinkedList<cmy> Dqc;
  public String ijP;
  public String scR;
  
  public bjd()
  {
    AppMethodBeat.i(123616);
    this.Dqc = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DGz != null)
      {
        paramVarArgs.kX(2, this.DGz.computeSize());
        this.DGz.writeFields(paramVarArgs);
      }
      if (this.DGH != null) {
        paramVarArgs.d(3, this.DGH);
      }
      paramVarArgs.e(4, 8, this.Dqc);
      if (this.scR != null) {
        paramVarArgs.d(5, this.scR);
      }
      if (this.CvQ != null) {
        paramVarArgs.d(6, this.CvQ);
      }
      if (this.Ctz != null) {
        paramVarArgs.d(7, this.Ctz);
      }
      if (this.Ctm != null) {
        paramVarArgs.d(8, this.Ctm);
      }
      if (this.DGI != null) {
        paramVarArgs.d(9, this.DGI);
      }
      paramVarArgs.aR(10, this.DGJ);
      if (this.DGG != null) {
        paramVarArgs.d(11, this.DGG);
      }
      if (this.ijP != null) {
        paramVarArgs.d(12, this.ijP);
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
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DGz != null) {
        paramInt = i + f.a.a.a.kW(2, this.DGz.computeSize());
      }
      i = paramInt;
      if (this.DGH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DGH);
      }
      i += f.a.a.a.c(4, 8, this.Dqc);
      paramInt = i;
      if (this.scR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.scR);
      }
      i = paramInt;
      if (this.CvQ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CvQ);
      }
      paramInt = i;
      if (this.Ctz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ctz);
      }
      i = paramInt;
      if (this.Ctm != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Ctm);
      }
      paramInt = i;
      if (this.DGI != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DGI);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.DGJ);
      paramInt = i;
      if (this.DGG != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DGG);
      }
      i = paramInt;
      if (this.ijP != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.ijP);
      }
      AppMethodBeat.o(123617);
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
          AppMethodBeat.o(123617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjd localbjd = (bjd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123617);
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
            localbjd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
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
            localbjd.DGz = ((bij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
          return 0;
        case 3: 
          localbjd.DGH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123617);
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
            localbjd.Dqc.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
          return 0;
        case 5: 
          localbjd.scR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 6: 
          localbjd.CvQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 7: 
          localbjd.Ctz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 8: 
          localbjd.Ctm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 9: 
          localbjd.DGI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 10: 
          localbjd.DGJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123617);
          return 0;
        case 11: 
          localbjd.DGG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123617);
          return 0;
        }
        localbjd.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123617);
        return 0;
      }
      AppMethodBeat.o(123617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjd
 * JD-Core Version:    0.7.0.1
 */