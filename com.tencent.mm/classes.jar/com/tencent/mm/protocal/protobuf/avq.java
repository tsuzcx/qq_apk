package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avq
  extends cld
{
  public int CNq;
  public String CNs;
  public SKBuiltinBuffer_t Dva;
  public int Dvf;
  public LinkedList<cmf> Dvg;
  public int Dvh;
  public LinkedList<blc> Dvi;
  public String Dvj;
  public int Dvk;
  public int Dvl;
  public bld Dvm;
  public String Dvn;
  public String ijO;
  
  public avq()
  {
    AppMethodBeat.i(32251);
    this.Dvg = new LinkedList();
    this.Dvi = new LinkedList();
    AppMethodBeat.o(32251);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32252);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.Dva == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Dva != null)
      {
        paramVarArgs.kX(2, this.Dva.computeSize());
        this.Dva.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Dvf);
      paramVarArgs.e(4, 8, this.Dvg);
      paramVarArgs.aR(5, this.Dvh);
      paramVarArgs.e(6, 8, this.Dvi);
      paramVarArgs.aR(7, this.CNq);
      if (this.Dvj != null) {
        paramVarArgs.d(8, this.Dvj);
      }
      if (this.CNs != null) {
        paramVarArgs.d(9, this.CNs);
      }
      paramVarArgs.aR(10, this.Dvk);
      if (this.ijO != null) {
        paramVarArgs.d(11, this.ijO);
      }
      paramVarArgs.aR(12, this.Dvl);
      if (this.Dvm != null)
      {
        paramVarArgs.kX(13, this.Dvm.computeSize());
        this.Dvm.writeFields(paramVarArgs);
      }
      if (this.Dvn != null) {
        paramVarArgs.d(14, this.Dvn);
      }
      AppMethodBeat.o(32252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1490;
      }
    }
    label1490:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dva != null) {
        i = paramInt + f.a.a.a.kW(2, this.Dva.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(3, this.Dvf) + f.a.a.a.c(4, 8, this.Dvg) + f.a.a.b.b.a.bA(5, this.Dvh) + f.a.a.a.c(6, 8, this.Dvi) + f.a.a.b.b.a.bA(7, this.CNq);
      paramInt = i;
      if (this.Dvj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Dvj);
      }
      i = paramInt;
      if (this.CNs != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CNs);
      }
      i += f.a.a.b.b.a.bA(10, this.Dvk);
      paramInt = i;
      if (this.ijO != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ijO);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.Dvl);
      paramInt = i;
      if (this.Dvm != null) {
        paramInt = i + f.a.a.a.kW(13, this.Dvm.computeSize());
      }
      i = paramInt;
      if (this.Dvn != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Dvn);
      }
      AppMethodBeat.o(32252);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dvg.clear();
        this.Dvi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        if (this.Dva == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32252);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avq localavq = (avq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32252);
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
            localavq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavq.Dva = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 3: 
          localavq.Dvf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32252);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavq.Dvg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 5: 
          localavq.Dvh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32252);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavq.Dvi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 7: 
          localavq.CNq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32252);
          return 0;
        case 8: 
          localavq.Dvj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 9: 
          localavq.CNs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 10: 
          localavq.Dvk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32252);
          return 0;
        case 11: 
          localavq.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 12: 
          localavq.Dvl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32252);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bld();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavq.Dvm = ((bld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        }
        localavq.Dvn = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32252);
        return 0;
      }
      AppMethodBeat.o(32252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avq
 * JD-Core Version:    0.7.0.1
 */