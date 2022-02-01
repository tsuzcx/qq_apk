package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lc
  extends ckq
{
  public SKBuiltinBuffer_t CDX;
  public String CFS;
  public String CFT;
  public String CGf;
  public int CGr;
  public String CGs;
  public String CGt;
  public String CGu;
  public int CGv;
  public cmf CGw;
  public SKBuiltinBuffer_t CGx;
  public int CGy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155396);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CGr);
      if (this.CGf != null) {
        paramVarArgs.d(3, this.CGf);
      }
      if (this.CGs != null) {
        paramVarArgs.d(4, this.CGs);
      }
      if (this.CGt != null) {
        paramVarArgs.d(5, this.CGt);
      }
      if (this.CGu != null) {
        paramVarArgs.d(6, this.CGu);
      }
      paramVarArgs.aR(7, this.CGv);
      if (this.CGw != null)
      {
        paramVarArgs.kX(8, this.CGw.computeSize());
        this.CGw.writeFields(paramVarArgs);
      }
      if (this.CGx != null)
      {
        paramVarArgs.kX(9, this.CGx.computeSize());
        this.CGx.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.CGy);
      if (this.CFS != null) {
        paramVarArgs.d(11, this.CFS);
      }
      if (this.CFT != null) {
        paramVarArgs.d(12, this.CFT);
      }
      if (this.CDX != null)
      {
        paramVarArgs.kX(13, this.CDX.computeSize());
        this.CDX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1282;
      }
    }
    label1282:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CGr);
      paramInt = i;
      if (this.CGf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CGf);
      }
      i = paramInt;
      if (this.CGs != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CGs);
      }
      paramInt = i;
      if (this.CGt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CGt);
      }
      i = paramInt;
      if (this.CGu != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CGu);
      }
      i += f.a.a.b.b.a.bA(7, this.CGv);
      paramInt = i;
      if (this.CGw != null) {
        paramInt = i + f.a.a.a.kW(8, this.CGw.computeSize());
      }
      i = paramInt;
      if (this.CGx != null) {
        i = paramInt + f.a.a.a.kW(9, this.CGx.computeSize());
      }
      i += f.a.a.b.b.a.bA(10, this.CGy);
      paramInt = i;
      if (this.CFS != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CFS);
      }
      i = paramInt;
      if (this.CFT != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.CFT);
      }
      paramInt = i;
      if (this.CDX != null) {
        paramInt = i + f.a.a.a.kW(13, this.CDX.computeSize());
      }
      AppMethodBeat.o(155396);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lc locallc = (lc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155396);
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
            locallc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 2: 
          locallc.CGr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155396);
          return 0;
        case 3: 
          locallc.CGf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 4: 
          locallc.CGs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 5: 
          locallc.CGt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 6: 
          locallc.CGu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 7: 
          locallc.CGv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155396);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallc.CGw = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallc.CGx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 10: 
          locallc.CGy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155396);
          return 0;
        case 11: 
          locallc.CFS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 12: 
          locallc.CFT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155396);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locallc.CDX = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      AppMethodBeat.o(155396);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lc
 * JD-Core Version:    0.7.0.1
 */