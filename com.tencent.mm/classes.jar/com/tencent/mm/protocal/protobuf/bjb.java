package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class bjb
  extends cld
{
  public String Ctm;
  public String Ctz;
  public String DGG;
  public String DGH;
  public String DGI;
  public int DGJ;
  public bij DGz;
  public String ijP;
  
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
      if (this.Ctz != null) {
        paramVarArgs.d(4, this.Ctz);
      }
      if (this.Ctm != null) {
        paramVarArgs.d(5, this.Ctm);
      }
      if (this.DGI != null) {
        paramVarArgs.d(6, this.DGI);
      }
      paramVarArgs.aR(7, this.DGJ);
      if (this.DGG != null) {
        paramVarArgs.d(8, this.DGG);
      }
      if (this.ijP != null) {
        paramVarArgs.d(9, this.ijP);
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
      paramInt = i;
      if (this.Ctz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ctz);
      }
      i = paramInt;
      if (this.Ctm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ctm);
      }
      paramInt = i;
      if (this.DGI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DGI);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.DGJ);
      paramInt = i;
      if (this.DGG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DGG);
      }
      i = paramInt;
      if (this.ijP != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ijP);
      }
      AppMethodBeat.o(123613);
      return i;
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
        bjb localbjb = (bjb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123613);
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
            localbjb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
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
            localbjb.DGz = ((bij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 3: 
          localbjb.DGH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 4: 
          localbjb.Ctz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 5: 
          localbjb.Ctm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 6: 
          localbjb.DGI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 7: 
          localbjb.DGJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123613);
          return 0;
        case 8: 
          localbjb.DGG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123613);
          return 0;
        }
        localbjb.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123613);
        return 0;
      }
      AppMethodBeat.o(123613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjb
 * JD-Core Version:    0.7.0.1
 */