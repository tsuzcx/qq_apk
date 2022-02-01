package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axp
  extends cld
{
  public String CIE;
  public int CKN;
  public String CNs;
  public String Ctz;
  public SKBuiltinBuffer_t Dva;
  public String Dvj;
  public int Dvk;
  public int Dww;
  public LinkedList<bxg> Dwx;
  public int OpCode;
  public String Url;
  
  public axp()
  {
    AppMethodBeat.i(56250);
    this.Dwx = new LinkedList();
    AppMethodBeat.o(56250);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56251);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.Dva == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Dww);
      paramVarArgs.e(3, 8, this.Dwx);
      paramVarArgs.aR(4, this.OpCode);
      paramVarArgs.aR(5, this.CKN);
      if (this.Dva != null)
      {
        paramVarArgs.kX(6, this.Dva.computeSize());
        this.Dva.writeFields(paramVarArgs);
      }
      if (this.Url != null) {
        paramVarArgs.d(7, this.Url);
      }
      if (this.Dvj != null) {
        paramVarArgs.d(8, this.Dvj);
      }
      if (this.CIE != null) {
        paramVarArgs.d(9, this.CIE);
      }
      if (this.Ctz != null) {
        paramVarArgs.d(10, this.Ctz);
      }
      paramVarArgs.aR(11, this.Dvk);
      if (this.CNs != null) {
        paramVarArgs.d(12, this.CNs);
      }
      AppMethodBeat.o(56251);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Dww) + f.a.a.a.c(3, 8, this.Dwx) + f.a.a.b.b.a.bA(4, this.OpCode) + f.a.a.b.b.a.bA(5, this.CKN);
      paramInt = i;
      if (this.Dva != null) {
        paramInt = i + f.a.a.a.kW(6, this.Dva.computeSize());
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Url);
      }
      paramInt = i;
      if (this.Dvj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Dvj);
      }
      i = paramInt;
      if (this.CIE != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CIE);
      }
      paramInt = i;
      if (this.Ctz != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Ctz);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.Dvk);
      paramInt = i;
      if (this.CNs != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CNs);
      }
      AppMethodBeat.o(56251);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dwx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        if (this.Dva == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56251);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axp localaxp = (axp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56251);
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
            localaxp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 2: 
          localaxp.Dww = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(56251);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxp.Dwx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 4: 
          localaxp.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(56251);
          return 0;
        case 5: 
          localaxp.CKN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(56251);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxp.Dva = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 7: 
          localaxp.Url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 8: 
          localaxp.Dvj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 9: 
          localaxp.CIE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 10: 
          localaxp.Ctz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 11: 
          localaxp.Dvk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(56251);
          return 0;
        }
        localaxp.CNs = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(56251);
        return 0;
      }
      AppMethodBeat.o(56251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axp
 * JD-Core Version:    0.7.0.1
 */