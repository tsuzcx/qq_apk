package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abt
  extends cvp
{
  public String FVo;
  public String FVp;
  public LinkedList<byt> FuN;
  public cwt FuO;
  public SKBuiltinBuffer_t Fvm;
  public cwt Gbo;
  public cwt Gbr;
  public cwt Gbs;
  public int fLb;
  
  public abt()
  {
    AppMethodBeat.i(101799);
    this.FuN = new LinkedList();
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
      if (this.Gbo == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.Gbr == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.Gbs == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.FuO == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.Fvm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Gbo != null)
      {
        paramVarArgs.lC(2, this.Gbo.computeSize());
        this.Gbo.writeFields(paramVarArgs);
      }
      if (this.Gbr != null)
      {
        paramVarArgs.lC(3, this.Gbr.computeSize());
        this.Gbr.writeFields(paramVarArgs);
      }
      if (this.Gbs != null)
      {
        paramVarArgs.lC(4, this.Gbs.computeSize());
        this.Gbs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.fLb);
      paramVarArgs.e(6, 8, this.FuN);
      if (this.FuO != null)
      {
        paramVarArgs.lC(7, this.FuO.computeSize());
        this.FuO.writeFields(paramVarArgs);
      }
      if (this.Fvm != null)
      {
        paramVarArgs.lC(8, this.Fvm.computeSize());
        this.Fvm.writeFields(paramVarArgs);
      }
      if (this.FVo != null) {
        paramVarArgs.d(9, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(10, this.FVp);
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
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gbo != null) {
        paramInt = i + f.a.a.a.lB(2, this.Gbo.computeSize());
      }
      i = paramInt;
      if (this.Gbr != null) {
        i = paramInt + f.a.a.a.lB(3, this.Gbr.computeSize());
      }
      paramInt = i;
      if (this.Gbs != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gbs.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.fLb) + f.a.a.a.c(6, 8, this.FuN);
      paramInt = i;
      if (this.FuO != null) {
        paramInt = i + f.a.a.a.lB(7, this.FuO.computeSize());
      }
      i = paramInt;
      if (this.Fvm != null) {
        i = paramInt + f.a.a.a.lB(8, this.Fvm.computeSize());
      }
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FVo);
      }
      i = paramInt;
      if (this.FVp != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FVp);
      }
      AppMethodBeat.o(101800);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FuN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.Gbo == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.Gbr == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.Gbs == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.FuO == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.Fvm == null)
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
        abt localabt = (abt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101800);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabt.Gbo = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabt.Gbr = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabt.Gbs = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 5: 
          localabt.fLb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101800);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabt.FuN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabt.FuO = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabt.Fvm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 9: 
          localabt.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101800);
          return 0;
        }
        localabt.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(101800);
        return 0;
      }
      AppMethodBeat.o(101800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abt
 * JD-Core Version:    0.7.0.1
 */