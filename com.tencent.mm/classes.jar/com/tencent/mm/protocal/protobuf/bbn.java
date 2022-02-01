package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbn
  extends cld
{
  public int Dza;
  public String Dzb;
  public int Dzc;
  public String Dzd;
  public int Dze;
  public LinkedList<cmf> Dzf;
  public String Dzg;
  public int Dzh;
  public String Dzi;
  public int Dzj;
  public SKBuiltinBuffer_t Dzk;
  
  public bbn()
  {
    AppMethodBeat.i(152605);
    this.Dzf = new LinkedList();
    AppMethodBeat.o(152605);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152606);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152606);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Dza);
      if (this.Dzb != null) {
        paramVarArgs.d(3, this.Dzb);
      }
      paramVarArgs.aR(4, this.Dzc);
      if (this.Dzd != null) {
        paramVarArgs.d(5, this.Dzd);
      }
      paramVarArgs.aR(6, this.Dze);
      paramVarArgs.e(7, 8, this.Dzf);
      if (this.Dzg != null) {
        paramVarArgs.d(8, this.Dzg);
      }
      paramVarArgs.aR(9, this.Dzh);
      if (this.Dzi != null) {
        paramVarArgs.d(10, this.Dzi);
      }
      paramVarArgs.aR(11, this.Dzj);
      if (this.Dzk != null)
      {
        paramVarArgs.kX(12, this.Dzk.computeSize());
        this.Dzk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Dza);
      paramInt = i;
      if (this.Dzb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Dzb);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Dzc);
      paramInt = i;
      if (this.Dzd != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Dzd);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.Dze) + f.a.a.a.c(7, 8, this.Dzf);
      paramInt = i;
      if (this.Dzg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Dzg);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.Dzh);
      paramInt = i;
      if (this.Dzi != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Dzi);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.Dzj);
      paramInt = i;
      if (this.Dzk != null) {
        paramInt = i + f.a.a.a.kW(12, this.Dzk.computeSize());
      }
      AppMethodBeat.o(152606);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dzf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152606);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbn localbbn = (bbn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152606);
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
            localbbn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 2: 
          localbbn.Dza = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152606);
          return 0;
        case 3: 
          localbbn.Dzb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 4: 
          localbbn.Dzc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152606);
          return 0;
        case 5: 
          localbbn.Dzd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 6: 
          localbbn.Dze = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152606);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbn.Dzf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 8: 
          localbbn.Dzg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 9: 
          localbbn.Dzh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152606);
          return 0;
        case 10: 
          localbbn.Dzi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 11: 
          localbbn.Dzj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152606);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbbn.Dzk = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      AppMethodBeat.o(152606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbn
 * JD-Core Version:    0.7.0.1
 */