package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class zt
  extends cqk
{
  public crm DPA;
  public SKBuiltinBuffer_t DPX;
  public LinkedList<bue> DPz;
  public String Eof;
  public String Eog;
  public crm EtW;
  public crm EtY;
  public crm EtZ;
  public int fsB;
  
  public zt()
  {
    AppMethodBeat.i(101799);
    this.DPz = new LinkedList();
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
      if (this.EtW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.EtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.EtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.DPA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EtW != null)
      {
        paramVarArgs.ln(2, this.EtW.computeSize());
        this.EtW.writeFields(paramVarArgs);
      }
      if (this.EtY != null)
      {
        paramVarArgs.ln(3, this.EtY.computeSize());
        this.EtY.writeFields(paramVarArgs);
      }
      if (this.EtZ != null)
      {
        paramVarArgs.ln(4, this.EtZ.computeSize());
        this.EtZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.fsB);
      paramVarArgs.e(6, 8, this.DPz);
      if (this.DPA != null)
      {
        paramVarArgs.ln(7, this.DPA.computeSize());
        this.DPA.writeFields(paramVarArgs);
      }
      if (this.DPX != null)
      {
        paramVarArgs.ln(8, this.DPX.computeSize());
        this.DPX.writeFields(paramVarArgs);
      }
      if (this.Eof != null) {
        paramVarArgs.d(9, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(10, this.Eog);
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
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EtW != null) {
        paramInt = i + f.a.a.a.lm(2, this.EtW.computeSize());
      }
      i = paramInt;
      if (this.EtY != null) {
        i = paramInt + f.a.a.a.lm(3, this.EtY.computeSize());
      }
      paramInt = i;
      if (this.EtZ != null) {
        paramInt = i + f.a.a.a.lm(4, this.EtZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.fsB) + f.a.a.a.c(6, 8, this.DPz);
      paramInt = i;
      if (this.DPA != null) {
        paramInt = i + f.a.a.a.lm(7, this.DPA.computeSize());
      }
      i = paramInt;
      if (this.DPX != null) {
        i = paramInt + f.a.a.a.lm(8, this.DPX.computeSize());
      }
      paramInt = i;
      if (this.Eof != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Eof);
      }
      i = paramInt;
      if (this.Eog != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Eog);
      }
      AppMethodBeat.o(101800);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DPz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.EtW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.EtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.EtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.DPA == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.DPX == null)
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
        zt localzt = (zt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101800);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzt.EtW = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzt.EtY = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzt.EtZ = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 5: 
          localzt.fsB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101800);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bue();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bue)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzt.DPz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzt.DPA = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzt.DPX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 9: 
          localzt.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101800);
          return 0;
        }
        localzt.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(101800);
        return 0;
      }
      AppMethodBeat.o(101800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zt
 * JD-Core Version:    0.7.0.1
 */