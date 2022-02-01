package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class p
  extends cld
{
  public String CsB;
  public String Csk;
  public a Csu;
  public int dcG = 268513600;
  public String duI;
  public String nTK = "请求不成功，请稍候再试";
  public String rcq;
  public String vAM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91327);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91327);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      if (this.rcq != null) {
        paramVarArgs.d(4, this.rcq);
      }
      if (this.duI != null) {
        paramVarArgs.d(5, this.duI);
      }
      if (this.vAM != null) {
        paramVarArgs.d(7, this.vAM);
      }
      if (this.Csk != null) {
        paramVarArgs.d(8, this.Csk);
      }
      if (this.Csu != null)
      {
        paramVarArgs.kX(9, this.Csu.computeSize());
        this.Csu.writeFields(paramVarArgs);
      }
      if (this.CsB != null) {
        paramVarArgs.d(10, this.CsB);
      }
      AppMethodBeat.o(91327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.rcq != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.rcq);
      }
      paramInt = i;
      if (this.duI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.duI);
      }
      i = paramInt;
      if (this.vAM != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.vAM);
      }
      paramInt = i;
      if (this.Csk != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Csk);
      }
      i = paramInt;
      if (this.Csu != null) {
        i = paramInt + f.a.a.a.kW(9, this.Csu.computeSize());
      }
      paramInt = i;
      if (this.CsB != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CsB);
      }
      AppMethodBeat.o(91327);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91327);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91327);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(91327);
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
            localp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91327);
          return 0;
        case 2: 
          localp.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91327);
          return 0;
        case 3: 
          localp.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 4: 
          localp.rcq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 5: 
          localp.duI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 7: 
          localp.vAM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 8: 
          localp.Csk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localp.Csu = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91327);
          return 0;
        }
        localp.CsB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91327);
        return 0;
      }
      AppMethodBeat.o(91327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.p
 * JD-Core Version:    0.7.0.1
 */