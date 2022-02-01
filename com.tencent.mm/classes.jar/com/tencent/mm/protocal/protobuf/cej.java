package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cej
  extends cld
{
  public long CWA;
  public long CWz;
  public LinkedList<byt> CsY;
  public clp DEh;
  public bgk Dbf;
  public dcl DsY;
  public pu Duz;
  public bsc Eat;
  public int ntx;
  public String nty;
  
  public cej()
  {
    AppMethodBeat.i(72560);
    this.CsY = new LinkedList();
    AppMethodBeat.o(72560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72561);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      if (this.Dbf != null)
      {
        paramVarArgs.kX(4, this.Dbf.computeSize());
        this.Dbf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.CsY);
      paramVarArgs.aG(6, this.CWz);
      paramVarArgs.aG(7, this.CWA);
      if (this.DEh != null)
      {
        paramVarArgs.kX(8, this.DEh.computeSize());
        this.DEh.writeFields(paramVarArgs);
      }
      if (this.Duz != null)
      {
        paramVarArgs.kX(9, this.Duz.computeSize());
        this.Duz.writeFields(paramVarArgs);
      }
      if (this.DsY != null)
      {
        paramVarArgs.kX(10, this.DsY.computeSize());
        this.DsY.writeFields(paramVarArgs);
      }
      if (this.Eat != null)
      {
        paramVarArgs.kX(11, this.Eat.computeSize());
        this.Eat.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72561);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1470;
      }
    }
    label1470:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.Dbf != null) {
        i = paramInt + f.a.a.a.kW(4, this.Dbf.computeSize());
      }
      i = i + f.a.a.a.c(5, 8, this.CsY) + f.a.a.b.b.a.q(6, this.CWz) + f.a.a.b.b.a.q(7, this.CWA);
      paramInt = i;
      if (this.DEh != null) {
        paramInt = i + f.a.a.a.kW(8, this.DEh.computeSize());
      }
      i = paramInt;
      if (this.Duz != null) {
        i = paramInt + f.a.a.a.kW(9, this.Duz.computeSize());
      }
      paramInt = i;
      if (this.DsY != null) {
        paramInt = i + f.a.a.a.kW(10, this.DsY.computeSize());
      }
      i = paramInt;
      if (this.Eat != null) {
        i = paramInt + f.a.a.a.kW(11, this.Eat.computeSize());
      }
      AppMethodBeat.o(72561);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CsY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72561);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cej localcej = (cej)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72561);
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
            localcej.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 2: 
          localcej.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72561);
          return 0;
        case 3: 
          localcej.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72561);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcej.Dbf = ((bgk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcej.CsY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 6: 
          localcej.CWz = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(72561);
          return 0;
        case 7: 
          localcej.CWA = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(72561);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcej.DEh = ((clp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcej.Duz = ((pu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcej.DsY = ((dcl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcej.Eat = ((bsc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      AppMethodBeat.o(72561);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cej
 * JD-Core Version:    0.7.0.1
 */