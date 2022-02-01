package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dlc
  extends ckq
{
  public int CLY;
  public int CNt;
  public int EAM;
  public LinkedList<cmf> EAN;
  public int EAO;
  public cmf EfP;
  public String ExD;
  public int ExF;
  public int Scene;
  public int hno;
  public SKBuiltinBuffer_t uKT;
  
  public dlc()
  {
    AppMethodBeat.i(148668);
    this.EAN = new LinkedList();
    AppMethodBeat.o(148668);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148669);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148669);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uKT != null)
      {
        paramVarArgs.kX(2, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.CNt);
      if (this.ExD != null) {
        paramVarArgs.d(4, this.ExD);
      }
      paramVarArgs.aR(5, this.hno);
      paramVarArgs.aR(6, this.ExF);
      paramVarArgs.aR(7, this.CLY);
      paramVarArgs.aR(8, this.EAM);
      paramVarArgs.e(9, 8, this.EAN);
      if (this.EfP != null)
      {
        paramVarArgs.kX(10, this.EfP.computeSize());
        this.EfP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.EAO);
      paramVarArgs.aR(12, this.Scene);
      AppMethodBeat.o(148669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1182;
      }
    }
    label1182:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uKT != null) {
        i = paramInt + f.a.a.a.kW(2, this.uKT.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.CNt);
      paramInt = i;
      if (this.ExD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ExD);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.hno) + f.a.a.b.b.a.bA(6, this.ExF) + f.a.a.b.b.a.bA(7, this.CLY) + f.a.a.b.b.a.bA(8, this.EAM) + f.a.a.a.c(9, 8, this.EAN);
      paramInt = i;
      if (this.EfP != null) {
        paramInt = i + f.a.a.a.kW(10, this.EfP.computeSize());
      }
      i = f.a.a.b.b.a.bA(11, this.EAO);
      int j = f.a.a.b.b.a.bA(12, this.Scene);
      AppMethodBeat.o(148669);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EAN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.uKT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148669);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148669);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlc localdlc = (dlc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148669);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlc.uKT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 3: 
          localdlc.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148669);
          return 0;
        case 4: 
          localdlc.ExD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148669);
          return 0;
        case 5: 
          localdlc.hno = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148669);
          return 0;
        case 6: 
          localdlc.ExF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148669);
          return 0;
        case 7: 
          localdlc.CLY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148669);
          return 0;
        case 8: 
          localdlc.EAM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148669);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlc.EAN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlc.EfP = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 11: 
          localdlc.EAO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148669);
          return 0;
        }
        localdlc.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148669);
        return 0;
      }
      AppMethodBeat.o(148669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlc
 * JD-Core Version:    0.7.0.1
 */