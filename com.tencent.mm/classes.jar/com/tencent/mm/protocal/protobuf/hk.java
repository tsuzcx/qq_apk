package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hk
  extends cvw
{
  public int FJf;
  public SKBuiltinBuffer_t FRs;
  public ix FSd;
  public String FSe;
  public int FSf;
  public String FSg;
  public String FSh;
  public SKBuiltinBuffer_t FSi;
  public SKBuiltinBuffer_t FSj;
  public String jfY;
  public String nIN;
  public String qkM;
  public String qkN;
  public String uQx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRs == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133146);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FSd != null)
      {
        paramVarArgs.lJ(2, this.FSd.computeSize());
        this.FSd.writeFields(paramVarArgs);
      }
      if (this.FRs != null)
      {
        paramVarArgs.lJ(3, this.FRs.computeSize());
        this.FRs.writeFields(paramVarArgs);
      }
      if (this.uQx != null) {
        paramVarArgs.d(4, this.uQx);
      }
      if (this.FSe != null) {
        paramVarArgs.d(5, this.FSe);
      }
      paramVarArgs.aS(6, this.FSf);
      if (this.FSg != null) {
        paramVarArgs.d(7, this.FSg);
      }
      if (this.jfY != null) {
        paramVarArgs.d(8, this.jfY);
      }
      if (this.nIN != null) {
        paramVarArgs.d(9, this.nIN);
      }
      if (this.FSh != null) {
        paramVarArgs.d(10, this.FSh);
      }
      if (this.qkN != null) {
        paramVarArgs.d(11, this.qkN);
      }
      if (this.qkM != null) {
        paramVarArgs.d(12, this.qkM);
      }
      paramVarArgs.aS(13, this.FJf);
      if (this.FSi != null)
      {
        paramVarArgs.lJ(14, this.FSi.computeSize());
        this.FSi.writeFields(paramVarArgs);
      }
      if (this.FSj != null)
      {
        paramVarArgs.lJ(15, this.FSj.computeSize());
        this.FSj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1562;
      }
    }
    label1562:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FSd != null) {
        paramInt = i + f.a.a.a.lI(2, this.FSd.computeSize());
      }
      i = paramInt;
      if (this.FRs != null) {
        i = paramInt + f.a.a.a.lI(3, this.FRs.computeSize());
      }
      paramInt = i;
      if (this.uQx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uQx);
      }
      i = paramInt;
      if (this.FSe != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FSe);
      }
      i += f.a.a.b.b.a.bz(6, this.FSf);
      paramInt = i;
      if (this.FSg != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FSg);
      }
      i = paramInt;
      if (this.jfY != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.jfY);
      }
      paramInt = i;
      if (this.nIN != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nIN);
      }
      i = paramInt;
      if (this.FSh != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FSh);
      }
      paramInt = i;
      if (this.qkN != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.qkN);
      }
      i = paramInt;
      if (this.qkM != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.qkM);
      }
      i += f.a.a.b.b.a.bz(13, this.FJf);
      paramInt = i;
      if (this.FSi != null) {
        paramInt = i + f.a.a.a.lI(14, this.FSi.computeSize());
      }
      i = paramInt;
      if (this.FSj != null) {
        i = paramInt + f.a.a.a.lI(15, this.FSj.computeSize());
      }
      AppMethodBeat.o(133146);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FRs == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hk localhk = (hk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133146);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ix();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhk.FSd = ((ix)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhk.FRs = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 4: 
          localhk.uQx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 5: 
          localhk.FSe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 6: 
          localhk.FSf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133146);
          return 0;
        case 7: 
          localhk.FSg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 8: 
          localhk.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 9: 
          localhk.nIN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 10: 
          localhk.FSh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 11: 
          localhk.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 12: 
          localhk.qkM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 13: 
          localhk.FJf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133146);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhk.FSi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhk.FSj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      AppMethodBeat.o(133146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hk
 * JD-Core Version:    0.7.0.1
 */