package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azw
  extends cqk
{
  public int ENU;
  public rm ENW;
  public String ENX;
  public int ENY;
  public int ENZ;
  public rv EOa;
  public rm EQU;
  public String EQV;
  public String EQW;
  public LinkedList<ra> Ejf;
  public int nWx;
  public String nWy;
  public int oGs;
  
  public azw()
  {
    AppMethodBeat.i(206454);
    this.Ejf = new LinkedList();
    AppMethodBeat.o(206454);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(206455);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      paramVarArgs.aR(4, this.oGs);
      paramVarArgs.aR(5, this.ENU);
      paramVarArgs.e(6, 8, this.Ejf);
      if (this.EOa != null)
      {
        paramVarArgs.ln(7, this.EOa.computeSize());
        this.EOa.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.ENY);
      paramVarArgs.aR(9, this.ENZ);
      if (this.ENW != null)
      {
        paramVarArgs.ln(10, this.ENW.computeSize());
        this.ENW.writeFields(paramVarArgs);
      }
      if (this.ENX != null) {
        paramVarArgs.d(11, this.ENX);
      }
      if (this.EQU != null)
      {
        paramVarArgs.ln(12, this.EQU.computeSize());
        this.EQU.writeFields(paramVarArgs);
      }
      if (this.EQV != null) {
        paramVarArgs.d(13, this.EQV);
      }
      if (this.EQW != null) {
        paramVarArgs.d(14, this.EQW);
      }
      AppMethodBeat.o(206455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1434;
      }
    }
    label1434:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.oGs) + f.a.a.b.b.a.bx(5, this.ENU) + f.a.a.a.c(6, 8, this.Ejf);
      paramInt = i;
      if (this.EOa != null) {
        paramInt = i + f.a.a.a.lm(7, this.EOa.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.ENY) + f.a.a.b.b.a.bx(9, this.ENZ);
      paramInt = i;
      if (this.ENW != null) {
        paramInt = i + f.a.a.a.lm(10, this.ENW.computeSize());
      }
      i = paramInt;
      if (this.ENX != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ENX);
      }
      paramInt = i;
      if (this.EQU != null) {
        paramInt = i + f.a.a.a.lm(12, this.EQU.computeSize());
      }
      i = paramInt;
      if (this.EQV != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.EQV);
      }
      paramInt = i;
      if (this.EQW != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.EQW);
      }
      AppMethodBeat.o(206455);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ejf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(206455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(206455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azw localazw = (azw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206455);
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
            localazw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206455);
          return 0;
        case 2: 
          localazw.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206455);
          return 0;
        case 3: 
          localazw.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206455);
          return 0;
        case 4: 
          localazw.oGs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206455);
          return 0;
        case 5: 
          localazw.ENU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206455);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ra();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazw.Ejf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206455);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazw.EOa = ((rv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206455);
          return 0;
        case 8: 
          localazw.ENY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206455);
          return 0;
        case 9: 
          localazw.ENZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206455);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazw.ENW = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206455);
          return 0;
        case 11: 
          localazw.ENX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206455);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazw.EQU = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206455);
          return 0;
        case 13: 
          localazw.EQV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206455);
          return 0;
        }
        localazw.EQW = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(206455);
        return 0;
      }
      AppMethodBeat.o(206455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azw
 * JD-Core Version:    0.7.0.1
 */