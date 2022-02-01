package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class yy
  extends cld
{
  public String CVv;
  public String CVw;
  public SKBuiltinBuffer_t CxB;
  public LinkedList<bpn> Cxd;
  public cmf Cxe;
  public cmf DaZ;
  public cmf Dbb;
  public cmf Dbc;
  public int fpb;
  
  public yy()
  {
    AppMethodBeat.i(101799);
    this.Cxd = new LinkedList();
    AppMethodBeat.o(101799);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101800);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.DaZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.Dbb == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.Dbc == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.Cxe == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DaZ != null)
      {
        paramVarArgs.kX(2, this.DaZ.computeSize());
        this.DaZ.writeFields(paramVarArgs);
      }
      if (this.Dbb != null)
      {
        paramVarArgs.kX(3, this.Dbb.computeSize());
        this.Dbb.writeFields(paramVarArgs);
      }
      if (this.Dbc != null)
      {
        paramVarArgs.kX(4, this.Dbc.computeSize());
        this.Dbc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.fpb);
      paramVarArgs.e(6, 8, this.Cxd);
      if (this.Cxe != null)
      {
        paramVarArgs.kX(7, this.Cxe.computeSize());
        this.Cxe.writeFields(paramVarArgs);
      }
      if (this.CxB != null)
      {
        paramVarArgs.kX(8, this.CxB.computeSize());
        this.CxB.writeFields(paramVarArgs);
      }
      if (this.CVv != null) {
        paramVarArgs.d(9, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(10, this.CVw);
      }
      AppMethodBeat.o(101800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1682;
      }
    }
    label1682:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DaZ != null) {
        paramInt = i + f.a.a.a.kW(2, this.DaZ.computeSize());
      }
      i = paramInt;
      if (this.Dbb != null) {
        i = paramInt + f.a.a.a.kW(3, this.Dbb.computeSize());
      }
      paramInt = i;
      if (this.Dbc != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dbc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.fpb) + f.a.a.a.c(6, 8, this.Cxd);
      paramInt = i;
      if (this.Cxe != null) {
        paramInt = i + f.a.a.a.kW(7, this.Cxe.computeSize());
      }
      i = paramInt;
      if (this.CxB != null) {
        i = paramInt + f.a.a.a.kW(8, this.CxB.computeSize());
      }
      paramInt = i;
      if (this.CVv != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CVv);
      }
      i = paramInt;
      if (this.CVw != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CVw);
      }
      AppMethodBeat.o(101800);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Cxd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.DaZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.Dbb == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.Dbc == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.Cxe == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.CxB == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101800);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yy localyy = (yy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101800);
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
            localyy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyy.DaZ = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyy.Dbb = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
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
            localyy.Dbc = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 5: 
          localyy.fpb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101800);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyy.Cxd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
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
            localyy.Cxe = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyy.CxB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 9: 
          localyy.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101800);
          return 0;
        }
        localyy.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(101800);
        return 0;
      }
      AppMethodBeat.o(101800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yy
 * JD-Core Version:    0.7.0.1
 */