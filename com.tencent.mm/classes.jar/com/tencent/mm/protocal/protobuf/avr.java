package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avr
  extends cqk
{
  public SKBuiltinBuffer_t DUt;
  public int DVc;
  public LinkedList<za> DVd;
  public String DVe;
  public String DVf;
  public String DVg;
  public int DVk;
  public String DVl;
  public String DVm;
  public String ENI;
  public String ID;
  public int Scene;
  public int ndI;
  public long ndf;
  
  public avr()
  {
    AppMethodBeat.i(32227);
    this.DVd = new LinkedList();
    AppMethodBeat.o(32227);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32228);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.DUt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ID != null) {
        paramVarArgs.d(2, this.ID);
      }
      if (this.DUt != null)
      {
        paramVarArgs.ln(3, this.DUt.computeSize());
        this.DUt.writeFields(paramVarArgs);
      }
      if (this.DVl != null) {
        paramVarArgs.d(4, this.DVl);
      }
      if (this.DVm != null) {
        paramVarArgs.d(5, this.DVm);
      }
      paramVarArgs.aR(6, this.ndI);
      paramVarArgs.aR(7, this.DVc);
      paramVarArgs.e(8, 8, this.DVd);
      if (this.ENI != null) {
        paramVarArgs.d(9, this.ENI);
      }
      if (this.DVe != null) {
        paramVarArgs.d(10, this.DVe);
      }
      if (this.DVf != null) {
        paramVarArgs.d(11, this.DVf);
      }
      paramVarArgs.aR(12, this.DVk);
      paramVarArgs.aR(13, this.Scene);
      paramVarArgs.aO(14, this.ndf);
      if (this.DVg != null) {
        paramVarArgs.d(15, this.DVg);
      }
      AppMethodBeat.o(32228);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1379;
      }
    }
    label1379:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ID);
      }
      i = paramInt;
      if (this.DUt != null) {
        i = paramInt + f.a.a.a.lm(3, this.DUt.computeSize());
      }
      paramInt = i;
      if (this.DVl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DVl);
      }
      i = paramInt;
      if (this.DVm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DVm);
      }
      i = i + f.a.a.b.b.a.bx(6, this.ndI) + f.a.a.b.b.a.bx(7, this.DVc) + f.a.a.a.c(8, 8, this.DVd);
      paramInt = i;
      if (this.ENI != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ENI);
      }
      i = paramInt;
      if (this.DVe != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DVe);
      }
      paramInt = i;
      if (this.DVf != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DVf);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.DVk) + f.a.a.b.b.a.bx(13, this.Scene) + f.a.a.b.b.a.p(14, this.ndf);
      paramInt = i;
      if (this.DVg != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DVg);
      }
      AppMethodBeat.o(32228);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DVd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        if (this.DUt == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32228);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avr localavr = (avr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32228);
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
            localavr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 2: 
          localavr.ID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavr.DUt = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 4: 
          localavr.DVl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 5: 
          localavr.DVm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 6: 
          localavr.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32228);
          return 0;
        case 7: 
          localavr.DVc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32228);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new za();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((za)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavr.DVd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 9: 
          localavr.ENI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 10: 
          localavr.DVe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 11: 
          localavr.DVf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 12: 
          localavr.DVk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32228);
          return 0;
        case 13: 
          localavr.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32228);
          return 0;
        case 14: 
          localavr.ndf = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32228);
          return 0;
        }
        localavr.DVg = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32228);
        return 0;
      }
      AppMethodBeat.o(32228);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avr
 * JD-Core Version:    0.7.0.1
 */